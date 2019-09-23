import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Alex 
 */
public class MenueInterface extends GUI
{
    private String mouseStatus;
    private boolean initReady = false;
    private int width;
    private int height;
    private int middleX;
    private int middleY;
    
    private GreenfootImage mainImage;
    
    private MouseInfo mouse;
    private MenueWorld world;
    private Play play;
    // private GamePlay game;

    public MenueInterface()
    {
        mouseStatus = "";
    }

    public void act() 
    {
        initialisierung();
        buttonPress();
        buttonActions();
        // System.out.println(mouseStatus);
    }   
    
    private void buttonActions()
    {
        if(mouseStatus.equals("play"))
        {
            
        }
    }

    private void buttonPress()
    {
        mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(null))
        {
            if(mouse.getButton() == 1)
            {
                //leftClick
                if(mouse.getActor() == play)
                {
                    mouseStatus = "play";
                    Greenfoot.setWorld(new Level1());
                }
                else
                {
                      mouseStatus = "leftClick";
                }
            }
            else if(mouse.getButton() == 3)
            {
                 mouseStatus = "rightClick";
            }
            else if(mouse.getButton() == 2)
            {
                mouseStatus = "mouseClick";
            }
        }
    }

    private void initialisierung()
    {
        if(!initReady)
        {
            world = (MenueWorld)this.getWorld();

            width  = world.getWidth();
            height = world.getHeight();
            middleX = width/2;
            middleY = height/2;
            
            play = new Play();
            world.addObject(play, middleX, middleY);

            mainImage = new GreenfootImage(width,   height); 
            // game = new GamePlay();
            
            this.setImage(mainImage);

            initReady = true;
        }
    }
}
