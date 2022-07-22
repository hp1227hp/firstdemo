package com.hp.test.stream.grouping;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    //年级
    private String grade;
    //班级
    private String classNumber;
    //姓名
    private String name;
    //年龄
    private int age;
    //地址
    private String address;
    //数学成绩
    private int mathScores;
    //语文成绩
    private int chainessScores;

    public Student(String classNumber, String name, int age, String address, int mathScores, int chainessScores) {
        this.classNumber = classNumber;
        this.name = name;
        this.age = age;
        this.address = address;
        this.mathScores = mathScores;
        this.chainessScores = chainessScores;
    }

}
