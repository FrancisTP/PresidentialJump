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

    final int BOUNDS_NOT_TOUCHED = 0;
    final int BOUNDS_TOUCHED = 1;

    float stateTime = 3;

    Player player;
    Background background;
    Wall wall;

    ElectricBoundary topBoundary, bottomBoundary;

    private Text textText_01;
    private Text textText_02;
    private Text textText_03;
    private Text textText_04;
    private Text textText_05;
    private Text textText_06;

    Rectangle pauseBounds;
    int pauseState;
    PauseMenu pauseMenu;

    public GameScreen(Game game, Fireworks fireworks) {
        super(game);
        guiCam = new Camera2D(glGraphics, 480, 800); // Screen resolution 1280x800
        batcher = new SpriteBatcher(glGraphics, 100); // A maximum of 100 sprite per batch
        touchPoint = new Vector2();

        state = RUNNING_STATE;

        background =  new Background(fireworks);

        player = new Trump();

        wall = new Wall();

        topBoundary = new ElectricBoundary(240, 850);
        bottomBoundary = new ElectricBoundary(240, -50);

        //public Text(float x, float y, String text, float size, String align, float width, boolean background) {
        textText_01 = new Text(240, 650, "It's almost       working, I need to fix the      words getting    cut off :O", 10, "left", 400, false);
        //textText_02 = new Text(240, 550, "TESTING 12369", 20);
        //textText_03 = new Text(240, 450, "Testing 12369", 10);
        //textText_04 = new Text(240, 350, "TESTING 12369", 10);
        //textText_05 = new Text(240, 250, "Testing 12369", 5);
        //textText_06 = new Text(240, 150, "TESTING 12369", 5);

        pauseBounds = new Rectangle(Assets.pause_button.width + 5, 800 - Assets.pause_button.height - 5, Assets.pause_button.width*2, Assets.pause_button.height*2);
        pauseState = BOUNDS_NOT_TOUCHED;

        pauseMenu = new PauseMenu();

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
                wall.scroll(-1.50f);
                background.scroll(-1.50f);

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
            }
            background.update(deltaTime);

            wall.checkWall();
            background.checkBackgrounds();

            checkAndSetPlayer(player, wall);

            if (checkIfHit()) {
                pauseState = BOUNDS_NOT_TOUCHED;
                state = PAUSED_STATE;
            }
        } else if (Assets.readyState && state == PAUSED_STATE) {
            List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();
            game.getInput().getKeyEvents();

            pauseMenu.update(deltaTime);
            pauseMenu.listenToTouches(touchEvents, touchPoint, guiCam, game, glGame);
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
                    pauseState = BOUNDS_NOT_TOUCHED;
                    state = PAUSED_STATE;
                }

            }
            if(event.type == Input.TouchEvent.TOUCH_DOWN){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(OverlapTester.pointInRectangle(pauseBounds, touchPoint)) {
                    pauseState = BOUNDS_TOUCHED;
                } else {
                    player.jump();
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

        batcher.beginBatch(Assets.trumpallbodyparts);
        player.render(batcher);
        batcher.endBatch();

        topBoundary.render(batcher);
        bottomBoundary.render(batcher);

        textText_01.render(batcher);
        //textText_02.render(batcher);
        //textText_03.render(batcher);
        //textText_04.render(batcher);
        //textText_05.render(batcher);
        //textText_06.render(batcher);

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

        batcher.beginBatch(Assets.trumpallbodyparts);
        player.render(batcher);
        batcher.endBatch();

        topBoundary.render(batcher);
        bottomBoundary.render(batcher);

        pauseMenu.render(batcher);

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
            return true;
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
