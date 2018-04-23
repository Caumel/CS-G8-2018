package prueba.app.raulmartin.com.sprint2;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;




public class PongMotor extends SurfaceView implements Runnable{

    //Este es el hilo del juego
    private Thread gameThread = null;


    // Cuando usamos el Canvas para pintar en un hilo necesitamos un SurfaceHolder
    private SurfaceHolder ourHolder;


    //Bool que nos dice si se esta jungando actualmente o no
    private volatile boolean playing;

    // Si el juego esta pausado = true
    private boolean paused = true;

    // Objeto canvas y las herramientas para pintar
    private Canvas canvas;
    private Paint paint;
    private Paint pincel;

    // Como de grande es la pantalla
    private int screenX;
    private int screenY;

    //Con esto controlamos los fps del juego (lleva la velocidad del movimiento)
    private long fps;


    //Lo utilizamos para calcular los fps
    private long timeThisFrame;

    //El bate...el arma... el aniquilador
    Bat bat;

    // La pelota
    private Ball ball;

    //Numero máximo de balas, y el objeto bala
    private int maxBalas;


    private Bala bullet;

    //Estado del juego, para imprimir cuando has perdido
    String estado="";


    // Constructor al que se llama cuando se abre la aplicación
    public PongMotor(Context context, int x, int y) {
        //Llamamos al constructor por defecto
        super(context);
        // Inicializamos el holder y las herramientas de dibujo
        ourHolder = getHolder();
        paint = new Paint();
        pincel = new Paint();
        pincel.setColor(Color.argb(255,  255, 255, 255));
        // Inicializamos screenY y screenX porque x e y son locales
        screenX = x;
        screenY = y;

        // Iincializamos el bate
        bat = new Bat(x,y);

        //Inicializamos la pelota
        ball = new Ball(screenX, screenY);

        //Fijamos el maximo de balas a 5
        maxBalas = 5;

        //Inicializamos la bala
        bullet = new Bala(screenY);


        //Llamamos a restart que nos pondra los parametros de inicio del juego
        restart();
    }

    // Entramos cuando se llama al PAUSE de la clase PongActivity
    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }
    }

    // Entramos cuando se llama al metodo RESUME de la clase PongActivity
    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {


        while (playing) {

            // Captura el tiempo actual en milisegundos
            long startFrameTime = System.currentTimeMillis();


            // Actualiza la pantalla
            if(!paused){
                update();

            }
            //Dibuja el canvas
            draw();

            // Calcula los fps
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if (timeThisFrame >= 1) {
                fps = 5000 / timeThisFrame;
            }

        }
    }

    private void update(){



        //Estado inicial de lost = Fasle, antes de empezar no hemos perdido
        boolean lost = false;

        estado = "";

        // Actualizamos los elementos de la pantalla
        ball.update(fps);
        bat.update(fps);

        //Si hemos disparado una bala la acualizamos en la pantalla
        if(bullet.getStatus()){
            bullet.update(fps);
        }

        //Si una bala choca con la pelota, hemos ganado
        if(RectF.intersects(bullet.getRect(),ball.getRect())){
            //Restablecemos los parametros del juego
            maxBalas = 5;
            paused = true;
            bullet.setInactive();
            //Paramos la aplicacion tras 2 seg
            try{
                Thread.sleep(2000);
                System.exit(1);
            }
            catch(InterruptedException e ) { System.out.println(); }

        }


        //Si la bala se pierde por la parte de arriba de la pantalla se queda inactiva.
        if(bullet.getImpactPointY() < 0){
            bullet.setInactive();

            //Si nos quedamos sin balas hemos perdido; restablecemos los parametros.
            if(maxBalas <= 0 ){
                paused = true;
                estado = "Has perdido";
                maxBalas = 5;
                restart();
            }
        }

        if(lost){
            restart();
        }


    }

    void restart(){
        // Put the ball back to the start
        ball.reset(screenX/2, 30);
        ball = new Ball(screenX, screenY);




    }

    private void draw(){
        // Make sure our drawing surface is valid or game will crash
        if (ourHolder.getSurface().isValid()) {
            // Lock the canvas ready to draw
            canvas = ourHolder.lockCanvas();

            // Draw the background color
            canvas.drawColor(Color.argb(255,  26, 128, 182));

            // Draw everything to the screen

            // Choose the brush color for drawing
            pincel.setColor(Color.argb(255,  0, 0, 0));

            // Draw the ball
            canvas.drawRect(ball.getRect(), pincel);



            paint.setColor(Color.argb(255,  255, 255, 255));


            canvas.drawRect(bat.getRect(),paint);

            if(bullet.getStatus())
            {
                canvas.drawRect(bullet.getRect(),paint);
            }
            paint.setTextSize(80);
            canvas.drawText("Balas: " + maxBalas, 20,90, paint);
            paint.setTextSize(120);
            canvas.drawText(estado, 250, (screenY-120),paint);
            // Show everything we have drawn
            ourHolder.unlockCanvasAndPost(canvas);



        }
    }

    // The SurfaceView class implements onTouchListener
    // So we can override this method and detect screen touches.
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        // Our code here
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

            // Player has touched the screen
            case MotionEvent.ACTION_DOWN:

                paused = false;
                if(!((motionEvent.getX()>bat.getX())&& (motionEvent.getX()<bat.getX()+bat.length) && motionEvent.getY()>bat.getY()&&(motionEvent.getY()< bat.getY()+bat.height))) {
                    bat.setX(motionEvent.getRawX()-bat.length/2);
                    bat.setY(motionEvent.getRawY()-bat.height);
                    bat.update(fps);
                }
                if(!bullet.getStatus()){
                    if((motionEvent.getX()>bat.getX())&& (motionEvent.getX()<bat.getX()+bat.length) && motionEvent.getY()>bat.getY()&&(motionEvent.getY()< bat.getY()+bat.height)) {
                        bullet.shoot(bat.getX() + bat.length / 2, bat.getY() + bat.height / 2, bullet.UP);
                        maxBalas = maxBalas - 1;
                    }
                }

                break;



            // Player has removed finger from screen
            case MotionEvent.ACTION_UP:
                bat.setMovementState(bat.STOPPED);
                break;
        }

        return true;
    }


    public boolean isPaused() {
        return paused;
    }

    public Ball getBall() {
        return ball;
    }

    public Bala getBullet() {
        return bullet;
    }

    public String getEstado() {
        return estado;
    }
}





