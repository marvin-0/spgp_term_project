package com.naver.scope93.MapleRandomDefense.game.paused;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.naver.scope93.framework.objects.Sprite;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

public class PausedScene extends Scene {
    public enum Layer {
        bg, title, touch, COUNT
    }
    private float angle;
    public PausedScene() {
        initLayers(Layer.COUNT);
        float w = Metrics.width, h = Metrics.height;
        float cx = w / 2, cy = h / 2;
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
