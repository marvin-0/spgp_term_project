package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.naver.scope93.framework.objects.Sprite;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

public class PlayerUnit extends Sprite {
    private static final String TAG = PlayerUnit.class.getSimpleName();

    public PlayerUnit() {
        super(R.mipmap.beginner_idle1);
        setPosition(Metrics.width / 2, Metrics.height/2, 0.9f, 1.3f);

    }

    public void update(float elapsedSeconds){

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private static boolean selectOn = false;

    public boolean onTouch(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float[] pts = Metrics.fromScreen(event.getX(), event.getY());
                if(dstRect.contains(pts[0], pts[1])){
                    Log.d(TAG, "터치됨");
                    selectOn = true;
                    setPosition(pts[0], pts[1], 0.9f, 1.3f);
                }
                else{
                    Log.d(TAG, "마우스 x, " + pts[0] + "캐릭터 x : " + dstRect.centerX());
                }
                return true;
            case MotionEvent.ACTION_UP:
                selectOn = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                pts = Metrics.fromScreen(event.getX(), event.getY());
                if(selectOn){
                    Log.d(TAG, "마우스 x, " + pts[0] + "캐릭터 x : " + dstRect.centerX());
                    setPosition(pts[0], pts[1], 0.9f, 1.3f);
                }
                return true;
        }
        return false;
    }
}
