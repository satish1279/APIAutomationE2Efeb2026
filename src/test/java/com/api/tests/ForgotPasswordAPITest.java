package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordAPITest {

@Test
	
	public void forgotpasswordtest() {
	
	AuthService authService= new AuthService();
	
	Response response= authService.forgotPassword("satish8feb1521@yopmail.com");
	
	System.out.println(response.asPrettyString());
	
	
	Assert.assertEquals(response.getStatusCode(), 200);
	//Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}
	
}
