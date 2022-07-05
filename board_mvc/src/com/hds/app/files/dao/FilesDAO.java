package com.hds.app.files.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hds.app.files.vo.FilesVO;
import com.hds.app.mybatis.config.MyBatisConfig;
import com.oreilly.servlet.MultipartRequest;

public class FilesDAO {
	SqlSessionFactory sessionFactory = MyBatisConfig.getSqlsession_f();
	SqlSession sqlSession;
	
	public FilesDAO() {
		sqlSession = sessionFactory.openSession(true);
	}
	
	//게시글의 첨부파일 추가
	public void insertFile(MultipartRequest multi, int boardNum) {
		Enumeration<String> files = multi.getFileNames();
		FilesVO vo = new FilesVO();
		
		while(files.hasMoreElements()) {
			//사용자가 업로드한 파일 태그의 name
			String name = files.nextElement();
			//사용자가 업로드한 원본 파일 이름
			String original = multi.getOriginalFileName(name);
			//중복 시 변경된 이름
			String systemName = multi.getFilesystemName(name);
			if(systemName == null) {continue;}
			
			vo.setFileName(systemName);
			vo.setBoardNum(boardNum);
			vo.setFileNameOriginal(original);
			
			sqlSession.insert("Files.insertFile", vo);
		}
	}
	
	//게시글의 첨부파일 가져오기
	public List<FilesVO> getFiles(int boardNum){
		return sqlSession.selectList("Files.getFiles", boardNum);
	}
	
	public void deleteFiles(int boardNum) {
		sqlSession.delete("Files.deleteFiles", boardNum);
	}
	
}




















