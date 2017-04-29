package com.francistp.game.presidentialjump.Assets;

/**
 * Created by Francis on 2017-04-26.
 */
public class Line {

    private Word words[];
    private float x, y;
    private float width, height;

    public Line(Word words[], float width, float height) {
        this.words = words;
        this.width = width;
        this.height = height;

    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    private static float wordSpacing = 2;


}
