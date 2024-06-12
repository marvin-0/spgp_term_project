package com.naver.scope93.MapleRandomDefense.game.paused;

import com.naver.scope93.framework.objects.Button;
import com.naver.scope93.framework.objects.Sprite;
import com.naver.scope93.framework.res.Sound;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

public class GameEndScene extends Scene {
    public enum Layer {
        bg, title, touch, COUNT
    }
    private float angle;
    public GameEndScene(boolean isClear) {
        initLayers(Layer.COUNT);
        float w = Metrics.width, h = Metrics.height;
        float cx = w / 2, cy = h / 2;
        add(Layer.bg, new Sprite(R.mipmap.trans_50b, cx, cy, w, h));
        if(isClear) {
            add(Layer.bg, new Sprite(R.mipmap.gameclear, cx, cy, 8.0f, 4.75f));
        }else{
            add(Layer.bg, new Sprite(R.mipmap.gameover, cx, cy, 8.0f, 4.75f));
        }

        add(Layer.touch, new Button(R.mipmap.restart_button, 6f, 5.5f, 2.667f, 1f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                Sound.stopMusic();
                restart();
                return false;
            }
        }));
        add(Layer.touch, new Button(R.mipmap.title_button, 10f, 5.5f, 2.667f, 1f, new Button.Callback() {
            @Override
            public boolean onTouch(Button.Action action) {
                Sound.stopMusic();
                Scene.popAll();
                return false;
            }
        }));
    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

    @Override
    protected int getTouchLayerIndex() {
        return Layer.touch.ordinal();
    }

    @Override
    public boolean isTransparent() {
        return true;
    }
}
