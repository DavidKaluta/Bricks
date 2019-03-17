package com.davidkaluta.bricks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class Particle extends Brick {

    private Bitmap bmp;
    private int lifespan;
    private int dx;
    private int dy;
    private GameView gv;

    public Particle(float x, float y, GameView gv) {
        super(x,y,gv);
        bmp = BitmapFactory.decodeResource(gv.getResources(), R.drawable.particle);
        width = bmp.getWidth();
        height = bmp.getHeight();
        this.gv = gv;
        Random random = new Random();
        dx = random.nextInt(20) - 10;
        dy = random.nextInt(20) - 10;
        lifespan = 60;
    }

    public Particle(Brick brick, GameView gv) {
        super(brick.x, brick.y, gv);
        bmp = BitmapFactory.decodeResource(gv.getResources(), R.drawable.particle);
        width = bmp.getWidth();
        height = bmp.getHeight();
        this.gv = gv;
        Random random = new Random();
        dx = random.nextInt(20) - 10;
        dy = random.nextInt(20) - 10;
        lifespan = 60;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bmp, x, y, null);
    }


    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public void move() {
        x += dx;
        y += dy;
        lifespan--;
    }
}