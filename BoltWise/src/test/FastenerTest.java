/**
 * 
 */
package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import src.main.FastenerDataEndpoint;
import src.main.FastenerDataProcessor;
import src.main.FastenerData;

/**
 * @author Darrin Donahue
 *
 */
class FastenerTest {
	FastenerDataEndpoint endpoint = new FastenerDataEndpoint();
	
	@Test
	void noItems() {
		FastenerDataProcessor.clear();
		// do immediate return without any data
		List<FastenerData> result = endpoint.getAllData();
		assertEquals(result.size(), 0);
	}

	@Test
	void nullSKU() {
		FastenerDataProcessor.clear();
		// try to insert an item with a null SKU
		FastenerData data = new FastenerData("type", "length", "material", "grade", "finish", "name", null, 10, "uRL");
		endpoint.insertData(data);
		List<FastenerData> result = endpoint.getAllData();
		assertEquals(result.size(), 0);
	}

	@Test
	void blankSKU() {
		FastenerDataProcessor.clear();
		// try to insert an item with a blank SKU
		FastenerData data = new FastenerData("type", "length", "material", "grade", "finish", "name", "", 10, "uRL");
		endpoint.insertData(data);
		List<FastenerData> result = endpoint.getAllData();
		assertEquals(result.size(), 0);		
	}

	@Test
	void threeItems() {
		FastenerDataProcessor.clear();
		// Insert 3 items and then read them
		FastenerData data = new FastenerData("type", "length", "material", "grade", "finish", "name", "a", 10, "uRL");
		endpoint.insertData(data);
		FastenerData data1 = new FastenerData("type", "length", "material", "grade", "finish", "name", "b", 20, "uRL");
		endpoint.insertData(data1);
		FastenerData data2 = new FastenerData("type", "length", "material", "grade", "finish", "name", "c", 30, "uRL");
		endpoint.insertData(data2);
		List<FastenerData> result = endpoint.getAllData();
		assertEquals(result.size(), 3);		
	}

	@Test
	void fourItems() {
		FastenerDataProcessor.clear();
		// Insert 4 items, but 2 are the same and then read them
		FastenerData data = new FastenerData("type", "length", "material", "grade", "finish", "name", "a", 10, "uRL");
		endpoint.insertData(data);
		endpoint.insertData(data);
		FastenerData data1 = new FastenerData("type", "length", "material", "grade", "finish", "name", "b", 20, "uRL");
		endpoint.insertData(data1);
		FastenerData data2 = new FastenerData("type", "length", "material", "grade", "finish", "name", "c", 30, "uRL");
		endpoint.insertData(data2);
		List<FastenerData> result = endpoint.getAllData();
		assertEquals(result.size(), 3);
	}
}
