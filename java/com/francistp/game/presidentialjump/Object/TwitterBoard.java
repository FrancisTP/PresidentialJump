package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Text;

/**
 * Created by Francis on 2017-05-18.
 */
public class TwitterBoard {

    private Text text;
    private float y;
    private float height;

    private final float x = 240;
    public static final float width = 400;
    private boolean destroy;

    public TwitterBoard(Text text, float y) {
        this.text = text;
        this.y = y;
        destroy = false;
        height = text.getBackgroundHeight();
    }

    public void update(float deltaTime, float speed) {
        if (!destroy) {
            y += speed;
            text.addY(speed);
        }

        if ((speed > 0 && y - height > 800) || (speed < 0 && y + height < 0)) {
            destroy = true;
        }
    }

    public boolean destroy() {
        return destroy;
    }

    public void render(SpriteBatcher batcher) {
        text.render(batcher);
    }

}
