package com.tencoding.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tencoding.blog.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
