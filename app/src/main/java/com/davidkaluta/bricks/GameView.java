package com.davidkaluta.bricks;

import android.content.Context;
import java.util.ArrayList;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;

public class GameView extends View {

    private Killer killer;
    private ArrayList<Brick> bricks;

    public GameView(Context context) {
        super(context);
        spawnKiller();
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

    public void spawnKiller(){
        int deviceWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int deviceHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        killer = null;
        killer = new Killer((float) deviceWidth/2, (float) (deviceHeight)/4*3, 0, 0, this);
    }
    
    public Killer getKiller() {
        return killer;
    }

    public void setKiller(Killer killer) {
        this.killer = killer;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Brick brick: bricks) {
            if(brick != null)
                brick.draw(canvas);
        }
        if(killer != null)
            killer.draw(canvas);
        invalidate();
    }


}
