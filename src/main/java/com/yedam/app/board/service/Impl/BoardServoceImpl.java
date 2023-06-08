package com.yedam.app.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServoceImpl implements BoardService {

	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO vo) {
		return boardMapper.selectBoardInfo(vo);
	}

	@Override
	public int insertBoardInfo(BoardVO vo) {
		int result = boardMapper.insertBoard(vo);
		
		if(result == 1) {
			System.out.println("등록 성공");
			return vo.getBno();
		}else {
			System.out.println("등록 실패");
			return -1;
		}
	}

	@Override
	public int updateBoardInfo(BoardVO vo) {
		int result = boardMapper.updateBoard(vo);
		if(result == 1) {
			System.out.println("수정 성공");
			return vo.getBno();
		}else {
			System.out.println("수정 실패");
			return -1;
		}
	}

	@Override
	public int deleteBoardInfo(int bno) {
		int result = boardMapper.deleteBoard(bno);
		
		if(result == 1) {
			System.out.println("삭제 성공");
			return bno;
		}else {
			System.out.println("삭제 실패");
			return -1;
		}
	}
}
