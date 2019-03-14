package com.davidkaluta.bricks;

import java.util.TimerTask;

class TimeHelper extends TimerTask {
    public static int seconds = 0;
    public static int minutes = 0;
    public static int hours = 0;

    public void run() {
        if (seconds < 59)
            seconds++;
        else {
            seconds = 0;
            if (minutes < 59)
                minutes++;
            else {
                minutes = 0;
                hours += 1;
            }
        }
    }
}