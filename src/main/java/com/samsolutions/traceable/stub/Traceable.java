package com.samsolutions.traceable.stub;

public interface Traceable<T> {

    public void doBusinessLogic(T t);

    public T calculateBusinessValue();

}
