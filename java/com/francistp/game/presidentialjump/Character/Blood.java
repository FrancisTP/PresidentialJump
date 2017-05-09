package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-07.
 */
public class Blood {

    private float x, y;
    private float length;
    private float speedX, speedY;

    private static final float GRAVITY = 0.15f;
    private boolean destroy;

    public Blood(float x, float y, int direction) {
        this.x = x;
        this.y = y;

        length = Assets.trump_blood.width + (int)(Math.random() * ((Assets.trump_blood.width*5 - Assets.trump_blood.width) + 1));

        if (direction == ExplodedPart.LEFT) {
            speedX = (-1)*(1 + (int)(Math.random() * ((8 - 1) + 1)));
            speedY = 0;
        } else if (direction == ExplodedPart.TOP) {
            speedX = 0;
            speedY = 1 + (int)(Math.random() * ((15 - 1) + 1));
        } else if (direction == ExplodedPart.RIGHT) {
            speedX = 1 + (int)(Math.random() * ((8 - 1) + 1));
            speedY =  0;
        } else if (direction == ExplodedPart.BOTTOM) {
            speedX = 0;
            speedY =  (-1)*(1 + (int)(Math.random() * ((15 -1) + 1)));
        } else if (direction == ExplodedPart.ALL) {
            speedX = (1 + (int)(Math.random() * ((10 - 1) + 1))) - 5;
            speedY =  (1 + (int)(Math.random() * ((10 - 1) + 1))) - 5;
        }
        destroy = false;
    }

    public void update(float deltaTime) {
        if (x > 0 - length && x < 480 + length && y > 0 - length && y < 800 + length) {
            x += speedX;
            y += speedY;
            speedY -= GRAVITY;
            System.out.println("updating");
        } else {
            destroy = true;
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.drawSprite(x, y, length, length, Assets.trump_blood);
    }

    public boolean destroy() {
        return destroy;
    }
}
