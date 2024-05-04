package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.naver.scope93.framework.interfaces.IRecyclable;
import com.naver.scope93.framework.objects.AnimSprite;
import com.naver.scope93.framework.objects.Sprite;
import com.naver.scope93.framework.scene.RecycleBin;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

public class PlayerUnit extends AnimSprite implements IRecyclable {
    private static final String TAG = PlayerUnit.class.getSimpleName();
    private int level;
    private int atk, range;
    private int index;
    private static final float UNIT_WIDTH = 0.9f;
    private static final float UNIT_HEIGHT = 1.3f;

    private PlayerUnit(int level, int index) {
        super(R.mipmap.normal_idle, 10.0f);
        init(level, index);

    }

    private void init(int level, int index){
        this.level = level;
        this.atk = (level + 1) * 30;
        this.range = level + 2;
        this.index = index;
        setAnimationResource(R.mipmap.normal_idle, 10.0f, 4);
        setPosition(Metrics.width / 2, Metrics.height/2, UNIT_WIDTH, UNIT_HEIGHT);
    }

    public static PlayerUnit get(int level, int index){
        PlayerUnit playerUnit = (PlayerUnit) RecycleBin.get(PlayerUnit.class);
        if(playerUnit != null){
            playerUnit.init(level, index);
            return playerUnit;
        }
        return new PlayerUnit(level, index);
    }

    public void update(float elapsedSeconds){

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private boolean selectOn = false;

    public boolean onTouch(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float[] pts = Metrics.fromScreen(event.getX(), event.getY());
                if(dstRect.contains(pts[0], pts[1])){
                    Log.d(TAG, "터치됨 "+this.index);
                    selectOn = true;
                    setPosition(pts[0], pts[1], 0.9f, 1.3f);
                    return true;
                }
                else{
                    Log.d(TAG, "마우스 x, " + pts[0] + "캐릭터 x : " + dstRect.centerX() + "인덱스 : " + this.index);
                    return false;
                }
            case MotionEvent.ACTION_UP:
                selectOn = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                pts = Metrics.fromScreen(event.getX(), event.getY());
                if(selectOn){
                    //Log.d(TAG, "마우스 x, " + pts[0] + "캐릭터 x : " + dstRect.centerX());
                    setPosition(pts[0], pts[1], UNIT_WIDTH, UNIT_HEIGHT);
                }
                return true;
        }
        return false;
    }

    @Override
    public void onRecycle() {

    }
}
