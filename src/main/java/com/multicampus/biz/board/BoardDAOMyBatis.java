package com.multicampus.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

//DAO(Data Access Object)
@Repository("boardDAO4")
public class BoardDAOMyBatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo)  {
		System.out.println("===> MyBatis 기반으로 insertBoard() 기능 처리");
		mybatis.insert("Board.insertBoard", vo);
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 updateBoard() 기능 처리");
		mybatis.update("Board.updateBoard", vo);
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 deleteBoard() 기능 처리");
		mybatis.delete("Board.deleteBoard", vo);
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 getBoard() 기능 처리");
		return (BoardVO) mybatis.selectOne("Board.getBoard", vo);
	}

	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 getBoardList() 기능 처리");
		return (List<BoardVO>) mybatis.selectList("Board.getBoardList", vo);
	}
}







