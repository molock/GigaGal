package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by wayne on 2017/5/1.
 */

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();

    public static final Assets instance = new Assets();

    public GigaGalAssets gigaGalAssets;

    private AssetManager assetManager;

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS, TextureAtlas.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS);
        gigaGalAssets = new GigaGalAssets(atlas);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public class GigaGalAssets {
        // Add a AtlasRegion to hold the standing-right sprite
        public final TextureAtlas.AtlasRegion standingRightSprite;
        public final TextureAtlas.AtlasRegion standingLeftSprite;

        // Add AtlasRegions for jumping-left and jumping-right
        public final TextureAtlas.AtlasRegion jumpingRightSprite;
        public final TextureAtlas.AtlasRegion jumpingLeftSprite;


        public GigaGalAssets(TextureAtlas atlas) {
            // Use atlas.findRegion() to initialize the standing right AtlasRegion
            standingRightSprite = atlas.findRegion(Constants.STANDING_RIGHT);
            standingLeftSprite = atlas.findRegion(Constants.STANDING_LEFT);

            // Find jumping-left and jumping-right
            jumpingRightSprite = atlas.findRegion(Constants.JUMPING_RIGHT);
            jumpingLeftSprite = atlas.findRegion(Constants.JUMPING_LEFT);
        }
    }

}
