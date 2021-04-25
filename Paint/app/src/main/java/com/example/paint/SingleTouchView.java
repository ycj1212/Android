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
    // 펜의 다중 사용을 위함
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

    // 선분, 도형의 다중 사용을 위함
    class ShapeInfo {
        private Paint paint;
        private float sx, sy, ex, ey;
        private int mode;

        public ShapeInfo(float width, int color, int mode, Paint.Style style) {
            this.mode = mode;
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(width);
            paint.setColor(color);
            paint.setStyle(style);
        }

        public Paint getPaint() {
            return paint;
        }
        public void setSxy(float sx, float sy) {
            this.sx = sx;
            this.sy = sy;
        }
        public void setExy(float ex, float ey) {
            this.ex = ex;
            this.ey = ey;
        }
        public int getMode() {
            return mode;
        }
    }

    private ArrayList<PathInfo> pathInfo;
    private ArrayList<ShapeInfo> shapeInfo;
    private Bitmap canvasBitmap;
    private Canvas drawCanvas;
    private Paint canvasPaint;
    private float width;
    private int backgroundColor, paintColor;
    private int mode;   // 0: pen, 1: eraser, 2: line, 3: circle, 4: rectangle

    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private boolean isMultiTouch = false;

    public SingleTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        pathInfo = new ArrayList();
        shapeInfo = new ArrayList();
        width = 10;
        backgroundColor = Color.WHITE;
        paintColor = Color.BLACK;
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    public void setPenMode(int mode) {
        this.mode = mode;
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
        shapeInfo.clear();
        setBackgroundColor(backgroundColor);

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        drawCanvas.drawColor(backgroundColor);
        canvasPaint.setColor(paintColor);

        // 선분, 도형 그리기
        for (ShapeInfo s : shapeInfo) {
            if (s.getMode() == 2) {
                drawCanvas.drawLine(s.sx, s.sy, s.ex, s.ey, s.paint);
                canvas.drawLine(s.sx, s.sy, s.ex, s.ey, s.paint);
            } else if (s.getMode() == 3) {
                drawCanvas.drawCircle(s.sx, s.sy, (float) Math.sqrt(Math.pow((s.ey - s.sy), 2) + Math.pow((s.ex - s.sx), 2)), s.paint);
                canvas.drawCircle(s.sx, s.sy, (float) Math.sqrt(Math.pow((s.ey - s.sy), 2) + Math.pow((s.ex - s.sx), 2)), s.paint);
            } else {
                drawCanvas.drawRect(s.sx, s.sy, s.ex, s.ey, s.paint);
                canvas.drawRect(s.sx, s.sy, s.ex, s.ey, s.paint);
            }
        }

        // 펜 그리기
        for (PathInfo p : pathInfo) {
            drawCanvas.drawPath(p.getPath(), p.getPaint());
            canvas.drawPath(p.getPath(), p.getPaint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        // 확대 및 축소 시
        if (event.getPointerCount() > 1) {
            isMultiTouch = true;
            return mScaleGestureDetector.onTouchEvent(event);
        }

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int color = paintColor;
                if (mode == 1) {
                    color = backgroundColor;
                }

                if (mode <= 1) {
                    pathInfo.add(new PathInfo(width, color));
                    pathInfo.get(pathInfo.size() - 1).getPath().moveTo(x, y);
                } else {
                    Paint.Style style;
                    if (mode == 2) {
                        style = Paint.Style.STROKE;
                    } else {
                        style = Paint.Style.FILL;
                    }
                    shapeInfo.add(new ShapeInfo(width, color, mode, style));
                    shapeInfo.get(shapeInfo.size() - 1).setSxy(x, y);
                }

                return true;
            case MotionEvent.ACTION_UP:
                isMultiTouch = false;

                break;
            case MotionEvent.ACTION_MOVE:
                if (!isMultiTouch) {
                    if (mode <= 1) {
                        pathInfo.get(pathInfo.size() - 1).getPath().lineTo(x, y);
                    } else {
                        shapeInfo.get(shapeInfo.size() - 1).setExy(x, y);
                    }
                }

                break;
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
            mScaleFactor *= scaleGestureDetector.getScaleFactor();

            // 최대 10배, 최소 10배 줌 한계 설정
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));

            // 뷰 스케일에 적용
            setScaleX(mScaleFactor);
            setScaleY(mScaleFactor);

            return true;
        }
    }
}
