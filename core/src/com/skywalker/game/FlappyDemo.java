package com.skywalker.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.skywalker.game.states.GameStateManager;
import com.skywalker.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	private SpriteBatch batch;
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
    public static final String TITLE = "Flappy Bird";
    private GameStateManager gsm;
    private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
        gsm = new GameStateManager();
        music = Gdx.audio.newMusic(Gdx.files.internal("bgm.mp3"));
        music.setLooping(true);
        music.setVolume(0.3f);
        music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
        music.dispose();
	}
}
