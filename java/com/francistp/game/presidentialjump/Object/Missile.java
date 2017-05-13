package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Character.Player;
import com.francistp.game.presidentialjump.Settings.SoundController;

/**
 * Created by Francis on 2017-05-06.
 */
public class Missile {

    private float x, y;
    private float width, height;
    private Animation missileAnimation, fireAnimation, explosionAnimation;
    private float missleAnimationCounter, fireAnimationCounter, explosionAnimationCounter;
    private boolean ready, start;
    private float speed;
    private int delay, delayCounter, warningCounter;

    private float missileWidth, missileHeight;
    private float fireWidth, fireHeight;
    private float fireOffset;
    private float missileExplosionWidth, missileExplosionHeight;

    private GameObjectRectangle bounds;
    private boolean hit;
    private int number;

    boolean movingSoundPlayed, explosionSoundPlayed;

    public Missile(float x, int number) {
        this.x = x;
        this.number = number;

        missileAnimation = Assets.missile;
        fireAnimation = Assets.missile_fire;
        explosionAnimation = Assets.missile_explosion;
        missleAnimationCounter = 0;
        fireAnimationCounter = 0;
        explosionAnimationCounter = 0;
        ready = true;
        start = false;
        speed = 14;
        delay = 0;
        delayCounter = 0;
        warningCounter = 0;

        float multiplier = 1.5f;
        float fireMultiplier = 2;

        missileWidth = Assets.missile_01.width*multiplier;
        missileHeight = Assets.missile_01.height*multiplier;
        fireWidth = (Assets.missile_fire_01.width*multiplier)*fireMultiplier;
        fireHeight = (Assets.missile_fire_01.height*multiplier)*fireMultiplier;
        fireOffset = (9*multiplier)*fireMultiplier;
        fireOffset = (9*multiplier)*fireMultiplier;
        missileExplosionWidth = Assets.missile_explosion_01.width*3;
        missileExplosionHeight = Assets.missile_explosion_01.height*3;

        width = missileWidth;
        height = missileHeight + fireHeight;
        y = 0 - (height*5);

        bounds = new GameObjectRectangle(this.x, y, width - 2, Assets.missile_01.height - 4);

        movingSoundPlayed = false;
        explosionSoundPlayed = false;
    }

    public void reset() {
        y = 0-(height*5);
        bounds.setPosition(x, y);
        ready = true;
        start = false;
        delayCounter = 0;
        warningCounter = 0;
        movingSoundPlayed = false;
        explosionSoundPlayed = false;
        hit = false;
    }

    public boolean isReady() {
        return ready;
    }

    public void start(int delay) {
        start = true;
        ready = false;
        this.delay = delay;
    }

    public void update(float deltaTime) {
        if (!hit) {
            if (delayCounter >= delay) {
                if (start) {
                    if (y - height > 800) {
                        reset();
                    } else {
                        y += speed;
                        bounds.setPosition(x, y);

                        missleAnimationCounter += 0.2f;
                        fireAnimationCounter += 0.3f;
                    }
                    warningCounter++;
                }
            } else {
                delayCounter++;
                if (delayCounter == delay-20) {
                    // start playing sound
                    if (!movingSoundPlayed) {
                        movingSoundPlayed = true;
                        if (number == 1) {
                            SoundController.playMissileMoving01();
                        } else if (number == 2) {
                            SoundController.playMissileMoving02();
                        } else if (number == 3) {
                            SoundController.playMissileMoving03();
                        }
                    }
                }
            }
        } else {
            if (!explosionSoundPlayed) {
                explosionSoundPlayed = true;
                if (number == 1) {
                    SoundController.pauseMissileMoving01();
                } else if (number == 2) {
                    SoundController.pauseMissileMoving02();
                } else if (number == 3) {
                    SoundController.pauseMissileMoving03();
                }
                SoundController.playMissileExplosion();
            }
            explosionAnimationCounter += 0.2f;
            if (explosionAnimationCounter > 25) {
                reset();
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        if (!hit) {
            if (y + (missileHeight / 2) + fireHeight >= 0) {
                TextureRegion keyFrame = missileAnimation.getKeyFrame(missleAnimationCounter, Animation.ANIMATION_LOOPING);
                batcher.drawSprite(x, y, missileWidth, missileHeight, keyFrame);
                keyFrame = fireAnimation.getKeyFrame(fireAnimationCounter, Animation.ANIMATION_LOOPING);
                batcher.drawSprite(x, y - ((missileHeight / 2) + fireOffset), fireWidth, fireHeight, keyFrame);
            } else {
                if (delayCounter >= delay) {
                    if (warningCounter < 10) {
                        batcher.drawSprite(x, (Assets.missile_warning.height / 2) + (Assets.electric_boundry_01.height * 3), Assets.missile_warning.width, Assets.missile_warning.height, Assets.missile_warning);
                    } else if (warningCounter > 15) {
                        warningCounter = 0;
                    }
                }
            }
        } else {
            TextureRegion keyFrame = explosionAnimation.getKeyFrame(explosionAnimationCounter, Animation.ANIMATION_NONLOOPING);
            batcher.drawSprite(x, y + (missileHeight/2), missileExplosionWidth, missileExplosionHeight, keyFrame);
        }

        /*
        batcher.drawSprite(-1, -1, 1, 1,Assets.reduntant);
        batcher.endBatch();
        batcher.beginBatch(Assets.collisionLinesTexture);
        batcher.drawSprite(-1, -1, 1, 1, new TextureRegion(Assets.collisionLinesTexture, 0, 0, 1, 1));
        bounds.drawShape(batcher);
        batcher.endBatch();
        batcher.beginBatch(Assets.obstaclesTexture);
        batcher.drawSprite(-1, -1, 1, 1, Assets.reduntant);
        */


    }

    public GameObjectRectangle getBounds() {
        return bounds;
    }

    public void hit() {
        hit = true;
    }

}
