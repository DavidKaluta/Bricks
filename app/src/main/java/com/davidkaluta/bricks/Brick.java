package com.davidkaluta.bricks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Brick {
    private Bitmap bmp;
    protected float x;
    protected float y;
    protected static float width;
    protected static float height;
    public Brick(float x, float y, GameView gameView) {
        bmp = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.brick);
        width = bmp.getWidth();
        height = bmp.getHeight();
        this.x = x;
        this.y = y;
    }


    public static float getWidth() {
        return width;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static float getHeight() {
        return height;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }
}
