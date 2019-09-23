package me.xelantro.info;

import me.xelantro.info.Main.Run;

public class Test5 extends Run{
	@Override
	public void run() {
		String in = "Best Nightcore Mix 2018 - Top 20 Nightcore 2018 - YouTube - Mozilla Firefox";
		sysLog(
				in.substring(0, this.startOfPhrase(in, " - YouTube"))
				);
	}

	private int startOfPhrase(String val, String phrase)
	{
		int start = 0;
		for(int i=0; i<=val.length(); i++)
		{
			if(val.substring(i).startsWith(phrase))
			{
				start = i;
				break;
			}
		}
		return start;
	}
}
