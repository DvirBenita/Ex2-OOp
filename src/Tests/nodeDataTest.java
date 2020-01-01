package Tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import utils.nodeData;
import utils.Point3D;

class nodeDataTest {
	
	static nodeData node1,node2,node3;
	
	@BeforeAll
	static void init() {
		node1 = new nodeData(0);
		node2 = new nodeData(1);
		node3 = new nodeData(2);
	}
	
	@Test
	void testNodeNode_data() {
		node1.setInfo("Info");
		node1.setLocation(new Point3D(1, 2, 3));
		node1.setTag(1);
		node1.setWeight(10);
		
		nodeData copy = new nodeData(node1);
		
		assertEquals(node1.getKey(), copy.getKey());
		assertEquals(node1.getInfo(), copy.getInfo());
		assertEquals(node1.getLocation(), copy.getLocation());
		assertEquals(node1.getTag(), copy.getTag());
		assertEquals(node1.getWeight(), copy.getWeight());
		
		node1.setInfo("Other Info");
		node1.setLocation(new Point3D(3, 2, 1));
		node1.setTag(0);
		node1.setWeight(20);
		
		assertEquals(node1.getKey(), copy.getKey());
		assertNotEquals(node1.getInfo(), copy.getInfo());
		assertNotEquals(node1.getLocation(), copy.getLocation());
		assertNotEquals(node1.getTag(), copy.getTag());
		assertNotEquals(node1.getWeight(), copy.getWeight());
		
	}

	@Test
	void testEquals() {
		nodeData n = node1;
		nodeData copy = new nodeData(n);
		nodeData node20 = new nodeData(4);
		
		assertTrue(!n.equals(copy));
		assertFalse(n.equals(node20));
		assertFalse(copy.equals(node20));
	
	}

	@Test
	void testNodeData() {
		nodeData n = new nodeData(5);
		for(int i = n.getKey()+1; i<=50;i++) {
			nodeData node = new nodeData(i);
			assertEquals(i, node.getKey());
		}
	}
	
	@Test
	void testGetKey() {
		assertEquals(0, node1.getKey());
		assertEquals(1, node2.getKey());
		assertEquals(2, node3.getKey());
		
	}
	
	@Test
	void testSetAndGetLocation() {
		Point3D node1_l = new Point3D(1, 2, 3);
		Point3D node2_l = new Point3D(4, 5, 6);
		
		node1.setLocation(node1_l);
		node2.setLocation(node2_l);
		node3.setLocation(node1_l);
		
		assertEquals(node1_l, node1.getLocation());
		assertEquals(node2_l, node2.getLocation());
		assertEquals(node1.getLocation(), node3.getLocation());

	}
	
	@Test
	void testSetAndGetInfo() {		
		String node1_i = "node1 Info";
		String node2_i = "node2 Info";
		
		node1.setInfo(node1_i);
		node2.setInfo(node2_i);
		node3.setInfo(node1_i);
		
		assertEquals(node1_i, node1.getInfo());
		assertEquals(node2_i, node2.getInfo());
		assertEquals(node1.getInfo(), node3.getInfo());
		
	}
	
	@Test
	void testSetAndGetTag() {
		int node1_t = 0;
		int node2_t = 1;
		
		node1.setTag(node1_t);
		node2.setTag(node2_t);
		node3.setTag(node1_t);
		
		assertEquals(node1_t, node1.getTag());
		assertEquals(node2_t, node2.getTag());
		assertEquals(node1.getTag(), node3.getTag());
	}

	@Test
	void testSetAndGetWeight() {
		double node1_w = 10;
		double node2_w= 20;
		
		node1.setWeight(node1_w);
		node2.setWeight(node2_w);
		node3.setWeight(node1_w);
		
		assertEquals(node1_w, node1.getWeight());
		assertEquals(node2_w, node2.getWeight());
		assertEquals(node1.getWeight(), node3.getWeight());
	}
}
