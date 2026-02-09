package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;


import io.restassured.response.Response;

public class SignupAPITest {

	@Test(description = "validate if signup api is working")
	
	public void signupTest() {// Builder Class pattern allows us to use variables in random order 
							 // this pattern remove vari order compulsion in the constru
		
		SignupRequest signupRequest = new SignupRequest.Builder()
										.email("satish8feb1521@yopmail.com")
										.firstName("ram1521")
										.lastName("yop1521")
										.mobileNumber("9871231521")
										.password("Pass@1234")
										.username("satish1521")
										.build();
										
		
		AuthService authService= new AuthService();
		Response response = authService.signup(signupRequest);


		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!", "User Exists !!!");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
