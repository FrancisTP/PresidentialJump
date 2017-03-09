package com.francistp.game.presidentialjump.Character;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.math.Rectangle;
import com.francistp.game.framework.math.Vector2;

/**
 * Created by Francis on 2017-01-16.
 */
public class Player {

    public void setPlayerState(int playerState) {
        this.playerState = playerState;
    }

    protected int playerState;

    protected final int IDLE = 0;
    protected final int JUMP_LEFT = 1;
    protected final int JUMP_RIGHT = 2;
    protected final int WALL_LEFT = 3;
    protected final int WALL_RIGHT = 4;

    private static final float GRAVITY = -0.5f;
    private static final float WALL_RESISTANCE = 0.65f;

    protected Vector2 position;
    protected Vector2 velocity;
    protected GameObjectRectangle wallBounds, damageBounds;
    protected float initialJumpSpeedX, initialJumpSpeedY;
    protected float jumpSpeedX, jumpSpeedY;

    protected float x, y;


    public Player() {
        playerState = IDLE;

        initialJumpSpeedX = 17;
        initialJumpSpeedY = 15;

        jumpSpeedX = 22;
        jumpSpeedY = 19;
    }

    public void update(float deltaTime) {
        // nothing
    }

    public void updatePlayer(float deltaTime) {
        if (playerState == JUMP_LEFT || playerState == JUMP_RIGHT) {
            if (position.y >  50) {
                velocity.add(0, GRAVITY);
            } else {
                position.y = 50;
            }
        } else if (playerState == WALL_LEFT || playerState == WALL_RIGHT) {
            if (position.y > 50) {
                velocity.add(0, GRAVITY * WALL_RESISTANCE);
            } else {
                position.y = 50;
            }
        }
        velocity.scl(0.97f);
        position.add(velocity.x, velocity.y);

        if (position.y > 720) {
            position.y = 720;
        }
    }

    public void jump() {
        if (playerState == IDLE) {
            velocity.y = initialJumpSpeedY;
            velocity.x = initialJumpSpeedX;
            playerState = JUMP_RIGHT;
        } else if (playerState == WALL_LEFT) {
            velocity.y = jumpSpeedY;
            velocity.x = jumpSpeedX;
            playerState = JUMP_RIGHT;
        } else if (playerState == WALL_RIGHT) {
            velocity.y = jumpSpeedY;
            velocity.x = -jumpSpeedX;
            playerState = JUMP_LEFT;
        }

    }

    public void render(SpriteBatcher batcher) {
        // nothing
    }

    public int getPlayerState() {
        return playerState;
    }

    public int getIDLE() {
        return IDLE;
    }

    public int getJUMP_LEFT() {
        return JUMP_LEFT;
    }

    public int getJUMP_RIGHT() {
        return JUMP_RIGHT;
    }

    public int getWALL_LEFT() {
        return WALL_LEFT;
    }

    public int getWALL_RIGHT() {
        return WALL_RIGHT;
    }

    public static float getGRAVITY() {
        return GRAVITY;
    }

    public static float getWallResistance() {
        return WALL_RESISTANCE;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public GameObjectRectangle getWallBounds() {
        return wallBounds;
    }

    public GameObjectRectangle getDamageBounds() {
        return damageBounds;
    }

    public float getInitialJumpSpeedX() {
        return initialJumpSpeedX;
    }

    public float getInitialJumpSpeedY() {
        return initialJumpSpeedY;
    }

    public float getJumpSpeedX() {
        return jumpSpeedX;
    }

    public float getJumpSpeedY() {
        return jumpSpeedY;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
