package algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node_data;
import utils.dijkstras;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	graph Graph;



	
	@Override
	public void init(graph g) {
		Graph = g;
	}

	@Override
	public void init(String file_name)  {
		try {///////////////////////////////////////////////////////chek this and save one
			FileInputStream f = new FileInputStream(file_name);
			ObjectInputStream o = new ObjectInputStream(f);

			Graph = (graph) o.readObject();
			o.close();
			f.close();
			System.out.println("the graph has init from file");

		}catch (IOException e) {
			System.out.println("IOException is caught");
		}catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

	@Override
	public void save(String file_name) {
		try {
			FileOutputStream f = new FileOutputStream(file_name);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(this);

			o.close();
			f.close();
			System.out.println("The object has been saved");


		}catch(IOException e) {
			System.out.println("IOException is caught");
		}
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public double shortestPathDist(int src, int dest) {
		return new dijkstras((DGraph) Graph).dijkstra(src, dest);
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		return ((DGraph)Graph).copy();
	}
//////////////////////////////////////////////////
	
	
	
	
	
	
	
}
