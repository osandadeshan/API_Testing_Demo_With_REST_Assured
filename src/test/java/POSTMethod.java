import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.ValidatableResponse;


/**
 * Created by Osanda on 7/13/2017.
 */


public class POSTMethod extends BaseClass{
	
	public ValidatableResponse json;
	private String LOGIN_API_ENDPOINT = "/Kraydel-server/rest/login";
	
	@Step("When the user invokes the login API with valid username as <username> and valid password as <password>")
	public void invokeLoginAPI(String username, String password){
		String JsonPayloadForLogin = "{" +
											"\"username\":\"" +username+ "\"," +
											"\"password\":\"" +password+ "\"" +
									  "}";
		postAPI(LOGIN_API_ENDPOINT, JsonPayloadForLogin);
	}
	
	@Step("Then the status code should be <statusCode>")
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
