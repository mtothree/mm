import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lever extends Actor
{
    int animationNumber = 0;
    
    /**
     * Lever is the object that has to be hit in order to open the door. If we hit it, the door is opened and the lever changes image. The lever also uses
     * the methods canSee from the Player.class.
     */
    
    public void act() 
    {
        checkForPlayer();
    }
    public void changeState()
    {
        if(animationNumber == 0)
        {
            setImage("LeverOn.png");
            animationNumber++;
        }
    }
    public void checkForPlayer()
    {
        if(canSee(Player.class))
        {
            changeState();
        }
    }
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
}
