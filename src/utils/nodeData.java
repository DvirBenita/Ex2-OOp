package utils;

import dataStructure.node_data;

public class nodeData implements node_data {
	private int key;
	private Point3D location;
	private double weight;
	private String info;
	private int tag;
	
	
	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public Point3D getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(Point3D p) {
		Point3D temp = new Point3D(p);
		this.location=temp;
	}

	@Override
	public double getWeight() {
		
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		this.weight=w;
		
	}

	@Override
	public String getInfo() {
		
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		this.info=s;
		
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		this.tag=t;
		
	}

}
