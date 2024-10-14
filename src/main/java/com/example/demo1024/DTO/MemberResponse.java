package com.example.demo1024.DTO;

import com.example.demo1024.Entity.Member;
import lombok.Data;

import java.util.List;

@Data
public class MemberResponse {

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.posts = member.getPosts().stream().map(post -> new PostResponse(post)).toList();
    }

    private Long id;
    private String name;
    private Long password;
    private String email;

    private List<PostResponse> posts;

}
