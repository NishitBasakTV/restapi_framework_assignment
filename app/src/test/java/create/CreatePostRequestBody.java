package create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreatePostRequestBody {

    private String owner;
    private String text;

    public CreatePostRequestBody(Builder builder) {
        this.owner = builder.owner;
        this.text = builder.text;
    }

    public static class Builder {
        private String owner;
        private String text;

        public Builder() {
            this.owner = "6260deef0893782dcaedbc24";
            this.text = "This is a dummy blog";
        }

        public Builder owner(String owner) {
            this.text = text;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public CreatePostRequestBody build(){
            CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody(this);
            return createPostRequestBody;
        }
    }
}
