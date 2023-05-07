package src.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Darrin Donahue
 * Endpoint to insert and read data
 */
public class FastenerDataEndpoint {
	/**
	 * Insert the data
	 * @param data
	 * @return String, either success or failure
	 */
// A Post would do something like this:	
//	  @POST
//    @Path("insert")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Insert an item")
//    @ApiResponses({
//        @ApiResponse(code=200, message="Data Inserted", response=String),
//        @ApiResponse(code=403, message="Forbidden"),
//        @ApiResponse(code=500, message="Error Processing Message")
//    })
//    public void insertData(@ApiParam(value="message details", required=true) final FastenerData data) {
	public String insertData(FastenerData data) {
    	return FastenerDataProcessor.insertData(data.getSKU(), data);
    } 

    /**
     * Get all the data as a List
     */
 // A Get would do something like this:	
//    @GET
//    @Path("getall")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value = "Return the data as a List")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Success", response = FastenerData.class, responseContainer = "List"),
//            @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "Not Found")
//    })
   public List<FastenerData> getAllData() {
	   // Map of key-value pairs isn't that nice.  We'll return a List which has everything, including SKU
	   Map<String, FastenerData> map = FastenerDataProcessor.getAllData();
	   List<FastenerData> data = map.values().stream().collect(Collectors.toList());
	   return data;
   }	
}
