package board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {
	public int count(String search_option, String keyword) {
		int result = 0;
		SqlSession session = MybatisManager.getInstance().openSession();
		
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			result = session.selectOne("board.search_count", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return result;
	}

	public List<BoardDTO> list_search(String search_option, String keyword, int start, int end){
		List<BoardDTO> list = null;
		SqlSession session = MybatisManager.getInstance().openSession();
		return list;
	}
}
