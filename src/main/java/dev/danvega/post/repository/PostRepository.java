package dev.danvega.post.repository;

import dev.danvega.post.model.Post;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ListCrudRepository<Post, Integer> {
}
