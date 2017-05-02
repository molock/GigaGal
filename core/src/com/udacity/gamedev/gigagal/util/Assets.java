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
        public final TextureAtlas.AtlasRegion standingRight;
        public final TextureAtlas.AtlasRegion standingLeft;

        public final TextureAtlas.AtlasRegion jumpingRight;
        public final TextureAtlas.AtlasRegion jumpingLeft;

        public final TextureAtlas.AtlasRegion walkingRight;
        public final TextureAtlas.AtlasRegion walkingLeft;



        public GigaGalAssets(TextureAtlas atlas) {
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT);
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT);

            jumpingRight = atlas.findRegion(Constants.JUMPING_RIGHT);
            jumpingLeft = atlas.findRegion(Constants.JUMPING_LEFT);

            walkingRight = atlas.findRegion(Constants.WALK_2_RIGHT);
            walkingLeft = atlas.findRegion(Constants.WALK_2_LEFT);

        }
    }

}
