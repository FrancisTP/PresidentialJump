package com.francistp.game.presidentialjump.Menues;

import android.annotation.SuppressLint;

import com.francistp.game.framework.CollisionTester;
import com.francistp.game.framework.Game;
import com.francistp.game.framework.GameObjectRectangle;
import com.francistp.game.framework.Input;
import com.francistp.game.framework.gl.Camera2D;
import com.francistp.game.framework.gl.FPSCounter;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.impl.GLScreen;
import com.francistp.game.framework.math.OverlapTester;
import com.francistp.game.framework.math.Rectangle;
import com.francistp.game.framework.math.Vector2;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Assets.Text;
import com.francistp.game.presidentialjump.Character.Player;
import com.francistp.game.presidentialjump.Character.Trump;
import com.francistp.game.presidentialjump.Decore.Background;
import com.francistp.game.presidentialjump.Decore.Fireworks;
import com.francistp.game.presidentialjump.Object.ElectricBoundary;
import com.francistp.game.presidentialjump.Object.Excalibur;
import com.francistp.game.presidentialjump.Object.ExcaliburController;
import com.francistp.game.presidentialjump.Object.MissileController;
import com.francistp.game.presidentialjump.Object.ObstaclesController;
import com.francistp.game.presidentialjump.Decore.TwitterBoardController;
import com.francistp.game.presidentialjump.Object.Wall;
import com.francistp.game.presidentialjump.Settings.SoundController;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by franc on 2017-01-18.
 */

public class GameScreen extends GLScreen {

    // Variables
    Camera2D guiCam;
    SpriteBatcher batcher;
    Vector2 touchPoint;
    FPSCounter fpsCounter = new FPSCounter();

    public static int state;
    public static final int LOADING_STATE = 0;
    public static final int READY_STATE = 1;
    public static final int RUNNING_STATE = 2;
    public static final int PAUSED_STATE = 3;
    public static final int FINISHED_STATE = 4;
    public static final int SETTING_STATE = 5;

    public static final float scrollSpeed = -1.5f;

    final int BOUNDS_NOT_TOUCHED = 0;
    final int BOUNDS_TOUCHED = 1;

    float stateTime = 3;

    Player player;
    Background background;
    Wall wall;

    ElectricBoundary topBoundary, bottomBoundary;

    private Text scoreText;
    private String scoreString;
    private int score, scoreCounter;


    Rectangle pauseBounds;
    int pauseState;
    PauseMenu pauseMenu;
    SettingMenu settingMenu;

    FinishedMenu finishedMenu;
    String deathCause;
    public static boolean gameStarted;

    // Obstacles
    ObstaclesController obstaclesController;
    TwitterBoardController twitterBoardController;

    public GameScreen(Game game, Fireworks fireworks) {
        super(game);
        guiCam = new Camera2D(glGraphics, 480, 800); // Screen resolution 1280x800
        batcher = new SpriteBatcher(glGraphics, 1000); // A maximum of 100 sprite per batch
        touchPoint = new Vector2();

        state = RUNNING_STATE;

        background =  new Background(fireworks);

        player = new Trump();

        wall = new Wall();

        topBoundary = new ElectricBoundary(240, 850);
        bottomBoundary = new ElectricBoundary(240, -50);

        //String text, int size, String colour, float x, float y, float width                                                                       - alignment left, no background
        //String text, int size, String colour, String alignment, float x, float y, float width                                                     - no background
        //String text, int size, String colour, float x, float y, float width, boolean background,  float backgroundHeight                          - alignment left
        //String text, int size, String colour, String alignment, float x, float y, float width, boolean background,  float backgroundHeight
        //String text, int size, String colour, float x, float y, float width, boolean background                                                   - alignment left, background autoSized
        //String text, int size, String colour, String alignment, float x, float y, float width, boolean background                                 - background autoSized
        scoreText = new Text("Score: 0000000", 7, "white", "left", 40, 750, 325, true);
        scoreString = "Score: ";
        score = 0;
        scoreCounter = 0;

        pauseBounds = new Rectangle(480 - Assets.pause_button.width - 5, 800 - Assets.pause_button.height - 5, Assets.pause_button.width*2, Assets.pause_button.height*2);
        pauseState = BOUNDS_NOT_TOUCHED;

        SoundController.requestSong("PimPoy.ogg");
        SoundController.pauseMusic();

        pauseMenu = new PauseMenu();
        settingMenu = new SettingMenu();

        deathCause = "";
        gameStarted = false;

        // obstacles
        obstaclesController = new ObstaclesController();
        twitterBoardController = new TwitterBoardController();
    }

