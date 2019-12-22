package utils;
import java.util.*;
import java.util.Map;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.node_data; 
public class dijkstras {
	private DGraph Grpah;
	private Set<Integer> settled; 
	private PriorityQueue<node_data> pq; 

	
	
	
	
	public dijkstras( DGraph Grpah) 
	{ 
		this.Grpah=Grpah;
		settled = new HashSet<Integer>(); 
		pq = new PriorityQueue<node_data>(this.Grpah.getVertex().size(),new compNode()); 
	} 

	// Function for Dijkstra's Algorithm 
	public double dijkstra(int src,int dest) 
	{ 
		
		for (Map.Entry<Integer, node_data> entry : this.Grpah.getVertex().entrySet())
		{
			entry.getValue().setWeight(Integer.MAX_VALUE);
			entry.getValue().setInfo("-1");
			entry.getValue().setTag(-1);
		}
		this.Grpah.getVertex().get(src).setInfo("-10");
		this.Grpah.getVertex().get(src).setWeight(0);
		pq.add(this.Grpah.getVertex().get(src)); 

		while (settled.size() != this.Grpah.getVertex().size()) { 

			// remove the minimum distance node 
			// from the priority queue 
			int u = pq.remove().getKey(); 

			// adding the node whose distance is 
			// finalized 
			this.Grpah.getVertex().get(u).setTag(1);
			settled.add(u); 
			Neigh(u); 
		}
		
		
		node_data temp =  this.Grpah.getVertex().get(dest);
		
		return temp.getWeight();
	} 

	// Function to process all the neighbours 
	// of the passed node 
	private void Neigh(int u) 
	{ 
		double edgeDistance = -1; 
		double newDistance = -1; 

		// All the neighbors of v 
		//		for(Map.Entry<Integer,edge_data> entry : this.Grpah.getE().get(u)) {
		//			
		//		}

		for(edge_data edge : this.Grpah.getE().get(u).values() ) {
			//chek if his tag color is black=1
			if(this.Grpah.getVertex().get(edge.getDest()).getTag()!=1) {
				edgeDistance = this.Grpah.getVertex().get(edge.getSrc()).getWeight();
				newDistance = edgeDistance +  edge.getWeight();
				if(newDistance<this.Grpah.getVertex().get(edge.getDest()).getWeight()) {
					this.Grpah.getVertex().get(edge.getDest()).setWeight(newDistance);
					this.Grpah.getVertex().get(edge.getDest()).setInfo(""+edge.getSrc());
					
				}
				pq.add(this.Grpah.getVertex().get(edge.getDest()));
			}
		}
	} 

}
