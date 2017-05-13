package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-07.
 */
public class DisintegrateParticle {

    private float x, y;
    private float width, height;
    private float speed, speedUp;
    private int delay, delayCounter;

    public DisintegrateParticle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        speed = (-1)*(5 + (int)(Math.random() * ((10 - 5) + 1)));
        speedUp = 1.02f;
        delay = (7 + (int)(Math.random() * ((25 - 7) + 1)));
        delayCounter = 0;
    }

    public void update(float deltaTime) {
        if (delayCounter < delay) {
            delayCounter++;
        } else {
            if (y + height > 0) {
                y += speed;
                speed = speed*speedUp;
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.drawSprite(x, y, width, height, Assets.trump_disintegrate_block);
    }
}
