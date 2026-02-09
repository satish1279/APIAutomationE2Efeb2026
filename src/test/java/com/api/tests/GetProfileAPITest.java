package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserprofileManagmentService;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileAPITest {

	@Test

	public void getProfileTest() {
		LoginRequest loginRequest = new LoginRequest("aman1234", "aman1234");

		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		// System.out.println(loginResponse.getToken());

		UserprofileManagmentService userprofileService = new UserprofileManagmentService();
		response = userprofileService.getProfileInformation(loginResponse.getToken());

		System.out.println(response.asPrettyString());

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

	}

}
