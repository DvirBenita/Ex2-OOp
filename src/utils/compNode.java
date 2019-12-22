package utils;
import java.util.Comparator;

import dataStructure.node_data; 
public class compNode implements Comparator<node_data> {


	@Override
	public int compare(node_data o1, node_data o2) {
		if (o1.getWeight() < o2.getWeight()) 
			return -1; 
		if (o2.getWeight() > o2.getWeight()) 
			return 1; 
		return 0; 
		
	}
}
