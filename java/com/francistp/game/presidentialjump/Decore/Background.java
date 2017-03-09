package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Francis on 2017-01-21.
 */
public class Background {

    private float x, y;
    private float startingHeight;
    private float scrollSpeed;
    private int initialLimit;
    private float whiteHouseOffset;
    Fireworks fireworks;
    Clouds clouds;

    private List<GameObjectRectangle> backgrounds;
    private float friction;

    private int backgroundCount;
    private int backgroundIntervalAmount;

    private int color;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int SIX = 6;
    private final int SEVEN = 7;
    private final int EIGHT = 8;
    private final int NINE = 9;

    private final int CLOUD_AMOUNT = 5;

    public Background(Fireworks fireworks) {

        this.fireworks = fireworks;

        x = 240;
        y = 400;
        startingHeight = y;
        scrollSpeed = -1.5f;

        whiteHouseOffset = 100;

        backgrounds = new LinkedList<GameObjectRectangle>();
        backgrounds.add(new GameObjectRectangle(x, startingHeight + Assets.background_01.height - 1, Assets.background_01.width, Assets.background_01.height, Assets.background_01));
        backgrounds.add(new GameObjectRectangle(x, startingHeight + (Assets.background_01.height*2) - 2, Assets.background_01.width, Assets.background_01.height, Assets.background_01));
        backgrounds.add(new GameObjectRectangle(x, startingHeight + (Assets.background_transition_01.height*3) - 3, Assets.background_transition_01.width, Assets.background_transition_01.height, Assets.background_transition_01));

        friction = 0.75f;

        initialLimit = -400;
        backgroundCount = 3;
        backgroundIntervalAmount = 2;

        color = ONE;
        clouds = new Clouds(color, CLOUD_AMOUNT);
    }

    public void update(float deltaTime) {
        if (y > initialLimit) {
            fireworks.update(deltaTime);
        }

    }

    public void scroll(float scrollSpeed) {
        clouds.update(color);
        y += scrollSpeed*friction;

        Iterator<GameObjectRectangle> backgroundsIterator = backgrounds.iterator();

        while (backgroundsIterator.hasNext()) {
            GameObjectRectangle background = backgroundsIterator.next();
            background.setPosition(background.x, background.y + (scrollSpeed * friction));
        }

        if (y > initialLimit) {
            fireworks.scroll(scrollSpeed * friction);
        }
        clouds.scroll(scrollSpeed * friction);
    }

