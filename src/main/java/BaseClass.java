import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.CoreMatchers;
import java.io.IOException;
import static io.restassured.RestAssured.given;


/**
 * Created by Osanda on 7/12/2017.
 */


public class BaseClass {
    
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request = getRequestSpecification();
    public String SERVER_HOST = System.getenv("server_host");
    private String GOOGLE_BOOKS_HOST = System.getenv("google_books_host");
    public String AUTHORIZATION_HEADER_NAME = System.getenv("header_name_for_authorization");
    
    public RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON);
    }
    
    public void printApiEndpoint(String apiEndpoint) {
        System.out.println("API Endpoint is: " + "\n" + apiEndpoint);
        Gauge.writeMessage("API Endpoint is: " + "\n" + apiEndpoint);
    }
    
    public void invokeApi(String apiEndpointName) throws IOException {
        setValueToDataStore("API_NAME", apiEndpointName);
        // Print API Endpoint
        printApiEndpoint(ApiEndpoints.getApiEndpontByName(apiEndpointName));
    }
    
    public static void printRequest(String request) {
        System.out.println("Request is: " + "\n" + request);
        Gauge.writeMessage("Request is: " + "\n" + request);
    }
    
    public void printResponse() {
        if (response.prettyPrint().toString().equals("")) {
            System.out.println("Response is empty for the given payload");
            Gauge.writeMessage("Response is empty for the given payload");
        }
        else {
            System.out.println("Response is: " + "\n" + response.prettyPrint());
            Gauge.writeMessage("Response is: " + "\n" + response.prettyPrint());
        }
    }
    
    public void postAPI(String jsonPayload) throws IOException {
        String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
        // Executing API and getting the response
        response = given()
                .contentType("application/json")
                .body(jsonPayload)
                .when()
                .post(SERVER_HOST.concat(ApiEndpoints.getApiEndpontByName(apiName)));
        printResponse();
    }
    
    public void postAPI(String apiEndpoint, String jsonPayload) {
        response = given()
                .contentType("application/json")
                .body(jsonPayload)
                .when()
                .post(SERVER_HOST.concat(apiEndpoint));
        printResponse();
    }
    
    public void postAPIWithAuth(String jsonPayload, String headerName, String headerValue) throws IOException {
        String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
        // Executing API and getting the response
        response = given()
                .contentType("application/json")
                .header(headerName, headerValue) //Some API contains headers to run with the API
                .body(jsonPayload)
                .when()
                .post(ApiEndpoints.getApiEndpontByName(apiName));
        printResponse();
    }
    
    public void postAPIWithAuth(String jsonPayload, String headerValue) throws IOException {
        String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
        // Executing API and getting the response
        response = given()
                .contentType("application/json")
                .header(AUTHORIZATION_HEADER_NAME, headerValue) //Some API contains headers to run with the API
                .body(jsonPayload)
                .when()
                .post(ApiEndpoints.getApiEndpontByName(apiName));
        printResponse();
    }
    
    public void postAPIWithAuth(String apiEndpoint, String jsonPayload, String headerName, String headerValue) throws IOException {
        response = given()
                .contentType("application/json")
                .header(headerName, headerValue) //Some API contains headers to run with the API
                .body(jsonPayload)
                .when()
                .post(ApiEndpoints.getApiEndpontByName(apiEndpoint));
        printResponse();
    }
    
    public void getAPI(String apiEndpoint, String queryParameters, String queryValues) throws IOException {
        response = request
                .given()
                .queryParam("q", queryParameters + queryValues)
                .when()
                .get(GOOGLE_BOOKS_HOST.concat(apiEndpoint));
        printResponse();
    }
    
    public void getAPI(String queryParameters, String queryValues) throws IOException {
        String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
        response = request
                .given()
                .queryParam("q", queryParameters + queryValues)
                .when()
                .get(SERVER_HOST.concat(ApiEndpoints.getApiEndpontByName(apiName)));
        printResponse();
    }
    
    public void getAPIWithAuth(String apiEndpoint, String headerValue, String queryParameters, String queryValues) {
        response = request
                .given()
                .header(AUTHORIZATION_HEADER_NAME, headerValue) //Some API contains headers to run with the API
                .queryParam("q", queryParameters + queryValues)
                .when()
                .get(SERVER_HOST.concat(apiEndpoint));
        printResponse();
    }
    
    public void getAPIWithAuth(String headerValue) throws IOException {
        String apiName = getValueFromDataStore("API_NAME"); // Fetching Value from the Data Store
        response = request
                .given()
                .header(AUTHORIZATION_HEADER_NAME, headerValue) //Some API contains headers to run with the API
                .when()
                .get(SERVER_HOST.concat(ApiEndpoints.getApiEndpontByName(apiName)));
        printResponse();
    }
    
    public ValidatableResponse verifyStatusCode(int statusCode) {
        json = response.then().statusCode(statusCode);
        return json;
    }
    
    // Asserts on JSON fields with single values
    public void responseEquals(Table responseFields){
        for(TableRow row : responseFields.getTableRows()){
            Gauge.writeMessage(row.getCell("Key" + " | " + row.getCell("Value")));
            if(StringUtils.isNumeric(row.getCell("Value"))){
                if(row.getCell("Value").equals("null")) {
                    json.body(row.getCell("Value"), CoreMatchers.equalTo(null));
                } else {
                    json.body(row.getCell("Key"), CoreMatchers.equalTo(Integer.parseInt(row.getCell("Value"))));
                }
            } else {
                if(row.getCell("Value").equals("null")) {
                    json.body(row.getCell("Value"), CoreMatchers.equalTo(null));
                } else {
                    json.body(row.getCell("Key"), CoreMatchers.equalTo(row.getCell("Value")));
                }
            }
        }
    }
    
    public static String getValueFromDataStore(String variableNameOfValueStoredInDataStore) {
        // Fetching Value from the Data Store
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
        return (String) scenarioStore.get(variableNameOfValueStoredInDataStore);
    }
    
    public static void setValueToDataStore(String variableNameOfValueToBeStoredInDataStore, String valueToBeStoredInDataStore) {
        // Adding value to the Data Store
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore();
        scenarioStore.put(variableNameOfValueToBeStoredInDataStore, valueToBeStoredInDataStore);
    }
    
    
}
