import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GamePlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePlay extends GUI
{
    public static final int countOfLevels = 2;
    public static String currentWorld = "";
    private static String nextWorld = "";
    private static boolean initReady;
    private static boolean spawnExtra;
     
    private boolean guiReady = false;

    private World newWorld;
    private Console console = new Console();

    public GamePlay()
    {
        
    }

    public void act() 
    {
        initialisierung();
        setWorld();
    }

    private void initialisierung()
    {
        if(initReady != true)
        {
            currentWorld = "Menue";
            nextWorld = "";
            
            spawnExtra = false;
            // newWorld = new MenueWorld();
            
            initReady = true;
        
        }
        
    }

    private void setWorld()
    {
        if(!currentWorld.equals(nextWorld))
        {
            if(isWorld("Menue"))
            {
                newWorld = new MenueWorld();
                initReady = false;
            }
            else if(isWorld("Level1"))
            {
                newWorld = new Level1();
                initReady = true;
            }
            else if(isWorld("Level2"))
            {
                newWorld = new Level2();
                initReady = true;
            }
            else if(isWorld("WinWorld"))
            {
                newWorld = new WinWorld();
                initReady = false;
            }
            
            if(newWorld != null)
            {
                Greenfoot.setWorld(newWorld);
            }
            currentWorld = nextWorld;
        }
    }

    private boolean isWorld(String compare)
    {
        boolean isWorld = nextWorld.equals(compare);
        return isWorld;
    }

    public static void nextLevel()
    {
        for(int i = 1; i <= countOfLevels; i++)
        {
           if(i > countOfLevels)
           {
               nextWorld = "WinWorld";
           }
           else if(currentWorld.endsWith(""+i))
           {
               nextWorld = "Level"+(i+1);
               break;
           }
        }
    }
    
    public static void setWorld(String world)
    {
        nextWorld = world;
    }
    
    
}
