package com.naver.scope93.MapleRandomDefense.game.main;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.naver.scope93.framework.objects.Sprite;
import com.naver.scope93.spgp_term_project.BuildConfig;
import com.naver.scope93.spgp_term_project.R;

public class mapTile extends Sprite {
    private static final String TAG = mapTile.class.getSimpleName();

    private static final float MAP_RADIUS = 0.6f;
    private static final float MAP_LEFT = 3.8f;
    private static final float MAP_TOP = 2.0f;
    private static final float MAP_RIGHT = MAP_LEFT + (2*MAP_RADIUS*7);
    private static final float MAP_BOTTOM = MAP_TOP + (2*MAP_RADIUS*4);
    public boolean unitPlace = false;
    public int unitIndex = -1;

    public mapTile(int row, int col) {
        super(R.mipmap.grass);
        setPosition(MAP_LEFT + (2 * MAP_RADIUS * row), MAP_TOP + (2 * MAP_RADIUS * col), MAP_RADIUS);
        //setPosition(0.5f + (2 * MAP_RADIUS * row), Metrics.height / 3 + (2 * MAP_RADIUS * col), MAP_RADIUS);
    }

    @Override
    public void update(float elapsedSeconds) {

    }

    private static Paint tilePaint;


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(BuildConfig.DEBUG) {
            if(tilePaint == null){
                tilePaint = new Paint();
                tilePaint.setStyle(Paint.Style.STROKE);
                tilePaint.setColor(Color.RED);
            }
            canvas.drawRect(dstRect, tilePaint);
        }
    }

    public RectF getRect(){
        return dstRect;
    }

}
