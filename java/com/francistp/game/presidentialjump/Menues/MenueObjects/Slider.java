package com.francistp.game.presidentialjump.Menues.MenueObjects;

import com.francistp.game.framework.Game;
import com.francistp.game.framework.Input;
import com.francistp.game.framework.gl.Camera2D;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.gl.TextureRegion;
import com.francistp.game.framework.impl.GLGame;
import com.francistp.game.framework.math.OverlapTester;
import com.francistp.game.framework.math.Rectangle;
import com.francistp.game.framework.math.Vector2;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Menues.GameScreen;
import com.francistp.game.presidentialjump.Menues.MainMenuScreen;

import java.util.List;

/**
 * Created by Francis on 2017-05-03.
 */
public class Slider {

    private float x, y;
    private float knobX;
    private float sliderBarWidth;
    private float valueWidth;
    private float value;
    private TextureRegion sliderBackground, sliderBar, sliderKnob;
    private boolean pressedDown;
    private float fingerXPosition;


    Rectangle knobBounds;

    public Slider(float x, float y, float value) {
        this.x = x;
        this.y = y;

        this.value = value;

        sliderBackground = Assets.slider_background;
        sliderBar = Assets.slider_bar;
        sliderKnob = Assets.slider_knob;

        knobBounds = new Rectangle(x, y, sliderBar.width, sliderBar.height*4);

        valueWidth = (value*sliderBar.width);
        sliderBarWidth = valueWidth;
        knobX = x - (sliderBar.width/2) + sliderBarWidth;
        fingerXPosition = knobX;

        pressedDown = false;
    }

    public boolean getPressedDown() {
        return pressedDown;
    }

    public float getValue() {
        return value;
    }

    public void update(float deltaTime) {
        if (pressedDown) {
            valueWidth = fingerXPosition;
            if (valueWidth < 0) {
                valueWidth = 0;
            } else if (valueWidth > sliderBar.width) {
                valueWidth = sliderBar.width;
            }
            sliderBarWidth = valueWidth;
            knobX = x - (sliderBar.width/2) + sliderBarWidth;
            value = sliderBarWidth / sliderBar.width;
        }
    }

    public void listenToTouches(List<Input.TouchEvent> touchEvents, Vector2 touchPoint, Camera2D guiCam, Game game, GLGame glGame){
        int len = touchEvents.size();
        for(int i=0; i<len; i++){
            Input.TouchEvent event = touchEvents.get(i);

            if(event.type == Input.TouchEvent.TOUCH_UP){
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);
                pressedDown = false;
            }
            if(event.type == Input.TouchEvent.TOUCH_DOWN){
                if(OverlapTester.pointInRectangle(knobBounds, touchPoint)) {
                    touchPoint.set(event.x, event.y);
                    guiCam.touchToWorld(touchPoint);
                    pressedDown = true;
                    fingerXPosition = touchPoint.x - (x - (sliderBar.width/2));
                    System.out.println("touchPoint.x: " + touchPoint.x);
                    System.out.println("(x - (sliderBar.width/2): " +  (x - (sliderBar.width/2)));
                    System.out.println("fingerXPosition: " + fingerXPosition);
                    System.out.println("sliderBar.width: " + sliderBar.width);
                }
            }
            if(event.type == Input.TouchEvent.TOUCH_DRAGGED){
                if (pressedDown) {
                    touchPoint.set(event.x, event.y);
                    guiCam.touchToWorld(touchPoint);
                    fingerXPosition = touchPoint.x - (x - (sliderBar.width/2));
                }
            }
        }
    }

    public void render(SpriteBatcher batcher) {
        batcher.drawSprite(x, y, sliderBackground.width, sliderBackground.height, sliderBackground);
        batcher.drawSprite(x - (sliderBar.width/2) + (sliderBarWidth/2), y, sliderBarWidth, sliderBar.height, sliderBar);
        batcher.drawSprite(knobX, y, sliderKnob.width, sliderKnob.height, sliderKnob);
    }




}
