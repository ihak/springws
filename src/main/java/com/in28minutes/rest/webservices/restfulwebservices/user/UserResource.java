package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.post.Post;
import com.in28minutes.rest.webservices.restfulwebservices.post.PostDAOService;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService userService;
    
    @Autowired
    private  PostDAOService userPosts;
    
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        var users = userService.findAll();
        
        if (users.size() == 0) {
            throw new NoRecordFoundException("Users list is empty. No user added yet.");
        }

        return userService.findAll();
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User  user = userService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return userService.findOne(id);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteOne(@PathVariable int id) {
        User user = userService.deleteOne(id);

        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable int id) {
        return userPosts.findAll(id);
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Object> createUser(@PathVariable int id, @RequestBody Post post) {
        if (post.getTitle() == null || post.getDescription() == null) {
            throw new IncompleteUserDataException("Provide all the fields");
        }

        if (post.getTitle().isBlank() || post.getDescription().isBlank()) {
            throw new IncompleteUserDataException("Provide all the fields");
        }

        post.setUserId(id);
        Post savedPost = userPosts.save(post);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/users/{id}/posts/{post_id}")
    public Post retrieveOnePostForUser(@PathVariable int id,@PathVariable int post_id) {
        return userPosts.findOne(post_id, id);
    }
}
