package com.francistp.game.presidentialjump.Assets;

import com.francistp.game.presidentialjump.Character.Player;

/**
 * Created by Francis on 2017-04-26.
 */
public class Text {

    private String text;
    private float x, y;
    private float width, height;
    private float lineSpacing;
    private boolean invisible;
    private boolean background;
    private float backgroundWidth, backgroundHeight;
    private Line lines[];
    private Word words[];
    private int wordCount, lineCount;
    private Character characters[];
    private char charCharacters[];
    private int size;
    private String colour;

    public Text(String text, int size, String colour, float x, float y, float width) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.size = size;
        this.colour = colour;

        background = false;
        backgroundHeight = 0;

        create();
    }

    public Text(String text, int size, String colour, float x, float y, float width, boolean background,  float backgroundHeight) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.background = background;
        this.backgroundHeight = backgroundHeight;
        this.size = size;
        this.colour = colour;

        create();
    }

    private void create() {
        wordCount = 0;
        lineCount = 0;
        charCharacters = text.toCharArray();
        words = new Word[charCharacters.length];
        characters = new Character[charCharacters.length];

        // Create characters
        float wordHeight = 0;
        for (int i=0; i<charCharacters.length; i ++) {
            characters[i] = new Character(charCharacters[i], size, colour);
            if (characters[i].getHeight() > wordHeight) {
                wordHeight = characters[i].getHeight();
            }
        }

        // All characters created, word creation starts
        Character wordChar[] = new Character[characters.length];
        int wordCharCount = 0;
        for (int i=0; i<characters.length; i ++) {
            // making words
            if (i == characters.length-1) { // last character in text
                if (characters[i].getCharacter() == ' ') {
                    if (wordChar[0] == null) {
                        words[wordCount] = new Word(new Character[]{characters[i]}, characters[i].getWidth(), wordHeight);
                        wordCount++;
                    } else {
                        Character[] newWordChar = new Character[wordCharCount];
                        wordCharCount = 0;

                        // create word
                        float wordWidth = 0;
                        for (int r = 0; r < newWordChar.length; r++) {
                            if (r == newWordChar.length - 1) {
                                newWordChar[r] = wordChar[r];
                                wordWidth += newWordChar[r].getWidth();
                            } else {
                                newWordChar[r] = wordChar[r];
                                wordWidth += newWordChar[r].getWidth() + Word.charSpacing;
                            }
                        }
                        words[wordCount] = new Word(newWordChar, wordWidth, wordHeight);
                        wordCount++;
                        wordChar = new Character[characters.length];

                        // create "space" word
                        words[wordCount] = new Word(new Character[]{characters[i]}, characters[i].getWidth(), wordHeight);
                        wordCount++;
                    }
                } else {
                    wordChar[wordCharCount] = characters[i];
                    wordCharCount++;

                    Character[] newWordChar = new Character[wordCharCount];
                    wordCharCount = 0;

                    // create word
                    float wordWidth = 0;
                    for (int r = 0; r < newWordChar.length; r++) {
                        if (r == newWordChar.length - 1) {
                            newWordChar[r] = wordChar[r];
                            wordWidth += newWordChar[r].getWidth();
                        } else {
                            newWordChar[r] = wordChar[r];
                            wordWidth += newWordChar[r].getWidth() + Word.charSpacing;
                        }
                    }
                    words[wordCount] = new Word(newWordChar, wordWidth, wordHeight);
                    wordCount++;
                    wordChar = new Character[characters.length];
                }
            } else if (characters[i].getCharacter() == ' ') { // space
                if (wordChar[0] == null) {
                    words[wordCount] = new Word(new Character[]{characters[i]}, characters[i].getWidth(), wordHeight);
                    wordCount++;
                } else {
                    Character[] newWordChar = new Character[wordCharCount];
                    wordCharCount = 0;

                    // create word
                    float wordWidth = 0;
                    for (int r = 0; r < newWordChar.length; r++) {
                        if (r == newWordChar.length - 1) {
                            newWordChar[r] = wordChar[r];
                            wordWidth += newWordChar[r].getWidth();
                        } else {
                            newWordChar[r] = wordChar[r];
                            wordWidth += newWordChar[r].getWidth() + Word.charSpacing;
                        }
                    }
                    words[wordCount] = new Word(newWordChar, wordWidth, wordHeight);
                    wordCount++;
                    wordChar = new Character[characters.length];

                    // create "space" word
                    words[wordCount] = new Word(new Character[]{characters[i]}, characters[i].getWidth(), wordHeight);
                    wordCount++;
                }
            } else { // character
                wordChar[wordCharCount] = characters[i];
                wordCharCount++;
            }
        }

        // All words created, line creation starts
        Word[] lineWords = new Word[words.length];
        int wordCounter = 0;
        Word overFlowWord = null; // used if word is bigger than defined width of text
        float lineWidth = 0;
        for (int i=0; i<words.length; i++) {
            if (overFlowWord != null) {
                i--;

            } else {
                if (words[i] != null) {

                    if (lineWidth + words[i].getWidth() > width) {
                        if (words[i].getWidth() > width) { // word needs to be broken up
                            overFlowWord = words[i];
                            // roll back to previous word
                            i--;

                            // look if part of word can fit on line
                            Character hyphen = new Character('-', size, colour);
                            float widthLeft = width - lineWidth - hyphen.getWidth();
                            int lettersThatFit = 0;
                            while (widthLeft > 0) {
                                widthLeft -= overFlowWord.getCharacters()[lettersThatFit].getWidth();
                                lettersThatFit++;
                            }
                            lettersThatFit--;

                            if (lettersThatFit > 3) { // at least three characters fit on the line
                                Word newPartialWord;

                                Character[] partialWordCharacters = new Character[lettersThatFit+1]; // create partial word and create line with it, set new partial word to remaining characters

                            } else {        // DONE
                                Word[] newLineWords = new Word[wordCounter];
                                for (int r=0; r < wordCounter; r++) {
                                    newLineWords[r] = lineWords[r];
                                }
                                Line newLine = new Line(newLineWords, lineWidth, wordHeight);
                                lines[lineCount] = newLine;
                                lineCount++;
                                lineWidth = 0;
                            }
                        } else { // word goes on next line      // DONE
                            // roll back to previous word
                            i--;
                            // create next line
                            Word[] newLineWords = new Word[wordCounter];
                            for (int r=0; r < wordCounter; r++) {
                                newLineWords[r] = lineWords[r];
                            }
                            Line newLine = new Line(newLineWords, lineWidth, wordHeight);
                            lines[lineCount] = newLine;
                            lineCount++;
                            lineWidth = 0;
                        }
                    } else { // add word to line        // DONE
                        lineWords[wordCounter] = words[i];
                        wordCounter++;
                        lineWidth += words[i].getWidth();
                    }
                } else {

                }
            }
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public float getLineSpacing() {
        return lineSpacing;
    }

    public void setLineSpacing(float lineSpacing) {
        this.lineSpacing = lineSpacing;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public boolean isBackground() {
        return background;
    }

    public void setBackground(boolean background) {
        this.background = background;
    }

    public float getBackgroundWidth() {
        return backgroundWidth;
    }

    public void setBackgroundWidth(float backgroundWidth) {
        this.backgroundWidth = backgroundWidth;
    }

    public float getBackgroundHeight() {
        return backgroundHeight;
    }

    public void setBackgroundHeight(float backgroundHeight) {
        this.backgroundHeight = backgroundHeight;
    }

    public Line[] getLines() {
        return lines;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }
}
