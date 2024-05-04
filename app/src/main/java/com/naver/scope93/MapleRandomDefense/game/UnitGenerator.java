package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.scene.Scene;

import java.util.ArrayList;
import java.util.Map;
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
        scene.add(InGameScene.Layer.player, PlayerUnit.get(0, this.index, (InGameScene) scene));
    }

    public boolean onTouch(MotionEvent event, InGameScene scene){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            ArrayList<IGameObject> tiles = scene.objectsAt(InGameScene.Layer.map);
            for(int t = 0; t < tiles.size(); t++){
                mapTile tile = (mapTile)tiles.get(t);
                if(!tile.unitPlace){
                    index = t;
                    generate();
                    break;
                }
            }
            return true;
        }
        return false;
    }
}
