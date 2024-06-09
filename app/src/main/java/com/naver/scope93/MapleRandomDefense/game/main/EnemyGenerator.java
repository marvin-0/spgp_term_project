package com.naver.scope93.MapleRandomDefense.game.main;

import android.graphics.Canvas;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.scene.Scene;

import java.util.Random;

public class EnemyGenerator implements IGameObject {
    private static final String TAG = EnemyGenerator.class.getSimpleName();
    public static final float GEN_INTERVAL = 0.5f;
    public static final float WAVE_READY = 1.f;
    public static final float BOSS_FIGHT = 20.f;
    private final Random random = new Random();
    private float enemyTime = WAVE_READY;
    private int wave = 1;
    public int enemyCount = 0;

    @Override
    public void update(float elapsedSeconds) {
        enemyTime -= elapsedSeconds;
        if(wave % 5 != 0) {
            if (enemyTime < 0 && enemyCount < 25 && wave <= 20) {
                generate();
                enemyTime = GEN_INTERVAL;
                enemyCount++;
            } else if (enemyCount >= 25) {
                enemyTime = WAVE_READY;
                wave += 1;
                enemyCount = 0;
            }
        }
        else{
            if(enemyTime < 0 && enemyCount < 1){
                InGameScene scene = (InGameScene) Scene.top();
                scene.bossGenerate();
                generate();
                enemyTime = BOSS_FIGHT;
                enemyCount++;
            } else if(enemyCount > 0 && enemyTime < 0){
                InGameScene scene = (InGameScene) Scene.top();
                if(scene.isBossAlive()){
                    scene.gameOver();
                    return;
                }
                enemyTime = WAVE_READY;
                wave += 1;
                enemyCount = 0;
            }
        }


    }

    private void generate() {
        Scene scene = Scene.top();
        if(scene == null) return;
        scene.add(InGameScene.Layer.enemy, Enemy.get(wave-1, 1));
    }

    @Override
    public void draw(Canvas canvas) {

    }
}
