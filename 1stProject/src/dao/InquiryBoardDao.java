package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class InquiryBoardDao {
	private static InquiryBoardDao instance;

	private InquiryBoardDao() {
	}

	public static InquiryBoardDao getInstance() {
		if (instance == null) {
			instance = new InquiryBoardDao();
		}
		return instance;
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> seletBoardList() {
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
	public int insertInquiry_Q (List<Object> test) {
		String sql = "INSERT INTO INQUIRY select tnum, ?, ?, ?, SYSDATE,'ADMIN','','','' from ( SELECT NVL(MAX(INNUM), 0) + 1 as tnum from inquiry)"; 
		return jdbc.update(sql,test);
		
	}
	
	public int insertInquiry_A (List<Object> param) {
		String sql = "update inquiry set atitle = ?, acontents = ?, adate = sysdate+1 where innum = ?";  //답변제목, 답변내용, 질문글번호
		return jdbc.update(sql,param);
	}
	//답변해야하는 1:1 조회
	public List<Map<String, Object>> selectInquiry_A() {
		String sql = "SELECT INNUM, QMEM_ID, QTITLE, QTIME "
				+ " FROM INQUIRY A "
				+ " WHERE ADATE IS NULL";
		return jdbc.selectList(sql);
	}
	public Map<String, Object> selectOneList(List<Object> test){
		
		String sql = "select * from INQUIRY where INNUM = ?";
		
		return jdbc.selectOne(sql, test);
	}
	//답변 완료한 1:1 조회 
	public List<Map<String, Object>> selectInquiry_Adone() {
		String sql = "SELECT * FROM inquiry where adate is not null";
		return jdbc.selectList(sql);
	}
	 public int Ans_delete(List<Object> list) {

		      String sql = "DELETE inquiry where INNUM = ?";
		      
	return jdbc.update(sql, list);
	   }
	
	
	
	
	
	
	
	
	
	
	
	

}
