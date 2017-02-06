package com.samsolutions.traceable.stub;

import java.util.Random;

public class TraceableImplStub implements Traceable<Integer> {

    private final static int MAX_VALUE_SLEEP = 1000;

    static Random randomGenerator = new Random();

    public void doBusinessLogic(Integer integer) {
        long delay = sleep();
        System.out.println("TraceableImplStub doBusinessLogic" + " with argument " + integer + " sleeps " + delay);
    }

    public Integer calculateBusinessValue() {
        long delay = sleep();
        System.out.println("TraceableImplStub calculateBusinessValue sleeps " + delay);
        return 10;
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