package com.careerdevs.demo.JPHolder2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/JPHolder2/")
public class main {
    @GetMapping("/test")
    public String test() {
        return " the run test";
    }

    @GetMapping("/getAllPosts")
    public Object getPosts(RestTemplate restTemplate) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/", Object.class);
    }
//localhost:8080/JPHolder2/getPostbyId/4
    @GetMapping("/getPostbyId/{id}")
    public Object getPostById(RestTemplate restTemplate, @PathVariable String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Object.class);

    }
    @GetMapping("/posts/{id}/comments")
    public Object getCommentsByPost(RestTemplate restTemplate, @PathVariable String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts" + id + "/comments", Object.class);
    }

    @GetMapping("/comments")
    public Object getCommentsByQuery(RestTemplate restTemplate, @RequestParam String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments?postId=" + id, Object.class);
    }

//postForObjects takes in 3 args
// 1. URL
// 2. Request Body
// 3. Return Type

    @PostMapping("/posts")
    public Post createPost(RestTemplate restTemplate, @RequestBody Post newPost )
    {
        return restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", newPost, Post.class);
    }
    @PutMapping("/posts/{id}")
    public String updatePost(RestTemplate restTemplate, @PathVariable int id, @RequestBody Post post) {
        restTemplate.put("https://jsonplaceholder.typicode.com/posts", +id, post);
        return "Post with id" + id + "successfully Updated";
    }


    }


//@RequestMapping with Class: /home is the URI for which this controller will be used
//The @RequestParam annotation is used with @RequestMapping to
// bind a web request parameter to the parameter of the handler method.

        //SEND POST REQUEST :
//localhost:8080/JPHolder2/posts
//In Body Write request
//{
//        "id":2892,
//
//        "title":"Lima"
//        }