import create.CreateUserRequestBody;
import create.response.CreateUserResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;


public class UserTests {

    @Test
    public void shouldCreateMaleUser() {
//  Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("male").build();
//  Act
        CreateUserResponse createUserResponses = new UsersService().createUser(requestBody);
//  Assert
        createUserResponses.assertUser(requestBody);

    }

    @Test
    public void shouldCreateFemaleUser() {
//  Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("male").build();
//  Act
        CreateUserResponse createUserResponses = new UsersService().createUser(requestBody);
//  Assert
        createUserResponses.assertUser(requestBody);
    }

    @Test
    public void shouldGetAllUsers() {
        new UsersClient().getAll()
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(10));
    }

    @Test
    public void getUserById() {
//  Arrange
        String id = "6260deef0893782dcaedbc24";
        CreateUserRequestBody userData = new CreateUserRequestBody.Builder().email("tenali.ramakrishna@115ce.com").build();
//  Act
        CreateUserResponse createUserResponses = new UsersService().getUser(id);
//  Assert
        createUserResponses.assertUser(userData);
    }
}
