package net.njsharpe.netclient.util;

import java.lang.reflect.Array;

public class Types {

    public static boolean nullOrDefault(Class<?> type, Object value) {
        return value == null || value.equals(Array.get(Array.newInstance(type, 1), 0));
    }

}