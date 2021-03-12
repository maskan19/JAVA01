package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class FilmDao {

	private static FilmDao instance;

	private FilmDao() {
	}

	public static FilmDao getInstance() {
		if (instance == null) {
			instance = new FilmDao();
		}
		return instance;
		// 싱글톤 패턴
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();
	//전체 영화 리스트
	public List<Map<String, Object>> selectMovielist() {
		String sql = "SELECT FILMCODE, FILMNAME, NVL(FILMRATING,'미           정') AS FILMRATING, NVL(RUNTIME,0)AS RUNTIME,NVL( RELEASEDATE,TO_DATE('3000/01/01'))AS RELEASEDATE, NVL(GENRE,'미           정')AS GENRE, NVL(COUNTRY,'미           정')AS COUNTRY, NVL(DIRECTOR,'미           정')AS DIRECTOR, NVL(ACTOR,'미           정')AS ACTOR, NVL(SUMMARY,' ') AS SUMMARY, URL FROM FILM order by releasedate desc";
		return jdbc.selectList(sql);
	}

	//상영중 영화(3달동안 상영) 리스트
	public List<Map<String, Object>> selectMovielist_now() {
		String sql = "SELECT * FROM FILM where releasedate<=sysdate and releasedate >=add_months(sysdate,-3) order by releasedate desc";
		return jdbc.selectList(sql);
	}
	
	//개봉예정 영화 리스트
	public List<Map<String, Object>> selectMovielist_coming() {
		String sql = "SELECT trunc(NVL( RELEASEDATE,TO_DATE('3000/01/01'))-sysdate) as d_day, a.FILMCODE, a.FILMNAME, NVL(a.FILMRATING,'미           정') AS FILMRATING, NVL(a.RUNTIME,0)AS RUNTIME, NVL( a.RELEASEDATE,TO_DATE('3000/01/01'))AS RELEASEDATE, NVL(a.GENRE,'미           정')AS GENRE, NVL(a.COUNTRY,'미           정')AS COUNTRY, NVL(a.DIRECTOR,'미           정')AS DIRECTOR, NVL(a.ACTOR,'미           정')AS ACTOR, NVL(a.SUMMARY,' ') AS SUMMARY, a.URL FROM (select * from FILM where NVL( RELEASEDATE,TO_DATE('3000/01/01'))>sysdate order by releasedate) a";
		return jdbc.selectList(sql);
	}
	
	//상영 종료 영화 리스트
//	public List<Map<String, Object>> selectMovielist_over() {
//		String sql = "SELECT * FROM FILM where releasedate <add_months(sysdate,-3) order by releasedate desc";
//		return jdbc.selectList(sql);
//	}
	
	
	
	
	
	public Map<String, Object> selectMovieInfo(List<Object> param) {
		String sql = " SELECT FILMCODE, FILMNAME, NVL(FILMRATING,'미           정') AS FILMRATING, NVL(RUNTIME,0)AS RUNTIME,NVL( RELEASEDATE,TO_DATE('3000/01/01'))AS RELEASEDATE, NVL(GENRE,'미           정')AS GENRE, NVL(COUNTRY,'미           정')AS COUNTRY, NVL(DIRECTOR,'미           정')AS DIRECTOR, NVL(ACTOR,'미           정')AS ACTOR, NVL(SUMMARY,' ') AS SUMMARY, URL FROM FILM where filmcode = ? ";
		return jdbc.selectOne(sql, param);
	}
	
	public List<Map<String, Object>> selectMoviecomments(List<Object> param) {
		String sql = " SELECT *" + " FROM COMMENTS" + " WHERE FILMCODE = ?";
		return jdbc.selectList(sql, param);
	}
	
	
	public int insertComments (List<Object> param){ //id, 영화코드, 별점, 한줄평
		String sql = "INSERT INTO comments select tnum, ?, ?, ?, ? from ( SELECT NVL(MAX(comcode), 0) + 1 as tnum from comments)"; 
		return jdbc.update(sql, param);
	}
	
	public int updateComments (List<Object> param){ //별점, 한줄평, 아이디, 필름코드
		String sql = "UPDATE COMMENTS SET COMSTAR = ? , COMLINE = ? WHERE MEM_ID = ? AND FILMCODE = ?"; 
		return jdbc.update(sql, param);
	}
	
	//실관람객
	public Map<String, Object> movieCheck (List<Object> param){//id , 필름코드
		String sql = "select b.mem_id, b. bookcode, T.Filmcode from booking b, timetable t where b.timecode = t.timecode and b.mem_id = ? and t.filmcode = ?";
		return jdbc.selectOne(sql, param);
	}
	
	//댓글 전적
	public Map<String, Object> comCheck (List<Object> param){//id , 필름코드
		String sql = "select * from comments where mem_id = ? and filmcode = ?";
		return jdbc.selectOne(sql, param);
	}
	//댓글 삭제
	public int comDelete (List<Object> param){//id , 필름코드
		String sql = "delete from comments where mem_id = ? and filmcode = ?";
		return jdbc.update(sql, param);
	}

	
	public Map<String, Object> getURL (List<Object> param){//필름코드
		String sql = "select URL from film where filmcode = ?";
		return jdbc.selectOne(sql, param);
	}
	


	
	
	
}
