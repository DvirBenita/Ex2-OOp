package dataStructure;


import java.util.Collection;
import java.util.HashMap;
import utils.edgeData;



public class DGraph implements graph{

	private HashMap<String, edge_data> edges = new HashMap<>();
	private HashMap<Integer,node_data> vertex = new HashMap<>();
	private HashMap<Integer,HashMap<Integer,edge_data>> E;
	//	private HashMap<Integer,MyDS> forE;
	private int change=0;


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
			this.E.put(n.getKey(), new HashMap<Integer,edge_data>());
			//this.forE.put(n.getKey(), new MyDS());
			this.change++;
		}
	}

	@Override
	public void connect(int src, int dest, double w) {
		String key = ""+src+","+dest;
		if(!edges.containsKey(key)) {
			edge_data temp = new edgeData(src, dest, w);
			edges.put(key, temp);
			E.get(src).put(dest, temp);
			//	forE.get(src).add(temp);
			this.change++;
		}
	}

	@Override
	public Collection<node_data> getV() {
		return  this.vertex.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {

		return	E.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {

		node_data current = vertex.get(key);
		if(current==null)
			return null;
		vertex.remove(key);
		E.remove(key);
		//forE.remove(key);
		for(String s :edges.keySet()) {
			if(s.contains(""+key)) {
				edges.remove(s);
			}
		}
		this.change++;
		return current;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		edge_data current = this.edges.get(""+src+","+dest);
		if(current==null){
			return null;
		}
		edges.remove(""+src+","+dest);
		E.get(src).remove(dest);//O(1)
		// forE.get(src).remove(current);
		return current;
	}

	@Override
	public int nodeSize() {
		return this.vertex.values().size();
	}

	@Override
	public int edgeSize() {

		return edges.values().size();
	}

	@Override
	public int getMC() {
		return this.change;
	}

}
