package services.videa.web.blog.client.dtos;

import java.util.ArrayList;
import java.util.List;

public class BlogEntry {

    private String title;
    private String timestamp;
    private String content;
    private String picture;
    private List<CommentEntry> comments = new ArrayList<>();
    private int commentsSize = 0;

    public int getCommentsSize() {
        return commentsSize;
    }

    public void setCommentsSize(int commentsSize) {
        this.commentsSize = commentsSize;
    }

    public List<CommentEntry> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntry> comments) {
        this.comments = comments;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
