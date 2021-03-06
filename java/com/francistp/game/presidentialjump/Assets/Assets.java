package com.francistp.game.presidentialjump.Assets;

/**
 * Created by Francis on 2017-01-11.
 */

//import com.tp.framework.Music;
//import com.tp.framework.Sound;
//import android.util.Log;

import com.francistp.game.framework.gl.Animation;
import com.francistp.game.framework.gl.Texture;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.framework.impl.GLGame;

public class Assets {

    protected static GLGame glGame;

    public static String onScreen = "";

    // Ready state
    public static boolean readyState;

    // AlwaysLoaded
    public static Texture SplashScreenScreen;
    public static TextureRegion SplashScreen;

    // Line Texture
    public static Texture collisionLinesTexture;
    public static TextureRegion line;
    public static TextureRegion circle;

    // TextOld
    public static Texture textSpriteSheet;

    public static TextureRegion a_lower;
    public static TextureRegion a_upper;
    public static TextureRegion apostrophe;
    public static TextureRegion at;
    public static TextureRegion b_lower;
    public static TextureRegion b_upper;
    public static TextureRegion backwards_dash;
    public static TextureRegion c_lower;
    public static TextureRegion c_upper;
    public static TextureRegion comma;
    public static TextureRegion d_lower;
    public static TextureRegion d_upper;
    public static TextureRegion dollar;
    public static TextureRegion e_lower;
    public static TextureRegion e_upper;
    public static TextureRegion equal;
    public static TextureRegion exclamation_mark;
    public static TextureRegion f_lower;
    public static TextureRegion f_upper;
    public static TextureRegion forward_dash;
    public static TextureRegion g_lower;
    public static TextureRegion g_upper;
    public static TextureRegion gear_01;
    public static TextureRegion gear_02;
    public static TextureRegion h_lower;
    public static TextureRegion h_upper;
    public static TextureRegion hyphen;
    public static TextureRegion i_lower;
    public static TextureRegion i_upper;
    public static TextureRegion j_lower;
    public static TextureRegion j_upper;
    public static TextureRegion k_lower;
    public static TextureRegion k_upper;
    public static TextureRegion l_lower;
    public static TextureRegion l_upper;
    public static TextureRegion m_lower;
    public static TextureRegion m_upper;
    public static TextureRegion n_lower;
    public static TextureRegion n_upper;
    public static TextureRegion number_0;
    public static TextureRegion number_1;
    public static TextureRegion number_2;
    public static TextureRegion number_3;
    public static TextureRegion number_4;
    public static TextureRegion number_5;
    public static TextureRegion number_6;
    public static TextureRegion number_7;
    public static TextureRegion number_8;
    public static TextureRegion number_9;
    public static TextureRegion o_lower;
    public static TextureRegion o_upper;
    public static TextureRegion p_lower;
    public static TextureRegion p_upper;
    public static TextureRegion parenthesis_left;
    public static TextureRegion parenthesis_right;
    public static TextureRegion period;
    public static TextureRegion pound;
    public static TextureRegion q_lower;
    public static TextureRegion q_upper;
    public static TextureRegion question_mark;
    public static TextureRegion quotation_mark;
    public static TextureRegion r_lower;
    public static TextureRegion r_upper;
    public static TextureRegion s_lower;
    public static TextureRegion s_upper;
    public static TextureRegion semi_colon;
    public static TextureRegion t_lower;
    public static TextureRegion t_upper;
    public static TextureRegion text_background;
    public static TextureRegion twitter_board_bottom;
    public static TextureRegion twitter_board_top;
    public static TextureRegion u_lower;
    public static TextureRegion u_upper;
    public static TextureRegion v_lower;
    public static TextureRegion v_upper;
    public static TextureRegion w_lower;
    public static TextureRegion w_upper;
    public static TextureRegion x_lower;
    public static TextureRegion x_upper;
    public static TextureRegion y_lower;
    public static TextureRegion y_upper;
    public static TextureRegion z_lower;
    public static TextureRegion z_upper;

    public static Animation gear;
    public static TextureRegion [] gear_collection;


    // Main menu_frame
    public static Texture plainSkyAndGroundTexture;
    public static TextureRegion plainSkyAndGround;

    public static Texture backgroundsTexture;
    public static TextureRegion background_01;
    public static TextureRegion background_02;
    public static TextureRegion background_03;
    public static TextureRegion background_04;
    public static TextureRegion background_05;
    public static TextureRegion background_06;
    public static TextureRegion background_07;
    public static TextureRegion background_08;
    public static TextureRegion background_09;
    public static TextureRegion background_transition_01;
    public static TextureRegion background_transition_02;
    public static TextureRegion background_transition_03;
    public static TextureRegion background_transition_04;
    public static TextureRegion background_transition_05;
    public static TextureRegion background_transition_06;
    public static TextureRegion background_transition_07;
    public static TextureRegion background_transition_08;
    public static TextureRegion background_transition_09;

    public static Texture presidentialJumpTitleTexture;
    public static TextureRegion presidentialJumpTitle;

    public static Texture whiteHouseTexture;
    public static TextureRegion whiteHouse;

    public static Texture fenceTexture;
    public static TextureRegion metal_fence;
    public static TextureRegion left_wall;
    public static TextureRegion right_wall;
    public static TextureRegion medium_wall;
    public static TextureRegion small_wall;
    public static TextureRegion dust_01;
    public static TextureRegion dust_02;
    public static Animation dust_right;
    public static TextureRegion [] dust_right_collection;
    public static Animation dust_left;
    public static TextureRegion [] dust_left_collection;

    public static Texture electricBoundry;
    public static TextureRegion electric_boundry_01;
    public static TextureRegion electric_boundry_02;
    public static Animation electric_boundry;
    public static TextureRegion [] electric_boundry_collection;


    // Trump
    public static Texture trumpallbodyparts;

    public static TextureRegion trump_arm_dead;
    public static TextureRegion trump_blood;
    public static TextureRegion trump_body_dead_left;
    public static TextureRegion trump_body_dead_right;
    public static TextureRegion trump_body_jump_left;
    public static TextureRegion trump_body_jump_right;
    public static TextureRegion trump_body_left;
    public static TextureRegion trump_body_right;
    public static TextureRegion trump_body_slide_left;
    public static TextureRegion trump_body_slide_right;
    public static TextureRegion trump_disintegrate_block;
    public static TextureRegion trump_electricity_01;
    public static TextureRegion trump_electricity_02;
    public static TextureRegion trump_electricity_03;
    public static TextureRegion trump_electricity_04;
    public static TextureRegion trump_electricity_05;
    public static TextureRegion trump_electrocuted_position_jump_left;
    public static TextureRegion trump_electrocuted_position_jump_right;
    public static TextureRegion trump_electrocuted_position_wall_left;
    public static TextureRegion trump_electrocuted_position_wall_right;
    public static TextureRegion trump_eyes_closed;
    public static TextureRegion trump_eyes_open;
    public static TextureRegion trump_hand_dead_left;
    public static TextureRegion trump_hand_dead_right;
    public static TextureRegion trump_hand_left;
    public static TextureRegion trump_hand_right;
    public static TextureRegion trump_head_01_left;
    public static TextureRegion trump_head_01_right;
    public static TextureRegion trump_head_02_left;
    public static TextureRegion trump_head_02_right;
    public static TextureRegion trump_head_03_left;
    public static TextureRegion trump_head_03_right;
    public static TextureRegion trump_head_04_left;
    public static TextureRegion trump_head_04_right;
    public static TextureRegion trump_head_dead_left;
    public static TextureRegion trump_head_dead_right;
    public static TextureRegion trump_leg_dead_left;
    public static TextureRegion trump_leg_dead_right;
    public static TextureRegion trump_mouth_01_left;
    public static TextureRegion trump_mouth_01_right;
    public static TextureRegion trump_mouth_02_left;
    public static TextureRegion trump_mouth_02_right;
    public static TextureRegion trump_mouth_03_left;
    public static TextureRegion trump_mouth_03_right;
    public static TextureRegion trump_mouth_04_left;
    public static TextureRegion trump_mouth_04_right;

    public static Animation trump_hair_flip_right;
    public static TextureRegion [] trump_hair_flip_right_collection;
    public static Animation trump_hair_flip_left;
    public static TextureRegion [] trump_hair_flip_left_collection;
    public static Animation trump_hair_settle_right;
    public static TextureRegion [] trump_hair_settle_right_collection;
    public static Animation trump_hair_settle_left;
    public static TextureRegion [] trump_hair_settle_left_collection;

