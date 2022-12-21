package com.tencoding.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tencoding.blog.dto.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

}
