package com.davidkaluta.bricks;

import android.content.Context;
import java.util.ArrayList;
import android.graphics.Canvas;
import android.view.View;

public class GameView extends View {

    private Killer killer;
    private ArrayList<Brick> bricks;

    public GameView(Context context) {
        super(context);
        killer = new Killer(300, 700, 0, 0, this);
        bricks = new ArrayList<>();
        bricks.add(new Brick(200,100,this));
        bricks.add(new Brick(400,100,this));
        bricks.add(new Brick(600,100,this));
        bricks.add(new Brick(200,300,this));
        bricks.add(new Brick(400,300,this));
        bricks.add(new Brick(600,300,this));
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(ArrayList<Brick> bricks){
        this.bricks = bricks;
    }

    public void killBrick(Brick brick) {
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
        for (Brick brick:
             bricks) {
            if(brick != null)
                brick.draw(canvas);
        }
        killer.draw(canvas);
        invalidate();
    }


}
