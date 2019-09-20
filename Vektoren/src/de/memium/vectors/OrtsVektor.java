package de.memium.vectors;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import de.memium.grafic.Drawable;

public class OrtsVektor extends Drawable {
	private ArrayList<Vektor> veks = new ArrayList<Vektor>();

	public OrtsVektor(Vektor... veks) {
		for(Vektor v : veks)
			this.veks.add(v);
		//this.setMinimumSize(super.getMinimumSize());
	}

	public void addVektor(Vektor v)
	{
		veks.add(v);
	}

	public Polygon makeVektor(int px, int py, int dx, int dy, int size)
	{
		//draw arrow pointing downwards -> betrag = dy weil dx (vorläufig) 0
		int[] xVals = { 3*size, 3*size, 0, 4*size, 8*size, 5*size, 5*size};
		int arrowPos = dy-Math.max(dy/40, xVals[5]);
		int[] yVals = { 0, arrowPos, arrowPos, dy, arrowPos, arrowPos, 0};

		//Polarkoordinatentransformation: Betrag = sqrt(dx²+dy²); Winkel = tan^-1(y/x)
		for(int i=0; i<7; i++)
		{
			//			double b = Math.sqrt(Math.pow(xVals[i], 2)+Math.pow(yVals[i], 2));
			//			double w = Math.atan2(yVals[i], xVals[i])-0.5*Math.PI;
			//			xVals[i] = (int)Math.round(b*Math.cos(Math.toRadians(w)));
			//			yVals[i] = this.getHeight()-axes-(int)Math.round(b*Math.sin(Math.toRadians(w)));
			@SuppressWarnings("static-access")
			Point2D temp = c.at.transform(new Point(xVals[i], yVals[i]), null);
			xVals[i] = c.axes+(int)Math.round(temp.getX());
			yVals[i] = c.getHeight()-c.axes-(int)Math.round(temp.getY());
		}
		return new Polygon(xVals, yVals, 7);
	}

	@Override
	public void paint(Graphics g) {
		//		for(Vektor v : veks)
		//			this.drawVektor((Graphics2D)g, 0, 0, 
		//					(int)Math.round(scale*v.getCoord(1)), 
		//					(int)Math.round(scale*v.getCoord(2)));
		g.drawPolygon(this.makeVektor(0, 0, 900, 900, 3));
		//this.drawVektor(g, 0, 0, 900, 900, 3);
	}

}
