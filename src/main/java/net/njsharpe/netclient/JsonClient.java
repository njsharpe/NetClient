package net.njsharpe.netclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.http.*;
import net.njsharpe.netclient.exception.ApiException;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class JsonClient implements Client {

    private final HttpClient client;
    private final URI baseAddress;
    private final Gson gson;
    private final String bearerToken;

    private boolean alwaysReturnBody;

    public JsonClient(String baseUri) {
        this(baseUri, null);
    }

    public JsonClient(String baseUri, String bearerToken) {
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(60))
                .cookieHandler(new CookieManager())
                .build();
        this.baseAddress = URI.create(baseUri);
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.bearerToken = bearerToken;
    }

    @Override
    public URI getBaseAddress() {
        return this.baseAddress;
    }

    public JsonClient alwaysReturnBody() {
        this.alwaysReturnBody = true;
        return this;
    }

    @Override
    public <U, T extends Returns<U>> U send(Class<T> clazz, T request) {
        try {
            Route route = this.validateRequestOptions(clazz);
            URI absoluteUri = this.baseAddress.resolve(Query.parse(clazz, request).getUri(clazz));

            HttpRequest req = this.createHttpRequest(route.verb(), absoluteUri, this.bearerToken);
            HttpResponse<String> response = this.client.send(req, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            if(this.shouldReturnBody(statusCode)) {
                return this.gson.fromJson(response.body(), request.getType());
            }

            throw new ApiException("(%d) There was a problem with your request, please try again!".formatted(response.statusCode()));
        } catch (IOException | InterruptedException ex) {
            throw new ApiException("An unexpected error has occurred.", ex);
        }
    }

    @Override
    public <T extends ReturnsVoid> void send(Class<T> clazz, T request) {
        try {
            Route route = this.validateRequestOptions(clazz);
            URI absoluteUri = this.baseAddress.resolve(Query.parse(clazz, request).getUri(clazz));

            HttpRequest req = this.createHttpRequest(route.verb(), absoluteUri, this.bearerToken);
            HttpResponse<Void> response = this.client.send(req, HttpResponse.BodyHandlers.discarding());

            int statusCode = response.statusCode();
            if(this.shouldReturnBody(statusCode)) {
                return;
            }

            throw new ApiException("(%d) There was a problem with your request, please try again!".formatted(response.statusCode()));
        } catch (IOException | InterruptedException ex) {
            throw new ApiException("An unexpected error has occurred.", ex);
        }
    }

    private <T> Route validateRequestOptions(Class<T> clazz) throws ApiException {
        if(!clazz.isAnnotationPresent(Route.class)) {
            throw new ApiException("Specified request does not have any associated route information!");
        }
        return clazz.getAnnotation(Route.class);
    }

    private boolean shouldReturnBody(int statusCode) {
        return (statusCode >= 200 && statusCode <= 300) || this.alwaysReturnBody;
    }

    private HttpRequest createHttpRequest(Verb httpMethod, URI absoluteUri, String bearerToken) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(absoluteUri)
                .timeout(Duration.ofSeconds(60))
                .header("Content-Type", "application/json")
                .method(httpMethod.name(), HttpRequest.BodyPublishers.noBody());

        if(bearerToken != null) {
            builder.header("Authorization", "Bearer %s".formatted(bearerToken));
        }

        return builder.build();
    }

}
