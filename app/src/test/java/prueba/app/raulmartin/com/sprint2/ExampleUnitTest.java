package prueba.app.raulmartin.com.sprint2;



import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    Bat bat;
    @Test
    public void stopped_isCorrect() throws Exception {
        bat=new Bat(100,100);
        assertTrue(bat.getMovementState() == 0);
    }
    @Test
    public void up_isCorrect() throws Exception {
        bat=new Bat(100,100);
        bat.setX(630);
        assertTrue(bat.getX()==630);
    }
    @Test
    public void down_isCorrect() throws Exception {
        bat=new Bat(500,100);
        bat.setX(400);
        assertTrue(bat.getX()==400);
    }
    @Test
    public void right_isCorrect() throws Exception {
        bat=new Bat(100,100);
        bat.setY(400);
        assertTrue(bat.getY()==400);
    }
    @Test
    public void left_isCorrect() throws Exception {
        bat=new Bat(100,500);
        bat.setY(300);
        assertTrue(bat.getY()==300);
    }

}