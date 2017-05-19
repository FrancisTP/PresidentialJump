package com.francistp.game.presidentialjump;

import com.francistp.game.framework.Screen;
import com.francistp.game.framework.impl.GLGame;
import com.francistp.game.presidentialjump.Assets.Assets;
import com.francistp.game.presidentialjump.Menues.LoadingScreen;
import com.francistp.game.presidentialjump.Object.TwitterHandler;
import com.francistp.game.presidentialjump.Settings.Saves;
import com.francistp.game.presidentialjump.Settings.SoundController;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PresidentialJump extends GLGame {

    public boolean firstTimeCreate = true;

    public Screen getStartScreen(){
        return new LoadingScreen(this, "MainMenuScreen");
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config){
        super.onSurfaceCreated(gl, config);
        if(firstTimeCreate){
            Saves.load(this);
            Assets.load(this);
            SoundController.load(this);
            TwitterHandler.configureTwitter();

            firstTimeCreate = false;
            Assets.readyState = true;
        } else {
            Assets.reload();
            System.out.println("only reloaded");
        }
    }

    @Override
    public void onPause(){
        SoundController.pauseMusicAppClosed();
        SoundController.pauseAllSoundEffects();
        super.onPause();
    }

    @Override
    public void onResume() {
        SoundController.resumeMusicAppOpened();
        SoundController.resumeAllSoundEffects();
        super.onResume();
    }

    @Override
    public void onBackPressed(){
        // Je suis un baller
    }
}
