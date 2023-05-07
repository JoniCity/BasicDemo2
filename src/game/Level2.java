package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel {
    public Level2(Game game) {
        super(game);
        createDoor(new Vec2(0, 9));

        // Add enemies to the level
        Enemy2 enemy2 = new Enemy2(this,new Vec2(8,-8));
        Enemy3 enemy3 = new Enemy3(this,new Vec2(-3,0));

        GenericCollisionListener gcl = new GenericCollisionListener(this.getStudent());

        // Generate platforms
        createPlatform(this, new Vec2(-14, -3), 1, 1, "data/frames/floor_1.png");
        createPlatform(this, new Vec2(-10, 0), 1, 1, "data/frames/floor_2.png");

        createPlatform(this, new Vec2(-4, 3), 1, 1, "data/frames/floor_3.png");
        createPlatform(this, new Vec2(0, 6), 1, 1, "data/frames/floor_4.png");
        createPlatform(this, new Vec2(-2, 6), 1, 1, "data/frames/floor_4.png");
        createPlatform(this, new Vec2(2, 6), 1, 1, "data/frames/floor_4.png");


        createPlatform(this, new Vec2(4, 3), 1, 1, "data/frames/floor_5.png");
        createPlatform(this, new Vec2(10, 0), 1, 1, "data/frames/floor_6.png");

        createPlatform(this, new Vec2(14, -3), 1, 1, "data/frames/floor_7.png");
        createPlatform(this, new Vec2(8, -6), 1, 1, "data/frames/floor_8.png");

        createPlatform(this, new Vec2(2, -9), 1, 1, "data/frames/floor_1.png");
        createPlatform(this, new Vec2(-4, -12), 1, 1, "data/frames/floor_2.png");

        createPlatform(this, new Vec2(-10, -15), 1, 1, "data/frames/floor_3.png");
    }

    private void createPlatform(GameLevel world, Vec2 position, float width, float height, String imagePath) {
        Shape platformShape = new BoxShape(width, height);
        StaticBody platform = new StaticBody(world, platformShape);
        platform.setPosition(position);
        BodyImage platformImage = new BodyImage(imagePath, 2 * height);
        platform.addImage(platformImage);
    }
    @Override
    public Image getBackgroundFile(){
        return new ImageIcon("data/bg2.jpeg").getImage();
    }
}
