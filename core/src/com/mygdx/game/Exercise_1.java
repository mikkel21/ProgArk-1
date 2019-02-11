package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.PlayState;

public class Exercise_1 extends ApplicationAdapter {

	//singleton: not really appropriate for this class?
	private static Exercise_1 exercise_1_instance = null;

	public static int WIDTH;
	public static int HEIGHT;

	public static String TITLE;

	private GameStateManager gsm;
	private SpriteBatch batch;

	private Exercise_1() {
		WIDTH=600;
		HEIGHT=600;
		TITLE="PONG";
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0,0,0,1);
		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	public static Exercise_1 getInstance() {
		if (exercise_1_instance == null) {
			exercise_1_instance = new Exercise_1();
		}
		return exercise_1_instance;
	}
}
