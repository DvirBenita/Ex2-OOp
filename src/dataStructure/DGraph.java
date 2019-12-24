package dataStructure;


import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import utils.edgeData;
import utils.nodeData;



public class DGraph implements graph,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedHashMap<String, edge_data> edges ;
	private LinkedHashMap<Integer,node_data> vertex ;
	private LinkedHashMap<Integer,LinkedHashMap<Integer,edge_data>> E;
	//	private LinkedHashMap<Integer,MyDS> forE;
	private int change;

	public DGraph() {
		this.edges = new LinkedHashMap<String, edge_data>();
		this.vertex = new LinkedHashMap<Integer, node_data>();
		this.E= new LinkedHashMap<Integer, LinkedHashMap<Integer,edge_data>>();
		this.change = Integer.MAX_VALUE;
	}
	public DGraph(LinkedHashMap<String, edge_data> edges , LinkedHashMap<Integer,node_data> vertex,LinkedHashMap<Integer,LinkedHashMap<Integer,edge_data>> E,int change) {
		this.edges = copyWithStringKey(edges);
		this.vertex = copyWithIntegerKey(vertex);
		this.E= copyWithIntegerHashInt(E);
		this.change = Integer.MAX_VALUE;
	}

	public graph copy() {
		return new DGraph(this.getEdges(),this.getVertex(),this.getE(),this.getChange());
	}

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
			this.E.put(n.getKey(), new LinkedHashMap<Integer,edge_data>());
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
		Collection<node_data> vertex = this.vertex.values();
		return  vertex;
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
		this.change++;
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
	

	
	public static LinkedHashMap<String, edge_data> copyWithStringKey(LinkedHashMap<String, edge_data> original)
	{
		String s="";
		LinkedHashMap<String, edge_data> copy = new LinkedHashMap<String, edge_data>();
		for (Map.Entry<String, edge_data> entry : original.entrySet())
		{
			s+=entry.getKey();
			copy.put(s,new edgeData(entry.getValue()));
			s="";
		}
		return copy;
	}
	private static LinkedHashMap<Integer, node_data> copyWithIntegerKey(LinkedHashMap<Integer, node_data> original)
	{
		LinkedHashMap<Integer, node_data> copy = new LinkedHashMap<Integer, node_data>();
		for (Map.Entry<Integer, node_data> entry : original.entrySet())
		{
			copy.put(entry.getKey(),new nodeData(entry.getValue()));
		}
		return copy;
	}
	private static LinkedHashMap<Integer, edge_data> copyWithIntegerKeyandEdge(LinkedHashMap<Integer, edge_data> original)
	{
		LinkedHashMap<Integer, edge_data> copy = new LinkedHashMap<Integer, edge_data>();
		for (Map.Entry<Integer, edge_data> entry : original.entrySet())
		{
			copy.put(entry.getKey(),new edgeData(entry.getValue()));
		}
		return copy;
	}
	private LinkedHashMap<Integer, LinkedHashMap<Integer, edge_data>> copyWithIntegerHashInt(
			LinkedHashMap<Integer, LinkedHashMap<Integer, edge_data>> original) {
		LinkedHashMap<Integer, LinkedHashMap<Integer, edge_data>> copy = new LinkedHashMap<Integer, LinkedHashMap<Integer,edge_data>>();

		for (Map.Entry<Integer, LinkedHashMap<Integer, edge_data>> entry : original.entrySet())
		{
			copy.put(entry.getKey(), copyWithIntegerKeyandEdge(entry.getValue()));
			
		}
		return copy;
	}

	public LinkedHashMap<String, edge_data> getEdges() {
		return edges;
	}
	public void setEdges(LinkedHashMap<String, edge_data> edges) {
		this.edges = edges;
	}
	public LinkedHashMap<Integer, node_data> getVertex() {
		return vertex;
	}
	public void setVertex(LinkedHashMap<Integer, node_data> vertex) {
		this.vertex = vertex;
	}
	public LinkedHashMap<Integer, LinkedHashMap<Integer, edge_data>> getE() {
		return E;
	}
	public void setE(LinkedHashMap<Integer, LinkedHashMap<Integer, edge_data>> e) {
		E = e;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
}
