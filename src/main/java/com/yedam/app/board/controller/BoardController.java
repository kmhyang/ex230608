package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardMapper boardMapper;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		model.addAttribute("boardList",boardService.getBoardList());
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO vo, Model model) {
		model.addAttribute("board",boardService.getBoardInfo(vo));
		return "board/boardInfo";
	}

	
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO vo, RedirectAttributes rtt) {
		boardService.insertBoardInfo(vo);
		System.out.println("vo => "+vo);
		rtt.addFlashAttribute("bno", vo.getBno());
		return "redirect:boardList";
		
	}
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - boa rd/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO vo, Model model){
		model.addAttribute("board", boardService.getBoardInfo(vo));
		return "board/boardUpdate";
	}

	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	public String boardUpdate(BoardVO vo) {
		boardService.updateBoardInfo(vo);
		System.out.println("vo => "+vo);
		return "redirect:boardList";
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(int bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}

}
