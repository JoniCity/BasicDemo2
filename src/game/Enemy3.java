package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy3 extends Walker implements StepListener{

    private float left, right;
    private final int range = 2;
    private final int walkingSpeed = 3;

    public Enemy3(GameLevel world, Vec2 position) {
        super(world,new PolygonShape(-0.512f,-0.968f, -0.496f,0.244f, 0.728f,0.988f, 0.748f,0.016f, 0.62f,-0.992f));
        setPosition(position);
        BodyImage image = new BodyImage("data/frames/imp_idle_anim_f0.png", 2.0f);
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
