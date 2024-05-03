package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.naver.scope93.framework.interfaces.IBoxCollidable;
import com.naver.scope93.framework.interfaces.IRecyclable;
import com.naver.scope93.framework.objects.AnimSprite;
import com.naver.scope93.framework.scene.RecycleBin;
import com.naver.scope93.spgp_term_project.R;

//implements IBoxCollidable, IRecyclable
public class Enemy extends AnimSprite {
    private static final float SPEED = 3.0f;
    private static final float RADIUS = 0.7f;
    private int level;
    private int life, maxLife;


    public Enemy(int level, int index){
        super(R.mipmap.monster1_run, 10.0f);
        init(level, index);
    }

    private void init(int level, int index){
        this.level = level;
        this.life = this.maxLife = (level + 1) * 30;
        setAnimationResource(R.mipmap.monster1_run, 10.0f, 8);
        setPosition(2.4f, 0.6f, RADIUS);
    }

//    public static Enemy get(int level, int index){
//        Enemy enemy = (Enemy) RecycleBin.get(Enemy.class);
//        if(enemy != null){
//            enemy.init(level, index);
//            return enemy;
//        }
//        return new Enemy(level, index);
//    }

    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

//    @Override
//    public RectF getCollisionRect() {
//        return null;
//    }

//    @Override
//    public void onRecycle() {
//
//    }
}
