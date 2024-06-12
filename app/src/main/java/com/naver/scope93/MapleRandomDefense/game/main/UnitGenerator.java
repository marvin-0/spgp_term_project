package com.naver.scope93.MapleRandomDefense.game.main;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.res.Sound;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.spgp_term_project.R;

import java.util.ArrayList;
import java.util.Random;

public class UnitGenerator implements IGameObject {
    private static final String TAG = UnitGenerator.class.getSimpleName();
    private final Random random = new Random();
    private int index = 0;
    @Override
    public void update(float elapsedSeconds) {

    }

    @Override
    public void draw(Canvas canvas) {

    }

    private void generate(){
        Scene scene = Scene.top();
        if(scene == null) return;
        scene.add(InGameScene.Layer.player, PlayerUnit.get(randomLevel(), this.index, (InGameScene) scene));
    }

    private int randomLevel(){
        int randomNum = random.nextInt(100);

        int[] gamble = {50, 75, 90, 95, 99};
        //int[] gamble = {20, 40, 60, 80, 100};

        for(int i = 0; i < gamble.length; ++i){
            if(randomNum < gamble[i]){
                return i;
            }
        }
        Sound.playEffect(R.raw.highlevel_pick);
        return 5;
    }

    public boolean onTouch(MotionEvent event, InGameScene scene){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            ArrayList<IGameObject> tiles = scene.objectsAt(InGameScene.Layer.map);

            for(int t = 0; t < tiles.size(); t++){
                mapTile tile = (mapTile)tiles.get(t);
                if(!tile.unitPlace){
                    index = t;
                    generate();
                    return true;
                }
            }
        }
        return false;
    }
}
