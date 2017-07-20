import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.ValidatableResponse;
import java.io.IOException;


/**
 * Created by Osanda on 7/18/2017.
 */


public class POSTMethodWithAuth extends BaseClass{
	
	public ValidatableResponse json;
	String headerName = "Authorization";
	String headerValue = "bearer 6blg-dv8c7UQHDv8LDs00_HZ0sIcfYGn8eyfDLdzyTa_MEaC7p5fgHm2lpBCt6CRlocMVRu6fF9PwBFwXc_1E3W2FfiNDGak3TH5JJII5yRhaC-83hC1HoKagpsyrDmL4NBIvMii-W1mAVfxz06tXMw6-DXhkEqFcUN5MYFKROjFqgxdNDK9pfNBrBzIA-kLB6bMA20hh5BF3mzx46cZaRuTLWyl56UIT5yRdBAquJlf_I2BMTaaVeFVC8wWBJgADH8-jYrSgbVv78v6mtiTjF_Vd7s5GeTD6a1DGye-oZUP468PISIQqCi0EBNcbDXagNFwGA";
	
	@Step("When the user invokes the Hospital Create API with valid details <hospitalId> and <hospitalName>")
	public void responseForHospitalCreateApi(String hospitalId, String hospitalName) throws IOException {
		String JsonPayloadForHospitalCreateRequest = JsonRequestsCreator.setJsonBodyForHospitalCreateRequest(hospitalId, hospitalName);
		// Executing API and getting the response
		postAPIWithAuth(JsonPayloadForHospitalCreateRequest, headerName, headerValue);
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
