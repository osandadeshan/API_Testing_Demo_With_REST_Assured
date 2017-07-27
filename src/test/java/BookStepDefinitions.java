import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;


/**
 * Created by Osanda on 7/12/2017.
 */


public class BookStepDefinitions extends BaseClass{
	
	private Response response;
	private ValidatableResponse json;
	public RequestSpecification request;
	private String VOLUMES_API_ENDPOINT = "/books/v1/volumes";
	
	@Step("Given a book exists with an isbn of <isbn>")
	public void aBookExistsWithIsbn(String isbn){
		request = given().queryParam("q","isbn:" + isbn);
	}
	
	@Step("When a user retrieves the book by isbn of <isbn>")
	public void aUserRetrievesBookWithIsbn(String isbn) throws IOException {
		getAPI(VOLUMES_API_ENDPOINT, "isbn:", isbn);
	}
	
	@Step("Then the status code for retrieving book request is <statusCode>")
	public void verifyResponseStatusCode(int statusCode){
		json = verifyStatusCode(statusCode);
	}
	
	// Asserts on JSON fields with single values
	@Step("And the response for retrieving book request contains the following <responseFields>")
	public void responseContains(Table responseFields){
		responseEquals(responseFields);
	}
	
	// Asserts on JSON Arrays
	@Step("And the response for retrieving book request contains the following information in any order <table>")
	public void responseContainsInAnyOrder(Table responseFields){
		responseEquals(responseFields);
	}
	
	
}
