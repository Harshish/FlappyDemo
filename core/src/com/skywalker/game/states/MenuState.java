package com.skywalker.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.skywalker.game.FlappyDemo;

/**
 * Created by HARSHISH on 08-12-2016.
 */
public class MenuState extends State {

    private Texture background,playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("bg.png");
        playBtn = new Texture("replay.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched())
            gsm.set(new PlayState(gsm));
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Menu State Disposed");
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn,cam.position.x-playBtn.getWidth()/2,cam.position.y);
        sb.end();
    }
}