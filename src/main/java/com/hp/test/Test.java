package com.hp.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        xxx();
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

    public static void xxx() {
        int[] a = {5,4,3,8,2};
        int[] b = new int[]{89,34,12,900};
        int[] c = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        Integer[] integers = Arrays.stream(c).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(integers));

    }

}
