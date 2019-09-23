package me.xelantro.info;

import java.util.ArrayList;
import java.util.Arrays;

import me.xelantro.info.Main.Run;

public class Test1 extends Run {
	private static final ArrayList<Character> list1 = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', '4', '6', 'F'));
	private static final ArrayList<Character> list2 = new ArrayList<Character>(Arrays.asList('C', '6', '5', 'A'));
	@Override
	public void run() {
		//		list1.stream().map(item -> {return list2.contains(item)? item : null;}).filter(item -> item != null).collect(Collectors.toList()).forEach(System.out::println);
		//		list1.stream().map(item -> {if(list2.contains(item)) return item;}).collect(Collectors.toList()).forEach(System.out::println);
		//		list1.stream().filter(item -> list2.contains(item)).forEach(System.out::println);
		list1.stream().filter(list2::contains).forEach(System.out::println);
	}
}
