package com.samsolutions.traceable.util;

import com.google.gson.Gson;

import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by dima on 06.02.2017.
 */
public class Statistic {

    private final static int MAX_COUNT_OF_SHOWING_ELEMENTS = 3;

    protected Gson gson = new Gson();

    class Info {
        Long duration;
        String beanName;
        String operationName;
        String argument;
        LocalDateTime start;

        public Info(Long duration, String beanName, String operationName, String argument, LocalDateTime start) {
            this.duration = duration;
            this.beanName = beanName;
            this.operationName = operationName;
            this.argument = argument;
            this.start = start;
        }

        public Info() {
        }
    }

    ConcurrentSkipListMap<Long, Info> tree = new ConcurrentSkipListMap<Long, Info>(new ByReverseTimeWithDuplicateComparator());

    public String show3LongestOperations() {
        int i = 0;
        String s = null;
        for (Map.Entry element : tree.entrySet()) {
//            System.out.println(element.getKey() + "   " + (Info) element.getValue());
            String elementString = gson.toJson(element);
            s += gson.toJson(element);
            System.out.println(elementString);
            if (++i >= MAX_COUNT_OF_SHOWING_ELEMENTS) {
                return s;
            }
        }
        return s;
    }

    public void addValue(Long key, String value) {
        tree.put(key, new Info());
    }

    class ByReverseTimeWithDuplicateComparator implements Comparator<Long> {
        @Override
        public int compare(Long e1, Long e2) {
            int result = e2.compareTo(e1);
            return result == 0 ? -1 : result;
        }
    }

    @PreDestroy
    public void destroy() {
        show3LongestOperations();
    }
}
