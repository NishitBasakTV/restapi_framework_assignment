import create.CreatePostRequestBody;
import create.CreateUserRequestBody;
import create.response.CreatePostResponse;
import create.response.CreateUserResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;


public class E2EIntegrationTests {

    @Test
    public void shouldCreateAPostAndDelete() {
//  Arrange
        CreatePostRequestBody postBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponse createPostResponses = new UsersService().createPost(postBody);
        String postId = createPostResponses.getId();
//  Act
        CreatePostResponse createPostResponses2 = new UsersService().deletePost(postId);
        CreatePostResponse createPostResponses3 = new UsersService().getPost(postId);
//  Assert
        Assert.assertEquals(createPostResponses2.getId(), postId);
        createPostResponses3.assertError();
    }
}
