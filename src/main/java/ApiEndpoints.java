import java.io.IOException;


/**
 * Created by Osanda on 7/17/2017.
 */


public abstract class ApiEndpoints extends BaseClass{
	
	public static String getApiEndpontByName(String apiEndpointName) throws IOException {
		return ReadDataFromApiDoc.getAPIEndpoint(apiEndpointName);
	}
	
	
}
