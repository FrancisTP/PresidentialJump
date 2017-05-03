package com.francistp.game.presidentialjump.Settings;

import com.francistp.game.framework.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Saves {
	public static float musicVolume = 0.5f;
	public static float soundEffectVolume = 0.5f;
	public static int highscore = 0;
	public static boolean firstTimePlaying = true;
	public final static String file = ".presidentialJumpSave";
	
	public static void load(FileIO files){
		BufferedReader in = null;

		System.out.println(" ");
		System.out.println("============================");
		System.out.println("Trying to load settings..");
		System.out.println(" ");
		try{
			in = new BufferedReader(new InputStreamReader(files.readFile(file)));
			musicVolume = Float.parseFloat(in.readLine()); // first line musicVolume
			soundEffectVolume = Float.parseFloat(in.readLine());	// second line soudEffect volume
			highscore = Integer.parseInt(in.readLine());	// third line highscore
			firstTimePlaying = Boolean.parseBoolean(in.readLine());

			System.out.println("musicVolume: " + musicVolume);
			System.out.println("soundEffectVolume: " + soundEffectVolume);
			System.out.println("highscore: " + highscore);
			System.out.println("firstTimePlaying: " + firstTimePlaying);

		} catch (IOException e) {
			// We have defaults
			System.out.println("IOException: " + e.getMessage());
		} catch (NumberFormatException e) {
			// we have defaults
			System.out.println("NumberFormatException: " + e.getMessage());
		} finally {
			try{
				if(in != null)
					in.close();
			} catch (IOException e) {
			}
		}

		System.out.println("============================");
		System.out.println(" ");
	}


	
	public static void saveSettings(FileIO files){
		BufferedWriter out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeFile(file)));
			out.write(Float.toString(musicVolume));
		} catch (IOException e) {
		} finally {
			try{
				if(out != null)
					out.close();
			} catch (IOException e){
			}
		}
	}

	public static void savemusicVolume(FileIO files){
		BufferedWriter out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeFile(file)));
			out.write(Float.toString(musicVolume));
		} catch (IOException e) {
		} finally {
			try{
				if(out != null)
					out.close();
			} catch (IOException e){
			}
		}
	}

	public static void saveSoundEffectVolume(FileIO files){
		BufferedWriter out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeFile(file)));
			out.write("\n");
			out.write(Float.toString(soundEffectVolume));
		} catch (IOException e) {
		} finally {
			try{
				if(out != null)
					out.close();
			} catch (IOException e){
			}
		}
	}

	public static void saveHighscore(FileIO files){
		BufferedWriter out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeFile(file)));
			out.write("\n");
			out.write("\n");
			out.write(Integer.toString(highscore));
		} catch (IOException e) {
		} finally {
			try{
				if(out != null)
					out.close();
			} catch (IOException e){
			}
		}
	}

	public static void saveFirstTimePlaying(FileIO files){
		BufferedWriter out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeFile(file)));
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write(Boolean.toString(firstTimePlaying));
		} catch (IOException e) {
		} finally {
			try{
				if(out != null)
					out.close();
			} catch (IOException e){
			}
		}
	}
	
	public static void saveAll(FileIO files){
		BufferedWriter out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeFile(file)));
			out.write(Float.toString(musicVolume));
			out.write(Float.toString(soundEffectVolume));
			out.write(Integer.toString(highscore));
			out.write(Boolean.toString(firstTimePlaying));
		} catch (IOException e) {
		} finally {
			try{
				if(out != null)
					out.close();
			} catch (IOException e){
			}
		}
	}
}
