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
    private MissileController missileController;
    private boolean createNewObstacles;
    private int delay, delayCounter;
    private int obstacleInUse;
    public static final int BARRIER = -1;
    public static final int NONE = 0;
    public static final int EXCALIBUR = 1;
    public static final int MISSILE = 2;

    public ObstaclesController() {
        excaliburController = new ExcaliburController();
        missileController = new MissileController();
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
                    if (obstacleInUse == NONE && GameScreen.state != GameScreen.FINISHED_STATE) {
                        //Min + (int)(Math.random() * ((Max - Min) + 1))
                        int randomNum = 0 + (int)(Math.random() * ((1 - 0) + 1));
                        // Check which obstacle to create
                        if (randomNum == 0) {//randomNum == 0
                            // choose type
                            randomNum = (int) (Math.random() * (2));

                            if (excaliburController.getReady()) {
                                if (randomNum == 0) {// randomNum == 1) {
                                    excaliburController.setState(ExcaliburController.LEFT);
                                } else if (randomNum == 1) {// || randomNum == 3) {
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
                        } else if (randomNum == 1) {//randomNum == 1
                            randomNum = MissileController.LEFT_TO_RIGHT + (int)(Math.random() * ((MissileController.RIGHT_TO_LEFT - MissileController.LEFT_TO_RIGHT) + 1));

                            if (missileController.isReady()) {
                                if (randomNum == 1) {
                                    missileController.setState(MissileController.LEFT);
                                } else if (randomNum == 2) {
                                    missileController.setState(MissileController.MIDDLE);
                                } else if (randomNum == 3) {
                                    missileController.setState(MissileController.RIGHT);
                                } else if (randomNum == 4) {
                                    missileController.setState(MissileController.LEFT_THEN_RIGHT);
                                } else if (randomNum == 5) {
                                    missileController.setState(MissileController.RIGHT_THEN_LEFT);
                                } else if (randomNum == 6) {
                                    missileController.setState(MissileController.LEFT_TO_RIGHT);
                                } else if (randomNum == 7) {
                                    missileController.setState(MissileController.RIGHT_TO_LEFT);
                                }
                                missileController.start();
                                obstacleInUse = MISSILE;
                                delayCounter = 0;
                            }
                        }
                    }
                }
            }
            excaliburController.update(deltaTime);
            missileController.update(deltaTime);

            // check if obstacles are noLonger in use
            if (obstacleInUse == EXCALIBUR) {
                if (excaliburController.getReady()) {
                    obstacleInUse = NONE;
                }
            } else if (obstacleInUse == MISSILE) {
                if (missileController.isReady()) {
                    obstacleInUse = NONE;
                }
            }
        }
    }

    public void setCreateNewObstacles(boolean createNewObstacles) {
        this.createNewObstacles = createNewObstacles;
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.obstaclesTexture);
        batcher.drawSprite(-1, -1, 1, 1, Assets.reduntant);
        if (obstacleInUse == EXCALIBUR) {
            if (excaliburController.readyToStart()) {
                excaliburController.render(batcher);
            }
        } else if (obstacleInUse == MISSILE) {
            if (missileController.readyToStart()) {
                missileController.render(batcher);
            }
        }
        batcher.endBatch();
    }

    public ExcaliburController getExcaliburController() {
        return excaliburController;
    }

    public MissileController getMissileController() {
        return missileController;
    }

}
