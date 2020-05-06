package com.jiang.base.rxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RxjavaTest {


    public static void main(String[] args) {
        ExecutorService executors = Executors.newCachedThreadPool();
        Observable.create("Hello")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        System.out.println(Thread.currentThread().getName());
                        return s + " Rxjava";
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        System.out.println(Thread.currentThread().getName());
                        return s + " a ha ";
                    }
                })
                .subscribeOn(executors)
                // 在安卓中用Handler切换线程回来，这里假装一下
//                .observeOn(Thread.currentThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe() {
                        System.out.println(Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext: " + Thread.currentThread().getName());
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
