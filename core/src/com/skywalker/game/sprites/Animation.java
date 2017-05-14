package com.skywalker.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/**
 * Created by HARSHISH on 09-12-2016.
 */
public class Animation {
    public Array<Texture> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(int frameCount,float cycleTime){
        frames = new Array<Texture>();
        frames.add(new Texture("bird1.png"));
        frames.add(new Texture("bird2.png"));
        frames.add(new Texture("bird3.png"));
        frames.add(new Texture("bird4.png"));
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if(frame==frameCount)
            frame = 0;
    }

    public Texture getFrame(){
        return frames.get(frame);
    }

    public void dispose(){
        for (Texture t : frames)
            t.dispose();
    }
}
