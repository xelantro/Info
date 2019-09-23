import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

//import java.awt.Color;

/**
 * @author Alex 
 */
public class Player extends Entity
{
    public int welt;  

    private static final int moveSpeed   = 2;
    private static final int fallSpeed   = 4;
    private static final int jumpStrengh = 4;  
    private static final int walkAnimationSpeed = 20;  
    private static final double gravity = 0.1;
    public static final double maxHealth   = 200;
    
    private static double health;
    private static boolean move = true;
    
    private int animationCount = 0;
    private int facing = 1;
    private int kickStrengh = 100; 
    private double actualKick = kickStrengh;
    private double startTime;
    private double timeElapsed;
    private double levelTime;
    private double remeaningTime;
    private double actualJumpSpeed = jumpStrengh; 
    private boolean onJump;
    private boolean onMove;
    private boolean kickAway;
    private boolean onGround = false;
    private boolean fallAnimations = true;
    private boolean timeSparwned = false;
    private boolean healthSparwned = false;

    private Enemy currentEnemy;
    private SimpleTimer time = new SimpleTimer();
    private Counter counter = new Counter("Time: "," sec"); //sufix selbst programmiert
    private NexProgressBar timeBar = new NexProgressBar(3, new Color(255,255,0),null);
    private NexProgressBar healthBar = new NexProgressBar(0, new Color(230,10,10),
            new Color(150,0,0));
    private GamePlay game = new GamePlay();

    private ArrayList<Class> stop;

    public Player(int level,int levelTime)
    {
        welt = level;
        this.levelTime = levelTime;
        health = maxHealth;
        move = true;
        //scale(1.5);
        stop = new ArrayList<Class>();
        stop.add(EnemyShoot.class);
        stop.add(EnemyWalk.class);

    }

    public void act() 
    {
        // if(ready)
        end();
        timeActions();
        if(move == true)
        {
            health();
            moveOwn();
            jump();
        }
        fall();
        updateOnGround();
        animationen();
    }  

    private void jump()
    {
        if(Greenfoot.isKeyDown("Space")||onJump)
        {
            if(!onJump)
            {
                onJump=true;
                fallAnimations = false;
            }
            while(onGround)
            {
                this.setLocation(this.getX(), this.getY()-10 );
                updateOnGround();
            }
            this.setLocation(this.getX(), (int)(this.getY()-actualJumpSpeed) );
            actualJumpSpeed-=gravity;
            updateOnGround();
        }
    }

    private void end()
    {
        Actor finish = this.getOneIntersectingObject(Finish.class);
        if(finish != null)
        {
            if(this.getX() == finish.getX())    
            { 
                move = false;
                onJump = false;
                if(this.getdy() == 0)
                {
                    this.setImage("Spieler4_"+facing+".png");
                    Greenfoot.delay(100);
                    this.setImage("SpielerTransparent.png");
                    Greenfoot.delay(50);
                    
                    game.nextLevel();             
                }
            }
        }
    }

    private void moveOwn()
    {   
        kickAway = false;
        List<Enemy> list = this.getIntersectingObjects(Enemy.class);
        for(Enemy e : list)
        {
            if(stop.contains(e.getClass()))
            {
                kickAway = true;

                //kick
                int oldY = this.getY();
                this.setImage("Spieler1_"+facing+".png");
                time.mark();
                for(int i = 0; i < kickStrengh; i++)
                {
                    if(time.millisElapsed()>=1)
                    {
                        time.mark();
                        if(e.getX() > this.getX())
                        {
                            this.setLocation(this.getX()+1, this.getY());
                        }
                        else if(e.getX() > this.getX())
                        {
                            this.setLocation(this.getX()-1, this.getY());
                        }
                    }
                }
                /*
                for(int i = oldY; this.getY() >=oldY; i++)
                {
                this.setLocation(this.getX()+1, (int)(2*Math.pow(i, 2)) ); 
                }
                 */

                break;
            }
        }

        if(!kickAway)
        {
            if(Greenfoot.isKeyDown("left")&&move)
            {
                this.setLocation(this.getX()-moveSpeed, this.getY());
                facing = 2;
                onMove = true;
            }
            else if(Greenfoot.isKeyDown("right")&&move)
            {
                this.setLocation(this.getX()+moveSpeed, this.getY());
                facing = 1;
                onMove = true;
            }
            else
            {
                onMove = false;
            }
        }
    }

