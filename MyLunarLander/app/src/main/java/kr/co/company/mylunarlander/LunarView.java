/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kr.co.company.mylunarlander;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * View that draws, takes keystrokes, etc. for a simple LunarLander game.
 * 
 * Has a mode which RUNNING, PAUSED, etc. Has a x, y, dx, dy, ... capturing the
 * current ship physics. All x/y etc. are measured with (0,0) at the lower left.
 * updatePhysics() advances the physics based on realtime. draw() renders the
 * ship, and does an invalidate() to prompt another draw() as soon as possible
 * by the system.
 */
class LunarView extends SurfaceView implements SurfaceHolder.Callback {
    public Handler mHandler;

	class LunarThread extends Thread {
        /** The drawable to use as the background of the animation canvas */
        private Bitmap mBackgroundImage;
        /**
         * Current height of the surface/canvas.
         * 
         * @see #setSurfaceSize
         */
        private int mCanvasHeight = 1;

        /**
         * Current width of the surface/canvas.
         * 
         * @see #setSurfaceSize
         */
        private int mCanvasWidth = 1;

        /** What to draw for the Lander in its normal state */
        private Drawable mLanderImage, mLandingZone;
        /** Indicate whether the surface has been created & is ready to draw */
        private boolean mRun = false;

        /** Handle to the surface manager object we interact with */
        private SurfaceHolder mSurfaceHolder;

        int x, y=0, tempX=0;
        int landingZoneX, landingZoneY;
        boolean drawing = true;

        public LunarThread(SurfaceHolder surfaceHolder, Context context,
                Handler handler) {
            // get handles to some important objects
            mSurfaceHolder = surfaceHolder;
            mHandler = handler;
            mContext = context;

            Resources res = context.getResources();
            // cache handles to our key sprites & other drawables
            mLanderImage = context.getResources().getDrawable(
                    R.drawable.lander_plain);
            mLandingZone = context.getResources().getDrawable(
                    R.drawable.landing_zone);

            // load background image as a Bitmap instead of a Drawable b/c
            // we don't need to transform it and it's faster to draw this way
            mBackgroundImage = BitmapFactory.decodeResource(res,
                    R.drawable.earthrise);
        }
        /* Callback invoked when the surface dimensions change. */
        public void setSurfaceSize(int width, int height) {
            // synchronized to make sure these all change atomically
            synchronized (mSurfaceHolder) {
                // don't forget to resize the background image
                mCanvasWidth = width;
                mCanvasHeight = height;
                mBackgroundImage = mBackgroundImage.createScaledBitmap(
                        mBackgroundImage, width, height, true);

                initSetting();
            }
        }

        public void initSetting() {
            synchronized (mSurfaceHolder) {
                x = (int) (Math.random() * (getWidth() - mLanderImage.getMinimumWidth()));
                y = 0;
                landingZoneX = (int) (Math.random() * (getWidth() - mLandingZone.getMinimumWidth()));
                landingZoneY = getHeight()-200;

                doStart();
            }
        }

        /**
         * Starts the game, setting parameters for the current difficulty.
         */
        public void doStart() {
            synchronized (mSurfaceHolder) {
                Message msg = mHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("visibility", View.INVISIBLE);
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                drawing = true;
            }
        }

        /**
         * Pauses the physics update & animation.
         */
        public void pause() {
            synchronized (mSurfaceHolder) {
                drawing = false;

                Message msg = mHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("visibility", View.VISIBLE);
                msg.setData(bundle);
                mHandler.sendMessage(msg);
            }
        }

        /**
         * Restores game state from the indicated Bundle. Typically called when
         * the Activity is being restored after having been previously
         * destroyed.
         * 
         * @param savedState Bundle containing the game state
         */
        public synchronized void restoreState(Bundle savedState) {
            synchronized (mSurfaceHolder) {
            }
        }

