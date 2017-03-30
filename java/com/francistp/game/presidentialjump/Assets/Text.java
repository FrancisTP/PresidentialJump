package com.francistp.game.presidentialjump.Assets;

import com.francistp.game.framework.gl.SpriteBatcher;

/**
 * Created by franc on 2017-03-29.
 */

public class Text {

    private float x, y;
    private String text;
    private char[] textArray;
    private Letter[] letters;
    private float length, biggestHeight;
    private float size;

    public Text(float x, float y, String text, float size) {
        this.x = x;
        this.y = y;
        this.size = size;

        this.text = text;
        calculateText();
    }

    private void calculateText() {
        textArray = this.text.toCharArray();
        letters = new Letter[textArray.length];
        //charLength = new float[textArray.length];

        for (int i=0; i < letters.length; i++) {
            letters[i] = new Letter(textArray[i], this.size);
        }

        biggestHeight = 0;
        length = 0;
        for (int i=0; i < letters.length; i++) {
            if (i != (letters.length -1)) {
                length += letters[i].getWidth() + Letter.buffer_width;
            } else {
                length += letters[i].getWidth();
            }
            if (letters[i].getHeight() > biggestHeight) {
                biggestHeight = letters[i].getHeight();
            }
        }

        float bottomLine = this.y - (biggestHeight/2);
        float startingX = this.x - (length/2);

        for (int i=0; i < letters.length; i++) {
            letters[i].setY(bottomLine + (letters[i].getHeight()/2), biggestHeight);
            letters[i].setX(startingX + (letters[i].getWidth()/2));
            startingX += letters[i].getWidth() + Letter.buffer_width;
        }
    }

    private void moveText() {

        float bottomLine = this.y - (biggestHeight/2);
        float startingX = this.x - (length/2);

        for (int i=0; i < letters.length; i++) {
            letters[i].setY(bottomLine + (letters[i].getHeight()/2), biggestHeight);
            letters[i].setX(startingX + (letters[i].getWidth()/2));
            startingX += letters[i].getWidth() + Letter.buffer_width;
        }
    }

    public void setX(float x) {
        this.x = x;
        moveText();
    }

    public void setY(float y){
        this.y = y;
        moveText();
    }

    public void setText(String text) {
        this.text = text;
        calculateText();
    }

    public void setSize(int size) {
        this.size = size;
        calculateText();
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.textSpriteSheet);
        for (int i=0; i < letters.length; i++) {
            letters[i].render(batcher);
        }
        batcher.endBatch();
    }
}
