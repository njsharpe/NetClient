package net.njsharpe.netclient.http;

import net.njsharpe.netclient.annotation.Member;
import net.njsharpe.netclient.annotation.Route;
import net.njsharpe.netclient.util.Strings;
import net.njsharpe.netclient.util.Types;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.*;

public class Query {

    private final Map<String, String> path = new HashMap<>();
    private final Map<String, String> query = new HashMap<>();

    public static <T extends Response> Query parse(Class<T> type, T instance) {
        Query query = new Query();

        for(Field field : type.getDeclaredFields()) {
            if(!field.isAnnotationPresent(Member.class)) {
                continue;
            }

            Member member = field.getAnnotation(Member.class);
            field.setAccessible(true);

            try {
                Class<?> fieldType = field.getType();

                String name = field.getName();
                Object value = field.get(instance);

                if(member.required() && value == null) {
                    throw new IllegalStateException("Field %s set to required but no value was passed!".formatted(name));
                }

                // We need the raw value for this to work properly
                if(Types.nullOrDefault(fieldType, value)) {
                    continue;
                }

                (member.parameter() == Parameter.PATH ? query.path : query.query)
                        .put(name, Strings.asString(fieldType, value));
            } catch (Exception ex) {
                throw new RuntimeException("An unexpected error has occurred!", ex);
            }
        }

        return query;
    }

    public String getQueryString() {
        if(this.query.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder("?");

        Iterator<Map.Entry<String, String>> it = this.query.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if(it.hasNext()) {
                sb.append("&");
            }
        }

        return sb.toString();
    }

    public <T extends Response> String getPathString(Class<T> type) {
        String template = type.getAnnotation(Route.class).uri();
        return Strings.placeholder(template, this.path);
    }

    public <T extends Response> URI getUri(Class<T> type) {
        return URI.create(this.getPathString(type) + this.getQueryString());
    }

}
