package dev.danvega.post.model;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Version;

public record Post(

        @Id
        Integer id,
        Integer userId,
        @NotEmpty
        String title,
        @NotEmpty
        String body,
        @Version
        Integer version) {
}
