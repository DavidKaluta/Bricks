package com.davidkaluta.bricks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Brick {
    private Bitmap bmp;
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected Rect rect;
    public Brick(float x, float y, GameView gameView) {
        bmp = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.brick);
        width = bmp.getWidth();
        height = bmp.getHeight();
        this.x = x;
        this.y = y;
        rect = new Rect((int) x , (int) y, (int) (x+width),  (int) (x+height));
    }

    public Rect getRect() {
        return rect;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setX(float x) {this.x = x;}

    public void setY(float y) {this.y = y;}

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }
}
