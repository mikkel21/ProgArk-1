package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Exercise_1;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= Exercise_1.WIDTH;
		config.height=Exercise_1.HEIGHT;
		config.title=Exercise_1.TITLE;
		new LwjglApplication(new Exercise_1(), config);
	}
}
