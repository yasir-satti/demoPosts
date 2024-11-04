package dev.danvega.post.controller;

import dev.danvega.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.danvega.post.model.Post;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    private List<Post> posts = new ArrayList<>();

    @Autowired
    private PostRepository postRepository;

    void setup() {
        posts = List.of(
                new Post(1, 1, "Hello, World!", "This is my first post.", null),
                new Post(2,1,"Second Post", "This is my second post.",null)
        );
    }

    @GetMapping("")
    List<Post> findAll() {
/*        setup();
        return posts;*/
        return postRepository.findAll();
    }
}
