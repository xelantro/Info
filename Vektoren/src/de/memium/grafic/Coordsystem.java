package de.memium.grafic;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Coordsystem extends JPanel {
	private static final long serialVersionUID = 251419057598134292L;
	public static AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(0));
	protected static Color axeColor = new Color(255, 70, 70);
	protected static Color bgColor  = new Color(240, 240, 255);
	protected ArrayList<Drawable> panels = new ArrayList<Drawable>();
	protected int scale;
	public int axes;
	//protected Stroke stroke = new BasicStroke(4);
	//	private Rectangle clip;
	//	private Rectangle drawRange;

	/**
	 * @param vals the area of Values
	 * @param scale the ammount of pixels used for 1LE
	 */
	public Coordsystem(int maxX, int maxY, int scale, Drawable... init) {
		this.scale = scale;
		this.setMinimumSize(new Dimension(maxX*scale, maxY*scale));
		this.setSize(this.getMinimumSize());
		this.setBackground(bgColor);
		axes = scale*2;
		for(Drawable d : init)
			this.addPanel(d);
	}

	public void addPanel(Drawable d)
	{
		panels.add(d);
		d.c = this;
	}

	protected void paintSystem(Graphics g)
	{
		g.setColor(axeColor);

	}

	protected void drawVektor(Graphics g, int x, int y, int dx, int dy, int size)
	{
		//g.drawPolygon(this.makeVektor(x+axes, this.getHeight()-axes-y, dx+axes, this.getHeight()-axes-dy, size));
	}



	@Override
	public void paint(Graphics g) {
		g.setColor(bgColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		panels.forEach(p -> p.paint(g));
		//super.paint(g);
	}
}
