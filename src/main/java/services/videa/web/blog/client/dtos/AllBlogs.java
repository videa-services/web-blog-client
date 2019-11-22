package services.videa.web.blog.client.dtos;

import java.util.List;

public class AllBlogs {

    private List<BlogEntry> blogs;

    public List<BlogEntry> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogEntry> blogs) {
        this.blogs = blogs;
    }

}
