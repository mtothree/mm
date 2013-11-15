import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    
    /**
     * See Intro World for an explanation of world objects and arrays.
     */
    
    public int coinX[] = {574, 460, 420, 380, 340, 300, 260, 220};
    public int coinY[] = {507, 421, 371, 321, 261, 221, 161, 121};
    public int platformBottomX[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformBottomY[] = {599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599};
    public int platformTopX[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformTopY[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int wallLeftX[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int wallLeftY[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int wallRightX[] = {599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599};
    public int wallRightY[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformX[] = {340, 380, 420, 460, 574, 500, 460, 420, 380, 340, 300, 260, 220, 180, 25, 65, 105, 145};
    public int platformY[] = {500, 500, 500, 500, 546, 500, 450, 400, 350, 300, 250, 200, 150, 120, 470, 470, 470, 470};
    public int wallX[] = {315, 315, 315, 90};
    public int wallY[] = {515, 555, 595, 485};
    
    public int amountOfCoins = 0;
    public int amountOfBottomPlatforms = 0;
    public int amountOfTopPlatforms = 0;
    public int amountOfLeftWalls = 0;
    public int amountOfRightWalls = 0;
    public int amountOfPlatforms = 0;
    public int amountOfWalls = 0;
    
    public Level2()
    {    
        super(600, 600, 1); 
        
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
        while(amountOfPlatforms <= 17)
        {
            int x = platformX[amountOfPlatforms];
            int y = platformY[amountOfPlatforms];
            Platform platform = new Platform();
            addObject(platform, x, y);
            
            amountOfPlatforms++;
        }
        while(amountOfWalls <= 3)
        {
            int x = wallX[amountOfWalls];
            int y = wallY[amountOfWalls];
            Wall wall = new Wall();
            addObject(wall, x, y);
            
            amountOfWalls++;
        }
        
        Player player = new Player();
        addObject(player, 338, 550);
        
        Portal portal = new Portal();
        addObject(portal, 38, 545);
        
        Door door = new Door();
        addObject(door, 90, 553);
        
        Lever lever = new Lever();
        addObject(lever, 176, 95);
        
        GreenfootImage bg = getBackground();
        bg.setColor(Color.WHITE);
        bg.drawString("Was that level fustrating?", 25, 140);
        bg.drawString("Have fun with this one!", 25, 160);
    }
}
