package com.example.flappybird;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/*
          * Клас ігрових ниток має намір створити ігровий цикл.
          * Цей клас спілкується з класом Game through
          * методи оновлення () та drawCanvas ().
          * */

public class GameThread extends Thread{

    private int FPS = 30;
    private SurfaceHolder surfaceHolder;
    private Game game;
    private boolean running;
    public static Canvas canvas;

    public GameThread(SurfaceHolder holder, Game game) {
        super();
        this.surfaceHolder = holder;
        this.game = game;
        surfaceHolder.setKeepScreenOn(true);
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        long targetTime = 1000/FPS;

        while(running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    if (!game.getInitComponents()) {

                        game.initComponents();

                    }

                    this.game.update();
                    this.game.drawCanvas(canvas);


                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;

            try {
                this.sleep(waitTime);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void setRunning(boolean isRunning) {

        this.running = isRunning;

    }

}
