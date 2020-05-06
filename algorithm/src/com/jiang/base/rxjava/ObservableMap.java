package com.jiang.base.rxjava;

public class ObservableMap<T,R> extends Observable<T> {

    private Function<T,R> mapper;
    private Observable<T> observable;
    public ObservableMap(Observable<T> source, Function<T,R> mapper) {
        this.observable = source;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Observer observer) {
        observable.subscribe(new ObserverMap<T,R>(observer,mapper));
    }

    static final class ObserverMap<T,R> implements Observer<T>{
        private Observer<R> observer;
        private Function<T,R> mapper;

        public ObserverMap(Observer<R> observer, Function<T, R> mapper) {
            this.observer = observer;
            this.mapper = mapper;
        }

        @Override
        public void onSubscribe() {
        }

        @Override
        public void onNext(T t) {
            observer.onNext(mapper.apply(t));
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
