import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyShoot_new here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShoot extends Enemy
{
    private long delay;
    private int facing;

    private SimpleTimer time = new SimpleTimer();

    public EnemyShoot(int delay, int facing)
    {
        this.delay = delay;
        this.facing = facing;
        time.mark();
    }

    public void act() 
    {
        shoot();
    }

    private void shoot()
    {
        if(time.millisElapsed() >= delay)
        {

            this.getWorld().addObject(new LaserStrahl(facing), this.getX(), getdeviation());   
            time.mark();
        }
    }

    private int getdeviation()
    {
        int value = this.getY();
        if(facing == 1)
        {
            value = this.getY()+(this.getImage().getWidth()/2)+1;
        }
        else if(facing == 2)
        {
            value = this.getY()-(this.getImage().getWidth()/2)-1;
        }
        return value;
    }
}
