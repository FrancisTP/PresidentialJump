package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.framework.math.Rectangle;
import com.francistp.game.framework.math.Vector2;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-01-16.
 */
public class Trump extends Player {

    private float bodyOffsetX, bodyOffsetY;
    private float headOffsetX, headOffsetY;
    private float handOffsetX, handOffsetY, handDefaultOffsetY;
    private float mouthOffsetX, mouthOffsetY;
    private float eyesOffsetX, eyesOffsetY;
    private float dustOffsetX, dustOffsetY;

    private float handWobble;

    private float stateTime;

    private int blinkIntervalTime;
    private int blinkTime;
    private int blinkCounter;
    private boolean resetBlinkTime;
    private int minBlinkTime;
    private int maxBlinkTime;

    private float hairFlipAnimationTimer;
    private float hairSettleAnimationTimer;
    private float dustTimer;

    public Trump(){
        super();

        position = new Vector2(240, 50);
        velocity = new Vector2(0, 0);

        bodyOffsetX = 0;
        bodyOffsetY = -10f;

        headOffsetX = 10;
        headOffsetY = 55;

        handOffsetX = -5;
        handDefaultOffsetY = -15;
        handOffsetY = -15;

        mouthOffsetX = 13;
        mouthOffsetY = 33;

        eyesOffsetX = 15;
        eyesOffsetY = 47;

        dustOffsetX = 20;
        dustOffsetY = -15;

        wallBounds = new GameObjectRectangle(position.x - bodyOffsetX, position.y - bodyOffsetY, 45, 40);
        damageBounds = new GameObjectRectangle(position.x - bodyOffsetX, position.y - bodyOffsetY, 25, 35);

        handWobble = 0;

        blinkIntervalTime = 180;
        blinkTime = 20;
        blinkCounter = 0;
        resetBlinkTime = false;
        minBlinkTime = 240;
        maxBlinkTime = 600;

        stateTime = 0;
        hairFlipAnimationTimer = 0;
        hairSettleAnimationTimer = 0;
        dustTimer = 0;
    }

    @Override
    public void update(float deltaTime) {
        handWobble += 0.05;
        if(handWobble >= 360)
            handWobble -= 360;
        handOffsetY = handDefaultOffsetY + ((float) Math.sin(handWobble));

        blinkCounter++;

        if (blinkCounter > blinkIntervalTime && !resetBlinkTime) {
            resetBlinkTime = true;
            blinkCounter = 0;
        } else if (blinkCounter > blinkTime && resetBlinkTime) {
            resetBlinkTime = false;
            blinkCounter = 0;
            blinkIntervalTime = minBlinkTime + (int)(Math.random() * ((maxBlinkTime - minBlinkTime) + 1));
        }

        updatePlayer(deltaTime);
        wallBounds.setPosition(position.x - bodyOffsetX, position.y - bodyOffsetY);
        damageBounds.setPosition(position.x - bodyOffsetX, position.y - bodyOffsetY);
    }

