package com.jiang.base.rxjava;

public interface Function<T,R> {

    // 传进来是个被观察者，本身是观察者，输出被观察者
    R apply(T t);
}
