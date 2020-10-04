package com.wisdom08;

import java.lang.reflect.Type;
import java.util.HashMap;

public class TypeMap extends HashMap<String, Object> {

    public static TypeMap success(Object... args) {
        return with(true, args);
    }

    public static Object fail(Object... args) {
        return with(false, args);
    }

    public static TypeMap with(boolean result, Object... args) {

        TypeMap map = TypeMap.with(args);

        map.put("success", result);
        return map;
    }

    public static TypeMap with(Object... args) {
        if (args.length % 2 == 1) {
            throw new RuntimeException("짝수개가 아님");
        }

        TypeMap map = new TypeMap();

        for (int i = 0; i < args.length; i += 2) {
            String key = (String) args[i];
            Object value = args[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
