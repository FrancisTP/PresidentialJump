package com.francistp.game.presidentialjump.Decore;

import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.presidentialjump.Assets.Assets;

import java.util.Random;

/**
 * Created by Francis on 2017-01-23.
 */
public class Cloud {
    float stateTime;

    private float x, y;
    private float initialSpawningX1 = 50;
    private float initialSpawningX2 = 550;
    private float initialSpawningY1 = 900;
    private float spawningY1 = 50;
    private float spawningY2 = 1600;

    private float speed;
    private float minSpeed = 0.2f;
    private float maxSpeed = 1.5f;
    private int startDelay;
    private int counter;

    Random rand = new Random();

    private boolean isRunning = true;

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

    private int size;
    private final int SMALL_ONE = 1;
    private final int SMALL_TWO = 4;
    private final int MEDIUM_ONE = 2;
    private final int MEDIUM_TWO= 5;
    private final int BIG = 3;

    private int direction;
    private final int LEFT = 1;
    private final int RIGHT = 2;

    private final int waitTime = 4;
    private int sizeMultiplier;

    public TextureRegion textureRegion;

    public Cloud(int color) {
        stateTime = 0;

        x = rand.nextFloat() * (initialSpawningX2 - initialSpawningX1) + initialSpawningX1;
        y = rand.nextFloat() * (spawningY2 - initialSpawningY1) + initialSpawningY1;
        speed = rand.nextFloat() * (maxSpeed - minSpeed) + minSpeed;

        size = 1 + (int)(Math.random() * ((5 - 1) + 1));
        direction =  1 + (int)(Math.random() * ((2 - 1) + 1));

        startDelay = 60 + (int)(Math.random() * (((waitTime*60) - 60) + 1));
        counter = 0;

        this.color = color;

        if (size == SMALL_ONE || size == SMALL_TWO ) {
            speed = speed * 0.5f;
            sizeMultiplier = 1;
        } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
            sizeMultiplier = 3;
            speed = speed * 0.8f;
            x += 150;
        } else if (size == BIG) {
            speed = speed * 1.2f;
            sizeMultiplier = 6;
            x += 300;
        }

