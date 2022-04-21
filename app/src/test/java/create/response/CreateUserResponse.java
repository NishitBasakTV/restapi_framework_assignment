package create.response;

import create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserResponse {
    @Setter
    private int statusCode;

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String registerDate;
    private String updatedDate;

    public void assertUser(CreateUserRequestBody requestBody) {
        assertEquals(this.getStatusCode(), 200);
        assertNotNull(this.getId());
        assertEquals(this.getFirstName(), requestBody.getFirstName());
        assertEquals(this.getLastName(), requestBody.getLastName());
        assertEquals(this.getGender(), requestBody.getGender());
        assertEquals(this.getEmail(), requestBody.getEmail());
    }
}
