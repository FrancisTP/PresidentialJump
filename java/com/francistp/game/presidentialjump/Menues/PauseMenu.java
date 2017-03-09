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

import java.util.List;

/**
 * Created by franc on 2017-01-27.
 */

public class PauseMenu {

    private float x, y;
    private float resumeOffsetX, resumeOffsetY;
    private float quitOffsetX, quitOffsetY;
    private float titleOffsetY;

    Rectangle resumeBounds;
    int resumeState;
    Rectangle quitBounds;
    int quitState;

    final int BOUNDS_NOT_TOUCHED = 0;
    final int BOUNDS_TOUCHED = 1;

    public PauseMenu() {
        x = 240;
        y = 400;

        resumeOffsetX = 80;
        quitOffsetX = -80;
        resumeOffsetY = -200;
        quitOffsetY = -200;

        titleOffsetY = 200;

        resumeBounds = new Rectangle(x + resumeOffsetX, y + resumeOffsetY, Assets.play_button.width*2, Assets.play_button.height*2);
        resumeState = BOUNDS_NOT_TOUCHED;
        quitBounds = new Rectangle(x + quitOffsetX, y + quitOffsetY, Assets.no_button.width*2, Assets.no_button.height*2);
        quitState = BOUNDS_NOT_TOUCHED;;
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
                resumeState = BOUNDS_NOT_TOUCHED;
                quitState = BOUNDS_NOT_TOUCHED;

                if(OverlapTester.pointInRectangle(resumeBounds, touchPoint)) {
                    resumeState = BOUNDS_NOT_TOUCHED;
                    GameScreen.state = GameScreen.RUNNING_STATE;
                }
                if(OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
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
                if(!OverlapTester.pointInRectangle(quitBounds, touchPoint)) {
                    quitState = BOUNDS_NOT_TOUCHED;
                }
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.menuesTexture);
        batcher.drawSprite(x, y, Assets.menu_frame.width, Assets.menu_frame.height, Assets.menu_frame);
        batcher.drawSprite(x, y + titleOffsetY, Assets.pause_title.width, Assets.pause_title.height, Assets.pause_title);
        batcher.endBatch();

        batcher.beginBatch(Assets.buttonsTexture);
        if (resumeState == BOUNDS_NOT_TOUCHED) {
            batcher.drawSprite(resumeBounds.x, resumeBounds.y, resumeBounds.width, resumeBounds.height, Assets.play_button);
        } else {
            batcher.drawSprite(resumeBounds.x, resumeBounds.y, resumeBounds.width, resumeBounds.height, Assets.play_button_pressed);
        }

        if (quitState == BOUNDS_NOT_TOUCHED) {
            batcher.drawSprite(quitBounds.x, quitBounds.y, quitBounds.width, quitBounds.height, Assets.no_button);
        } else {
            batcher.drawSprite(quitBounds.x, quitBounds.y, quitBounds.width, quitBounds.height, Assets.no_button_pressed);
        }
        batcher.endBatch();
    }
}
