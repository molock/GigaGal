package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.udacity.gamedev.gigagal.entities.GigaGal;

/**
 * Created by wayne on 2017/5/1.
 */

public class Level {
    // Add a GigaGal member variable
    GigaGal gigaGal;

    public Level() {
        // Initialize GigaGal
        gigaGal = new GigaGal();

    }

    public void update(float delta) {
        // Update GigaGal
        gigaGal.update(delta);

    }

    public void render(SpriteBatch batch) {
        // Render GigaGal
        gigaGal.render(batch);

    }
}
