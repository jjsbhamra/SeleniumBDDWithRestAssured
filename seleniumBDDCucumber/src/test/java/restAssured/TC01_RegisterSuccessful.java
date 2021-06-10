package restAssured;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Method;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TC01_RegisterSuccessful {

	@SuppressWarnings("unchecked")
	@Test
	void loginSuccessful() throws IOException{
		String jsonBody = generateStringFromResource("C:\\projects\\workspace\\seleniumBDDCucumber\\Drivers\\utilities\\RegisterSuccessful.json");
		baseURI="https://reqres.in/";
		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");
		System.out.println("Json body provided in payload: "+ jsonBody);
		
		System.out.println(request.toJSONString());
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
				accept(ContentType.JSON).
			body(jsonBody).
		when()
		.request(Method.POST, "/api/register").
		then().
			statusCode(200).
		log().
			all();
	}
	public String generateStringFromResource(String path) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(path)));
	}
}