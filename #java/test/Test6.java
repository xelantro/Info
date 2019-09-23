package me.xelantro.info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import me.xelantro.info.Main.Run;

public class Test6 extends Run{
	private final ArrayList<String> list = new ArrayList<String>(Arrays.asList("Hallo", "du", "kek", "Moinsen"));

	@Override
	public void run() {
		this.listOut(list);
		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.length()-arg1.length();
			}
		};
		System.out.println();
		list.sort((a,b) -> a.length()-b.length());
		this.listOut(list);
	}


	private void listOut(ArrayList<String> l)
	{
		l.forEach(System.out::println);
	}
}
