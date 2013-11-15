import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    
    /**
     * See Intro World for an explanation of world objects and arrays.
     */
    
    public int coinX[] = {140, 200, 260, 320, 380, 440, 460, 480};
    public int coinY[] = {491, 421, 351, 281, 211, 141, 141, 141};
    public int platformBottomX[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformBottomY[] = {599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599};
    public int platformTopX[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformTopY[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int wallLeftX[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int wallLeftY[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int wallRightX[] = {599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599, 599};
    public int wallRightY[] = {20, 60, 100, 140, 180, 220, 260, 300, 340, 380, 420, 460, 500, 540, 580};
    public int platformX[] = {140, 200, 260, 320, 380, 440, 480, 520, 525, 485, 445, 405, 365, 325};
    public int platformY[] = {530, 460, 390, 320, 250, 180, 180, 180, 495, 495, 495, 495, 495, 495};
    public int wallX[] = {540, 540, 540, 540, 540, 540, 540, 540, 301, 301, 301};
    public int wallY[] = {200, 240, 280, 320, 360, 400, 440, 480, 510, 550, 590};
    
    public int amountOfCoins = 0;
    public int amountOfBottomPlatforms = 0;
    public int amountOfTopPlatforms = 0;
    public int amountOfLeftWalls = 0;
    public int amountOfRightWalls = 0;
    public int amountOfPlatforms = 0;
    public int amountOfWalls = 0;
    
    public Level1()
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
        while(amountOfPlatforms <= 13)
        {
            int x = platformX[amountOfPlatforms];
            int y = platformY[amountOfPlatforms];
            Platform platform = new Platform();
            addObject(platform, x, y);
            
            amountOfPlatforms++;
        }
        while(amountOfWalls <= 10)
        {
            int x = wallX[amountOfWalls];
            int y = wallY[amountOfWalls];
            Wall wall = new Wall();
            addObject(wall, x, y);
            
            amountOfWalls++;
        }
        
        Player player = new Player();
        addObject(player, 45, 550);
        
        Lever lever = new Lever();
        addObject(lever, 560, 570);
        
        Door door = new Door();
        addObject(door, 460, 553);
        
        Portal portal = new Portal();
        addObject(portal, 338, 548);
        
        GreenfootImage bg = getBackground();
        bg.setColor(Color.WHITE);
        bg.drawString("It starts to get harder now!", 25, 100);
    }
}
