package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentController implements KeyListener {

    private Student student;

    public StudentController(Student student) {
        this.student = student;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            student.startWalking(-5);
        }  if (code == KeyEvent.VK_D) {
            student.startWalking(5);
        }  if (code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) {
            student.jump(12);
        }
        if (code==KeyEvent.VK_SHIFT){
            student.shoot(student.level);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A ) {
            student.stopWalking();
        } if (code == KeyEvent.VK_D) {
            student.stopWalking();
        }
    }
    public void updateStudent (Student newStudent) {
        student = newStudent;
    }

}
