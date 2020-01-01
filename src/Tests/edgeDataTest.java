package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import utils.edgeData;

class edgeDataTest {

	static edgeData edge;
	static int src = 1;
	static int dest = 2;
	static double weight = 10;

	@BeforeAll
	static void createEdge() {
		edge = new edgeData(src,dest,weight);
	}

	@Test
	void checkSrc() {
		assertEquals(src, edge.getSrc());
	}

	@Test
	void checkDest() {
		assertEquals(dest, edge.getDest());
	}

	@Test
	void checkWeight() {
		assertEquals(weight, edge.getWeight());
	}

	@Test
	void checkInfo() {
		String info = "test info";
		edge.setInfo(info);
		assertEquals(info, edge.getInfo());
	}

	@Test
	void checkTag() {
		int t = 1;
		edge.setTag(t);
		assertEquals(t, edge.getTag());
	}
}
