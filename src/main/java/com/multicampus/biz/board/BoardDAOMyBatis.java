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

	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo)  {
		System.out.println("===> MyBatis ������� insertBoard() ��� ó��");
		mybatis.insert("Board.insertBoard", vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� updateBoard() ��� ó��");
		mybatis.update("Board.updateBoard", vo);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� deleteBoard() ��� ó��");
		mybatis.delete("Board.deleteBoard", vo);
	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� getBoard() ��� ó��");
		return (BoardVO) mybatis.selectOne("Board.getBoard", vo);
	}

	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis ������� getBoardList() ��� ó��");
		return (List<BoardVO>) mybatis.selectList("Board.getBoardList", vo);
	}
}







