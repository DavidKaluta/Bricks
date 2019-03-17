package com.davidkaluta.bricks;

import android.graphics.Canvas;

import java.util.ArrayList;

public class ParticleManager implements Runnable {

    private ArrayList<Particle> particles;
    private GameView gv;
    private Thread thread;

    public ParticleManager(GameView gv) {
        particles = new ArrayList<>();
        // thread = new Thread("pmThread");
        this.gv = gv;
        // thread.start();
    }

    public void addParticles(Brick brick) {
        for (int i = 0; i < 5; i++) {
            particles.add(new Particle(brick, gv));
        }
    }

    public void draw(Canvas canvas) {
        for (Particle particle : particles) {
            if (particle != null)
                particle.draw(canvas);
        }
    }

    public boolean isEmpty() {
        return particles.isEmpty();
    }

    public void run() {
        for (int i = 0; i < particles.size(); i++) {
            if(particles.get(i).getLifespan() > 0) {
                particles.get(i).move();
            }
            else {
                particles.remove(i);
                i--;
            }
        }
    }
}
