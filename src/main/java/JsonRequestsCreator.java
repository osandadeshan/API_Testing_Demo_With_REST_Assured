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
	
	
}
