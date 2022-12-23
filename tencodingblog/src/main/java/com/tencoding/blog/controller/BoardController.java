package com.tencoding.blog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tencoding.blog.dto.Board;
import com.tencoding.blog.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping({"", "/", "/board/search"})
	public String index(@RequestParam(required = false) String q, Model model,
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		String searchTitle = q == null ? "" : q;
		Page<Board> boards = boardService.searchBoard(searchTitle.replace("//", ""), pageable);
		
		int PAGENATION_BLOCK_COUNT = 3;
		
		int nowPage = boards.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - PAGENATION_BLOCK_COUNT, 1);
		int endPageNumber = Math.min(nowPage + PAGENATION_BLOCK_COUNT, boards.getTotalPages());
		
		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for(int i = startPageNumber; i <= endPageNumber; i++) {
			pageNumbers.add(i);
		}
		
		model.addAttribute("boards", boards);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPageNumber);
		model.addAttribute("endPage", endPageNumber);
		model.addAttribute("pageNumbers", pageNumbers);
		
		return "index";
	}
	
	
//	@GetMapping({"","/"})
//	public String index(Model model, 
//			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageble) {
//		
//		Page<Board> boards = boardService.getBoardList(pageble);
//		
//		boards.stream().forEach(item ->{
//			
//		});
//		
//		model.addAttribute("boards", boards);
//		
//		return "index";
//	}
//	
	
	@GetMapping("/board/save_form")
	public String saveForm() {
		
		return "/board/save_form";
		
	}
	
	@GetMapping("/board/{id}")
	public String showDetail(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "/board/detail";
	}
	
	@GetMapping("/board/{id}/update_form")
	public String updateForm(@PathVariable int id, Model model) {
		
		model.addAttribute("board", boardService.boardDetail(id));
		
		return "/board/update_form";
	}
	
	
}
