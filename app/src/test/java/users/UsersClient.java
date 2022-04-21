package users;

import create.CreatePostRequestBody;
import create.CreateUserRequestBody;
import create.response.CreateUserErrorResponse;
import create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response create(CreateUserRequestBody requestBody) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", "6260d6aef8a1115b12a7cfcd")
                .body(requestBody)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");

                response.then()
                .log().body();

                return response;
    }

    public Response getAll() {
        Response response = given()
                .header("app-id", "6260d6aef8a1115b12a7cfcd")
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10");
        response.then()
                .log().body();

        return response;
    }

    public Response get(String id) {
        Response response = given()
                .header("app-id", "6260d6aef8a1115b12a7cfcd")
                .when()
                .get("https://dummyapi.io/data/v1/user/"+id);
        response.then()
                .log().body();

        return response;
    }

    public Response createPost(CreatePostRequestBody requestBody) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", "6260d6aef8a1115b12a7cfcd")
                .body(requestBody)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");

        response.then()
                .log().body();

        return response;
    }

    public Response getPost(String postId) {
        Response response = given()
                .header("app-id", "6260d6aef8a1115b12a7cfcd")
                .when()
                .get("https://dummyapi.io/data/v1/post/"+postId);
        response.then()
                .log().body();

        return response;
    }

    public Response deletePost(String postId) {
        Response response = given()
                .header("app-id", "6260d6aef8a1115b12a7cfcd")
                .when()
                .delete("https://dummyapi.io/data/v1/post/"+postId);
        response.then()
                .log().body();

        return response;
    }
}
