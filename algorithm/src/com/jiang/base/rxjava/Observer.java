package com.jiang.base.rxjava;

/**
 * 观察者接口类
 * @param <T>
 */
public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}
