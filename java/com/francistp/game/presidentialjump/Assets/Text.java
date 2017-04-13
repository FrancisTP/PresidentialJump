package com.francistp.game.presidentialjump.Assets;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.presidentialjump.Character.Player;

/**
 * Created by franc on 2017-03-29.
 */

// This classes y attribute specifies the TOP of the text box, not middle like other objects

public class Text {

    private float x, y;
    private String text;
    private float width, height;
    private String align;
    private char[] textArray;
    private Letter[] letters;
    private TextLine[] textLines;
    private float length, biggestHeight;
    private float size;
    private boolean background;

    public Text(float x, float y, String text, float size, String align) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.align = align;

        this.text = text;
        this.width = 480;
        this.height = 800;
        this.background = false;
        calculateText();
    }

    public Text(float x, float y, String text, float size, String align, float width) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.align = align;

        this.text = text;
        this.width = width;
        this.height = 0;
        this.background = false;
        calculateText();
    }

    public Text(float x, float y, String text, float size, String align, float width, float height) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.align = align;

        this.text = text;
        this.width = width;
        this.height = height;
        this.background = false;
        calculateText();
    }

    public Text(float x, float y, String text, float size, String align, float width, boolean background) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.align = align;

        this.text = text;
        this.width = width;
        this.height = 0;
        this.background = background;
        calculateText();
    }

    public Text(float x, float y, String text, float size, String align, float width, float height, boolean background) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.align = align;

        this.text = text;
        this.width = width;
        this.height = height;
        this.background = background;
        calculateText();
    }

    private void calculateText() {

        textArray = this.text.toCharArray();
        letters = new Letter[textArray.length];
        textLines = new TextLine[textArray.length];

        biggestHeight = 0;

        for (int i=0; i < letters.length; i++) {
            letters[i] = new Letter(textArray[i], size);
            if (letters[i].getHeight() > biggestHeight) {
                biggestHeight = letters[i].getHeight();
            }
        }

        length = (TextLine.sidePad*2);
        int offSet = 0;

        int letterCount = 0;
        for (int i=0; i < letters.length; i++) {
            if (length + letters[i].getWidth() - Letter.buffer_width > width || i == letters.length-1) {
                length -= Letter.buffer_width;
                if (i == letters.length-1) {
                    letterCount++;
                }
                Letter[] lineLetters = new Letter[letterCount];
                int newLetterCount = letterCount;
                for (int z=0; z < lineLetters.length; z++) {
                    if ((z == 0 && letters[z + offSet].getLetter() == ' ') || (z == lineLetters.length-1 && letters[z + offSet].getLetter() == ' ')) {
                        newLetterCount--;
                    } else {
                        lineLetters[z] = letters[z + offSet];
                    }
                }

                int realLineCount = 0;
                Letter[] newLineLetters = new Letter[newLetterCount];
                for (int z=0; z < lineLetters.length; z++) {
                    if (lineLetters[z] != null) {
                        newLineLetters[realLineCount] = lineLetters[z];
                        realLineCount++;
                    }
                }


                lineLetters = newLineLetters;
                offSet += letterCount;

                float lineX = 0;
                float lineY;

                if (align.equals("left")) {
                    lineX = x - (width/2) + (length/2);
                } else if (align.equals("center")) {
                    lineX = x;
                } else if (align.equals("right")) {
                    lineX = x + (width/2) - (length/2);
                }

                int lineCount = 0;
                for (int z=0; z < textLines.length; z++) {
                    if (textLines[z] != null) {
                        lineCount++;
                    } else {
                        lineY = y - ((biggestHeight + TextLine.bottomPad + TextLine.topPad)*lineCount); //float x, float y, Letter[] lettersLine, float width, float height
                        textLines[lineCount] = new TextLine(lineX, lineY, lineLetters, length, biggestHeight + TextLine.bottomPad + TextLine.topPad);
                    }
                }

                length = (TextLine.sidePad*2) + letters[i].getWidth();
                letterCount = 1;
            } else {
                length += letters[i].getWidth() + Letter.buffer_width;
                letterCount++;
            }
        }

        int lineC = 0;
        for (int i=0; i < textLines.length; i++) {
            if (textLines[i] != null) {
                lineC++;
            } else {
                break;
            }
        }

        TextLine[] trimmedTextLines = new TextLine[lineC];
        for (int i=0; i < trimmedTextLines.length; i++) {
            trimmedTextLines[i] = textLines[i];
        }
        textLines = trimmedTextLines;
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
        for (int i=0; i < textLines.length; i++) {
            textLines[i].render(batcher);
        }
        batcher.endBatch();
    }
}
