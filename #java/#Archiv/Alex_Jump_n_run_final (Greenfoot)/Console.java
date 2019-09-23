import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
// import java.awt.FontMetrics;
//import java.awt.Color;
//
/**
 * @author alex
 */
public class Console extends GUI
{    
    private static final int backgroundWidth = 350;
    private static final int backgroundHeight = 17;
    private static final int outputWidth = 350;
    private static final int outputHeight = 100;

    private static final int width  = 800;
    private static final int height = outputHeight + backgroundHeight;

    private static final int curserSpeed = 800;
    private static final int openTransparenty  = 190;
    private static final int closeTransparenty = 110;

    private int inputPosition;

    private String currentInputText = "";
    private String currentLetter;
    private String output = "";
    private String oldOutput = "";

    private ArrayList<CharSequence> dontPrint;

    private boolean printLetter;
    private boolean initReady = false;
    private boolean open;
    private int inputLength = 0;
    private int outputLength = 0;
    private int outputTransparency = 0;

    private GreenfootImage MainImage;
    private GreenfootImage MainImageOutput;
    private GreenfootImage MainImageInput;
    private GreenfootImage BackgroundImage;
    private GreenfootImage CurserImage;
    private GreenfootImage InputText;
    private GreenfootImage OutputText;

    // private SimpleTimer outputTime = new SimpleTimer();
    private SimpleTimer curserTime = new SimpleTimer();

    public Console()
    {
        MainImage        = new GreenfootImage(width, height);
        MainImageOutput  = new GreenfootImage(outputWidth, outputHeight);
        MainImageInput   = new GreenfootImage(backgroundWidth, backgroundHeight);
        BackgroundImage  = new GreenfootImage(backgroundWidth, backgroundHeight);
        CurserImage      = new GreenfootImage(2, backgroundHeight-6);
        InputText        = new GreenfootImage(backgroundWidth, backgroundHeight-4);
        OutputText       = new GreenfootImage(outputWidth, outputHeight);

        CurserImage.setColor(new Color(255, 255, 255, openTransparenty));

        OutputText.setColor(Color.WHITE);
        InputText.setColor(Color.WHITE);
        MainImageOutput.setColor(Color.BLACK);
        MainImageOutput.fill();
        this.setImage(MainImage);

        currentInputText = "";
        dontPrint = new ArrayList<CharSequence>();
        dontPrint.add((CharSequence)"escape");
        dontPrint.add((CharSequence)"enter");
        dontPrint.add((CharSequence)"shift");
        dontPrint.add((CharSequence)"left");
        dontPrint.add((CharSequence)"right");
        dontPrint.add((CharSequence)"up");
        dontPrint.add((CharSequence)"down");
        dontPrint.add((CharSequence)"control");

        open = false;
        curserTime.mark();
    }

    public void act() 
    {
        initiaisierung();
        activate();

        BackgroundImage();
        curser();
        position();
        output();

        MainImage.clear();
        MainImage.drawImage(MainImageInput, 0, height-backgroundHeight);
        MainImage.drawImage(MainImageOutput, 0, 0);

        System.out.println(currentInputText);
        System.out.println(output);
    }

    private void output()
    {
        if(!output.isEmpty())
        {
            if(output == oldOutput)
            {
                outputTransparency += Math.min(-1, (-15)+(Math.min(5, output.length())))+5;
            }
            else
            {
                outputTransparency = 255;
            }

            if(outputTransparency >= 30)
            {
                outputLength = OutputText.getAwtImage().getGraphics().getFontMetrics().stringWidth(output);
                
                OutputText.clear();
                // if(outputLength < OutputText.getWidth())
                // {
                OutputText.drawString(output, 5, 10);
                // }
                // else if(outputLength < OutputText.getWidth()*2)
                // {
                // OutputText.drawString(output.substring(1, 10), 1, 1);
                // }
                // else if(outputLength < OutputText.getWidth()*3)
                // {
                // OutputText.drawString(output, 1, 1);
                // }

                oldOutput = output;
            }
        }
        else
        {
            outputTransparency = 0;
        }
        
        MainImageOutput.clear();
        MainImageOutput.fill();
        MainImageOutput.drawImage(OutputText, 1, 1);
        MainImageOutput.setTransparency( (Math.min(255, (Math.max(0, outputTransparency)))) ); //0 is Transparet
    }

