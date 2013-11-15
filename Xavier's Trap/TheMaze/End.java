import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class End extends World
{

    /**
     * This is the finish screen. All it does is displays some text and a button that takes you back to level 1.
     */
    
    public End()
    {    
        super(600, 600, 1); 
        
        PlayAgain button = new PlayAgain();
        addObject(button, 250, 500);
        
        GreenfootImage bg = getBackground();
        bg.setColor(Color.WHITE);
        bg.drawString("Congrats on Winning!", 250, 200);
        bg.drawString("I hope you had fun!", 250, 240);
        bg.drawString("You collected a total of 24 coins!", 250, 280);
        bg.drawString("Matt Millett, Year 10 IST, 2013", 400, 570);
    }
}
