package com.in28minutes.rest.webservices.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDAOService {
    private static List<Post> posts = new ArrayList<>();
    private static Integer postCount = 6;

    static {
        posts.add(new Post(1, 1, new Date(), "User1 first post", "This is the first post of the user so enjoy."));
        posts.add(new Post(2, 1, new Date(), "User1 second post", "This is the second post of the user so enjoy."));
        posts.add(new Post(3, 1, new Date(), "User1 third post", "This is the third post of user 1"));

        posts.add(new Post(4, 2, new Date(), "User2 first post", "This is the first post of the user so enjoy."));
        posts.add(new Post(5, 2, new Date(), "User2 second post", "This is the second post of the user so enjoy."));
        
        posts.add(new Post(6, 3, new Date(), "User3 first post", "This is the first post of user 3"));
    }

    public List<Post> findAll() {
        return posts;
    }

    public List<Post> findAll(int userID) {
        List<Post> userPosts = new ArrayList<>();

        for (Post post : posts) {
            if (post.getUserId() == userID) {
                userPosts.add(post);
            }    
        }

        return userPosts;
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            post.setId(++postCount);
        }
        posts.add(post);
        return post;
    }

    public Post findOne(Integer id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }

        return null;
    }

    public Post findOne(Integer id, Integer userId) {
        for (Post post : posts) {
            if (post.getId() == id && post.getUserId() == userId) {
                return post;
            }
        }
        return null;
    }
    
    public Post deleteOne(Integer id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                posts.remove(post);
                return post;
            }
        }

        return null;
    }

}
