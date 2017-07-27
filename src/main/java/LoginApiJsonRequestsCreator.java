import java.io.IOException;


/**
 * Created by Osanda on 7/14/2017.
 */


public abstract class LoginApiJsonRequestsCreator extends BaseClass{
	
	public static String setJsonBodyForLoginRequest(String username, String password) throws IOException {
		String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
		String request = ReadDataFromApiDoc.getRequestTemplate(apiName);
		String replaceWithValueForUsername = request.replaceAll("#username", username);
		String replaceWithValueForPassword = replaceWithValueForUsername.replaceAll("#password", password);
		String finalJsonRequestBody = replaceWithValueForPassword;
		printRequest(finalJsonRequestBody);
		return finalJsonRequestBody;
	}
	
	public static String setJsonBodyForInvalidLoginRequestUsingNullPassword(String username) throws IOException {
		String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
		String request = ReadDataFromApiDoc.getRequestTemplate(apiName);
		String replaceWithValueForUsername = request.replaceAll("#username", username);
		String replaceWithValueForPassword = replaceWithValueForUsername.replaceAll("\"#password\"", "null"); // Sets password as null
		String finalJsonRequestBody = replaceWithValueForPassword;
		printRequest(finalJsonRequestBody);
		return finalJsonRequestBody;
	}
	
	public static String setJsonBodyForInvalidLoginRequestUsingNullUsername(String password) throws IOException {
		String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
		String request = ReadDataFromApiDoc.getRequestTemplate(apiName);
		String replaceWithValueForUsername = request.replaceAll("\"#username\"", "null"); // Sets username as null
		String replaceWithValueForPassword = replaceWithValueForUsername.replaceAll("#password", password);
		String finalJsonRequestBody = replaceWithValueForPassword;
		printRequest(finalJsonRequestBody);
		return finalJsonRequestBody;
	}
	
	public static String setJsonBodyForInvalidLoginRequestUsingNullUsernameNullPassword() throws IOException {
		String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
		String request = ReadDataFromApiDoc.getRequestTemplate(apiName);
		String replaceWithValueForUsername = request.replaceAll("\"#username\"", "null"); // Sets username as null
		String replaceWithValueForPassword = replaceWithValueForUsername.replaceAll("\"#password\"", "null"); // Sets password as null
		String finalJsonRequestBody = replaceWithValueForPassword;
		printRequest(finalJsonRequestBody);
		return finalJsonRequestBody;
	}
	
	
}
