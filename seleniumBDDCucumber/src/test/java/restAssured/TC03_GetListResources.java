package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
public class TC03_GetListResources {

	@Test 
	void getListForResouces() {
		baseURI="https://reqres.in/api";
		//Below creating a Request object for GET method
		RequestSpecification httprequest = given();
		//Response Object
		Response response = httprequest.request(Method.GET, "/unknown");
		//Print Response in console
		String responseBody= response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		//Status code validations
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);
	}
	@Test
	void getResponsThenValidateIdAndName() {
		baseURI="https://reqres.in/api";
		given()
		.request(Method.GET, "/unknown")
	  		.then().assertThat().
	  			body("data.id[0]", equalTo(1));
		given()
		.request(Method.GET, "/unknown")
	  		.then().assertThat().
	  			body("data.name[0]", equalTo("cerulean")).log().all();
	}
}