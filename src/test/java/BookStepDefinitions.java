import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang.StringUtils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by Osanda on 7/12/2017.
 */


public class BookStepDefinitions {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private String BOOKS_SPECIFICATION_HOST = System.getenv("books_specification_host");
	
	@Step("Given a book exists with an isbn of <isbn>")
	public void aBookExistsWithIsbn(String isbn){
		request = given().queryParam("q","isbn:" + isbn);
	}
	
	@Step("When a user retrieves the book by isbn")
	public void aUserRetrievesBookWithIsbn(){
		response = request.when().get(BOOKS_SPECIFICATION_HOST);
		Gauge.writeMessage("Response is " + response.prettyPrint());
	}
	
	@Step("Then the status code is <statusCode>")
	public void verifyStatusCode(int statusCode){
		json = response.then().statusCode(statusCode);
	}
	
	// Asserts on JSON fields with single values
	@Step("And Response contains the following <responseFields>")
	public void responseEquals(Table responseFields){
		for(TableRow row : responseFields.getTableRows()){
			Gauge.writeMessage(row.getCell("Key" + " | " + row.getCell("Value")));
				if(StringUtils.isNumeric(row.getCell("Value"))){
					json.body(row.getCell("Key"), equalTo(Integer.parseInt(row.getCell("Value"))));
				} else {
					json.body(row.getCell("Key"), equalTo(row.getCell("Value")));
			}
		}
	}
	
	// Asserts on JSON Arrays
	@Step("And Response contains the following in any order <table>")
	public void responseContainsInAnyOrder(Table responseFields){
		for(TableRow row : responseFields.getTableRows()){
			Gauge.writeMessage(row.getCell("Key" + " | " + row.getCell("Value")));
				if(StringUtils.isNumeric(row.getCell("Value"))){
					json.body(row.getCell("Key"), equalTo(Integer.parseInt(row.getCell("Value"))));
				} else {
					json.body(row.getCell("Key"), equalTo(row.getCell("Value")));
			}
		}
	}
	
}
