package com.tcblog.springblog;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long postId) throws Exception {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new Exception("Post not found."));
        return ResponseEntity.ok().body(post);
    }

    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(value="id") Long postId, @Valid @RequestBody Post newPost) throws Exception {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new Exception("Post not found."));
        post.setTitle(newPost.getTitle());
        post.setContent(newPost.getContent());
        post.setUpdateTime(LocalDateTime.now());
        final Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);
    }
    
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable(value="id") Long postId) throws Exception {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new Exception("Post not found."));
        postRepository.delete(post);
        return ResponseEntity.ok(postId);
    }
}
