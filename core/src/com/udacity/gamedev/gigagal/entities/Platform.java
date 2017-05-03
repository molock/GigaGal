package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.udacity.gamedev.gigagal.util.Assets;

import static com.udacity.gamedev.gigagal.util.Constants.GIGAGAL_EYE_POSITION;

/**
 * Created by wayne on 2017/5/1.
 */

public class Platform {

    // Add members for the platform top, bottom, left edge, right edge, width, and height

    float top;
    float bottom;
    float left;
    float right;
    float width;
    float height;


    public Platform(float left, float top, float width, float height) {
        // Populate the member variables
       this.top = top;
       this.bottom = top - height;
       this.left = left;
       this.right = left + width;
       this.width = width;
       this.height = height;
    }

    public void render(SpriteBatch batch) {
        // TODO: Draw the platform using the NinePatch
        Assets.instance.platformAssets.platformNinePatch.draw(batch, left, top, width, height);

    }
}
