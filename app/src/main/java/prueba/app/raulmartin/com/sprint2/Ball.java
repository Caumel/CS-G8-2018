
package prueba.app.raulmartin.com.sprint2;

import android.graphics.RectF;
import android.content.Context;
import android.view.SurfaceView;


import java.util.Random;

public class Ball  implements Cloneable{

    private RectF rect;
    private float xVelocity;
    private float yVelocity;
    private float batWidth = 35;
    private float batHeight = 35;

    private float x,y,g,p;

    Ball(float X, float Y){

        xVelocity = -750;
        yVelocity = 1000;

        rect = new RectF(375 , 30 , 375+batWidth, 30+batHeight);

        x=X;
        y=Y;
    }
    public float getX(){
        g = this.getRect().top;
        return g;
    }
    public float getY(){
        p= this.getRect().bottom;
        return p;
    }


    RectF getRect(){
        return rect;
    }

    void update(long fps){
        rect.left = rect.left + (xVelocity / fps);
        rect.top = rect.top + (yVelocity / fps);
        rect.right = rect.left + batWidth;
        rect.bottom = rect.top - batHeight;


        if(this.getRect().bottom > y){

            rect.left = this.getRect().left  ;
            rect.top = 1;
            rect.right = this.getRect().left + batWidth ;
            rect.bottom = this.getRect().top + batHeight;
        }



        if(this.getRect().top < 1) {

            rect.left = this.getRect().left ;
            rect.top = y - batHeight;
            rect.right = this.getRect().left + batWidth ;
            rect.bottom = y;
        }

        if(this.getRect().left < 1){

            rect.left = x - batWidth  ;
            rect.top = this.getRect().bottom;
            rect.right = x ;
            rect.bottom = this.getRect().top + batHeight;
        }

        // If the ball hits right wall bounce
        if(this.getRect().right > x ){
            //System.out.print("Me salgo por la derecha");
            //this.reset(1,(int)this.getRect().bottom);
            rect.left = 0  ;
            rect.top = this.getRect().bottom;
            rect.right = 0 + batWidth ;
            rect.bottom = this.getRect().bottom + batHeight;
        }
    }

    void reverseYVelocity(){
        yVelocity = -yVelocity;
    }

    void reverseXVelocity(){
        xVelocity = - xVelocity;
    }

    void setRandomXVelocity(){
        Random generator = new Random();
        int answer = generator.nextInt(2);

        if(answer == 0){
            reverseXVelocity();
        }
    }


    void reset(int x, int y){
        rect.left = x  ;
        rect.top = y;
        rect.right = x + batWidth ;
        rect.bottom = y + batHeight;
    }



}

