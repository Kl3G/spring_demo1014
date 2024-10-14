package com.example.demo1024.Controller;

import com.example.demo1024.DTO.MemberForm;
import com.example.demo1024.DTO.MemberResponse;
import com.example.demo1024.Entity.Member;
import com.example.demo1024.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.List;

@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping ("/")
    public String helloWorld(){

        return "helloWorld";
    }

    @GetMapping ("/user")
    public List<MemberResponse> getUser(){

        List<Member> members = memberRepository.findAll();
        List<MemberResponse> responses = members.stream().map(member -> new MemberResponse(member)).toList();
        return responses;

        /*List<Member> members = memberRepository.findAll();
        return members;*/
    }

    @PostMapping("/user")
    public MemberResponse createMember(@RequestBody MemberForm form){

        System.out.println(form.toString());
        Member member = form.toEntity();
        Member result = memberRepository.save(member);
        System.out.println(result.toString());
        return new MemberResponse(result);
        /*MemberForm form = new MemberForm("KIM", 123L, "KIM@naver.com");
        System.out.println(form.toString());*/
    }

}
