package api_tests;

import Utils.RestApiUtils;
import Utils.TestDataReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class CarterApiWithBejan {
	Response response;
	RestApiUtils apiutils;
	String token;
	String id;
	String 	cuName ;
	String 	cuMail ;
	String baseurl = "http://crater.primetech-apps.com/";
	
	@Test
	public void craterLogin() {
		
	String endpoint = "api/v1/auth/login";
	String username = TestDataReader.getProperty("email");
	String password = TestDataReader.getProperty("password");
	
	Map<String, Object> requestHeaders = new HashMap<>();
	requestHeaders.put("accept", "application/json");
	requestHeaders.put("Content-Type", "application/json");
	requestHeaders.put("company", "1");
	
	Map<String, Object> requestBody = new HashMap<>();
	requestBody.put("username", username);
	requestBody.put("password", password);
	requestBody.put("device_name", "mobile_app");
	
	response = RestAssured.given()
		.headers(requestHeaders)
		.body(requestBody)
	.when()
		.post(baseurl+endpoint);
	
	response.then()
		.statusCode(200)
		.contentType("application/json");
	
	response.prettyPrint();
	
	token = response.path("token").toString();
	
	Assert.assertEquals(response.path("type").toString(), "Bearer");

		
	}
	@Test (dependsOnMethods = "craterLogin")
	public void ListAllCustomer() {
		String endpoint = "api/v1/customers";
		Map<String, Object> requestHeaders = new HashMap<>();
		requestHeaders.put("accept", "application/json");
		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("company", "1");
		requestHeaders.put("Authorization", "Bearer " + token);
	
		response = RestAssured.given()
				.param("limit","15")
				.headers(requestHeaders)
				.when()
				.get(baseurl + endpoint);
		response.then()
		.statusCode(200)
		.contentType("application/json");
		response.prettyPrint();
		
	}
	
	@Test (dependsOnMethods = "craterLogin")
	public void newCustomer() {
		String endpoint = "api/v1/customers";
		Faker faker = new Faker();
	cuName = faker.name().firstName();
	cuMail = faker.name().firstName()+"@gamil.com";
	
	Map<String, Object> requestHeaders = new HashMap<>();
	requestHeaders.put("accept", "application/json");
	requestHeaders.put("Content-Type", "application/json");
	requestHeaders.put("company", "1");
	requestHeaders.put("Authorization", "Bearer " + token);
	
	Map<String, Object> requestBody = new HashMap<>();
	requestBody.put("name", cuName);
	requestBody.put("email", cuMail);
	requestBody.put("enable_portal", true);

	response = RestAssured.given()
			.headers(requestHeaders)
			.body(requestBody)
			.when()
			.post(baseurl + endpoint);
	response.prettyPrint();
	
	response.then()
	.statusCode(200)
	.contentType("application/json");
	 id = response.path("data.id").toString();
	
	Assert.assertEquals(response.path("data.name").toString(), cuName);
	Assert.assertEquals(response.path("data.email").toString(), cuMail);
	Assert.assertTrue(response.path("data.enable_portal"));

	}
	@Test (dependsOnMethods = "newCustomer")
	public void RetrieveCustomer() {
		String endpoint = "api/v1/customers/";
		
		Map<String, Object> requestHeaders = new HashMap<>();
		requestHeaders.put("accept", "application/json");
		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("company", "1");
		requestHeaders.put("Authorization", "Bearer " + token);
		
		response = RestAssured.given()
				.headers(requestHeaders)
				.when()
				.get(baseurl + endpoint + id);
		response.prettyPrint();
		
		response.then()
		.statusCode(200)
		.contentType("application/json");
		
		Assert.assertEquals(response.path("data.name").toString(), cuName);
		Assert.assertEquals(response.path("data.email").toString(), cuMail);
		
		
	}
	@Test (dependsOnMethods = "newCustomer")
	public void Update_a_Customer() {
		String endpoint = "api/v1/customers/";
		
		Map<String, Object> requestHeaders = new HashMap<>();
		requestHeaders.put("accept", "application/json");
		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("company", "1");
		requestHeaders.put("Authorization", "Bearer " + token);
	
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("name", cuName);
		requestBody.put("email", cuMail);
		requestBody.put("enable_portal", false);
		
		response = RestAssured.given()
				.headers(requestHeaders)
				.body(requestBody)
				.when()
				.put(baseurl + endpoint + id);
		response.prettyPrint();
		
		response.then()
		.statusCode(200)
		.contentType("application/json");
		 id = response.path("data.id").toString();
		
		Assert.assertEquals(response.path("data.name").toString(), cuName);
		Assert.assertEquals(response.path("data.email").toString(), cuMail);
		Assert.assertFalse(response.path("data.enable_portal"));
	
	
	
	
	}
	
}

