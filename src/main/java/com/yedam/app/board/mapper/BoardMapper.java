package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	//전체조회
	public List<BoardVO> selectBoardList();
	
	//단건조회
	public BoardVO selectBoardInfo(BoardVO vo);
	
	//등록
	public int insertBoard(BoardVO vo);
	
	//수정
	public int updateBoard(BoardVO vo);
	
	//삭제
	public int deleteBoard(int bno);
	
}
