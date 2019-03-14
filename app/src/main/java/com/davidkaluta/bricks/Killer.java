package com.davidkaluta.bricks;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.ArrayList;

public class Killer extends Brick implements Runnable {
    private Bitmap bmp;
    private Thread thread;
    private float dx;
    private float dy;
    private float ddx;
    private float ddy;
    private int score;
    private GameView gv;

    public Killer(float x, float y, float dx, float dy, GameView gameView) {
        super(x, y, gameView);
        bmp = BitmapFactory.decodeResource(gameView.getResources(),
         R.drawable.ninjastar);
        gv = gameView;
        width = bmp.getWidth();
        height = bmp.getHeight();
        this.dx = dx;
        this.dy = dy;
        score = 0;
        thread = new Thread(this, "killerThread");
        thread.start();
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public int getScore() {
        return score;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }

    @Override
    public void run() {
        while (true) {
            int deviceWidth = Resources.getSystem().getDisplayMetrics()
            .widthPixels;
            int deviceHeight = Resources.getSystem().getDisplayMetrics()
            .heightPixels;
            if (x <= 0 || x >= deviceWidth - width)
                dx = -dx;
            if(x < 0)
                x = 0;
            if(x > deviceWidth - width)
                x = deviceWidth-width;
            if (y <= 0 || y >= deviceHeight - height)
                dy = -dy;
            ArrayList<Brick> bricks = gv.getBricks();
            for (Brick brick: bricks) {
                if(brick != null) {
                    if (x + width >brick.x
                            && x < brick.x + brick.width
                            && y + height > brick.y
                            && y < brick.y + brick.height) {
                        bricks.remove(brick);
                        score++;
                        if(Saver.getHighScore(gv.getContext()) < score)
                            Saver.setHighScore(gv.getContext(), score);
                        break;
                    }
                }
            }
            ddy = Math.abs(dy*(float) (0.003));
            ddx = Math.abs(dx*(float) (0.003));
            if(Math.sqrt(Math.pow(ddy,2) + Math.pow(ddx, 2)) <= 0.00001) {
                ddy = 0;
                ddx = 0;
                dy = 0;
                dx = 0;
            }
            if(dx > 0)
                dx -= ddx;
            else if(dx < 0)
                dx += ddx;
            else {}
            if(dy > 0)
                dy -= ddy;
            else if(dy < 0)
                dy += ddy;
            else {}
            x += dx;
            y += dy;
            if(bricks.isEmpty())
                gv.spawnBricks(bricks);
            gv.setBricks(bricks);
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
