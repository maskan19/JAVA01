package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class NoticeBoardDao {

	
	//싱글톤 패턴 생성
	private static NoticeBoardDao instance;
	private NoticeBoardDao () {}
	public static NoticeBoardDao getInstance() {
			if(instance == null){
				instance = new NoticeBoardDao();
				
			}
			return instance;
	
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	public List<Map<String , Object>> seletBoardList(){
		String sql = "SELECT A.NONUM, A.NOTITLE,A.MEM_ID, A.NOCONTENTS, B.MEM_NAME, A.NOTIME"
				    +" FROM NOTICE A "
				    + " LEFT OUTER JOIN MEMBER B"
				    + " ON A.MEM_ID = B.MEM_ID"
				    + " ORDER BY A.NOTIME DESC";
		//SQL문에는 앞글자에 띄워쓰기 작성하기 !!!!!!!!!!!!!!!!!!!!!!!!!!!
		//ORA-00923: FROM keyword not found where expected SQL문 에러
		
		
		return jdbc.selectList(sql);			
	}
	
	
	
	public Map<String, Object> selectOneList(List<Object> test){
		String sql = "select * from  NOTICE  where  NONUM = ?";
		return jdbc.selectOne(sql, test);
	}

	
	public int update(List<Object> test) {
	
		String sql = "UPDATE NOTICE SET NOTITLE =?,NOCONTENTS=?  WHERE NONUM= ?";

		return jdbc.update(sql, test);
	}

	
	public int delete(List<Object> test) {

		String sql = "DELETE NOTICE where NONUM = ?";
		
		return jdbc.update(sql, test);
	}
	
	
	public int Insert(List<Object> test) {
			    
		  String sql ="INSERT INTO NOTICE  select tnum, 'ADMIN', ?, ?, SYSDATE"
	               +   " from (SELECT NVL(MAX(NONUM),0)+1 as tnum from NOTICE)";

		return jdbc.update(sql, test);
	
	
}
	
	
	
}
