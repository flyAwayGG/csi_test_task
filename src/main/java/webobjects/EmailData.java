package webobjects;

/**
 * Created by root on 22.02.17.
 */
public class EmailData {

    private String author;
    private String theme;
    private String content;

    private EmailData() {

    }

    public String getAuthor() {
        return author;
    }

    public String getTheme() {
        return theme;
    }

    public String getContent() {
        return content;
    }

    public static EmailData.Builder builder(String author, String theme) {
        return new EmailData().new Builder(author, theme);
    }

    public class Builder {

        private Builder(String author, String theme) {
            EmailData.this.author = author;
            EmailData.this.theme = theme;
            EmailData.this.content = null;
        }

        public EmailData.Builder setContent(String content) {
            EmailData.this.content = content;
            return this;
        }

        public EmailData build() {
            return EmailData.this;
        }
    }
}
