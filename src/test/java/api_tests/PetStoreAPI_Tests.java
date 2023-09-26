package api_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.RsetApiUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PetStoreAPI_Tests {
	
	String url = "https://petstore.swagger.io/v2";
	Response 	response ;
	int petid;
		@Test
		public void getPetsByStatus() {
		
		String endpoint = "/pet/findByStatus";

		response = RestAssured
		
		.given()
					.accept(ContentType.JSON)
					.param("status", "sold")
		.when()	.get(url+endpoint);
		
		response.then()
					.statusCode(200)
					.contentType("application/json");
		response.prettyPrint();
		
						
	}
		@Test
		public void getApetByID() {
			String endPoint = "/pet/";
			
			response = RestAssured
					.given()
								.accept(ContentType.JSON)
					.when()	.get(url+endPoint+"7411");
			
			
		response.then()
								.statusCode(200)
								.contentType("application/json");
								response.prettyPrint();
			
						//		response.jsonPath().get("id");
								
								System.out.println(response.path("name").toString());
								System.out.println(response.jsonPath().get("id").toString());
								Assert.assertEquals(response.jsonPath().get("id").toString(), "7411");
								
								
								
		}
		@Test
		public void create_a_pet () {
			RsetApiUtils apiUtils = new RsetApiUtils ();
		// request URL
		String endpoint = "/pet";
		// request header
		// request method
		// request body
		petid = apiUtils. randomNumber ( ) ;
		String payload  ="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		response = RestAssured
				.given()
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
				.when().post(url+endpoint);
		
		
		}
		
		
		
		
		
		
		
		
}
