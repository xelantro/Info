package me.xelantro.info;

import me.xelantro.info.Main.Run;

public class Test7 extends Run{

	@Override
	public void run() {
		int t = 0;
		sysLog(Math.ceil(t / 2000)+((t%2000)==0?0:1));
	}
}
