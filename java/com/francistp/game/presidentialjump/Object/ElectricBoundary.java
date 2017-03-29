package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by franc on 2017-03-03.
 */

public class ElectricBoundary {

    private float x, y;
    private float stateTime;
    private GameObjectRectangle bounds;

    public ElectricBoundary(float x, float y) {
        this.x = x;
        this.y = y;

        bounds = new GameObjectRectangle(this.x, this.y, Assets.electric_boundry_01.width, Assets.electric_boundry_01.height);
        stateTime = 0;
    }

    public void update() {
        stateTime += 0.20f;

    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.electricBoundry);

        TextureRegion keyFrame = Assets.electric_boundry.getKeyFrame(stateTime, Animation.ANIMATION_LOOPING);
        batcher.drawSprite(x, y, Assets.electric_boundry_01.width, Assets.electric_boundry_01.height, keyFrame);

        batcher.endBatch();

        /*
        batcher.beginBatch(Assets.collisionLinesTexture);
        bounds.drawShape(batcher);
        batcher.endBatch();
        */
    }

    public GameObjectRectangle getBounds() {
        return bounds;
    }

    public void addY(float amount) {
        this.y += amount;
        bounds.setPosition(this.x, this.y);
    }

    public void setY (float y) {
        this.y = y;
        bounds.setPosition(this.x, this.y);
    }

    public float getY() {
        return y;
    }
}
