package com.naver.scope93.MapleRandomDefense.game.main;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.objects.Score;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

import java.util.Random;

public class EnemyGenerator implements IGameObject {
    private static final String TAG = EnemyGenerator.class.getSimpleName();
    public static final float GEN_INTERVAL = 0.5f;
    public static final float WAVE_READY = 3.f;
    public static final float BOSS_FIGHT = 20.5f;
    private final Random random = new Random();
    private float enemyTime = WAVE_READY;
    private int wave = 1;
    public int enemyCount = 0;
    private boolean bossalive = false;


    @Override
    public void update(float elapsedSeconds) {
        enemyTime -= elapsedSeconds;
        InGameScene scene = (InGameScene) Scene.top();
        if(wave % 5 != 0) {
            if (enemyTime < 0 && enemyCount < 25 && wave <= 20) {
                generate();
                scene.addMonster();
                enemyTime = GEN_INTERVAL;
                enemyCount++;
            } else if (enemyCount >= 25) {
                enemyTime = WAVE_READY;
                wave += 1;
                scene.setWave(wave);
                enemyCount = 0;
            }
        }
        else{
            if(enemyTime < 0 && enemyCount < 1){
                scene.bossGenerate();
                scene.addMonster();
                generate();
                bossalive = true;
                enemyTime = BOSS_FIGHT;
                enemyCount++;
            } else if(enemyCount > 0 && enemyTime < 0){
                if(scene.isBossAlive()){
                    enemyTime = 0;
                    scene.gameOver();
                    return;
                }
                bossalive = false;
                enemyTime = WAVE_READY;
                wave += 1;
                scene.setWave(wave);
                enemyCount = 0;
            } else if(enemyCount > 0 && wave == 20 && !scene.isBossAlive()){
                scene.gameClear();
            }
        }



    }

    private void generate() {
        Scene scene = Scene.top();
        if(scene == null) return;
        scene.add(InGameScene.Layer.enemy, Enemy.get(wave-1, 1));
    }
    private static Paint timePaint;
    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        if(timePaint == null){
            timePaint = new Paint();
            timePaint.setColor(Color.RED);
            timePaint.setTextSize(5f);
        }
        canvas.translate(12.4f, 0.5f);
        canvas.scale(0.1f, 0.1f);
        if(bossalive){
            canvas.drawText("남은시간 : " + String.format("%.2f", enemyTime), 0f, 0f, timePaint);
        }
        canvas.restore();
    }
}
