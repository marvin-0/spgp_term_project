package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.naver.scope93.framework.objects.Sprite;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.BuildConfig;
import com.naver.scope93.spgp_term_project.R;

public class Map extends Sprite {
    private static final String TAG = Map.class.getSimpleName();

    private static final float MAP_RADIUS = 0.7f;

    public Map(int row, int col) {
        super(R.mipmap.grass);
        setPosition(Metrics.width / 4 + (2 * MAP_RADIUS * row), Metrics.height / 3 + (2 * MAP_RADIUS * col), MAP_RADIUS);
    }

    @Override
    public void update(float elapsedSeconds) {
        //super.update(elapsedSeconds);
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

    public static Map get(int row, int col){
        return new Map(row, col);
    }

    public void generate(){
        Scene scene = Scene.top();
        if(scene == null) return;

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 4; j++){
                scene.add(InGameScene.Layer.map, Map.get(i, j));
            }
        }
    }
}
