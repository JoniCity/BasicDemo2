package game;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level3 extends GameLevel {
    public Level3(Game game) {
        super(game);
        createDoor(new Vec2(-12, -2));

        // Add enemies to the level
        Enemy1 enemy1 = new Enemy1(this,new Vec2(8,12f));
        Enemy4 enemy4 = new Enemy4(this,new Vec2(-10,-8));

        GenericCollisionListener gcl = new GenericCollisionListener(this.getStudent());

        // Generate platforms
        createPlatform(this, new Vec2(-14, -5), 3, "data/frames/floor_1.png");
        createPlatform(this, new Vec2(6, -1), 5, "data/frames/floor_2.png");
        createPlatform(this, new Vec2(0, 3), 2, "data/frames/floor_3.png");
        createPlatform(this, new Vec2(-10, 7), 4, "data/frames/floor_4.png");
        createPlatform(this, new Vec2(12, 11), 7, "data/frames/floor_5.png");
    }

    private void createPlatform(GameLevel world, Vec2 startPos, int length, String imagePath) {
        Level4.platformPreset(world, startPos, length, imagePath);
    }
    @Override
    public Image getBackgroundFile(){
        return new ImageIcon("data/bg3.png").getImage();
    }
}
