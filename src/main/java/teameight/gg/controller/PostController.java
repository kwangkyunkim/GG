package teameight.gg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import teameight.gg.dto.ApiResponse;
import teameight.gg.dto.PostRequestDto;
import teameight.gg.security.UserDetailsImpl;
import teameight.gg.service.PostService;

import static teameight.gg.utils.ResponseUtils.ok;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ApiResponse<?> readAllPosts() {
        return ok(postService.getPosts());
    }

    @GetMapping("/{postId}")
    public ApiResponse<?> readOnePost(@PathVariable Long postId) {
        return ok(postService.getSinglePost(postId));
    }

    @PostMapping
    public ApiResponse<?> createPost(@RequestBody PostRequestDto postRequestDto,
                                     @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return ok(postService.createPost(postRequestDto, userDetailsImpl.getUser()));
    }

    @PatchMapping("/{postId}")
    public ApiResponse<?> modifyPost(@PathVariable Long postId,
                                     @RequestBody PostRequestDto postRequestDto,
                                     @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return ok(postService.updatePost(postId, postRequestDto, userDetailsImpl.getUser()));
    }

    @DeleteMapping ("/{postId}")
    public ApiResponse<?> removePost(@PathVariable Long postId,
                                     @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        return ok(postService.deletePost(postId, userDetailsImpl.getUser()));
    }
}