package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class UserDao {

	private static UserDao instance;

	private UserDao() {
	}

	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	// 회원가입
	private JDBCUtil jdbc = JDBCUtil.getInstance();

	public int insertUser(List<Object> param) {
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, 0, 1)";

		return jdbc.update(sql, param);
	}

	public Map<String, Object> checkID(List<Object> param) {
		String sql = "SELECT * FROM MEMBER WHERE MEM_ID = ?";
		return jdbc.selectOne(sql, param);
	}

	public Map<String, Object> selectUser(List<Object> param) {
		String sql = "SELECT * FROM MEMBER WHERE MEM_ID = ? AND MEM_PW = ?";
		return jdbc.selectOne(sql, param);
	}

	public Map<String, Object> pwfinder(List<Object> param) {// id 이름 pn
		String sql = "select mem_pw from member where mem_id = ? and mem_name = ? and mem_pn = ?";
		return jdbc.selectOne(sql, param);
	}

	public Map<String, Object> idfinder(List<Object> param) {// 이름 폰번
		String sql = "select mem_id from member where mem_name = ? and mem_pn = ?";
		return jdbc.selectOne(sql, param);
	}

	public Map<String, Object> checkPW(List<Object> param) {
		String sql = "SELECT * FROM MEMBER WHERE MEM_ID =? AND MEM_PW = ?";
		return jdbc.selectOne(sql, param);
	}

	public List<Map<String, Object>> bookingList(List<Object> param1) {
		String sql = " SELECT  A.MEM_ID, G.CINEMANAME, B.BOOKCODE, D.FILMNAME, B.TOTALPRICE, B.PAYMENT"
				+ " FROM  MEMBER A "
				+ " INNER JOIN BOOKING B "
				+ "	ON A.MEM_ID = B.MEM_ID "
				+ " INNER JOIN TIMETABLE C "
				+ "	ON B.TIMECODE = C.TIMECODE "
				+ " INNER JOIN FILM D "
				+ "	ON C.FILMCODE = D.FILMCODE "
				+ " INNER JOIN HALL F "
				+ "	ON C.HALLCODE = F.HALLCODE "
				+ " INNER JOIN CINEMA G "
				+ "	ON F.CINEMACODE = G.CINEMACODE " + "	WHERE A.MEM_ID = ?";
		return jdbc.selectList(sql, param1);
	}

	public int mem_update(List<Object> list) {

		String sql = "UPDATE member SET mem_pw = ?," + " mem_pn= ?"
				+ " WHERE mem_id = ?";

		return jdbc.update(sql, list);
	}

	public int mem_delete(List<Object> list) {

		String sql = "DELETE Member where mem_id = ?";

		return jdbc.update(sql, list);
	}

	public Map<String, Object> mem_mil(List<Object> param) {
		String sql = "select MEM_MIL from member" + "  where mem_id=?";
		return jdbc.selectOne(sql, param);
	}

}
