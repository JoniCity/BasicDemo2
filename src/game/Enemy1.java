package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy1 extends Walker {
    private int health;

    public Enemy1(GameLevel world, Vec2 position) {
        super(world,new PolygonShape(-2.03f,1.15f, -2.01f,0.2f, 0.41f,-1.53f, 1.41f,-0.48f, 0.29f,1.44f));
        setPosition(position);
        BodyImage image = new BodyImage("data/enemy.gif", 4.0f);
        addImage(image);
    }


}
