package com.timer;

import com.mylogger.MyLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created @2017/6/10 15:39
 */
public class Timer {

    List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void timerAsync(int time) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                timer(time);
            }
        }).start();
    }

    public void timer(int timeSeconds) {
        int left = timeSeconds;

        for (int i = 0; i < timeSeconds; i++) {
            try {
                Thread.sleep(1000);
                left--;

                for (Listener l : listeners) {
                    l.onTick(left);
                }

            } catch (InterruptedException e) {
                MyLogger.log("interrupted");
            }

        }
        for (Listener l : listeners) {
            l.onComplete();
        }
    }
}