    private void fall()
    {
        if(!onJump)
        {
            fallAnimations= true;
            this.setLocation(this.getX(), this.getY()+getdy());
        }
    }

    private void animationen()
    {
        if(fallAnimations &! onGround)
        {
            this.setImage("Spieler3_"+facing+".png");
        }
        else if(onJump)
        {
            if(Math.abs(actualJumpSpeed)-2 > jumpStrengh)
            {
                this.setImage("Spieler3_"+facing+".png");
            }
            else
            {
                this.setImage("Spieler2_"+facing+".png");
            }
        }
        else if(onGround)
        {
            if(onMove &! kickAway)
            {
                if(animationCount < walkAnimationSpeed)
                {
                    this.setImage("Spieler5_"+facing+".png");
                }
                else if(animationCount < walkAnimationSpeed*2)
                {
                    this.setImage("Spieler6_"+facing+".png");
                }
                else
                {
                    animationCount=-1;
                }
                animationCount++;
            }
            else
            {
                this.setImage("Spieler1_"+facing+".png");
            }

            actualJumpSpeed = jumpStrengh;
        }
        //scale(1.5);
    }

    private int getdy()
    {
        int dy = fallSpeed;
        List<Ground> list = this.getIntersectingObjects(Ground.class);
        for(int i = 0; i < list.size(); i++)
        {
            Ground g = list.get(i);
            if(g.getY() > this.getY())
            {
                dy = 0;
                break;
            }
        }
        List<Plattform> list2 = this.getIntersectingObjects(Plattform.class);
        for(int i = 0; i < list2.size(); i++)
        {
            Plattform p = list2.get(i);
            if(p.getY()-(this.getImage().getHeight()/2)-10 > this.getY() )// (/*this.getObjectsAtOffset(this.getImage().getWidth(), this.getImage().getHeight()-5, Plattform.class) != null &&*/
                      // this.getObjectsAtOffset(this.getImage().getWidth()/2, this.getImage().getHeight()-5, Plattform.class) != null) )
            { 
                    dy = 0;
                    break;
            }
        }
        return dy;
    }

    private void updateOnGround()
    {
        if(getdy() == 0)
        {
            onGround = true;
            onJump   = false;
        }
        else
        {
            onGround = false;
        }
    }

    private void scale(double wert)
    {
        this.getImage().scale((int)(this.getImage().getWidth()/wert) , (int)(this.getImage().getHeight()/wert));
    }

    private void timeActions()
    {
        if(timeSparwned == false)
        {
            this.getWorld().addObject(counter, 70, 29);
            this.getWorld().addObject(timeBar, 300, 29);
            timeSparwned = true;
            startTime = System.currentTimeMillis();
        }
        timeElapsed = (System.currentTimeMillis()-startTime)/1000;

        counter.setValue((int)timeElapsed);

        remeaningTime = levelTime-timeElapsed;
        timeBar.setPercentage((remeaningTime/levelTime)*100);
    }

    private void health()
    {
        if(healthSparwned == false)
        {
            this.getWorld().addObject(healthBar, 300, 59);
            healthSparwned = true;
        }

        healthBar.setPercentage((health/maxHealth)*100);
    }

    public static void damage(double damage)
    {
        health -= Math.min(maxHealth, damage);//(damage/maxHealth)*100);
    }
    
    public static void setLife(double percentage)
    {
        health = (percentage/100)*maxHealth;
    }

    public static void freeze(boolean freeze)
    {
        move = !freeze;
    }
}