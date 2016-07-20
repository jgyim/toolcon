package com.multicampus.biz.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

//DAO(Data Access Object)
@Repository("boardDAO3")
public class BoardDAOIbatis {
	@Autowired
	private SqlMapClientTemplate ibatis;

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo)  {
		System.out.println("===> iBatis 기반으로 insertBoard() 기능 처리");
		ibatis.insert("insertBoard", vo);
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 updateBoard() 기능 처리");
		ibatis.update("updateBoard", vo);
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 deleteBoard() 기능 처리");
		ibatis.delete("deleteBoard", vo);
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 getBoard() 기능 처리");
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}

	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBatis 기반으로 getBoardList() 기능 처리");
		return ibatis.queryForList("getBoardList", vo);
	}
}







