import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Plattform extends Actor
{
    public Plattform(int widht, int height, String bild)
    {
        this.setImage(bild);
        this.getImage().scale(widht, height);
    }
    public Plattform()
    {
        int widht  = 200;
        int height = 30;
        this.setImage("images"+".jpeg");
        this.getImage().scale(widht, height);
    }
    public void act() 
    {
       
    }    
}
