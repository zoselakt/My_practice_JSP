package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import controller.JdbcUtil;

public class BoardDao {
	private static BoardDao instance;
	JdbcUtil ju = JdbcUtil.getInstance();
	
	private BoardDao() {}
	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	//시퀀스 불러오기
	public int getSeq() {
		int result = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select board_num.nextval from dual ");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	//글 작성
	public boolean boardInsert(BoardVo vo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = ju.getConnection();
			con.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append("insert into jsp_board ");
			sql.append(" (board_num, board_id, board_subject, board_content, board_file) ");
			sql.append(", board_re_ref, board_count, board_parent, board_date) ");
			sql.append(" values(?,?,?,?,?, ?,?,?,sysdate) ");
			
			int num = vo.getBoard_num();
			int ref = vo.getBoard_re_ref();
			int parent = vo.getBoard_parent();
			
			if(parent == 0) {
				ref = num;
			}
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			pstmt.setString(2, vo.getBoard_id());
			pstmt.setString(3, vo.getBoard_subject());
			pstmt.setString(4, vo.getBoard_content());
			pstmt.setString(5, vo.getBoard_file());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, parent);
			pstmt.setInt(8, vo.getBoard_count());
			
			int flag = pstmt.executeUpdate();
			if(flag > 0) {
				result = true;
				con.commit();
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	//글 목록
	public ArrayList<BoardVo> getBoardList(HashMap<String, Object> listOpt){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String opt = (String) listOpt.get("opt");
		String condition = (String) listOpt.get("condition");
		int start = (Integer)listOpt.get("start");
		
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			
			// 글전체 정렬
			if(opt == null) {
				sql.append("select * from ");
				sql.append("( select rownum as rnum, data.* from ");
				sql.append(  "( select level, board_num, board_id, board_subject, ");
				sql.append(      " board_content, board_file, board_count, ");
				sql.append(      " board_re_ref, board_parent, board_date ");
				sql.append(  " from jsp_board) ");
				sql.append(  " start with board_parent = 0 ");
				sql.append(  " connect by prior board_num = board_parent ");
				sql.append(  " order siblings by board_re_ref desc) ");
				sql.append(" data ");
				sql.append(" where rnum >=? and rnum <=?") ;
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, start + 9);
				
				sql.delete(0, sql.toString().length());
				// 제목으로 검색
			}else if(opt.equals("0")){
				sql.append(" select * from ");
				sql.append(" (select rownum as rnum, data.* from ");
				sql.append(  " (select level, board_num, board_id, board_subject, ");
				sql.append(      " board_content, board_file, board_count, ");
				sql.append(      " board_re_ref, board_parent, board_date ");
				sql.append(  " from jsp_board) ");
				sql.append(  " where board_subject like=? ");
				sql.append(  " start with board_parent = 0 ");
				sql.append(  " connect by prior board_num = board_parent ");
				sql.append(  " order siblings by board_re_ref desc) ");
				sql.append(" data");
				sql.append(" where rnum >=? and rnum <=? ");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
				
				//내용으로 검색
			}else if(opt.equals("1")) {
				sql.append("select * from ");
				sql.append(" (select rownum as rnum, data.* from ");
				sql.append(  " (select level, board_num, board_id, board_subject, ");
				sql.append(      " board_content, board_file, board_count, ");
				sql.append(      " board_re_ref, board_parent, board_date ");
				sql.append(  " from jsp_board) ");
				sql.append(  " where board_content like=? ");
				sql.append(  " start with board_parent = 0 ");
				sql.append(  " connect by prior board_num = board_parent ");
				sql.append(  " order siblings by board_re_ref desc) ");
				sql.append(" data ");
				sql.append(" where rnum >=? and rnum <=? ");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+ condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				
				sql.delete(0, sql.toString().length());
				
				//제목+내용
			}else if(opt.equals("2")) {
				sql.append(" select * from ");
				sql.append(" (select rownum as rnum, data.* from ");
				sql.append(  " (select level, board_num, board_id, board_subject, ");
				sql.append(      " board_content, board_file, board_count, ");
				sql.append(      " board_re_ref, board_parent, board_date ");
				sql.append(  " from jsp_board) ");
				sql.append(  " where board_content like=? ");
				sql.append(  " or board_content like = ? ");
				sql.append(  " start with board_parent = 0 ");
				sql.append(  " connect by prior board_num = board_parent ");
				sql.append(  " order siblings by board_re_ref desc) ");
				sql.append(" data");
				sql.append(" where rnum >=? and rnum <=?");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+ condition+"%");
				pstmt.setString(2, "%"+ condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+9);
				
				sql.delete(0, sql.toString().length());
				
				//글쓴이로 검색
			}else if(opt.equals("3")) {
				sql.append(" select * from ");
				sql.append(" (select rownum as rnum, data.* from ");
				sql.append(  " (select level, board_num, board_id, board_subject, ");
				sql.append(      " board_content, board_file, board_count, ");
				sql.append(      " board_re_ref, board_parent, board_date ");
				sql.append(  " from jsp_board) ");
				sql.append(  " where board_id like=? ");
				sql.append(  " start with board_parent = 0 ");
				sql.append(  " connect by prior board_num = board_parent ");
				sql.append(  " order siblings by board_re_ref desc) ");
				sql.append(" data ");
				sql.append(" where rnum >=? and rnum <=? ");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+ condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				sql.delete(0, sql.toString().length());
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoard_re_lev(rs.getInt("level"));
				vo.setBoard_num(rs.getInt("board_num"));
				vo.setBoard_id(rs.getString("board_id"));
				vo.setBoard_subject(rs.getString("board_subject"));
				vo.setBoard_content(rs.getString("board_content"));
				
				vo.setBoard_file(rs.getString("board_file"));
				vo.setBoard_count(rs.getInt("board_count"));
				vo.setBoard_re_ref(rs.getInt("board_re_ref"));
				vo.setBoard_parent(rs.getInt("board_parent"));
				vo.setBoard_date(rs.getDate("board_date"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return list;
	}
	//글 갯수?
	public int getBoardListCount(HashMap<String, Object> listOpt) {
		int result = 0;
		String opt = (String)listOpt.get("opt");
		String condition = (String)listOpt.get("condition");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			if(opt == null) { // 전체글갯수
				sql.append(" select count(*) from jsp_board ");
				pstmt = con.prepareStatement(sql.toString());
				
				sql.delete(0, sql.toString().length());
			}else if(opt.equals("0")) { //제목으로 검색한 글의 갯수
				sql.append(" select count(*) from jsp_board where board_subject like = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}else if(opt.equals("1")) { //내용으로 검색한 글의 갯수
				sql.append(" select count(*) from jsp_board where board_content like = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}else if(opt.equals("2")) { // 제목+내용으로 검색한 글의 갯수
				sql.append(" select count(*) from jsp_board ");
				sql.append(" where board_subject like = ? or board_content like = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				pstmt.setString(2, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}else if(opt.equals("3")) { // 글쓴이로 검색한ㄷ 글의 갯수
				sql.append(" select count(*) from jsp_board where board_id like = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, '%'+condition+'%');
				
				sql.delete(0, sql.toString().length());
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	//글 상세보기
	public BoardVo getDetail(int boardNum) {
		BoardVo vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select * from jsp_board where Board_num = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVo();
				vo.setBoard_num(boardNum);
				vo.setBoard_id(rs.getString("board_id"));
				vo.setBoard_subject(rs.getString("board_subject"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_file(rs.getString("board_file"));
				vo.setBoard_count(rs.getInt("board_count"));
				vo.setBoard_re_ref(rs.getInt("board_re_ref"));
				vo.setBoard_date(rs.getDate("board_date"));
				vo.setBoard_parent(rs.getInt("board_parent"));
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return vo;
	}
	//조횟수증가
	public boolean updateCount(int boardNum) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ju.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("update jsp_board set board_count = board_count + 1");
			sql.append("where board_num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			int flag = pstmt.executeUpdate();
			
			if(flag > 0) {
				result = true;
				con.commit();
			}
		}catch(Exception e) {
			try {
				con.rollback();
			}catch(SQLException sqlE) {
				sqlE.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	//삭제할 게시글 가져오기
	public String getFileName(int boardNum) {
		String fileName = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_file from jsp_board where board_num=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				fileName = rs.getString("Board_file");
			}
		}catch(Exception e) {
			try {
				con.rollback();
			}catch(SQLException sqlE) {
				sqlE.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return fileName;
	}
	//삭제
	public boolean deleteBoard(int boardNum) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" delete from jsp_board ");
			sql.append(" where board_num in ");
			sql.append(" (select board_num ");
			sql.append(" from jsp_board ");
			sql.append(" start with board_num = ? ");
			sql.append(" connect by prior board_num = board_parent ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNum);
			int flag = pstmt.executeUpdate();
			if(flag > 0) {
				result = true;
				con.commit();
			}
		}catch(Exception e) {
			try {
				con.rollback();
			}catch(SQLException sqlE) {
				sqlE.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	//수정
	public boolean updateBoard(BoardVo vo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ju.getConnection();
			con.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append(" update jsp_board set ");
			sql.append(" board_subject=? ");
			sql.append(", board_content=? ");
			sql.append(", board_file=? ");
			sql.append(", board_date=sysdate ");
			sql.append(" where board_num=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getBoard_subject());
			pstmt.setString(2, vo.getBoard_content());
			pstmt.setString(3, vo.getBoard_file());
			pstmt.setInt(4, vo.getBoard_num());
			
			int flag = pstmt.executeUpdate();
			if(flag > 0) {
				result = true;
				con.commit();
			}
		}catch(Exception e) {
			try {
				con.rollback();
			}catch(SQLException sqlE) {
				sqlE.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
}
