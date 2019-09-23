import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
//
/**
 * @author Alex 
 */
public class Level1 extends World
{
    private GreenfootSound backgroundMusic;
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        createGame();
        createLevel();
        
        this.addObject(new GamePlay(), 0, 0);
        this.addObject(new Console(), 0, 0);  
        
        this.setPaintOrder(GUI.class,Plattform.class,Ground.class,Player.class,Enemy.class,Finish.class);  
        Greenfoot.setSpeed(50);
        backgroundMusic = new GreenfootSound("AlphaDance.mp3");
        backgroundMusic.playLoop();
    }
    
    private void createGame()
    {
        this.addObject(new Player(1,15), 400, 300);
        this.addObject(new Finish(), 750, 175);
        this.addObject(new EnemyShoot(2000,1), 75, 432);
        this.addObject(new EnemyWalk(50, 300), 75, 266);
        this.addObject(new Plattform(500,30,"holz.jpeg"), 250, 320);
        this.addObject(new Plattform(150,30,"holz.jpeg"), 75, 490);
        this.addObject(new Plattform(200,30,"holz.jpeg"), 700, 250);
        this.addObject(new Plattform(100,30,"holz.jpeg"), 640, 500);
        this.addObject(new Plattform(60,30,"holz.jpeg"), 555, 400);
    }
    
    private void createLevel()
    {
        try{
            int x = 0;
            int y = 0;
            BufferedReader reader = new BufferedReader(new FileReader(new File("levels/level1.txt")));
            String zeile = null;
            while((zeile = reader.readLine()) != null)
            {
                for(int i = 0; i < zeile.length(); i++)
                {
                    String zeichen = zeile.substring(0, 1);
                    zeile = zeile.substring(1);
                    if(zeichen.equals("G"))
                    {
                        this.addObject(new Ground("ground"), x*50, y*50);
                    }
                    x++;
                }
                x=0;
                y++;
            }
        }
        catch(Exception e) { }
    }
    
    public int level()
    {
        return 1;
    }
    
    public void act()
    {
        // if(!backgroundMusic.isPlaying())
        // {
            // backgroundMusic.play();
        // }
    }
}
