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
			sql.append("select board_num.nextval from dual");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch (SQLException e) {
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
	public boolean boardInsert(BoardVo vo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ju.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into jsp_board");
			sql.append("(board_num, board_id, borad_subject, board_content, board_file)");
			sql.append(", board_re_ref, board_re_lev, board_re_seq, board_count, board_date)");
			sql.append("values(?,?,?,?,?,?,?,?,?,sysdate)");
			
			int num = vo.getBoard_num();
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			pstmt.setString(2, vo.getBoard_id());
			pstmt.setString(3, vo.getBoard_subject());
			pstmt.setString(4, vo.getBoard_content());
			pstmt.setString(5, vo.getBoard_file());
			pstmt.setInt(6, num);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			
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
				sql.append("select * from");
				sql.append("(select rownum rnum, board_num, board_id, board_subject");
				sql.append(", board_content, board_file, board_count, board_re_ref");
				sql.append(", board_re_lev, board_re_seq, board_date");
				sql.append("from");
				sql.append("(select * from jsp_board order by board_re_ref desc, board_re_seq asc))");
				sql.append("where rnum >=? and rnum <=?");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, start+9);
				sql.delete(0, sql.toString().length());
				// 제목으로 검색
			}else if(opt.equals("0")){
				sql.append("select * from");
				sql.append("(select rownum rnum, board_num, board_id, board_subject");
				sql.append(", board_content, board_file, board_date, board_count");
				sql.append(", board_re_ref, board_re_lev, board_seq");
				sql.append("from");
				sql.append("(select * from jsp_board where board_subject like ? ");
				sql.append("order by board_re_ref desc, board_re_seq asc)");
				sql.append("where rnum >=? and rnum <=?");
				//내용으로 검색
			}else if(opt.equals("1")) {
				sql.append("select * from");
				sql.append("(select rownum rnum, board_num, board_id, board_subject");
				sql.append(", board_content, board_file, board_date, board_count");
				sql.append(", board_re_ref, board_re_lev, board_seq");
				sql.append("from");
				sql.append("(select * from jsp_board where board_content like ? ");
				sql.append("order by board_re_ref desc, board_re_seq asc)");
				sql.append("where rnum >=? and rnum <=?");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+ condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				sql.delete(0, sql.toString().length());
				//제목+내용
			}else if(opt.equals("2")) {
				sql.append("select * from");
				sql.append("(select rownum rnum, board_num, board_id, board_subject");
				sql.append(", board_content, board_file, board_date, board_count");
				sql.append(", board_re_ref, board_re_lev, board_seq");
				sql.append("from");
				sql.append("(select * from jsp_board where board_subject like ? or board_content like ?");
				sql.append("order by board_re_ref desc, board_re_seq asc)");
				sql.append("where rnum >=? and rnum <=?");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+ condition+"%");
				pstmt.setString(2, "%"+ condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+9);
				sql.delete(0, sql.toString().length());
			}else if(opt.equals("3")) {
				sql.append("select * from");
				sql.append("(select rownum rnum, board_num, board_id, board_subject");
				sql.append(", board_content, board_file, board_date, board_count");
				sql.append(", board_re_ref, board_re_lev, board_seq");
				sql.append("from");
				sql.append("(select * from jsp_board where board_id like ?");
				sql.append("order by board_re_ref desc, board_re_seq asc)");
				sql.append("where rnum >=? and rnum <=?");
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%"+ condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
				sql.delete(0, sql.toString().length());
			}
			rs= pstmt.executeQuery();
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoard_num(rs.getInt("board_num"));
				vo.setBoard_id(rs.getString("board_id"));
				vo.setBoard_subject(rs.getString("board_subject"));
				vo.setBoard_content(rs.getString("board_content"));
				vo.setBoard_file(rs.getString("board_file"));
				vo.setBoard_count(rs.getInt("board_count"));
				vo.setBoard_re_ref(rs.getInt("board_re_ref"));
				vo.setBoard_re_lev(rs.getInt("board_re_lev"));
				vo.setBoard_re_seq(rs.getInt("board_seq"));
				vo.setBoard_date(rs.getDate("board_date"));
			}
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}
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
			if(opt == null) {
				sql.append("select count(*) from jsp_board");
				pstmt = con.prepareStatement(sql.toString());
				sql.delete(0, sql.toString().length());
			}
		}
	}
}
