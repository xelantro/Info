import java.util.Arrays;

public class Steckbriefverwaltung 
{
    // Attribute
    protected Steckbrief[] steckbriefe;

    private static final MergeSort mergeSort = new MergeSort();

    // Konstruktor(en)
    public Steckbriefverwaltung(int lenght)
    {
        steckbriefe = Util.init();
        SpeedTest.construct(this, lenght);
        this.steckbriefeSortieren_8();
        this.steckbriefeDrucken();
    }
    
    public Steckbriefverwaltung()
    {
        this(10000);
    }

    public Steckbriefverwaltung(Steckbrief[] st)
    {
        if(st!=null)
            steckbriefe = st;
    }

    // Methoden
    public void steckbriefeDrucken()
    {
        Arrays.asList(steckbriefe).forEach(s -> {System.out.print(s); System.out.println(s.gibGewicht());});
    }

    /**
     * Algo 1 -> Untericht: erster
     */
    public void steckbriefeSortieren_1()
    {
        for(int i = 0; i < steckbriefe.length-1; i++)
        {
            for(int j = i + 1; j < steckbriefe.length; j++)
            {
                //System.out.println(i+" - "+j);
                if(steckbriefe[i].gibGewicht() > steckbriefe[j].gibGewicht())
                {
                    Steckbrief temp = steckbriefe[i];
                    steckbriefe[i] = steckbriefe[j];
                    steckbriefe[j] = temp;
                }
            }
        }
    }

    /**
     * Aglo 2 -> Erster eigener
     */
    public void steckbriefeSortieren_2()
    {
        boolean getauscht;
        Steckbrief temp;
        do {
            getauscht = false;
            for(int i=0; i<steckbriefe.length-1; i++)
                if(steckbriefe[i].gibGewicht() < steckbriefe[i+1].gibGewicht())
                {
                    temp = steckbriefe[i];
                    steckbriefe[i] = steckbriefe[i+1];
                    steckbriefe[i+1] = temp;
                    getauscht = true;
                }
        } while(getauscht);
    }

    /**
     * Algo 3 -> Shakersort
     */
    public void steckbriefeSortieren_3()
    {
        for(int i = 1; i< steckbriefe.length;i++)
        {
            boolean getauscht = false;
            if(i%2 == 1)
            {
                for(int j=0; j<steckbriefe.length-i;j++)
                {
                    if(steckbriefe[j].gibGeburtsjahr() > steckbriefe[j+1].gibGeburtsjahr())
                    {
                        Steckbrief temp = steckbriefe[j];
                        steckbriefe[j] = steckbriefe[j+1];
                        steckbriefe[j+1] = temp;
                        getauscht = true;
                    }
                }
            }
            else
            {
                for(int j=steckbriefe.length-i; j> 0; j--)
                {
                    if(steckbriefe[j].gibGeburtsjahr() < steckbriefe[j-1].gibGeburtsjahr())
                    {
                        Steckbrief temp = steckbriefe[j];
                        steckbriefe[j] = steckbriefe[j-1];
                        steckbriefe[j-1] = temp;
                    }
                }
            }
            if(!getauscht)
                break;
        }
    }

    /**
     * Algo 4 -> Merge
     */
    public void steckbriefeSortieren_4()
    {
        mergeSort.sort(steckbriefe, 0 , steckbriefe.length-1);
    }

    /**
     * Algo 5 -> Lambda
     */
    public void steckbriefeSortieren_5() 
    {
        //Arrays.sort(steckbriefe, (s1, s2) -> s1.compareTo(s2));
    }

    /**
     * Algo 6 -> rekursiv
     */
    public void steckbriefeSortieren_6()
    {

    }

    /**
     * Algo 7 -> gnomesort
     */
    public void steckbriefeSortieren_7()
    {
        for(int i=0; i<steckbriefe.length-1;)
        {
            if(steckbriefe[i].compare(steckbriefe[i+1]))
            {
                Steckbrief temp = steckbriefe[i];
                steckbriefe[i] = steckbriefe[i+1];
                steckbriefe[i+1] = temp;
                i+=(i==0)?0:-1;
            }
            else
                i++;
        }
    }
    
    /**
     * Algo 8 -> maxSort
     */
    public void steckbriefeSortieren_8()
    {
        int mi; //greatest i
        for(int i=steckbriefe.length-1; i>=0; i--)
        {
            mi = 0;
            for(int j=1; j<=i; j++) //größtes element
            {
                if(steckbriefe[j].compare(steckbriefe[mi])) mi = j;
            }
            //taschen
            Steckbrief temp = steckbriefe[mi];
            steckbriefe[mi] = steckbriefe[i];
            steckbriefe[i]  = temp;
        }
    }

    public void steckbriefHinzufuegen()
    {
        //        String zeile = new Scanner(System.in).nextLine();
        //        System.out.println(zeile);
    }
}
