package com.example.rxjava.network.subscribers;


public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}
