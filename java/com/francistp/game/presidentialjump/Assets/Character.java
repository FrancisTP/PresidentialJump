package com.francistp.game.presidentialjump.Assets;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;

/**
 * Created by Francis on 2017-04-26.
 */
public class Character {

    private float x, y;
    private float width, height;
    private float size;
    private String colour;
    private char character;
    private TextureRegion sprite;

    public Character(char character, int size, String colour) {
        this.character = character;
        this.size = size;
        this.colour = colour;

        if (this.character == 'a') {
            sprite = Assets.a_lower;
        } else if (this.character == 'b') {
            sprite = Assets.b_lower;
        } else if (this.character == 'c') {
            sprite = Assets.c_lower;
        } else if (this.character == 'd') {
            sprite = Assets.d_lower;
        } else if (this.character == 'e') {
            sprite = Assets.e_lower;
        } else if (this.character == 'f') {
            sprite = Assets.f_lower;
        } else if (this.character == 'g') {
            sprite = Assets.g_lower;
        } else if (this.character == 'h') {
            sprite = Assets.h_lower;
        } else if (this.character == 'i') {
            sprite = Assets.i_lower;
        } else if (this.character == 'j') {
            sprite = Assets.j_lower;
        } else if (this.character == 'k') {
            sprite = Assets.k_lower;
        } else if (this.character == 'l') {
            sprite = Assets.l_lower;
        } else if (this.character == 'm') {
            sprite = Assets.m_lower;
        } else if (this.character == 'n') {
            sprite = Assets.n_lower;
        } else if (this.character == 'o') {
            sprite = Assets.o_lower;
        } else if (this.character == 'p') {
            sprite = Assets.p_lower;
        } else if (this.character == 'q') {
            sprite = Assets.q_lower;
        } else if (this.character == 'r') {
            sprite = Assets.r_lower;
        } else if (this.character == 's') {
            sprite = Assets.s_lower;
        } else if (this.character == 't') {
            sprite = Assets.t_lower;
        } else if (this.character == 'u') {
            sprite = Assets.u_lower;
        } else if (this.character == 'v') {
            sprite = Assets.v_lower;
        } else if (this.character == 'w') {
            sprite = Assets.w_lower;
        } else if (this.character == 'x') {
            sprite = Assets.x_lower;
        } else if (this.character == 'y') {
            sprite = Assets.y_lower;
        } else if (this.character == 'z') {
            sprite = Assets.z_lower;
        } else if (this.character == 'A') {
            sprite = Assets.a_upper;
        } else if (this.character == 'B') {
            sprite = Assets.b_upper;
        } else if (this.character == 'C') {
            sprite = Assets.c_upper;
        } else if (this.character == 'D') {
            sprite = Assets.d_upper;
        } else if (this.character == 'E') {
            sprite = Assets.e_upper;
        } else if (this.character == 'F') {
            sprite = Assets.f_upper;
        } else if (this.character == 'G') {
            sprite = Assets.g_upper;
        } else if (this.character == 'H') {
            sprite = Assets.h_upper;
        } else if (this.character == 'I') {
            sprite = Assets.i_upper;
        } else if (this.character == 'J') {
            sprite = Assets.j_upper;
        } else if (this.character == 'K') {
            sprite = Assets.k_upper;
        } else if (this.character == 'L') {
            sprite = Assets.l_upper;
        } else if (this.character == 'M') {
            sprite = Assets.m_upper;
        } else if (this.character == 'N') {
            sprite = Assets.n_upper;
        } else if (this.character == 'O') {
            sprite = Assets.o_upper;
        } else if (this.character == 'P') {
            sprite = Assets.p_upper;
        } else if (this.character == 'Q') {
            sprite = Assets.q_upper;
        } else if (this.character == 'R') {
            sprite = Assets.r_upper;
        } else if (this.character == 'S') {
            sprite = Assets.s_upper;
        } else if (this.character == 'T') {
            sprite = Assets.t_upper;
        } else if (this.character == 'U') {
            sprite = Assets.u_upper;
        } else if (this.character == 'V') {
            sprite = Assets.v_upper;
        } else if (this.character == 'W') {
            sprite = Assets.w_upper;
        } else if (this.character == 'X') {
            sprite = Assets.x_upper;
        } else if (this.character == 'Y') {
            sprite = Assets.y_upper;
        } else if (this.character == 'Z') {
            sprite = Assets.z_upper;
        } else if (this.character == '0') {
            sprite = Assets.number_0;
        } else if (this.character == '1') {
            sprite = Assets.number_1;
        } else if (this.character == '2') {
            sprite = Assets.number_2;
        } else if (this.character == '3') {
            sprite = Assets.number_3;
        } else if (this.character == '4') {
            sprite = Assets.number_4;
        } else if (this.character == '5') {
            sprite = Assets.number_5;
        } else if (this.character == '6') {
            sprite = Assets.number_6;
        } else if (this.character == '7') {
            sprite = Assets.number_7;
        } else if (this.character == '8') {
            sprite = Assets.number_8;
        } else if (this.character == '9') {
            sprite = Assets.number_9;
        } else if (this.character == '.') {
            sprite = Assets.period;
        } else if (this.character == '?') {
            sprite = Assets.question_mark;
        } else if (this.character == '!') {
            sprite = Assets.exclamation_mark;
        } else if (this.character == ',') {
            sprite = Assets.comma;
        } else if (this.character == '-') {
            sprite = Assets.hyphen;
        } else if (this.character == '#') {
            sprite = Assets.pound;
        } else if (this.character == '$') {
            sprite = Assets.dollar;
        } else if (this.character == '=') {
            sprite = Assets.equal;
        } else if (this.character == ':') {
            sprite = Assets.semi_colon;
        } else if (this.character == '\'') {
            sprite = Assets.apostrophe;
        } else if (this.character == '(') {
            sprite = Assets.parenthesis_left;  // TO BE ADDED
        } else if (this.character == ')') {
            sprite = Assets.parenthesis_right;  // TO BE ADDED
        }  else if (this.character == '@') {
            sprite = Assets.at;  // TO BE ADDED
        } else if (this.character == ' ') {
            sprite = null;
        } else {
            sprite = Assets.question_mark;
        }

        if (sprite != null) {
            width = sprite.width * (this.size / 10);
            height = sprite.height * (this.size / 10);
        } else {
            width = 20 * (this.size / 10);
            height = 25 * (this.size / 10);
        }
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

    public void setY(float y, float biggestHeight) {
        if (this.character == ',') {
            this.y = y - (height/2);
        } else if (this.character == '-') {
            this.y = y + (biggestHeight/2) - (height/2);
        } else if (this.character == '\'') {
            this.y = y + biggestHeight - (height);//(height/2)
        } else if (this.character == 'g' || this.character == 'j' || this.character == 'p' || this.character == 'q' || this.character == 'y' || this.character == 'Q') {
            this.y = y - (height/3) + (height/9);
        } else if (this.character == '0' || this.character == '6') {
            this.y = y - (height/50);
        } else {
            this.y = y;
        }
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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public char getCharacter() {
        return character;
    }

    public void render(SpriteBatcher batcher) {
        if (sprite != null) {
            batcher.drawSprite(x + width/2, y + height/2, width, height, sprite);
        }
    }
}
