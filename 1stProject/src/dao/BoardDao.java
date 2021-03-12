package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {
	private static BoardDao instance;

	private BoardDao() {
	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> selectBoardList() {
		String sql = "SELECT A.BOARD_NO, A. TITLE, A. CONTENT, B.USER_NAME, A.REG_DATE"
				+ " FROM TB_JDBC_BOARD A"
				+ " LEFT OUTER JOIN TB_JDBC_USER B"
				+ " ON A. USER_ID = B.USER_ID" + " ORDER BY A. BOARD_NO DESC";

		return jdbc.selectList(sql);
	}
	
	
	public int insertNotice (List<Object> param) {
		String sql = "INSERT INTO NOTICE VALUES (?, ?, ?, ?, SYSDATE)";  //글코드, 작성자, 제목, 내용	
		return jdbc.update(sql,param);
	}
	
	
	public int insertEvent (List<Object> param) {
		String sql = "INSERT INTO EVENT VALUES (?, ?, ?, ?, SYSDATE)";  //글코드, 작성자, 제목, 내용
		return jdbc.update(sql,param);
	}
	
	public int insertQA (List<Object> param) {
		String sql = "INSERT INTO QA VALUES (?, ?, ?, ?, SYSDATE)";  //글코드, 작성자, 제목, 내용
		return jdbc.update(sql,param);
	}
	//1:1 질문 게시 (작성자id, 제목, 본문)
	public int insertInquiry_Q (List<Object> param) {
		String sql = "INSERT INTO INQUIRY select tnum, ?, ?, ?, SYSDATE,'ADMIN','','','' from ( SELECT NVL(MAX(INNUM), 0) + 1 as tnum from inquiry)"; 
		return jdbc.update(sql,param);
		
	}
	
	public int insertInquiry_A (List<Object> param) {
		String sql = "update inquiry set atitle = ?, acontents = ?, adate = sysdate where innum = ?";  //답변제목, 답변내용, 질문글번호
		return jdbc.update(sql,param);
	}
	//답변해야하는 1:1 조회
	public int selectInquiry_A (List<Object> param) {
		String sql = "SELECT innum, qmem_id, qtitle, QCONTENTS, Qtime FROM inquiry where adate is null;";
		return jdbc.update(sql,param);
	}
	//답변 완료한 1:1 조회 
	public int selectInquiry_Adone (List<Object> param) {
		String sql = "SELECT * FROM inquiry where adate is not null";
		return jdbc.update(sql,param);
	}
	
	
	
	
	
	
	
	
	
	

}
