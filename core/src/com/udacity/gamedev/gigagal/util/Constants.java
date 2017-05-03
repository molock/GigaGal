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

    public static final String STANDING_RIGHT = "standing-right";
    public static final String STANDING_LEFT = "standing-left";
    public static final String JUMPING_RIGHT = "jumping-right";
    public static final String JUMPING_LEFT = "jumping-left";

    public static final String WALK_RIGHT_2 = "walk-2-right";
    public static final String WALK_LEFT_2 = "walk-2-left";

    public static final String WALK_RIGHT_1 = "walk-1-right";
    public static final String WALK_LEFT_1 = "walk-1-left";

    public static final String WALK_RIGHT_3 = "walk-3-right";
    public static final String WALK_LEFT_3 = "walk-3-left";

    public static final float WALK_LOOP_DURATION = 0.25f;

    // Define a Vector2 Constant for GigaGal's eye position within her sprites (16, 24)
    public static final Vector2 GIGAGAL_EYE_POSITION = new Vector2(16, 24);

    public static final float GIGAGAL_EYE_HEIGHT = 16f;
    public static final float GIGAGAL_MOVE_SPEED = 40;
    public static final float GIGAGAL_JUMP_SPEED = 250;

    // Add constant for GigaGal's max jump duration
    // Meaning how long you can hold the jump key to continue to jump higher. 0.15 seconds works well
    public static final float GIGAGAL_MAX_JUMP_DURATION = 0.15f;

    // Add constant for acceleration due to gravity
    // Something like 1000 works well.
    public static final float GRAVITY_ACC = 1000;

}
