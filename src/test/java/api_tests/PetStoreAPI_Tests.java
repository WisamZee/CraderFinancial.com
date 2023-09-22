package api_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PetStoreAPI_Tests {
	
	String url = "https://petstore.swagger.io/v2";
	Response 	response ;
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
		
	
}
