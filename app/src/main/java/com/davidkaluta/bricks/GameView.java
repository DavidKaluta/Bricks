package com.davidkaluta.bricks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View {

    private Brick brick;
    private Killer killer;

    public GameView(Context context) {
        super(context);
        brick = new Brick(100,200,this);
        killer = new Killer(150, 500, 0, 0, this);
    }

    public Brick getBrick() {
        return brick;
    }

    public void setBrick(Brick brick){
        this.brick = brick;
    }

    public void killBrick() {
        brick = null;
    }

    public Killer getKiller() {
        return killer;
    }

    public void setKiller(Killer killer) {
        this.killer = killer;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(brick != null)
            brick.draw(canvas);
        killer.draw(canvas);
        invalidate();
    }


}
