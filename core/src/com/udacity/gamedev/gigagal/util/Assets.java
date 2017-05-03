package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by wayne on 2017/5/1.
 */

public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();

    public static final Assets instance = new Assets();
    public GigaGalAssets gigaGalAssets;
    public PlatformAssets platformAssets;
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
        platformAssets = new PlatformAssets(atlas);
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

        public final Animation<AtlasRegion> walkRightAnimation;
        public final Animation<AtlasRegion> walkLeftAnimation;


        public GigaGalAssets(TextureAtlas atlas) {
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT);
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT);

            jumpingRight = atlas.findRegion(Constants.JUMPING_RIGHT);
            jumpingLeft = atlas.findRegion(Constants.JUMPING_LEFT);

            Array<AtlasRegion> walkRightFrames = new Array<AtlasRegion>();
            walkRightFrames.add(atlas.findRegion(Constants.WALK_RIGHT_1));
            walkRightFrames.add(atlas.findRegion(Constants.WALK_RIGHT_2));
            walkRightFrames.add(atlas.findRegion(Constants.WALK_RIGHT_3));

            walkRightAnimation = new Animation<AtlasRegion>(
                    Constants.WALK_LOOP_DURATION,
                    walkRightFrames,
                    PlayMode.LOOP_PINGPONG);

            Array<AtlasRegion> walkLeftFrames = new Array<AtlasRegion>();
            walkLeftFrames.add(atlas.findRegion(Constants.WALK_LEFT_1));
            walkLeftFrames.add(atlas.findRegion(Constants.WALK_LEFT_2));
            walkLeftFrames.add(atlas.findRegion(Constants.WALK_LEFT_3));

            walkLeftAnimation = new Animation<AtlasRegion>(
                    Constants.WALK_LOOP_DURATION,
                    walkLeftFrames,
                    PlayMode.LOOP_PINGPONG);
        }


    }

    public class PlatformAssets {

        // Add a NinePatch member
        public final NinePatch platformNinePatch;
        public final TextureRegion platformTexture;

        public PlatformAssets(TextureAtlas atlas) {
            int edge = Constants.PLATFORM_EDGE_SIZE;

            // Find the AtlasRegion holding the platform
            platformTexture = atlas.findRegion(Constants.PLATFORM);

            // Turn that AtlasRegion into a NinePatch using the edge constant you defined
            platformNinePatch = new NinePatch(platformTexture, edge, edge, edge, edge);

        }
    }

}
