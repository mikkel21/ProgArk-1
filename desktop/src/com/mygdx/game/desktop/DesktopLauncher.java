package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Exercise_1;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Exercise_1 exercise_1 = Exercise_1.getInstance();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= exercise_1.WIDTH;
		config.height=exercise_1.HEIGHT;
		config.title=exercise_1.TITLE;
		new LwjglApplication(exercise_1, config);
	}
}
