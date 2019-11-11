package de.memium.speedtest;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@SuppressWarnings("unused")
public class ChartPrinter extends JFrame {
	private static final long serialVersionUID = 1L;

	private File file;
	private Dimension size = new Dimension(1000, 700);

	public ChartPrinter(File file) throws Exception {
		this.file = file;//.isDirectory() ? new File(file.getPath()+"/output1.csv"):file;

		BufferedImage chart = createChart().createBufferedImage((int)Math.round(size.width/1.05), (int)Math.round(size.height/1.18));
		ImageIO.write(chart, "jpg", new File(file.getParent()+"/"+file.getName()+".jpg"));
		MainPan m = new MainPan(chart);
		this.setSize(size);
		this.add(m);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Sort-times");

		this.repaint();
	}

	private JFreeChart createChart() throws Exception
	{
		return ChartFactory.createAreaChart("ListSpeed", 
				"Number of elements", 
				"Actiontime in ms", 
				createDataset(), 
				PlotOrientation.VERTICAL, 
				false, 
				false, 
				false);
	}

	private CategoryDataset createDataset() throws Exception
	{ 
		System.out.println("Calculate");
		DefaultCategoryDataset data =  new DefaultCategoryDataset();
		ArrayList<String> counts = new ArrayList<String>();
		ArrayList<Integer> vals = new ArrayList<Integer>();
		BufferedReader r = new BufferedReader(new FileReader(file));
		r.lines().skip(1).forEach(l -> {
			String[] tmp = l.split(",");
			counts.add(tmp[0]);
			vals.add(Integer.parseInt(tmp[1]));
		});
		r.close();
		vals.trimToSize();
		counts.trimToSize();

		//mapwithIndex
		for(int i=0; i<vals.size(); i++)
		{
			data.setValue(vals.get(i)/1000, "time", counts.get(i));
		}
		System.out.println("Construct");
		return data;
		//        double[] valCount = new double[temp.size()];
		//        double[][] vals = new double[1][temp.size()];
		//        for(int i=0; i<temp.size(); i++)
		//        {
		//        	valCount[i] = i+1;
		//        	vals[0][i] = temp.get(i);
		//        }
		//        	
		//		return DatasetUtilities.createCategoryDataset("SortTime", "Test", vals);
	}

	private XYDataset createXYDataset() throws Exception
	{
		XYSeries ser = new XYSeries("vals");
		ArrayList<Integer> temp = new ArrayList<Integer>();
		BufferedReader r = new BufferedReader(new FileReader(file));
		r.lines().limit(10000).forEach(l -> temp.add(Integer.parseInt(l)));
		r.close();
		for(int i=0; i<temp.size(); i++)
		{
			ser.add((double)i+1, (double)temp.get(i));
		}

		XYSeriesCollection data = new XYSeriesCollection();
		data.addSeries(ser);
		return data;
	}

	private class MainPan extends JPanel
	{
		private static final long serialVersionUID = -8516941754357151441L;
		BufferedImage img;

		public MainPan(BufferedImage pImg) {
			img = pImg;
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, null);
			//g.setColor(Color.BLACK);
			//g.fillRect(10, 10, 10, 10);
			//System.out.println("Test");
		}
	}
}
