package com.pupu.stability.common.utils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public MapUtils putMap(Map<String,Object> params) {
        super.putAll(params);
        return this;
    }

    public static <K, V> HashMap<K, V> build(K key, V value) {
        HashMap<K, V> map = Maps.newHashMap();
        map.put(key, value);
        return map;
    }

    public static <K, V> HashMap<K, V> build(Function<ImmutableMap.Builder<K, V>, ImmutableMap.Builder<K, V>> function) {
        ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
        function.apply(builder);
        return Maps.newHashMap(builder.build());
    }

    public static Object[][] getMapKeyValue(Map map) {
        Object[][] object = null;
        if ((map != null) && (!map.isEmpty())) {
            int size = map.size();
            object = new Object[size][2];
            Iterator iterator = map.entrySet().iterator();
            for (int i = 0; i < size; i++) {
                Entry entry = (Entry) iterator.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                object[i][0] = key;
                object[i][1] = value;
            }
        }
        return object;
    }
}