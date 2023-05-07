package src.main;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Darrin Donahue
 * Class to process the FastenerData
 */
public class FastenerDataProcessor {
	private static final String INVALID_SKU = "Empty or null SKU is not allowed";
	private static final String INSERTED = "Data inserted";
	
	// Thread Safe Map of our data with SKU as our key
	private static Map<String, FastenerData> map = new ConcurrentHashMap<>();
	
	/**
	 * Insert an item.  Check the SKU to see if it already exists
	 */
	public static String insertData(String SKU, FastenerData fastenerData) {
		if(Objects.isNull(SKU) || SKU.isBlank()) {
			return INVALID_SKU;
		}
		map.put(SKU, fastenerData); // Thread safe so do not have to worry about separate threads
		return INSERTED;
	}

	/**
	 * Return all the data
	 * @return map
	 */
	public static Map<String, FastenerData> getAllData() {
		return map;
	}

	/**
	 * Clear the data (This is here for testing purposes)
	 */
	public static void clear() {
		map.clear();
	}}
