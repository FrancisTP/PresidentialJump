package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Menues.GameScreen;

import java.util.Random;

/**
 * Created by Francis on 2017-01-12.
 */
public class Firework {
    float stateTime;

    private float x, y;

    private float startingY;
    private float spawningX1, spawningX2;
    private float explosionHeight;
    private float explosionHeightY1;
    private float explosionHeightY2;
    private float speed;
    private float minSpeed = 2.5f;
    private float maxSpeed = 4.5f;
    private int counter;
    private int explosionCounter = 0;
    private int startDelay;
    private int explosionTime = 120;

    Random rand = new Random();

    private int state;
    private final int SHOOTING_STATE = 0;
    private final int EXPLOSION_STATE = 1;
    private boolean isRunning = false;

    private int color;
    private final int BLUE = 1;
    private final int YELLOW = 2;
    private final int RED = 3;

    public Firework(){
        stateTime = 0;

        startingY = 200;
        spawningX1 = 0;
        spawningX2 = 480;

        x = rand.nextFloat() * (spawningX2 - spawningX1) + spawningX1;
        y = startingY;
        explosionHeightY1 = 500;
        explosionHeightY2 = 750;
        explosionHeight = rand.nextFloat() * (explosionHeightY2 - explosionHeightY1) + explosionHeightY1;
        speed = rand.nextFloat() * (maxSpeed - minSpeed) + minSpeed;

        state = SHOOTING_STATE;
        color = 1 + (int)(Math.random() * ((3 - 1) + 1));
        counter = 0;
        startDelay = 60 + (int)(Math.random() * ((480 - 60) + 1));
    }

    public Firework(float x, float y, float explosionHeightY1, float explosionHeightY2){
        stateTime = 0;

        this.x = x;
        this.y = y;
        this.explosionHeightY1 = explosionHeightY1;
        this.explosionHeightY2 = explosionHeightY2;
        explosionHeight = rand.nextFloat() * (explosionHeightY2 - explosionHeightY1) + explosionHeightY1;
        speed = rand.nextFloat() * (maxSpeed - minSpeed) + minSpeed;

        state = SHOOTING_STATE;
        color = 1 + (int)(Math.random() * ((3 - 1) + 1));
        counter = 0;
        startDelay = 60 + (int)(Math.random() * ((480 - 60) + 1));
    }

    public void update(float deltaTime){
        //this.stateTime += deltaTime;
        if (state == EXPLOSION_STATE) {
            stateTime += 0.20f;
        }
        if (state == SHOOTING_STATE) {
            counter++;
        } else if (state == EXPLOSION_STATE) {
            explosionCounter++;
        }

        if (counter > startDelay && !isRunning) {
            isRunning = true;
        }

        if (isRunning) {
            if (state == SHOOTING_STATE) {
                y += speed;
                if (y > explosionHeight) {
                    state = EXPLOSION_STATE;
                    counter = 0;
                }
            } else if (state == EXPLOSION_STATE) {
                if (explosionCounter > explosionTime) {
                    restart();
                }
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        if (state  == SHOOTING_STATE) {
            if (color == BLUE) {
                batcher.drawSprite(x, y, Assets.blue_firework_01.width, Assets.blue_firework_01.height, Assets.blue_firework_01);
            } else if (color == YELLOW) {
                batcher.drawSprite(x, y, Assets.yellow_firework_01.width, Assets.yellow_firework_01.height, Assets.yellow_firework_01);
            } else if (color == RED) {
                batcher.drawSprite(x, y, Assets.red_firework_01.width, Assets.red_firework_01.height, Assets.red_firework_01);
            }
        } else if (state == EXPLOSION_STATE) {
            if (color == BLUE) {
                TextureRegion keyFrame = Assets.blueFirework.getKeyFrame(stateTime, Animation.ANIMATION_NONLOOPING);
                batcher.drawSprite(x, y, Assets.blue_firework_01.width, Assets.blue_firework_01.height, keyFrame);
            } else if (color == YELLOW) {
                TextureRegion keyFrame = Assets.yellowFirework.getKeyFrame(stateTime, Animation.ANIMATION_NONLOOPING);
                batcher.drawSprite(x, y, Assets.yellow_firework_01.width, Assets.yellow_firework_01.height, keyFrame);
            } else if (color == RED) {
                TextureRegion keyFrame = Assets.redFirework.getKeyFrame(stateTime, Animation.ANIMATION_NONLOOPING);
                batcher.drawSprite(x, y, Assets.red_firework_01.width, Assets.red_firework_01.height, keyFrame);
            }
        }
    }

    private void restart() {
        stateTime = 0;
        isRunning = false;

        x = rand.nextFloat() * (spawningX2 - spawningX1) + spawningX1;
        y = startingY;
        explosionHeight = rand.nextFloat() * (explosionHeightY2 - explosionHeightY1) + explosionHeightY1;
        speed = rand.nextFloat() * (maxSpeed - minSpeed) + minSpeed;

        state = SHOOTING_STATE;
        color = 1 + (int)(Math.random() * ((3 - 1) + 1));
        counter = 0;
        explosionCounter = 0;
        startDelay = 60 + (int)(Math.random() * ((480 - 60) + 1));
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getExplosionHeight() {
        return explosionHeight;
    }

    public void setExplosionHeight(float explosionHeight) {
        this.explosionHeight = explosionHeight;
    }

    public float getExplosionHeightY1() {
        return explosionHeightY1;
    }

    public void setExplosionHeightY1(float explosionHeightY1) {
        this.explosionHeightY1 = explosionHeightY1;
    }

    public float getExplosionHeightY2() {
        return explosionHeightY2;
    }

    public void setExplosionHeightY2(float explosionHeightY2) {
        this.explosionHeightY2 = explosionHeightY2;
    }

    public float getStartingY() {
        return startingY;
    }

    public void setStartingY(float startingY) {
        this.startingY = startingY;
    }
}
