package com.davidkaluta.bricks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class GameView extends View {

    private Brick[] bricks;
    private Killer killer;

    public GameView(Context context) {
        super(context);
        int x = 100;
        bricks = new Brick[3];
        for (int i = 0; i < bricks.length; i++) {
            bricks[i] = new Brick(x, 200, this);
            x+=200;
        }
        killer = new Killer(150, 500, 0, 0, this);
    }

    public Brick[] getBricks() {
        return bricks;
    }

    public Killer getKiller() {
        return killer;
    }

    public void setKiller(Killer killer) {
        this.killer = killer;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < bricks.length; i++) {
            bricks[i].draw(canvas);
        }
        killer.draw(canvas);
        invalidate();
    }


}
