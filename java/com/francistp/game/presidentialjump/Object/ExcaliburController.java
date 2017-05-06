package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

/**
 * Created by Francis on 2017-05-05.
 */
public class ExcaliburController {

    private int state;
    public static final int MIDDLE = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int LEFT_TO_RIGHT = 3;
    public static final int RIGHT_TO_LEFT = 4;
    public static final int LEFT_THEN_RIGHT = 5;
    public static final int RIGHT_THEN_LEFT = 6;
    public static final int NOTHING = 7;

    private Excalibur[] excaliburs;
    private boolean isReady, start;

    public ExcaliburController() {
        excaliburs = new Excalibur[3];

        excaliburs[0] = new Excalibur(55);
        excaliburs[1] = new Excalibur(240);
        excaliburs[2] = new Excalibur(425);

        state = NOTHING;
        isReady = true;
        start = false;
    }

    public void update(float deltaTime) {
        isReady = true;
        for (int i=0; i < excaliburs.length; i++) {
            if (start && excaliburs[i].getState() != Excalibur.NOTHING && state != NOTHING) {
                excaliburs[i].update(deltaTime);
            }
        }

        if (excaliburs[0].getState() != Excalibur.NOTHING || excaliburs[1].getState() != Excalibur.NOTHING || excaliburs[2].getState() != Excalibur.NOTHING) {
            isReady = false;
        }
        if (isReady == true) {
            start = false;
            state = NOTHING;
        }
    }

    public void start() {
        start = true;
    }

    public void render(SpriteBatcher batcher) {
        for (int i=0; i<excaliburs.length; i++) {
            if (start && excaliburs[i].isReady()) {
                excaliburs[i].render(batcher);
            }
        }
    }

    public void setState(int state) {
        isReady = false;
        this.state = state;
        start = false;

        if (this.state == MIDDLE) {
            excaliburs[1].setState(Excalibur.AIM, 0);
        } else if (this.state == LEFT) {
            excaliburs[0].setState(Excalibur.AIM, 0);
        } else if (this.state == RIGHT) {
            excaliburs[2].setState(Excalibur.AIM, 0);
        } else if (this.state == LEFT_TO_RIGHT) {
            excaliburs[0].setState(Excalibur.AIM, 0);
            excaliburs[1].setState(Excalibur.AIM, 90);
            excaliburs[2].setState(Excalibur.AIM, 180);
        } else if (this.state == RIGHT_TO_LEFT) {
            excaliburs[0].setState(Excalibur.AIM, 180);
            excaliburs[1].setState(Excalibur.AIM, 90);
            excaliburs[2].setState(Excalibur.AIM, 0);
        } else if (this.state == LEFT_THEN_RIGHT) {
            excaliburs[0].setState(Excalibur.AIM, 0);
            excaliburs[2].setState(Excalibur.AIM, 90);
        } else if (this.state == RIGHT_THEN_LEFT) {
            excaliburs[0].setState(Excalibur.AIM, 90);
            excaliburs[2].setState(Excalibur.AIM, 0);
        } else {
            state = NOTHING;
        }
    }

    public boolean readyToStart() {
        return start;
    }

    public boolean getReady() {
        return isReady;
    }

    public int getState() {
        return state;
    }

    public Excalibur[] getExcaliburs() {
        return excaliburs;
    }
}
