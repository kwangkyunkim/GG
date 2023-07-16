package teameight.gg.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import teameight.gg.entity.Post;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String username;
    private String content;
    private LocalDateTime createdAt;
    private String imageUrl;
    private long liked;
    private long disliked;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.imageUrl = post.getImageUrl();
        this.liked = post.getLiked();
        this.disliked = post.getDisliked();
    }
}