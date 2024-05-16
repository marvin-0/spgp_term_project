package com.naver.scope93.MapleRandomDefense.game.main;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.naver.scope93.framework.objects.Sprite;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

public class ButtonUI extends Sprite {
    private static final String TAG = ButtonUI.class.getSimpleName();
    private static final int[] resIds = {
            R.mipmap.pickup_button, R.mipmap.sell_button
    };
    private static final float BUTTON_WIDTH = 2.5f;
    private static final float BUTTON_HEIGHT = 1.2f;

    private int type;

    public ButtonUI(int type){
        super(resIds[type]);
        this.type = type;
        setPosition(Metrics.width - (BUTTON_WIDTH * 0.7f) - (BUTTON_WIDTH * type * 1.5f), Metrics.height - BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    @Override
    public void update(float elapsedSeconds) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean onTouch(MotionEvent event, UnitGenerator unitGenerator){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            float[] pts = Metrics.fromScreen(event.getX(), event.getY());
            if(type == 0 && dstRect.contains(pts[0], pts[1])){
                return unitGenerator.onTouch(event, (InGameScene) Scene.top());
            }
            return true;
        }
        return false;
    }


}
