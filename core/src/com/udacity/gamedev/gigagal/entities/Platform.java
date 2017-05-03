package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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

    public void render(ShapeRenderer renderer) {

        // Draw a box representing the platform
        renderer.setColor(Color.ORANGE);
        renderer.rect(left, bottom, width, height);
    }
}
