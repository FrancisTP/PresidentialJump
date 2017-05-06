package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Menues.GameScreen;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Francis on 2017-05-05.
 */
public class ObstaclesController {

    private ExcaliburController excaliburController;
    private boolean createNewObstacles;
    private int delay, delayCounter;
    private int obstacleInUse;
    private final int NONE = 0;
    private final int EXCALIBUR = 1;

    public ObstaclesController() {
        excaliburController = new ExcaliburController();
        obstacleInUse = NONE;
        createNewObstacles = true;
        delayCounter = 0;
        delay = 0;
    }

    public void update(float deltaTime) {

        if (GameScreen.gameStarted) {
            if (delay == 0 && obstacleInUse == NONE) {
                delay = 30 + (int)(Math.random() * ((120 - 30) + 1));
            } else {
                if (obstacleInUse == NONE) {
                    delayCounter++;
                }
                if (delayCounter > delay) {
                    if (obstacleInUse == NONE) {
                        //Min + (int)(Math.random() * ((Max - Min) + 1))
                        int randomNum = 0 + (int) (Math.random() * ((0 - 0) + 1));
                        // Check which obstacle to create
                        if (randomNum == 0) {
                            // choose type
                            randomNum = (int) (Math.random() * (6));

                            if (excaliburController.getReady()) {
                                if (randomNum == 0 || randomNum == 1) {
                                    excaliburController.setState(ExcaliburController.LEFT);
                                } else if (randomNum == 2 || randomNum == 3) {
                                    excaliburController.setState(ExcaliburController.RIGHT);
                                } else if (randomNum == 4) {
                                    excaliburController.setState(ExcaliburController.LEFT_THEN_RIGHT);
                                } else if (randomNum == 4) {
                                    excaliburController.setState(ExcaliburController.RIGHT_THEN_LEFT);
                                }
                                excaliburController.start();
                                obstacleInUse = EXCALIBUR;
                                delayCounter = 0;
                            }
                        }
                    }
                }
            }
            excaliburController.update(deltaTime);

            // check if obstacles are noLonger in use
            if (obstacleInUse == EXCALIBUR) {
                if (excaliburController.getReady()) {
                    obstacleInUse = NONE;
                }
            }
        }
    }

    public void setCreateNewObstacles(boolean createNewObstacles) {
        this.createNewObstacles = createNewObstacles;
    }

    public void render(SpriteBatcher batcher) {
        if (obstacleInUse == EXCALIBUR) {
            if (excaliburController.readyToStart()) {
                batcher.beginBatch(Assets.obstaclesTexture);
                excaliburController.render(batcher);
                batcher.endBatch();
            }
        }
    }

    public ExcaliburController getExcaliburController() {
        return excaliburController;
    }

}
