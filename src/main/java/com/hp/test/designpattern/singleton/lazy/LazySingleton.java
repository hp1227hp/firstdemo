package com.hp.test.designpattern.singleton.lazy;

public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {

    }

    /**
     * 懒汉模式
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
    }

}
