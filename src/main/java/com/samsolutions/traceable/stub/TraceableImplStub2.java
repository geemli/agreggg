package com.samsolutions.traceable.stub;

import java.util.Random;

/**
 * Created by dima on 05.02.2017.
 */
public class TraceableImplStub2 implements Traceable<Double> {

    private final static int MAX_VALUE_SLEEP = 1000;

    static Random randomGenerator = new Random();

    public void doBusinessLogic(Double number) {
        long delay = sleep();
        System.out.println("TraceableImplStub2 doBusinessLogic" + " with argument " + number + " sleeps " + delay);
    }

    public Double calculateBusinessValue() {
        long delay = sleep();
        System.out.println("TraceableImplStub2 calculateBusinessValue sleeps " + delay);
        return 10.;
    }

    private long sleep() {
        long lat = randomGenerator.nextInt(MAX_VALUE_SLEEP);
        try {
            Thread.sleep(lat);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lat;
    }
}