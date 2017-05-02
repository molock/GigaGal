package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;

import static com.udacity.gamedev.gigagal.util.Constants.BACKGROUND_COLOR;

/**
 * Created by wayne on 2017/5/1.
 */

public class GameplayScreen implements Screen {

    public static final String TAG = GameplayScreen.class.getName();

    SpriteBatch batch;
    ExtendViewport viewport;
    Level level;


    @Override
    public void show() {
        AssetManager am = new AssetManager();
        Assets.instance.init(am);
        // Initialize Level
        level = new Level();

        batch = new SpriteBatch();
        viewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
    }

    @Override
    public void resize(int width, int height) {
        // Update the viewport
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta) {
        level.update(delta);
        viewport.apply();

        // Clear the screen to the BACKGROUND_COLOR
        Gdx.gl.glClearColor(
                BACKGROUND_COLOR.r,
                BACKGROUND_COLOR.g,
                BACKGROUND_COLOR.b,
                BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        // Render the Level
        level.render(batch);

        batch.end();


    }



    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Assets.instance.dispose();
        batch.dispose();
    }
}
