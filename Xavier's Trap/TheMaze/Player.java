import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The player is a actor that the use controls onscreen.
 * 
 * Matthew Millett
 */
public class Player extends Actor
{
    /**
     * Arrays that let us know what images we have for the animations.
     */
    String[] animationImageR = {"Player1R.png", "Player2R.png", "Player3R.png", "Player4R.png", "Player5R.png", "Player6R.png"};
    String[] animationImageL = {"Player1L.png", "Player2L.png", "Player3L.png", "Player4L.png", "Player5L.png", "Player6L.png"};
    
    /**
     * Booleans
     */
    Boolean wallCollision = true;
    Boolean isMoving = false;
    Boolean rightStance = true;
    Boolean canWalkThroughDoor = false;
    Boolean canFinish = false;
    Boolean staticOnPlatform = false;
    Boolean gravityOn = false;
    
    /**
     * Integers
     */
    int coinsEaten = 0;
    int animationNumberR = 0;
    int animationNumberL = 0;
    int x = 0;
    int y = 0;
    int levelCounter = 0;
    int gravity = 3;
    int animationTimer = 0;
    int jumpCounter = 0;
    
    /**
     *
     * Resources
     * http://sandbox.yoyogames.com/make/resources
     * Sound effects
     * 
     * http://spritedatabase.net/
     * Sprites for the player
     * 
     * http://minecraft.net/
     * Sprites for the lever and door
     * 
     * http://www.deviantart.com/morelikethis/91322970?view_mode=2
     * Sprites for the portal
     * 
     * All other sprites (such as the coins, wall, backgrounds, platforms, etc.) were made by me in Photoshop
     * 
     */
    
    /**
     * Act method. Everything in here gets executed.
     */
    
