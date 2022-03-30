package com.example.servicePost.service;


//import com.example.servicePost.Post;
import com.example.servicePost.createPostRequest;
import com.example.servicePost.createPostResponse;
import com.example.servicePost.domain.Post;
import com.example.servicePost.reponsitory.PostReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostReponsitory postReponsitory;

    public PostService(PostReponsitory postReponsitory) {
        this.postReponsitory = postReponsitory;
    }


    public createPostResponse  createPost (createPostRequest request) {
        if (request != null) {
            Post post = new Post();
            post.setUserId(request.getUserId());
            post.setTitle(request.getTitle());
            post.setContent(request.getContent());
            postReponsitory.save(post);

            return createPostResponse.newBuilder()
                    .setIdPost(post.getId())
                    .setUserId(post.getUserId())
                    .setTitle(post.getTitle())
                    .setContent(post.getContent())
                    .setMessage("create new post success!")
                    .build();

        }
        return createPostResponse.newBuilder()
                .setMessage("Please transmit data")
                .build();
    }

}
