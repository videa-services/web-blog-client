package services.videa.web.blog.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import services.videa.web.blog.client.dtos.AllBlogs;
import services.videa.web.blog.client.dtos.BlogEntry;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class ClientController {

    private RestTemplate restTemplate;

    @Autowired
    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String home(Model model) {

        AllBlogs allBlogs = restTemplate.getForObject("http://localhost:8080/blog/readAll", AllBlogs.class);

        List<BlogEntry> blogEntries = allBlogs.getBlogs().stream().map(entry -> {
            BlogEntry blog = new BlogEntry();
            blog.setTitle(entry.getTitle());
            blog.setTimestamp(entry.getTimestamp());
            blog.setContent(entry.getContent());

            // FIXME set fixed avatars re. pictures
            int avatarNo = new Random().nextInt(6) + 1;
            blog.setPicture("avatar-0" + avatarNo + ".png");

            blog.setCommentsSize(entry.getComments().size());

            return blog;
        }).collect(Collectors.toList());

        model.addAttribute("blogEntries", blogEntries);

        return "list-all-blogs";
    }

}
