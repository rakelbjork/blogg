package com.example.blogg.controller;

import com.example.blogg.entities.Post;
import com.example.blogg.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> findAll(
            @RequestParam(required = false, defaultValue = "") String contains
    ){
        return postService.findAll(contains);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") int id){
        return postService.findById(id);
    }
}
