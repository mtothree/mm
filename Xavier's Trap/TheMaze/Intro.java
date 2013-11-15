import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * The Intro world constructs the world to make it look nice.
 * 
 * By Matthew Millett
 */
public class Intro extends World
{
    /**
     * Just some arrays passing through...
     */
    public int coinX[] = {45, 90, 135, 180, 225, 270, 315, 360};
    public int coinY[] = {560, 560, 560, 560, 560, 560, 560, 560};
    public int platformBottomX[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformBottomY[] = {599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599};
    public int platformTopX[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformTopY[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int wallLeftX[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int wallLeftY[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int wallRightX[] = {599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599};
    public int wallRightY[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    
    /**
     * Integers
     */
    public int amountOfCoins = 0;
    public int amountOfBottomPlatforms = 0;
    public int amountOfTopPlatforms = 0;
    public int amountOfLeftWalls = 0;
    public int amountOfRightWalls = 0;
    public int stringCounter = 0;
    
    public Intro()
    {    
        super(600, 600, 1); 
        
        /**
         * This next few parts follow the same type of formatting as the other worlds, and so to save time and space, I have decided to explain everything
         * in this Intro class.
         * 
         * We have an object named coins in our world. Now, we want 8 coins in the world. So while we don't have 8 coins, we want to keep adding them.
         * But where? We need to find coordinated to place them down. Individually specifying the coordinates over and over again would be very 
         * time consuming, as I learned from my past game (I wrote 300 lines of addObject, all of the same object but with a different set of coords.)
         * so we use an array. So we have two arrays: one for the X coord, and one for the Y coord. We then want to input the values for the x and y 
         * coords above in the array declaration and then reference them below.
         * 
         * int x = coinX[amountOfCoins];
         * 
         * This sets the x coord as the x value in the array declaration. If amountOfCoins is 2, then:
         * 
         * x = 90;
         * y = 560;
         * 
         * The rest of the objects follow the same type of structure to them.
         */
        while(amountOfCoins <= 7)
        {
            int x = coinX[amountOfCoins];
            int y = coinY[amountOfCoins];
            
            Coin coin = new Coin();
            addObject(coin, x, y);
            
            amountOfCoins++;
        }
        while(amountOfBottomPlatforms <= 14)
        {
            int x = platformBottomX[amountOfBottomPlatforms];
            int y = platformBottomY[amountOfBottomPlatforms];
            Platform platform = new Platform();
            addObject(platform, x, y);
            
            amountOfBottomPlatforms++;
        }
        while(amountOfTopPlatforms <= 14)
        {
            int x = platformTopX[amountOfTopPlatforms];
            int y = platformTopY[amountOfTopPlatforms];
            Platform platform = new Platform();
            addObject(platform, x, y);
            
            amountOfTopPlatforms++;
        }
        while(amountOfLeftWalls <= 14)
        {
            int x = wallLeftX[amountOfLeftWalls];
            int y = wallLeftY[amountOfLeftWalls];
            Wall wall = new Wall();
            addObject(wall, x, y);
            
            amountOfLeftWalls++;
        }
        while(amountOfRightWalls <= 14)
        {
            int x = wallRightX[amountOfRightWalls];
            int y = wallRightY[amountOfRightWalls];
            Wall wall = new Wall();
            addObject(wall, x, y);
            
            amountOfRightWalls++;
        }
        
        Lever lever = new Lever();
        addObject(lever, 400, 570);
        
        Player player = new Player();
        addObject(player, 45, 550);
        
        Door door = new Door();
        addObject(door, 500, 561);
        
        Portal portal = new Portal();
        addObject(portal, 570, 550);
        
        GreenfootImage bg = getBackground();
        bg.setColor(Color.WHITE);
        bg.drawString("Welcome to Xavier's Trap!", 25, 100);
        bg.drawString("Aim:", 25, 140);
        bg.drawString(" - Collect all 8 coins", 25, 160);
        bg.drawString(" - Press the lever to open the door", 25, 180);
        bg.drawString(" - Go through the portal!", 25, 200);
        bg.drawString("Good Luck and Have Fun!", 25, 240);
        bg.drawString("Hint - If you are having issues with a level, press 1 to turn off wall collision", 25, 280);
        
    }
}