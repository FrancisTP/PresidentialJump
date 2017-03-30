package com.francistp.game.presidentialjump.Assets;

import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;

/**
 * Created by franc on 2017-03-29.
 */

public class Letter {
    public static int buffer_width = 4;
    public static int buffer_height = 4;

    private char letter;
    private float x, y;
    private float width, height;
    private float size;
    private TextureRegion sprite;

    public Letter(char letter, float size) {
        this.letter = letter;
        this.size = size;

        if (this.letter == 'a') {
            sprite = Assets.a_lower;
        } else if (this.letter == 'b') {
            sprite = Assets.b_lower;
        } else if (this.letter == 'c') {
            sprite = Assets.c_lower;
        } else if (this.letter == 'd') {
            sprite = Assets.d_lower;
        } else if (this.letter == 'e') {
            sprite = Assets.e_lower;
        } else if (this.letter == 'f') {
            sprite = Assets.f_lower;
        } else if (this.letter == 'g') {
            sprite = Assets.g_lower;
        } else if (this.letter == 'h') {
            sprite = Assets.h_lower;
        } else if (this.letter == 'i') {
            sprite = Assets.i_lower;
        } else if (this.letter == 'j') {
            sprite = Assets.j_lower;
        } else if (this.letter == 'k') {
            sprite = Assets.k_lower;
        } else if (this.letter == 'l') {
            sprite = Assets.l_lower;
        } else if (this.letter == 'm') {
            sprite = Assets.m_lower;
        } else if (this.letter == 'n') {
            sprite = Assets.n_lower;
        } else if (this.letter == 'o') {
            sprite = Assets.o_lower;
        } else if (this.letter == 'p') {
            sprite = Assets.p_lower;
        } else if (this.letter == 'q') {
            sprite = Assets.q_lower;
        } else if (this.letter == 'r') {
            sprite = Assets.r_lower;
        } else if (this.letter == 's') {
            sprite = Assets.s_lower;
        } else if (this.letter == 't') {
            sprite = Assets.t_lower;
        } else if (this.letter == 'u') {
            sprite = Assets.u_lower;
        } else if (this.letter == 'v') {
            sprite = Assets.v_lower;
        } else if (this.letter == 'w') {
            sprite = Assets.w_lower;
        } else if (this.letter == 'x') {
            sprite = Assets.x_lower;
        } else if (this.letter == 'y') {
            sprite = Assets.y_lower;
        } else if (this.letter == 'z') {
            sprite = Assets.z_lower;
        } else if (this.letter == 'A') {
            sprite = Assets.a_upper;
        } else if (this.letter == 'B') {
            sprite = Assets.b_upper;
        } else if (this.letter == 'C') {
            sprite = Assets.c_upper;
        } else if (this.letter == 'D') {
            sprite = Assets.d_upper;
        } else if (this.letter == 'E') {
            sprite = Assets.e_upper;
        } else if (this.letter == 'F') {
            sprite = Assets.f_upper;
        } else if (this.letter == 'G') {
            sprite = Assets.g_upper;
        } else if (this.letter == 'H') {
            sprite = Assets.h_upper;
        } else if (this.letter == 'I') {
            sprite = Assets.i_upper;
        } else if (this.letter == 'J') {
            sprite = Assets.j_upper;
        } else if (this.letter == 'K') {
            sprite = Assets.k_upper;
        } else if (this.letter == 'L') {
            sprite = Assets.l_upper;
        } else if (this.letter == 'M') {
            sprite = Assets.m_upper;
        } else if (this.letter == 'N') {
            sprite = Assets.n_upper;
        } else if (this.letter == 'O') {
            sprite = Assets.o_upper;
        } else if (this.letter == 'P') {
            sprite = Assets.p_upper;
        } else if (this.letter == 'Q') {
            sprite = Assets.q_upper;
        } else if (this.letter == 'R') {
            sprite = Assets.r_upper;
        } else if (this.letter == 'S') {
            sprite = Assets.s_upper;
        } else if (this.letter == 'T') {
            sprite = Assets.t_upper;
        } else if (this.letter == 'U') {
            sprite = Assets.u_upper;
        } else if (this.letter == 'V') {
            sprite = Assets.v_upper;
        } else if (this.letter == 'W') {
            sprite = Assets.w_upper;
        } else if (this.letter == 'X') {
            sprite = Assets.x_upper;
        } else if (this.letter == 'Y') {
            sprite = Assets.y_upper;
        } else if (this.letter == 'Z') {
            sprite = Assets.z_upper;
        } else if (this.letter == '0') {
            sprite = Assets.number_0;
        } else if (this.letter == '1') {
            sprite = Assets.number_1;
        } else if (this.letter == '2') {
            sprite = Assets.number_2;
        } else if (this.letter == '3') {
            sprite = Assets.number_3;
        } else if (this.letter == '4') {
            sprite = Assets.number_4;
        } else if (this.letter == '5') {
            sprite = Assets.number_5;
        } else if (this.letter == '6') {
            sprite = Assets.number_6;
        } else if (this.letter == '7') {
            sprite = Assets.number_7;
        } else if (this.letter == '8') {
            sprite = Assets.number_8;
        } else if (this.letter == '9') {
            sprite = Assets.number_9;
        } else if (this.letter == '.') {
            sprite = Assets.period;
        } else if (this.letter == '?') {
            sprite = Assets.question_mark;
        } else if (this.letter == '!') {
            sprite = Assets.exclamation_mark;
        } else if (this.letter == ',') {
            sprite = Assets.comma;
        } else if (this.letter == '-') {
            sprite = Assets.hyphen;
        } else if (this.letter == '#') {
            sprite = Assets.pound;
        } else if (this.letter == '$') {
            sprite = Assets.dollar;
        } else if (this.letter == '=') {
            sprite = Assets.equal;
        } else if (this.letter == ':') {
            sprite = Assets.semi_colon;
        } else if (this.letter == '\'') {
            sprite = Assets.apostrophe;
        } else if (this.letter == ' ') {
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

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y, float biggestHeight){
        if (this.letter == ',') {
            this.y = y - (this.sprite.height/2);
        } else if (this.letter == '-') {
            this.y = y + (biggestHeight/2) - (this.sprite.height/2);
        } else if (this.letter == '\'') {
            this.y = y + biggestHeight - (this.sprite.height/2);
        } else if (this.letter == 'g' || this.letter == 'j' || this.letter == 'p' || this.letter == 'q' || this.letter == 'y' || this.letter == 'Q') {
            this.y = y - (this.sprite.height/3) + (this.sprite.height/9);
        } else if (this.letter == '0' || this.letter == '6') {
            this.y = y - (this.sprite.height/50);
        } else {
            this.y = y;
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void render(SpriteBatcher batcher) {
        if (sprite != null) {
            batcher.drawSprite(x, y, width, height, sprite);
        }
    }
}