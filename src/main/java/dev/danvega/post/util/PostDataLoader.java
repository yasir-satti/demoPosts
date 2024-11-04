package dev.danvega.post.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.post.model.Posts;
import dev.danvega.post.repository.PostRepository;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class PostDataLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private static final Logger log = (Logger) LoggerFactory.getLogger(PostDataLoader.class);
    private final ObjectMapper objectMapper;

    public PostDataLoader(PostRepository postRepository, ObjectMapper objectMapper) {
        this.postRepository = postRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        if (postRepository.count() == 0){
            String POSTS_JSON = "/data/posts.json";
            log.info("Loading posts to database from JSON : {}", POSTS_JSON);
            try(InputStream inputStream = TypeReference.class.getResourceAsStream(POSTS_JSON)) {
                Posts response = objectMapper.readValue(inputStream, Posts.class);
                postRepository.saveAll(response.posts());
            } catch(IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        }
    }
}
