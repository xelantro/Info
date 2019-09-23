package de.memium.vectors;

import javax.swing.JFrame;

import java.awt.Dimension;

import de.memium.grafic.Coordsystem;

public class Main {

	public static void main(String[] args) {
		Vektor v1 = new Vektor(1,2,3);
		v1.print(System.out);
		//		System.out.println(v1.getVal());

		//JFrame out = 
		new VekFrame(new Coordsystem(10, 10, 100, new OrtsVektor(v1)));

		//		while(true)
		//			System.out.println(out.getSize());
		//		System.out.println(v1+v2);
	}

	private static class VekFrame extends JFrame
	{
		private static final long serialVersionUID = -6340056175315383631L;

		public VekFrame(Coordsystem pan) {
			int maxH = pan.getWidth(), maxW = pan.getWidth();
			//			for(JPanel pan : pans)
			//			{
			//				this.add(pan);
			//				if(pan.getWidth()>maxW)
			//					maxW = pan.getWidth();
			//				if(pan.getHeight()>maxH)
			//					maxH = pan.getHeight();
			//			}
			this.setMinimumSize(new Dimension(maxW, maxH));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.pack();
			this.repaint();
		}
	}

}
