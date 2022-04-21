package create.response;

import create.CreatePostRequestBody;
import create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreatePostResponse {
    @Setter
    private int statusCode;

    private String id;
    private String image;
    private String likes;
    private String link;
    private List<String> tags;
    private String text;
    private String publishDate;
    private String updatedDate;
    private Owner owner;
    private String error;

    public void assertPost(CreatePostRequestBody requestBody) {
        assertEquals(this.getStatusCode(), 200);
        assertNotNull(this.getId());
        assertEquals(this.getText(), requestBody.getText());
        assertEquals(this.getOwner().getId(), requestBody.getOwner());
    }

    public void assertError(){
        assertEquals(this.getStatusCode(), 404);
        assertEquals(this.getError(),"RESOURCE_NOT_FOUND");
    }

    @Getter
    public class Owner{
        private String id;
        private String firstName;
        private String lastName;

    }
}
