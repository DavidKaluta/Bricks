package com.davidkaluta.bricks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Killer extends Brick implements Runnable {
    private Bitmap bmp;
    private Thread thread;
    private float dx;
    private float dy;
    private GameView gv;

    public Killer(float x, float y, float dx, float dy, GameView gameView) {
        super(x, y, gameView);
        bmp = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.ic_launcher_round);
        gv = gameView;
        width = bmp.getWidth();
        height = bmp.getHeight();
        this.dx = dx;
        this.dy = dy;
        thread = new Thread(this, "killerThread");
        thread.start();
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }

    @Override
    public void run() {
        while (true) {
            int deviceWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
            int deviceHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
            if (x <= 0 || x >= deviceWidth - width)
                dx = -dx;
            if (y <= 0 || y >= deviceHeight - height)
                dy = -dy;
            if(gv.getBrick() != null) {
                if (x + width > gv.getBrick().x
                        && x < gv.getBrick().x + gv.getBrick().width
                        && y + height > gv.getBrick().y
                        && y < gv.getBrick().y + gv.getBrick().height) {
                    dx = 0;
                    dy = 0;
                    gv.killBrick();
                }
            }
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
