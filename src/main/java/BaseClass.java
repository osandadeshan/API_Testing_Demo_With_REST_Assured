import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.CoreMatchers;
import static io.restassured.RestAssured.given;


/**
 * Created by Osanda on 7/12/2017.
 */


public class BaseClass {
    
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request = getRequestSpecification();
    private String SERVER_HOST = System.getenv("server_host");
    private String GOOGLE_BOOKS_HOST = System.getenv("google_books_host");
    
    public RequestSpecification getRequestSpecification(){
        return RestAssured.given().contentType(ContentType.JSON);
    }
    
    public void postAPI(String API_ENDPOINT, String JsonPayload){
        response = given()
                .contentType("application/json").
                        body(JsonPayload).
                        when().
                        post(SERVER_HOST.concat(API_ENDPOINT));
        System.out.println(response.prettyPrint());
        Gauge.writeMessage(response.prettyPrint());
    }
    
    public void getAPI(String API_ENDPOINT, String queryParameters, String queryValues){
        response = request.given().queryParam("q",queryParameters + queryValues).when().get(GOOGLE_BOOKS_HOST.concat(API_ENDPOINT));
        System.out.println("Response is " + response.prettyPrint());
        Gauge.writeMessage("Response is " + response.prettyPrint());
    }
    
    public ValidatableResponse verifyStatusCode(int statusCode){
        json = response.then().statusCode(statusCode);
        return json;
    }
    
    // Asserts on JSON fields with single values
    public void responseEquals(Table responseFields){
        for(TableRow row : responseFields.getTableRows()){
            Gauge.writeMessage(row.getCell("Key" + " | " + row.getCell("Value")));
            if(StringUtils.isNumeric(row.getCell("Value"))){
                json.body(row.getCell("Key"), CoreMatchers.equalTo(Integer.parseInt(row.getCell("Value"))));
            } else {
                json.body(row.getCell("Key"), CoreMatchers.equalTo(row.getCell("Value")));
            }
        }
    }
    
}
