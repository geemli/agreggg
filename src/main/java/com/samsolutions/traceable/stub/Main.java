package com.samsolutions.traceable.stub;

import com.samsolutions.traceable.stub.config.TraceableConfig;
import com.samsolutions.traceable.util.Statistic;
import com.samsolutions.traceable.util.config.UtilConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TraceableConfig.class);
        context.register(UtilConfig.class);
        context.refresh();

        Traceable obj = (Traceable) context.getBean("traceableImplStub");
        Traceable obj2 = (Traceable) context.getBean("traceableImplStub2");
        Traceable obj3 = (Traceable) context.getBean("traceableImplStub3");
        Statistic statistic = (Statistic) context.getBean("statistic");

        obj.calculateBusinessValue();
        obj2.calculateBusinessValue();
        obj3.calculateBusinessValue();
        obj.doBusinessLogic(1);
        obj2.doBusinessLogic(1.);
        obj3.doBusinessLogic("abc");

//        statistic.show3LongestOperations();
    }
}
