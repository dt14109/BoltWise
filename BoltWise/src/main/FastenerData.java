package src.main;

/**
 * @author Darrin Donahue
 * This class is our data
 */
public class FastenerData {
	private String type; 	// It's a String so we can add other types in the future (currently bolt or screw)
	private String length; 	// It's a String to make sizes such as 5/8 easy to recognize
	private String material;// Such as steel or cooper
	private String grade; 	// Grade 8, Grade C, etc...
	private String finish;	// Chrome, Plain, etc...
	private String name;	// Just about anything
	private String SKU;		// Unique identifier
	private Integer quantity; // Has to be 0 and above
	private String URL;

	/**
	 * Constructor
	 * @param type
	 * @param length
	 * @param material
	 * @param grade
	 * @param finish
	 * @param name
	 * @param sKU
	 * @param quantity
	 * @param uRL
	 */
	public FastenerData(String type, String length, String material, String grade, String finish, String name,
			String sKU, Integer quantity, String uRL) {
		this.type = type;
		this.length = length;
		this.material = material;
		this.grade = grade;
		this.finish = finish;
		this.name = name;
		SKU = sKU;
		this.quantity = quantity;
		URL = uRL;
	}
	
	/**
	 * The only getter we need
	 * @return
	 */
	public String getSKU() {
		return SKU;
	}
}