    // Fireworks
    public static Texture fireworksTexture;

    public static TextureRegion blue_firework_01;
    public static TextureRegion blue_firework_02;
    public static TextureRegion blue_firework_03;
    public static TextureRegion blue_firework_04;
    public static TextureRegion blue_firework_05;
    public static TextureRegion blue_firework_06;
    public static TextureRegion blue_firework_07;
    public static TextureRegion blue_firework_08;
    public static TextureRegion red_firework_01;
    public static TextureRegion red_firework_02;
    public static TextureRegion red_firework_03;
    public static TextureRegion red_firework_04;
    public static TextureRegion red_firework_05;
    public static TextureRegion red_firework_06;
    public static TextureRegion red_firework_07;
    public static TextureRegion red_firework_08;
    public static TextureRegion yellow_firework_01;
    public static TextureRegion yellow_firework_02;
    public static TextureRegion yellow_firework_03;
    public static TextureRegion yellow_firework_04;
    public static TextureRegion yellow_firework_05;
    public static TextureRegion yellow_firework_06;
    public static TextureRegion yellow_firework_07;
    public static TextureRegion yellow_firework_08;
    public static Animation blueFirework;
    public static TextureRegion [] blueFireworkCollection;
    public static Animation redFirework;
    public static TextureRegion [] redFireworkCollection;
    public static Animation yellowFirework;
    public static TextureRegion [] yellowFireworkCollection;

    // Clouds
    public static Texture cloudsTexture;

    public static TextureRegion cloud_01_big_left;
    public static TextureRegion cloud_01_big_right;
    public static TextureRegion cloud_01_medium_left;
    public static TextureRegion cloud_01_medium_right;
    public static TextureRegion cloud_01_small_left;
    public static TextureRegion cloud_01_small_right;
    public static TextureRegion cloud_02_big_left;
    public static TextureRegion cloud_02_big_right;
    public static TextureRegion cloud_02_medium_left;
    public static TextureRegion cloud_02_medium_right;
    public static TextureRegion cloud_02_small_left;
    public static TextureRegion cloud_02_small_right;
    public static TextureRegion cloud_03_big_left;
    public static TextureRegion cloud_03_big_right;
    public static TextureRegion cloud_03_medium_left;
    public static TextureRegion cloud_03_medium_right;
    public static TextureRegion cloud_03_small_left;
    public static TextureRegion cloud_03_small_right;
    public static TextureRegion cloud_04_big_left;
    public static TextureRegion cloud_04_big_right;
    public static TextureRegion cloud_04_medium_left;
    public static TextureRegion cloud_04_medium_right;
    public static TextureRegion cloud_04_small_left;
    public static TextureRegion cloud_04_small_right;
    public static TextureRegion cloud_05_big_left;
    public static TextureRegion cloud_05_big_right;
    public static TextureRegion cloud_05_medium_left;
    public static TextureRegion cloud_05_medium_right;
    public static TextureRegion cloud_05_small_left;
    public static TextureRegion cloud_05_small_right;
    public static TextureRegion cloud_06_big_left;
    public static TextureRegion cloud_06_big_right;
    public static TextureRegion cloud_06_medium_left;
    public static TextureRegion cloud_06_medium_right;
    public static TextureRegion cloud_06_small_left;
    public static TextureRegion cloud_06_small_right;
    public static TextureRegion cloud_07_big_left;
    public static TextureRegion cloud_07_big_right;
    public static TextureRegion cloud_07_medium_left;
    public static TextureRegion cloud_07_medium_right;
    public static TextureRegion cloud_07_small_left;
    public static TextureRegion cloud_07_small_right;
    public static TextureRegion cloud_08_big_left;
    public static TextureRegion cloud_08_big_right;
    public static TextureRegion cloud_08_medium_left;
    public static TextureRegion cloud_08_medium_right;
    public static TextureRegion cloud_08_small_left;
    public static TextureRegion cloud_08_small_right;
    public static TextureRegion cloud_09_big_left;
    public static TextureRegion cloud_09_big_right;
    public static TextureRegion cloud_09_medium_left;
    public static TextureRegion cloud_09_medium_right;
    public static TextureRegion cloud_09_small_left;
    public static TextureRegion cloud_09_small_right;

    // Menues
    public static Texture menuesTexture;

    public static TextureRegion menu_frame;
    public static TextureRegion slider_background;
    public static TextureRegion slider_bar;
    public static TextureRegion slider_knob;

    // Buttons
    public static Texture buttonsTexture;

    public static TextureRegion home_button;
    public static TextureRegion home_button_pressed;
    public static TextureRegion menu_button;
    public static TextureRegion menu_button_pressed;
    public static TextureRegion minus_button;
    public static TextureRegion minus_button_pressed;
    public static TextureRegion next_button;
    public static TextureRegion next_button_pressed;
    public static TextureRegion no_button;
    public static TextureRegion no_button_pressed;
    public static TextureRegion no_sound_button;
    public static TextureRegion no_sound_button_pressed;
    public static TextureRegion ok_button;
    public static TextureRegion ok_button_pressed;
    public static TextureRegion pause_button;
    public static TextureRegion pause_button_pressed;
    public static TextureRegion play_button;
    public static TextureRegion play_button_pressed;
    public static TextureRegion plus_button;
    public static TextureRegion plus_button_pressed;
    public static TextureRegion previous_button;
    public static TextureRegion previous_button_pressed;
    public static TextureRegion replay_button;
    public static TextureRegion replay_button_pressed;
    public static TextureRegion right_arrow_button;
    public static TextureRegion right_arrow_button_pressed;
    public static TextureRegion settings_button;
    public static TextureRegion settings_button_pressed;
    public static TextureRegion sound_button;
    public static TextureRegion sound_button_pressed;


    // Obstacles
    public static Texture obstaclesTexture;
    public static TextureRegion reduntant;

    public static TextureRegion excalibur_solid;
    public static TextureRegion excalibur_transparent;
    public static TextureRegion missile_explosion_01;
    public static TextureRegion missile_explosion_02;
    public static TextureRegion missile_explosion_03;
    public static TextureRegion missile_explosion_04;
    public static TextureRegion missile_explosion_05;
    public static TextureRegion missile_explosion_06;
    public static TextureRegion missile_explosion_07;
    public static TextureRegion missile_explosion_08;
    public static TextureRegion missile_explosion_09;
    public static TextureRegion missile_explosion_10;
    public static TextureRegion missile_explosion_11;
    public static TextureRegion missile_explosion_12;
    public static TextureRegion missile_explosion_13;
    public static TextureRegion missile_01;
    public static TextureRegion missile_02;
    public static TextureRegion missile_fire_01;
    public static TextureRegion missile_fire_02;
    public static TextureRegion missile_fire_03;
    public static TextureRegion missile_fire_04;
    public static TextureRegion missile_fire_05;
    public static TextureRegion missile_fire_06;
    public static TextureRegion missile_fire_07;
    public static TextureRegion missile_fire_08;
    public static TextureRegion missile_warning;

    public static Animation missile;
    public static TextureRegion [] missileCollection;
    public static Animation missile_fire;
    public static TextureRegion [] missileFireCollection;
    public static Animation missile_explosion;
    public static TextureRegion [] missileExplosionCollection;



    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////


    public static void load(GLGame game){
        glGame = game;
        loadAlwaysLoaded(glGame);

    }
    public static void load(){
        loadAlwaysLoaded(glGame);
        if(onScreen.equals("MainMenuScreen")) {
            loadMainMenu(glGame);
        } else if (onScreen.equals("GameScreen")) {
            loadGameScreen(glGame);
        }
    }


    public static void reload(){
        reloadAlwaysLoaded();
        if(onScreen.equals("MainMenuScreen")) {
            reloadMainMenu();
        } else if (onScreen.equals("GameScreen")) {
            reloadGameScreen();
        }
    }

    public static void dispose(){
        unloadAlwaysLoaded();
        if(onScreen.equals("MainMenuScreen")) {
            unloadMainMenu();
        } else if (onScreen.equals("GameScreen")) {
            unloadGameScreen();
        }
    }

