package com.francistp.game.presidentialjump.Menues;

import com.francistp.game.framework.Game;
import com.francistp.game.framework.Input;
import com.francistp.game.framework.gl.Camera2D;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.impl.GLGame;
import com.francistp.game.framework.math.OverlapTester;
import com.francistp.game.framework.math.Rectangle;
import com.francistp.game.framework.math.Vector2;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Assets.Text;
import com.francistp.game.presidentialjump.Decore.Fireworks;
import com.francistp.game.presidentialjump.Settings.SoundController;

import java.util.List;

/**
 * Created by Francis on 2017-05-01.
 */
public class FinishedMenu {
    private float x, y;
    private float restartOffsetX, restartOffsetY;
    private float quitOffsetX, quitOffsetY;

    Rectangle restartBounds;
    int restartState;
    Rectangle quitBounds;
    int quitState;

    final int BOUNDS_NOT_TOUCHED = 0;
    final int BOUNDS_TOUCHED = 1;

    private Text scoreText;

    private Text deathCauseText;

    public FinishedMenu(int score, String deathCause) {
        x = 240;
        y = 400;

        restartOffsetX = 80;
        quitOffsetX = -80;
        restartOffsetY = -200;
        quitOffsetY = -200;

        restartBounds = new Rectangle(x + restartOffsetX, y + restartOffsetY, Assets.play_button.width*2, Assets.play_button.height*2);
        restartState = BOUNDS_NOT_TOUCHED;
        quitBounds = new Rectangle(x + quitOffsetX, y + quitOffsetY, Assets.no_button.width*2, Assets.no_button.height*2);
        quitState = BOUNDS_NOT_TOUCHED;

        String scoreString;

        if (Integer.toString(score).length() == 1) {
            scoreString = "Score: 000000" + Integer.toString(score);
        } else if (Integer.toString(score).length() == 2) {
            scoreString = "Score: 00000" + Integer.toString(score);
        } else if (Integer.toString(score).length() == 3) {
            scoreString = "Score: 0000" + Integer.toString(score);
        } else if (Integer.toString(score).length() == 4) {
            scoreString = "Score: 000" + Integer.toString(score);
        } else if (Integer.toString(score).length() == 5) {
            scoreString = "Score: 00" + Integer.toString(score);
        } else if (Integer.toString(score).length() == 6) {
            scoreString = "Score: 0" + Integer.toString(score);
        } else if (Integer.toString(score).length() == 7) {
            scoreString = "Score: " + Integer.toString(score);
        } else {
            scoreString = "Score: " + Integer.toString(score);
        }

        scoreText = new Text(scoreString, 7, "white", "center", 77, 400, 325, false);

        deathCauseText = new Text(deathCause, 7, "white", "center", 67, 640, 344, false);
    }

    public void update(float deltaTime) {

    }

    public void listenToTouches(List<Input.TouchEvent> touchEvents, Vector2 touchPoint, Camera2D guiCam, Game game, GLGame glGame){
        int len = touchEvents.size();
        for(int i=0; i<len; i++){
            Input.TouchEvent event = touchEvents.get(i);

            if(event.type == Input.TouchEvent.TOUCH_UP){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                // If finger is lifted, all buttons are reset
                restartState = BOUNDS_NOT_TOUCHED;
                quitState = BOUNDS_NOT_TOUCHED;

                if(OverlapTester.pointInRectangle(restartBounds, touchPoint)) {
                    restartState = BOUNDS_NOT_TOUCHED;
                    game.setScreen(new LoadingScreen(glGame, "GameScreen", new Fireworks()));
                    SoundController.stopMusic();
                }
                if(OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
                    quitState = BOUNDS_NOT_TOUCHED;
                    game.setScreen(new LoadingScreen(glGame, "MainMenuScreen"));
                    SoundController.stopMusic();
                }

            }
            if(event.type == Input.TouchEvent.TOUCH_DOWN){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(OverlapTester.pointInRectangle(restartBounds, touchPoint)) {
                    restartState = BOUNDS_TOUCHED;
                }
                if(OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
                    quitState = BOUNDS_TOUCHED;
                }
            }
            if(event.type == Input.TouchEvent.TOUCH_DRAGGED){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(!OverlapTester.pointInRectangle(restartBounds, touchPoint)) {
                    restartState = BOUNDS_NOT_TOUCHED;
                }
                if(!OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
                    quitState = BOUNDS_NOT_TOUCHED;
                }
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.menuesTexture);
        batcher.drawSprite(x, y, Assets.menu_frame.width, Assets.menu_frame.height, Assets.menu_frame);
        batcher.endBatch();

        deathCauseText.render(batcher);
        scoreText.render(batcher);

        batcher.beginBatch(Assets.buttonsTexture);
        if (restartState == BOUNDS_NOT_TOUCHED) {
            batcher.drawSprite(restartBounds.x, restartBounds.y, restartBounds.width, restartBounds.height, Assets.replay_button);
        } else {
            batcher.drawSprite(restartBounds.x, restartBounds.y, restartBounds.width, restartBounds.height, Assets.replay_button_pressed);
        }

        if (quitState == BOUNDS_NOT_TOUCHED) {
            batcher.drawSprite(quitBounds.x, quitBounds.y, quitBounds.width, quitBounds.height, Assets.no_button);
        } else {
            batcher.drawSprite(quitBounds.x, quitBounds.y, quitBounds.width, quitBounds.height, Assets.no_button_pressed);
        }
        batcher.endBatch();
    }
}
