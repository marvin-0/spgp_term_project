package com.naver.scope93.framework.objects;

import android.graphics.Canvas;

import com.naver.scope93.framework.view.Metrics;


public class Background extends Sprite {
    public Background(int bitmapResId) {
        super(bitmapResId);
        setPosition(0, 0, Metrics.width, Metrics.height);
    }
    @Override
    public void update(float elapsedSeconds) {
        super.update(elapsedSeconds);
    }

    @Override
    public void draw(Canvas canvas) {
        dstRect.set(0, 0, Metrics.width, Metrics.height);
        canvas.drawBitmap(bitmap, null, dstRect, null);

    }
}
