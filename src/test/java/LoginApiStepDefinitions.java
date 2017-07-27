import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.ValidatableResponse;
import java.io.IOException;


/**
 * Created by Osanda on 7/13/2017.
 */


public class LoginApiStepDefinitions extends BaseClass{
	
	public ValidatableResponse json;
	
	@Step("When the user invokes the login API with a username as <username> and a password as <password>")
	public void responseForLoginApi(String username, String password) throws IOException {
		String JsonPayloadForLogin = LoginApiJsonRequestsCreator.setJsonBodyForLoginRequest(username,password);
		// Executing API and getting the response
		postAPI(JsonPayloadForLogin);
	}
	
	@Step("When the user trying to invoke the login API with valid username as <username> and null password")
	public void responseForLoginApiForNullPassword(String username) throws IOException {
		String JsonPayloadForLogin = LoginApiJsonRequestsCreator.setJsonBodyForInvalidLoginRequestUsingNullPassword(username);
		// Executing API and getting the response
		postAPI(JsonPayloadForLogin);
	}
	
	@Step("When the user trying to invoke the login API with null username and a password as <password>")
	public void responseForLoginApiForNullUsername(String password) throws IOException {
		String JsonPayloadForLogin = LoginApiJsonRequestsCreator.setJsonBodyForInvalidLoginRequestUsingNullUsername(password);
		// Executing API and getting the response
		postAPI(JsonPayloadForLogin);
	}
	
	@Step("When the user trying to invoke the login API with null username and null password")
	public void responseForLoginApiForNullUsernameNullPassword() throws IOException {
		String JsonPayloadForLogin = LoginApiJsonRequestsCreator.setJsonBodyForInvalidLoginRequestUsingNullUsernameNullPassword();
		// Executing API and getting the response
		postAPI(JsonPayloadForLogin);
	}
	
	@Step("Then the status code for login request is <statusCode>")
	public void verifyResponseStatusCode(int statusCode){
		json = verifyStatusCode(statusCode);
	}
	
	// Asserts on JSON fields with single values
	@Step("And the response for login request contains the following <responseFields>")
	public void responseContains(Table responseFields){
		responseEquals(responseFields);
	}
	
	
}
