package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public abstract class GameLevel extends World{
    private Student student;
    private Enemy1 enemy1;
    SoundClip doorSound;
//    private int score;
    private int scoreToOpenDoor;
    private Game game;
    private GhostlyFixture door;
    private Sensor doorSensor;
    GameView view;

    private BodyImage closedDoorImage = new BodyImage("data/frames/doors_leaf_closed.png", 4);
    private BodyImage openDoorImage = new BodyImage("data/frames/doors_leaf_open.png", 4);

    public GameLevel(Game game){
        this.game = game;
    this.student = new Student (this, game);
    student.setPosition(new Vec2(-10,10));

    student.addCollisionListener(new GenericCollisionListener(this.getStudent()));
    DoorSensor doorSensor = new DoorSensor(this, this.game);
    Shape doorSensorShape = new BoxShape(2,2);



// add vertical platforms on the left and right sides
    Shape verticalPlatformShape = new BoxShape(0.5f, 20f);

    //make the ground
    Shape tileShape = new BoxShape(1f, 1f);
    BodyImage tileImage = new BodyImage("data/frames/floor_1.png");
    for (int i = 0; i < 20; i++) {
        StaticBody tileBody = new StaticBody(this, tileShape);
        tileBody.setPosition(new Vec2(-19f + (i*2) , -11.5f));
        AttachedImage attachedImage = new AttachedImage(tileBody, tileImage, 2, 0, new Vec2());
    }

//     left wall
    StaticBody leftPlatform = new StaticBody(this, verticalPlatformShape);
    leftPlatform.setPosition(new Vec2(-20f, 2.5f));
    leftPlatform.setName("leftPlatform");
    leftPlatform.setFillColor(new Color(0, 0, 0, 0)); // set fill color to transparent
    leftPlatform.setLineColor(new Color(0, 0, 0, 0)); // set line color to transparent


    // right wall
    StaticBody rightPlatform = new StaticBody(this, verticalPlatformShape);
    rightPlatform.setName("rightPlatform");
    rightPlatform.setPosition(new Vec2(20, -5));
    rightPlatform.setFillColor(new Color(0, 0, 0, 0)); // set fill color to transparent
    rightPlatform.setLineColor(new Color(0, 0, 0, 0)); // set line color to transparent


    scoreToOpenDoor = 200;


}
    public void openDoor() {
        door.getBody().removeAllImages();
        door.getBody().addImage(openDoorImage);
    }
public Student getStudent() {return student;}


    public void createDoor(Vec2 position) {
        StaticBody doorBody = new StaticBody(this);
        doorBody.setPosition(position);
        doorBody.addImage(closedDoorImage);
        door = new GhostlyFixture(doorBody, new BoxShape(2, 2));
        doorSensor = new Sensor(doorBody, new BoxShape(2, 2));
        doorSensor.addSensorListener(new DoorSensor(this, game));

    }


    public int getScoreToOpenDoor() {
        return scoreToOpenDoor;
    }

    public void setScoreToOpenDoor(int scoreToOpenDoor) {
        this.scoreToOpenDoor = scoreToOpenDoor;
    }

    public boolean isDoorOpen() {
        return game.getScore() >= scoreToOpenDoor;
    }


    public void updateDoorImage(int score) {
        int scoreThreshold;
        if (this instanceof Level1) {
            scoreThreshold = 200;
        } else if (this instanceof Level2) {
            scoreThreshold = 400;
        } else if (this instanceof Level3) {
            scoreThreshold = 600;
        } else { // Level4
            scoreThreshold = 1000;
        }

        if (score >= scoreThreshold) {
            door.getBody().removeAllImages();
            door.getBody().addImage(openDoorImage);
        }
    }

    public abstract Image getBackgroundFile();

    // Add a getter for the door
    public GhostlyFixture getDoor() {
        return door;
    }
//    public void incrementScore(int points) {

    public int resetScore() {
        return game.setScore();
    }



}