package com.hp.test;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        String s = "AAAABBBFFEEFFIO";
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String t = "" + c;
            if (countMap.containsKey(t)) {
                countMap.put(t, ((Integer) countMap.get(t) + 1));
            } else {
                countMap.put(t, 1);
            }
        }
        System.out.println("----------------");
        // map的value做排序
        // 将entry放到List里
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(countMap.entrySet());
        // 对List排序
        list.sort((o1, o2) -> {
            Integer v1 = o1.getValue();
            Integer v2 = o2.getValue();
            if (v1.intValue() > v2.intValue()) {
                return 1;
            } else if (v1.intValue() == v2.intValue()) {
                return 0;
            } else {
                return -1;
            }
        });
        // 上一步，按照map的value已经做了排序了，现在组装Map
        Map<String, Integer> finalMap = new LinkedHashMap<>();
        list.stream().forEach(o -> {
            finalMap.put(o.getKey(), o.getValue());
        });
        System.out.println(finalMap);

    }

}
