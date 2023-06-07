package com.example.ztbd_project.utils;

import org.springframework.data.util.Pair;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

public class TimeMeasurer {

    private static final HashMap<String, Long> tagMap = new HashMap<>();
    public static boolean debug = true;


    public static void start(String tag) {
        if (debug) {
            tagMap.put(tag, System.nanoTime());
        }
    }

    public static double end(String tag) {
        if (debug) {
            long time = System.nanoTime();
            Long time1 = tagMap.get(tag);
            if (time1 == null) {
                return 0d;
            }
            time -= time1;
            double t = time / 1000000d;
            System.out.format("|TimeMeasurer| %s took: %f ms", tag, t).println();
            return t;
        }
        return 0d;
    }

}