    public void act() 
    {
        x = getX();
        y = getY();
        
        gravity();
        cheats();
        checkForCoin();
        animation();
        setStance();
        checkButtons();
        checkForLever();
        checkForPortal();
        autoComplete();
    }    
    /**
     * Checks if we are pressing buttons.
     * 
     * If I learned anything about implementing gravity, it is:
     * 
     * Complex and confusing code is better than no code at all.
     */
    public void checkButtons()
    {
        int previousX = getX();
        int previousY = getY();
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(getOneIntersectingObject(Platform.class) != null)
            {
                setLocation(x, y-50);
            }
            else
            {
                setLocation(x, y+gravity);
            }
            isMoving = true;
            if(wallCollision == true && getOneIntersectingObject(Wall.class) != null)
            {
                setLocation(previousX, previousY);
            }
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(x-5, y);
            if(getOneIntersectingObject(Platform.class) == null)
            {
                setLocation(x-5, y+gravity);
            }
            if(Greenfoot.isKeyDown("up") && getOneIntersectingObject(Platform.class) != null)
            {
                setLocation(x-5, y-50);
            }
            isMoving = true;
            if(wallCollision == true && getOneIntersectingObject(Wall.class) != null)
            {
                setLocation(previousX, previousY);
            }
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(x+5, y);
            if(getOneIntersectingObject(Platform.class) == null)
            {
                setLocation(x+5, y+gravity);
            }
            if(Greenfoot.isKeyDown("up") && getOneIntersectingObject(Platform.class) != null)
            {
                setLocation(x+5, y-50);
            }
            isMoving = true;
            if(wallCollision == true && getOneIntersectingObject(Wall.class) != null)
            {
                setLocation(previousX, previousY);
            }
        }
        if(!Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("up"))
        {
            isMoving = false;
        }
    }
    /**
     * Checks how many coins we have. We need 8 to finish the level. It also plays music.
     */
    public void checkForCoin()
    {
        if(canSee(Coin.class))
        {
            eat(Coin.class);
            coinsEaten++;
            Greenfoot.playSound("Coin.wav");
            
            if(coinsEaten == 8)
            {
                canFinish = true;
                coinsEaten = 0;
            }
        }
    }
    /**
     * Animates the player. Every 5 times the code is executed, we animate the character. This is to slow down the animation speed.
     */
    public void animation()
    {
       if(animationTimer == 5)
       {
           animationTimer = 0;
           
           if(Greenfoot.isKeyDown("right"))
           {
                if(animationNumberR < 6)
                {
                    String currentImageR = animationImageR[animationNumberR];
                    setImage(currentImageR);
                    animationNumberR++;
                }
                else
                {
                    while(animationNumberR > 1)
                    {
                        animationNumberR--;
                        String currentImageR = animationImageR[animationNumberR];
                        setImage(currentImageR);
                        animationNumberR--;
                    }
                }
                rightStance = true;
           }
           if(Greenfoot.isKeyDown("left"))
           {
                if(animationNumberL < 6)
                {
                    String currentImageL = animationImageL[animationNumberL];
                    setImage(currentImageL);
                    animationNumberL++;
                }
                else
                {
                    while(animationNumberL >1)
                    {
                        animationNumberL--;
                        String currentImageL = animationImageL[animationNumberL];
                        setImage(currentImageL);
                        animationNumberL--;
                    }
                }
                rightStance = false;
           }
        }
        else
        {
            animationTimer++;
        }
    }
    /**
     * If we are standing still, we don't want the animation to be stuck on the last frame it was on. This fixes that.
     */
    public void setStance()
    {
        if(isMoving == false)
        {
            if(rightStance == true)
            {
                setImage("PlayerStaticR.png");
            }
            else
            {
                setImage("PlayerStaticL.png");
            }
        }
    }
    /**
     * Sets the gravity. If we cannot see platforms, then we start falling until we hit a platform.
     */
    public void gravity()
    {
        if(isMoving == false && getOneIntersectingObject(Platform.class) == null)
        {
            setLocation(x, y+gravity);
        }
    }
    /**
     * Checks to see if we have hit a lever. If we have, then we want to change the door image and we also want to say that we can walk through the
     * door.
     */
    public void checkForLever()
    {
        if(canSee(Lever.class))
        {
            canWalkThroughDoor = true;
        }
    }
    /**
     * Checks to see if we can walk through the portal. If we can, then we have a look at the next world that we will be on. Since the player is
     * freshly spawned in every single world, we have to check where the player spawned. By doing this, we then get a guideline on what world the
     * player is in.
     */
    public void checkForPortal()
    {
        if(canSee(Portal.class))
        {
            if(x >= 300 && x <= 400)
            {
                levelCounter = 1;
            }
            if(x >= 0 && x <= 100)
            {
                levelCounter = 2;
            }
            if(x >= 500 && x <= 600 && levelCounter == 2)
            {
                levelCounter = 3;
            }
        }
        if(canSee(Portal.class) && canFinish == true)
        {
            levelCounter++;
            Greenfoot.playSound("Win.wav");
            canWalkThroughDoor = false;
            canFinish = false;
            if(levelCounter == 1)
            {
                Level1 n = new Level1();
                Greenfoot.setWorld(n);
            }
            if(levelCounter == 2)
            {
                Level2 n = new Level2();
                Greenfoot.setWorld(n);
            }
            if(levelCounter == 3)
            {
                End n = new End();
                Greenfoot.setWorld(n);
            }
        }
    }
    /**
     * This is the autocomplete method. If we press the 1 key, wall collision turns off, and if we touch the portal, we then
     * finish.
     */
    public void autoComplete()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            canFinish = true;
            canWalkThroughDoor = true;
            wallCollision = false;
        }
    }
    /**
     * Stolen from the crabs scenario from the beginning of the year, but modified. canSee and eat are actually pretty good in terms of minimising the
     * amount of code written. 
     * 
     * canSee checks to see if we can see an object somewhere around the actor. If we can, we return the class.
     * 
     * eat then gets rid of the class from the world.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneIntersectingObject(clss);
        return actor != null;       
    }
    public void eat(Class clss)
    {
        Actor actor = getOneIntersectingObject(clss);
        if(actor != null) 
        {
            getWorld().removeObject(actor);
        }
    }
    public void cheats()
    {
        /**
         * Shhh! Don't let anyone see this! It disables wall collision!
         * 
         * The disabling wall collision is more of an inside joke/cheat that only people who look at the code will understand and be able to use.
         */
        if(Greenfoot.isKeyDown("8"))
        {
            wallCollision = false;
        }
    }
}
