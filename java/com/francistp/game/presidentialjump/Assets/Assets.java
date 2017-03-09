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

    // Main Menu
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

    public static TextureRegion trump_body_jump_left;
    public static TextureRegion trump_body_jump_right;
    public static TextureRegion trump_body_left;
    public static TextureRegion trump_body_right;
    public static TextureRegion trump_body_slide_left;
    public static TextureRegion trump_body_slide_right;
    public static TextureRegion trump_eyes_closed;
    public static TextureRegion trump_eyes_open;
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
    public static TextureRegion pause_title;
    public static TextureRegion results_title;

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
    }
    public static void unloadAlwaysLoaded(){
        if (SplashScreenScreen != null) {
            SplashScreenScreen.dispose();
        }
        if (collisionLinesTexture != null) {
            collisionLinesTexture.dispose();
        }
    }
    public static void clearAlwaysLoaded(){

        unloadAlwaysLoaded();

        SplashScreenScreen = null;
        SplashScreen = null;

        // Collision lines
        collisionLinesTexture = null;
        line = null;
        circle = null;
    }


    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////


    public static void loadMainMenu(GLGame game){
        loadTrump(game);
        loadFireworks(game);
        loadButtons(game);
        loadFence(game);

        // Background
        plainSkyAndGroundTexture = new Texture(game, "environments/SkyAndGround.png");
        plainSkyAndGround = new TextureRegion(plainSkyAndGroundTexture, 0, 0, 480, 800);

        // Main menu objects
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

        // Background
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

        // Main menu objects
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

        menu_frame = new TextureRegion(menuesTexture, 3, 3, 480, 800);
        pause_title = new TextureRegion(menuesTexture, 3, 870, 256, 59);
        results_title = new TextureRegion(menuesTexture, 3, 807, 265, 59);
    }

    public static void reloadMenues() {
        if (menuesTexture != null) {
            menuesTexture.reload();
        } else {
            System.out.println("Error reloading menuesTexture");
        }
    }

    public static void unloadMenues() {
        if (menuesTexture != null) {
            menuesTexture.dispose();
        }
    }

    public static void clearMenues() {
        unloadMenues();

        menuesTexture = null;
        menu_frame = null;
        pause_title = null;
        results_title = null;
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

        trump_body_jump_left = new TextureRegion(trumpallbodyparts, 3, 211, 45, 40);
        trump_body_jump_right = new TextureRegion(trumpallbodyparts, 52, 211, 45, 40);
        trump_body_left = new TextureRegion(trumpallbodyparts, 101, 211, 45, 40);
        trump_body_right = new TextureRegion(trumpallbodyparts, 150, 211, 45, 40);
        trump_body_slide_left = new TextureRegion(trumpallbodyparts, 199, 211, 45, 40);
        trump_body_slide_right = new TextureRegion(trumpallbodyparts, 248, 211, 45, 40);
        trump_eyes_closed = new TextureRegion(trumpallbodyparts, 297, 211, 25, 5);
        trump_eyes_open = new TextureRegion(trumpallbodyparts, 321, 230, 25, 5);
        trump_hand_left = new TextureRegion(trumpallbodyparts, 297, 240, 15, 10);
        trump_hand_right = new TextureRegion(trumpallbodyparts, 316, 240, 15, 10);
        trump_head_01_left = new TextureRegion(trumpallbodyparts, 3, 3, 85, 100);
        trump_head_01_right = new TextureRegion(trumpallbodyparts, 3, 107, 85, 100);
        trump_head_02_left = new TextureRegion(trumpallbodyparts, 92, 3, 85, 100);
        trump_head_02_right = new TextureRegion(trumpallbodyparts, 92, 107, 85, 100);
        trump_head_03_left = new TextureRegion(trumpallbodyparts, 199, 3, 85, 100);
        trump_head_03_right = new TextureRegion(trumpallbodyparts, 181, 107, 85, 100);
        trump_head_04_left = new TextureRegion(trumpallbodyparts, 270, 107, 85, 100);
        trump_head_04_right = new TextureRegion(trumpallbodyparts, 288, 3, 85, 100);
        trump_mouth_01_left = new TextureRegion(trumpallbodyparts, 359, 107, 20, 15);
        trump_mouth_01_right = new TextureRegion(trumpallbodyparts, 359, 126, 20, 15);
        trump_mouth_02_left = new TextureRegion(trumpallbodyparts, 359, 145, 20, 15);
        trump_mouth_02_right = new TextureRegion(trumpallbodyparts, 359, 164, 20, 15);
        trump_mouth_03_left = new TextureRegion(trumpallbodyparts, 359, 183, 20, 15);
        trump_mouth_03_right = new TextureRegion(trumpallbodyparts, 359, 202, 20, 15);
        trump_mouth_04_left = new TextureRegion(trumpallbodyparts, 297, 221, 20, 15);
        trump_mouth_04_right = new TextureRegion(trumpallbodyparts, 335, 211, 20, 15);

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

        trumpallbodyparts = null;
        trump_body_jump_left = null;
        trump_body_jump_right = null;
        trump_body_left = null;
        trump_body_right = null;
        trump_body_slide_left = null;
        trump_body_slide_right = null;
        trump_eyes_closed = null;
        trump_eyes_open = null;
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
}