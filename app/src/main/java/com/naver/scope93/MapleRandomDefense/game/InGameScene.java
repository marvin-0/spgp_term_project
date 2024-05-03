package com.naver.scope93.MapleRandomDefense.game;

import android.view.MotionEvent;

import com.naver.scope93.framework.objects.Background;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.spgp_term_project.R;

public class InGameScene extends Scene {
    private static final String TAG = InGameScene.class.getSimpleName();
    private final PlayerUnit playerUnit;
    private static final int MAP_ROW = 7;
    private static final int MAP_COL = 4;

    //private final PlayerUnit playerUnit;

    public enum Layer {
        bg, map, enemy,  player, ui, COUNT
    }
    public InGameScene() {

        initLayers(Layer.COUNT);
        this.playerUnit = new PlayerUnit();
        add(Layer.player, playerUnit);
        add(Layer.bg, new Background(R.mipmap.background));
        for(int i = 0; i < MAP_ROW; i++){
            for(int j = 0; j < MAP_COL; j++){
                add(Layer.map, Map.get(i, j));
            }
        }

    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

    @Override
    public boolean onTouch(MotionEvent event) {
        return playerUnit.onTouch(event);
    }
}
