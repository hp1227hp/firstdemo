package com.hp.test.stream.grouping;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Student student1 = new Student("701", "张三", 16, "北京", 78, 90);
        Student student2 = new Student("700", "李四", 17, "北京", 78, 90);
        Student student3 = new Student("703", "王五", 16, "上海", 78, 90);
        Student student4 = new Student("701", "赵六", 16, "上海", 78, 90);
        Student student5 = new Student("700", "钱七", 18, "", 78, 90);
        Student student6 = new Student("701", "老八", 17, "", 78, 90);

        Stream<Student> studentStream = Stream.of(student1, student2, student3, student4, student5, student6);
        List<Student> studentList = studentStream.collect(Collectors.toList());
        // 按照班级分组
        Map<String, List<Student>> classMap = studentList.stream().collect(Collectors.groupingBy(Student::getClassNumber));
        System.out.println(classMap);

        // 按照班级分组得到每个班级的同学姓名
        System.out.println("-----------------------------------------");
        Map<String, List<String>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getClassNumber, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(JSON.toJSONString(collect));
        // {"700":["李四","钱七"],"701":["张三","赵六","老八"],"703":["王五"]}

        System.out.println("-----------------------------------------");
        // 统计每个班级人数
        Map<String, Long> collect2 = studentList.stream().collect(Collectors.groupingBy(Student::getClassNumber, Collectors.counting()));
        System.out.println(JSON.toJSONString(collect2));
        //{"700":2,"701":3,"703":1}

        // 求每个班级的数学平均成绩
        System.out.println("-----------------------------------------");
        Map<String, Double> collect3 = studentList.stream().collect(Collectors.groupingBy(Student::getClassNumber, Collectors.averagingDouble(Student::getMathScores)));
        System.out.println(JSON.toJSONString(collect3));
        // {"700":65.0,"701":61.0,"703":82.0}

        // 按班级分组求每个同学的总成绩
        System.out.println("-----------------------------------------");
        Map<String, Map<String, Integer>> collect4 = studentList.stream().collect(Collectors.groupingBy(Student::getClassNumber, Collectors.toMap(Student::getName, student -> student.getMathScores() + student.getChainessScores())));
        System.out.println(JSON.toJSONString(collect4));
        // {"700":{"钱七":150,"李四":160},"701":{"张三":168,"老八":148,"赵六":137},"703":{"王五":172}}

        // 嵌套分组，先按班级分组，再按年龄分组
        Map<String, Map<Integer, List<Student>>> collect5 = studentList.stream().collect(Collectors.groupingBy(Student::getClassNumber, Collectors.groupingBy(Student::getAge)));

        // 分组后得到一个线程安全的ConcurrentMap
        ConcurrentMap<String, List<Student>> collect6 = studentList.stream().collect(Collectors.groupingByConcurrent(Student::getClassNumber));

        // 根据年龄分组并小到大排序,TreeMap默认为按照key升序
        TreeMap<Integer, List<String>> collect7 = studentList.stream().collect(Collectors.groupingBy(Student::getAge, TreeMap::new, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(JSON.toJSONString(collect7));
        //{16:["张三","王五","赵六"],17:["李四","老八"],18:["钱七"]}

        // 根据年龄分组并大到小排序,因为TreeMap默认为按照key升序，所以排完顺序再反转一下就OK了
        TreeMap<Integer, List<String>> collect8 = studentList.stream().collect(Collectors.groupingBy(Student::getAge, TreeMap::new, Collectors.mapping(Student::getName, Collectors.toList())));
        Map<Integer, List<String>> collect9 = collect8.descendingMap();
        System.out.println(JSON.toJSONString(collect9));
        //{18:["钱七"],17:["李四","老八"],16:["张三","王五","赵六"]}


    }

}
