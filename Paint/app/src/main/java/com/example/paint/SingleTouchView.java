package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
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
    private float width;
    private int backgroundColor, paintColor;
    private int mode;   // 0: pen, 1: eraser

    public SingleTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        pathInfo = new ArrayList();
        width = 10;
        backgroundColor = Color.WHITE;
        paintColor = Color.BLACK;
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

    public void erase() {
        pathInfo.clear();

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (PathInfo p : pathInfo) {
            canvas.drawPath(p.getPath(), p.getPaint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int color;
                if (mode == 0) {
                    color = paintColor;
                } else {
                    color = backgroundColor;
                }

                pathInfo.add(new PathInfo(width, color));
                pathInfo.get(pathInfo.size()-1).getPath().moveTo(x, y);
                return true;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                pathInfo.get(pathInfo.size()-1).getPath().lineTo(x, y);
                break;
            default:
                return false;
        }

        invalidate();

        return true;
    }
}
