package com.samsolutions.traceable.stub;

import java.util.Random;

/**
 * Created by dima on 05.02.2017.
 */
public class TraceableImplStub3 implements Traceable<String> {

    private final static int MAX_VALUE_SLEEP = 1000;

    static Random randomGenerator = new Random();

    public void doBusinessLogic(String string) {
        long delay = sleep();
        System.out.println("TraceableImplStub3 doBusinessLogic" + " with argument " + string + " sleeps " + delay);
    }

    public String calculateBusinessValue() {
        long delay = sleep();
        System.out.println("TraceableImplStub3 calculateBusinessValue sleeps " + delay);
        return "abc";
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