    public void checkBackgrounds() {
        Iterator<GameObjectRectangle> backgroundsIterator = backgrounds.iterator();

        if (backgroundsIterator.hasNext()) {
            GameObjectRectangle backgroundToCheck = backgroundsIterator.next();
            if (backgroundToCheck.y < (0 - Assets.background_01.height/2)) {
                while (backgroundsIterator.hasNext()) {
                    backgroundToCheck = backgroundsIterator.next();
                }
                backgrounds.remove(0);

                TextureRegion textureToGive = null;
                if (backgroundCount < backgroundIntervalAmount) {
                    textureToGive = Assets.background_01;
                } else if (backgroundCount == backgroundIntervalAmount) {
                    textureToGive = Assets.background_transition_01;
                } else if (backgroundCount < backgroundIntervalAmount*2) {
                    textureToGive = Assets.background_02;
                } else if (backgroundCount == backgroundIntervalAmount*2) {
                    textureToGive = Assets.background_transition_02;
                } else if (backgroundCount < backgroundIntervalAmount*3) {
                    textureToGive = Assets.background_03;
                } else if (backgroundCount == backgroundIntervalAmount*3) {
                    textureToGive = Assets.background_transition_03;
                } else if (backgroundCount < backgroundIntervalAmount*4) {
                    textureToGive = Assets.background_04;
                } else if (backgroundCount == backgroundIntervalAmount*4) {
                    textureToGive = Assets.background_transition_04;
                } else if (backgroundCount < backgroundIntervalAmount*5) {
                    textureToGive = Assets.background_05;
                } else if (backgroundCount == backgroundIntervalAmount*5) {
                    textureToGive = Assets.background_transition_05;
                } else if (backgroundCount < backgroundIntervalAmount*6) {
                    textureToGive = Assets.background_06;
                } else if (backgroundCount == backgroundIntervalAmount*6) {
                    textureToGive = Assets.background_transition_06;
                } else if (backgroundCount < backgroundIntervalAmount*7) {
                    textureToGive = Assets.background_07;
                } else if (backgroundCount == backgroundIntervalAmount*7) {
                    textureToGive = Assets.background_transition_07;
                } else if (backgroundCount < backgroundIntervalAmount*8) {
                    textureToGive = Assets.background_08;
                } else if (backgroundCount == backgroundIntervalAmount*8) {
                    textureToGive = Assets.background_transition_08;
                } else if (backgroundCount < backgroundIntervalAmount*9) {
                    textureToGive = Assets.background_09;
                } else if (backgroundCount == backgroundIntervalAmount*9) {
                    textureToGive = Assets.background_transition_09;
                    backgroundCount = 0;
                }


                if (backgroundCount == backgroundIntervalAmount + backgroundIntervalAmount) {
                    color = TWO;
                } else if (backgroundCount == (backgroundIntervalAmount*2) + backgroundIntervalAmount) {
                    color = THREE;
                } else if (backgroundCount == (backgroundIntervalAmount*3) + backgroundIntervalAmount) {
                    color = FOUR;
                } else if (backgroundCount == (backgroundIntervalAmount*4) + backgroundIntervalAmount) {
                    color = FIVE;
                } else if (backgroundCount == (backgroundIntervalAmount*5) + backgroundIntervalAmount) {
                    color = SIX;
                } else if (backgroundCount == (backgroundIntervalAmount*6) + backgroundIntervalAmount) {
                    color = SEVEN;
                } else if (backgroundCount == (backgroundIntervalAmount*7) + backgroundIntervalAmount) {
                    color = EIGHT;
                } else if (backgroundCount == (backgroundIntervalAmount*8) + backgroundIntervalAmount) {
                    color = NINE;
                } else if (backgroundCount == (backgroundIntervalAmount*9) + backgroundIntervalAmount) {
                    color = ONE;
                }

                backgrounds.add(new GameObjectRectangle(x, backgroundToCheck.y + Assets.background_01.height - 1, Assets.background_01.width, Assets.background_01.height, textureToGive));

                backgroundCount++;
            }
        }
    }

    public void render(SpriteBatcher batcher) {

        if (y > initialLimit) {
            batcher.beginBatch(Assets.plainSkyAndGroundTexture);
            batcher.drawSprite(x, y, Assets.plainSkyAndGround.width, Assets.plainSkyAndGround.height, Assets.plainSkyAndGround);
            batcher.endBatch();

            batcher.beginBatch(Assets.fireworksTexture);
            fireworks.render(batcher);
            batcher.endBatch();

            batcher.beginBatch(Assets.whiteHouseTexture);
            batcher.drawSprite(x, y - whiteHouseOffset, Assets.whiteHouse.width, Assets.whiteHouse.height, Assets.whiteHouse);
            batcher.endBatch();
        }

        Iterator<GameObjectRectangle> backgroundsIterator = backgrounds.iterator();
        batcher.beginBatch(Assets.backgroundsTexture);
        while (backgroundsIterator.hasNext()) {
            GameObjectRectangle backgroundToRender = backgroundsIterator.next();
            batcher.drawSprite(backgroundToRender.x, backgroundToRender.y, backgroundToRender.textureRegion.width, backgroundToRender.textureRegion.height, backgroundToRender.textureRegion);
        }
        batcher.endBatch();

        clouds.render(batcher);
    }

}
