package com.example.servicePost.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "post")
public class Post {
    @Id
    private String id;
    private String title;
    private Integer like = 0;
    private String createTime;
    private String userId;
    private String content;
    private List<String> listCommentId;
    private List<String> listUserId;

}
