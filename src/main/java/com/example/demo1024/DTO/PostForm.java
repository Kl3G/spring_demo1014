package com.example.demo1024.DTO;

import com.example.demo1024.Entity.Member;
import com.example.demo1024.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PostForm {

    private String title;
    private String content;

    public Post toEntity(Member member){

        return new Post(null, title, content, member);
    }
}

