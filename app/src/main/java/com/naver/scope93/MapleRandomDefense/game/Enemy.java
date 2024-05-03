package com.naver.scope93.MapleRandomDefense.game;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.naver.scope93.framework.interfaces.IBoxCollidable;
import com.naver.scope93.framework.interfaces.IRecyclable;
import com.naver.scope93.framework.objects.AnimSprite;
import com.naver.scope93.framework.scene.RecycleBin;
import com.naver.scope93.spgp_term_project.R;

//implements IBoxCollidable, IRecyclable
public class Enemy extends AnimSprite implements IRecyclable{
    private static final float SPEED = 3.0f;
    private static final float RADIUS = 0.4f;
    private int level;
    private int life, maxLife;

    private static final float MAP_RADIUS = 0.7f;
    private static final float MAP_LEFT = 3.8f - MAP_RADIUS * 2;
    private static final float MAP_TOP = 2.0f - MAP_RADIUS * 2;
    private static final float MAP_RIGHT = MAP_LEFT + (2*MAP_RADIUS*8);
    private static final float MAP_BOTTOM = MAP_TOP + (2*MAP_RADIUS*5);


    public Enemy(int level, int index){
        super(R.mipmap.monster1_run, 10.0f);
        init(level, index);
        dy = SPEED;
    }

    private void init(int level, int index){
        this.level = level;
        this.life = this.maxLife = (level + 1) * 30;
        setAnimationResource(R.mipmap.monster1_run, 10.0f, 8);
        setPosition(MAP_LEFT, MAP_TOP, RADIUS);
    }

    public static Enemy get(int level, int index){
        Enemy enemy = (Enemy) RecycleBin.get(Enemy.class);
        if(enemy != null){
            enemy.init(level, index);
            return enemy;
        }
        return new Enemy(level, index);
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
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

//    @Override
//    public RectF getCollisionRect() {
//        return null;
//    }

    @Override
    public void onRecycle() {

    }
}