    public static void clear(){
        clearAlwaysLoaded();
        if(onScreen.equals("MainMenuScreen")) {
            clearMainMenu();
        } else if (onScreen.equals("GameScreen")) {
            clearGameScreen();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////


    public static void loadAlwaysLoaded(GLGame game){

        SplashScreenScreen = new Texture(game, "SplashScreen.png");
        SplashScreen = new TextureRegion(SplashScreenScreen, 0, 0, 480, 800);

        // Collision lines
        collisionLinesTexture = new Texture(game, "CollisionLines.png");
        line = new TextureRegion(collisionLinesTexture, 519, 2, 2, 2);
        circle = new TextureRegion(collisionLinesTexture, 2, 2, 515, 515);

        loadText(game);
    }
    public static void reloadAlwaysLoaded(){
        if (SplashScreenScreen != null) {
            SplashScreenScreen.reload();
        } else {
            System.out.println("Error reloading SplashScreenScreen");
        }
        if (collisionLinesTexture != null) {
            collisionLinesTexture.reload();
        } else {
            System.out.println("Error reloading collisionLinesTexture");
        }

        reloadText();
    }
    public static void unloadAlwaysLoaded(){
        if (SplashScreenScreen != null) {
            SplashScreenScreen.dispose();
        }
        if (collisionLinesTexture != null) {
            collisionLinesTexture.dispose();
        }

        unloadText();
    }
    public static void clearAlwaysLoaded(){

        unloadAlwaysLoaded();

        SplashScreenScreen = null;
        SplashScreen = null;

        // Collision lines
        collisionLinesTexture = null;
        line = null;
        circle = null;

        clearText();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////


    public static void loadText(GLGame game) {
        textSpriteSheet = new Texture(game, "other/text.png");

        a_lower = new TextureRegion(textSpriteSheet, 606, 144, 32, 31);
        a_upper = new TextureRegion(textSpriteSheet, 88, 146, 32, 43);
        apostrophe = new TextureRegion(textSpriteSheet, 649, 214, 7, 12);
        at = new TextureRegion(textSpriteSheet, 512, 3, 38, 43);
        b_lower = new TextureRegion(textSpriteSheet, 463, 88, 32, 43);
        b_upper = new TextureRegion(textSpriteSheet, 554, 3, 32, 43);
        backwards_dash = new TextureRegion(textSpriteSheet, 713, 179, 20, 40);
        c_lower = new TextureRegion(textSpriteSheet, 642, 144, 32, 31);
        c_upper = new TextureRegion(textSpriteSheet, 124, 146, 32, 43);
        comma = new TextureRegion(textSpriteSheet, 638, 214, 7, 19);
        d_lower = new TextureRegion(textSpriteSheet, 590, 3, 32, 43);
        d_upper = new TextureRegion(textSpriteSheet, 160, 146, 32, 43);
        dollar = new TextureRegion(textSpriteSheet, 626, 3, 32, 43);
        e_lower = new TextureRegion(textSpriteSheet, 678, 144, 32, 31);
        e_upper = new TextureRegion(textSpriteSheet, 196, 146, 32, 43);
        equal = new TextureRegion(textSpriteSheet, 494, 221, 31, 26);
        exclamation_mark = new TextureRegion(textSpriteSheet, 787, 97, 7, 43);
        f_lower = new TextureRegion(textSpriteSheet, 770, 3, 25, 43);
        f_upper = new TextureRegion(textSpriteSheet, 662, 3, 32, 43);
        forward_dash = new TextureRegion(textSpriteSheet, 737, 179, 20, 40);
        g_lower = new TextureRegion(textSpriteSheet, 512, 50, 32, 38);
        g_upper = new TextureRegion(textSpriteSheet, 232, 146, 32, 43);
        gear_01 = new TextureRegion(textSpriteSheet, 427, 3, 81, 81);
        gear_02 = new TextureRegion(textSpriteSheet, 3, 146, 81, 81);
        h_lower = new TextureRegion(textSpriteSheet, 698, 3, 32, 43);
        h_upper = new TextureRegion(textSpriteSheet, 268, 146, 32, 43);
        hyphen = new TextureRegion(textSpriteSheet, 3, 231, 31, 7);
        i_lower = new TextureRegion(textSpriteSheet, 786, 144, 7, 43);
        i_upper = new TextureRegion(textSpriteSheet, 412, 146, 19, 43);
        j_lower = new TextureRegion(textSpriteSheet, 427, 88, 32, 50);
        j_upper = new TextureRegion(textSpriteSheet, 734, 3, 32, 43);
        k_lower = new TextureRegion(textSpriteSheet, 435, 142, 25, 43);
        k_upper = new TextureRegion(textSpriteSheet, 304, 146, 32, 43);
        l_lower = new TextureRegion(textSpriteSheet, 761, 179, 13, 43);
        l_upper = new TextureRegion(textSpriteSheet, 340, 146, 32, 43);
        m_lower = new TextureRegion(textSpriteSheet, 714, 144, 32, 31);
        m_upper = new TextureRegion(textSpriteSheet, 376, 146, 32, 43);
        n_lower = new TextureRegion(textSpriteSheet, 750, 144, 32, 31);
        n_upper = new TextureRegion(textSpriteSheet, 548, 50, 32, 43);
        number_0 = new TextureRegion(textSpriteSheet, 584, 50, 32, 43);
        number_1 = new TextureRegion(textSpriteSheet, 764, 50, 31, 43);
        number_2 = new TextureRegion(textSpriteSheet, 620, 50, 32, 43);
        number_3 = new TextureRegion(textSpriteSheet, 656, 50, 32, 43);
        number_4 = new TextureRegion(textSpriteSheet, 692, 50, 32, 43);
        number_5 = new TextureRegion(textSpriteSheet, 728, 50, 32, 43);
        number_6 = new TextureRegion(textSpriteSheet, 88, 193, 32, 43);
        number_7 = new TextureRegion(textSpriteSheet, 124, 193, 32, 43);
        number_8 = new TextureRegion(textSpriteSheet, 160, 193, 32, 43);
        number_9 = new TextureRegion(textSpriteSheet, 196, 193, 32, 43);
        o_lower = new TextureRegion(textSpriteSheet, 494, 186, 32, 31);
        o_upper = new TextureRegion(textSpriteSheet, 232, 193, 32, 43);
        p_lower = new TextureRegion(textSpriteSheet, 535, 97, 32, 38);
        p_upper = new TextureRegion(textSpriteSheet, 268, 193, 32, 43);
        parenthesis_left = new TextureRegion(textSpriteSheet, 412, 193, 26, 43);
        parenthesis_right = new TextureRegion(textSpriteSheet, 442, 189, 25, 43);
        period = new TextureRegion(textSpriteSheet, 549, 221, 7, 13);
        pound = new TextureRegion(textSpriteSheet, 464, 135, 31, 43);
        q_lower = new TextureRegion(textSpriteSheet, 571, 97, 32, 38);
        q_upper = new TextureRegion(textSpriteSheet, 304, 193, 32, 43);
        question_mark = new TextureRegion(textSpriteSheet, 340, 193, 32, 43);
        quotation_mark = new TextureRegion(textSpriteSheet, 529, 221, 16, 13);
        r_lower = new TextureRegion(textSpriteSheet, 530, 186, 32, 31);
        r_upper = new TextureRegion(textSpriteSheet, 376, 193, 32, 43);
        s_lower = new TextureRegion(textSpriteSheet, 570, 181, 32, 31);
        s_upper = new TextureRegion(textSpriteSheet, 499, 92, 32, 43);
        semi_colon = new TextureRegion(textSpriteSheet, 778, 191, 7, 38);
        t_lower = new TextureRegion(textSpriteSheet, 471, 182, 19, 43);
        t_upper = new TextureRegion(textSpriteSheet, 535, 139, 31, 43);
        text_background = new TextureRegion(textSpriteSheet, 535, 92, 1, 1);
        twitter_board_bottom = new TextureRegion(textSpriteSheet, 3, 77, 420, 65);
        twitter_board_top = new TextureRegion(textSpriteSheet, 3, 3, 420, 70);
        u_lower = new TextureRegion(textSpriteSheet, 566, 216, 32, 31);
        u_upper = new TextureRegion(textSpriteSheet, 607, 97, 32, 43);
        v_lower = new TextureRegion(textSpriteSheet, 602, 216, 32, 31);
        v_upper = new TextureRegion(textSpriteSheet, 643, 97, 32, 43);
        w_lower = new TextureRegion(textSpriteSheet, 606, 179, 32, 31);
        w_upper = new TextureRegion(textSpriteSheet, 679, 97, 32, 43);
        x_lower = new TextureRegion(textSpriteSheet, 642, 179, 32, 31);
        x_upper = new TextureRegion(textSpriteSheet, 715, 97, 32, 43);
        y_lower = new TextureRegion(textSpriteSheet, 570, 139, 32, 38);
        y_upper = new TextureRegion(textSpriteSheet, 751, 97, 32, 43);
        z_lower = new TextureRegion(textSpriteSheet, 678, 179, 31, 31);
        z_upper = new TextureRegion(textSpriteSheet, 499, 139, 32, 43);

        gear_collection = new TextureRegion[] {gear_01, gear_02};
        gear = new Animation(1.0f, gear_collection);
    }

    public static void reloadText() {
        if (textSpriteSheet != null) {
            textSpriteSheet.reload();
        }
    }

    public static void unloadText() {
        if (textSpriteSheet != null) {
            textSpriteSheet.dispose();
        }
    }

    public static void clearText() {
        textSpriteSheet = null;

        a_lower = null;
        a_upper = null;
        apostrophe = null;
        at = null;
        b_lower = null;
        b_upper = null;
        backwards_dash = null;
        c_lower = null;
        c_upper = null;
        comma = null;
        d_lower = null;
        d_upper = null;
        dollar = null;
        e_lower = null;
        e_upper = null;
        equal = null;
        exclamation_mark = null;
        f_lower = null;
        f_upper = null;
        forward_dash = null;
        g_lower = null;
        g_upper = null;
        gear_01 = null;
        gear_02 = null;
        h_lower = null;
        h_upper = null;
        hyphen = null;
        i_lower = null;
        i_upper = null;
        j_lower = null;
        j_upper = null;
        k_lower = null;
        k_upper = null;
        l_lower = null;
        l_upper = null;
        m_lower = null;
        m_upper = null;
        n_lower = null;
        n_upper = null;
        number_0 = null;
        number_1 = null;
        number_2 = null;
        number_3 = null;
        number_4 = null;
        number_5 = null;
        number_6 = null;
        number_7 = null;
        number_8 = null;
        number_9 = null;
        o_lower = null;
        o_upper = null;
        p_lower = null;
        p_upper = null;
        parenthesis_left = null;
        parenthesis_right = null;
        period = null;
        pound = null;
        q_lower = null;
        q_upper = null;
        question_mark = null;
        quotation_mark = null;
        r_lower = null;
        r_upper = null;
        s_lower = null;
        s_upper = null;
        semi_colon = null;
        t_lower = null;
        t_upper = null;
        text_background = null;
        twitter_board_bottom = null;
        twitter_board_top = null;
        u_lower = null;
        u_upper = null;
        v_lower = null;
        v_upper = null;
        w_lower = null;
        w_upper = null;
        x_lower = null;
        x_upper = null;
        y_lower = null;
        y_upper = null;
        z_lower = null;
        z_upper = null;

        gear_collection = null;
        gear = null;
    }


    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////


    public static void loadMainMenu(GLGame game){
        loadTrump(game);
        loadFireworks(game);
        loadButtons(game);
        loadFence(game);
        loadMenues(game);

        // text_background
        plainSkyAndGroundTexture = new Texture(game, "environments/SkyAndGround.png");
        plainSkyAndGround = new TextureRegion(plainSkyAndGroundTexture, 0, 0, 480, 800);

        // Main menu_frame objects
        whiteHouseTexture = new Texture(game, "environments/Whitehouse.png");
        whiteHouse = new TextureRegion(whiteHouseTexture, 0, 0, 526, 382);

        presidentialJumpTitleTexture = new Texture(game, "titles/PresidentialJump.png");
        presidentialJumpTitle = new TextureRegion(presidentialJumpTitleTexture, 0, 0, 355, 113);
    }
    public static void reloadMainMenu(){
        reloadTrump();
        reloadFireworks();
        reloadButtons();
        reloadFence();
        reloadMenues();

        if (plainSkyAndGroundTexture != null) {
            plainSkyAndGroundTexture.reload();
        } else {
            System.out.println("Error reloading plainSkyAndGroundTexture");
        }
        if (whiteHouseTexture != null) {
            whiteHouseTexture.reload();
        } else {
            System.out.println("Error reloading whiteHouseTexture");
        }
        if (presidentialJumpTitleTexture != null) {
            presidentialJumpTitleTexture.reload();
        } else {
            System.out.println("Error reloading presidentialJumpTitleTexture");
        }
    }
    public static void unloadMainMenu(){
        unloadTrump();
        unloadFireworks();
        unloadButtons();
        unloadFence();
        unloadMenues();

        if (plainSkyAndGroundTexture != null) {
            plainSkyAndGroundTexture.dispose();
        }
        if (whiteHouseTexture != null) {
            whiteHouseTexture.dispose();
        }
        if (presidentialJumpTitleTexture != null) {
            presidentialJumpTitleTexture.dispose();
        }
    }
    public static void clearMainMenu(){
        clearTrump();
        clearFireworks();
        clearButtons();
        clearFence();
        clearMenues();

        unloadMainMenu();
        plainSkyAndGroundTexture = null;
        plainSkyAndGround = null;
        whiteHouseTexture = null;
        whiteHouse = null;
        presidentialJumpTitleTexture = null;
        presidentialJumpTitle = null;
    }


    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////


    public static void loadGameScreen(GLGame game){
        loadTrump(game);
        loadFireworks(game);
        loadClouds(game);
        loadMenues(game);
        loadButtons(game);
        loadFence(game);
        loadObstacles(game);

        // text_background
        plainSkyAndGroundTexture = new Texture(game, "environments/SkyAndGround.png");
        plainSkyAndGround = new TextureRegion(plainSkyAndGroundTexture, 0, 0, 480, 800);

        backgroundsTexture = new Texture(game, "environments/Backgrounds.png");

        background_01 = new TextureRegion(backgroundsTexture, 3, 3, 480, 800);
        background_02 = new TextureRegion(backgroundsTexture, 487, 3, 480, 800);
        background_03 = new TextureRegion(backgroundsTexture, 971, 3, 480, 800);
        background_04 = new TextureRegion(backgroundsTexture, 1455, 3, 480, 800);
        background_05 = new TextureRegion(backgroundsTexture, 3, 807, 480, 800);
        background_06 = new TextureRegion(backgroundsTexture, 487, 807, 480, 800);
        background_07 = new TextureRegion(backgroundsTexture, 971, 807, 480, 800);
        background_08 = new TextureRegion(backgroundsTexture, 1455, 807, 480, 800);
        background_09 = new TextureRegion(backgroundsTexture, 3, 1611, 480, 800);

        background_transition_01 = new TextureRegion(backgroundsTexture, 3, 2415, 480, 800);
        background_transition_02 = new TextureRegion(backgroundsTexture, 3, 3219, 480, 800);
        background_transition_03 = new TextureRegion(backgroundsTexture, 487, 1611, 480, 800);
        background_transition_04 = new TextureRegion(backgroundsTexture, 971, 1611, 480, 800);
        background_transition_05 = new TextureRegion(backgroundsTexture, 1455, 1611, 480, 800);
        background_transition_06 = new TextureRegion(backgroundsTexture, 487, 2415, 480, 800);
        background_transition_07 = new TextureRegion(backgroundsTexture, 487, 3219, 480, 800);
        background_transition_08 = new TextureRegion(backgroundsTexture, 971, 2415, 480, 800);
        background_transition_09 = new TextureRegion(backgroundsTexture, 971, 3219, 480, 800);

        // Main menu_frame objects
        whiteHouseTexture = new Texture(game, "environments/Whitehouse.png");
        whiteHouse = new TextureRegion(whiteHouseTexture, 0, 0, 526, 382);

    }
    public static void reloadGameScreen(){
        reloadTrump();
        reloadFireworks();
        reloadClouds();
        reloadMenues();
        reloadButtons();
        reloadFence();
        reloadObstacles();

        if (plainSkyAndGroundTexture != null) {
            plainSkyAndGroundTexture.reload();
        } else {
            System.out.println("Error reloading plainSkyAndGroundTexture");
        }
        if (backgroundsTexture != null) {
            backgroundsTexture.reload();
        } else {
            System.out.println("Error reloading backgroundTexture");
        }
        if (whiteHouseTexture != null) {
            whiteHouseTexture.reload();
        } else {
            System.out.println("Error reloading whiteHouseTexture");
        }
    }
    public static void unloadGameScreen(){
        unloadTrump();
        unloadFireworks();
        unloadClouds();
        unloadMenues();
        unloadButtons();
        unloadFence();
        unloadObstacles();

        if (plainSkyAndGroundTexture != null) {
            plainSkyAndGroundTexture.dispose();
        }
        if (backgroundsTexture != null) {
            backgroundsTexture.dispose();
        }
        if (whiteHouseTexture != null) {
            whiteHouseTexture.dispose();
        }
    }
    public static void clearGameScreen(){
        clearTrump();
        clearFireworks();
        clearClouds();
        clearMenues();
        clearButtons();
        clearFence();
        clearObstacles();

        unloadMainMenu();
        plainSkyAndGroundTexture = null;
        plainSkyAndGround = null;
        whiteHouseTexture = null;
        whiteHouse = null;
        backgroundsTexture = null;
        background_01 = null;
        background_02 = null;
        background_03 = null;
        background_04 = null;
        background_05 = null;
        background_06 = null;
        background_07 = null;
        background_08 = null;
        background_09 = null;
        background_transition_01 = null;
        background_transition_02 = null;
        background_transition_03 = null;
        background_transition_04 = null;
        background_transition_05 = null;
        background_transition_06 = null;
        background_transition_07 = null;
        background_transition_08 = null;
        background_transition_09 = null;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    // Menues

    public static void loadMenues(GLGame game) {
        menuesTexture = new Texture(game, "interactive/Menues.png");

        menu_frame = new TextureRegion(menuesTexture, 3, 3, 400, 600);
        slider_background = new TextureRegion(menuesTexture, 3, 607, 300, 10);
        slider_bar = new TextureRegion(menuesTexture, 3, 621, 300, 10);
        slider_knob = new TextureRegion(menuesTexture, 307, 607, 10, 10);
    }

    public static void reloadMenues() {
        if (menuesTexture != null) {
            menuesTexture.reload();
        }
    }

    public static void unloadMenues() {
        if (menuesTexture != null) {
            menuesTexture.dispose();
        }
    }

    public static void clearMenues() {
        menuesTexture = null;

        menu_frame = null;
        slider_background = null;
        slider_bar = null;
        slider_knob = null;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    // Buttons
    public static void loadButtons(GLGame game) {
        buttonsTexture = new Texture(game, "interactive/Buttons.png");

        home_button = new TextureRegion(buttonsTexture, 3, 3, 46, 43);
        home_button_pressed = new TextureRegion(buttonsTexture, 53, 3, 46, 43);
        menu_button = new TextureRegion(buttonsTexture, 103, 3, 46, 43);
        menu_button_pressed = new TextureRegion(buttonsTexture, 153, 3, 46, 43);
        minus_button = new TextureRegion(buttonsTexture, 203, 3, 46, 43);
        minus_button_pressed = new TextureRegion(buttonsTexture, 3, 50, 46, 43);
        next_button = new TextureRegion(buttonsTexture, 53, 50, 46, 43);
        next_button_pressed = new TextureRegion(buttonsTexture, 103, 50, 46, 43);
        no_button = new TextureRegion(buttonsTexture, 153, 50, 46, 43);
        no_button_pressed = new TextureRegion(buttonsTexture, 203, 50, 46, 43);
        no_sound_button = new TextureRegion(buttonsTexture, 3, 97, 46, 43);
        no_sound_button_pressed = new TextureRegion(buttonsTexture, 53, 97, 46, 43);
        ok_button = new TextureRegion(buttonsTexture, 103, 97, 46, 43);
        ok_button_pressed = new TextureRegion(buttonsTexture, 153, 97, 46, 43);
        pause_button = new TextureRegion(buttonsTexture, 203, 97, 46, 43);
        pause_button_pressed = new TextureRegion(buttonsTexture, 3, 144, 46, 43);
        play_button = new TextureRegion(buttonsTexture, 53, 144, 46, 43);
        play_button_pressed = new TextureRegion(buttonsTexture, 103, 144, 46, 43);
        plus_button = new TextureRegion(buttonsTexture, 153, 144, 46, 43);
        plus_button_pressed = new TextureRegion(buttonsTexture, 203, 144, 46, 43);
        previous_button = new TextureRegion(buttonsTexture,  3, 191, 46, 43);
        previous_button_pressed = new TextureRegion(buttonsTexture, 53, 191, 46, 43);
        replay_button = new TextureRegion(buttonsTexture, 103, 191, 46, 43);
        replay_button_pressed = new TextureRegion(buttonsTexture, 153, 191, 46, 43);
        right_arrow_button = new TextureRegion(buttonsTexture, 203, 191, 46, 43);
        right_arrow_button_pressed = new TextureRegion(buttonsTexture, 3, 238, 46, 43);
        settings_button = new TextureRegion(buttonsTexture, 53, 238, 46, 43);
        settings_button_pressed = new TextureRegion(buttonsTexture, 103, 238, 46, 43);
        sound_button = new TextureRegion(buttonsTexture, 153, 238, 46, 43);
        sound_button_pressed = new TextureRegion(buttonsTexture, 203, 238, 46, 43);
    }

    public static void reloadButtons() {
        if (buttonsTexture != null) {
            buttonsTexture.reload();
        } else {
            System.out.println("Error reloading buttonsTexture");
        }
    }

    public static void unloadButtons() {
        if (buttonsTexture != null) {
            buttonsTexture.dispose();
        }
    }

    public static void clearButtons() {
        unloadButtons();

        buttonsTexture = null;
        home_button = null;
        home_button_pressed = null;
        menu_button = null;
        menu_button_pressed = null;
        minus_button = null;
        minus_button_pressed = null;
        next_button = null;
        next_button_pressed = null;
        no_button = null;
        no_button_pressed = null;
        no_sound_button = null;
        no_sound_button_pressed = null;
        ok_button = null;
        ok_button_pressed = null;
        pause_button = null;
        pause_button_pressed = null;
        play_button = null;
        play_button_pressed = null;
        plus_button = null;
        plus_button_pressed = null;
        previous_button = null;
        previous_button_pressed = null;
        replay_button = null;
        replay_button_pressed = null;
        right_arrow_button = null;
        right_arrow_button_pressed = null;
        settings_button = null;
        settings_button_pressed = null;
        sound_button = null;
        sound_button_pressed = null;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    public static void loadFence(GLGame game) {
        fenceTexture = new Texture(game, "environments/Fence.png");

        metal_fence = new TextureRegion(fenceTexture, 3, 812, 480, 150);
        left_wall = new TextureRegion(fenceTexture, 3, 3, 90, 805);
        right_wall = new TextureRegion(fenceTexture, 97, 3, 90, 805);
        medium_wall = new TextureRegion(fenceTexture, 191, 3, 90, 405);
        small_wall = new TextureRegion(fenceTexture, 191, 412, 90, 145);
        dust_01 = new TextureRegion(fenceTexture, 191, 561, 10, 15);
        dust_02 = new TextureRegion(fenceTexture, 205, 561, 10, 15);

        dust_right_collection = new TextureRegion[] {dust_01, dust_02};
        dust_left_collection = new TextureRegion[] {dust_02, dust_01};

        dust_right = new Animation(1.0f, dust_right_collection);
        dust_left = new Animation(1.0f, dust_left_collection);

        electricBoundry = new Texture(game, "environments/VerticalBoundries.png");
        electric_boundry_01 = new TextureRegion(electricBoundry, 3, 3 ,480, 20);
        electric_boundry_02 = new TextureRegion(electricBoundry, 3, 27, 480, 20);
        electric_boundry_collection = new TextureRegion[] {electric_boundry_01, electric_boundry_02};
        electric_boundry = new Animation(1.0f, electric_boundry_collection);
    }

    public static void reloadFence() {
        if (fenceTexture != null) {
            fenceTexture.reload();
        } else {
            System.out.println("Error reloading fenceTexture");
        }
        if (electricBoundry != null) {
            electricBoundry.reload();
        }
    }

    public static void unloadFence() {
        if (fenceTexture != null) {
            fenceTexture.dispose();
        }
        if (electricBoundry != null) {
            electricBoundry.dispose();
        }
    }

    public static void clearFence() {
        unloadFence();

        fenceTexture = null;

        metal_fence = null;
        left_wall = null;
        right_wall = null;
        medium_wall = null;
        small_wall = null;
        dust_01 = null;
        dust_02 = null;
        dust_right = null;
        dust_left = null;
        dust_right_collection = null;
        dust_left_collection = null;

        electricBoundry = null;
        electric_boundry_01 = null;
        electric_boundry_02 = null;
        electric_boundry_collection = null;
        electric_boundry = null;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    // Trump
    public static void loadTrump(GLGame game) {
        trumpallbodyparts = new Texture(game, "characters/TrumpSpriteSheet.png");

        trump_arm_dead = new TextureRegion(trumpallbodyparts, 309, 231, 5, 20);
        trump_blood = new TextureRegion(trumpallbodyparts, 3, 250, 1, 1);
        trump_body_dead_left = new TextureRegion(trumpallbodyparts, 459, 221, 25, 25);
        trump_body_dead_right = new TextureRegion(trumpallbodyparts, 488, 221, 25, 25);
        trump_body_jump_left = new TextureRegion(trumpallbodyparts, 637, 211, 45, 40);
        trump_body_jump_right = new TextureRegion(trumpallbodyparts, 686, 211, 45, 40);
        trump_body_left = new TextureRegion(trumpallbodyparts, 735, 211, 45, 40);
        trump_body_right = new TextureRegion(trumpallbodyparts, 784, 211, 45, 40);
        trump_body_slide_left = new TextureRegion(trumpallbodyparts, 833, 211, 45, 40);
        trump_body_slide_right = new TextureRegion(trumpallbodyparts, 882, 211, 45, 40);
        trump_disintegrate_block = new TextureRegion(trumpallbodyparts, 253, 245, 5, 5);
        trump_electricity_01 = new TextureRegion(trumpallbodyparts, 3, 3, 110, 110);
        trump_electricity_02 = new TextureRegion(trumpallbodyparts, 3, 117, 110, 110);
        trump_electricity_03 = new TextureRegion(trumpallbodyparts, 117, 3, 110, 110);
        trump_electricity_04 = new TextureRegion(trumpallbodyparts, 117, 117, 110, 110);
        trump_electricity_05 = new TextureRegion(trumpallbodyparts, 231, 3, 110, 110);
        trump_electrocuted_position_jump_left = new TextureRegion(trumpallbodyparts, 231, 117, 110, 110);
        trump_electrocuted_position_jump_right = new TextureRegion(trumpallbodyparts, 345, 3, 110, 110);
        trump_electrocuted_position_wall_left = new TextureRegion(trumpallbodyparts, 345, 117, 110, 110);
        trump_electrocuted_position_wall_right = new TextureRegion(trumpallbodyparts, 459, 3, 110, 110);
        trump_eyes_closed = new TextureRegion(trumpallbodyparts, 195, 245, 25, 5);
        trump_eyes_open = new TextureRegion(trumpallbodyparts, 224, 245, 25, 5);
        trump_hand_dead_left = new TextureRegion(trumpallbodyparts, 195, 231, 20, 10);
        trump_hand_dead_right = new TextureRegion(trumpallbodyparts, 219, 231, 20, 10);
        trump_hand_left = new TextureRegion(trumpallbodyparts, 243, 231, 15, 10);
        trump_hand_right = new TextureRegion(trumpallbodyparts, 290, 231, 15, 10);
        trump_head_01_left = new TextureRegion(trumpallbodyparts, 459, 117, 85, 100);
        trump_head_01_right = new TextureRegion(trumpallbodyparts, 548, 117, 85, 100);
        trump_head_02_left = new TextureRegion(trumpallbodyparts, 573, 3, 85, 100);
        trump_head_02_right = new TextureRegion(trumpallbodyparts, 637, 107, 85, 100);
        trump_head_03_left = new TextureRegion(trumpallbodyparts, 662, 3, 85, 100);
        trump_head_03_right = new TextureRegion(trumpallbodyparts, 726, 107, 85, 100);
        trump_head_04_left = new TextureRegion(trumpallbodyparts, 751, 3, 85, 100);
        trump_head_04_right = new TextureRegion(trumpallbodyparts, 815, 107, 85, 100);
        trump_head_dead_left = new TextureRegion(trumpallbodyparts, 840, 3, 85, 87);
        trump_head_dead_right = new TextureRegion(trumpallbodyparts, 904, 94, 85, 87);
        trump_leg_dead_left = new TextureRegion(trumpallbodyparts, 262, 231, 10, 15);
        trump_leg_dead_right = new TextureRegion(trumpallbodyparts, 276, 231, 10, 15);
        trump_mouth_01_left = new TextureRegion(trumpallbodyparts, 3, 231, 20, 15);
        trump_mouth_01_right = new TextureRegion(trumpallbodyparts, 27, 231, 20, 15);
        trump_mouth_02_left = new TextureRegion(trumpallbodyparts, 51, 231, 20, 15);
        trump_mouth_02_right = new TextureRegion(trumpallbodyparts, 75, 231, 20, 15);
        trump_mouth_03_left = new TextureRegion(trumpallbodyparts, 99, 231, 20, 15);
        trump_mouth_03_right = new TextureRegion(trumpallbodyparts, 123, 231, 20, 15);
        trump_mouth_04_left = new TextureRegion(trumpallbodyparts, 147, 231, 20, 15);
        trump_mouth_04_right = new TextureRegion(trumpallbodyparts, 171, 231, 20, 15);

        trump_hair_flip_right_collection = new TextureRegion[] {trump_head_01_right, trump_head_02_right, trump_head_03_right, trump_head_04_right};
        trump_hair_flip_right = new Animation(1.0f, trump_hair_flip_right_collection);

        trump_hair_flip_left_collection = new TextureRegion[] {trump_head_01_left, trump_head_02_left, trump_head_03_left, trump_head_04_left};
        trump_hair_flip_left = new Animation(1.0f, trump_hair_flip_left_collection);

        trump_hair_settle_right_collection = new TextureRegion[] {trump_head_04_right, trump_head_03_right, trump_head_02_right, trump_head_01_right};
        trump_hair_settle_right = new Animation(1.0f, trump_hair_settle_right_collection);

        trump_hair_settle_left_collection = new TextureRegion[] {trump_head_04_left, trump_head_03_left, trump_head_02_left, trump_head_01_left};
        trump_hair_settle_left = new Animation(1.0f, trump_hair_settle_left_collection);
    }

    public static void reloadTrump() {
        if (trumpallbodyparts != null) {
            trumpallbodyparts.reload();
        } else {
            System.out.println("Error reloading trumpallbodyparts");
        }
    }

    public static void unloadTrump() {
        if (trumpallbodyparts != null) {
            trumpallbodyparts.dispose();
        }
    }

    public static void clearTrump()  {
        unloadTrump();

        trump_arm_dead = null;
        trump_blood = null;
        trump_body_dead_left = null;
        trump_body_dead_right = null;
        trump_body_jump_left = null;
        trump_body_jump_right = null;
        trump_body_left = null;
        trump_body_right = null;
        trump_body_slide_left = null;
        trump_body_slide_right = null;
        trump_disintegrate_block = null;
        trump_electricity_01 = null;
        trump_electricity_02 = null;
        trump_electricity_03 = null;
        trump_electricity_04 = null;
        trump_electricity_05 = null;
        trump_electrocuted_position_jump_left = null;
        trump_electrocuted_position_jump_right = null;
        trump_electrocuted_position_wall_left = null;
        trump_electrocuted_position_wall_right = null;
        trump_eyes_closed = null;
        trump_eyes_open = null;
        trump_hand_dead_left = null;
        trump_hand_dead_right = null;
        trump_hand_left = null;
        trump_hand_right = null;
        trump_head_01_left = null;
        trump_head_01_right = null;
        trump_head_02_left = null;
        trump_head_02_right = null;
        trump_head_03_left = null;
        trump_head_03_right = null;
        trump_head_04_left = null;
        trump_head_04_right = null;
        trump_head_dead_left = null;
        trump_head_dead_right = null;
        trump_leg_dead_left = null;
        trump_leg_dead_right = null;
        trump_mouth_01_left = null;
        trump_mouth_01_right = null;
        trump_mouth_02_left = null;
        trump_mouth_02_right = null;
        trump_mouth_03_left = null;
        trump_mouth_03_right = null;
        trump_mouth_04_left = null;
        trump_mouth_04_right = null;

        trump_hair_flip_right_collection = null;
        trump_hair_flip_right = null;
        trump_hair_flip_left_collection = null;
        trump_hair_flip_left = null;
        trump_hair_settle_right = null;
        trump_hair_settle_right_collection = null;
        trump_hair_settle_left = null;
        trump_hair_settle_left_collection = null;

    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    // Fireworks
    public static void loadFireworks(GLGame game) {
        fireworksTexture = new Texture(game, "environments/Fireworks.png");

        blue_firework_01 = new TextureRegion(fireworksTexture, 3, 3, 75, 75);
        blue_firework_02 = new TextureRegion(fireworksTexture, 3, 82, 75, 75);
        blue_firework_03 = new TextureRegion(fireworksTexture, 3, 161, 75, 75);
        blue_firework_04 = new TextureRegion(fireworksTexture, 3, 240, 75, 75);
        blue_firework_05 = new TextureRegion(fireworksTexture, 3, 319, 75, 75);
        blue_firework_06 = new TextureRegion(fireworksTexture, 3, 398, 75, 75);
        blue_firework_07 = new TextureRegion(fireworksTexture, 82, 3, 75, 75);
        blue_firework_08 = new TextureRegion(fireworksTexture, 82, 82, 75, 75);
        blueFireworkCollection = new TextureRegion[] {blue_firework_01, blue_firework_02, blue_firework_03, blue_firework_04, blue_firework_05, blue_firework_06, blue_firework_07, blue_firework_08};
        blueFirework = new Animation(1.0f, blueFireworkCollection);

        red_firework_01 = new TextureRegion(fireworksTexture, 82, 161, 75, 75);
        red_firework_02 = new TextureRegion(fireworksTexture, 82, 240, 75, 75);
        red_firework_03 = new TextureRegion(fireworksTexture, 82, 319, 75, 75);
        red_firework_04 = new TextureRegion(fireworksTexture, 82, 398, 75, 75);
        red_firework_05 = new TextureRegion(fireworksTexture, 161, 3, 75, 75);
        red_firework_06 = new TextureRegion(fireworksTexture, 161, 82, 75, 75);
        red_firework_07 = new TextureRegion(fireworksTexture, 161, 161, 75, 75);
        red_firework_08 = new TextureRegion(fireworksTexture, 82, 82, 75, 75);
        redFireworkCollection = new TextureRegion[] {red_firework_01, red_firework_02, red_firework_03, red_firework_04, red_firework_05, red_firework_06, red_firework_07, red_firework_08};
        redFirework = new Animation(1.0f, redFireworkCollection);

        yellow_firework_01 = new TextureRegion(fireworksTexture, 161, 240, 75, 75);
        yellow_firework_02 = new TextureRegion(fireworksTexture, 161, 319, 75, 75);
        yellow_firework_03 = new TextureRegion(fireworksTexture, 161, 398, 75, 75);
        yellow_firework_04 = new TextureRegion(fireworksTexture, 240, 3, 75, 75);
        yellow_firework_05 = new TextureRegion(fireworksTexture, 240, 82, 75, 75);
        yellow_firework_06 = new TextureRegion(fireworksTexture, 240, 161, 75, 75);
        yellow_firework_07 = new TextureRegion(fireworksTexture, 240, 240, 75, 75);
        yellow_firework_08 = new TextureRegion(fireworksTexture, 82, 82, 75, 75);
        yellowFireworkCollection = new TextureRegion[] {yellow_firework_01, yellow_firework_02, yellow_firework_03, yellow_firework_04, yellow_firework_05, yellow_firework_06, yellow_firework_07, yellow_firework_08};
        yellowFirework = new Animation(1.0f, yellowFireworkCollection);

    }

    public static void reloadFireworks() {
        if (fireworksTexture != null) {
            fireworksTexture.reload();
        } else {
            System.out.println("Error reloading fireworksTexture");
        }
    }

    public static void unloadFireworks() {
        if (fireworksTexture != null) {
            fireworksTexture.dispose();
        }
    }

    public static void clearFireworks()  {
        unloadFireworks();
        fireworksTexture = null;
        blue_firework_01 = null;
        blue_firework_02 = null;
        blue_firework_03 = null;
        blue_firework_04 = null;
        blue_firework_05 = null;
        blue_firework_06 = null;
        blue_firework_07 = null;
        blue_firework_08 = null;
        blueFireworkCollection = null;
        blueFirework = null;
        red_firework_01 = null;
        red_firework_02 = null;
        red_firework_03 = null;
        red_firework_04 = null;
        red_firework_05 = null;
        red_firework_06 = null;
        red_firework_07 = null;
        red_firework_08 = null;
        redFireworkCollection = null;
        redFirework = null;
        yellow_firework_01 = null;
        yellow_firework_02 = null;
        yellow_firework_03 = null;
        yellow_firework_04 = null;
        yellow_firework_05 = null;
        yellow_firework_06 = null;
        yellow_firework_07 = null;
        yellow_firework_08 = null;
        yellowFireworkCollection = null;
        yellowFirework = null;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    // Clouds
    public static void loadClouds(GLGame game) {
        cloudsTexture = new Texture(game, "environments/Clouds.png");

        cloud_01_big_left = new TextureRegion(cloudsTexture, 3, 3, 130, 75);
        cloud_01_big_right = new TextureRegion(cloudsTexture, 3, 82, 130, 75);
        cloud_01_medium_left = new TextureRegion(cloudsTexture, 807, 3, 115, 75);
        cloud_01_medium_right = new TextureRegion(cloudsTexture, 807, 82, 115, 75);
        cloud_01_small_left = new TextureRegion(cloudsTexture, 1521, 3, 55, 35);
        cloud_01_small_right = new TextureRegion(cloudsTexture, 1521, 42, 55, 35);
        cloud_02_big_left = new TextureRegion(cloudsTexture, 3, 161, 130, 75);
        cloud_02_big_right = new TextureRegion(cloudsTexture, 137, 3, 130, 75);
        cloud_02_medium_left = new TextureRegion(cloudsTexture, 807, 161, 115, 75);
        cloud_02_medium_right = new TextureRegion(cloudsTexture, 926, 3, 115, 75);
        cloud_02_small_left = new TextureRegion(cloudsTexture, 1521, 81, 55, 35);
        cloud_02_small_right = new TextureRegion(cloudsTexture, 1521, 120, 55, 35);
        cloud_03_big_left = new TextureRegion(cloudsTexture, 137, 82, 130, 75);
        cloud_03_big_right = new TextureRegion(cloudsTexture, 137, 161, 130, 75);
        cloud_03_medium_left = new TextureRegion(cloudsTexture, 926, 82, 115, 75);
        cloud_03_medium_right = new TextureRegion(cloudsTexture, 926, 161, 115, 75);
        cloud_03_small_left = new TextureRegion(cloudsTexture, 1521, 198, 55, 35);
        cloud_03_small_right = new TextureRegion(cloudsTexture, 1521, 159, 55, 35);
        cloud_04_big_left = new TextureRegion(cloudsTexture, 271, 3, 130, 75);
        cloud_04_big_right = new TextureRegion(cloudsTexture, 271, 82, 130, 75);
        cloud_04_medium_left = new TextureRegion(cloudsTexture, 1045, 3, 115, 75);
        cloud_04_medium_right = new TextureRegion(cloudsTexture, 1045, 82, 115, 75);
        cloud_04_small_left = new TextureRegion(cloudsTexture, 1580, 3, 55, 35);
        cloud_04_small_right = new TextureRegion(cloudsTexture, 1580, 42, 55, 35);
        cloud_05_big_left = new TextureRegion(cloudsTexture, 271, 161, 130, 75);
        cloud_05_big_right = new TextureRegion(cloudsTexture, 405, 3, 130, 75);
        cloud_05_medium_left = new TextureRegion(cloudsTexture, 1045, 161, 115, 75);
        cloud_05_medium_right = new TextureRegion(cloudsTexture, 1164, 3, 115, 75);
        cloud_05_small_left = new TextureRegion(cloudsTexture, 1580, 81, 55, 35);
        cloud_05_small_right = new TextureRegion(cloudsTexture, 1580, 120, 55, 35);
        cloud_06_big_left = new TextureRegion(cloudsTexture, 405, 82, 130, 75);
        cloud_06_big_right = new TextureRegion(cloudsTexture, 405, 161, 130, 75);
        cloud_06_medium_left = new TextureRegion(cloudsTexture, 1164, 82, 115, 75);
        cloud_06_medium_right = new TextureRegion(cloudsTexture, 1164, 161, 115, 75);
        cloud_06_small_left = new TextureRegion(cloudsTexture, 1580, 159, 55, 35);
        cloud_06_small_right = new TextureRegion(cloudsTexture, 1580, 198, 55, 35);
        cloud_07_big_left = new TextureRegion(cloudsTexture, 539, 3, 130, 75);
        cloud_07_big_right = new TextureRegion(cloudsTexture, 539, 82, 130, 75);
        cloud_07_medium_left = new TextureRegion(cloudsTexture, 1283, 3, 115, 75);
        cloud_07_medium_right = new TextureRegion(cloudsTexture, 1283, 82, 115, 75);
        cloud_07_small_left = new TextureRegion(cloudsTexture, 1639, 3, 55, 35);
        cloud_07_small_right = new TextureRegion(cloudsTexture, 1639, 42, 55, 35);
        cloud_08_big_left = new TextureRegion(cloudsTexture, 539, 161, 130, 75);
        cloud_08_big_right = new TextureRegion(cloudsTexture, 673, 3, 130, 75);
        cloud_08_medium_left = new TextureRegion(cloudsTexture, 1283, 161, 115, 75);
        cloud_08_medium_right = new TextureRegion(cloudsTexture, 1402, 3, 115, 75);
        cloud_08_small_left = new TextureRegion(cloudsTexture, 1639, 81, 55, 35);
        cloud_08_small_right = new TextureRegion(cloudsTexture, 1639, 120, 55, 35);
        cloud_09_big_left = new TextureRegion(cloudsTexture, 673, 82, 130, 75);
        cloud_09_big_right = new TextureRegion(cloudsTexture, 673, 161, 130, 75);
        cloud_09_medium_left = new TextureRegion(cloudsTexture, 1402, 82, 115, 75);
        cloud_09_medium_right = new TextureRegion(cloudsTexture, 1402, 161, 115, 75);
        cloud_09_small_left = new TextureRegion(cloudsTexture, 1639, 159, 55, 35);
        cloud_09_small_right = new TextureRegion(cloudsTexture, 1639, 198, 55, 35);
    }

    public static void reloadClouds() {
        if (cloudsTexture != null) {
            cloudsTexture.reload();
        } else {
            System.out.println("Error reloading cloudsTexture");
        }
    }

    public static void unloadClouds() {
        if (cloudsTexture != null) {
            cloudsTexture.dispose();
        }
    }

    public static void clearClouds()  {
        cloudsTexture = null;
        cloud_01_big_left = null;
        cloud_01_big_right = null;
        cloud_01_medium_left = null;
        cloud_01_medium_right = null;
        cloud_01_small_left = null;
        cloud_01_small_right = null;
        cloud_02_big_left = null;
        cloud_02_big_right = null;
        cloud_02_medium_left = null;
        cloud_02_medium_right = null;
        cloud_02_small_left = null;
        cloud_02_small_right = null;
        cloud_03_big_left = null;
        cloud_03_big_right = null;
        cloud_03_medium_left = null;
        cloud_03_medium_right = null;
        cloud_03_small_left = null;
        cloud_03_small_right = null;
        cloud_04_big_left = null;
        cloud_04_big_right = null;
        cloud_04_medium_left = null;
        cloud_04_medium_right = null;
        cloud_04_small_left = null;
        cloud_04_small_right = null;
        cloud_05_big_left = null;
        cloud_05_big_right = null;
        cloud_05_medium_left = null;
        cloud_05_medium_right = null;
        cloud_05_small_left = null;
        cloud_05_small_right = null;
        cloud_06_big_left = null;
        cloud_06_big_right = null;
        cloud_06_medium_left = null;
        cloud_06_medium_right = null;
        cloud_06_small_left = null;
        cloud_06_small_right = null;
        cloud_07_big_left = null;
        cloud_07_big_right = null;
        cloud_07_medium_left = null;
        cloud_07_medium_right = null;
        cloud_07_small_left = null;
        cloud_07_small_right = null;
        cloud_08_big_left = null;
        cloud_08_big_right = null;
        cloud_08_medium_left = null;
        cloud_08_medium_right = null;
        cloud_08_small_left = null;
        cloud_08_small_right = null;
        cloud_09_big_left = null;
        cloud_09_big_right = null;
        cloud_09_medium_left = null;
        cloud_09_medium_right = null;
        cloud_09_small_left = null;
        cloud_09_small_right = null;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    public static void loadObstacles(GLGame game) {
        obstaclesTexture = new Texture(game, "objects/obstacles.png");
        reduntant = new TextureRegion(obstaclesTexture, 0, 0, 1, 1);

        excalibur_solid = new TextureRegion(obstaclesTexture, 3, 3, 1, 1);
        excalibur_transparent = new TextureRegion(obstaclesTexture, 8, 3, 1, 1);
        missile_explosion_01 = new TextureRegion(obstaclesTexture, 3, 25, 96, 96);
        missile_explosion_02 = new TextureRegion(obstaclesTexture, 103, 67, 96, 96);
        missile_explosion_03 = new TextureRegion(obstaclesTexture, 3, 125, 96, 96);
        missile_explosion_04 = new TextureRegion(obstaclesTexture, 103, 167, 96, 96);
        missile_explosion_05 = new TextureRegion(obstaclesTexture, 3, 225, 96, 96);
        missile_explosion_06 = new TextureRegion(obstaclesTexture, 103, 267, 96, 96);
        missile_explosion_07 = new TextureRegion(obstaclesTexture, 3, 325, 96, 96);
        missile_explosion_08 = new TextureRegion(obstaclesTexture, 103, 367, 96, 96);
        missile_explosion_09 = new TextureRegion(obstaclesTexture, 3, 425, 96, 96);
        missile_explosion_10 = new TextureRegion(obstaclesTexture, 103, 467, 96, 96);
        missile_explosion_11 = new TextureRegion(obstaclesTexture, 3, 525, 96, 96);
        missile_explosion_12 = new TextureRegion(obstaclesTexture, 103, 567, 96, 96);
        missile_explosion_13 = new TextureRegion(obstaclesTexture, 0, 0, 1, 1);
        missile_01 = new TextureRegion(obstaclesTexture, 136, 3, 24, 60);
        missile_02 = new TextureRegion(obstaclesTexture, 164, 3, 24, 60);
        missile_fire_01 = new TextureRegion(obstaclesTexture, 13, 3, 10, 18);
        missile_fire_02 = new TextureRegion(obstaclesTexture, 27, 3, 10, 18);
        missile_fire_03 = new TextureRegion(obstaclesTexture, 41, 3, 10, 18);
        missile_fire_04 = new TextureRegion(obstaclesTexture, 55, 3, 10, 18);
        missile_fire_05 = new TextureRegion(obstaclesTexture, 69, 3, 10, 18);
        missile_fire_06 = new TextureRegion(obstaclesTexture, 83, 3, 10, 18);
        missile_fire_07 = new TextureRegion(obstaclesTexture, 97, 3, 10, 18);
        missile_fire_08 = new TextureRegion(obstaclesTexture, 111, 3, 10, 18);
        missile_warning = new TextureRegion(obstaclesTexture, 125, 3, 7, 49);

        missileCollection = new TextureRegion[] {missile_01, missile_02};
        missile = new Animation(1.0f, missileCollection);

        missileFireCollection = new TextureRegion[] {missile_fire_01, missile_fire_02, missile_fire_03, missile_fire_04, missile_fire_05, missile_fire_06, missile_fire_07, missile_fire_08};
        missile_fire = new Animation(1.0f, missileFireCollection);

        missileExplosionCollection = new TextureRegion[] {missile_explosion_01, missile_explosion_02, missile_explosion_03, missile_explosion_04, missile_explosion_05, missile_explosion_06, missile_explosion_07,missile_explosion_08, missile_explosion_09, missile_explosion_10, missile_explosion_11, missile_explosion_12, missile_explosion_13};
        missile_explosion = new Animation(1.0f, missileExplosionCollection);
    }

    public static void reloadObstacles() {
        if (obstaclesTexture != null) {
            obstaclesTexture.reload();
        }
    }

    public static void unloadObstacles() {
        if (obstaclesTexture != null) {
            obstaclesTexture.dispose();
        }
    }

    public static void clearObstacles() {
        obstaclesTexture = null;

        excalibur_solid = null;
        excalibur_transparent = null;
        missile_explosion_01 = null;
        missile_explosion_02 = null;
        missile_explosion_03 = null;
        missile_explosion_04 = null;
        missile_explosion_05 = null;
        missile_explosion_06 = null;
        missile_explosion_07 = null;
        missile_explosion_08 = null;
        missile_explosion_09 = null;
        missile_explosion_10 = null;
        missile_explosion_11 = null;
        missile_explosion_12 = null;
        missile_01 = null;
        missile_02 = null;
        missile_fire_01 = null;
        missile_fire_02 = null;
        missile_fire_03 = null;
        missile_fire_04 = null;
        missile_fire_05 = null;
        missile_fire_06 = null;
        missile_fire_07 = null;
        missile_fire_08 = null;
        missile_warning = null;

        missileCollection = null;
        missile = null;

        missileFireCollection = null;
        missile_fire = null;

        missileExplosionCollection = null;
        missile_explosion = null;
    }
}
