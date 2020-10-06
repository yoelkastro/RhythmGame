package com.rhythm.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rhythm.game.RhythmGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
	    config.height = 720;
		config.title = "RhythmGame";
		//config.fullscreen = true;
		new LwjglApplication(new RhythmGame(), config);
	}
}
