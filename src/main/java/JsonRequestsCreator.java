import java.io.IOException;


/**
 * Created by Osanda on 7/14/2017.
 */


public abstract class JsonRequestsCreator extends BaseClass{
	
	public static String setJsonBodyForLoginRequest(String username, String password) throws IOException {
		String request = ReadDataFromApiDoc.getRequestTemplate(ApiNames.LOGIN_API_NAME);
		String replaceWithValueForUsername = request.replaceAll("#username", username);
		String replaceWithValueForPassword = replaceWithValueForUsername.replaceAll("#password", password);
		String finalJsonRequestBody = replaceWithValueForPassword;
		printRequest(finalJsonRequestBody);
		return finalJsonRequestBody;
	}
	
	public static String setJsonBodyForHospitalCreateRequest(String hospitalId, String hospitalName) throws IOException {
		String request = ReadDataFromApiDoc.getRequestTemplate(ApiNames.HOSPITAL_CREATE_NAME);
		String replaceWithValueForHospitalId = request.replaceAll("#hospitalId", hospitalId);
		String replaceWithValueForHospitalName = replaceWithValueForHospitalId.replaceAll("#hospitalName", hospitalName);
		String finalJsonRequestBody = replaceWithValueForHospitalName;
		printRequest(finalJsonRequestBody);
		return finalJsonRequestBody;
	}
	
	
}
