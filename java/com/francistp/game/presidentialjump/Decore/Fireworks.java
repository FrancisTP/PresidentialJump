package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.framework.gl.SpriteBatcher;

/**
 * Created by Francis on 2017-01-12.
 */
public class Fireworks {

    private int amount;
    private int maxAmount;

    private Firework[] fireworks;

    public Fireworks(){

        maxAmount = 15;

        fireworks = new Firework[maxAmount];

        for (int i=0; i < maxAmount; i++) {
            fireworks[i] = new Firework();
        }
    }

    public Fireworks(int maxAmount){
        amount = 0;
        this.maxAmount = maxAmount;

        fireworks = new Firework[this.maxAmount];

        for (int i=0; i < maxAmount; i++) {
            fireworks[i] = new Firework();
        }
    }

    public void update(float deltaTime) {
        for (int i=0; i < maxAmount; i++) {
            fireworks[i].update(deltaTime);
        }
    }

    public void render(SpriteBatcher batcher) {
        for (int y=0; y < maxAmount; y++) {
            fireworks[y].render(batcher);
        }
    }

    public void scroll(float amount) {
        for (int i=0; i < fireworks.length; i++) {
            fireworks[i].setY(fireworks[i].getY() + amount);
            fireworks[i].setStartingY(fireworks[i].getStartingY() + amount);
            fireworks[i].setExplosionHeight(fireworks[i].getExplosionHeight() + amount);
            fireworks[i].setExplosionHeightY1(fireworks[i].getExplosionHeightY1() + amount);
            fireworks[i].setExplosionHeightY2(fireworks[i].getExplosionHeightY2() + amount);
        }
    }

}
