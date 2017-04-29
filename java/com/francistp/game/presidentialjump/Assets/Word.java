package com.francistp.game.presidentialjump.Assets;

/**
 * Created by Francis on 2017-04-26.
 */
public class Word {

    private Character characters[];
    private float x, y;
    private float width, height;

    public static final float charSpacing = 0.5f;

    public Word(Character characters[], float width, float height) {
        this.characters = characters;

        this.width = width;
        this.height = height;
    }

    public Character[] getCharacters() {
        return characters;
    }

    public void setCharacters(Character[] characters) {
        this.characters = characters;
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
}
