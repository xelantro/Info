package de.memium.de.automaten.tester;

import java.util.HashMap;

public class Abi2012Feuerwehr {	
	private enum Status {
		q0('r','0','s','0','h','2','t','1'),
		q1('h','3','t','2','r','0','s','0'),
		q2('h','3','t','3','s','1','r','0'),
		q3('r','1','s','2','h','3','t','3','-','-');
		private HashMap<String, String> map = new HashMap<String, String>();
		private boolean isend;
		public Status ueberführung(String i) {
			return Status.valueOf("q"+map.get(i));
		}
		public boolean valid(String i) {
			return map.containsKey(i);
		}
		public boolean isEnd() { return this.isend; }
		private Status(char... args) {
			if((int)(args.length%2)==args.length%2&&args.length>1)
				for(int i=0;i<args.length;i+=2) {
					if(args[i]=='-') this.isend=true;
					else map.put(""+args[i], ""+args[i+1]);
				}
		}
	};

	private Status cst;
	public boolean pruefeWort(String wort) {
		for(char c : wort.toCharArray()) {
			if(!cst.valid(""+c)) return false;
			cst = cst.ueberführung(c+"");
		}
		return cst.isEnd();
	}

	public Abi2012Feuerwehr() {
		cst=Status.valueOf("q0");
	}

	public static void main(String[] args) {
		Abi2012Feuerwehr m = new Abi2012Feuerwehr();
		System.out.println(m.pruefeWort("srhrhh"));
	}
}