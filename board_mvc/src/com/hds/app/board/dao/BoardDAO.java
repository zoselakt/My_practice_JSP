package com.hds.app.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hds.app.board.vo.BoardVO;
import com.hds.app.mybatis.config.MyBatisConfig;

public class BoardDAO {
	SqlSessionFactory sessionFactory = MyBatisConfig.getSqlsession_f();
	SqlSession sqlSession;
	
	public BoardDAO() {
		sqlSession = sessionFactory.openSession(true);
	}
	
	//게시글 목록
	public List<BoardVO> getList(int startRow, int endRow) {
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		return sqlSession.selectList("Board.getList", pageMap);
	}
	
	//게시글 전체 개수
	public int getTotal() {
		return sqlSession.selectOne("Board.getTotal");
	}
	
	//게시글 추가
	public void insertBoard(BoardVO board) {
		sqlSession.insert("Board.insertBoard", board);
	}
	
	//게시글 번호 가져오기
	public int getSeq() {
		return sqlSession.selectOne("Board.getSeq");
	}
	
	//게시글 상세보기
	public BoardVO getDetail(int boardNum) {
		return sqlSession.selectOne("Board.getDetail", boardNum);
	}
	
	//게시글 조회수 증가
	public void updateReadCount(int boardNum) {
		sqlSession.update("Board.updateReadCount", boardNum);
	}
	
	//게시글 삭제
	public void deleteBoard(int boardNum) {
		sqlSession.delete("Board.deleteBoard", boardNum);
	}
	
	//게시글 수정
	public void updateBoard(BoardVO board) {
		sqlSession.update("Board.updateBoard", board);
	}
}