    private void BackgroundImage()
    {
        BackgroundImage.clear();
        BackgroundImage.setColor(new Color(0,0,0));

        if(open)
        {
            BackgroundImage.setTransparency(openTransparenty);
        }
        else
        {
            BackgroundImage.setTransparency(closeTransparenty);
        }

        int moreBackgroundWidth = Math.max(0, inputLength-backgroundWidth);
        BackgroundImage.fillRect(0, 0, backgroundWidth+moreBackgroundWidth+20, backgroundHeight);  
    }

    private void curser()
    {
        if(open)
        {
            input();

            if(curserTime.millisElapsed() >= (curserSpeed*2))
            {
                curserTime.mark();
            }
            else if(curserTime.millisElapsed() >= curserSpeed)
            {
                CurserImage.setTransparency(0);
            }
            else if(curserTime.millisElapsed() >= 0)
            {
                CurserImage.setTransparency(255);
            }

            CurserImage.clear();
            CurserImage.fill();
        }
        else
        {
            CurserImage.clear();
        }

        InputText.clear();
        InputText.drawString(currentInputText, 0, 11);
        inputLength = InputText.getAwtImage().getGraphics().getFontMetrics().stringWidth(currentInputText);
        MainImageInput.clear();
        MainImageInput.drawImage(BackgroundImage, 0, 0);
        MainImageInput.drawImage(InputText, 2, 2);
        MainImageInput.drawImage(CurserImage, 4 + inputLength, 3);
    }

    private void input()
    {
        currentLetter = Greenfoot.getKey();
        if(currentLetter!=null)
        {
            if(currentLetter.contains((CharSequence)"backspace"))    
            {
                if(currentInputText.length()>1)
                {
                    currentInputText = currentInputText.substring(0, currentInputText.length()-1);    
                }
                else
                {
                    currentInputText = "";
                }
            }
            else if(inputLength < width-30)
            {
                if(currentLetter.contains((CharSequence)"space"))
                {
                    currentInputText+=" ";
                }
                else if(currentLetter.contains((CharSequence)"enter"))
                {
                    if(currentLetter.length() >= 2)
                    {
                        if(currentInputText.startsWith("/"))
                        {
                            output = Commands.doCommand(currentInputText.substring(1));
                            oldOutput = "";
                            currentInputText = "";
                        }
                        else
                        {
                            output = currentInputText;
                            currentInputText = "";
                        }
                    }
                    else
                    {
                        currentInputText = "";
                    }
                    Greenfoot.getKey();
                }
                else
                {
                    System.out.println(currentInputText); printLetter = true;
                    for(int i = 0; i<dontPrint.size(); i++)
                    {
                        if(currentLetter.contains(dontPrint.get(i)))
                        {
                            printLetter = false;
                            break;
                        }
                    }

                    if(printLetter)
                    {
                        currentInputText+=currentLetter;
                    } 
                }
            }
            System.out.println(currentInputText);
        }
    }

    private void position()
    {
        this.setLocation(width/2, this.getWorld().getHeight()-(height/2));
    }

    private void initiaisierung()
    {
        if(!initReady)
        { 
            initReady = true;
        }
    }

    private void activate()
    {
        if(Greenfoot.isKeyDown("t") &! open)
        {
            open = true;
            Greenfoot.getKey();
            Player.freeze(true);
        }
        else if(Greenfoot.isKeyDown("escape") && open)
        {
            open = false;
            Player.freeze(false);
        }
    }
}
