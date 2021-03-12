package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JJS0911";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from member where mem_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001"); //? 의 인덱스, 넣을 값
//			ps.setInt(parameterIndex, x);
//			ps.setObject(parameterIndex, x);
			
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData(); //메타데이터 : 데이터에 대한 데이터
			//컬럼의 갯수를 알아내야함
			int columnCount = md.getColumnCount(); // 컬럼의 수
						
			while (rs.next()) {
			
				for(int i = 1; i<=columnCount; i++){
					
					System.out.print(rs.getObject(i)+ "\t"
							+ md.getColumnName(i));
				}System.out.println();
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
			String sql = "insert into lprod values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 11);
			ps.setString(2, "P601");
			ps.setString(3, "식품");
			// select
//			rs = ps.executeQuery();

			// insert, update, delete
			 int result = ps.executeUpdate(); //영향받은 행(row)의 수를 리턴
			 System.out.println("영향받은 행의 수 :" +result);

			// --result 값의 다음 행이 있는지
//			while (rs.next()) {
//				String mem_name = rs.getString(1);
//				String prod_name = rs.getString(2);
//				String cart_qty = rs.getString(3);
//				System.out.println("주문자 : " + mem_name + "/ 주문 상품 : "
//						+ prod_name + " / 주문 수량 : " + cart_qty);
//			}

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
