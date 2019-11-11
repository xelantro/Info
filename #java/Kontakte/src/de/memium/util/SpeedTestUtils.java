package de.memium.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class SpeedTestUtils {

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
