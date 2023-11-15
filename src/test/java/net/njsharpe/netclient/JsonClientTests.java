package net.njsharpe.netclient;

import net.njsharpe.netclient.dto.MockHttpResponse;
import net.njsharpe.netclient.exception.ApiException;
import net.njsharpe.netclient.route.GetHttpInternalServerError;
import net.njsharpe.netclient.route.GetHttpNotFound;
import net.njsharpe.netclient.route.GetHttpOk;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonClientTests {

    private final JsonClient client = new JsonClient("https://dummyjson.com");

    @Test
    public void testGetHttpOk() {
        GetHttpOk request = new GetHttpOk();
        Assertions.assertDoesNotThrow(() ->
                this.client.send(GetHttpOk.class, request));
    }

    @Test
    public void testGetHttpNotFound() {
        GetHttpNotFound request = new GetHttpNotFound();
        ApiException ex = Assertions.assertThrows(ApiException.class, () ->
                this.client.send(GetHttpNotFound.class, request));
        Assertions.assertEquals("(404) There was a problem with your request, please try again!", ex.getMessage());
    }

    @Test
    public void testGetInternalServerError() {
        GetHttpInternalServerError request = new GetHttpInternalServerError();
        ApiException ex = Assertions.assertThrows(ApiException.class, () ->
                this.client.send(GetHttpInternalServerError.class, request));
        Assertions.assertEquals("(500) There was a problem with your request, please try again!", ex.getMessage());
    }

    @Test
    public void testGetInternalServerErrorWithErrorMessage() {
        GetHttpInternalServerError request = new GetHttpInternalServerError();
        MockHttpResponse response = this.client.alwaysReturnBody()
                .send(GetHttpInternalServerError.class, request);
        Assertions.assertEquals(500, response.getStatus());
        Assertions.assertEquals("xP", response.getDetail());
    }

}
