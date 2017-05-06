package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-06.
 */
public class ExcaliburParticle {

    private float x, y;
    private float ySpeed;
    private float length, lengthReduction;
    private float liveTime;

    public ExcaliburParticle(float x) {
        //Min + (int)(Math.random() * ((Max - Min) + 1))
        this.x = x + ((0 + (int)(Math.random() * ((10 - 0) + 1))) - 5);
        y = 0 + (int)(Math.random() * ((800 - 0) + 1));
        ySpeed = 1 + (int)(Math.random() * ((4 - 1) + 1));

        length = 4 + (int)(Math.random() * ((10 - 4) + 1));
        liveTime = 2 + (int)(Math.random() * ((15 - 2) + 1));

        lengthReduction = length/liveTime;
    }

    public void reset() {
        x = x + ((0 + (int)(Math.random() * ((10 - 0) + 1))) - 5);
        y = 0 + (int)(Math.random() * ((800 - 0) + 1));
        ySpeed = 1 + (int)(Math.random() * ((4 - 1) + 1));

        length = 4 + (int)(Math.random() * ((10 - 4) + 1));
        liveTime = 2 + (int)(Math.random() * ((15 - 2) + 1));

        lengthReduction = length/liveTime;
    }

    public void update(float deltaTime) {
        if (liveTime <= 0) {
            reset();
        }

        length -= lengthReduction;
        if (length < 1) {
            length = 1;
        }

        liveTime--;
    }

    public void render(SpriteBatcher batcher) {
        batcher.drawSprite(x, y, length, length, Assets.excalibur_solid);
    }
}
