package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class Graph_GUI extends JFrame implements ActionListener{

	private graph Graph;
	private  Graph_Algo graphAlgo;
	
	
	public Graph_GUI(graph gr) {
		this.Graph =gr;
		graphAlgo = new Graph_Algo();
		graphAlgo.init(gr);
		initGui();
		
	}


	private void initGui() {
		
		this.setSize(900, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		MenuBar menu = new MenuBar();
		Menu m = new Menu("Menu");
		menu.add(m);
		this.setMenuBar(menu);
		RandomL(900, 800);
		MenuItem save = new MenuItem("Save");
		save.addActionListener(this);
		m.add(save);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		node_data prev = null;
		super.paint(g);
		
		for(node_data n : this.Graph.getV()) {//////chek in the end about getV
			g.setColor(Color.BLUE);
			int x =n.getLocation().ix();
			int y = n.getLocation().iy();
			g.fillOval(x,y, 10, 10);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString(n.getKey()+"", x+10, y+10);
			
			if(Graph.getE(n.getKey())!=null) {
				for(edge_data edge: Graph.getE(n.getKey())) {
					Point3D p = this.Graph.getNode(edge.getDest()).getLocation();
					int x1 = p.ix();
					int y1 = p .iy();
					
					g.setColor(Color.RED);
					g.setFont(new Font("Arial", Font.BOLD, 10));
					g.drawLine(x, y,x1, y1);
					g.drawString(""+edge.getWeight(), (int)(x+x1)/2-3,(int)((y+y1)/2-3));
					//need to add direction
				}
			}
			
			
			
			
			
			
		}
		
		
		
	}
	public void RandomL(int height, int width) {

		for (node_data n : Graph.getV()) {
			double x = Math.random() * (width)+45;
			double y = Math.random() * (height / 1.5)+45;
			n.setLocation(new Point3D(x, y));
		}
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.compareTo("Save")==0) {
			
		}
	}
	
	
	
	
}

