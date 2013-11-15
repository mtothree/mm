import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Door extends Actor
{
    int animationNumber = 0;
    
    /**
     * Door.class is the door that is opened up by the lever. When we hit the lever, we open the door. The door also changes images using the basic animation
     * changeState method.
     */
    
    public void act() 
    {
        changeState();
    }    
    public void changeState()
    {
        if(canSee(Player.class) && animationNumber == 0)
        {
            setImage("DoorOpen.png");
            animationNumber++;
        }
    }
    public boolean canSee(Class clss)
    {
        Actor actor = getOneIntersectingObject(clss);
        return actor != null;       
    }
}