        @Override
        public void run() {
            while (mRun) {
                Canvas c = null;
                try {
                    c = mSurfaceHolder.lockCanvas(null);
                    if (drawing) {
                        synchronized (mSurfaceHolder) {
                            doDraw(c);
                        }
                    }
                } finally {
                    // do this in a finally so that if an exception is thrown
                    // during the above, we don't leave the Surface in an
                    // inconsistent state
                    if (c != null) {
                        mSurfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }

        /**
         * Dump game state to the provided Bundle. Typically called when the
         * Activity is being suspended.
         * 
         * @return Bundle with this view's state
         */
        public Bundle saveState(Bundle map) {
            synchronized (mSurfaceHolder) {
            }
            return map;
        }

        /**
         * Used to signal the thread whether it should be running or not.
         * Passing true allows the thread to run; passing false will shut it
         * down if it's already running. Calling start() after this was most
         * recently called with false will result in an immediate shutdown.
         * 
         * @param b true to run, false to shut down
         */
        public void setRunning(boolean b) {
            mRun = b;
        }

        /**
         * Resumes from a pause.
         */
        public void unpause() {
            // Move the real time clock up to now
            synchronized (mSurfaceHolder) {
                Message msg = mHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("visibility", View.INVISIBLE);
                msg.setData(bundle);
                mHandler.sendMessage(msg);
                drawing = true;
            }
        }

        /**
         * Draws the ship, fuel/speed bars, and background to the provided
         * Canvas.
         */
        private void doDraw(Canvas canvas) {
            canvas.drawBitmap(mBackgroundImage, 0, 0, null);
            drawLanderImage(canvas);
            drawLandingZone(canvas);
            if (x > mCanvasWidth) x = 0;
            if (y > landingZoneY - 80) {
                mLanderImage = mContext.getResources().getDrawable(R.drawable.app_lunar_lander);
                if (landingZoneX < x && x < landingZoneX+mLandingZone.getMinimumWidth()) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mContext, "Success", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    mLanderImage = mContext.getResources().getDrawable(R.drawable.lander_crashed);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mContext, "Failed", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                mLanderImage.draw(canvas);
                mLanderImage.invalidateSelf();
                setRunning(false);
            }
        }

        private void drawLanderImage(Canvas canvas) {
            if (isTouch) {
                mLanderImage = mContext.getResources().getDrawable(R.drawable.lander_firing);
                if (direction == 0) {
                    tempX = -1;
                } else {
                    tempX = 1;
                }
            } else {
                mLanderImage = mContext.getResources().getDrawable(R.drawable.lander_plain);
                tempX = 0;
            }
            x += tempX;
            mLanderImage.setBounds(x, y+=10, x + 100, y + 100);
            mLanderImage.draw(canvas);
        }

        private void drawLandingZone(Canvas canvas) {
            mLandingZone.setBounds(landingZoneX, landingZoneY,
                    landingZoneX+mLandingZone.getMinimumWidth(),
                    landingZoneY+mLandingZone.getMinimumHeight());
            mLandingZone.draw(canvas);
        }
    }

    /** Handle to the application context, used to e.g. fetch Drawables. */
    private Context mContext;

    private TextView textview;

    /** The thread that actually draws the animation */
    private LunarThread thread;

    public LunarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // register our interest in hearing about changes to our surface
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        // create thread only; it's started in surfaceCreated()
        thread = new LunarThread(holder, context, new Handler() {
            @Override
            public void handleMessage(Message m) {
                textview.setVisibility(m.getData().getInt("visibility"));
            }
        });

        setFocusable(true); // make sure we get key events
    }

    /**
     * Fetches the animation thread corresponding to this LunarView.
     * 
     * @return the animation thread
     */
    public LunarThread getThread() {
        return thread;
    }

    public void setTextView(TextView textview) {
        this.textview = textview;
    }

    /* Callback invoked when the surface dimensions change. */
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
        thread.setSurfaceSize(width, height);
    }

    /*
     * Callback invoked when the Surface has been created and is ready to be
     * used.
     */
    public void surfaceCreated(SurfaceHolder holder) {
        // start the thread here so that we don't busy-wait in run()
        // waiting for the surface to be created
        thread.setRunning(true);
        thread.start();
    }

    /*
     * Callback invoked when the Surface has been destroyed and must no longer
     * be touched. WARNING: after this method returns, the Surface/Canvas must
     * never be touched again!
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        // we have to tell thread to shut down & wait for it to finish, or else
        // it might touch the Surface after we return and explode
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    boolean isTouch = false;
    int direction = 0;  // 0: left, 1: right

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isTouch = true;
                if (!thread.drawing) {
                    thread.unpause();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getX() < getWidth()/2.0) {
                    direction = 0;
                } else {
                    direction = 1;
                }
                break;
            case MotionEvent.ACTION_UP:
                isTouch = false;
                break;
        }

        return true;
    }
}
