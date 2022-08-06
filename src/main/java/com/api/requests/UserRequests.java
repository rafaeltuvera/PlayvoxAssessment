package com.api.requests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class UserRequests {


	public String getToken(String payload, String endpoint) {
		
		return  given().contentType(ContentType.JSON)
				.body(payload)
				.expect().defaultParser(Parser.JSON)
				.when()
				.post(endpoint)
				.then().log().all().assertThat().statusCode(200)
				.extract()
				.response()
				.jsonPath()
				.getString("data.Token");
	}
	
	public Response getUser(String endpoint, String id, String token) {
		
		return  given()
				.header("authorization", "Basic " + token)
				.contentType(ContentType.JSON)
				.pathParam("id", id)
				.expect().defaultParser(Parser.JSON)
				.when()
				.get(endpoint)
				.then().log().all().assertThat().statusCode(200)
				.extract()
				.response();
	}
	
	//post new user with invalid token -> 401 unauthorized
	public Response POSTnewUserNoAuth(String payload, String endpoint) {

		return  given()
				.contentType(ContentType.JSON)
				.body(payload)
				.expect().defaultParser(Parser.JSON)
				.when()
				.post(endpoint)
				.then().log().all().assertThat().statusCode(401)
				.extract()
				.response();
	}
	//post valid user
	public String POSTnewUser(String payload, String endpoint, String token) {

		return  given()
				.header("authorization", "Basic " + token)
				.contentType(ContentType.JSON)
				.body(payload)
				.expect().defaultParser(Parser.JSON)
				.when()
				.post(endpoint)
				.then().log().all().assertThat().statusCode(201)
				.extract()
				.response()
				.jsonPath()
				.getString("id");
	}

	//post same user 400 bad req
	public Response POSTExistingUser(String payload, String endpoint, String token) {

		return  given()
				.header("authorization", "Basic " + token)
				.contentType(ContentType.JSON)
				.body(payload)
				.expect().defaultParser(Parser.JSON)
				.when()
				.post(endpoint)
				.then().log().all().assertThat().statusCode(400)
				.extract()
				.response();
	}

	//post user with invalid payload -> 500 internal
	public Response POSTInvalidPayload(String payload, String endpoint, String token) {

		return  given()
				.header("authorization", "Basic " + token)
				.contentType(ContentType.JSON)
				.body(payload)
				.expect().defaultParser(Parser.JSON)
				.when()
				.post(endpoint)
				.then().log().all().assertThat().statusCode(500)
				.extract()
				.response();
	}
}
