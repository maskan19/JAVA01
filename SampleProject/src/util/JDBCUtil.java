package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {

	public static void main(String[] args) {

		JDBCUtil instance = JDBCUtil.getInstance(); //객체를 빌려줌
		System.out.println(instance);
		JDBCUtil instance2 = JDBCUtil.getInstance(); //객체를 빌려줌
		System.out.println(instance2);
		JDBCUtil instance3 = JDBCUtil.getInstance(); //객체를 빌려줌
		System.out.println(instance3);
		
	}
	
	//싱글톤 패턴을 사용해서 객체를 하나만 사용
	//클래스를 설계하는 방식? 
	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	
	private JDBCUtil(){ //private는 다른 클래스에서는 호출을 할 수 없으므로 객체 생성도 할 수 없다.
		
	}
	
	//인스턴스를 보관할 변수
	private static JDBCUtil instance;
	
	//인스턴스를 빌려주는 메서드
	public static JDBCUtil getInstance(){
		if(instance == null){
			instance = new JDBCUtil();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "JJS0911";
	String password = "java";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*
	 * Map<String, Object> selectOne(String sql)// 물음표가 없는 메서드. 한줄만 조회하는 메서드. 해쉬맵
	 * Map<String, Object> selectOne(String sql, List<Object> param) //쿼리안에 물음표가 있으면 쓸 parameter
	 * List<Map<String, Object>> selectList(String sql)
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * int update(String sql)
	 * int update(String sql, List<Object> param)
	 */

	public Map<String, Object> selectOne(String sql) {
		Map<String, Object> map = new HashMap<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String key = md.getColumnName(i);
					Object value = rs.getObject(key);
					map.put(key, value);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return map;// 뭘 리턴을 해야하나
	}

	public Map<String, Object> selectOne(String sql, List<Object> param) {
		Map<String, Object> map = new HashMap<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			rs = ps.executeQuery();

			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String key = md.getColumnName(i);
					Object value = rs.getObject(key);
					map.put(key, value);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return map;// 뭘 리턴을 해야하나
	}

	public List<Map<String, Object>> selectList(String sql) {
		// 쿼리를 조회한 결과
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();

			while (rs.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String key = md.getColumnName(i);
					Object value = rs.getObject(key);
					row.put(key, value);
				}
				list.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return list;// 뭘 리턴을 해야하나
	}

	public List<Map<String, Object>> selectList(String sql, List<Object> param) {
		// 쿼리를 조회한 결과
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			rs = ps.executeQuery();

			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();

			while (rs.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String key = md.getColumnName(i);
					Object value = rs.getObject(key);
					row.put(key, value);
				}
				list.add(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return list;// 뭘 리턴을 해야하나
	}

	public int update(String sql, List<Object> param) {
		int result = 0;
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);

			for (int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;// 뭘 리턴을 해야하나
	}
	
	
	public int update(String sql) {
		int result = 0;
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;// 뭘 리턴을 해야하나
	}
	
}
