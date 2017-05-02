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

import java.util.List;

/**
 * Created by Francis on 2017-05-01.
 */
public class SettingMenu {

    private float x, y;
    private float backOffsetX, backOffsetY;
    private float settingOffetX, settingOffsetY;
    private float quitOffsetX, quitOffsetY;
    private float titleOffsetY;

    Rectangle backBounds;
    int backState;

    final int BOUNDS_NOT_TOUCHED = 0;
    final int BOUNDS_TOUCHED = 1;

    private Text settings;
    private Text music, sound;

    public SettingMenu() {
        x = 240;
        y = 400;

        settings = new Text("SETTINGS", 10, "white", "center", 77, 620, 325, false);
        music = new Text("MUSIC:", 7, "white", "left", 77, 500, 325, false);
        sound = new Text("SOUND:", 7, "white", "left", 77, 375, 325, false);

        backOffsetX = 0;
        backOffsetY = -200;

        titleOffsetY = 200;

        backBounds = new Rectangle(x + backOffsetX, y + backOffsetY, Assets.previous_button.width*2, Assets.previous_button.height*2);
        backState = BOUNDS_NOT_TOUCHED;
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
                backState = BOUNDS_NOT_TOUCHED;

                if(OverlapTester.pointInRectangle(backBounds, touchPoint)) {
                    backState = BOUNDS_NOT_TOUCHED;
                    if (Assets.onScreen == "MainMenuScreen") {
                        MainMenuScreen.state = MainMenuScreen.RUNNING_STATE;
                    } else if (Assets.onScreen == "GameScreen") {
                        GameScreen.state = GameScreen.PAUSED_STATE;
                    }
                }

            }
            if(event.type == Input.TouchEvent.TOUCH_DOWN){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(OverlapTester.pointInRectangle(backBounds, touchPoint)) {
                    backState = BOUNDS_TOUCHED;
                }
            }
            if(event.type == Input.TouchEvent.TOUCH_DRAGGED){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);

                if(!OverlapTester.pointInRectangle(backBounds, touchPoint)) {
                    backState = BOUNDS_NOT_TOUCHED;
                }
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.beginBatch(Assets.menuesTexture);
        batcher.drawSprite(x, y, Assets.menu_frame.width, Assets.menu_frame.height, Assets.menu_frame);
        batcher.endBatch();

        settings.render(batcher);
        music.render(batcher);
        sound.render(batcher);

        batcher.beginBatch(Assets.buttonsTexture);
        if (backState == BOUNDS_NOT_TOUCHED) {
            batcher.drawSprite(backBounds.x, backBounds.y, backBounds.width, backBounds.height, Assets.previous_button);
        } else {
            batcher.drawSprite(backBounds.x, backBounds.y, backBounds.width, backBounds.height, Assets.previous_button_pressed);
        }
        batcher.endBatch();
    }
}
