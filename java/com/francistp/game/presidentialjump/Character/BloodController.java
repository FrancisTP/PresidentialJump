package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Francis on 2017-05-08.
 */
public class BloodController {

    private static Queue<Blood> bloods = new LinkedList<Blood>();
    private final static int MAX = 500;

    public BloodController() {
        bloods = new LinkedList<Blood>();
    }

    public static void createBlood(float x, float y, int direction) {
        if (bloods.size() >= MAX) {
            bloods.add(new Blood(x, y, direction));
            bloods.remove();
        } else {
            bloods.add(new Blood(x, y, direction));
        }
    }

    public static void update(float deltaTime) {
        Stack<Blood> bloodsToRemove = new Stack<Blood>();
        for (Blood blood : bloods) {
            blood.update(deltaTime);
            if(blood.destroy()) {
                bloodsToRemove.push(blood);
            }
        }

        for (Blood blood : bloodsToRemove) {
            bloods.remove(blood);
        }
    }

    public static void render(SpriteBatcher batcher) {
        if (bloods.size() > 0) {
            batcher.beginBatch(Assets.trumpallbodyparts);
            for (Blood blood : bloods) {
                blood.render(batcher);
            }
            batcher.endBatch();
        }
    }

    public static void clear() {
        bloods = new LinkedList<Blood>();
    }
}
