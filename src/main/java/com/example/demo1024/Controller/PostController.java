package com.example.demo1024.Controller;

import com.example.demo1024.DTO.PostForm;
import com.example.demo1024.DTO.PostResponse;
import com.example.demo1024.Entity.Member;
import com.example.demo1024.Entity.Post;
import com.example.demo1024.Repository.MemberRepository;
import com.example.demo1024.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostController(PostRepository postRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/post")
    public List<PostResponse> getPosts(){

        List<Post> posts = postRepository.findAll();
        List<PostResponse> responses = posts.stream().map(post -> new PostResponse(post)).toList();
        return responses;
    }

    @PostMapping("/post")
    public PostResponse addPost(@RequestParam(value = "id") Long id, @RequestBody PostForm form){

        System.out.println(form.toString());
        //Optional : 값이 존재하지 않을 때는 null을 반환한다.
        /*Optional<Member> member = memberRepository.findById(id);*/
        Member member = memberRepository.findById(id).orElse(null);
        Post post = form.toEntity(member);
        Post result = postRepository.save(post);
        PostResponse response = new PostResponse(result);
        System.out.println(response.toString());
        return response;
    }
}
