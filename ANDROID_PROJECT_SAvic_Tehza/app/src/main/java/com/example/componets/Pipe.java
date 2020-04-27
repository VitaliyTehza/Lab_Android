package com.example.componets;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.flappybird.R;

import java.util.concurrent.ThreadLocalRandom;

public class Pipe {

    private Bitmap pipeUp;
    private Bitmap pipeDown;

    private int opening;
    private int x;
    private int y = 1265;
    private int resetPos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Pipe(Resources res, int x, int screenWidth) {

        this.x = x;
        this.resetPos = screenWidth;
        this.opening = this.generateRandom(300, 500);
        this.pipeUp = BitmapFactory.decodeResource(res, R.drawable.pipe_up);

        int type = generateRandom(0, 5);

        if (type == 1) {

            this.pipeDown = BitmapFactory.decodeResource(res, R.drawable.pipe_down1);

        } else if (type == 2) {

            this.pipeDown = BitmapFactory.decodeResource(res, R.drawable.pipe_down2);

        } else if (type == 3){

            this.pipeDown = BitmapFactory.decodeResource(res, R.drawable.pipe_down3);

        } else {

            this.pipeDown = BitmapFactory.decodeResource(res, R.drawable.pipe_down4);

        }

        /* Наступні операції були потрібні, оскільки позиція труби посилається на растрову карту
          * верхній лівий кут.
          **/

        this.y -= this.pipeDown.getHeight();

    }

    public void draw(Canvas canvas) {

        canvas.drawBitmap(this.pipeDown, this.x, this.y, null);
        canvas.drawBitmap(this.pipeUp, this.x, this.y - this.opening - this.pipeUp.getHeight(), null);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void move() {

        if (this.x <= -280){

            this.x = this.resetPos;
            this.opening -= generateRandom(50, 100);

        }

        this.x -= 8;

    }

   /** Генератор випадкових труб в отворі з заданим інтервалом.
                  **/

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int generateRandom(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max);

    }

  /** Абсциса труби (верхній лівий кут)
      **/

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

   /** Повертає ординату нижньої труби (верхній лівий кут)
      **/

    public int getPipeDownY() {
        return this.y;
    }

    /* Повертає ординату верхньої труби (нижній лівий кут)
      */

    public int getPipeUpperY() {

        return this.y - this.opening;

    }

    public void setOpening() {
        this.opening = this.generateRandom(300, 500);
    }

}
