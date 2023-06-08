package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	//전체조회
	public List<BoardVO> getBoardList();
	
	//단건조회
	public BoardVO getBoardInfo(BoardVO vo);
	
	//등록 - 등록된 글 번호 반환 / 실패 : -1
	public int insertBoardInfo(BoardVO vo);
	
	//수정 - 수정된 글 번호 반환 / 실패 : -1
	public int updateBoardInfo(BoardVO vo);
	
	//삭제 - 삭제된 글 번호 반환 / 실패 : -1
	public int deleteBoardInfo(int bno);
}
