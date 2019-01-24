package com.davidkaluta.bricks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Brick {
    private Bitmap bmp;
    private float x;
    private float y;
    public Brick(float x, float y, GameView gameView) {
        bmp = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.brick);
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }
}
