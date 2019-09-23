import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Foreground
{
    public int moveSpeed = 3;
    public HashMap<String, GreenfootImage> imgs = new HashMap();
    private String cImg;
    private long lastGround;
    private long lastAni;
    private short cAni = 1;
    private boolean walkRight = true;
    //private boolean onJump = false;

    public Player()
    {
        imgs.clear();
        String[] displayName = {"normal", "jump", "duck", "greet", "walk1","walk2", "walk3", "walk4", "walk5", "dance", "fall"};
        for(int i=1; i<=11; i++)
        {
            GreenfootImage img = new GreenfootImage("images/Player/character"+i+".png");
            imgs.put(displayName[i-1], img);
            img = new GreenfootImage("images/Player/character"+i+".png");
            img.mirrorHorizontally();
            imgs.put(displayName[i-1]+"R", img);
        }
        /*//Set<Map.Entry<String, GreenfootImage>> set = imgs.entrySet();
        Set<Map.Entry<String, GreenfootImage>> copy = imgs.entrySet();
        //Map.Entry<String, GreenfootImage> r : copy
        for(Iterator<Map.Entry<String, GreenfootImage>> i = copy.iterator(); i.hasNext(); )
        {
        Map.Entry<String, GreenfootImage> r = i.next();
        GreenfootImage img = new GreenfootImage(r.getValue());
        img.mirrorHorizontally();
        imgs.put(r.getKey()+"R", img);
        }*/
        this.changeImg("normalR");
        //imgs.entrySet().forEach(e -> e.getKey());//forEach((s, i) -> System.out.println(s));
    }

    public void act()
    {
        this.walkUser();
        this.fallDown();
        this.jump();
    }    

    private void jump()
    {
        
    }
    
    private void walkUser()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            this.walk(moveSpeed);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            this.walk(-moveSpeed);
        }
        else
        {
            this.changeImg("normal");
        }
    }

    private void walk(int moveSpeed)
    {
        if(this.getIntersectingObjects(null).stream().filter(o -> !(o instanceof Solid)).map(o -> (Actor) o).filter(a -> a.getY()>this.getY()).collect(Collectors.toList()).isEmpty())//.filter(a -> )
        {
            this.scroll(moveSpeed);
            this.walkRight = moveSpeed>0;
            this.changeImg("walk");
        }
    }

    private void fallDown()
    {
        boolean fall = true;
        for(Actor a : this.getIntersectingObjects(Foreground.class))
        {
            if(a instanceof Solid)
            {
                fall = false;
            }
        }
        if(fall)
        {
            this.moveY(gravity);
            this.changeImg("fall");
        }
    }

    private void scroll(int lenght)
    {
        for(Scrolled a : (List<Scrolled>)this.getWorld().getObjects(Scrolled.class))
        {
            a.move(lenght);
        }
        for(Background b : (List<Background>)this.getWorld().getObjects(Background.class))
        {
            b.scroll(lenght);
        }
    }

    private void changeImg(String nImg)
    {
        if(nImg.equals("walk"))
        {
            nImg = "walk" + cAni;
            if(this.lastAni<System.currentTimeMillis()-100)
            {
                if(cAni >= 5) { cAni = 0;} //cAni += (cAni==5)?-4:1;
                cAni++;
                this.lastAni = System.currentTimeMillis();
            }
        }
        if(!nImg.equals(cImg))
        {
            cImg = nImg;
            nImg = nImg + (walkRight ? "R" : "");
            this.setImage(imgs.get(nImg));
            System.out.println(nImg);
        }
    }
}
