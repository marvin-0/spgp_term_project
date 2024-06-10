package com.naver.scope93.MapleRandomDefense.game.main;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;

import com.naver.scope93.MapleRandomDefense.app.MapleRandomDefense;
import com.naver.scope93.MapleRandomDefense.game.paused.GameEndScene;
import com.naver.scope93.framework.activity.GameActivity;
import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.objects.Background;
import com.naver.scope93.framework.objects.Score;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

import java.util.ArrayList;

public class InGameScene extends Scene {
    private static final String TAG = InGameScene.class.getSimpleName();
    private UnitGenerator unitGenerator;
    private ArrayList<IGameObject> players;
    private static final int MAP_ROW = 7;
    private static final int MAP_COL = 4;
    private ButtonUI buyButton;
    private ButtonUI sellButton;
    Score money;
    Score wave;
    Score remainMonster;
    private static int monsterKill;
    private static int monsterAmount;
    private static boolean bossAlive = false;

    public enum Layer {
        bg, map, enemy, ui, player, controller, COUNT
    }
    public InGameScene() {
        monsterKill = 0;
        monsterAmount = 0;
        initLayers(Layer.COUNT);

        add(Layer.bg, new Background(R.mipmap.background));
        for(int i = 0; i < MAP_ROW; i++){
            for(int j = 0; j < MAP_COL; j++){
                add(Layer.map, new mapTile(i, j));
            }
        }
        this.unitGenerator = new UnitGenerator();
        add(Layer.controller, unitGenerator);
        add(Layer.controller, new EnemyGenerator());

        this.buyButton = new ButtonUI(0);
        add(Layer.ui, this.buyButton);

        this.sellButton = new ButtonUI(1);
        add(Layer.ui, this.sellButton);

        this.money = new Score(R.mipmap.count_sheet, Metrics.width - 0.5f, 1.0f, 0.6f);
        money.setScore(300);
        add(Layer.ui, money);

        this.wave = new Score(R.mipmap.count_sheet, Metrics.width - 0.5f, 2.0f, 0.6f);
        wave.setScore(1);
        add(Layer.ui, wave);

        this.remainMonster = new Score(R.mipmap.count_sheet, Metrics.width - 0.5f, 3.0f, 0.6f);
        remainMonster.setScore(monsterAmount);
        add(Layer.ui, remainMonster);


    }

    public void addMoney(int amount) {money.add(amount);}
    public void subMoney(int amount) {money.sub(amount);}
    public int getMoney() {return money.getScore();}
    public void setWave(int wave) {this.wave.setScore(wave);}

    public void killMonster() {
        monsterKill += 1;
        monsterAmount -= 1;
        if(monsterKill % 10 == 0){
            money.add(100);
        }
    }

    public void killBoss(){
        bossAlive = false;
        money.add(500);
    }

    public void bossGenerate(){
        bossAlive = true;
    }
    public boolean isBossAlive(){
        return bossAlive;
    }
    public void addMonster(){
        monsterAmount += 1;
    }

    public int getMonsterAmount(){
        return monsterAmount;
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
        remainMonster.setScore(monsterAmount);
        if(monsterAmount >= 15){
            gameOver();
        }
    }

    public void gameOver(){
        Log.d(TAG, "게임오버");
        new GameEndScene(false).push();
    }

    public void gameClear(){
        new GameEndScene(true).push();
    }

    @Override
    public boolean onTouch(MotionEvent event) {
        players = this.objectsAt(Layer.player);
        for(int p = players.size() - 1; p >= 0; p--){
            PlayerUnit playerUnit = (PlayerUnit)players.get(p);
            playerUnit.onTouch(event, this);
        }
        if (money.getScore() >= 100) {
            if(this.buyButton.onTouch(event, unitGenerator)) {
                money.sub(100);
            }
        }
        return true;
    }
}
