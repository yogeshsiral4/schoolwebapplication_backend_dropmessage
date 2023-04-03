package com.dropmessage;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import com.dropmessage.dto.AuthRequest;
import com.dropmessage.entity.Message;

import io.restassured.http.ContentType;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DropmessageApplicationTests {

	@Test
	void contextLoads() {
	}

// Test for sending a message
	@Test
	@Order(1)
	void SendMessageTest() {
		Message message = new Message();
		message.setEmail("testmessage@gmail.com");
		message.setMessage("Hello Madam, I completed my Homework");
		
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .body(message)
		   .when()
		   .post("http://localhost:9194/message/send")
		   .then()
		   .assertThat().statusCode(201);
	}

// Test for sending a message
	@Test
	@Order(2)
	void ShowAllMessageTest() {
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .when()
		   .get("http://localhost:9194/message/allmessage")
		   .then()
		   .assertThat().statusCode(200);
	}
// Test for show message by email
	@Test
	@Order(3)	
	void ShowMessageByEmail() {
		AuthRequest authCheck = new AuthRequest();
		authCheck.setEmail("pooja@gmail.com");
		authCheck.setPassword("pooja123");
		authCheck.setRole("Teacher");
		
	String tokenn = given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .body(authCheck)
		   .when()
		   .post("http://localhost:9192/home/login")
		   .then()
		   .assertThat().statusCode(200)
		   .extract().response().asString();
	
	 System.out.println(tokenn);
     
     String token = "Bearer "+tokenn;
     
     given()
	     .header("Authorization",token).contentType(ContentType.JSON).accept(ContentType.JSON)
	     .when()
	     .get("http://localhost:9194/message/show/testmessage@gmail.com")
	     .then()
	     .assertThat().statusCode(200);
     
	}

//Test for delete message 
	@Test
	@Order(4)
	void DeleteMessageTest() {
		AuthRequest authCheck = new AuthRequest();
		authCheck.setEmail("pooja@gmail.com");
		authCheck.setPassword("pooja123");
		authCheck.setRole("Teacher");
		
	String tokenn = given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .body(authCheck)
		   .when()
		   .post("http://localhost:9192/home/login")
		   .then()
		   .assertThat().statusCode(200)
		   .extract().response().asString();
	
     String token = "Bearer "+tokenn;
     System.out.println(token);
	
     given()
	     .header("Authorization",token).contentType(ContentType.JSON).accept(ContentType.JSON)
	     .when()
	     .delete("http://localhost:9194/message/delete/testmessage@gmail.com")
	     .then()
	     .assertThat().statusCode(200)
	     .extract().response();
}
	
}
