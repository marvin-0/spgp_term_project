package com.naver.scope93.MapleRandomDefense.game.main;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.interfaces.IRecyclable;
import com.naver.scope93.framework.objects.SheetSprite;
import com.naver.scope93.framework.scene.RecycleBin;
import com.naver.scope93.framework.scene.Scene;
import com.naver.scope93.framework.view.Metrics;
import com.naver.scope93.spgp_term_project.R;

import java.util.ArrayList;

public class PlayerUnit extends SheetSprite implements IRecyclable {
    public enum State {
        idle, attack
    }

    private static final String TAG = PlayerUnit.class.getSimpleName();
    private int level;
    private int atk;
    private int index;
    private float atkSpeed;
    private float range;
    private static final float UNIT_WIDTH = 1.3f;
    private static final float UNIT_HEIGHT = 1.2f;
    private float m_x, m_y;
    private int tileIndex = -1;
    protected State state = State.idle;
    protected static Rect[][] srcRectsArray = {
            makeRects(0, 1, 2),
            makeRects(100, 101, 102)
    };
    private static ArrayList<IGameObject> tiles;

    private static final int[] resId = {
            R.mipmap.normal_sheet, R.mipmap.rare_sheet, R.mipmap.ancient_sheet,
            R.mipmap.epic_sheet, R.mipmap.legend_sheet, R.mipmap.mystic_sheet
    };
    protected static Rect[] makeRects(int... indices) {
        Rect[] rects = new Rect[indices.length];
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            int l = 0 + (idx % 100) * 100;
            int t = 0 + (idx / 100) * 80;
            rects[i] = new Rect(l, t, l + 100, t + 80);
        }
        return rects;
    }

    private PlayerUnit(int level, int index, InGameScene scene) {
        //super(resId[level], 10.0f);
        super(resId[level], 8);
        if(tiles == null) {
            tiles = scene.objectsAt(InGameScene.Layer.map);
        }
        init(level, index);
    }

    private void init(int level, int index){
        this.level = level;
        this.atk = (level + 1) * 30;
        this.atkSpeed = 3.5f - (level * 0.4f);
        this.range = 0.6f * (level+3);
        this.tileIndex = index;
        //srcRects = srcRectsArray[state.ordinal()];
        setState(State.idle);
        mapTile tile = (mapTile)tiles.get(index);
        tileIndex = index;
        tile.unitPlace = true;
        m_x = tile.getRect().centerX();
        m_y = tile.getRect().centerY();
        setPosition(m_x, m_y, UNIT_WIDTH, UNIT_HEIGHT);
    }

    public static PlayerUnit get(int level, int index, InGameScene scene){
        PlayerUnit playerUnit = (PlayerUnit) RecycleBin.get(PlayerUnit.class);
        if(playerUnit != null){
            playerUnit.init(level, index);
            return playerUnit;
        }
        return new PlayerUnit(level, index, scene);
    }

    public void update(float elapsedSeconds){
        attack(elapsedSeconds);
    }
    private void attack(float elapsedSeconds){
        InGameScene scene = (InGameScene) Scene.top();
        if(scene == null) return;
        atkSpeed -= elapsedSeconds;


        ArrayList<IGameObject> enemies = scene.objectsAt(InGameScene.Layer.enemy);
        for(int e = 0; e < enemies.size(); e++){
            Enemy enemy = (Enemy)enemies.get(e);
            if(distanceEnemy(enemy)){
                setState(State.attack);
                if(atkSpeed > 0) return;
                enemy.decreaseLife(atk);
                atkSpeed = 3.5f - (level * 0.4f);
                return;
            }
        }
        setState(State.idle);
    }

    private boolean distanceEnemy(Enemy enemy){
        float distance = (float)(Math.pow(enemy.getRect().centerX() - x, 2) + Math.pow(enemy.getRect().centerY() - y, 2));
        return (distance < range*range);
    }

    private void setState(State state){
        this.state = state;
        srcRects = srcRectsArray[state.ordinal()];
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private boolean selectOn = false;

    public boolean onTouch(MotionEvent event, InGameScene scene){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float[] pts = Metrics.fromScreen(event.getX(), event.getY());
                if(dstRect.contains(pts[0], pts[1])){
                    //Log.d(TAG, "터치됨 "+this.index);
                    selectOn = true;
                    if(tileIndex != -1) {
                        mapTile tile = (mapTile) tiles.get(tileIndex);
                        tile.unitPlace = false;
                        Log.d(TAG, "실행됨" + tileIndex);
                    }
                    setPosition(pts[0], pts[1], 1.5f, 1.4f);
                    return true;
                }
                else{
                    //Log.d(TAG, "마우스 x, " + pts[0] + "캐릭터 x : " + dstRect.centerX() + "인덱스 : " + this.index);
                    return false;
                }
            case MotionEvent.ACTION_MOVE:
                pts = Metrics.fromScreen(event.getX(), event.getY());
                if(selectOn){
                    setPosition(pts[0], pts[1], 1.5f, 1.4f);

                    for(int t = tiles.size() - 1; t >= 0; t--){
                        mapTile tile = (mapTile)tiles.get(t);
                        if(tile.getRect().contains(x, y) && !tile.unitPlace){
                            m_x = tile.getRect().centerX();
                            m_y = tile.getRect().centerY();
                            tileIndex = t;
                            break;
                        }
                    }
                    //Log.d(TAG, "마우스 x, " + pts[0] + "캐릭터 x : " + dstRect.centerX());

                }
                return true;
            case MotionEvent.ACTION_UP:
                if(selectOn) {
                    mapTile tile = (mapTile)tiles.get(tileIndex);
                    tile.unitPlace = true;
                    setPosition(m_x, m_y, UNIT_WIDTH, UNIT_HEIGHT);
                }
                selectOn = false;
                return true;
        }
        return false;
    }

    @Override
    public void onRecycle() {

    }
}
