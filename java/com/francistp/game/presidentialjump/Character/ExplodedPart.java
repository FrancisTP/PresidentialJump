package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-07.
 */
public class ExplodedPart {

    private float x, y;
    private float xSpeed, ySpeed;
    private float gravity;
    private float width, height;

    public static final int LEFT = 0;
    public static final int TOP = 1;
    public static final int RIGHT = 2;
    public static final int BOTTOM = 3;
    public static final int ALL = 4;
    private int bloodOn;
    private TextureRegion sprite;
    private int bloodCounter;

    public ExplodedPart(float x, float y, int bloodOn, TextureRegion sprite) {
        this.x = x;
        this.y = y;
        this.bloodOn = bloodOn;
        this.sprite = sprite;

        if (this.bloodOn == LEFT) {
            xSpeed = 5 + (int)(Math.random() * ((10 - 5) + 1));
            ySpeed = (0 + (int)(Math.random() * ((5 - 0) + 1)));
        } else if (this.bloodOn == TOP) {
            xSpeed = (5 + (int)(Math.random() * ((10 - 5) + 1))) - 15;
            ySpeed = (0 + (int)(Math.random() * ((5 - 0) + 1)));
        } else if (this.bloodOn == RIGHT) {
            xSpeed = (-1)*(5 + (int)(Math.random() * ((10 - 5) + 1)));
            ySpeed = (0 + (int)(Math.random() * ((5 - 0) + 1)));
        } else if (this.bloodOn == BOTTOM) {
            xSpeed = (5 + (int)(Math.random() * ((10 - 5) + 1))) - 15;
            ySpeed = 5 + (int)(Math.random() * ((10 - 5) + 1));
        } else if (this.bloodOn == ALL) {
            xSpeed = (5 + (int)(Math.random() * ((10 - 5) + 1))) - 15;
            ySpeed = (0 + (int)(Math.random() * ((5 - 0) + 1)));
        }
        gravity = 0.15f;
        width = this.sprite.width;
        height = this.sprite.height;
        bloodCounter = 0;
    }

    public void update(float deltaTime) {
        if (y + height > 0) {
            x += xSpeed;
            y += ySpeed;
            ySpeed = ySpeed - gravity;

            if (x + (width/2) > 440 && xSpeed > 0) { // body part is leaving edge of game, make it switch sides
                xSpeed = (-1)*xSpeed;
            } else if (x - (width/2) < 40 && xSpeed < 0) {
                xSpeed = (-1)*xSpeed;
            }

            if (bloodCounter < 4) {
                bloodCounter++;
                BloodController.createBlood(x, y, bloodOn);
            } else if (bloodCounter > 6){
                bloodCounter = 0;
            } else {
                bloodCounter++;
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.drawSprite(x, y, width, height, sprite);
    }
}
