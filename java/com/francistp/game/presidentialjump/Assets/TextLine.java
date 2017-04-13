package com.francistp.game.presidentialjump.Assets;

import com.francistp.game.framework.gl.SpriteBatcher;

/**
 * Created by Francis on 2017-04-10.
 */

// As with Text, the y defines the top of the line

public class TextLine {

    private float x, y;
    private float width, height;
    private Letter[] lettersLine;
    private float startingX, bottomLine;

    public static float bottomPad = 2;
    public static float topPad = 3;
    public static float  sidePad = 2;

    public TextLine(float x, float y, Letter[] lettersLine, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        startingX = x - (width/2) + sidePad;
        bottomLine = y - height + bottomPad;

        this.lettersLine = lettersLine;
        calculateLine();
    }

    private void calculateLine() {
        for (int i=0; i < lettersLine.length; i++) {
            lettersLine[i].setY(bottomLine + (lettersLine[i].getHeight()/2), height - bottomPad - topPad);
            lettersLine[i].setX(startingX + (lettersLine[i].getWidth()/2));
            startingX += lettersLine[i].getWidth() + Letter.buffer_width;
        }
    }

    private void moveText() {

        float bottomLine = y - (height/2) + bottomPad;
        float startingX = this.x - (width/2) + sidePad;
        float biggestHeight = height - bottomPad - topPad;

        for (int i=0; i < lettersLine.length; i++) {
            lettersLine[i].setY(bottomLine + (lettersLine[i].getHeight()/2), biggestHeight);
            lettersLine[i].setX(startingX + (lettersLine[i].getWidth()/2));
            startingX += lettersLine[i].getWidth() + Letter.buffer_width;
        }
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void render(SpriteBatcher batcher) {
        for (int i=0; i < lettersLine.length; i++) {
            lettersLine[i].render(batcher);
        }
    }
}
