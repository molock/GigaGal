package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

/**
 * Created by wayne on 2017/5/1.
 */

public class Level {
    // Add a GigaGal member variable
    GigaGal gigaGal;
    Array<Platform> platforms;

    public Level() {
        // Initialize GigaGal
        gigaGal = new GigaGal();
        platforms = new Array<Platform>();
        platforms.add(new Platform(50,20,100,30));

    }

    public void update(float delta) {
        // Update GigaGal
        gigaGal.update(delta);
    }

    public void render(SpriteBatch batch) {
        batch.begin();

        for (Platform platform : platforms) {
            platform.render(batch);
        }

        gigaGal.render(batch);

        batch.end();

    }
}
