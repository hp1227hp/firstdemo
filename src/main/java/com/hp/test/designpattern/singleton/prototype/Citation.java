package com.hp.test.designpattern.singleton.prototype;

/**
 * Object的clone方法，浅度复制
 */
public class Citation implements Cloneable {

    private String name;

    private String info;

    private String college;

    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("奖状拷贝成功！");
        return (Citation) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Citation c1 = new Citation("张三", "黑马", "长安大学");
        Citation c2 = (Citation) c1.clone();
        System.out.println(c1 == c2);
        System.out.println(c1.name.equals(c2.name));
    }
}
