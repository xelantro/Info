package me.xelantro.info;

import java.util.ArrayList;
import java.util.stream.Collectors;

import me.xelantro.info.Main.Run;

public class Test2 extends Run {
	private static final ArrayList<Integer> list1 = new ArrayList<Integer>();

	public Test2() {
		for(int i=0; i<=5; i++)
		{
			list1.add((int)this.map(Math.random(), 0, 1, 0, 10000));
		}
	}

	@Override
	public void run() {
		list1.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList()).forEach(System.out::println);
	}
}
