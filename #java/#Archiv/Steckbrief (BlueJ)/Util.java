import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Util {
    public static void main(String[] args) throws Exception {
        //SpeedTest.go(1, 200000, nextLog(3));
        System.out.println("Starting...");
        //File data = mergeTimes(   new File("outs/sort1/"));
        //System.out.println("Evaluating...");
        //new ChartPrinter(new File("outs/sort3/output1.csv"));
        //throw new UserToStupidException("you must klick start");
        new Steckbriefverwaltung(10);
        
    }

    public static Steckbrief[] init()
    {
        Steckbrief[] temp = new Steckbrief[8];
        temp[0] = new Steckbrief("Peter", "Lustig", true, 1970L, 42105, 80.5, 185.2);
        temp[1] = new Steckbrief("Lisa", "Lustig", false, 1972L, 42105, 60.5, 165.2);
        temp[2] = new Steckbrief("Max", "Lustig", true, 1980L, 42922, 76.5, 190.2);
        temp[3] = new Steckbrief("Miri", "Lustig", false, 1984L, 42853, 85.5, 184.2);
        temp[4] = new Steckbrief("Tom", "Lustig", true, 1990L, 42363, 84.3, 183.2);
        temp[5] = new Steckbrief("Till", "Lustig", true, 1983L, 42104, 68.5, 168.2);
        temp[6] = new Steckbrief("Julia", "Lustig", false, 1989L, 42145, 91.5, 175.2);
        temp[7] = new Steckbrief("Laura", "Lustig", false, 1990L, 42115, 64.2, 165.2);
        return temp;
    }

    public static File mergeTimes(File dir) throws UserToStupidException, Exception //TODO
    {
        if(!dir.isDirectory())
            throw new UserToStupidException("this must be a path?!");

        File out = new File(dir.getPath()+"/output.csv");
        out.delete();
        FileWriter wr = new FileWriter(out);

        ArrayList<BufferedReader> rs = new ArrayList<BufferedReader>();
        for(File f : dir.listFiles(f -> f.getName().startsWith("output") && f.getName().length()>=7))
            rs.add(new BufferedReader(new FileReader(f)));
        rs.trimToSize();

        ArrayList<Integer> cTimes = new ArrayList<Integer>(rs.size());
        Integer cTime = 0;
        while(true)
        {
            cTimes.clear();
            rs.forEach(r -> { try { cTimes.add(Integer.parseInt(r.readLine())); } catch (Exception e) {}});
            if(cTimes.isEmpty())
                break;
            cTime = 0;
            for(int i : cTimes)
                cTime+=i;
            wr.append((cTime/cTimes.size())+"\n");
        }
        wr.close();
        rs.forEach(r -> {try {      r.close();       } catch (IOException e) {}});
        return out;
    }

    public static int durchschnitt(ArrayList<Integer> l)
    {
        int temp = 0;
        for(int i : l)
            temp+=i;
        return temp/l.size();
    }

    private static File nextLog(int algo) throws IOException 
    {
        File dir = new File("outs/sort"+algo+"/");
        if(dir.exists())
        {
            return new File("outs/sort"+algo+"/output"+(dir.listFiles(f -> f.getName().startsWith("output")).length+1)+".csv");
        }
        else
        {
            dir.mkdirs();
            return new File("outs/sort"+algo+"/output1.csv");
        }
    }

    public static class UserToStupidException extends Exception
    {
        private static final long serialVersionUID = 6290054696867382814L;
        private String msg;
        public UserToStupidException(String msg) {
            this.msg = msg;
        }

        public UserToStupidException(Exception e) {
            this.msg = e.getMessage()+" ("+e.getClass().getName()+")";
        }

        @Override
        public String getMessage() {
            return "Seems that you are just to stupid to get that "+msg;
        }
    }
}
