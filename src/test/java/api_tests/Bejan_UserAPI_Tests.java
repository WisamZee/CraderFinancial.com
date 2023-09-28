package api_tests;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utils.RestApiUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Create a new class called "UserAPI_Tests".
public class Bejan_UserAPI_Tests {
//		Go to petstore.swagger.io and locate the user api documentation.
//	Using RestAssured and TestNG:
	String baseurl = "https://petstore.swagger.io/v2";
	Faker faker = new Faker();

	Response response;
	RestApiUtils apiutils;
	String username;
	@Test
	public void TestCase_1_NewUser() {
		
		username = faker.name().username();
		String pass  = "pass123";
		String endpoind = "/user";
		
		String body =  "{\r\n"
				+ "  \"id\": "+123456+",\r\n"
				+ "  \"username\": \""+username+"\",\r\n"
				+ "  \"firstName\": \""+faker.name().firstName()+"\",\r\n"
				+ "  \"lastName\": \""+faker.name().lastName()+"\",\r\n"
				+ "  \"email\": \""+faker.name().fullName()+"\",\r\n"
				+ "  \"password\": \""+pass+"\",\r\n"
				+ "  \"phone\": \""+faker.phoneNumber().toString()+"\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}";
		
//		Perform a POST request to create a new user.

	response = RestAssured
			.given()
			.header("Content-Type", "application/json")
			.header("Accept", "application/json")
			.body(body)
			.when()
			.post(baseurl + endpoind);
//	Verify the status code is 200.
//	Verify the content type is application.json.
	response.then()
	.contentType("application/json")
	.statusCode(200);
	
	response.prettyPrint();
System.out.println(username+"Test case 1");
		
}

@Test (dependsOnMethods =  "TestCase_1_NewUser")
public void TestCase_2_NewUser () {
	String endpoind = "/user/";
	response = RestAssured
			.given()
			.header("Accept", "application/json")
			.when()
			.get(baseurl + endpoind + username);
		response.then()
		.statusCode(200)
		.contentType("application/json");
		response.prettyPrint();
	




	
	
	
}
	
	
	
	
}
