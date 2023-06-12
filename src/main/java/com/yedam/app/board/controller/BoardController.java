package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList",list);
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO vo, Model model) { //BoardVO vo : 커멘드객체에 담아서 넘겨줌.(검색기능)
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
	public String boardInsert(BoardVO vo, Model model) {
		boardService.insertBoardInfo(vo);
		System.out.println("vo => "+vo);
		return "redirect:boardList";
		
	}
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO vo, Model model){
		//기존 데이터 단건조회로 가져와서 보여줘야 함.
		model.addAttribute("board", boardService.getBoardInfo(vo));
		return "board/boardUpdate";
	}

	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	@ResponseBody //데이터만 반환 (페이지 반환X)
	public Map<String, Object> boardUpdate(BoardVO vo) {
		boolean result = false;
		int boardNo = boardService.updateBoardInfo(vo);
		if(boardNo > -1) {
			result = true;
			System.out.println("vo => "+vo);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result",result);
		map.put("board_no",boardNo);
		
		return map;
	}
//	public String boardUpdate(BoardVO vo) {
//		boardService.updateBoardInfo(vo);
//		return "redirect:boardList";
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam(required = false, defaultValue = "0", name="bno") int bno) { //int boardNo : 변수는 임의로 지정하면 됨.
		//@RequestParam 값을 무조건 넘겨줘야 함(required가 true라서). 넘겨주지 않으면 오류남.
		//==> required = false, defaultValue = "0", name="bno" 오류나지 않게 세 가지 설정해주면 됨.
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}

//	public String boardDelete(int bno) {
//		boardService.deleteBoardInfo(bno);
//		return "redirect:boardList";
//	}
}
