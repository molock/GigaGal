package com.udacity.gamedev.gigagal.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
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

    // Add a Facing member variable (defined below)
    Facing facing;

    // Add a Vector2 for GigaGal's velocity
    Vector2 velocity;

    // Add a JumpState
    JumpState jumpState;

    // Add a long for jumpStartTime
    long jumpStartTime;


    public GigaGal() {
        // Initialize GigaGal's position with height = GIGAGAL_EYE_HEIGHT
        position = new Vector2(20, GIGAGAL_EYE_HEIGHT);
        // Initialize facing, probably with Facing.RIGHT
        facing = Facing.RIGHT;

        // Initialize velocity
        velocity = new Vector2(0, 0);

        // Initialize JumpState (probably to FALLING)
        jumpState = JumpState.FALLING;

    }

    public void update(float delta) {
        // TODO: Accelerate GigaGal down
        // Multiple delta by the acceleration due to gravity and subtract it from GG's vertical velocity

        velocity.y -= Constants.GRAVITY_ACC * delta;

        // TODO: Apply GigaGal's velocity to her position
        // Vector2.mulAdd() is very convenient.
        position.mulAdd(velocity, delta);

        // TODO: If GigaGal isn't JUMPING, make her now FALLING
        if(jumpState != JumpState.JUMPING) {
            jumpState = JumpState.FALLING;
        }

        // Check if GigaGal has landed on the ground
        // Remember that position keeps track of GigaGal's eye position, not her feet.
        // If she has indeed landed, change her jumpState to GROUNDED, set her vertical velocity to 0,
        // and make sure her feet aren't sticking into the floor.
        if (position.y < GIGAGAL_EYE_HEIGHT) {
            jumpState = JumpState.GROUNDED;
            velocity.y = 0;
            position.y = GIGAGAL_EYE_HEIGHT;
        }

        if (Gdx.input.isKeyPressed(Keys.Z)) {
            // Handle jump key
            // Add a switch statement. If the jump key is pressed and GG is GROUNDED, then startJump()
            // If she's JUMPING, then continueJump()
            // If she's falling, then don't do anything

            switch (jumpState) {
                case GROUNDED: startJump();
                case JUMPING: continueJump();
                case FALLING: break;
            }

        } else {
            // If the jump key wasn't pressed, endJump()
            endJump();
        }


        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            moveLeft(delta);
        }

        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            moveRight(delta);
        }

    }

    private void moveLeft(float delta) {
        // Update facing direction
        facing = Facing.LEFT;

        // Move GigaGal left by delta * movement speed
        position.x -= delta * Constants.GIGAGAL_MOVE_SPEED;

    }

    private void moveRight(float delta) {
        // Update facing direction
        facing = Facing.RIGHT;

        // Same for moving GigaGal right
        position.x += delta * Constants.GIGAGAL_MOVE_SPEED;
    }

    private void startJump() {
        // Set jumpState to JUMPING
        jumpState = JumpState.JUMPING;

        // Set the jump start time
        // Using TimeUtils.nanoTime()
        jumpStartTime = TimeUtils.nanoTime();

        // Call continueJump()
        continueJump();

    }

    private void continueJump() {
        // First, check if we're JUMPING, if not, just return
        if(jumpState != JumpState.JUMPING) {
            return;
        }

        // Find out how long we've been jumping
        float jumpDuration = MathUtils.nanoToSec * (TimeUtils.nanoTime() - jumpStartTime);

        // If we have been jumping for less than the max jump duration, set GG's vertical speed to the jump speed constant
        if (jumpDuration < Constants.GIGAGAL_MAX_JUMP_DURATION) {
            velocity.y = Constants.GIGAGAL_JUMP_SPEED;

            // Else, call endJump()
        } else {
            endJump();
        }
    }

    private void endJump() {
        // If we're JUMPING, now we're FALLING
        if(jumpState == JumpState.JUMPING) {
            jumpState = JumpState.FALLING;
        }

    }

    public void render(SpriteBatch batch) {
        // Draw GigaGal's standing-right sprite at position - GIGAGAL_EYE_POSITION

        TextureRegion region = Assets.instance.gigaGalAssets.standingRightSprite;

        // Set region to the correct sprite for the current facing direction
        if(facing == Facing.LEFT) {
            region = Assets.instance.gigaGalAssets.standingLeftSprite;
        }


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

    // Do this first! Add a JumpState enum containing JUMPING, FALLING, and GROUNDED
    enum JumpState{
        JUMPING,
        FALLING,
        GROUNDED
    }


    // DO THIS FIRST!!! Create an enum called Facing, with LEFT and RIGHT members
    enum Facing{
        LEFT,
        RIGHT
    }


}
