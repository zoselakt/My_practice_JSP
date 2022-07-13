package com.test.ex.frontCon;

import java.sql.*;
import java.util.*;

public class NoticeService {
	//페이지 요청 메소드	
		public List<Notice> getNoticeList() {
			return getNoticeList("title", "", 1);
		}
		public List<Notice> getNoticeList(int page) {
			return getNoticeList("title", "", page);
		}
		public List<Notice> getNoticeList(String field, String query, int page) {
			
			List<Notice> list= new ArrayList<Notice>();		
			
			String sql = "SELECT * FROM( " + 
					"    SELECT ROWNUM NUM , NOTICE.* " + 
					"    FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC " + 
					"    ) " + 
					"    WHERE NUM BETWEEN ? AND ?" ;		
			
			String url = "jdbc:oracle:thin:@localhost:1521/myoracle";
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs= null;
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, "ora_user2", "0000");
				
			    pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+query+"%" );
				pstmt.setInt(2, 1+(page-1) );
				pstmt.setInt(3, page*10 );
				rs = pstmt.executeQuery();
				
				while(rs.next()){ 
					
					int id = rs.getInt("ID");
					String title = rs.getString("TITLE");		
					String writerId = rs.getString("WRITER_ID"); 
					Date regdate = rs.getDate("REGDATE"); 	
					int hit = rs.getInt("HIT"); 
					String files = rs.getString("FILES");
					String content = rs.getString("Content");
					
					Notice notice = new Notice(id, title, writerId, regdate, hit, files, content);
					list.add(notice);			

				} 
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				    if(conn !=null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			return list;	
		}
			
		
		//Notice 수 구하는 메소드
		public int getNoticeCount() {
			return  getNoticeCount("title" , "");
		}
		
		public int getNoticeCount(String field, String query) {
			
			int count = 0;
			
			String sql = "SELECT COUNT(ID) COUNT FROM( " + 
					"    SELECT ROWNUM NUM, NOTICE.* " + 
					"    FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC " + 
					"    )"	;
			
			String url = "jdbc:oracle:thin:@localhost:1521/myoracle";
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs= null;		
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, "ora_user2", "0000");
				
			    pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				pstmt.setString(1, "%"+query+"%" );	
				count = rs.getInt("count");
			
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				    if(conn !=null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			return count;	
		}		
		
		
		//Notice 요청 메소드
		public Notice getNotice(int id) {

			Notice notice = null;
			String sql = "SELECT * FROM NOTICE WHERE ID = ?";			
			
			String url = "jdbc:oracle:thin:@localhost:1521/myoracle";
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs= null;
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, "ora_user2", "0000");
				
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setInt(1, id );

			    rs = pstmt.executeQuery();
				
				while(rs.next()){ 
					
					int nid = rs.getInt("ID");
					String title = rs.getString("TITLE");		
					String writerId = rs.getString("WRITER_ID"); 
					Date regdate = rs.getDate("REGDATE"); 	
					int hit = rs.getInt("HIT"); 
					String files = rs.getString("FILES");
					String content = rs.getString("Content");

					notice = new Notice(nid, title, writerId, regdate, hit, files, content);							
				} 
				
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				    if(conn !=null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}			
			}			
			return notice;
		}
		
		
		public Notice getPrevNotice(int id) {
			
			Notice notice = null;
			
			String sql = "SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) " + 
					"    WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?) " + 
					"    AND ROWNUM = 1";
			
			String url = "jdbc:oracle:thin:@localhost:1521/myoracle";
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs= null;		
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, "ora_user2", "0000");
				
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setInt(1, id );
				rs = pstmt.executeQuery();

				while(rs.next()){ 
					
					int nid = rs.getInt("ID");
					String title = rs.getString("TITLE");		
					String writerId = rs.getString("WRITER_ID"); 
					Date regdate = rs.getDate("REGDATE"); 	
					int hit = rs.getInt("HIT"); 
					String files = rs.getString("FILES");
					String content = rs.getString("Content");

					notice = new Notice(nid, title, writerId, regdate, hit, files, content);					

				} 
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				    if(conn !=null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}	
			
			return notice;
		
		}
		public Notice getNextNotice(int id) {
			
			Notice notice =null;
			
			String sql ="SELECT * FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC)" + 
					"  WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?) " + 
					"  AND ROWNUM =1 ";
			
			String url = "jdbc:oracle:thin:@localhost:1521/myoracle";
			Connection conn = null;
			PreparedStatement pstmt= null;
			ResultSet rs= null;		
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, "ora_user2", "0000");
				
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setInt(1, id );
				rs = pstmt.executeQuery();

				while(rs.next()){ 
					
					int nid = rs.getInt("ID");
					String title = rs.getString("TITLE");		
					String writerId = rs.getString("WRITER_ID"); 
					Date regdate = rs.getDate("REGDATE"); 	
					int hit = rs.getInt("HIT"); 
					String files = rs.getString("FILES");
					String content = rs.getString("Content");

					notice = new Notice(nid, title, writerId, regdate, hit, files, content);					

				} 
			} catch (ClassNotFoundException e) {			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(rs !=null) rs.close();
					if(pstmt !=null) pstmt.close();
				    if(conn !=null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}	
			
			return notice;
		}
}
