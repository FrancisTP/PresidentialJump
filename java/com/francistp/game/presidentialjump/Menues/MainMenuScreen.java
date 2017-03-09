package com.francistp.game.presidentialjump.Menues;

import android.annotation.SuppressLint;

import com.francistp.game.framework.CollisionTester;
import com.francistp.game.framework.Game;
import com.francistp.game.framework.GameObject;
import com.francistp.game.framework.Input.TouchEvent;
import com.francistp.game.framework.gl.Camera2D;
import com.francistp.game.framework.gl.FPSCounter;
import com.francistp.game.framework.gl.SpriteBatcher;
import com.francistp.game.framework.impl.GLScreen;
import com.francistp.game.framework.math.Circle;
import com.francistp.game.framework.math.OverlapTester;
import com.francistp.game.framework.math.Rectangle;
import com.francistp.game.framework.math.Vector2;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Character.Player;
import com.francistp.game.presidentialjump.Character.Trump;
import com.francistp.game.presidentialjump.Decore.Fireworks;
import com.francistp.game.presidentialjump.Settings.SoundController;

import java.util.List;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

//import com.francistp.game.framework.gl.Animation;
//import com.francistp.game.framework.gl.TextureRegion;
//import com.francistp.game.framework.math.Circle;

public class MainMenuScreen extends GLScreen {
	// Variables 
	Camera2D guiCam;
	SpriteBatcher batcher;
	Vector2 touchPoint;
	FPSCounter fpsCounter = new FPSCounter();
	 
	int state;
	final int LOADING_STATE = 0;
	final int READY_STATE = 1;
	final int RUNNING_STATE = 2;
	final int PAUSED_STATE = 3;
	final int FINISHED_STATE = 4;

	GameObject title;
	float titleSinX;
	float titleDefaultY;

	Fireworks fireworks;

	Rectangle playBounds;
	int playState;
	Rectangle settingsBounds;
	int settingsState;
	
	final int BOUNDS_NOT_TOUCHED = 0;
	final int BOUNDS_TOUCHED = 1;

	float stateTime = 3;

	Player player;


	public MainMenuScreen(Game game){
		super(game);

		guiCam = new Camera2D(glGraphics, 480, 800); // Screen resolution 1280x800
		batcher = new SpriteBatcher(glGraphics, 100); // A maximum of 100 sprite per batch
		touchPoint = new Vector2();

		state = RUNNING_STATE;

		titleSinX = 0;
		titleDefaultY = 650;
		title = new GameObject(240, titleDefaultY, Assets.presidentialJumpTitle.width, Assets.presidentialJumpTitle.height);

		fireworks = new Fireworks();

		player = new Trump();

		// Rectangles used to detect touch inputs
		playBounds = new Rectangle(380, 465, Assets.play_button.width*2, Assets.play_button.height*2);
		playState = BOUNDS_NOT_TOUCHED;
		settingsBounds = new Rectangle(100, 465, Assets.settings_button.width*2, Assets.settings_button_pressed.height*2);
		settingsState = BOUNDS_NOT_TOUCHED;

		// Request a song
		//SoundController.requestSong("MainMenuSong.mp3");
	}
	
	@Override
	public void update(float deltaTime){
		SoundController.update();

		fireworks.update(deltaTime);
		player.update(deltaTime);

		if(Assets.readyState){
			List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
			game.getInput().getKeyEvents();
			
			if(state == RUNNING_STATE)
				listenToTouches(touchEvents);
		}

		// Title sin wave
		titleSinX += 0.05;
		if(titleSinX >= 360)
			titleSinX -= 360;
		title.position.y = titleDefaultY + ((float) Math.sin(titleSinX) * 2.5f);

		//time += deltaTime;
		//Log.d("deltaTime", "" + time);
	}
	
