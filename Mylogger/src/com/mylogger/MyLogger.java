package com.mylogger;

/**
 * Created @2017/6/10 15:30
 */
public class MyLogger {
    public  static void log(String message) {
        System.out.println(message);
    }

    public  static void log(Object o) {
        System.out.println(o);
    }

    public static void log(String format, Object... arg) {
        System.out.println(String.format(format, arg));
    }
}
