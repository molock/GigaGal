package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
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

        public final TextureAtlas.AtlasRegion walkingRight_1;
        public final TextureAtlas.AtlasRegion walkingLeft_1;

        public final TextureAtlas.AtlasRegion walkingRight_2;
        public final TextureAtlas.AtlasRegion walkingLeft_2;

        public final TextureAtlas.AtlasRegion walkingRight_3;
        public final TextureAtlas.AtlasRegion walkingLeft_3;

        public final Animation<TextureAtlas.AtlasRegion> walkRightAnimation;
        public final Animation<TextureAtlas.AtlasRegion> walkLeftAnimation;


        public GigaGalAssets(TextureAtlas atlas) {
            standingRight = atlas.findRegion(Constants.STANDING_RIGHT);
            standingLeft = atlas.findRegion(Constants.STANDING_LEFT);

            jumpingRight = atlas.findRegion(Constants.JUMPING_RIGHT);
            jumpingLeft = atlas.findRegion(Constants.JUMPING_LEFT);

            walkingRight_1 = atlas.findRegion(Constants.WALK_RIGHT_1);
            walkingLeft_1 = atlas.findRegion(Constants.WALK_LEFT_1);

            walkingRight_2 = atlas.findRegion(Constants.WALK_RIGHT_2);
            walkingLeft_2 = atlas.findRegion(Constants.WALK_LEFT_2);

            walkingRight_3 = atlas.findRegion(Constants.WALK_RIGHT_3);
            walkingLeft_3 = atlas.findRegion(Constants.WALK_LEFT_3);

            Array<TextureAtlas.AtlasRegion> walkRightFrames = new Array<TextureAtlas.AtlasRegion>();
            walkRightFrames.add(walkingRight_1);
            walkRightFrames.add(walkingRight_2);
            walkRightFrames.add(walkingRight_3);

            walkRightAnimation = new Animation(
                    Constants.WALK_LOOP_DURATION,
                    walkRightFrames,
                    Animation.PlayMode.LOOP);

            Array<TextureAtlas.AtlasRegion> walkLeftFrames = new Array<TextureAtlas.AtlasRegion>();
            walkLeftFrames.add(walkingLeft_1);
            walkLeftFrames.add(walkingLeft_2);
            walkLeftFrames.add(walkingLeft_3);

            walkLeftAnimation = new Animation(
                    Constants.WALK_LOOP_DURATION,
                    walkLeftFrames,
                    Animation.PlayMode.LOOP);



        }
    }

}
