package game;

import city.cs.engine.*;

public class DoorSensor implements SensorListener {
    private GameLevel level;
    private Game game;


    public DoorSensor(GameLevel level, Game game) {
        super();
        this.level = level;
        this.game = game;
    }


    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody().equals(level.getStudent())) {
            if (level.isDoorOpen()) {
                // If the door is open and the player touches it, go to the next level
                System.out.println("here");
                game.goToNextLevel();
            }
        }
    }




    @Override
    public void endContact(SensorEvent sensorEvent) {

    }

}

