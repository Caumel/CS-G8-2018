package prueba.app.raulmartin.com.sprint2;



import android.graphics.RectF;

import java.util.Random;


public class Bat {

    // RectF
    private RectF rect;

    //Tamaño
    public float length,height;

    // X, y
    private float x,y;

    private float anchoPantalla;
    private float altoPantalla;

    // Velocidad
    private float paddleSpeed;

    // Which ways can the paddle move
    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    final int TOP = 3;
    final int BOTTOM = 4;



    // Is the paddle moving and in which direction
    private int paddleMoving = STOPPED;

    // This the the constructor method
    // When we create an object from this class we will pass
    // in the screen width and height
    Bat(int screenX, int screenY){
        // 130 pixels wide and 20 pixels high


        length = 350;
        height = 45;

        // Start paddle in roughly the sceen centre
        x = screenX / 2;
        y = screenY / 2;
        // Y is the top coordinate
        //float y = screenY - 20;

        rect = new RectF(x, y, x + length, y + height);

        // How fast is the paddle in pixels per second
        paddleSpeed = 950;


        anchoPantalla = screenX;
        altoPantalla = screenY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }


    RectF getRect(){
        return rect;
    }


    void setMovementState(int state){
        paddleMoving = state;
    }


    void update(long fps){

        rect.left = x;
        rect.right = x + length;
        rect.top = y;
        rect.bottom = y + height;

        //Choca con la pared izquierda
        if(this.getRect().left < anchoPantalla*0+1){
            rect.left = anchoPantalla - (length + 2) ;
            rect.top = this.getRect().bottom;
            rect.right = length + this.getRect().left;
            rect.bottom = this.getRect().bottom + height;
        }

        // Choca con la pared derecha
        if(this.getRect().right > anchoPantalla){
            rect.left = 5;
            rect.top = this.getRect().bottom;
            rect.right = 5 + length ;
            rect.bottom = this.getRect().bottom + height;
        }
        //Choca con el top de la pantalla
        if(this.getRect().top < 1){
            rect.left = this.getRect().left ;
            rect.top = altoPantalla - height-6;
            rect.right = this.getRect().left + length ;
            rect.bottom = this.getRect().top + height;

        }
        //Choca con el bot de la pantalla
        if(this.getRect().bottom > altoPantalla - 5){
            rect.left = this.getRect().left  ;
            rect.top = 2;
            rect.right = this.getRect().left + length ;
            rect.bottom = this.getRect().top + height;

        }



    }

    public void sustituir (RectF x){
        this.rect = x;
    }


    public int getMovementState() {
        return this.paddleMoving;
    }
}
