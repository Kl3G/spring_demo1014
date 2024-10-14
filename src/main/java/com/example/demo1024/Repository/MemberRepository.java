package com.example.demo1024.Repository;

import com.example.demo1024.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{


}
