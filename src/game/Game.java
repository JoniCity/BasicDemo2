package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.World;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

/**
 * Your main game entry point
 */
public class Game {
    GameLevel currentLevel;
    GameView view;
    // In the Game class
    SoundClip lvl1Music, lvl2Music, lvl3Music, lvl4Music;
    StudentController controller;
    GenericCollisionListener collisions;
    private static int score = 0;




    /** Initialise a new Game. */
    public Game() {
        currentLevel = new Level1(this);

        //1. make an empty game world
        view = new GameView(currentLevel, 800, 500, currentLevel.getStudent());

        // Create the actual game level

        // Update the view with the actual game level and student


        // Update the view with the actual game level and student
        view.setWorld(currentLevel);

        controller = new StudentController(currentLevel.getStudent());
        collisions = new GenericCollisionListener(currentLevel.getStudent());
        view.addKeyListener(controller);

        GiveFocus gf = new GiveFocus(view);
        view.addMouseListener(gf);



        //3. create a Java window (frame) and add the game
        //   view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
         JFrame debugView = new DebugViewer(currentLevel, 800, 500);

        try {
            lvl1Music = new SoundClip("data/audio/lvl1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            lvl2Music = new SoundClip("data/audio/lvl2.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            lvl3Music = new SoundClip("data/audio/lvl3.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            lvl4Music = new SoundClip("data/audio/lvl4.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // start our game world simulation!
        currentLevel.start();
        playMusic();

    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
    public void playMusic() {
        if (currentLevel instanceof Level1) {
            lvl1Music.loop();
        } else if (currentLevel instanceof Level2) {
            lvl2Music.loop();
        } else if (currentLevel instanceof Level3) {
            lvl3Music.loop();
        } else if (currentLevel instanceof Level4) {
            lvl4Music.loop();
        }
    }

    public void goToNextLevel() {
        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            lvl1Music.stop();
            Student prevStudent = currentLevel.getStudent();
            currentLevel = new Level2(this);
            Student newStudent = currentLevel.getStudent();
            newStudent.addCollisionListener(collisions);
            controller.updateStudent(currentLevel.getStudent());
            view.setWorld(currentLevel);
            view.onLevelChange(currentLevel);
            currentLevel.resetScore();
            currentLevel.start();
        } else if (currentLevel instanceof Level2) {
            currentLevel.stop();
            lvl2Music.stop();
            Student prevStudent = currentLevel.getStudent();
            currentLevel = new Level3(this);
            Student newStudent = currentLevel.getStudent();
            newStudent.addCollisionListener(collisions);
            controller.updateStudent(currentLevel.getStudent());
            view.setWorld(currentLevel);
            view.onLevelChange(currentLevel);
            currentLevel.resetScore();
            currentLevel.start();
        } else if (currentLevel instanceof Level3) {
            currentLevel.stop();
            lvl3Music.stop();
            Student prevStudent = currentLevel.getStudent();
            currentLevel = new Level4(this);
            Student newStudent = currentLevel.getStudent();
            newStudent.addCollisionListener(collisions);
            controller.updateStudent(currentLevel.getStudent());
            view.setWorld(currentLevel);
            view.onLevelChange(currentLevel);
            currentLevel.resetScore();
            currentLevel.start();
        }
        playMusic();
    }
    // In the Game class
    public void incrementScore() {
        score += 100;
        view.updateScoreDisplay(score);
    }

    public static int getScore() {
        return score;
    }
    public int setScore() {
        return score;
    }

}
