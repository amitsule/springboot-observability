package com.cognitech.springboot_observability.posts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController
{
    private final JsonPlaceHolderService jsonPlaceHolderService;

    public PostController(JsonPlaceHolderService jsonPlaceHolderService)
    {
        this.jsonPlaceHolderService = jsonPlaceHolderService;
    }

    //----------------------------------------------------------------------------------------------------------
    @GetMapping
    public List<Post> findAll()
    {
        return this.jsonPlaceHolderService.findAll();
    }

    //----------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id)
    {
        return this.jsonPlaceHolderService.findById(id);
    }
}
