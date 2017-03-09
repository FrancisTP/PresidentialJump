package com.francistp.game.presidentialjump.Object;

import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Assets.Assets;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by franc on 2017-01-18.
 */

public class Wall {

    private float wallStartingHeight, fenceStartingHeight;
    private float x;

    private List<GameObjectRectangle> leftWallsList;
    private List<GameObjectRectangle> rightWallsList;
    private List<GameObjectRectangle> fencesList;

    private float wallOffset;

    public Wall() {
        wallStartingHeight = 420;
        fenceStartingHeight = 120;
        x = 240;

        wallOffset = 255;

        leftWallsList = new LinkedList<GameObjectRectangle>();
        leftWallsList.add(new GameObjectRectangle(x - wallOffset, wallStartingHeight, Assets.left_wall.width, Assets.left_wall.height));
        leftWallsList.add(new GameObjectRectangle(x - wallOffset, wallStartingHeight + Assets.left_wall.height - 5, Assets.left_wall.width, Assets.left_wall.height));
        leftWallsList.add(new GameObjectRectangle(x - wallOffset, wallStartingHeight + (Assets.left_wall.height*2) - 10, Assets.left_wall.width, Assets.left_wall.height));

        rightWallsList = new LinkedList<GameObjectRectangle>();
        rightWallsList.add(new GameObjectRectangle(x + wallOffset, wallStartingHeight, Assets.right_wall.width, Assets.right_wall.height));
        rightWallsList.add(new GameObjectRectangle(x + wallOffset, wallStartingHeight + Assets.right_wall.height - 5, Assets.right_wall.width, Assets.right_wall.height));
        rightWallsList.add(new GameObjectRectangle(x + wallOffset, wallStartingHeight + (Assets.right_wall.height*2) - 10, Assets.right_wall.width, Assets.right_wall.height));

        fencesList = new LinkedList<GameObjectRectangle>();
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*2, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*3, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*4, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*5, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*6, Assets.metal_fence.width, Assets.metal_fence.height));
    }

    public Wall(float wallStartingHeight) {
        this.wallStartingHeight = wallStartingHeight;
        x = 240;

        leftWallsList = new LinkedList<GameObjectRectangle>();
        leftWallsList.add(new GameObjectRectangle(x - wallOffset, wallStartingHeight, Assets.left_wall.width, Assets.left_wall.height));
        leftWallsList.add(new GameObjectRectangle(x - wallOffset, wallStartingHeight + Assets.left_wall.height - 5, Assets.left_wall.width, Assets.left_wall.height));
        leftWallsList.add(new GameObjectRectangle(x - wallOffset, wallStartingHeight + (Assets.left_wall.height*2) - 10, Assets.left_wall.width, Assets.left_wall.height));

        rightWallsList = new LinkedList<GameObjectRectangle>();
        rightWallsList.add(new GameObjectRectangle(x + wallOffset, wallStartingHeight, Assets.right_wall.width, Assets.right_wall.height));
        rightWallsList.add(new GameObjectRectangle(x + wallOffset, wallStartingHeight + Assets.right_wall.height - 5, Assets.right_wall.width, Assets.right_wall.height));
        rightWallsList.add(new GameObjectRectangle(x + wallOffset, wallStartingHeight + (Assets.right_wall.height*2) - 10, Assets.right_wall.width, Assets.right_wall.height));

        fencesList = new LinkedList<GameObjectRectangle>();
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*2, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*3, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*4, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*5, Assets.metal_fence.width, Assets.metal_fence.height));
        fencesList.add(new GameObjectRectangle(x, fenceStartingHeight + Assets.metal_fence.height*6, Assets.metal_fence.width, Assets.metal_fence.height));
    }

    public void scroll(float moveByY) {

        Iterator<GameObjectRectangle> leftWallsListIterator = leftWallsList.iterator();
        Iterator<GameObjectRectangle> rightWallsListIterator = rightWallsList.iterator();
        Iterator<GameObjectRectangle> fencesListIterator = fencesList.iterator();

        while (leftWallsListIterator.hasNext()) {
            GameObjectRectangle leftWall = leftWallsListIterator.next();
            leftWall.setPosition(leftWall.x, leftWall.y + moveByY);
        }
        while (rightWallsListIterator.hasNext()) {
            GameObjectRectangle rightWall = rightWallsListIterator.next();
            rightWall.setPosition(rightWall.x, rightWall.y + moveByY);
        }
        while (fencesListIterator.hasNext()) {
            GameObjectRectangle fence = fencesListIterator.next();
            fence.setPosition(fence.x, fence.y + moveByY);
        }

    }

    public void checkWall() {
        Iterator<GameObjectRectangle> leftWallsListIterator = leftWallsList.iterator();
        Iterator<GameObjectRectangle> rightWallsListIterator = rightWallsList.iterator();
        Iterator<GameObjectRectangle> fencesListIterator = fencesList.iterator();

        if (leftWallsListIterator.hasNext()) {
            GameObjectRectangle wallToCheck = leftWallsListIterator.next();
            if (wallToCheck.y < (0 - Assets.left_wall.height/2)) {
                while (leftWallsListIterator.hasNext()) {
                    wallToCheck = leftWallsListIterator.next();
                }
                leftWallsList.remove(0);
                leftWallsList.add(new GameObjectRectangle(x - wallOffset, wallToCheck.y + Assets.left_wall.height - 5, Assets.left_wall.width, Assets.left_wall.height));
            }
        }
        if (rightWallsListIterator.hasNext()) {
            GameObjectRectangle wallToCheck = rightWallsListIterator.next();
            if (wallToCheck.y < (0 - Assets.right_wall.height/2)) {
                while (rightWallsListIterator.hasNext()) {
                    wallToCheck = rightWallsListIterator.next();
                }
                rightWallsList.remove(0);
                rightWallsList.add(new GameObjectRectangle(x + wallOffset, wallToCheck.y + Assets.right_wall.height - 5, Assets.right_wall.width, Assets.right_wall.height));
            }
        }
        if (fencesListIterator.hasNext()) {
            GameObjectRectangle fenceToCheck = fencesListIterator.next();
            if (fenceToCheck.y < (0 - Assets.metal_fence.height/2)) {
                while (fencesListIterator.hasNext()) {
                    fenceToCheck = fencesListIterator.next();
                }
                fencesList.remove(0);
                fencesList.add(new GameObjectRectangle(x, fenceToCheck.y + Assets.metal_fence.height, Assets.metal_fence.width, Assets.metal_fence.height));
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.fenceTexture);
        Iterator<GameObjectRectangle> leftWallsListIterator = leftWallsList.iterator();
        Iterator<GameObjectRectangle> rightWallsListIterator = rightWallsList.iterator();
        Iterator<GameObjectRectangle> fencesListIterator = fencesList.iterator();

        while (fencesListIterator.hasNext()) {
            GameObjectRectangle fenceToRender = fencesListIterator.next();
            batcher.drawSprite(fenceToRender.x, fenceToRender.y, Assets.metal_fence.width, Assets.metal_fence.height, Assets.metal_fence);
        }
        while (leftWallsListIterator.hasNext()) {
            GameObjectRectangle leftWallToRender = leftWallsListIterator.next();
            batcher.drawSprite(leftWallToRender.x, leftWallToRender.y, Assets.left_wall.width, Assets.left_wall.height, Assets.left_wall);
        }
        while (rightWallsListIterator.hasNext()) {
            GameObjectRectangle rightWallToRender = rightWallsListIterator.next();
            batcher.drawSprite(rightWallToRender.x, rightWallToRender.y, Assets.right_wall.width, Assets.right_wall.height, Assets.right_wall);
        }

        /*
        batcher.endBatch();

        Iterator<GameObjectRectangle> leftWallsListIt = leftWallsList.iterator();
        Iterator<GameObjectRectangle> rightWallsListIt = rightWallsList.iterator();

        batcher.beginBatch(Assets.collisionLinesTexture);
        while (leftWallsListIt.hasNext()) {
            GameObjectRectangle leftWallToRender = leftWallsListIt.next();
            leftWallToRender.drawShape(batcher);
        }
        while (rightWallsListIt.hasNext()) {
            GameObjectRectangle rightWallToRender = rightWallsListIt.next();
            rightWallToRender.drawShape(batcher);
        }
        */
    }

    public List<GameObjectRectangle> getLeftWallsList() {
        return leftWallsList;
    }

    public List<GameObjectRectangle> getRightWallsList() {
        return rightWallsList;
    }
}
