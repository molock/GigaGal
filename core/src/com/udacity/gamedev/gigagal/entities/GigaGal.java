package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;

import static com.udacity.gamedev.gigagal.util.Constants.GIGAGAL_EYE_HEIGHT;
import static com.udacity.gamedev.gigagal.util.Constants.GIGAGAL_EYE_POSITION;

/**
 * Created by wayne on 2017/5/1.
 */

public class GigaGal {

    public final static String TAG = GigaGal.class.getName();

    // Add a position
    public Vector2 position;


    public GigaGal() {
        // Initialize GigaGal's position with height = GIGAGAL_EYE_HEIGHT
        position = new Vector2(20, GIGAGAL_EYE_HEIGHT);

    }

    public void update(float delta) {

        // Use Gdx.input.isKeyPressed() to check if the left arrow key is pressed
        // If so, call moveLeft()
        // Do the same with the right ArrowKey
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveLeft(delta);
        }

        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveRight(delta);
        }

    }

    private void moveLeft(float delta) {
        // TODO: Move GigaGal left by delta * movement speed
        position.x -= delta * Constants.GIGAGAL_MOVE_SPEED;

    }

    private void moveRight(float delta) {
        // TODO: Same for moving GigaGal right
        position.x += delta * Constants.GIGAGAL_MOVE_SPEED;
    }

    public void render(SpriteBatch batch) {
        // Draw GigaGal's standing-right sprite at position - GIGAGAL_EYE_POSITION

        TextureRegion region = Assets.instance.gigaGalAssets.standingRightSprite;

        batch.draw(
                region.getTexture(),
                position.x - GIGAGAL_EYE_POSITION.x,
                position.y - GIGAGAL_EYE_POSITION.y,
                0, 0,
                region.getRegionWidth(),
                region.getRegionHeight(),
                1, 1,
                0,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                false,
                false
        );



    }


}
