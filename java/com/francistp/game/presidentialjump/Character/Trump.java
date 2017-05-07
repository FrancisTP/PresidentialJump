package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.framework.math.Rectangle;
import com.francistp.game.framework.math.Vector2;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Object.ObstaclesController;

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

    private DisintegratedPlayer disintegratedPlayer;
    private ExplodedPlayer explodedPlayer;
    private boolean createdDeadPlayer;

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
        damageBounds = new GameObjectRectangle(position.x - bodyOffsetX, position.y - bodyOffsetY + 10, 25, 70);

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
        createdDeadPlayer = false;
    }

    @Override
    public void update(float deltaTime) {
        if (!dead) {
            handWobble += 0.05;
            if (handWobble >= 360)
                handWobble -= 360;
            handOffsetY = handDefaultOffsetY + ((float) Math.sin(handWobble));

            blinkCounter++;

            if (blinkCounter > blinkIntervalTime && !resetBlinkTime) {
                resetBlinkTime = true;
                blinkCounter = 0;
            } else if (blinkCounter > blinkTime && resetBlinkTime) {
                resetBlinkTime = false;
                blinkCounter = 0;
                blinkIntervalTime = minBlinkTime + (int) (Math.random() * ((maxBlinkTime - minBlinkTime) + 1));
            }
            dustTimer += 0.15f;
            updatePlayer(deltaTime);
            wallBounds.setPosition(position.x - bodyOffsetX, position.y - bodyOffsetY);
            damageBounds.setPosition(position.x - bodyOffsetX, position.y - bodyOffsetY + 10);
        } else {
            if (deathCause == ObstaclesController.EXCALIBUR) {
                // EXCALIBUR
                // CREATE DISINTEGRATED PLAYER
                if (!createdDeadPlayer) {
                    createdDeadPlayer = true;
                    // beginning and end are only 1 wide
                    // create a matrix to populate the pixel disentigration thing
                    // 24 high, 19 across
                    //height, 16th and 24th 1pxl high instead of 6
                    //width, 2nd and 19th 1pxl wide instead of 6
                    String[] pixelMatrix = new String[24];
                    pixelMatrix[0] =  "0000111111111100000";   // 1
                    pixelMatrix[1] =  "0001111111111110111";   // 2
                    pixelMatrix[2] =  "0011111111111111111";   // 3
                    pixelMatrix[3] =  "1111111111111110100";   // 4
                    pixelMatrix[4] =  "1111111111111100000";   // 5
                    pixelMatrix[5] =  "1111111111111100000";   // 6
                    pixelMatrix[6] =  "1111111111111100000";   // 7
                    pixelMatrix[7] =  "1111111111111000000";   // 8
                    pixelMatrix[8] =  "1111111111111000000";   // 9
                    pixelMatrix[9] =  "1111111111111000000";   // 10
                    pixelMatrix[10] = "0011111111111000000";   // 11
                    pixelMatrix[11] = "0001111111111000000";   // 12
                    pixelMatrix[12] = "0001111111110000000";   // 13
                    pixelMatrix[13] = "0000111111100000000";   // 14
                    pixelMatrix[14] = "0000001110000000000";   // 15
                    pixelMatrix[15] = "0000011111000000000";   // 16
                    pixelMatrix[16] = "0000111111100000000";   // 17
                    pixelMatrix[17] = "0000111111100000000";   // 18
                    pixelMatrix[18] = "0000111111100000000";   // 19
                    pixelMatrix[19] = "0000011111000000000";   // 20
                    pixelMatrix[20] = "0000011011000000000";   // 21
                    pixelMatrix[21] = "0000011011000000000";   // 22
                    pixelMatrix[22] = "0000011011000000000";   // 23
                    pixelMatrix[23] = "0000011011000000000";   // 24

                    float xOffest = -40;
                    float yOffset = 75;
                    if (playerState == JUMP_LEFT || playerState == WALL_RIGHT) { // if player is facing left, switch matrix side
                        xOffest = -65;
                        for (int i = 0; i < pixelMatrix.length; i++) {
                            pixelMatrix[i] = new StringBuilder(pixelMatrix[i]).reverse().toString();
                        }
                    }

                    int disintegratedParticlesCount = 0;

                    for (int i = 0; i < pixelMatrix.length; i++) {
                        char[] lineMatrix = pixelMatrix[i].toCharArray();
                        for (int r = 0; r < lineMatrix.length; r++) {
                            if (lineMatrix[r] == '1') {
                                disintegratedParticlesCount++;
                            }
                        }
                    }

                    DisintegrateParticle[] disintegratedParticles = new DisintegrateParticle[disintegratedParticlesCount];
                    disintegratedParticlesCount = 0;

                    float yPosition = position.y;

                    for (int i = 0; i < pixelMatrix.length; i++) {
                        char[] lineMatrix = pixelMatrix[i].toCharArray();
                        float xPosition = position.x;
                        for (int r = 0; r < lineMatrix.length; r++) {
                            if (lineMatrix[r] == '1') {
                                //height, 16th and 24th 1pxl high instead of 6
                                //width, 2nd and 19th 1pxl wide instead of 6
                                if (i == 15 || i == 23) { // height is 1
                                    if (r == 1 || r == 18) { // width  is 1
                                        disintegratedParticles[disintegratedParticlesCount] = new DisintegrateParticle((xPosition + 0.5f) + xOffest, (yPosition - 0.5f) + yOffset, 1, 1);
                                    } else { // width is 6
                                        disintegratedParticles[disintegratedParticlesCount] = new DisintegrateParticle((xPosition + 3) + xOffest, (yPosition - 0.5f) + yOffset, 6, 1);
                                    }
                                } else {    // height is 6
                                    if (r == 1 || r == 18) { // width is 1
                                        disintegratedParticles[disintegratedParticlesCount] = new DisintegrateParticle((xPosition + 0.5f) + xOffest, (yPosition - 3) + yOffset, 1, 6);
                                    } else { // width is 6
                                        disintegratedParticles[disintegratedParticlesCount] = new DisintegrateParticle((xPosition + 3) + xOffest, (yPosition - 3) + yOffset, 6, 6);
                                    }
                                }
                                disintegratedParticlesCount++;
                            }
                            if (r == 1 || r == 18) {
                                xPosition += 1;  // one pixel wide
                            } else {
                                xPosition += 6;  // six pixel wide
                            }
                        }
                        if (i == 15 || i == 23) {
                            yPosition -= 1; // one pixel high
                        } else {
                            yPosition -= 6; // six pixel high
                        }
                    }
                    disintegratedPlayer = new DisintegratedPlayer(disintegratedParticles);
                }
                disintegratedPlayer.update(deltaTime);
            } else if (deathCause == ObstaclesController.MISSILE) {
                // MISSILES
                if (!createdDeadPlayer) {
                    createdDeadPlayer = true;
                    //ExplodedPart head, body, leftLeg, rightLeg, leftArm, rightArm;
                    ExplodedPart head = null;
                    ExplodedPart body = null;
                    ExplodedPart leftLeg = null;
                    ExplodedPart rightLeg = null;
                    ExplodedPart leftArm = null;
                    ExplodedPart rightArm = null;
                    if (playerState == JUMP_LEFT || playerState == WALL_RIGHT) {
                        head = new ExplodedPart(position.x, position.y, ExplodedPart.BOTTOM, Assets.trump_head_dead_left);
                        body = new ExplodedPart(position.x, position.y, ExplodedPart.ALL, Assets.trump_body_dead_left);
                        leftLeg = new ExplodedPart(position.x, position.y, ExplodedPart.TOP, Assets.trump_leg_dead_left);
                        rightLeg = new ExplodedPart(position.x, position.y, ExplodedPart.TOP, Assets.trump_leg_dead_left);
                        leftArm = new ExplodedPart(position.x, position.y, ExplodedPart.TOP, Assets.trump_arm_dead);
                        rightArm = new ExplodedPart(position.x, position.y, ExplodedPart.RIGHT, Assets.trump_hand_dead_left);
                    } else if (playerState == JUMP_RIGHT || playerState == WALL_LEFT) {
                        head = new ExplodedPart(position.x, position.y, ExplodedPart.BOTTOM, Assets.trump_head_dead_right);
                        body = new ExplodedPart(position.x, position.y, ExplodedPart.ALL, Assets.trump_body_dead_right);
                        leftLeg = new ExplodedPart(position.x, position.y,ExplodedPart.TOP, Assets.trump_leg_dead_right);
                        rightLeg = new ExplodedPart(position.x, position.y,  ExplodedPart.TOP, Assets.trump_leg_dead_right);
                        leftArm = new ExplodedPart(position.x, position.y, ExplodedPart.TOP, Assets.trump_arm_dead);
                        rightArm = new ExplodedPart(position.x, position.y, ExplodedPart.LEFT, Assets.trump_hand_dead_right);
                    }

                    ExplodedPart[] explodedParts = new ExplodedPart[] {head, body, leftLeg, rightLeg, leftArm, rightArm};
                    explodedPlayer = new ExplodedPlayer(explodedParts);
                }
                explodedPlayer.update(deltaTime);
            }
        }
    }

    @Override
    public void render(SpriteBatcher batcher) {

        if (!dead) {
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
                    //dustTimer += 0.15f;
                    batcher.endBatch();
                } else if (playerState == WALL_LEFT) {
                    batcher.beginBatch(Assets.fenceTexture);
                    TextureRegion keyFrame;
                    keyFrame = Assets.dust_left.getKeyFrame(dustTimer, Animation.ANIMATION_LOOPING);
                    batcher.drawSprite(position.x - dustOffsetX, position.y + dustOffsetY, Assets.dust_01.width, Assets.dust_01.height, keyFrame);
                    //dustTimer += 0.15f;
                    batcher.endBatch();
                }
            }
        } else {    // DEAD
            if (deathCause == ObstaclesController.EXCALIBUR) {
                if (createdDeadPlayer) {
                    disintegratedPlayer.render(batcher);
                }
            } else if (deathCause == ObstaclesController.MISSILE) {
                if (createdDeadPlayer) {
                    explodedPlayer.render(batcher);
                }
            }
        }

        /*
        batcher.beginBatch(Assets.collisionLinesTexture);
        damageBounds.drawShape(batcher);
        batcher.endBatch();
        */


        //batcher.beginBatch(Assets.collisionLinesTexture);
        //damageBounds.drawShape(batcher);
        //wallBounds.drawShape(batcher);

    }
}
