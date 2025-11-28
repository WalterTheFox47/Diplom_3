package praktikum.ui.utils;

import io.restassured.response.ValidatableResponse;
import praktikum.api.model.CreateUserRequest;
import praktikum.api.model.LoginRequest;
import praktikum.api.model.SuccessResponse;

import static io.restassured.RestAssured.given;

public class UserApiSteps {
    private static final String BASE_URI = "https://stellarburgers.education-services.ru";

    public static CreateUserRequest createUniqueUser() {
        CreateUserRequest userRequest = new CreateUserRequest("testuser" + System.currentTimeMillis() + "@yandex.ru", "password123", "TestUser");

        given()
                .contentType("application/json")
                .baseUri(BASE_URI)
                .body(userRequest)
                .when()
                .post("/api/auth/register");

        return userRequest;
    }

    public static void deleteUser(CreateUserRequest userRequest) {
        ValidatableResponse loginResponse = given()
                .contentType("application/json")
                .baseUri(BASE_URI)
                .body(new LoginRequest(userRequest.email, userRequest.password))
                .when()
                .post("/api/auth/login")
                .then();

        String accessToken = loginResponse.extract().as(SuccessResponse.class).accessToken;

        if (accessToken != null) {
            given()
                    .contentType("application/json")
                    .baseUri(BASE_URI)
                    .header("Authorization", accessToken)
                    .when()
                    .delete("/api/auth/user")
                    .then()
                    .statusCode(202);
        }
    }
}