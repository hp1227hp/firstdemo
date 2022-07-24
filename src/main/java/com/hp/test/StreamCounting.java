package com.hp.test;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCounting {

    // 将字符串转换为Stream<Character>，再通过flatMap转换为一个大的Stream<Character>，进行分组
    static Stream<Character> toCharacter(String str) {
        final char[] chars = str.toCharArray();
        final ArrayList<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            if (aChar == ' ') {
                continue;
            }
            list.add(aChar);
        }
        return list.stream();
    }

    public static void main(String[] args) {

        Stream.of("Hello world", "I am tom", "how are you!")
                .flatMap(x -> toCharacter(x)).collect(Collectors.groupingBy(Character::charValue, Collectors.counting())).forEach((x, y) -> {
            System.out.println(x + "的个数：" + y);
        });

        List<String> list = new ArrayList<>();
        list.add("Holle world and you world");
        list.add("TT yy xx zz");
        /*

        // flatMap方法
        list.stream().flatMap(t -> Stream.of(t.split("\\s+"))).
                map(t -> t.toLowerCase()).
                forEach(System.out::println);
        // 结果为：Holle
        //		  world
        //		  and
        //		  you
        //		  world

        // Map方法
        list.stream().map(t -> Stream.of(t.split("\\s+"))).
                forEach(s -> {
                    s.forEach(System.out::println);
                    System.out.println("-------------------");
                });
        // 而Map方法最后的结果为一个地址，并没有对数组里面的结果进行细分最后的结果依旧为一个整体
        */

    }

}
