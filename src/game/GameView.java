package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Student student;
    GameLevel currentLevel;
    private Image background;


    public GameView(GameLevel currentLevel, int width, int height, Student student){

        super(currentLevel,width,height);
        this.currentLevel = currentLevel;
        this.student = student;
        System.out.println(student.getHealth());
    }

    @Override
    protected void paintBackground(Graphics2D g){
        background = currentLevel.getBackgroundFile();
        int width  = this.getWidth();
        int height = this.getHeight();
        g.drawImage(background,0,0,width,height,this);

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        int studentHealth = student.getHealth();
        GameLevel level = (GameLevel) student.getWorld();

        g.drawImage(new ImageIcon("data/health" + studentHealth + ".png").getImage(), 5, 5, this);

        g.setColor(Color.WHITE);

// Draw a filled rectangle with a specified position, width, and height
        int rectX = 590;
        int rectY = 10;
        int rectWidth = 100;
        int rectHeight = 20;
        g.fillRect(rectX, rectY, rectWidth, rectHeight);

// Set the color for the text
        g.setColor(Color.BLACK);


// Draw the text on top of the white background
        g.drawString("Score: " + Game.getScore(), 600, 25);
    }

    public void onLevelChange(GameLevel newLevel) {
        this.currentLevel = newLevel;
        repaint();
    }
    public void updateScoreDisplay(int score) {
        score= score;
        repaint();
    }






}
