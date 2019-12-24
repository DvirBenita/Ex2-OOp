package utils;

import java.util.Comparator;

import dataStructure.node_data;

public class nodeData implements node_data{
	private int key;
	private Point3D location;
	private double weight;
	private String info;
	private int tag;

	public nodeData() {
		this.key=-1;
		this.location=new Point3D(0,0,0);
		this.weight=0;
		this.info=" ";
		this.tag=Integer.MIN_VALUE;
	}
	public nodeData(int key,Point3D location , double weight, String info, int tag) {
		this.key=key;
		this.location=new Point3D(location);
		this.weight =weight;
		this.info=info;
		this.tag=tag;

	}
	
	
	public nodeData(node_data value) {
		this(value.getKey(),value.getLocation(),value.getWeight(),value.getInfo(),value.getTag());
	}

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


