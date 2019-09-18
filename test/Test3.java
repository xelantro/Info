package me.xelantro.info;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 extends Main.Run {

	@Override
	public void run() {
		ArrayList<String> list = this.splitEQ("x^34+3x^254+x^2+123+2x");
		this.sysLogBr(this.ableiten(list));
	}

	private String ableiten(ArrayList<String> list)
	{
		return list.stream()
				.filter(part -> part.contains("x"))
				.map(this.ax())
				.map(this.axb())
				.collect(Collectors.joining("+"));
	}

	private ArrayList<String> splitEQ(String eq)
	{
		ArrayList<String> temp = new ArrayList<String>();
		int lastP = 0;
		for(int i=0; i<eq.length(); i++)
		{
			if(eq.charAt(i) == '+')
			{
				temp.add(eq.substring(lastP, i));
				lastP = i+1;
			}
			else if((i+1)==eq.length())
			{
				temp.add(eq.substring(lastP, i+1));
			}
		}
		return temp;
	}

	private Function<String,String> ax() 
	{
		return s -> {
			for(int i=0; i<s.length(); i++)
			{
				if(s.charAt(i)=='x' && s.length()==i+1)
				{
					return s.substring(0, i);
				}
			}
			return s;
		};
	}

	private Function<String,String> axb()
	{
		return s -> {
			s.concat(" ");
			for(int i=0; i<s.length()-1; i++)
			{
				if(s.subSequence(i, i+2).equals("x^"))
				{
					int pow = this.getNumAfter(s, i+1);
					int mp = this.getNumBefore(s, i);
					return (pow==2)? mp*pow+"x" : mp*pow+"x^"+(pow-1);
				}
			}
			return s;
		};
	}

	private int getNumBefore(String s, int i)
	{
		String cs = "";
		for(int j=i; j>=0; j--)
		{
			if(this.isNumeric(s.substring(j, i)))
			{
				cs = s.substring(j, i);
			}
		}
		if(cs.isEmpty())
		{
			cs = "1";
		}
		return Integer.parseInt(cs);
	}

	private int getNumAfter(String s, int i)
	{
		String cs = "";
		for(int j=1; j<s.length()-i+1; j++)
		{
			if(this.isNumeric(s.substring(i+1, j+i)))
			{
				cs = s.substring(i+1, j+i);
			}
		}
		return Integer.parseInt(cs);
	}
}
