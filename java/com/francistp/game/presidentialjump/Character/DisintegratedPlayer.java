package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-07.
 */
public class DisintegratedPlayer {

    private DisintegrateParticle[] disintegratedParticles;

    public DisintegratedPlayer(DisintegrateParticle[] disintegratedParticles) {
        int disintegratedParticlesCount = 0;

        this.disintegratedParticles = disintegratedParticles;
    }

    public void update(float deltaTime) {
        for (int i=0; i<disintegratedParticles.length; i++) {
            disintegratedParticles[i].update(deltaTime);
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.trumpallbodyparts);
        for (int i = 0; i < disintegratedParticles.length; i++) {
            disintegratedParticles[i].render(batcher);
        }
        batcher.endBatch();
    }
}
