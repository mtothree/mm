import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayAgain extends Buttons
{
    
    /**
     * This is the PlayAgain class. It is a piece of text onscreen that is written up using the GreenfootImage function. When the screen is clicked,
     * we go back to level one. This uses the GreenfootImage method, one of the extensions.
     */
    
    public void act() 
    {
        checkMouse();
    }    
    public void checkMouse()
    {
        if(Greenfoot.mouseClicked(this))
        {
         Intro n = new Intro();
         Greenfoot.setWorld(n);
        }
    }
    public PlayAgain()
    {
        GreenfootImage img = new GreenfootImage (650, 600);
        img.drawString("Click anywhere to restart", 300, 350);
        setImage(img);
    }
}
