package net.njsharpe.netclient.util;

import com.google.gson.annotations.SerializedName;
import net.njsharpe.netclient.exception.ApiException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

    public static String asString(Class<?> type, Object value) {
        if(value == null) {
            return null;
        }
        if(type.isPrimitive()) {
            return String.valueOf(value);
        }
        if(type.isEnum()) {
            String name = String.valueOf(value);
            try {
                Field field = type.getDeclaredField(name);
                field.setAccessible(true);
                return field.isAnnotationPresent(SerializedName.class)
                        ? field.getAnnotation(SerializedName.class).value()
                        : name;
            } catch (Exception ex) {
                throw new ApiException("Could not find field '%s' for enum type '%s'."
                        .formatted(name, type.getSimpleName()));
            }
        }
        if(type.isArray()) {
            Class<?> component = type.getComponentType();
            StringBuilder sb = new StringBuilder();
            int length = Array.getLength(value);
            for(int i = 0; i < length; i++) {
                Object element = Array.get(value, i);
                sb.append(Strings.asString(component, element));
                if(i + 1 < length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        return value.toString();
    }

    public static String placeholder(String template, Map<String, String> parameters) {
        StringBuilder sb = new StringBuilder(template);
        List<String> values = new ArrayList<>();

        Matcher matcher = Pattern.compile("[{](\\w+)}").matcher(template);

        while (matcher.find()) {
            String key = matcher.group(1);

            String paramName = "{" + key + "}";
            int index = sb.indexOf(paramName);
            if (index != -1) {
                sb.replace(index, index + paramName.length(), "%s");
                values.add(parameters.get(key));
            }
        }

        return String.format(sb.toString(), values.toArray());
    }

}