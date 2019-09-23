import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;

/**
 * @author Alex 
 */
public class Level2 extends World
{
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        createLevel();
        this.addObject(new Player(2,30), 400, 300);
        this.addObject(new Finish(), 750, 509);
        this.addObject(new GamePlay(), 0, 0);  
        this.addObject(new Console(), 0, 0);  
        this.setPaintOrder(Ground.class,Player.class,Finish.class);
        Greenfoot.setSpeed(50);
    }

    private void createLevel()
    {
        try{
            int x = 0;
            int y = 0;
            BufferedReader reader = new BufferedReader(new FileReader(new File("levels/level2.txt")));
            String zeile = null;
            while((zeile = reader.readLine()) != null)
            {
                for(int i = 0; i < zeile.length(); i++)
                {
                    String zeichen = zeile.substring(0, 1);
                    zeile = zeile.substring(1);
                    if(zeichen.equals("G"))
                    {
                        this.addObject(new Ground("iron"), x*50, y*50);
                    }
                    x++;
                }
                x=0;
                y++;
            }
        }
        catch(Exception e) {}
    }
    
    public int level()
    {
        return 2;
    }
}
