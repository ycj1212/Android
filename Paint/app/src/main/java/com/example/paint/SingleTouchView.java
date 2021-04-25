package com.example.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import java.util.ArrayList;

public class SingleTouchView extends View {
    class PathInfo {
        private Paint paint;
        private Path path;

        public PathInfo(float width, int color) {
            paint = new Paint();
            path = new Path();

            paint.setAntiAlias(true);
            paint.setStrokeWidth(width);
            paint.setColor(color);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
        }

        public Path getPath() {
            return path;
        }

        public Paint getPaint() {
            return paint;
        }
    }

    private ArrayList<PathInfo> pathInfo;
    private Bitmap canvasBitmap;
    private Canvas drawCanvas;
    private Paint canvasPaint;
    private float width;
    private int backgroundColor, paintColor;
    private int mode;   // 0: pen, 1: eraser

    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private boolean isMultiTouch = false;

    public SingleTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        pathInfo = new ArrayList();
        width = 10;
        backgroundColor = Color.WHITE;
        paintColor = Color.BLACK;
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    public void setPenMode() {
        mode = 0;
    }

    public void setEraserMode() {
        mode = 1;
    }

    public void setPathWidth(float width) {
        this.width = width;
    }

    public void setBackColor(int color) {
        backgroundColor = color;
        setBackgroundColor(color);
    }

    public void setPaintColor(int color) {
        paintColor = color;
    }

    public Bitmap getBitmap() {
        return canvasBitmap;
    }

    public void erase() {
        pathInfo.clear();
        setBackgroundColor(backgroundColor);

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        drawCanvas.drawColor(backgroundColor);
        for (PathInfo p : pathInfo) {
            drawCanvas.drawPath(p.getPath(), p.getPaint());
            canvas.drawPath(p.getPath(), p.getPaint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if (event.getPointerCount() > 1) {
            isMultiTouch = true;
            return mScaleGestureDetector.onTouchEvent(event);
        }

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int color;
                if (mode == 0) {
                    color = paintColor;
                } else {
                    color = backgroundColor;
                }

                pathInfo.add(new PathInfo(width, color));
                pathInfo.get(pathInfo.size() - 1).getPath().moveTo(x, y);

                return true;
            case MotionEvent.ACTION_UP:
                isMultiTouch = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isMultiTouch) {
                    pathInfo.get(pathInfo.size() - 1).getPath().lineTo(x, y);
                    break;
                }
            default:
                return false;
        }

        invalidate();

        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            // ScaleGestureDetector에서 factor를 받아 변수로 선언한 factor에 넣고
            mScaleFactor *= scaleGestureDetector.getScaleFactor();

            // 최대 10배, 최소 10배 줌 한계 설정
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));

            // 이미지뷰 스케일에 적용
            setScaleX(mScaleFactor);
            setScaleY(mScaleFactor);

            return true;
        }
    }
}
