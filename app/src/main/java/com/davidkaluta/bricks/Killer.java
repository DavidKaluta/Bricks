package com.davidkaluta.bricks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Killer extends Brick {
    private Bitmap bmp;
    public Killer(float x, float y, GameView gameView) {
        super(x, y, gameView);
        bmp = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.ic_launcher_round);
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }
}
