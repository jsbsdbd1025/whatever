package com.jiang.base.rxjava;

/**
 * 被观察者接口
 * @param <T>
 */
public interface ObservableSource<T> {

    void subscribe(Observer<T> observer);

}
