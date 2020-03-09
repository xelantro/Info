package de.memium.de.automaten.tester;

import java.util.HashMap;

public class Main {	
	private Status cst;

	private enum Status {
		q0('g','1','w','3'),
		q1('w','2'),
		q2('g','1','r','5'),
		q3('g','4'),
		q4('w', '3', 'r', '5'),
		q5('r', '5', 'a', '6'),
		q6();
		private HashMap<String, String> map = new HashMap<String, String>();
		public Status ueberführung(String i) {
			return Status.valueOf("q"+map.get(i));
		}
		public boolean valid(String i) {
			return map.containsKey(i);
		}
		public boolean isEnd() { return map.size()==0; } 
		private Status(char... args) {
			if((int)(args.length%2)==args.length%2&&args.length>1)
				for(int i=0;i<args.length;i+=2)
					map.put(""+args[i], ""+args[i+1]);
		}
	};


	public boolean pruefeWort(String wort) {
		for(char c : wort.toCharArray()) {
			if(!cst.valid(""+c)) return false;
			cst = cst.ueberführung(c+"");
		}
		return cst.isEnd();
	}


	public static void main(String[] args) {
		Main m = new Main();
		m.cst=Status.valueOf("q0");
		System.out.println(m.pruefeWort("gwgwrrrrrra"));
	}
}