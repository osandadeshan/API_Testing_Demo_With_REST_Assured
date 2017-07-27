import java.io.IOException;


/**
 * Created by Osanda on 7/14/2017.
 */


public abstract class CreateHospitalApiJsonRequestsCreator extends BaseClass{
	
	public static String setJsonBodyForHospitalCreateRequest(String hospitalId, String hospitalName) throws IOException {
		String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
		String request = ReadDataFromApiDoc.getRequestTemplate(apiName);
		String replaceWithValueForHospitalId = request.replaceAll("#hospitalId", hospitalId);
		String replaceWithValueForHospitalName = replaceWithValueForHospitalId.replaceAll("#hospitalName", hospitalName);
		String finalJsonRequestBody = replaceWithValueForHospitalName;
		printRequest(finalJsonRequestBody);
		return finalJsonRequestBody;
	}
	
	
}
