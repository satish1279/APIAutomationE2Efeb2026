package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserprofileManagmentService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileUpdateRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileAPITest {

	@Test

	public void updateProfileTest() { 

	
		AuthService authService= new AuthService();
		
		LoginRequest loginRequest = new LoginRequest("satish1521", "Pass@1234");
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);



		UserprofileManagmentService userprofileManagmentService= new UserprofileManagmentService();
		
		ProfileUpdateRequest profilUpdateRequest= new ProfileUpdateRequest.Builder()
													.email("satish8feb2010@yopmail.com")
													.firstName("ram2010")
													.lastName("yop2010")					
													.mobileNumber("9871232010")
													.build();


		response= userprofileManagmentService.updateProfileInformation(loginResponse.getToken(), profilUpdateRequest);

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);





	}

}
