package com.jiang.base.rxjava;

import java.util.concurrent.ExecutorService;

/**
 * 被观察者抽象类
 *
 * @param <T>
 */
public abstract class Observable<T> implements ObservableSource<T> {

    private ExecutorService mExecutorService;
    private Thread mMainThread;



    public static <T> Observable<T> create(T t) {
        return new ObservableSourceImp<T>(t);
    }

//    return RxJavaPlugins.onAssembly(new ObservableMap<T, R>(this, mapper));
    public <R> ObservableMap<T, R> map(Function<T, R> mapper) {

        return new ObservableMap<T,R>(this,mapper);
//        return create(function.apply(source));
    }

    @Override
    public void subscribe(Observer<T> observer) {

        this.subscribe(observer);
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                observer.onSubscribe();
//            }
//        };
//        // doSomeThing
//        mExecutorService.execute(task);

    }

    public Observable<T> subscribeOn(ExecutorService executors) {
        if (executors != null) {
            this.mExecutorService = executors;
        }
        return this;
    }

    public ObservableSource<T> observeOn(Thread currentThread) {
        if (currentThread != null) {
            this.mMainThread = currentThread;
        }
        return this;
    }
}
