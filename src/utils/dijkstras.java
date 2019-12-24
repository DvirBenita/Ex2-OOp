package utils;
import java.util.*;

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
			entry.getValue().setWeight(Double.POSITIVE_INFINITY);
			entry.getValue().setInfo("-1");
			entry.getValue().setTag(-1);
		}
		this.Grpah.getVertex().get(src).setInfo("-10");
		this.Grpah.getVertex().get(src).setWeight(0);
		pq.add(this.Grpah.getVertex().get(src)); 

		while (settled.size() != this.Grpah.getVertex().size()) { 
			if(!pq.isEmpty()) {
			int u = pq.remove().getKey(); 
			
			this.Grpah.getVertex().get(u).setTag(1);
			settled.add(u); 
			Neigh(u); 
			}else {
				return -1;
			}
			
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

	public List<node_data> dijkstra1(int src, int dest) {
		
		for (Map.Entry<Integer, node_data> entry : this.Grpah.getVertex().entrySet())
		{
			entry.getValue().setWeight(Double.POSITIVE_INFINITY);
			entry.getValue().setInfo("-1");
			entry.getValue().setTag(-1);
		}
		this.Grpah.getVertex().get(src).setInfo("-10");
		this.Grpah.getVertex().get(src).setWeight(0);
		pq.add(this.Grpah.getVertex().get(src)); 

		while (settled.size() != this.Grpah.getVertex().size()) { 
			if(!pq.isEmpty()) {
				int u = pq.remove().getKey(); 
				
				this.Grpah.getVertex().get(u).setTag(1);
				settled.add(u); 
				Neigh(u); 
				}else {
					return null;
				}
		}
		
		ArrayList<node_data> path = new ArrayList<node_data>();
		node_data temp =  this.Grpah.getVertex().get(dest);
		path.add(temp);
		while(temp.getInfo().compareTo("-10")!=0) {
			temp = this.Grpah.getVertex().get(Integer.parseInt(temp.getInfo()));
			path.add(temp);
		}
		
		
		return reverseArrayList(path);
	}
		
		private static ArrayList<node_data> reverseArrayList(ArrayList<node_data> alist) 
	    { 
	        
	        ArrayList<node_data> revArrayList = new ArrayList<node_data>(); 
	        for (int i = alist.size() - 1; i >= 0; i--) { 
	 
	            revArrayList.add(alist.get(i)); 
	        }
	        
	        return revArrayList; 
	    } 
		
	

}
