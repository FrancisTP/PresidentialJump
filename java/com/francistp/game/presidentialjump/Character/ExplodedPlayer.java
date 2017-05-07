package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-07.
 */
public class ExplodedPlayer {

    ExplodedPart[] explodedParts;

    public ExplodedPlayer(ExplodedPart[] explodedParts) {
        this.explodedParts = explodedParts;
    }

    public void update(float deltaTime) {
        for (int i=0; i<explodedParts.length; i++) {
            explodedParts[i].update(deltaTime);
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.trumpallbodyparts);
        for (int i = 0; i < explodedParts.length; i++) {
            explodedParts[i].render(batcher);
        }
        batcher.endBatch();
    }
}
