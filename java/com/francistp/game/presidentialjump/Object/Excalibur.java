package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Settings.SoundController;

/**
 * Created by Francis on 2017-05-05.
 */
public class Excalibur {

    private float x, y;
    private float width, height;
    private float initialWidth;
    private int state;
    private int stateCounter;
    private int delay;
    private int delayCounter;
    private boolean ready;
    
    public static final int AIM = 0;
    public static final int SHOOT = 1;
    private static final int AFTER_EFFECT = 2;
    public static final int NOTHING = 3;

    private static final int INITIAL_AIM_COUNT = 20;
    private static final int AIM_COUNT = 80;
    private static final int SHOOT_COUNT = 25;
    private static final int AFTER_EFFECT_COUNT = 20;

    private GameObjectRectangle bounds;
    private boolean flashed, allArleadyPlayed;
    private  ExcaliburParticle[] excaliburParticles;

    public Excalibur(float x) {
        this.x = x;

        y = 400;
        height = 800;
        initialWidth = 30;

        bounds = new GameObjectRectangle(this.x, y, initialWidth/2, height);

        state = NOTHING;
        stateCounter = 0;
        delayCounter = 0;
        ready = false;
        allArleadyPlayed = false;
        flashed = false;

        excaliburParticles = new ExcaliburParticle[20];
        for (int i=0; i<excaliburParticles.length; i++) {
            excaliburParticles[i] = new ExcaliburParticle(this.x);
        }
    }

    public void update(float deltaTime) {
        if (state == AIM) {
            delayCounter++;

            if (delayCounter > delay) {
                if (!allArleadyPlayed) {
                    SoundController.playExcaliburAllSound();
                    allArleadyPlayed = true;
                }
                ready = true;
                stateCounter++;
                if (stateCounter > INITIAL_AIM_COUNT) {
                    width = initialWidth * (1 - (((float)stateCounter - (float)INITIAL_AIM_COUNT) / (float)AIM_COUNT));
                }

                if (stateCounter >= AIM_COUNT + INITIAL_AIM_COUNT) {
                    stateCounter = 0;
                    state = SHOOT;
                    width = bounds.getWidth();
                }
            }
        } else if (state == SHOOT) {
            stateCounter++;

            if (stateCounter > SHOOT_COUNT) {
                stateCounter = 0;
                state = AFTER_EFFECT;
            }
        } else if (state == AFTER_EFFECT) {
            stateCounter++;

            for (int i=0; i<excaliburParticles.length; i++) {
                excaliburParticles[i].update(deltaTime);
            }

            if (stateCounter > AFTER_EFFECT_COUNT) {
                stateCounter = 0;
                delayCounter = 0;
                state = NOTHING;
                allArleadyPlayed = false;
                ready = false;
                flashed = false;

                for (int i=0; i<excaliburParticles.length; i++) {
                    excaliburParticles[i].reset();
                }
            }
        } else {
            // NOTHING
        }
    }

    public void render(SpriteBatcher batcher) {
        if (state == AIM) {
            batcher.drawSprite(x, y, width, height, Assets.excalibur_transparent);
        } else if (state == SHOOT) {
            if (!flashed) {
                batcher.drawSprite(240, 400, 480, 800, Assets.excalibur_solid);
                flashed = true;
            } else {
                batcher.drawSprite(x, y, width, height, Assets.excalibur_solid);
            }
        } else if (state == AFTER_EFFECT) {
            for (int i=0; i<excaliburParticles.length; i++) {
                excaliburParticles[i].render(batcher);
            }
        } else {
            // NOTHING
        }
    }

    public void setState(int state, int delay) {
        this.state = state;
        this.delay = delay;
        stateCounter = 0;

        width = initialWidth;
    }

    public int getState() {
        return state;
    }

    public GameObjectRectangle getBounds() {
        return bounds;
    }

    public boolean isReady() {
        return ready;
    }

}
