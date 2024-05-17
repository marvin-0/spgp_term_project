package com.naver.scope93.MapleRandomDefense.game.main;

import android.view.MotionEvent;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.objects.Background;
import com.naver.scope93.framework.objects.Score;
import com.naver.scope93.framework.scene.Scene;
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


    public enum Layer {
        bg, map, enemy, ui, player, controller, COUNT
    }
    public InGameScene() {
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

    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

    @Override
    public boolean onTouch(MotionEvent event) {
        players = this.objectsAt(Layer.player);
        for(int p = players.size() - 1; p >= 0; p--){
            PlayerUnit playerUnit = (PlayerUnit)players.get(p);
            playerUnit.onTouch(event, this);
        }
        this.buyButton.onTouch(event, unitGenerator);
        return true;
    }
}
