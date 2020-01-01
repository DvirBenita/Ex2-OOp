package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node_data;

class GraphAlgoTest {

	static DGraph g;
	static Graph_Algo algo;
	
	@BeforeAll
	static void initial() {
		g = new DGraph(3);
		g.connect(2, 3, 40);
		g.connect(3, 1, 50);
		g.connect(1, 2, 10);
		g.connect(3, 2, 60);
		g.connect(1, 3, 20);
		g.connect(2, 1, 30);
		
		algo = new Graph_Algo();
		algo.init(g);
	}
	
	
	
	/////nedd add more 2 functions and check if need add my functions
	@Test
	void testInitSaveToFile() {
		algo.save("Test.txt");
		
		Graph_Algo copy = new Graph_Algo();
		copy.init("Test.txt");
		
		graph copy_g = copy.copy();
		
		assertEquals(g.nodeSize(), copy_g.nodeSize());
		
	}
	
	@Test
	void testIsConnected() {
		assertTrue(algo.isConnected());
		
		g.removeEdge(1, 3);
		g.removeEdge(2, 3);
		g.removeEdge(3, 2);

		assertFalse(algo.isConnected());
	}

	@Test
	void testShortestPathDist() {

		assertEquals(10, algo.shortestPathDist(1, 2));
		assertEquals(30, algo.shortestPathDist(2, 1));
		assertEquals(50, algo.shortestPathDist(3, 1));

	}

	@Test
	void testShortestPath() {
		g.removeEdge(1, 3);
		List<node_data> actual = algo.shortestPath(1, 3);
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		for(int i=0;i<expected.size();i++) {
			int ex = expected.get(i);
		
			int ac = actual.get(i).getKey();
			
			assertEquals(ex, ac);
		}
	}

	@Test
	void testTSP() {
		
		g.removeEdge(1, 3);
		ArrayList<Integer> targets = new ArrayList<>();
		targets.add(1);
		targets.add(3);

		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		
		List<node_data> actual = algo.TSP(targets);
		
	
		for(int i=0;i<expected.size();i++) {
			int ex = expected.get(i);
			int ac = actual.get(i).getKey();
			assertEquals(ex, ac);
		}
		
	}

	@Test
	void testCopy() {
		graph copy = algo.copy();
		for (node_data n : g.getV()) {
			assertEquals(n, copy.getNode(n.getKey()));
		}
	}
}
