package de.memium.util;

public class TmpTst {

	public static void main(String[] args) {
		BasicList<Integer> list = new BasicList<Integer>(new Integer[] {0,1,2,0,3,4,0,5});
		list.forEach(System.out::print);
		System.out.println("");
		System.out.println(list.size());
		list.removeMatching(v->v<=2);
		System.out.println(list.size());
		list.forEach(System.out::print);
		//System.out.println("\n"+list.get(0));
	}
}
