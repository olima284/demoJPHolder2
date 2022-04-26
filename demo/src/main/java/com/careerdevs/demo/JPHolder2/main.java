package com.careerdevs.demo.JPHolder2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/getAllComments")
    public Object getComments(RestTemplate restTemplate) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Object.class);
    }
}
