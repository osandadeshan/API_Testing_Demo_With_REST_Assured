import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import io.restassured.response.ValidatableResponse;
import java.io.IOException;


/**
 * Created by Osanda on 7/13/2017.
 */


public class POSTMethod extends BaseClass{
	
	public ValidatableResponse json;
	
//	@Step("Given that the user invokes <apiEndpointName>")
//	public void invokeApi(String apiEndpointName) throws IOException {
//		// Adding value to the Data Store
//		DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
//		scenarioStore.put("API_NAME", apiEndpointName);
//		// Print API Endpoint
//		printApiEndpoint(ApiEndpoints.getApiEndpontByName(apiEndpointName));
//	}
	
	@Step("When the user invokes the login API with valid username as <username> and valid password as <password>")
	public void responseForLoginApi(String username, String password) throws IOException {
		String JsonPayloadForLogin = JsonRequestsCreator.setJsonBodyForLoginRequest(username,password);
		// Executing API and getting the response
		postAPI(JsonPayloadForLogin);
	}
	
	@Step("Then the status code for login with valid credentials is <statusCode>")
	public void verifyResponseStatusCode(int statusCode){
		json = verifyStatusCode(statusCode);
	}
	
	// Asserts on JSON fields with single values
	@Step("And Response should contains the following <responseFields>")
	public void responseContains(Table responseFields){
		responseEquals(responseFields);
	}
	
	// Asserts on JSON Arrays
	@Step("And Response should contains the following in any order <table>")
	public void responseContainsInAnyOrder(Table responseFields){
		responseEquals(responseFields);
	}
	
	
}