    @Override
    public void render(SpriteBatcher batcher) {


        batcher.beginBatch(Assets.trumpallbodyparts);
        if (playerState == IDLE) {
            batcher.drawSprite(position.x + bodyOffsetX, position.y + bodyOffsetY, Assets.trump_body_right.width, Assets.trump_body_right.height, Assets.trump_body_right);
            batcher.drawSprite(position.x + handOffsetX, position.y + handOffsetY, Assets.trump_hand_right.width, Assets.trump_hand_right.height, Assets.trump_hand_right);
            batcher.drawSprite(position.x + headOffsetX, position.y + headOffsetY, Assets.trump_head_01_right.width, Assets.trump_head_01_right.height, Assets.trump_head_01_right);
            if (!resetBlinkTime) {
                batcher.drawSprite(position.x + eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_open.width, Assets.trump_eyes_open.height, Assets.trump_eyes_open);
            } else {
                batcher.drawSprite(position.x + eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_closed.width, Assets.trump_eyes_closed.height, Assets.trump_eyes_closed);
            }
            batcher.drawSprite(position.x + mouthOffsetX, position.y + mouthOffsetY, Assets.trump_mouth_01_right.width, Assets.trump_mouth_01_right.height, Assets.trump_mouth_01_right);
        } else if (playerState == JUMP_RIGHT) {
            hairSettleAnimationTimer = 0;
            dustTimer = 0;
            hairFlipAnimationTimer += 0.25f;

            batcher.drawSprite(position.x + bodyOffsetX, position.y + bodyOffsetY, Assets.trump_body_jump_right.width, Assets.trump_body_jump_right.height, Assets.trump_body_jump_right);

            TextureRegion keyFrame = Assets.trump_hair_flip_right.getKeyFrame(hairFlipAnimationTimer, Animation.ANIMATION_NONLOOPING);
            batcher.drawSprite(position.x + headOffsetX, position.y + headOffsetY, Assets.trump_head_01_right.width, Assets.trump_head_01_right.height, keyFrame);

            if (!resetBlinkTime) {
                batcher.drawSprite(position.x + eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_open.width, Assets.trump_eyes_open.height, Assets.trump_eyes_open);
            } else {
                batcher.drawSprite(position.x + eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_closed.width, Assets.trump_eyes_closed.height, Assets.trump_eyes_closed);
            }
            batcher.drawSprite(position.x + mouthOffsetX, position.y + mouthOffsetY, Assets.trump_mouth_01_right.width, Assets.trump_mouth_01_right.height, Assets.trump_mouth_01_right);
        } else if (playerState == JUMP_LEFT) {
            hairSettleAnimationTimer = 0;
            dustTimer = 0;
            hairFlipAnimationTimer += 0.2f;

            batcher.drawSprite(position.x - bodyOffsetX, position.y + bodyOffsetY, Assets.trump_body_jump_left.width, Assets.trump_body_jump_left.height, Assets.trump_body_jump_left);

            TextureRegion keyFrame = Assets.trump_hair_flip_left.getKeyFrame(hairFlipAnimationTimer, Animation.ANIMATION_NONLOOPING);
            batcher.drawSprite(position.x - headOffsetX, position.y + headOffsetY, Assets.trump_head_01_left.width, Assets.trump_head_01_left.height, keyFrame);

            if (!resetBlinkTime) {
                batcher.drawSprite(position.x - eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_open.width, Assets.trump_eyes_open.height, Assets.trump_eyes_open);
            } else {
                batcher.drawSprite(position.x - eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_closed.width, Assets.trump_eyes_closed.height, Assets.trump_eyes_closed);
            }
            batcher.drawSprite(position.x - mouthOffsetX, position.y + mouthOffsetY, Assets.trump_mouth_01_left.width, Assets.trump_mouth_01_left.height, Assets.trump_mouth_01_left);
        } else if (playerState == WALL_RIGHT) {
            hairFlipAnimationTimer = 0;
            hairSettleAnimationTimer += 0.25f;

            batcher.drawSprite(position.x - bodyOffsetX, position.y + bodyOffsetY, Assets.trump_body_slide_left.width, Assets.trump_body_slide_left.height, Assets.trump_body_slide_left);

            TextureRegion keyFrame = Assets.trump_hair_settle_left.getKeyFrame(hairSettleAnimationTimer, Animation.ANIMATION_NONLOOPING);
            batcher.drawSprite(position.x - headOffsetX, position.y + headOffsetY, Assets.trump_head_01_left.width, Assets.trump_head_01_left.height, keyFrame);

            if (!resetBlinkTime) {
                batcher.drawSprite(position.x - eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_open.width, Assets.trump_eyes_open.height, Assets.trump_eyes_open);
            } else {
                batcher.drawSprite(position.x - eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_closed.width, Assets.trump_eyes_closed.height, Assets.trump_eyes_closed);
            }
            batcher.drawSprite(position.x - mouthOffsetX, position.y + mouthOffsetY, Assets.trump_mouth_01_left.width, Assets.trump_mouth_01_left.height, Assets.trump_mouth_01_left);
        } else if (playerState == WALL_LEFT) {
            hairFlipAnimationTimer = 0;
            hairSettleAnimationTimer += 0.25f;

            batcher.drawSprite(position.x + bodyOffsetX, position.y + bodyOffsetY, Assets.trump_body_slide_right.width, Assets.trump_body_slide_right.height, Assets.trump_body_slide_right);

            TextureRegion keyFrame = Assets.trump_hair_settle_right.getKeyFrame(hairSettleAnimationTimer, Animation.ANIMATION_NONLOOPING);
            batcher.drawSprite(position.x + headOffsetX, position.y + headOffsetY, Assets.trump_head_01_right.width, Assets.trump_head_01_right.height, keyFrame);

            if (!resetBlinkTime) {
                batcher.drawSprite(position.x + eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_open.width, Assets.trump_eyes_open.height, Assets.trump_eyes_open);
            } else {
                batcher.drawSprite(position.x + eyesOffsetX, position.y + eyesOffsetY, Assets.trump_eyes_closed.width, Assets.trump_eyes_closed.height, Assets.trump_eyes_closed);
            }
            batcher.drawSprite(position.x + mouthOffsetX, position.y + mouthOffsetY, Assets.trump_mouth_01_right.width, Assets.trump_mouth_01_right.height, Assets.trump_mouth_01_right);
        }

        batcher.endBatch();

        if (velocity.y < (-5.5f)) {
            if (playerState == WALL_RIGHT) {
                batcher.beginBatch(Assets.fenceTexture);
                TextureRegion keyFrame;
                keyFrame = Assets.dust_right.getKeyFrame(dustTimer, Animation.ANIMATION_LOOPING);
                batcher.drawSprite(position.x + dustOffsetX, position.y + dustOffsetY, Assets.dust_01.width, Assets.dust_01.height, keyFrame);
                dustTimer += 0.15f;
                batcher.endBatch();
                ;
            } else if (playerState == WALL_LEFT) {
                batcher.beginBatch(Assets.fenceTexture);
                TextureRegion keyFrame;
                keyFrame = Assets.dust_left.getKeyFrame(dustTimer, Animation.ANIMATION_LOOPING);
                batcher.drawSprite(position.x - dustOffsetX, position.y + dustOffsetY, Assets.dust_01.width, Assets.dust_01.height, keyFrame);
                dustTimer += 0.15f;
                batcher.endBatch();
            }
        }

        /*
        batcher.beginBatch(Assets.collisionLinesTexture);
        damageBounds.drawShape(batcher);
        wallBounds.drawShape(batcher);
        */
    }
}
