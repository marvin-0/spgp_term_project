package com.naver.scope93.MapleRandomDefense.game.main;

import android.util.Log;
import android.view.MotionEvent;

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
    private static int monsterKill;
    private static int monsterAmount;

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

        this.money = new Score(R.mipmap.count_sheet, 3.0f, Metrics.height -1.5f, 0.6f);
        money.setScore(300);
        add(Layer.ui, money);

    }

    public void addMoney(int amount) {money.add(amount);}
    public void subMoney(int amount) {money.sub(amount);}
    public int getMoney() {return money.getScore();}

    public void killMonster() {
        monsterKill += 1;
        monsterAmount -= 1;
        if(monsterKill % 5 == 0){
            money.add(100);
        }
    }
    public void addMonster(){
        monsterAmount += 1;
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
        if(monsterAmount >= 15){
            Log.d(TAG, "게임오버");
            Scene.popAll();
        }
    }

    @Override
    public boolean onTouch(MotionEvent event) {
        players = this.objectsAt(Layer.player);
        for(int p = players.size() - 1; p >= 0; p--){
            PlayerUnit playerUnit = (PlayerUnit)players.get(p);
            playerUnit.onTouch(event, this);
        }
        if(money.getScore() >= 100) {
            if(this.buyButton.onTouch(event, unitGenerator))
                money.sub(100);
        }
        return true;
    }
}
