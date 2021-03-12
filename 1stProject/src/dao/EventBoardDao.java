package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class EventBoardDao {

	// 싱글톤 패턴 생성
	private static EventBoardDao instance;

	private EventBoardDao() {
	}

	public static EventBoardDao getInstance() {
		if (instance == null) {
			instance = new EventBoardDao();

		}
		return instance;

	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> seletBoardList() {
		String sql = "SELECT A.EVNUM, A.EVTITLE,A.MEM_ID, A.EVCONTENTS, B.MEM_NAME, A.EVTIME"
				+ " FROM EVENT A "
				+ " LEFT OUTER JOIN MEMBER B"
				+ " ON A.MEM_ID = B.MEM_ID" + " ORDER BY A.EVTIME DESC";
		// SQL문에는 앞글자에 띄워쓰기 작성하기 !!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ORA-00923: FROM keyword not found where expected SQL문 에러

		return jdbc.selectList(sql);

	}

	public Map<String, Object> selectOneList(List<Object> test) {

		String sql = "select * from EVENT where EVNUM = ?";

		return jdbc.selectOne(sql, test);
	}

	public int update(List<Object> test) {

		String sql = "UPDATE EVENT SET EVTITLE =?,EVCONTENTS=?  WHERE EVNUM= ?";

		return jdbc.update(sql, test);
	}

	public int delete(List<Object> test) {

		String sql = "DELETE EVENT where EVNUM = ?";

		return jdbc.update(sql, test);
	}

	public int Insert(List<Object> test) {

		// String sql
		// ="INSERT INTO EVENT(EVNUM,MEM_ID,EVTITLE,EVCONTENTS,EVTIME) "
		// + "VALUES(?, ?, ?, ?, SYSDATE)";
		String sql = "INSERT INTO EVENT  select tnum, 'ADMIN', ?, ?, SYSDATE"
				+ " from (SELECT NVL(MAX(EVNUM),0)+1 as tnum from EVENT)";
		return jdbc.update(sql, test);

	}

}
