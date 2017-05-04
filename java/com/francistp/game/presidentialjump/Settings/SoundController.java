package com.francistp.game.presidentialjump.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.SoundPool;

import com.francistp.game.framework.Music;
import com.francistp.game.framework.Sound;
import com.francistp.game.framework.impl.GLGame;

import java.io.IOException;

/**
 * Created by Francis on 2015-06-24.
 */
/*
    public void play();

	public void stop();

	public void pause();

	public void setLooping(boolean looping);

	public void setVolume(float volume);

	public boolean isPlaying();

	public boolean isStopped();

	public boolean isLooping();

	public void dispose();
 */

public class SoundController {

    protected static GLGame glGame;

    public static Music music;
    public static float musicVolume;
    public static int state;

    public static SoundPool soundPool;
    public static Sound sound;
    public static float soundEffectVolume;

    private static final int NOTHING = 0;
    private static final int FADE_OUT = 1;
    public static final int CHANGING = 2;

    public static String musicPlaying;

    public static String fileName;
    public static String musicVol;


    private static final String musicDirectory = "music/";
    private static final String soundEffectDirectory = "soundEffect/";

    private static boolean shouldMusicBePlaying;

    private static int JUMP_SOUND;
    private static int ELECTRIC_SOUND;
    private static int SETTING_SOUND;

    private static boolean isUserMusicPlaying;
    private static AudioManager manager;

    public static void load(GLGame game){
        glGame = game;

        state = NOTHING;

        musicPlaying = "";
        shouldMusicBePlaying = false;

       //////////////////////////////////////////////////////////////////////////////////////////

        fileName = "presidentialjumpsoundsettings";
        musicVol = "musicVolume";

        // Load saved music volume
        musicVolume = Saves.getMusicVolume();
        soundEffectVolume = Saves.getSoundEffectVolume();

        music = null;
        sound = null;

        manager = (AudioManager)glGame.getSystemService(Context.AUDIO_SERVICE);
        isUserMusicPlaying = manager.isMusicActive();

        soundPool = glGame.getAudio().getSoundPool();
        loadSoundEffects();
    }

    public static void update(){
        if (state == FADE_OUT){
            musicVolume -= 0.004;
            music.setVolume(musicVolume);
            if (musicVolume <= 0){
                music.stop();
                musicVolume = Saves.getMusicVolume();
                state = CHANGING;
            }
        } else if (state == CHANGING){
            state = NOTHING;
            startSong(musicPlaying);
        }
    }

    // Music
    public static void requestSong(String song){
        // Check if a song is already playing
        if(musicPlaying != song) {
            musicPlaying = song;
            if (music != null) {
                if (music.isPlaying() && state == NOTHING) {
                    state = FADE_OUT;
                } else if (state == NOTHING) {
                    startSong(musicDirectory + musicPlaying);
                }
            } else {
                startSong(musicDirectory + musicPlaying);
            }
        }
    }

    public static void startSong(String song){
        if(music != null)
            music.dispose();
        music = glGame.getAudio().newMusic(song);
        music.setLooping(true);
        music.setVolume(musicVolume);
        music.play();
        shouldMusicBePlaying = true;
    }

    public static void pauseMusic(){
        if(music != null)
            music.pause();
            shouldMusicBePlaying = false;
    }

    public static void resumeMusic(){
        if(music != null)
            music.play();
            shouldMusicBePlaying = true;
    }

    public static void stopMusic(){
        if(music != null) {
            music.stop();
            music.dispose();
            music = null;
            musicPlaying = "";
            shouldMusicBePlaying = false;
        }
    }

    public static void setMusicVolume(float musicV) {
        musicVolume = musicV;
        music.setVolume(musicVolume);
        Saves.setMusicVolume(musicVolume);
    }

    public static void setSoundEffectVolume(float soundEffectV) {
        soundEffectVolume = soundEffectV;
        Saves.setSoundEffectVolume(soundEffectVolume);
    }

    public static void pauseMusicAppClosed(){
        if (music != null && music.isPlaying()) {
            music.pause();
        }
    }

    public static void resumeMusicAppOpened(){
        if (shouldMusicBePlaying) {
            if (music != null)
                music.play();
        }
    }

    private static void loadSoundEffects() { // need to manually add the files I want loaded here
        try {
            AssetFileDescriptor assetDescriptor = glGame.getAssets().openFd(soundEffectDirectory + "wallJump.ogg");
            JUMP_SOUND = soundPool.load(assetDescriptor, 0);
            assetDescriptor = glGame.getAssets().openFd(soundEffectDirectory + "electricshock.ogg");
            ELECTRIC_SOUND = soundPool.load(assetDescriptor, 0);
            assetDescriptor = glGame.getAssets().openFd(soundEffectDirectory + "settingSound.ogg");
            SETTING_SOUND = soundPool.load(assetDescriptor, 0);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound some soundEffects: " + e.getMessage());
        }
    }

    public static void playJumpSound() {
        soundPool.play(JUMP_SOUND, soundEffectVolume, soundEffectVolume, 0, 0, 1);
    }

    public static void playElectricSound() {
        soundPool.play(ELECTRIC_SOUND, soundEffectVolume, soundEffectVolume, 0, 0, 1);
    }

    public static void playSettingSound() {
        soundPool.play(SETTING_SOUND, soundEffectVolume, soundEffectVolume, 0, 0, 1);
    }
}
