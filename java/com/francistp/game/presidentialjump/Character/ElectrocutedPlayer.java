package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-13.
 */
public class ElectrocutedPlayer {

    private TextureRegion[] electricity;
    private TextureRegion[] playerPositions;

    private float x, y;
    private int positionCounter, electricityCounter, electrocutedCounter;
    private final int positionTime = 10;
    private final int electricityTime = 2;
    private final int electrocuedTime = 100;
    private final float speedY = -10;
    private final float angleSpeed = -8;

    private int currentPosition;
    private int currentElectricity;
    private float angle;

    public ElectrocutedPlayer(float x, float y, TextureRegion playerWallLeft, TextureRegion playerJumpRight, TextureRegion playerWallRight, TextureRegion playerJumpLeft, TextureRegion[] electricity, int playerState) {
        this.x = x;
        this.y = y;
        this.playerPositions = new TextureRegion[] {playerWallLeft, playerJumpRight, playerWallRight, playerJumpLeft};
        this.electricity = electricity;

        positionCounter = 0;
        electricityCounter = 0;
        electrocutedCounter = 0;

        if (playerState == Player.WALL_LEFT) {
            currentPosition = 0;
        } else if (playerState == Player.JUMP_RIGHT) {
            currentPosition = 1;
        } else if (playerState == Player.WALL_RIGHT) {
            currentPosition = 2;
        } else if (playerState == Player.JUMP_LEFT) {
            currentPosition = 3;
        }
        newElectricity();
        angle = 360;
    }

    public void update(float deltaTime) {
        if (electrocutedCounter < electrocuedTime) {
            electrocutedCounter++;

            if (positionCounter < positionTime) {
                positionCounter++;
            } else {
                positionCounter = 0;
                newPosition();
            }

            if (electricityCounter < electricityTime) {
                electricityCounter++;
            } else {
                electricityCounter = 0;
                newElectricity();
            }
        } else {
            if (y + playerPositions[currentPosition].height > 0) {
                y += speedY;
                angle += angleSpeed;
                if (angle <= 0) {
                    angle += 360;
                }
                // might take out
                if (electricityCounter < electricityTime) {
                    electricityCounter++;
                } else {
                    electricityCounter = 0;
                    newElectricity();
                }
            }
        }
    }

    private void newPosition() {
        currentPosition = 0 + (int)(Math.random() * ((3 - 0) + 1));
        int angleInt = 0 + (int)(Math.random() * ((3 - 0) + 1));
        if (angleInt == 0) {
            angle = 0;
        } else if (angleInt == 1) {
            angle = 90;
        } else if (angleInt == 2) {
            angle = 180;
        } else if (angleInt == 3) {
            angle = 270;
        }
    }

    private void newElectricity() {
        currentElectricity = 0 + (int)(Math.random() * (((electricity.length - 1) - 0) + 1));
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.trumpallbodyparts);
        batcher.drawSprite(x, y, playerPositions[currentPosition].width, playerPositions[currentPosition].height, angle, playerPositions[currentPosition]);
        if (electrocutedCounter < electrocuedTime) {
            batcher.drawSprite(x, y, electricity[currentElectricity].width, electricity[currentElectricity].height, angle, electricity[currentElectricity]);
        }
        batcher.endBatch();
    }
}
