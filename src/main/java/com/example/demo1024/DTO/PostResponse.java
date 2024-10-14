package com.example.demo1024.DTO;

import com.example.demo1024.Entity.Post;
import lombok.Data;

@Data
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private String memberName;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.memberName = post.getMember().getName();
    }
}
