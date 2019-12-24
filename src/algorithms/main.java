package algorithms;

import java.util.Arrays;
import java.util.List;

import dataStructure.DGraph;
import utils.Point3D;
import utils.nodeData;
import dataStructure.node_data;
import gui.Graph_GUI; 
public class main {

	public static void main(String[] args) {
	
		Graph_Algo gra = new Graph_Algo();
		DGraph dg = new DGraph();
		for(int i=0;i<6;i++) {
		Point3D p = new Point3D(i,i+1);
		nodeData n = new nodeData(i,p,1,"-1",-1);
		dg.addNode(n);
		}
		
		dg.connect(1,0 , 14);
		dg.connect(0,1 , 14);
		
		dg.connect(1,5 , 9);
		
		dg.connect(1,2 , 7);
		dg.connect(2,1 , 7);
		dg.connect(2,5 , 10);
		dg.connect(2,3 , 15);
		dg.connect(3,2 , 15);
		dg.connect(3,5 , 11);
		//dg.connect(3,4 , 6);
		dg.connect(4,3 , 6);
		dg.connect(4,0 , 9);
		dg.connect(0,5 , 2);
		dg.connect(0,4 , 9);
		dg.connect(5, 3, 11);
		dg.connect(5, 2, 10);
		dg.connect(5, 1, 9);
		dg.connect(5, 0, 2);
		gra.init(dg);
		
		
//		System.out.println(gra.shortestPathDist(1, 4));
//		List<node_data> temp = gra.shortestPath(1, 4);
		
		
		System.out.println(gra.isConnected());
		Graph_GUI window = new Graph_GUI(dg);
		window.setVisible(true);
		
	}

}
