package com.skywalker.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by HARSHISH on 08-12-2016.
 */
public class Tube {

    private Texture topTube,bottomTube;

    private Vector2 posTopTube,posBotTube;
    private Random rand;
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 130;
    private static final int LOWEST_OPENING = 120;
    public static final int TUBE_WIDTH = 87;
    private Rectangle boundsTop,boundsBot;

    public Tube(float x){
        topTube = new Texture("pipeUp.png");
        bottomTube = new Texture("pipe.png");
        rand = new Random();
        posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop = new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x,posBotTube.y,bottomTube.getWidth(),bottomTube.getHeight());
    }

    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public void dispose() {
        topTube.dispose();
        bottomTube.dispose();
    }
}
