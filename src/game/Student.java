package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Student extends Walker {

    private boolean facingLeft = false;
    private int health = 6;
    GameLevel level;
    Game game;

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    SoundClip shootSound;

    public Student(GameLevel world, Game game){
        super(world, new PolygonShape(0.25f,0.81f, -0.86f,-0.78f, -0.74f,-1.94f, 0.59f,-1.94f, 1.12f,0.46f));
        this.level=world;
        this.game = game;
        setPosition(new Vec2(-10,10));
        System.out.println(getPosition());
        Shape studentShape = new BoxShape(1,2);
        BodyImage image = (new BodyImage("data/student.png",4f));
        addImage(image);

    }
    public void shoot(GameLevel level){
        try {
            shootSound = new SoundClip("data/audio/shoot.wav");
            shootSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
         float x = getLinearVelocity().x;
         float y = getLinearVelocity().y;

        if (x > 0) {
            facingLeft = false;
        } else {
            facingLeft = true;
        }
        Vec2 sPosLeft = this.getPosition().sub(new Vec2(1.5f,0));
        Vec2 sPosRight = this.getPosition().sub(new Vec2(-1.5f,0));
        DynamicBody shooting = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        BodyImage bulletRight = new BodyImage("data/bullet.png", 1f);
        BodyImage bulletLeft = new BodyImage("data/bulletLeft.png",1f);
        ShootingImpact impact = new ShootingImpact(game, level);
        shooting.addCollisionListener(impact);
        shooting.setGravityScale(0);
        if (facingLeft){
            AttachedImage bulletImage = new AttachedImage(shooting, bulletLeft,1,0,new Vec2());
            shooting.setPosition(sPosLeft);
            shooting.setLinearVelocity(new Vec2(-20,0));
        }
        else {shooting.setPosition(sPosRight);
            AttachedImage bulletImage = new AttachedImage(shooting, bulletRight,1,0,new Vec2());
            shooting.setLinearVelocity(new Vec2(20,0));
        }

    }



    }

