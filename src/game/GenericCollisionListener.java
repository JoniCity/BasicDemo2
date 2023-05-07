package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import java.util.logging.Level;

public class GenericCollisionListener implements CollisionListener {

    Level1 level;
    public GenericCollisionListener(Level1 level){
        this.level = level;
    }
    private Student student;
    public GenericCollisionListener(Student student) {
        this.student = student;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Enemy1 || collisionEvent.getOtherBody() instanceof Enemy2 || collisionEvent.getOtherBody() instanceof Enemy3 || collisionEvent.getOtherBody() instanceof Enemy4) {
            student.setHealth(student.getHealth()-1);

            }

    }
    public void updateStudent (Student newStudent) {
        student = newStudent;
    }

}
