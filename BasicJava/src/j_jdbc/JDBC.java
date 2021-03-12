package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성 단계 
		 * 1. Connection 생성
		 * 2. Statement (쿼리)생성
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 */
		
		//데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		String user = "JJS0911";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member";
			ps = con.prepareStatement(sql);

			// select
			rs = ps.executeQuery();

			// insert, update, delete
			// int result = ps.executeUpdate(); //영향받은 행(row)의 수를 리턴

			// --result 값의 다음 행이 있는지
			while (rs.next()) {
				String memId = rs.getString(1); // 인덱스로 값을 가져오기(index는
				String memPass = rs.getString("MEM_PASS"); // 컬럼명으로 값을 가져오기
				System.out.println("MEM_ID : " + memId + " / MEM_PASS : "
						+ memPass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 역순으로 닫아야함
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

		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "select b.mem_name, C.Prod_Name, a. cart_qty"
					+ "from cart a, member b, prod c"
					+ "where a.cart_member = b.mem_id"
					+ "and A.Cart_Prod = c. prod_id";
			ps = con.prepareStatement(sql);

			// select
			rs = ps.executeQuery();

			// insert, update, delete
			// int result = ps.executeUpdate(); //영향받은 행(row)의 수를 리턴

			// --result 값의 다음 행이 있는지
			while (rs.next()) {
				String mem_name = rs.getString(1);
				String prod_name = rs.getString(2);
				String cart_qty = rs.getString(3);
				System.out.println("주문자 : " + mem_name + "/ 주문 상품 : "
						+ prod_name + " / 주문 수량 : " + cart_qty);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 역순으로 닫아야함
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
	}
}
