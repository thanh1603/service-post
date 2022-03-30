package com.example.servicePost.reponsitory;

import com.example.servicePost.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostReponsitory extends MongoRepository<Post, String> {
}
