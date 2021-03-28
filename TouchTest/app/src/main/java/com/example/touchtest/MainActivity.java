package com.example.touchtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    protected class MyView extends View {
        float x = 100;
        float y = 100;

        String str;

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.WHITE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawCircle(x, y, 100, paint);
            paint.setTextSize(50);
            canvas.drawText("액션의 종류: " + str, 0, 100, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();

            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    str = "ACTION_DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    str = "ACTION_UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    str = "ACTION_MOVE";
                    break;
                case MotionEvent.ACTION_CANCEL:
                    str = "ACTION_CANCEL";
                    break;
                case MotionEvent.ACTION_OUTSIDE:
                    str = "ACTION_OUTSIDE";
                    break;
                default:
                    return super.onTouchEvent(event);
            }

            invalidate();
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mDetector.onTouchEvent(event)) {
            return true;
        }

        int action = event.getAction();

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                Log.d("ACTION_EVENT", "DOWN");
                return true;
            case MotionEvent.ACTION_UP:
                Log.d("ACTION_EVENT", "UP");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.d("ACTION_EVENT", "MOVE");
                return true;
            case MotionEvent.ACTION_CANCEL:
                Log.d("ACTION_EVENT", "CANCEL");
                return true;
            case MotionEvent.ACTION_OUTSIDE:
                Log.d("ACTION_EVENT", "OUTSIDE");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(DEBUG_TAG,"onDown: " + e.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d(DEBUG_TAG, "onShowPress: " + e.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + e.toString());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d(DEBUG_TAG, "onLongPress: " + e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + e1.toString() + e2.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + e.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + e.toString());
        return true;
    }
}