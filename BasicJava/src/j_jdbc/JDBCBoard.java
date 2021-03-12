package j_jdbc;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;

public class JDBCBoard {
	
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String user = "JJS0911";
//	String password = "java";
//	
//	Connection con = null;
//	PreparedStatement ps = null;
//	ResultSet rs = null;
//	Scanner s = new Scanner(System.in);
//	HashMap<String, Object> board = new HashMap<>();
//	int n = 1;
	JDBCUtil jdbc = JDBCUtil.getInstance();
	SimpleDateFormat date = new SimpleDateFormat("MM/dd");

	public static void main(String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고 , 게시판 프로그램을 만들어주세요.
		 * 테이블 : TB_JDBC_BOARD
		 * 컬럼 : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
		 */
		
		JDBCBoard jb = new JDBCBoard();
		while(true){
			jb.list();
			System.out.println("1. 조회  2. 등록   3. 검색   4. 종료");
			String input = ScanUtil.nextLine();
			switch(input){
			case "1" : jb.lookupNo();
				break;
			case "2" : jb.insert();
				break;
			case "3" : jb.lookupKeyword();
				break;
			case "4" : 
				System.exit(0);
				break;
			}
		}
	}

	void list() {
		String sql = "select * from TB_JDBC_BOARD order by board_no";
		List<Map<String, Object>> List = new ArrayList<>();
		List = jdbc.selectList(sql);
		System.out
				.println("-----------------------------------"
						+ "\n글 번호	제목	작성자	작성일"
						+ "\n-----------------------------------");
		if (List.size() > 0) {
			for (int i = List.size() - 1; i >= 0; i--) {
				Map<String, Object> list = List.get(i);
				System.out.print(list.get("BOARD_NO") + "\t");
				System.out.print(list.get("TITLE") + "\t");
				System.out.print(list.get("USER_ID") + "\t");
				System.out.print(date.format(list.get("REG_DATE")) + "");
				System.out.println();
			}
		} else {
			System.out.println("조회할 글이 없습니다.");
			
		}
	}
	
	void insert(){
		String sql = "insert into TB_JDBC_BOARD values(?,?,?,?,?)";

		List<Object> ListParam = new ArrayList<>();
		int num = postNum();
		System.out.println("작성자 : ");
		String writer = ScanUtil.nextLine();
		System.out.println("제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("본문 : ");
		String contents = ScanUtil.nextLine();
		Date date = new Date(new java.util.Date().getTime());
		ListParam.add(num);
		ListParam.add(title);
		ListParam.add(contents);
		ListParam.add(writer);
		ListParam.add(date);
		
		jdbc.update(sql,ListParam);
		
	}

	void lookupNo(){
		String sql = "select * from TB_JDBC_BOARD where board_no = ?";
		List <Object> ListParam = new ArrayList<>();
		System.out.println("조회할 글 번호 : ");
		int no = ScanUtil.nextInt();
		ListParam.add(no);
		Map<String, Object>lookup = jdbc.selectOne(sql, ListParam);
		System.out.println("-----------------------------------");
		System.out.print("글 번호 " + lookup.get("BOARD_NO"));
		System.out.print("   등록일: " + date.format(lookup.get("REG_DATE")));
		System.out.println("   작성자 : " + lookup.get("USER_ID"));
		System.out.println("제목 : " + lookup.get("TITLE"));
		System.out.println("본문 : " + lookup.get("CONTENT"));
		System.out.println("-----------------------------------");
		System.out.println("1. 수정  2. 삭제");
		String input = ScanUtil.nextLine();
		switch(input){
		case "1" : update(no);
			break;
		case "2" : delete(no);
			break;
		case "3" : 
			break;
			}
	}

	void update(int no) {
		String sql = "update TB_JDBC_BOARD set title = ?, content = ? where board_no = ?";

		List<Object> ListParam = new ArrayList<>();
		System.out.println("수정할 제목 : ");
		String title = ScanUtil.nextLine();
		ListParam.add(title);
		System.out.println("수정할 본문 : ");
		String contents = ScanUtil.nextLine();
		ListParam.add(contents);
		int num = 1;
		ListParam.add(num);
		
		jdbc.update(sql, ListParam);
		System.out.println("수정되었습니다.");
	}
	
	void delete(int no){
		String sql = "DELETE FROM TB_JDBC_BOARD WHERE board_no =?";
		List <Object> ListParam = new ArrayList<>();
		ListParam.add(no);
		jdbc.update(sql, ListParam);
		System.out.println("삭제되었습니다.");
	}
	
	int postNum() {
		int postnum = 1;
			String sql = "SELECT NVL(MAX(BOARD_NO), 0) + 1 AS BOARD_NO"
					   + " FROM TB_JDBC_BOARD";
			Map<String, Object> num = jdbc.selectOne(sql);
			postnum = ((BigDecimal)num.get("BOARD_NO")).intValue();
		return postnum;
	}

	void lookupKeyword() {
		String sql = "select * from TB_JDBC_BOARD where content like '%'||?||'%'";
		List<Object> ListParam = new ArrayList<>();
		System.out.println("검색어 : ");
		String word = ScanUtil.nextLine();
		ListParam.add(word);
		List<Map<String, Object>> lookup = jdbc.selectList(sql, ListParam);

		if (lookup.size() > 0) {
			System.out.println("-----------------------------------"
					+ "\n글 번호	제목	작성자	작성일"
					+ "\n-----------------------------------");
			for (int i = lookup.size() - 1; i >= 0; i--) {
				Map<String, Object> list = lookup.get(i);
				System.out.print(list.get("BOARD_NO") + "\t");
				System.out.print(list.get("TITLE") + "\t");
				System.out.print(list.get("USER_ID") + "\t");
				System.out.print(date.format(list.get("REG_DATE")) + "");
				System.out.println();
			}
			System.out.println("1. 조회  2. 돌아가기");
			String input = ScanUtil.nextLine();
			switch (input) {
			case "1":
				lookupNo();
				break;
			case "2":
				break;
			}

		} else {
			System.out.println("조회할 글이 없습니다.");

		}

	}
	

}
