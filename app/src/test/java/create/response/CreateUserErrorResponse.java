package create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

@Getter
    public class CreateUserErrorResponse {

    @Setter
    private int statusCode;

    private String error;
    private Data data;

    public void assertHasExistingEmailError(String errorMsg, String emailMsg) {

        assertEquals(this.getError(), errorMsg);
        assertEquals(this.getData().getEmail(), emailMsg);

    }

    @Getter
    public class Data{
        private String email;
    }
}
