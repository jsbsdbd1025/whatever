package com.jiang.base.rxjava;

public class ObservableSourceImp<T> extends Observable<T> {

    protected T source;

    public ObservableSourceImp(T source) {
        this.source = source;
    }

    @Override
    public void subscribe(Observer observer) {
        observer.onNext(source);
    }
}
