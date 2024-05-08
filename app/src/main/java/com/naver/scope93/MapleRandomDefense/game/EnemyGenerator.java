package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.scene.Scene;

import java.util.Random;

public class EnemyGenerator implements IGameObject {
    private static final String TAG = EnemyGenerator.class.getSimpleName();
    public static final float GEN_INTERVAL = 0.5f;
    public static final float WAVE_READY = 5.f;
    private final Random random = new Random();
    private float enemyTime = WAVE_READY;
    private int wave;
    public int enemyCount = 0;

    @Override
    public void update(float elapsedSeconds) {
        enemyTime -= elapsedSeconds;
        if (enemyTime < 0 && enemyCount < 25) {
            generate();
            enemyTime = GEN_INTERVAL;
            enemyCount++;
        } else if(enemyCount >= 25){
            enemyTime = WAVE_READY;
            enemyCount = 0;
        }
    }

    private void generate() {
        Scene scene = Scene.top();
        if(scene == null) return;
        scene.add(InGameScene.Layer.enemy, Enemy.get(1, 1));
    }

    @Override
    public void draw(Canvas canvas) {

    }
}
