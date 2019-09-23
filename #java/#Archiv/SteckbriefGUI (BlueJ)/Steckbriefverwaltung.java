import java.util.*;

public class Steckbriefverwaltung 
{
    // Attribute
    private ArrayList<Steckbrief> steckbriefe = new ArrayList<Steckbrief>();
    private Hauptfenster hf;
    private Eingabefenster ef;
    
    // Konstruktor(en)
    public Steckbriefverwaltung()
    {
        hf = new Hauptfenster(this);
        ef = new Eingabefenster();
        
        steckbriefe.add(new Steckbrief("Peter", "Lustig", true, 1974L, 42105, 80.5, 185.2));
        steckbriefe.add(new Steckbrief("Lisa", "Lustig", false, 1972L, 42105, 60.5, 165.2));
        steckbriefe.add(new Steckbrief("Max", "Lustig", true, 1980L, 42922, 76.5, 190.2));
        steckbriefe.add(new Steckbrief("Miri", "Lustig", false, 1984L, 42853, 85.5, 184.2));
        steckbriefe.add(new Steckbrief("Tom", "Lustig", true, 1990L, 42363, 84.3, 183.2));
        steckbriefe.add(new Steckbrief("Till", "Lustig", true, 1983L, 42104, 68.5, 168.2));
        steckbriefe.add(new Steckbrief("Julia", "Lustig", false, 1989L, 42145, 91.5, 175.2));
        steckbriefe.add(new Steckbrief("Laura", "Lustig", false, 1990L, 42115, 64.2, 165.2));
        
        this.mischen();
        
    }

    // Methoden
    public void steckbriefeDrucken(String pText)
    {
        hf.aktualisiereAusgabe(steckbriefe);
    }
    
    public void mischen()
    {
        Random r = new java.util.Random();
        for(int i = 0; i < 100; i++)
        {
            int a = r.nextInt(steckbriefe.size());
            int b = r.nextInt(steckbriefe.size());
            Steckbrief temp = steckbriefe.get(a);
            steckbriefe.set(a, steckbriefe.get(b));
            steckbriefe.set(b, temp);
        }
        this.steckbriefeDrucken("unsortiert");
    }
    
    public void maxsort()
    {
        for(int a = 0; a < steckbriefe.size()-1; a++)
        {
            int s = 0;
            for(int r = 1; r < steckbriefe.size()-a; r++)
            {
                if(steckbriefe.get(r).gibGeburtsjahr() > steckbriefe.get(s).gibGeburtsjahr())
                {
                    s = r;
                }
            }
            Steckbrief temp = steckbriefe.get(s);
            steckbriefe.set(s, steckbriefe.get(steckbriefe.size()-1-a));
            steckbriefe.set(steckbriefe.size()-1-a, temp);
        }
        steckbriefeDrucken("Maxsort");
    }

    public void steckbriefHinzufuegen()
    {
        steckbriefe.add(ef.gibSteckbrief());
        //String zeile = new Scanner(System.in).nextLine();
        //System.out.println(zeile);
    }
}
