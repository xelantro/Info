import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class enemyWalk_new here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyWalk extends Enemy
{
    private static final int walkAnimationSpeed = 20;  

    private int animationCount = 0;
    private int facing; //1 = right
    private int damageValue;
    private boolean walk;
    private int walkDistance;
    private int startX;
    private int walkSpeed = 1;
    
    private Player player;

    public EnemyWalk(int damageValue, int walkDistance)
    {
        facing = 1;
        walk = true;
        this.walkDistance = walkDistance;
        this.damageValue = damageValue;
        startX = this.getX();
    }

    public void act() 
    {
        if(walk)
        {
            walk();
        }
        walkAnimation();
        turnAround();
    } 

    private void turnAround()
    {   
        if(this.getOneIntersectingObject(Player.class) == null)
        {
            walk = true;
            if(this.getX()>walkDistance+startX || this.getX()<startX)
            {
                this.getImage().mirrorHorizontally();
                walkSpeed = -walkSpeed;
            }
        }
        else
        {
            player = (Player)this.getOneIntersectingObject(Player.class);
            walk = false;
            player.damage(damageValue);
        }
    }

    private void walk()
    {
        this.move(1);
    }

    private void walkAnimation()
    {
        if(animationCount < walkAnimationSpeed || walk == false)
        {
            this.setImage("enemy3_"+facing+".png");
        }
        else if(animationCount < walkAnimationSpeed*2)
        {
            this.setImage("enemy4_"+facing+".png");
        }
        else if(animationCount < walkAnimationSpeed*3 && false)
        {
            this.setImage("enemy5_"+facing+".png");
        }
        else
        {
            animationCount=-1;
        }
        animationCount++;
    }
}
