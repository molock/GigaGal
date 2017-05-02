package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by wayne on 2017/5/1.
 */

public class Constants {
    // Set a BACKGROUND_COLOR We recommend Color.SKY
    public static final Color BACKGROUND_COLOR = Color.SKY;

    // Set a WORLD_SIZE
    public static final float WORLD_SIZE = 128;

    /**
     * We'll draw our sprites at their natural size, so this is the number of pixels of our Pixel
     * art that will fit on the screen. We're going to use this size to initialize both dimensions
     * of an ExtendViewport, and we'll run the game in landscape mode, so this will really end up
     * specifying the height of the world. We recommend 128.
     */

    public static final String TEXTURE_ATLAS = "images/gigagal.pack.atlas";

    // Add a constant for the name of the standing-right sprite
    public static final String STANDING_RIGHT_NAME = "standing-right";

    // Define a Vector2 Constant for GigaGal's eye position within her sprites (16, 24)
    public static final Vector2 GIGAGAL_EYE_POSITION = new Vector2(16, 24);

    // Define a float constant for the height of GigaGal's eye above her feet (16)
    public static final float GIGAGAL_EYE_HEIGHT = 16;

    public static final float GIGAGAL_MOVE_SPEED = 40;


}
