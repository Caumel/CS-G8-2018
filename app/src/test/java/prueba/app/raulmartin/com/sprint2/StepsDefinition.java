package prueba.app.raulmartin.com.sprint2;


/**
 * Created by marcela on 22/4/18.
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class StepsDefinition {

        Bat bat;
        Ball ball;
        PongMotor pong;
        PongActivity activity;

         //Move Ball features
        @Given("^the ball$")
        public void haveTheBall() {
            ball = new Ball(0,0);
        }

        @When("^game start$")
        public void gameStarts() {
            pong = new PongMotor( new PongActivity(), 0,0 );
        }

        @Then("^I can move the ball up$")
        public void moveUp() {
            bat=new Bat(100,100);
            bat.setX(630);
            assertTrue(bat.getX()==630);
        }

        @Then("^I can move the ball down$")
        public void moveDown() {
            bat=new Bat(500,100);
            bat.setX(400);
            assertTrue(bat.getX()==400);

        }
        @Then("^the ball doesn't move by its own$")
        public void doNothing() {
            bat=new Bat(100,100);
            assertTrue(bat.getMovementState() == 0);

        }
        @Then("^I can't move the ball to the left$")
        public void moveLeft() {
            bat=new Bat(100,500);
            bat.setY(300);
            assertTrue(bat.getY()==300);
        }
        @Then("^I can't move the ball to the right$")
        public void moveRight() {
            bat=new Bat(100,100);
            bat.setY(400);
            assertTrue(bat.getY()==400);
        }

        //Smoke Move Ball features

        @Given("^the game$")
        public void newGame() {
            pong = new PongMotor( new PongActivity(),0,0 );
            pong.resume();
        }

        @When("^I quit the game$")
        public void moveBall() {
            pong.pause();

        }
        @Then("^The game stops")
        public void moveStick() {
            assert (pong.isPaused() == true);
        }

        @Then("^The ball is created$")
        public void ballCreated(){
            assert( pong.getBall() != null);
        }

        @Then("^The bullet is created$")
        public void bulletCreated(){
            assert( pong.getBullet() != null);
        }


















}