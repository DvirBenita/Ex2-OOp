package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Collection;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.node_data;
import utils.Point3D;
import utils.edgeData;
import utils.nodeData;

class DGraphTests {


	DGraph dg,empty_graph;
	int INIT_SIZE=10;
	int key1,key2,key3;
	@BeforeEach
	void init() {
		dg = new DGraph(INIT_SIZE);
		key1=key2=key3=0;
		while(key1==key2||key1==key3||key2==key3) {
		key1 = (int) (Math.random() * INIT_SIZE)+1;
		key2 = (int) (Math.random() * INIT_SIZE)+1;
		key3 = (int) (Math.random() * INIT_SIZE)+1;
		}
	
		dg.connect(key1, key2, 50);
		dg.connect(key1, key3, 60);
		dg.connect(key2, key3, 70);

		empty_graph = new DGraph();
	}



	
	
	@Test
	void checkSize() {
		
		assertEquals(INIT_SIZE, dg.nodeSize());
	}
	
	@Test
	void addVertex() {
		int add = 5;
		for (int i = INIT_SIZE + 1; i <= add + INIT_SIZE; i++) {
			node_data n = new nodeData(i);
			dg.addNode(n);
		}
		assertEquals(INIT_SIZE + add, dg.nodeSize());
	}

	
	
	@Test
	void removeVertex() {
		int remove = 3;
		for (int i = 1; i <= remove; i++) {
			dg.removeNode(i);
		}
		assertEquals(INIT_SIZE - remove, dg.nodeSize());
	}

	
	@Test
	void getNodes() {
		int remove = 3;
		for (int i = 1; i <= remove; i++) {
			dg.removeNode(i);
		}
		int nodeKey = 1;
		assertTrue(dg.getNode(nodeKey) == null);
		nodeKey = 3;
		assertTrue(dg.getNode(nodeKey) == null);
		nodeKey = 5;
		assertTrue(dg.getNode(nodeKey) != null);
	}
	
	@Test
	void testConnect() {
		node_data src_node = dg.getNode(key3);
		node_data dest_node = dg.getNode(key2);
		double w = 100;

		edgeData expected_edge = new edgeData(src_node.getKey(), dest_node.getKey(), w);
		dg.connect(src_node.getKey(), dest_node.getKey(), w);

		edge_data actual_edge = dg.getEdge(key3, key2);

		assertEquals(expected_edge.getSrc(), actual_edge.getSrc());
		assertEquals(expected_edge.getDest(), actual_edge.getDest());
		assertEquals(expected_edge.getWeight(), actual_edge.getWeight());

	}

	
	@Test
	void GetEdgeTest() {
		edge_data e0 = dg.getEdge(key1, key2);
		edge_data e1 = dg.getEdge(key2, key3);

		edge_data null_e = empty_graph.getEdge(key1, key2);

		assertEquals(key1, e0.getSrc());
		assertEquals(key2, e0.getDest());
		assertEquals(key2, e1.getSrc());
		assertEquals(key3, e1.getDest());
		assertNull(null_e);

	}
	
	@Test
	void GetVtest() {
		Collection<node_data> actual = dg.getV();
		int expected = dg.nodeSize();

		assertEquals(expected, actual.size());
	}
	@Test
	void testGetE() {
		int actual_edges = 0;
		for (node_data node : dg.getV()) {
			Collection<edge_data> edges = dg.getE(node.getKey());
			if (edges != null)
				actual_edges += edges.size();
		}

		assertEquals(dg.edgeSize(), actual_edges);
	}
	
	@Test
	void runnigTime() throws InterruptedException {
		int m1 = 1000000;
		assertTimeout(Duration.ofSeconds(10), () -> {
			DGraph dg = new DGraph(m1);
			for (node_data n : dg.getV()) {
				for (int i = 1; i <= 10; i++) {
					try {
						dg.connect(n.getKey(), n.getKey() + i, i * 5);
					} catch (Exception e) {
					}
				}
			}
		});
	}
	@Test
	void testRemoveEdge() {
		node_data new_node0 = new nodeData(300);
		node_data new_node1 = new nodeData(400);
		dg.addNode(new_node0);
		dg.addNode(new_node1);
		
		dg.connect(new_node0.getKey(), new_node1.getKey(), 100);
		int edges_before = dg.edgeSize();
		
		dg.removeEdge(new_node0.getKey(), new_node1.getKey());
		int edges_after = dg.edgeSize();

		assertEquals(edges_before - 1, edges_after);
		
	}


}
