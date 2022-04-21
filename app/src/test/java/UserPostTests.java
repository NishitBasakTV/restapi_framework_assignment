import create.CreatePostRequestBody;
import create.CreateUserRequestBody;
import create.response.CreatePostResponse;
import create.response.CreateUserResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;

public class UserPostTests {


    @Test
    public void shouldCreateAPostForUser() {
//  Arrange
        CreatePostRequestBody postBody = new CreatePostRequestBody.Builder().build();
//  Act
        CreatePostResponse createPostResponses = new UsersService().createPost(postBody);
//  Assert
        createPostResponses.assertPost(postBody);

    }

    @Test
    public void getPostById() {
//  Arrange
        String postId = "6260ed5796ef5152c3ada8ed";
        CreatePostRequestBody postBody = new CreatePostRequestBody.Builder().build();
//  Act
        CreatePostResponse createPostResponses = new UsersService().getPost(postId);
//  Assert
        createPostResponses.assertPost(postBody);
    }

    @Test
    public void deletePostById() {
        //  Arrange
        CreatePostRequestBody postBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponse createPostResponses = new UsersService().createPost(postBody);
        String postId = createPostResponses.getId();
//  Act
        CreatePostResponse createPostResponses2 = new UsersService().deletePost(postId);
//  Assert
        Assert.assertEquals(createPostResponses2.getId(), postId);
    }

}