        if (color == ONE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_01_small_left;
                } else {
                    textureRegion = Assets.cloud_01_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_01_medium_left;
                } else {
                    textureRegion = Assets.cloud_01_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_01_big_left;
                } else {
                    textureRegion = Assets.cloud_01_big_right;
                }
            }
        } else if (color == TWO) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_02_small_left;
                } else {
                    textureRegion = Assets.cloud_02_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_02_medium_left;
                } else {
                    textureRegion = Assets.cloud_02_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_02_big_left;
                } else {
                    textureRegion = Assets.cloud_02_big_right;
                }
            }
        } else if (color == THREE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_03_small_left;
                } else {
                    textureRegion = Assets.cloud_03_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_03_medium_left;
                } else {
                    textureRegion = Assets.cloud_03_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_03_big_left;
                } else {
                    textureRegion = Assets.cloud_03_big_right;
                }
            }
        } else if (color == FOUR) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_04_small_left;
                } else {
                    textureRegion = Assets.cloud_04_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_04_medium_left;
                } else {
                    textureRegion = Assets.cloud_04_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_04_big_left;
                } else {
                    textureRegion = Assets.cloud_04_big_right;
                }
            }
        } else if (color == FIVE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_05_small_left;
                } else {
                    textureRegion = Assets.cloud_05_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_05_medium_left;
                } else {
                    textureRegion = Assets.cloud_05_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_05_big_left;
                } else {
                    textureRegion = Assets.cloud_05_big_right;
                }
            }
        } else if (color == SIX) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_06_small_left;
                } else {
                    textureRegion = Assets.cloud_06_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_06_medium_left;
                } else {
                    textureRegion = Assets.cloud_06_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_06_big_left;
                } else {
                    textureRegion = Assets.cloud_06_big_right;
                }
            }
        } else if (color == SEVEN) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_07_small_left;
                } else {
                    textureRegion = Assets.cloud_07_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_07_medium_left;
                } else {
                    textureRegion = Assets.cloud_07_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_07_big_left;
                } else {
                    textureRegion = Assets.cloud_07_big_right;
                }
            }
        } else if (color == EIGHT) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_08_small_left;
                } else {
                    textureRegion = Assets.cloud_08_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_08_medium_left;
                } else {
                    textureRegion = Assets.cloud_08_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_08_big_left;
                } else {
                    textureRegion = Assets.cloud_08_big_right;
                }
            }
        } else if (color == NINE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_09_small_left;
                } else {
                    textureRegion = Assets.cloud_09_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_09_medium_left;
                } else {
                    textureRegion = Assets.cloud_09_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_09_big_left;
                } else {
                    textureRegion = Assets.cloud_09_big_right;
                }
            }
        }
    }

    public void update(int color){
        //this.stateTime += deltaTime;
        counter++;

        if (counter > startDelay && !isRunning) {
            isRunning = true;
        }
        if (isRunning) {
            x -= speed;
            if (size == SMALL_ONE || size == SMALL_TWO) {
                if (x < -160 || y < -100) {
                    restart(color);
                }
            } else if (size == MEDIUM_ONE ||size == MEDIUM_TWO) {
                if (x < -250 || y < -250) {
                    restart(color);
                }
            } else if (size == BIG) {
                if (x < -350 || y < -350) {
                    restart(color);
                }
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.drawSprite(x, y, textureRegion.width*sizeMultiplier, textureRegion.height*sizeMultiplier, textureRegion);
    }

    private void restart(int color) {
        stateTime = 0;
        isRunning = true;

        x = 550;
        y = rand.nextFloat() * (spawningY2 - spawningY1) + spawningY1;
        speed = rand.nextFloat() * (maxSpeed - minSpeed) + minSpeed;

        size = 1 + (int)(Math.random() * ((5 - 1) + 1));
        direction =  1 + (int)(Math.random() * ((2 - 1) + 1));
        startDelay = 60 + (int)(Math.random() * (((waitTime*60) - 60) + 1));
        counter = 0;

        this.color = color;

        if (size == SMALL_ONE || size == SMALL_TWO ) {
            speed = speed * 0.8f;
            sizeMultiplier = 1;
        } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
            sizeMultiplier = 3;
            x += 150;
        } else if (size == BIG) {
            speed = speed * 1.2f;
            sizeMultiplier = 6;
            x += 300;
        }

        if (color == ONE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_01_small_left;
                } else {
                    textureRegion = Assets.cloud_01_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_01_medium_left;
                } else {
                    textureRegion = Assets.cloud_01_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_01_big_left;
                } else {
                    textureRegion = Assets.cloud_01_big_right;
                }
            }
        } else if (color == TWO) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_02_small_left;
                } else {
                    textureRegion = Assets.cloud_02_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_02_medium_left;
                } else {
                    textureRegion = Assets.cloud_02_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_02_big_left;
                } else {
                    textureRegion = Assets.cloud_02_big_right;
                }
            }
        } else if (color == THREE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_03_small_left;
                } else {
                    textureRegion = Assets.cloud_03_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_03_medium_left;
                } else {
                    textureRegion = Assets.cloud_03_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_03_big_left;
                } else {
                    textureRegion = Assets.cloud_03_big_right;
                }
            }
        } else if (color == FOUR) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_04_small_left;
                } else {
                    textureRegion = Assets.cloud_04_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_04_medium_left;
                } else {
                    textureRegion = Assets.cloud_04_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_04_big_left;
                } else {
                    textureRegion = Assets.cloud_04_big_right;
                }
            }
        } else if (color == FIVE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_05_small_left;
                } else {
                    textureRegion = Assets.cloud_05_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_05_medium_left;
                } else {
                    textureRegion = Assets.cloud_05_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_05_big_left;
                } else {
                    textureRegion = Assets.cloud_05_big_right;
                }
            }
        } else if (color == SIX) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_06_small_left;
                } else {
                    textureRegion = Assets.cloud_06_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_06_medium_left;
                } else {
                    textureRegion = Assets.cloud_06_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_06_big_left;
                } else {
                    textureRegion = Assets.cloud_06_big_right;
                }
            }
        } else if (color == SEVEN) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_07_small_left;
                } else {
                    textureRegion = Assets.cloud_07_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_07_medium_left;
                } else {
                    textureRegion = Assets.cloud_07_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_07_big_left;
                } else {
                    textureRegion = Assets.cloud_07_big_right;
                }
            }
        } else if (color == EIGHT) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_08_small_left;
                } else {
                    textureRegion = Assets.cloud_08_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_08_medium_left;
                } else {
                    textureRegion = Assets.cloud_08_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_08_big_left;
                } else {
                    textureRegion = Assets.cloud_08_big_right;
                }
            }
        } else if (color == NINE) {
            if (size == SMALL_ONE || size == SMALL_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_09_small_left;
                } else {
                    textureRegion = Assets.cloud_09_small_right;
                }
            } else if (size ==MEDIUM_ONE || size == MEDIUM_TWO ) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_09_medium_left;
                } else {
                    textureRegion = Assets.cloud_09_medium_right;
                }
            } else if (size == BIG) {
                if (direction == LEFT) {
                    textureRegion = Assets.cloud_09_big_left;
                } else {
                    textureRegion = Assets.cloud_09_big_right;
                }
            }
        }
    }

    public void scroll(float amount) {
        y += amount;
    }
}
