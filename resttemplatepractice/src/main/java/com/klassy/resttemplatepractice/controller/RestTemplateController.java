package com.klassy.resttemplatepractice.controller;


import com.klassy.resttemplatepractice.modal.Request;
import com.klassy.resttemplatepractice.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resttemplatedemo")
public class RestTemplateController {

    @Autowired
    RestTemplateService restTemplateService;

    @GetMapping(value = "/posts")
    public String getAllPosts(){
        return restTemplateService.retrieveAllPosts();
    }

    @GetMapping(value = "/posts/{id}")
    public String getPostById(@PathVariable String id){
        return restTemplateService.retrievePostById(id);
    }

    @GetMapping(value = "/commments")
    public String getCommentsById(@RequestParam("id") String id){
        return restTemplateService.retrieveCommentsById(id);
    }

    @PostMapping(value = "/posts")
    public String addPost(@RequestBody Request request){
        return restTemplateService.createPost(request);
    }

    @PutMapping(value = "/posts/{id}")
    public String updatePost(@RequestBody Request request, @PathVariable String id){
        return restTemplateService.updatePost(request,id);
    }

    @DeleteMapping(value = "/posts/{id}")
    public String patchPost(@PathVariable String id){
        return restTemplateService.deletePost(id);
    }




}
