package com.davidkaluta.bricks;

public class Timer implements Runnable {
    private int seconds;
    private int minutes;
    private int hours;
    private Thread thread;
    public Timer() {
        seconds = 0;
        minutes = 0;
        hours = 0;
        thread = new Thread("timerThread");
        thread.start();
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public void run() {
        while(true) {
            if (seconds < 60)
                seconds += 1;
            else {
                seconds = 0;
                if (minutes < 60)
                    minutes += 1;
                else {
                    minutes = 0;
                    hours += 1;
                }
            }
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
