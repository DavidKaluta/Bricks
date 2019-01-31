package com.davidkaluta.bricks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Killer extends Brick implements Runnable {
    private Bitmap bmp;
    private Context context;
    private Thread thread;
    private float dx;
    private float dy;

    public Killer(float x, float y, float dx, float dy, GameView gameView) {
        super(x, y, gameView);
        this.context = context;
        bmp = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.ic_launcher_round);
        this.dx = dx;
        this.dy = dy;
        thread = new Thread(this, "killerThread");
        thread.start();
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            y += dy;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
