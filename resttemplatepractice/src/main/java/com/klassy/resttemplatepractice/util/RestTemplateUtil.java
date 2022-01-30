package com.klassy.resttemplatepractice.util;

import com.klassy.resttemplatepractice.modal.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateUtil {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.url}")
    public String url;

    public String fetchAllPosts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(url+"/posts", HttpMethod.GET, entity,String.class).getBody();
    }

    public String fetchPostById(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        return restTemplate.exchange(url+"/posts/{id}",HttpMethod.GET,entity, String.class,params).getBody();
    }

    public String fetchCommentsByPostId(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        /*return restTemplate.exchange(url+"/comments?postId={id}",
                HttpMethod.GET,entity, String.class,id).getBody();*/
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(url+"/comments").queryParam("postId", "{id}")
                .encode().toUriString();
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.exchange(urlTemplate,
                HttpMethod.GET,entity, String.class,params).getBody();
    }

    public String addPost(Request request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Request> entity = new HttpEntity<Request>(request,headers);
        return restTemplate.exchange(url+"/posts",HttpMethod.POST,entity, String.class).getBody();
    }

    public String updatePost(Request request, String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Request> entity = new HttpEntity<Request>(request,headers);
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.exchange(url+"/posts/{id}",HttpMethod.PUT,entity, String.class,params).getBody();
    }

    public String deletePost(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.exchange(url+"/posts/{id}",HttpMethod.DELETE,entity, String.class,params).getBody();
    }
}
