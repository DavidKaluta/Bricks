package com.davidkaluta.bricks;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

import android.content.res.Resources;
import android.graphics.*;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class GameView extends View {

    private Killer killer;
    private ArrayList<Brick> bricks;
    private Bitmap bg;
    private int secs;
    private int mins;
    private int hrs;
    private Timer timer;

    public GameView(Context context) {
        super(context);
        int deviceWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int deviceHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        bg = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.background),
                deviceWidth, deviceHeight, true);
        spawnKiller();
        bricks = new ArrayList<>();
        TimerTask task = new TimeHelper();
        timer = new Timer();
        timer.schedule(task, 1000, 1000);
    }

    public void spawnBricks(ArrayList<Brick> bricks) {
        if (bricks.isEmpty()) {
            Random random = new Random();
            Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                    R.drawable.brick);
            float deviceWidth = Resources.getSystem().getDisplayMetrics()
                    .widthPixels;
            float deviceHeight = Resources.getSystem().getDisplayMetrics().
                    heightPixels;
            for (int i = 0; i < 6; i++) {
                bricks.add(new Brick(random.nextInt((int)
                        (deviceWidth - Brick.getWidth() - 10)) + 5,
                        random.nextInt((int)
                                (deviceHeight - Brick.getHeight() - 10)) + 5,
                                 this));
            }
        }
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(ArrayList<Brick> bricks) {
        this.bricks = bricks;
    }

    public void spawnKiller() {
        int deviceWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int deviceHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        killer = null;
        killer = new Killer((float) deviceWidth / 2,
                (float) (deviceHeight) / 4 * 3, 0, 0, this);
    }

    public Killer getKiller() {
        return killer;
    }

    public void setKiller(Killer killer) {
        this.killer = killer;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bg, 0, 0, null);
        for (Brick brick : bricks) {
            if (brick != null)
                brick.draw(canvas);
        }
        if (killer != null)
            killer.draw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.WHITE);
        canvas.drawText(getContext().getString(R.string.score_textview,
                killer.getScore()), 50, 100, paint);
        canvas.drawText(getContext().getString(R.string.high_score_textview,
                Saver.getHighScore(getContext())),
                50, 150, paint);
        canvas.drawText(getContext().getString(R.string.timer_text,
                TimeHelper.hours, TimeHelper.minutes, TimeHelper.seconds),
                50, 200, paint);
        invalidate();
    }
}
