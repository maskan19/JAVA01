package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class QaBoardDao {

	// 싱글톤 패턴 생성
	private static QaBoardDao instance;

	private QaBoardDao() {
	}

	public static QaBoardDao getInstance() {
		if (instance == null) {
			instance = new QaBoardDao();

		}
		return instance;

	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> seletBoardList() {
		String sql = "SELECT A.QANUM, A.QATITLE,A.MEM_ID, A.QACONTENTS, B.MEM_NAME, A.QATIME"
				+ " FROM QA A "
				+ " LEFT OUTER JOIN MEMBER B"
				+ " ON A.MEM_ID = B.MEM_ID" + " ORDER BY A.QATIME DESC";
		// SQL문에는 앞글자에 띄워쓰기 작성하기 !!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ORA-00923: FROM keyword not found where expected SQL문 에러

		return jdbc.selectList(sql);

	}

	public Map<String, Object> selectOneList(List<Object> test) {

		String sql = "select * from QA where QANUM = ?";

		return jdbc.selectOne(sql, test);
	}

	public int update(List<Object> test) {

		String sql = "UPDATE QA SET QATITLE =?,QACONTENTS=?  WHERE QANUM= ?";

		return jdbc.update(sql, test);
	}

	public int delete(List<Object> test) {

		String sql = "DELETE QA where QANUM = ?";

		return jdbc.update(sql, test);
	}

	public int Insert(List<Object> test) {

		String sql = "INSERT INTO QA  select tnum, 'ADMIN', ?, ?, SYSDATE"
				+ " from (SELECT NVL(MAX(QANUM),0)+1 as tnum from QA)";
		return jdbc.update(sql, test);
	}

}
