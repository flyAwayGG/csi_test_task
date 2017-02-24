package webobjects;

/**
 * Created by root on 22.02.17.
 */
public class EmailData {

    private String author;
    private String authorEmail;
    private String theme;
    private String content;

    private EmailData() {

    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getTheme() {
        return theme;
    }

    public String getContent() {
        return content;
    }

    public static EmailData.Builder builder(String authorEmail, String theme) {
        return new EmailData().new Builder(authorEmail, theme);
    }

    public class Builder {

        private Builder(String authorEmail, String theme) {
            EmailData.this.authorEmail = authorEmail;
            EmailData.this.theme = theme;
            EmailData.this.author = null;
            EmailData.this.content = null;
        }

        public EmailData.Builder setContent(String content) {
            EmailData.this.content = content;
            return this;
        }

        public EmailData.Builder setAuthor(String author) {
            EmailData.this.author = author;
            return this;
        }

        public EmailData build() {
            return EmailData.this;
        }
    }
}
