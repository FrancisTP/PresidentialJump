package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-01-23.
 */
public class Clouds {

    private int amount;
    private int maxAmount;

    private Cloud[] clouds;

    public Clouds(int color) {
        maxAmount = 5;

        clouds = new Cloud[maxAmount];

        for (int i=0; i< maxAmount; i++) {
            clouds[i] = new Cloud(color);
        }
    }

    public Clouds(int color, int maxAmount) {
        this.maxAmount = maxAmount;

        clouds = new Cloud[maxAmount];

        for (int i=0; i< maxAmount; i++) {
            clouds[i] = new Cloud(color);
        }
        sortCloudsBySize();
    }

    public void update(int color) {
        for (int i=0; i < maxAmount; i++) {
            clouds[i].update(color);
        }

        sortCloudsBySize();
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.cloudsTexture);
        for (int i=0; i < maxAmount; i++) {
            clouds[i].render(batcher);
        }
        batcher.endBatch();
    }

    public void scroll(float amount) {
        for (int i=0; i < maxAmount; i++) {
            clouds[i].scroll(amount);
        }
    }

    public void sortCloudsBySize() {
        Cloud[] sortedClouds = new Cloud[maxAmount];

        int cloudUsed = 0;
        int c = 0;
        Cloud cloudToAdd = null;
        while (c < maxAmount) {
            for (int i = 0; i < maxAmount; i++) {
                if (i == 0) {
                    cloudToAdd = clouds[i];
                    cloudUsed = 0;
                } else {
                    if (cloudToAdd == null && clouds[i] != null) {
                        cloudToAdd = clouds[i];
                        cloudUsed = i;
                    } else if (clouds[i] != null && clouds[i].textureRegion.width < cloudToAdd.textureRegion.width) {
                        cloudToAdd = clouds[i];
                        cloudUsed = i;
                    }
                }
            }
            sortedClouds[c] = cloudToAdd;
            clouds[cloudUsed] = null;
            c++;
        }
        clouds = sortedClouds;
        sortedClouds = null;
    }
}
