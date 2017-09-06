package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;
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

    private float gearAnimationCounter;

    public TwitterBoard(Text text, float y) {
        this.text = text;
        this.y = y;
        destroy = false;
        height = text.getBackgroundHeight();
        gearAnimationCounter = 0;
    }

    public void update(float deltaTime, float speed) {
        if (!destroy) {
            y += speed;
            text.addY(speed);
            gearAnimationCounter += 0.1f;
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

        batcher.beginBatch(Assets.textSpriteSheet);
        TextureRegion keyFrame = Assets.gear.getKeyFrame(gearAnimationCounter, Animation.ANIMATION_LOOPING);


        // top-left
        batcher.drawSprite(x - (Assets.twitter_board_top.width/2) + (Assets.gear_01.width/2) - 2, text.getBackgroundY() + (text.getBackgroundHeight()/2) + (Assets.twitter_board_top.height/2) + 10, Assets.gear_01.width, Assets.gear_01.height, keyFrame);
        // top-right
        batcher.drawSprite(x + (Assets.twitter_board_top.width/2) - (Assets.gear_01.width/2) + 2, text.getBackgroundY() + (text.getBackgroundHeight()/2) + (Assets.twitter_board_top.height/2) + 10, Assets.gear_01.width, Assets.gear_01.height, keyFrame);
        // top
        batcher.drawSprite(x, text.getBackgroundY() + (text.getBackgroundHeight()/2) + (Assets.twitter_board_top.height/2), Assets.twitter_board_top.width, Assets.twitter_board_top.height, Assets.twitter_board_top);

        // bottom-left
        batcher.drawSprite(x - (Assets.twitter_board_bottom.width/2) + (Assets.gear_01.width/2) - 2, text.getBackgroundY() - (text.getBackgroundHeight()/2) - (Assets.twitter_board_bottom.height/2) - 10, Assets.gear_01.width, Assets.gear_01.height, keyFrame);
        // bottom-right
        batcher.drawSprite(x + (Assets.twitter_board_bottom.width/2) - (Assets.gear_01.width/2) + 2, text.getBackgroundY() - (text.getBackgroundHeight()/2) - (Assets.twitter_board_bottom.height/2) - 10, Assets.gear_01.width, Assets.gear_01.height, keyFrame);
        // bottom
        batcher.drawSprite(x, text.getBackgroundY() - (text.getBackgroundHeight()/2) - (Assets.twitter_board_bottom.height/2), Assets.twitter_board_bottom.width, Assets.twitter_board_bottom.height, Assets.twitter_board_bottom);

        batcher.endBatch();
    }

}
