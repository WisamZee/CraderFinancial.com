package api_tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import Utils.RestApiUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//Create a new class called "UserAPI_Tests".
public class Bejan_UserAPI_Tests {
//		Go to petstore.swagger.io and locate the user api documentation.
//	Using RestAssured and TestNG:
	String baseurl = "https://petstore.swagger.io/v2";
	Faker faker = new Faker();

	Response response;
	RestApiUtils apiutils = new RestApiUtils();
	int id;
	String username;
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;

	
	@Test
	public void TestCase_1_NewUser() {
		String endpoint = "/user";
		id = apiutils.randomNumber();
		username = faker.name().username();
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
		email = firstName+lastName+"@gmail.com";
		password = "Pass123";
		phone = faker.phoneNumber().toString();
		
		String body = "{\n"
				+ "  \"id\": "+id+",\n"
				+ "  \"username\": \""+username+"\",\n"
				+ "  \"firstName\": \""+firstName+"\",\n"
				+ "  \"lastName\": \""+lastName+"\",\n"
				+ "  \"email\": \""+email+"\",\n"
				+ "  \"password\": \""+password+"\",\n"
				+ "  \"phone\": \""+phone+"\",\n"
				+ "  \"userStatus\": 0\n"
				+ "}";
//		Perform a POST request to create a new user.
	response = RestAssured
			.given()
			.header("Content-Type", "application/json")
			.header("Accept", "application/json")
			.body(body)
			.when()
			.post(baseurl + endpoint);
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
	String endpoint = "/user/";
	response = RestAssured
			.given()
			.header("Accept", "application/json")
			.when()
			.get(baseurl + endpoint + username);
		response.then()
		.statusCode(200)
		.contentType("application/json");
		response.prettyPrint();
		Assert.assertEquals(Integer.parseInt(response.jsonPath().get("id").toString()), id);
		Assert.assertEquals(response.jsonPath().get("username"), username);
		Assert.assertEquals(response.path("firstName").toString(), firstName);
		Assert.assertEquals(response.path("lastName").toString(), lastName);
		Assert.assertEquals(response.path("email").toString(), email);
		Assert.assertEquals(response.path("password").toString(), password);
		Assert.assertEquals(response.path("phone").toString(), phone);
}
@Test (dependsOnMethods =  "TestCase_2_NewUser")
public void TestCase_3_UserNotFound () {
	username = "SamZee";
	
	String endpoint = "/user/";
	response = RestAssured
			.given()
			.header("Accept", "application/json")
			.when()
			.get(baseurl + endpoint + username);
	response.then()
	.statusCode(404)
	.contentType("application/json");
	Assert.assertEquals(response.path("message").toString(), "User not found");
	Assert.assertEquals(response.path("type").toString(), "error");
	Assert.assertEquals(response.path("code").toString(), "1");
	response.prettyPrint();

}

@Test (dependsOnMethods =  "TestCase_1_NewUser")
public void TestCase_4_Login() {
//	 Perform a Get request to login the new user you just created.
	String endpoint = "/user/login?username=tanya.russel&password=Pass123";
	response = RestAssured
			.given()
			.header("Accept", "application/json")
			.param("username","username")
			.param("password","password")
			.when()
		   .get(baseurl + endpoint );
	
	response.then()
//	 Verify the content type is application.json.
	.contentType("application/json")
//	 Verify the status code is 200 .
	.statusCode(200);
//	 Verify the response message is not null.
	Assert.assertNotNull(response.jsonPath().get("message").toString());
						//	Assert.assertEquals(response.path("type").toString(), "unknown");
						//	Assert.assertEquals(response.path("code").toString(), "200");
//	 Print the response in console.
	response.prettyPrint();


}
	
@Test  (dependsOnMethods =  "TestCase_1_NewUser")
public void TestCase_5_logout() {
	String endpoint = "/user/logout";
	response = RestAssured
			.given()
			.header("Accept", "application/json")
			.when()
		   .get(baseurl + endpoint );
	response.then()
	.contentType("application/json")
	.statusCode(200);
	Assert.assertEquals(response.path("message").toString(), "ok");
response.prettyPrint();
}
@Test  (dependsOnMethods =  "TestCase_1_NewUser")
public void TestCase_5_UpdateUser() {
	
	String endpoint = "/user/" + username;
	int newId = apiutils.randomNumber();
	String newUsername = faker.name().username();
	String newFirstName = faker.name().firstName();
	String newlastName = faker.name().lastName();
	String newemail = firstName+lastName+"@gmail.com";
	String newpassword = "Pass123";
	String newphone = faker.phoneNumber().toString();
	
	Map<String, Object> requestHeaders = new HashMap<>();
	requestHeaders.put("accept", "application/json");
	requestHeaders.put("Content-Type", "application/json");
	
	Map<String, Object> requestBody = new HashMap<>();
	requestBody.put("id", newId);
	requestBody.put("username", newUsername);
	requestBody.put("firstName", newFirstName);
	requestBody.put("lastName", newlastName);
	requestBody.put("email", newemail);
	requestBody.put("password", newpassword);
	requestBody.put("phone", newphone);
	
	response = RestAssured.given()
		.headers(requestHeaders)
		.body(requestBody)
	.when()
		.put(baseurl+endpoint);
	
	response.then()
		.statusCode(200)
		.contentType("application/json");
	
	response.prettyPrint();
}

}
