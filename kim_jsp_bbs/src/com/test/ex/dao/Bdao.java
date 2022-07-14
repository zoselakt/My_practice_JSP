package com.test.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.test.ex.dto.Bdto;
import com.test.ex.frontCon.JdbcUtil;

public class Bdao {
	
	DataSource dataSource;
	
	public Bdao(){
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myOracle");
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public ArrayList<Bdto> list(){
		ArrayList<Bdto> dtos = new ArrayList<Bdto>();
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			dbconn = dataSource.getConnection();
			String sql = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from board order by bGroup desc, bStep asc";
			pstmt = dbconn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bgroup");
				int bStep = rs.getInt("bStep");
				int bIndent =rs.getInt("bIndent");
				
				Bdto dto = new Bdto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			}catch( Exception ee){
				ee.printStackTrace();
			}
			
		}
		return dtos;
	}
	
	public void write(String bName, String bTitle, String bContent){
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		
		try {
			dbconn = dataSource.getConnection();
			String sql ="insert into board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
					+ "values(board_seq.nextval,?,?,?,0,board_seq.currval,0,0)";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{			
				try {
				  if(pstmt !=null)pstmt.close();
				  if(dbconn !=null) dbconn.close();
				} catch (SQLException e) {					 
					e.printStackTrace();
				}			
		}		
	}//write
	
	public Bdto view(String sbId){
		
		plusHit(sbId);
		
		Bdto dto = null;
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			dbconn = dataSource.getConnection();
			
			String sql = "select * from board where bId=?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbId));
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bgroup");
				int bStep = rs.getInt("bStep");
				int bIndent =rs.getInt("bIndent");
				
				dto = new Bdto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			}catch( Exception ee){
				ee.printStackTrace();
			}
		}
		return dto;
	}//view
	
	public int modify(String bId, String bName, String bTitle, String bContent){
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		int n = 0;;
		
		try {
			dbconn = dataSource.getConnection();
			String sql = "update board set bName=?, bTitle=?, bContent=? where bId =?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4,  Integer.parseInt(bId));
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return n;
	}//modify
	
	public int delete(String bId){
		Connection dbconn=null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			dbconn = dataSource.getConnection();
			String sql = "delete from board where bId = ?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(bId));
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			} catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		return n;
	}//delete
	
	public Bdto replyView(String sBid){
		Bdto dto = null;
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			dbconn = dataSource.getConnection();
			String sql = "select * from board where bId = ?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(sBid));
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bgroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new Bdto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try{
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return dto;
	} //replyView
	
	public void reply(String bid, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent){
		
		replyForm(bGroup, bStep);
		
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		try {
			dbconn = dataSource.getConnection();
			String sql = "insert into board(bId, bName, bTitle, bContent, bgroup, bStep, bIndent)"
					+ "values(board_seq.nextval, ?,?,?,?,?,?)";
			pstmt = dbconn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep)+1);
			pstmt.setInt(6, Integer.parseInt(bIndent)+1);
			
			pstmt.executeUpdate();
			              
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
	} //reply
	
	private void replyForm(String sGroup, String sStep){
		
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		
		try {
			dbconn = dataSource.getConnection();
			String sql = "update board set bStep = bStep+1 where bgroup = ? and bStep > ?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sGroup));
			pstmt.setInt(2, Integer.parseInt(sStep));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}//replyform
	
	private void plusHit(String bId){
		Connection dbconn = null;
		PreparedStatement pstmt = null;
		
		try{
			dbconn = dataSource.getConnection();
			String sql = "update board set bHit = bHit+1 where bId = ?";
			pstmt = dbconn.prepareStatement(sql);
			pstmt.setString(1, bId);
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(dbconn !=null) dbconn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}
	
	public ArrayList<Bdto> getAllSearch(String col, String word){
		
		ArrayList<Bdto> list = new ArrayList<Bdto>();
		Connection conn = (Connection) JdbcUtil.getInstance();
		PreparedStatement pstmt;
		ResultSet rs;
		char sb;
		try {
		  if(col.equals("none")) {
				sb.setLength(0);
				sb.append("select post_no, user_id, title, contents, hits, write_date, likes, writer, board_type, latitude, longitude ");
				sb.append("from project_board ");
				sb.append("where user_id like ? or title like ? or user_id like ? or writer like ? ");
				sb.append("order by post_no desc ");
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setString(3, "%" + word + "%");
				pstmt.setString(4, "%" + word + "%");
		 
		  } else if(col.equals("post_no")) {
			  	
			  sb.setLength(0);
			  sb.append("select post_no, user_id, title, contents, hits, write_date, likes, writer, board_type, latitude, longitude ");
			  sb.append("from project_board ");
			  sb.append("where post_no like ? ");
			  sb.append("order by post_no desc ");
			  pstmt = conn.prepareStatement(sb.toString());
			  pstmt.setString(1, "%" + word + "%");
		  
		  } else if(col.equals("title")) {
			  sb.setLength(0);
			  sb.append("select post_no, user_id, title, contents, hits, write_date, likes, writer, board_type, latitude, longitude ");
			  sb.append("from project_board ");
			  sb.append("where title like ? ");
			  sb.append("order by post_no desc ");
			  pstmt = conn.prepareStatement(sb.toString());
			  pstmt.setString(1, "%" + word + "%");
		 
		  } else if(col.equals("user_id")) {
			  sb.setLength(0);
			  sb.append("select post_no, user_id, title, contents, hits, write_date, likes, writer, board_type, latitude, longitude ");
			  sb.append("from project_board ");
			  sb.append("where user_id like ? ");
			  sb.append("order by post_no desc ");
			  pstmt = conn.prepareStatement(sb.toString());
			  pstmt.setString(1, "%" + word + "%");
		 
		  } else if(col.equals("writer")) {
			  sb.setLength(0);
			  sb.append("select post_no, user_id, title, contents, hits, write_date, likes, writer, board_type, latitude, longitude ");
			  sb.append("from project_board ");
			  sb.append("where writer like ? ");
			  sb.append("order by post_no desc ");
			  pstmt = conn.prepareStatement(sb.toString());
			  pstmt.setString(1, "%" + word + "%");
		  } else {
              sb.append(" SELECT post_no, user_id, title, contents, hits, write_date, likes, writer, board_type, latitude, longitude ");
              sb.append(" FROM project_board ");
              sb.append(" ORDER BY post_no DESC");
              pstmt = conn.prepareStatement(sb.toString());
		  }
		  
			
			
			rs = pstmt.executeQuery();  
				
			while(rs.next()) { 
				int bid = rs.getInt(1);				
				String bName = rs.getString(2);
				String bTitle = rs.getString(3);
				String bContent = rs.getString(4);
				int bHit = rs.getInt(5);								
				String bDate = rs.getString(6);
				String bGroup = rs.getString(7);
				String bStep = rs.getString(8);
				String bIndent = rs.getString(9);
					
				Bdto vo = new Bdto();
					
				list.add(vo);
				
		}
			}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return list;
		
	}// getAllSearch() end
}
