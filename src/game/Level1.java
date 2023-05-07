package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel {
    public Level1(Game game) {
        super(game);
        createDoor(new Vec2(3, 10));
        // Add enemies to the level
        Enemy1 enemy1 = new Enemy1(this,new Vec2(8,8f));
        Enemy2 enemy2 = new Enemy2(this,new Vec2(8,-8));


        GenericCollisionListener gcl = new GenericCollisionListener(this.getStudent());

        // Generate platforms
        createPlatform(this, new Vec2(-12, -6), 1, 1, "data/frames/floor_1.png");
        createPlatform(this, new Vec2(-10, -6), 1, 1, "data/frames/floor_2.png");

        createPlatform(this, new Vec2(-4, -1), 1, 1, "data/frames/floor_3.png");
        createPlatform(this, new Vec2(-2, -1), 1, 1, "data/frames/floor_4.png");
        createPlatform(this, new Vec2(0, -1), 1, 1, "data/frames/floor_5.png");

        createPlatform(this, new Vec2(4, 1), 1, 1, "data/frames/floor_6.png");
        createPlatform(this, new Vec2(6, 1), 1, 1, "data/frames/floor_7.png");
        createPlatform(this, new Vec2(8, 1), 1, 1, "data/frames/floor_8.png");

        createPlatform(this, new Vec2(-10, 5), 1, 1, "data/frames/floor_1.png");
        createPlatform(this, new Vec2(-8, 5), 1, 1, "data/frames/floor_2.png");

        createPlatform(this, new Vec2(2, 7), 1, 1, "data/frames/floor_3.png");
        createPlatform(this, new Vec2(4, 7), 1, 1, "data/frames/floor_4.png");

        //data/frames/doors_leaf_closed.png
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
        return new ImageIcon("data/bg1.png").getImage();
    }
}
