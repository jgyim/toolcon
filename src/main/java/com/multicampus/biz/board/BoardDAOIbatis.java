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

	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo)  {
		System.out.println("===> iBatis ������� insertBoard() ��� ó��");
		ibatis.insert("insertBoard", vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> iBatis ������� updateBoard() ��� ó��");
		ibatis.update("updateBoard", vo);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> iBatis ������� deleteBoard() ��� ó��");
		ibatis.delete("deleteBoard", vo);
	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> iBatis ������� getBoard() ��� ó��");
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}

	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBatis ������� getBoardList() ��� ó��");
		return ibatis.queryForList("getBoardList", vo);
	}
}







