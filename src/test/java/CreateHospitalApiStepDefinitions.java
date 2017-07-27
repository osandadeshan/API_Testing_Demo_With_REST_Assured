import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.ValidatableResponse;
import java.io.IOException;


/**
 * Created by Osanda on 7/18/2017.
 */


public class CreateHospitalApiStepDefinitions extends BaseClass{
	
	public ValidatableResponse json;
	String headerValue = "bearer 58EBG_TlpE9zoIB9O-AUOkDvYMjQj9T6rCdJE4uVhmp-Fx8lllhqq7_1VIaaMZ3Bk_BEubw6K6ecrMhLtiykQoZUsQo5KhVgfiobnpD1W6Jm79G62uKxHoiybv-Z38E2B6VFE4NZ0dxjtGlyWKYsY2amq1KP8aLOi4XCxqWevImP_i3PDiVhr0mrEFE3Xc2KBFd8e_CICZaIEwMbI3aGTw8_iTKxYsUBaU3jt8syQqeEYtbaV8-jXC6OybXB80nJBA9tAesq1pG1b38EFgohBP_Kljp4aB5N14rsLf4qlEHywUprDU2Y6Elr_bI6rKC0lk9tcQ";
	
	@Step("When the user invokes the Hospital Create API with valid details <hospitalId> and <hospitalName>")
	public void responseForHospitalCreateApi(String hospitalId, String hospitalName) throws IOException {
		String JsonPayloadForHospitalCreateRequest = CreateHospitalApiJsonRequestsCreator.setJsonBodyForHospitalCreateRequest(hospitalId, hospitalName);
		// Executing API and getting the response
		postAPIWithAuth(JsonPayloadForHospitalCreateRequest, headerValue);
	}
	
	@Step("Then the status code for creating hospital request is <statusCode>")
	public void verifyResponseStatusCode(int statusCode){
		json = verifyStatusCode(statusCode);
	}
	
	// Asserts on JSON Arrays
	@Step("And the response for creating hospital request contains the following information in any order <table>")
	public void responseContainsInAnyOrder(Table responseFields){
		responseEquals(responseFields);
	}
	
	
}
