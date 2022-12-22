package com.tencoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.blog.dto.Board;
import com.tencoding.blog.dto.Reply;
import com.tencoding.blog.dto.User;
import com.tencoding.blog.repository.BoardRepository;
import com.tencoding.blog.repository.ReplyRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	public void write(Board board, User user) {
		
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
		
	}
	
	@Transactional(readOnly = true)
	public Page<Board> getBoardList(Pageable pageble){
		
		Page<Board> page = boardRepository.findAll(pageble);
		
		return boardRepository.findAll(pageble);
	}
	
	
	public Board boardDetail(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
	}
	
	@Transactional
	public void deleteById(int id) {
		boardRepository.deleteById(id);
	}
	
	
	@Transactional
	public int modifyBoard(int boardId, Board board) {
		
		Board boardEntity = boardRepository.findById(boardId).orElseThrow(() ->{
			return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
		});
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		
		return 1;
	}

	@Transactional
	public void writeReply(int boardId, Reply requestReply, User user) {
			
		Board board = boardRepository.findById(boardId).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 쓰기 실패 : 게시글이 존재하지 않습니다.");
		});
			
		requestReply.setUser(user);
		requestReply.setBoard(board);
		replyRepository.save(requestReply); 
	}
	
	
	
}