    @Override
    public void update(float deltaTime){
        SoundController.update();


        if(Assets.readyState && state == RUNNING_STATE){
            List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
            game.getInput().getKeyEvents();

            listenToTouches(touchEvents, deltaTime);

            player.update(deltaTime);
            if (player.getPlayerState() != 0) {
                wall.scroll(scrollSpeed);
                background.scroll(scrollSpeed);
                twitterBoardController.update(deltaTime);

                if (topBoundary.getY() > 780) {
                    topBoundary.addY(-2f);
                    if (topBoundary.getY() < 780) {
                        topBoundary.setY(780);
                    }
                }
                if (bottomBoundary.getY() < 0) {
                    bottomBoundary.addY(2f);
                    if (bottomBoundary.getY() > 0) {
                        bottomBoundary.setY(0);
                    }
                }

                topBoundary.update();
                bottomBoundary.update();

                // update score
                scoreCounter++;
                if (scoreCounter >= 10) {
                    scoreCounter = 0;
                    score++;
                    if (Integer.toString(score).length() == 1) {
                        scoreText.setText(scoreString + "000000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 2) {
                        scoreText.setText(scoreString + "00000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 3) {
                        scoreText.setText(scoreString + "0000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 4) {
                        scoreText.setText(scoreString + "000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 5) {
                        scoreText.setText(scoreString + "00" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 6) {
                        scoreText.setText(scoreString + "0" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 7) {
                        scoreText.setText(scoreString + Integer.toString(score));
                    }
                }
            }
            background.update(deltaTime);

            wall.checkWall();
            background.checkBackgrounds();

            checkAndSetPlayer(player, wall);

            obstaclesController.update(deltaTime);

            if (checkIfHit()) {
                player.setDead(true);
                pauseState = BOUNDS_NOT_TOUCHED;
                state = FINISHED_STATE;
                finishedMenu = new FinishedMenu(score,deathCause);
            }

        } else if (Assets.readyState && state == PAUSED_STATE) {
            List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
            game.getInput().getKeyEvents();

            pauseMenu.update(deltaTime, score);
            pauseMenu.listenToTouches(touchEvents, touchPoint, guiCam, game, glGame);
        } else if (Assets.readyState && state == FINISHED_STATE) {
            List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
            game.getInput().getKeyEvents();

            player.update(deltaTime);
            if (player.getPlayerState() != 0) {
                wall.scroll(scrollSpeed);
                background.scroll(scrollSpeed);

                if (topBoundary.getY() > 780) {
                    topBoundary.addY(-2f);
                    if (topBoundary.getY() < 780) {
                        topBoundary.setY(780);
                    }
                }
                if (bottomBoundary.getY() < 0) {
                    bottomBoundary.addY(2f);
                    if (bottomBoundary.getY() > 0) {
                        bottomBoundary.setY(0);
                    }
                }

                topBoundary.update();
                bottomBoundary.update();

                if (scoreCounter >= 10) {
                    scoreCounter = 0;
                    score++;
                    if (Integer.toString(score).length() == 1) {
                        scoreText.setText(scoreString + "000000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 2) {
                        scoreText.setText(scoreString + "00000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 3) {
                        scoreText.setText(scoreString + "0000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 4) {
                        scoreText.setText(scoreString + "000" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 5) {
                        scoreText.setText(scoreString + "00" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 6) {
                        scoreText.setText(scoreString + "0" + Integer.toString(score));
                    } else if (Integer.toString(score).length() == 7) {
                        scoreText.setText(scoreString + Integer.toString(score));
                    }
                }
            }
            background.update(deltaTime);

            wall.checkWall();
            background.checkBackgrounds();

            checkAndSetPlayer(player, wall);

            obstaclesController.update(deltaTime);

            finishedMenu.update(deltaTime);
            finishedMenu.listenToTouches(touchEvents, touchPoint, guiCam, game, glGame);
        } else if (Assets.readyState && state == SETTING_STATE) {
            List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
            game.getInput().getKeyEvents();

            settingMenu.update(deltaTime);
            settingMenu.listenToTouches(touchEvents, touchPoint, guiCam, game, glGame);
        }


        //time += deltaTime;
        //Log.d("deltaTime", "" + time);
    }

    public void listenToTouches(List<Input.TouchEvent> touchEvents, float deltaTime){
        int len = touchEvents.size();
        for(int i=0; i<len; i++){
            Input.TouchEvent event = touchEvents.get(i);

            if(event.type == Input.TouchEvent.TOUCH_UP){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                // If finger is lifted, all buttons are reset
                pauseState = BOUNDS_NOT_TOUCHED;

                if(OverlapTester.pointInRectangle(pauseBounds, touchPoint)) {
                    SoundController.pauseMusic();
                    SoundController.pauseAllSoundEffects();
                    pauseState = BOUNDS_NOT_TOUCHED;
                    state = PAUSED_STATE;
                }

            }
            if(event.type == Input.TouchEvent.TOUCH_DOWN){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if (state == RUNNING_STATE) {
                    if (OverlapTester.pointInRectangle(pauseBounds, touchPoint)) {
                        pauseState = BOUNDS_TOUCHED;
                    } else {
                        player.jump();
                        if (!gameStarted) {
                            gameStarted = true;
                        }
                        if(!SoundController.music.isPlaying()) {
                            SoundController.resumeMusic();
                        }
                    }
                }
            }
            if(event.type == Input.TouchEvent.TOUCH_DRAGGED){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(!OverlapTester.pointInRectangle(pauseBounds, touchPoint)) {
                    pauseState = BOUNDS_NOT_TOUCHED;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime){
        if(state == LOADING_STATE)
            presentLoading(deltaTime);
        else if(state == RUNNING_STATE)
            presentRunning(deltaTime);
        else if (state == PAUSED_STATE) {
            presentPause(0);
        } else if (state == FINISHED_STATE) {
            presentFinished(0);
        } else if (state == SETTING_STATE) {
            presentSetting(0);
        }
    }

    @SuppressLint("FloatMath")
    public void presentLoading(float deltaTime){

    }

    @SuppressLint("FloatMath")
    public void presentRunning(float deltaTime){
        stateTime += deltaTime; // updates stateTime if we want frame independent movement

        // Initiates everything needed to render sprites
        GL10 gl = glGraphics.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        guiCam.setViewportAndMatrices();

        gl.glEnable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);


        // Draw background
        background.render(batcher);

        batcher.beginBatch(Assets.fenceTexture);
        wall.render(batcher);
        batcher.endBatch();

        twitterBoardController.render(batcher);

        player.render(batcher);

        // Obstacles
        obstaclesController.render(batcher);
        //

        topBoundary.render(batcher);
        bottomBoundary.render(batcher);

        if (player.getPlayerState() != 0) {
            scoreText.render(batcher);
        }

        batcher.beginBatch(Assets.buttonsTexture);
        if (pauseState == BOUNDS_NOT_TOUCHED) {
            batcher.drawSprite(pauseBounds.x, pauseBounds.y, pauseBounds.width, pauseBounds.height, Assets.pause_button);
        } else {
            batcher.drawSprite(pauseBounds.x, pauseBounds.y, pauseBounds.width, pauseBounds.height, Assets.pause_button_pressed);
        }
        batcher.endBatch();


        // Stop rendering
        gl.glDisable(GL10.GL_BLEND);

        // Display fps on LogCat
        //fpsCounter.logFrame();
    }

    @SuppressLint("FloatMath")
    public void presentPause(float deltaTime){
        // Initiates everything needed to render sprites
        GL10 gl = glGraphics.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        guiCam.setViewportAndMatrices();

        gl.glEnable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);


        // Draw background
        background.render(batcher);

        batcher.beginBatch(Assets.fenceTexture);
        wall.render(batcher);
        batcher.endBatch();

        player.render(batcher);

        obstaclesController.render(batcher);

        topBoundary.render(batcher);
        bottomBoundary.render(batcher);

        pauseMenu.render(batcher);

        // Stop rendering
        gl.glDisable(GL10.GL_BLEND);
    }

    @SuppressLint("FloatMath")
    public void presentFinished(float deltaTime) {
        // Initiates everything needed to render sprites
        GL10 gl = glGraphics.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        guiCam.setViewportAndMatrices();

        gl.glEnable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);


        // Draw background
        background.render(batcher);

        batcher.beginBatch(Assets.fenceTexture);
        wall.render(batcher);
        batcher.endBatch();

        player.render(batcher);


        obstaclesController.render(batcher);

        topBoundary.render(batcher);
        bottomBoundary.render(batcher);

        finishedMenu.render(batcher);

        // Stop rendering
        gl.glDisable(GL10.GL_BLEND);
    }

    @SuppressLint("FloatMath")
    public void presentSetting(float deltaTime) {
        GL10 gl = glGraphics.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        guiCam.setViewportAndMatrices();

        gl.glEnable(GL10.GL_TEXTURE_2D);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);


        // Draw background
        background.render(batcher);

        batcher.beginBatch(Assets.fenceTexture);
        wall.render(batcher);
        batcher.endBatch();

        player.render(batcher);

        obstaclesController.render(batcher);

        topBoundary.render(batcher);
        bottomBoundary.render(batcher);

        settingMenu.render(batcher);

        // Stop rendering
        gl.glDisable(GL10.GL_BLEND);
    }


    @SuppressLint("FloatMath")
    public void presentChange(float deltaTime){
        presentRunning(deltaTime);
    }

    public void checkAndSetPlayer(Player player, Wall wall) {
        // left walls

        if (player.getVelocity().x == 0) {

        } else if (player.getVelocity().x > 0) {
            for (GameObjectRectangle rightWall : wall.getRightWallsList()) {
                if (CollisionTester.rectangleCollision(player.getWallBounds(), rightWall)) {
                    player.getPosition().x = rightWall.getX() - (rightWall.getWidth()/2) - (player.getWallBounds().getWidth()/2);
                    player.getVelocity().x = 0;
                    player.setPlayerState(player.getWALL_RIGHT());
                }
            }
        } else if (player.getVelocity().x < 0) {
            for (GameObjectRectangle leftWall : wall.getLeftWallsList()) {
                if (CollisionTester.rectangleCollision(player.getWallBounds(), leftWall)) {
                    player.getPosition().x = leftWall.getX() + (leftWall.getWidth()/2) + (player.getWallBounds().getWidth()/2);
                    player.getVelocity().x = 0;
                    player.setPlayerState(player.getWALL_LEFT());
                }
            }
        }

        // right walls


        // small walls


        // medium walls

    }

    public boolean checkIfHit() {
        if (CollisionTester.CollisionTest(player.getDamageBounds(), topBoundary.getBounds()) || CollisionTester.CollisionTest(player.getDamageBounds(), bottomBoundary.getBounds())) {
            deathCause = "YOU WERE KILLED BY THE ELECTRIC BARRIER";
            SoundController.playElectricSound();
            player.setDeathCause(ObstaclesController.BARRIER);
            return true;
        } else if (obstaclesController.getExcaliburController().getState() != ExcaliburController.NOTHING) {
            if (obstaclesController.getExcaliburController().getExcaliburs()[0].getState() == Excalibur.SHOOT) {
                if (CollisionTester.CollisionTest(player.getDamageBounds(), obstaclesController.getExcaliburController().getExcaliburs()[0].getBounds())) {
                    deathCause = "YOU WERE KILLED BY ORBITAL BOMBARDMENT";
                    player.setDeathCause(ObstaclesController.EXCALIBUR);
                    return true;
                }
            }
            if (obstaclesController.getExcaliburController().getExcaliburs()[1].getState() == Excalibur.SHOOT) {
                if (CollisionTester.CollisionTest(player.getDamageBounds(), obstaclesController.getExcaliburController().getExcaliburs()[1].getBounds())) {
                    deathCause = "YOU WERE KILLED BY ORBITAL BOMBARDMENT";
                    player.setDeathCause(ObstaclesController.EXCALIBUR);
                    return true;
                }
            }
            if (obstaclesController.getExcaliburController().getExcaliburs()[2].getState() == Excalibur.SHOOT) {
                if (CollisionTester.CollisionTest(player.getDamageBounds(), obstaclesController.getExcaliburController().getExcaliburs()[2].getBounds())) {
                    deathCause = "YOU WERE KILLED BY ORBITAL BOMBARDMENT";
                    player.setDeathCause(ObstaclesController.EXCALIBUR);
                    return true;
                }
            }
            return false;
        } if (obstaclesController.getMissileController().getState() != MissileController.NOTHING || true) {
            if (!obstaclesController.getMissileController().getMissiles()[0].isReady()) {
                if (CollisionTester.CollisionTest(player.getDamageBounds(), obstaclesController.getMissileController().getMissiles()[0].getBounds())) {
                    deathCause = "YOU WERE KILLED BY A MISSILE";
                    obstaclesController.getMissileController().getMissiles()[0].hit();
                    player.setDeathCause(ObstaclesController.MISSILE);
                    return true;
                }
            }
            if (!obstaclesController.getMissileController().getMissiles()[1].isReady()) {
                if (CollisionTester.CollisionTest(player.getDamageBounds(), obstaclesController.getMissileController().getMissiles()[1].getBounds())) {
                    deathCause = "YOU WERE KILLED BY A MISSILE";
                    obstaclesController.getMissileController().getMissiles()[1].hit();
                    player.setDeathCause(ObstaclesController.MISSILE);
                    return true;
                }
            }
            if (!obstaclesController.getMissileController().getMissiles()[2].isReady()) {
                if (CollisionTester.CollisionTest(player.getDamageBounds(), obstaclesController.getMissileController().getMissiles()[2].getBounds())) {
                    deathCause = "YOU WERE KILLED BY A MISSILE";
                    obstaclesController.getMissileController().getMissiles()[2].hit();
                    player.setDeathCause(ObstaclesController.MISSILE);
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    @Override
    public void pause(){
    }

    @Override
    public void resume(){
    }

    @Override
    public void dispose(){
    }
}
