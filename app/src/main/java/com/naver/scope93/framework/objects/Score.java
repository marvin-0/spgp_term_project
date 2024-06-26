package com.naver.scope93.framework.objects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import com.naver.scope93.framework.interfaces.IGameObject;
import com.naver.scope93.framework.res.BitmapPool;


public class Score implements IGameObject {
    private final Bitmap bitmap;
    private final float right, top, dstCharWidth, dstCharHeight;
    private final Rect srcRect = new Rect();
    private final RectF dstRect = new RectF();
    private final int srcCharWidth, srcCharHeight;
    private int score, displayScore;

    public Score(int mipmapId, float right, float top, float width) {
        this.bitmap = BitmapPool.get(mipmapId);
        this.right = right;
        this.top = top;
        this.dstCharWidth = width;
        this.srcCharWidth = bitmap.getWidth() / 10;
        this.srcCharHeight = bitmap.getHeight();
        this.dstCharHeight = dstCharWidth * srcCharHeight / srcCharWidth;
    }

    public void setScore(int score) {
        this.score = this.displayScore = score;
    }

    @Override
    public void update(float elapsedSeconds) {
        int diff = score - displayScore;
        if (diff == 0) return;
        if (-10 < diff && diff < 0) {
            displayScore--;
        } else if (0 < diff && diff < 10) {
            displayScore++;
        } else {
            displayScore += diff / 10;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        int value = this.displayScore;
        float x = right;
        while (value > 0) {
            int digit = value % 10;
            srcRect.set(digit * srcCharWidth, 0, (digit + 1) * srcCharWidth, srcCharHeight);
            x -= dstCharWidth;
            dstRect.set(x, top, x + dstCharWidth, top + dstCharHeight);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
            value /= 10;
        }
        if(score == 0){
            srcRect.set(0, 0, srcCharWidth, srcCharHeight);
            dstRect.set(right - dstCharWidth, top, right, top + dstCharHeight);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
        }
    }

    public void add(int amount) {
        score += amount;
    }

    public void sub(int amount) {score -= amount;}

    public int getScore() {
        return score;
    }
}
