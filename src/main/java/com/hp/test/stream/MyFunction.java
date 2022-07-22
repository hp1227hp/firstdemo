package com.hp.test.stream;

public interface MyFunction<T, R> {
    R getValue(T t);
}
