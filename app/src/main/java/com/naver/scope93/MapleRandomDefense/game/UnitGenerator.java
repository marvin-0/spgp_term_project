package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.scene.Scene;

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
        scene.add(InGameScene.Layer.player, PlayerUnit.get(1, this.index));
        this.index += 1;
    }

    public boolean onTouch(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            generate();
            return true;
        }
        return false;
    }
}
