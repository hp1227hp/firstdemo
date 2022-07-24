package com.hp.test.stream;

@FunctionalInterface
public interface MyPredicate<T> {

    /**
     * 对传递过来的T类型的数据进行过滤
     * 符合规则返回true，不符合规则返回false
     */
    boolean filter(T t);

    default void test() {
        System.out.println("11111111111111111");
    }
}
