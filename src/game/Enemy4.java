package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy4 extends Walker implements StepListener{

    private float left, right;
    private final int range = 3;
    private final int walkingSpeed = 4;

    public Enemy4(GameLevel world, Vec2 position) {
        super(world,new PolygonShape(-0.5f,0.972f, -0.5f,-0.98f, 0.508f,-0.996f, 0.5f,0.98f));
        setPosition(position);
        BodyImage image = new BodyImage("data/frames/ice_zombie_anim_f0.png", 2.0f);
        addImage(image);
        startWalking(walkingSpeed);
        world.addStepListener(this);
    }

    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-range;
        right = position.x+range;

    }
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right) {
            startWalking(-walkingSpeed);
        } if (getPosition().x < left) {
            startWalking(walkingSpeed);
        }
    }
    @Override
    public void postStep(StepEvent stepEvent){

    }

}



