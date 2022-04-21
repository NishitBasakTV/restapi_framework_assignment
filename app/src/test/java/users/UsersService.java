package users;

import create.CreatePostRequestBody;
import create.CreateUserRequestBody;
import create.response.CreatePostResponse;
import create.response.CreateUserErrorResponse;
import create.response.CreateUserResponse;
import io.restassured.response.Response;

public class UsersService {

    public CreateUserResponse createUser(CreateUserRequestBody requestBody) {
        Response response = new UsersClient().create(requestBody);
        CreateUserResponse createUserResponses = response.as(CreateUserResponse.class);
        createUserResponses.setStatusCode(response.statusCode());
        return createUserResponses;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody requestBody){
        Response response = new UsersClient().create(requestBody);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }

    public CreateUserResponse getUser(String id) {
        Response response = new UsersClient().get(id);
        CreateUserResponse createUserResponses = response.as(CreateUserResponse.class);
        createUserResponses.setStatusCode(response.statusCode());
        return createUserResponses;
    }

    public CreatePostResponse createPost(CreatePostRequestBody requestBody) {
        Response response = new UsersClient().createPost(requestBody);
        CreatePostResponse createPostResponses = response.as(CreatePostResponse.class);
        createPostResponses.setStatusCode(response.statusCode());
        return createPostResponses;
    }

    public CreatePostResponse getPost(String postId) {
        Response response = new UsersClient().getPost(postId);
        CreatePostResponse createPostResponses = response.as(CreatePostResponse.class);
        createPostResponses.setStatusCode(response.statusCode());
        return createPostResponses;
    }
        public CreatePostResponse deletePost(String postId) {
        Response response = new UsersClient().deletePost(postId);
        CreatePostResponse createPostResponses = response.as(CreatePostResponse.class);
        createPostResponses.setStatusCode(response.statusCode());
        return createPostResponses;
    }

}
