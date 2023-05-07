package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ShootingImpact implements CollisionListener {

    private GameLevel level;
    SoundClip dead, dead2;
    private  Game game;

    public ShootingImpact(Game game, GameLevel level) {
        this.game = game;
        this.level = level;
    }

    @Override
    public void collide(CollisionEvent e) {
        // get the two colliding objects
        DynamicBody bullet = null;

        if (e.getOtherBody() instanceof Enemy1 || e.getOtherBody() instanceof  Enemy3 ) {
            try {
                dead = new SoundClip("data/audio/dead.wav");
                dead.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                System.out.println(event);
            }
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
            game.incrementScore();
            level.updateDoorImage(Game.getScore()); // Update the door's image
        } else if (e.getOtherBody() instanceof Enemy2 ||  e.getOtherBody() instanceof  Enemy4) {
            try {
                dead2 = new SoundClip("data/audio/dead2.wav");
                dead2.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException event) {
                System.out.println(event);
            }
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
            game.incrementScore();
            level.updateDoorImage(Game.getScore()); // Update the door's image
        } else {
            e.getReportingBody().destroy();
        }
    }
}
