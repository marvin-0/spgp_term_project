package com.naver.scope93.MapleRandomDefense.game.main;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;

import com.naver.scope93.framework.interfaces.IRecyclable;
import com.naver.scope93.framework.objects.AnimSprite;
import com.naver.scope93.framework.scene.RecycleBin;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.util.Gauge;
import com.naver.scope93.spgp_term_project.R;

import java.util.ArrayList;

//implements IBoxCollidable, IRecyclable
public class Enemy extends AnimSprite implements IRecyclable{
    private static final float SPEED = 3.0f;
    private static final float RADIUS = 0.3f;
    private int level;
    private int life, maxLife;
    private static final int[] resId = {
            R.mipmap.monster1_sheet, R.mipmap.monster2_sheet, R.mipmap.monster3_sheet,
            R.mipmap.monster4_sheet, R.mipmap.boss1_sheet, R.mipmap.monster5_sheet,
            R.mipmap.monster6_sheet, R.mipmap.monster7_sheet, R.mipmap.monster8_sheet,
            R.mipmap.boss2_sheet, R.mipmap.monster9_sheet, R.mipmap.monster10_sheet,
            R.mipmap.monster11_sheet, R.mipmap.monster12_sheet, R.mipmap.boss3_sheet,
            R.mipmap.monster13_sheet, R.mipmap.monster14_sheet, R.mipmap.monster15_sheet,
            R.mipmap.monster16_sheet, R.mipmap.boss4_sheet
    };
    private static final int[] frameCount = {
            8, 4, 4,
            6, 6, 7,
            7, 7, 7,
            7, 4, 4,
            4, 4, 6,
            4, 3, 4,
            3, 6
    };
    private static PointF[] monsterSize = {
            makeSize(0.5f, 0.5f), makeSize(0.6f, 0.6f), makeSize(0.6f, 0.6f),
            makeSize(0.9f, 0.9f), makeSize(1.8f, 1.8f), makeSize(1.2f, 1.2f),
            makeSize(1.2f, 1.2f), makeSize(1.2f, 1.2f), makeSize(1.2f, 1.2f),
            makeSize(2.0f, 2.0f), makeSize(0.9f, 0.9f), makeSize(0.9f, 0.9f),
            makeSize(1.2f, 1.2f), makeSize(1.3f, 1.3f), makeSize(2.3f, 2.3f),
            makeSize(0.7f, 0.7f), makeSize(1.1f, 1.1f), makeSize(1.0f, 1.0f),
            makeSize(1.0f, 1.0f), makeSize(1.9f, 1.9f)
    };
    private static final float MAP_RADIUS = 0.6f;
    private static final float MAP_LEFT = 3.8f - MAP_RADIUS * 2;
    private static final float MAP_TOP = 2.0f - MAP_RADIUS * 2;
    private static final float MAP_RIGHT = MAP_LEFT + (2*MAP_RADIUS*8);
    private static final float MAP_BOTTOM = MAP_TOP + (2*MAP_RADIUS*5);
    protected static Gauge gauge = new Gauge(0.1f, R.color.enemy_gauge_fg, R.color.enemy_gauge_bg);

    private Enemy(int level, int index){
        super(resId[level], 10.0f);
        init(level, index);
    }

    private void init(int level, int index){
        this.level = level;
        this.life = this.maxLife = (level + 1) * 30;
        this.dx = 0;
        dy = SPEED;
        setAnimationResource(resId[level], 10.0f, frameCount[level]);
        setPosition(MAP_LEFT, MAP_TOP, monsterSize[level].x, monsterSize[level].y);
    }

    public static Enemy get(int level, int index){
        Enemy enemy = (Enemy) RecycleBin.get(Enemy.class);
        if(enemy != null){
            enemy.init(level, index);
            return enemy;
        }
        return new Enemy(level, index);
    }

    public RectF getRect(){
        return dstRect;
    }

    private static PointF makeSize(float w, float h){
        return new PointF(w, h);
    }

    @Override
    public void update(float elapsedSeconds) {
        if (dy > 0 && this.y > MAP_BOTTOM ){
            dy = 0;
            dx = SPEED;
        }
        else if(dx > 0 && this.x > MAP_RIGHT){
            dy = -SPEED;
            dx = 0;
        }
        else if(dy < 0 && this.y < MAP_TOP){
            dy = 0;
            dx = -SPEED;
        }
        else if(dx < 0 && this.x < MAP_LEFT){
            dy = SPEED;
            dx = 0;
        }
        super.update(elapsedSeconds);
        if(this.life <= 0){
            InGameScene scene = (InGameScene) Scene.top();
            if(scene == null) return;
            scene.remove(InGameScene.Layer.enemy, this);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.save();
        float width = dstRect.width() * 0.1f;
        canvas.translate(x - width / 2, dstRect.bottom);
        canvas.scale(width, width);
        gauge.draw(canvas, (float)life / maxLife);
        canvas.restore();
    }

//    @Override
//    public RectF getCollisionRect() {
//        return null;
//    }

    @Override
    public void onRecycle() {

    }

    public boolean decreaseLife(int power){
        life -= power;
        return life <= 0;
    }
}
