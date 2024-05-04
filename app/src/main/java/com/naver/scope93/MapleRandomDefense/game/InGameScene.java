package com.naver.scope93.MapleRandomDefense.game;

import android.view.MotionEvent;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.objects.Background;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.spgp_term_project.R;

import java.util.ArrayList;

public class InGameScene extends Scene {
    private static final String TAG = InGameScene.class.getSimpleName();
    private UnitGenerator unitGenerator;
    private ArrayList<IGameObject> players;
    private static final int MAP_ROW = 7;
    private static final int MAP_COL = 4;

    //private final PlayerUnit playerUnit;

    public enum Layer {
        bg, map, enemy,  player, ui, controller, COUNT
    }
    public InGameScene() {
        initLayers(Layer.COUNT);
        this.unitGenerator = new UnitGenerator();
        add(Layer.controller, unitGenerator);

        add(Layer.bg, new Background(R.mipmap.background));
        for(int i = 0; i < MAP_ROW; i++){
            for(int j = 0; j < MAP_COL; j++){
                add(Layer.map, new Map_Tile(i, j));
            }
        }

        add(Layer.controller, new EnemyGenerator());


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
        unitGenerator.onTouch(event);
        return true;
    }
}