	public void listenToTouches(List<TouchEvent> touchEvents){
		int len = touchEvents.size();
		for(int i=0; i<len; i++){
			TouchEvent event = touchEvents.get(i);
			
			if(event.type == TouchEvent.TOUCH_UP){
				touchPoint.set(event.x, event.y);
				guiCam.touchToWorld(touchPoint);

				// If finger is lifted, all buttons are reset
				playState = BOUNDS_NOT_TOUCHED;
				settingsState = BOUNDS_NOT_TOUCHED;
			
				if(OverlapTester.pointInRectangle(playBounds, touchPoint)){
					//state = CHANGE_SCREEN_STATE;
					game.setScreen(new LoadingScreen(glGame, "GameScreen", fireworks));
					//return;
				}
				if (OverlapTester.pointInRectangle(settingsBounds, touchPoint)) {

				}
			}
			if(event.type == TouchEvent.TOUCH_DOWN){
				touchPoint.set(event.x, event.y);
				guiCam.touchToWorld(touchPoint);
				
				if(OverlapTester.pointInRectangle(playBounds, touchPoint)) {
					playState = BOUNDS_TOUCHED;
				}
				if(OverlapTester.pointInRectangle(settingsBounds, touchPoint)) {
					settingsState = BOUNDS_TOUCHED;
				}

			}
			if(event.type == TouchEvent.TOUCH_DRAGGED){
				touchPoint.set(event.x, event.y);
				guiCam.touchToWorld(touchPoint);
				
				if(!OverlapTester.pointInRectangle(playBounds, touchPoint)) {
					playState = BOUNDS_NOT_TOUCHED;
				}
				if(!OverlapTester.pointInRectangle(settingsBounds, touchPoint)) {
					settingsState = BOUNDS_NOT_TOUCHED;
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
		batcher.beginBatch(Assets.plainSkyAndGroundTexture);
		batcher.drawSprite(240, 400, Assets.plainSkyAndGround.width, Assets.plainSkyAndGround.height, Assets.plainSkyAndGround);
		batcher.endBatch();

		batcher.beginBatch(Assets.fireworksTexture);
		fireworks.render(batcher);
		batcher.endBatch();

		batcher.beginBatch(Assets.whiteHouseTexture);
		batcher.drawSprite(240, 300, Assets.whiteHouse.width, Assets.whiteHouse.height, Assets.whiteHouse);
		batcher.endBatch();

		batcher.beginBatch(Assets.fenceTexture);
		batcher.drawSprite(240, 120, Assets.metal_fence.width, Assets.metal_fence.height, Assets.metal_fence);
		batcher.drawSprite(240, 120 + Assets.metal_fence.height, Assets.metal_fence.width, Assets.metal_fence.height, Assets.metal_fence);
		batcher.drawSprite(240, 120 + (Assets.metal_fence.height*2), Assets.metal_fence.width, Assets.metal_fence.height, Assets.metal_fence);
		batcher.drawSprite(240, 120 + (Assets.metal_fence.height*3), Assets.metal_fence.width, Assets.metal_fence.height, Assets.metal_fence);
		batcher.drawSprite(240, 120 + (Assets.metal_fence.height*4), Assets.metal_fence.width, Assets.metal_fence.height, Assets.metal_fence);
		batcher.drawSprite(240, 120 + (Assets.metal_fence.height*5), Assets.metal_fence.width, Assets.metal_fence.height, Assets.metal_fence);
		batcher.drawSprite(-15, 420, Assets.left_wall.width, Assets.left_wall.height, Assets.left_wall);
		batcher.drawSprite(495, 420, Assets.right_wall.width, Assets.right_wall.height, Assets.right_wall);
		batcher.endBatch();
		
		// Draw title
		batcher.beginBatch(Assets.presidentialJumpTitleTexture);
		batcher.drawSprite(title.position.x, title.position.y, Assets.presidentialJumpTitle.width, Assets.presidentialJumpTitle.height, Assets.presidentialJumpTitle);
		batcher.endBatch();

		player.render(batcher);

		batcher.beginBatch(Assets.buttonsTexture);
		if (playState == BOUNDS_NOT_TOUCHED) {
			batcher.drawSprite(playBounds.x, playBounds.y, playBounds.width, playBounds.height, Assets.play_button);
		} else {
			batcher.drawSprite(playBounds.x, playBounds.y, playBounds.width, playBounds.height, Assets.play_button_pressed);
		}
		if (settingsState == BOUNDS_NOT_TOUCHED) {
			batcher.drawSprite(settingsBounds.x, settingsBounds.y, settingsBounds.width, settingsBounds.height, Assets.settings_button);
		} else {
			batcher.drawSprite(settingsBounds.x, settingsBounds.y, settingsBounds.width, settingsBounds.height, Assets.settings_button_pressed);
		}
		batcher.endBatch();

		/*
			// Play button
		if(playState == BOUNDS_NOT_TOUCHED)
			batcher.drawSprite(playBounds.x, playBounds.y, playBounds.width, playBounds.height, Assets.mainMenuButtonUp);
		else
			batcher.drawSprite(playBounds.x, playBounds.y, playBounds.width, playBounds.height, Assets.mainMenuButtonDown);
		batcher.drawSprite(playBounds.x, playBounds.y, 114, 56, Assets.mainMenuPlay);
		*/

		/*
		// Draw collision lines
		batcher.beginBatch(Assets.collisionLinesTexture);
		noStarZone.drawShape(batcher);
		batcher.endBatch();
		*/

		// Stop rendering
		gl.glDisable(GL10.GL_BLEND);
		
		// Display fps on LogCat
		//fpsCounter.logFrame();
	}

	@SuppressLint("FloatMath")
	public void presentChange(float deltaTime){
		presentRunning(deltaTime);

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
