package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.gl.SpriteBatcher;

/**
 * Created by Francis on 2017-05-06.
 */
public class MissileController {

    private Missile[] missiles;
    public static int NOTHING = 0;
    public static final int LEFT = 1;
    public static final int MIDDLE = 2;
    public static final int RIGHT = 3;
    public static final int LEFT_THEN_RIGHT = 4;
    public static final int RIGHT_THEN_LEFT = 5;
    public static final int LEFT_TO_RIGHT = 6;
    public static final int RIGHT_TO_LEFT = 7;
    private int state;
    private boolean ready, start;

    public MissileController() {
        state = NOTHING;

        missiles = new Missile[3];
        missiles[0] = new Missile(55, 1);
        missiles[1] = new Missile(240, 2);
        missiles[2] = new Missile(425, 3);

        ready = true;
        start = false;
    }

    public void setState(int state) {
        this.state = state;
        ready = false;

        if (this.state == LEFT) { //this.state == LEFT
            missiles[0].start(0);
        } else if (this.state == MIDDLE) { //this.state == MIDDLE
            missiles[1].start(0);
        } else if (this.state == RIGHT) { //this.state == RIGHT
            missiles[2].start(0);
        } else if (this.state == LEFT_TO_RIGHT) {
            missiles[0].start(0);
            missiles[1].start(70);
            missiles[2].start(140);
        } else if (this.state == RIGHT_TO_LEFT) {
            missiles[0].start(140);
            missiles[1].start(70);
            missiles[2].start(0);
        } else if (this.state == LEFT_THEN_RIGHT) {
            missiles[0].start(0);
            missiles[2].start(70);
        } else if (this.state == RIGHT_THEN_LEFT) {
            missiles[0].start(70);
            missiles[2].start(0);
        }  else {
            state = NOTHING;
        }
    }

    public int getState() {
        return state;
    }

    public void update(float deltaTime) {
        if (state != NOTHING) {
            ready = true;
            for (int i=0; i<missiles.length; i++) {
                if (!missiles[i].isReady()) {
                    ready = false;
                    break;
                }
            }

            if (ready) {
                start = false;
            }

            if (start) {
                // do your shit
                for (int i=0; i <missiles.length; i++) {
                    if (!missiles[i].isReady()) {
                        missiles[i].update(deltaTime);
                    }
                }
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        for (int i=0; i<missiles.length; i++) {
            if (!missiles[i].isReady()) {
                missiles[i].render(batcher);
            }
        }
    }

    public boolean isReady() {
        return ready;
    }

    public void start() {
        start = true;
    }

    public boolean readyToStart() {
        return start;
    }
    public Missile[] getMissiles() {
        return missiles;
    }
}
