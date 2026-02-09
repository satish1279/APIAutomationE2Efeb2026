package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest {

	@Test(description = "Verify if login api is working")

	public void loginTest() {

		LoginRequest LoginRequest = new LoginRequest("aman1234", "aman1234");

		AuthService authService = new AuthService();

		Response response = authService.login(LoginRequest);

	

		LoginResponse loginResponse	= response.as(LoginResponse.class); // de-serialize | saved response in respo model/respo pojo

		System.out.println(response.asPrettyString());
		
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());


		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getEmail(), "aman71165@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 4266, "Id Not Matches"); //put 3 to print err msg
		

	}

}
