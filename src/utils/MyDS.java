package utils;

import java.util.*;

import dataStructure.edge_data; 

//this class This class was built on the inspiration of https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
public class MyDS 
{ 
	ArrayList<edge_data> arr; 
	HashMap<edge_data, Integer>  hash; 

	public MyDS() 
	{ 
		arr = new ArrayList<edge_data>(); 
		hash = new HashMap<edge_data, Integer>(); 
	} 

	public void add(edge_data x) 
	{ 

		if (hash.get(x) != null) 
		{
			Integer index=hash.get(x);
			arr.set(index, x);
			hash.values();
		}
		int s = arr.size(); 
		arr.add(x); 
		hash.put(x, s); 
	} 

	public void remove(edge_data x) 
	{ 
		Integer index = hash.get(x); 
		if (index == null) 
			return; 
		hash.remove(x); 
		int size = arr.size(); 
		edge_data last = arr.get(size-1); 
		Collections.swap(arr, index,  size-1); 
		arr.remove(size-1); 
		hash.put(last, index); 
	} 

	public Integer search(edge_data x) 
	{ 
		return hash.get(x); 
	} 
	public ArrayList<edge_data> getCollection(){
		return this.arr;
	}
} 
