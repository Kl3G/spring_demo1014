package com.example.demo1024.DTO;

import com.example.demo1024.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberForm {

    @Override
    public String toString() {
        return "MemberForm{" +
                "name='" + name + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                '}';
    }

    private String name;
    private Long password;
    private String email;


    public Member toEntity(){

        return new Member(null, password, email, name, new ArrayList<>());
    }
}
