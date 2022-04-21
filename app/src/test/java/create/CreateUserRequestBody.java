package create;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;

    public CreateUserRequestBody(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.email = builder.email;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String gender;
        private String email;

        public Builder() {

            this.firstName = "Tenali";
            this.lastName = "Ramakrishna";
            this.gender = "male";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public CreateUserRequestBody build(){
            CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(this);
            return createUserRequestBody;
        }
    }
}
