package com.hp.test.designpattern.singleton.prototype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.*;

@Data
@Accessors(chain = true)
public class User implements Cloneable, Serializable {
    private Integer id;
    private Integer age;
    private String name;
    private Car car;
    private String category;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    /**
     * 方法一：最原始的实现方式，通过构造方法手创建
     * 优点：
     * 1.实现简单直观
     * 2.不需要依赖额外的接口和第三方包
     * 缺点：
     * 1.成员变量发生变动需要修改方法，不满足开闭原则；
     * 2.不具有可复用性；
     */
    public User copyUser1() {
        User copyUser = new User()
                .setId(this.getId())
                .setName(this.getName())
                .setAge(this.getAge())
                .setCategory(this.getCategory());
        if (this.getCar() != null) {
            copyUser.setCar(new Car().setId(this.getCar().getId())
                    .setColor(this.getCar().getColor())
                    .setName(this.getCar().getName()));
        }
        return copyUser;
    }

    /**
     * 方法二：使用Object的clone方法实现
     * 优点：
     * 1.较方式1实现更简单，不需要关注copy细节；
     * 2.不需要依赖第三方包；
     * 3.不修改引用类型成员变量不需要修改代码
     * 缺点：
     * 1.需要实现Cloneable，重写父类clone方法，不满足里式替换；
     * 2.且引用类型成员变量发生变动需要修改方法，不满足开闭原则；
     * 3.不具有可复用性；
     */
    public User copyUser2() throws CloneNotSupportedException {
        User cloneUser = (User) this.clone();
        if (this.getCar() != null) {
            cloneUser.setCar(this.getCar().clone());
        }
        return cloneUser;
    }

    /**
     * 方法三：使用Java自带的流方式实现
     * 优点：
     * 1.不破坏类的封装，无需了解被copy对象的内部
     * 2.不需要依赖第三方包
     * 3.代码可复用
     * 缺点：
     * 1.需要实现Serializable接口，会有额外的开销
     */
    public User copyUser3() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (User) ois.readObject();
    }

    /**
     * 方法四：使用第三方包Jackson实现
     * 优点：
     * 1.不破坏类的封装，无需了解被copy对象的内部
     * 2.不需要实现接口
     * 3.代码可复用
     * 缺点：
     * 1.需要依赖第三方包
     * 2.内部实现复杂
     */
    public User copyUser4() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(objectMapper.writeValueAsString(this), User.class);
    }

    //
    // 使用java原生推荐方法三，
    // 方法一、方法二缺点过于明显，第三方库的方式可以用方法四，
    // spring boot默认的序列化反序列化就是Jackson，另外比照方法四同类的类库也能实现
}
