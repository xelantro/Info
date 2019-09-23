import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Commands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Commands extends Console
{
    private static String currentCommand;
    private static boolean argumentError;
    
    private static final String command1 = "damagePlayer";
    private static final String command2 = "healPlayer";
    private static final String command3 = "freezePlayer";
    private static final String command4 = "test";
    private static final String command5 = "say";

    public Commands()
    {

    }

    public static String doCommand(String command)
    {
        String output = "Unnown Command, Try /help.";
        argumentError = false;
        try
        {
            if(command.equals("help"))
            {
                output = "Commands: "+command1+", "+command2+", "+command3+", "+command4+", "+command5;
            }
            
            //with parameter
            if(command.length() >= command5.length())
            {
                if( command.substring(0, command5.length()).equals(command5) )    
                {
                    argumentError = true;
                    output = "argumentError!";
                    if(command.substring(command5.length()+1, command5.length()+2).equals(" "))
                    {
                        String value = command.substring(command5.length()+2);
                        output = "";
                        output = say(value);
                    }
                }
            }
            
            //withoutParameter
            if(command.length() >= command4.length())
            {
                if( command.substring(0, command4.length()).equals(command4))    
                {
                    output = test();
                }
            }
            /*
            if(command.length() >= 14)
            {
                if( command.substring(0, 12).equals("damagePlayer") && command.substring(12).equals(" ") )    
                {
                    double value = Double.valueOf(command.substring(13));
                    damagePlayer(value);
                }
            }
            if(command.length() >= 14)
            {
                if( command.substring(0, 12).equals("damagePlayer") && command.substring(12).equals(" ") )    
                {
                    double value = Double.valueOf(command.substring(13));
                    damagePlayer(value);
                    
                }
            }
            */
            
        }
        catch(Exception e)
        {
            if(argumentError)
            {
                output = "ArgumentError!";
            }
            else
            {
                output = "Unnown Error, watch the Terminal.";
            }
            System.out.println(e);
            // Greenfoot.stop();
        }
        return output;
    }

    //setCommands
    private static void damagePlayer(double damage)
    {
        Player.damage(damage);
    }

    private static void healPlayer(double percentage)
    {
        Player.setLife(percentage);
    }

    private static void freezePlayer(boolean freeze)
    {
        Player.freeze(freeze);
    }
    //getCommands
    private static String test()
    {
        return "trololo";
    }
    
    private static String say(String text)
    {
        if(!text.trim().isEmpty())
        {
            text = "You've said: "+text;
        }
        else
        {
            text = "You've said nothing!?";
        }
        
        return text;
    }
}
