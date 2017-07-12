import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


/**
 * Created by Osanda on 7/12/2017.
 */


public class BaseClass {
    
    public RequestSpecification getRequestSpecification(){
        return RestAssured.given().contentType(ContentType.JSON);
    }
    
}
