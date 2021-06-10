package restAssured;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Method;

import static io.restassured.RestAssured.*;

public class TC02_LoginSuccessful {

	@SuppressWarnings("unchecked")
	@Test
	void loginSuccessful() {
		 baseURI="https://reqres.in/";
		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");
		// System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
				accept(ContentType.JSON).
			body(request.toJSONString()).
		when()
		.request(Method.POST, "/api/login").
		then().
			statusCode(200).
		log().
			all();
	}
}