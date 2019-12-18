package dataStructure;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

import utils.edgeData;



public class DGraph implements graph{
	private HashMap<String, edge_data> edges = new HashMap<>();
	private HashMap<Integer,node_data> vertex = new HashMap<>();
	private HashMap<Integer,LinkedList<edge_data>> forE;
	private LinkedList<node_data> colle = new LinkedList<>();
	
	@Override
	public node_data getNode(int key) {
		return vertex.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		String key = ""+src+","+dest;
		return edges.get(key);
	}

	@Override
	public void addNode(node_data n) {
		if(!vertex.containsKey(n.getKey())) {
		vertex.put(n.getKey(), n);
		this.colle.add(n);
		this.forE.put(n.getKey(), new LinkedList<edge_data>());
		}
	}

	@Override
	public void connect(int src, int dest, double w) {
		String key = ""+src+","+dest;
		if(!edges.containsKey(key)) {
		edgeData temp = new edgeData(src, dest, w);
		edges.put(key, temp);
		forE.get(src).add(temp);
		}
	}

	@Override
	public Collection<node_data> getV() {
		
		return  this.colle;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		
		return this.forE.get(node_id);
	}

	@Override
	public node_data removeNode(int key) {
		node_data current = vertex.get(key);
		this.colle.remove(current);
		vertex.remove(key);
		forE.remove(key);
//		String key = ""+src+","+dest;
//		if(!edges.containsKey(key)) {
//		edgeData temp = new edgeData(src, dest, w);
//		edges.put(key, temp);
//		forE.get(src).add(temp);
//		}
		Iterator it = edges.entrySet().iterator();
		while(it.hasNext()) {
			
		}
		return current;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
