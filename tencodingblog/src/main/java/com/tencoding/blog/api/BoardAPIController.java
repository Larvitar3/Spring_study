package com.tencoding.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.blog.dto.Board;
import com.tencoding.blog.dto.ResponseDTO;
import com.tencoding.blog.oauth.PrincipalDetail;
import com.tencoding.blog.service.BoardService;

@RestController
public class BoardAPIController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDTO<Integer> save(@RequestBody Board board,
			@AuthenticationPrincipal PrincipalDetail detail){
		
		boardService.write(board, detail.getUser());
		
		return new ResponseDTO<Integer>(HttpStatus.OK, 1);
		
	}

}
