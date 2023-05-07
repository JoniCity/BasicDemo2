package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level4 extends GameLevel {
    public Level4(Game game) {
        super(game);
        createDoor(new Vec2(16, 9));

        // Add enemies to the level
        Enemy1 enemy1 = new Enemy1(this,new Vec2(8,8f));
        Enemy2 enemy2 = new Enemy2(this,new Vec2(8,-8));
        Enemy3 enemy3 = new Enemy3(this,new Vec2(-3,0));
        Enemy4 enemy4 = new Enemy4(this,new Vec2(-10,-8));

        GenericCollisionListener gcl = new GenericCollisionListener(this.getStudent());

        // Generate platforms
        createPlatform(this, new Vec2(-12, -4), 4, "data/frames/floor_1.png");
        createPlatform(this, new Vec2(8, -2), 2, "data/frames/floor_2.png");
        createPlatform(this, new Vec2(-4, 2), 3, "data/frames/floor_3.png");
        createPlatform(this, new Vec2(14, 6), 5, "data/frames/floor_4.png");
        createPlatform(this, new Vec2(-10, 10), 6, "data/frames/floor_5.png");
    }

    private void createPlatform(GameLevel world, Vec2 startPos, int length, String imagePath) {
        platformPreset(world, startPos, length, imagePath);
    }

    static void platformPreset(GameLevel world, Vec2 startPos, int length, String imagePath) {
        float tileWidth = 1.0f;
        float tileHeight = 1.0f;
        Shape tileShape = new BoxShape(tileWidth, tileHeight);

        for (int i = 0; i < length; i++) {
            Vec2 position = new Vec2(startPos.x + i * tileWidth * 2, startPos.y);
            StaticBody tile = new StaticBody(world, tileShape);
            tile.setPosition(position);
            tile.addImage(new BodyImage(imagePath, 2 * tileHeight));
        }
    }
    @Override
    public Image getBackgroundFile(){
        return new ImageIcon("data/bg4.png").getImage();
    }
}
