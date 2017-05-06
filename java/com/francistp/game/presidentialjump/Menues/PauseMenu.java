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
import com.francistp.game.presidentialjump.Settings.SoundController;

import java.util.List;

/**
 * Created by franc on 2017-01-27.
 */

public class PauseMenu {

    private float x, y;
    private float resumeOffsetX, resumeOffsetY;
    private float settingOffetX, settingOffsetY;
    private float quitOffsetX, quitOffsetY;
    private float titleOffsetY;

    Rectangle resumeBounds;
    int resumeState;
    Rectangle settingBounds;
    int settingState;
    Rectangle quitBounds;
    int quitState;

    final int BOUNDS_NOT_TOUCHED = 0;
    final int BOUNDS_TOUCHED = 1;

    private Text paused;
    private String scoreString;
    private Text scoreText;

    public PauseMenu() {
        x = 240;
        y = 400;

        paused = new Text("PAUSED", 10, "white", "center", 77, 620, 325, false);
        scoreText = new Text("Score: 0000000", 7, "white", "center", 77, 400, 325, false);
        scoreString = "";

        resumeOffsetX = 125;
        settingOffetX = 0;
        quitOffsetX = -125;
        resumeOffsetY = -200;
        settingOffsetY = -200;
        quitOffsetY = -200;

        titleOffsetY = 200;

        resumeBounds = new Rectangle(x + resumeOffsetX, y + resumeOffsetY, Assets.play_button.width*2, Assets.play_button.height*2);
        resumeState = BOUNDS_NOT_TOUCHED;
        settingBounds = new Rectangle(x + settingOffetX, y + settingOffsetY, Assets.settings_button.width*2, Assets.settings_button.height*2);
        settingState = BOUNDS_NOT_TOUCHED;
        quitBounds = new Rectangle(x + quitOffsetX, y + quitOffsetY, Assets.no_button.width*2, Assets.no_button.height*2);
        quitState = BOUNDS_NOT_TOUCHED;
    }

    public void update(float deltaTime, int score) {

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

        scoreText.setText(scoreString);
    }

    public void listenToTouches(List<Input.TouchEvent> touchEvents, Vector2 touchPoint, Camera2D guiCam, Game game, GLGame glGame){
        int len = touchEvents.size();
        for(int i=0; i<len; i++){
            Input.TouchEvent event = touchEvents.get(i);

            if(event.type == Input.TouchEvent.TOUCH_UP){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                // If finger is lifted, all buttons are reset
                resumeState = BOUNDS_NOT_TOUCHED;
                settingState = BOUNDS_NOT_TOUCHED;
                quitState = BOUNDS_NOT_TOUCHED;

                if(OverlapTester.pointInRectangle(resumeBounds, touchPoint)) {
                    resumeState = BOUNDS_NOT_TOUCHED;
                    GameScreen.state = GameScreen.RUNNING_STATE;
                    if (GameScreen.gameStarted) {
                        SoundController.resumeMusic();
                        SoundController.resumeAllSoundEffects();
                    }
                }
                if(OverlapTester.pointInRectangle(settingBounds, touchPoint)) {
                    settingState = BOUNDS_NOT_TOUCHED;
                    GameScreen.state = GameScreen.SETTING_STATE;
                }
                if(OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
                    SoundController.stopMusic();
                    SoundController.stopAllSoundEffects();
                    quitState = BOUNDS_NOT_TOUCHED;
                    game.setScreen(new LoadingScreen(glGame, "MainMenuScreen"));
                }

            }
            if(event.type == Input.TouchEvent.TOUCH_DOWN){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(OverlapTester.pointInRectangle(resumeBounds, touchPoint)) {
                    resumeState = BOUNDS_TOUCHED;
                }
                if(OverlapTester.pointInRectangle(settingBounds, touchPoint)) {
                    settingState = BOUNDS_TOUCHED;
                }
                if(OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
                    quitState = BOUNDS_TOUCHED;
                }
            }
            if(event.type == Input.TouchEvent.TOUCH_DRAGGED){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(!OverlapTester.pointInRectangle(resumeBounds, touchPoint)) {
                    resumeState = BOUNDS_NOT_TOUCHED;
                }
                if(!OverlapTester.pointInRectangle(settingBounds, touchPoint)) {
                    settingState = BOUNDS_NOT_TOUCHED;
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

            paused.render(batcher);
            scoreText.render(batcher);

            batcher.beginBatch(Assets.buttonsTexture);
            if (resumeState == BOUNDS_NOT_TOUCHED) {
                batcher.drawSprite(resumeBounds.x, resumeBounds.y, resumeBounds.width, resumeBounds.height, Assets.play_button);
            } else {
                batcher.drawSprite(resumeBounds.x, resumeBounds.y, resumeBounds.width, resumeBounds.height, Assets.play_button_pressed);
            }

            if (settingState == BOUNDS_NOT_TOUCHED) {
                batcher.drawSprite(settingBounds.x, settingBounds.y, settingBounds.width, settingBounds.height, Assets.settings_button);
            } else {
                batcher.drawSprite(settingBounds.x, settingBounds.y, settingBounds.width, settingBounds.height, Assets.settings_button_pressed);
            }

            if (quitState == BOUNDS_NOT_TOUCHED) {
                batcher.drawSprite(quitBounds.x, quitBounds.y, quitBounds.width, quitBounds.height, Assets.no_button);
            } else {
                batcher.drawSprite(quitBounds.x, quitBounds.y, quitBounds.width, quitBounds.height, Assets.no_button_pressed);
            }
        batcher.endBatch();
    }

}
