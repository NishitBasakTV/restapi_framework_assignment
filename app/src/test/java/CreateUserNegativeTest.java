import create.CreateUserRequestBody;
import create.response.CreateUserErrorResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;

import static org.testng.Assert.assertEquals;

public class CreateUserNegativeTest {

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail() {
//  Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("tenali.ramakrishna@114ce.com").build();
//  Act
        CreateUserErrorResponse errorResponse = new UsersService().createUserExpectingError(requestBody);
//  Assert
        assertEquals(errorResponse.getStatusCode(), 400);
        errorResponse.assertHasExistingEmailError("BODY_NOT_VALID", "Email already used");
    }

}
