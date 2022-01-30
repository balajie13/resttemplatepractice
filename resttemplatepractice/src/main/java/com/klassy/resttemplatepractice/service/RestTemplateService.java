package com.klassy.resttemplatepractice.service;

import com.klassy.resttemplatepractice.modal.Request;
import com.klassy.resttemplatepractice.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestTemplateService {

    @Autowired
    RestTemplateUtil restTemplateUtil;


    public String retrieveAllPosts() {
        return restTemplateUtil.fetchAllPosts();
    }

    public String retrievePostById(String id) {
        return restTemplateUtil.fetchPostById(id);
    }

    public String retrieveCommentsById(String id) {
        return restTemplateUtil.fetchCommentsByPostId(id);
    }

    public String createPost(Request request) {
        return restTemplateUtil.addPost(request);
    }

    public String updatePost(Request request, String id) {
        return restTemplateUtil.updatePost(request,id);
    }

    public String deletePost(String id) {
        return restTemplateUtil.deletePost(id);
    }
}
