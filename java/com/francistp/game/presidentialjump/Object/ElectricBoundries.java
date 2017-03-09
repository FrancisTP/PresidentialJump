package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by franc on 2017-03-03.
 */

public class ElectricBoundries {

    private float topX, topY;
    private float bottomX, bottomY;

    public ElectricBoundries() {
        topX = 240;
        topY = 810;

        bottomX = 240;
        bottomY = -10;
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.electricBoundry);

        batcher.endBatch();
    }
}
