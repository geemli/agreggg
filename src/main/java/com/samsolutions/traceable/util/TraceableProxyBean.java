package com.samsolutions.traceable.util;

import com.samsolutions.traceable.stub.Traceable;

/**
 * Created by dznor on 06.02.2017.
 */
public class TraceableProxyBean implements Traceable {

    private Traceable original;
    private Statistic statistic;

    public TraceableProxyBean(Traceable o, Statistic statistic) {
        this.original = o;
        this.statistic = statistic;
    }

    @Override
    public void doBusinessLogic(Object o) {
        long startTime = System.nanoTime();
        original.doBusinessLogic(o);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        statistic.addValue(duration, original.getClass().toString());
    }

    @Override
    public Object calculateBusinessValue() {
        long startTime = System.nanoTime();
        original.calculateBusinessValue();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        statistic.addValue(duration, original.getClass().toString());
        return null;
    }
}
