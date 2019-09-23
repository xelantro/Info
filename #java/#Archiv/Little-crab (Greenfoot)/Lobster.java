import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
This class defines a crab. Crabs live on the beach.
 */
public class Lobster extends Animal 
{  
    public void act()
    {
        if(atWorldEdge()){
            turn(20);   
        }
        if(Greenfoot.getRandomNumber(100) < 10){
            turn(45-Greenfoot.getRandomNumber(90));   
        }   
        lookForCrabs();
        move();  
    }    

    public void lookForCrabs()
    {
        if(canSee(Crab.class)){
            eat(Crab.class); 
            Greenfoot.playSound("au.wav");
            Greenfoot.stop() ;
        }
        if(canSee(Crab2.class)){
            eat(Crab2.class); 
            Greenfoot.playSound("au.wav");
            Greenfoot.stop() ;
        }
    }
}

