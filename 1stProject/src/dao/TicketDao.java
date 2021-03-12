package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class TicketDao {

   private static TicketDao instance;

   private TicketDao() {
   }

   public static TicketDao getInstance() {
      if (instance == null) {
         instance = new TicketDao();
      }
      return instance;
      // 싱글톤 패턴
   }

   private JDBCUtil jdbc = JDBCUtil.getInstance();

   public List<Map<String, Object>> selectBoardList() {
      // 상영관 리스트 조회
      String sql = "SELECT * FROM CINEMA";
      return jdbc.selectList(sql);
   }

   public List<Map<String, Object>> select_Member() {
      // 회원 조회
      String sql = "SELECT * FROM MEMBER";
      return jdbc.selectList(sql);
   }

   public List<Map<String, Object>> select_NoMember() {
      // 비회원 조회
      String sql = "SELECT * FROM NMEM";
      return jdbc.selectList(sql);
   }

   public List<Map<String, Object>> Time_BoardList(List<Object> list) {
      // 영화지점코드
      String sql = "SELECT DISTINCT c.timecode,D.filmname ,C.hallcode, c.tt_start,c.tt_end"
            + " FROM CINEMA a"
            + " INNER JOIN HALL b"
            + "   ON A.cinemacode = b.cinemacode "
            + " INNER JOIN timetable C "
            + "   ON B.hallcode = C.hallcode "
            + " INNER JOIN film D "
            + "   ON C.FILMCODE = D.FILMCODE "
            + " WHERE a.cinemacode = ?"
            + " ORDER BY C.timecode , D.filmname";

      return jdbc.selectList(sql, list);
   }

   public Map<String, Object> select_TICKET_TIME(List<Object> list) {
      // 상영시간
      String sql = "SELECT DISTINCT c.timecode,D.filmname ,C.hallcode, c.tt_start,c.tt_end"
            + " FROM CINEMA a"
            + " INNER JOIN HALL b"
            + "   ON A.cinemacode = b.cinemacode "
            + " INNER JOIN timetable C "
            + "   ON B.hallcode = C.hallcode "
            + " INNER JOIN film D "
            + "   ON C.FILMCODE = D.FILMCODE "
            + " WHERE c.timecode = ?" + " ORDER BY C.timecode , D.filmname";

      return jdbc.selectOne(sql, list);
   }

   public Map<String, Object> select_CINEMA(List<Object> list) {
      // 상영관 이름
      String sql = "select * from CINEMA " + " where CINEMACODE = ?";

      return jdbc.selectOne(sql, list);
   }

   public int Booking__MEM_Insert(List<Object> list) {
      // 회원 생성

      String sql = "Insert into BOOKING (BOOKCODE,MEM_ID,HALLCODE,TIMECODE,PRICE2,PRICE3,PRICE1,TOTALPRICE)"
            + "  values (?,?,?,?,?,?,?,?)";

      return jdbc.update(sql, list);

   }
   
   public int Calculation_update(List<Object> list) {
      String sql = "UPDATE BOOKING "
               + " SET PAYMENT = ?"
                  + " WHERE mem_id = ?";
      return jdbc.update(sql, list);

   }
   

   public int Booking__NMEM_Insert(List<Object> list) {

      // 비회원 생성
      String sql = "Insert into BOOKING (BOOKCODE,NMEM_ID,HALLCODE,TIMECODE,PRICE2,PRICE3,PRICE1,TOTALPRICE,PAYMENT)"
            + "  values (?,?,?,?,?,?,?,?,?)";

      return jdbc.update(sql, list);

   }
   
   public int NMEM_Insert(List<Object> list) {

      // 비회원 생성
      String sql = "Insert into nmem "
            + "  values (?,?,2)";

      return jdbc.update(sql, list);

   }
   
   
   public Map<String, Object> mem_mil(List<Object> param) {
      String sql = "select MEM_MIL from member"
                  + "  where mem_id=?";
      return jdbc.selectOne(sql,param);
   }

   
   
   public List<Map<String, Object>> Seat_List(List<Object> list) {
      // 상영관 리스트 조회
      String sql = "select DISTINCT A.SEATCODE,A.HALLCODE,A.SEATROW,A.SEATNUM"
            + "   from seats A"
            + "   INNER JOIN HALL B"
            + "    ON A.hallcode = b.hallcode "
            + "   INNER JOIN TIMETABLE C"
            + "    ON C.hallcode = B.hallcode "
            + "   where B.CINEMACODE = ?"
            + "   AND C.hallcode = ?" + "  ORDER BY A.SEATCODE,A.SEATNUM";
      return jdbc.selectList(sql, list);
   }

   public int SEATSET_Insert(List<Object> list) {

      // 비회원 생성
      String sql = "INSERT INTO SEATSET  select tnum,?,?"
            + " from (SELECT NVL(MAX(SET_CODE),0)+1 as tnum from SEATSET)";

      return jdbc.update(sql, list);
   }

   public Map<String, Object> M_SEATSET_List(List<Object> list) {
      // 좌석 묶음 리스트 조회
      String sql = " select H.CINEMANAME, B.BOOKCODE,G.FILMNAME,E.HALLNAME,D.SEATROW,D.SEATNUM from member A      inner join BOOKING B        ON A.MEM_ID=B.MEM_ID     inner join SEATSET C        ON B.BOOKCODE=C.BOOKCODE     inner join SEATS D        ON D.SEATCODE=C.SEATCODE     inner join TIMETABLE F        ON F.TIMECODE=B.TIMECODE     inner join FILM G        ON F.FILMCODE=G.FILMCODE     inner join HALL E        ON E.HALLCODE=F.HALLCODE     inner join CINEMA H        ON H.CINEMACODE=E.CINEMACODE             WHERE A.MEM_ID = ? AND B.BOOKCODE = ? AND D.SEATCODE = ? ";
      System.out.println(sql);
      return jdbc.selectOne(sql, list);
   }

   public Map<String, Object> NM_SEATSET_List(List<Object> list) {
      // 좌석 묶음 리스트 조회
      String sql = "select  h.cinemaname, b.bookcode, g.filmname,  e.hallname, d.seatrow, d.seatnum from nmem a INNER JOIN booking b ON b.nmem_id = a.nmem_id INNER JOIN seatset c ON b.bookcode = c.bookcode INNER JOIN seats d ON d.seatcode = c.seatcode INNER JOIN timetable f ON f.timecode = b.timecode INNER JOIN film g ON f.filmcode = g.filmcode INNER JOIN hall e ON e.hallcode = f.hallcode INNER JOIN cinema h ON h.cinemacode = e.cinemacode WHERE a.nmem_id = ? AND  b.bookcode = ? AND d.seatcode = ? ";
      System.out.println(sql);
      return jdbc.selectOne(sql, list);
   }
   
   public Map<String, Object> tk_chek(List<Object> param) {
      String sql = " select C.CINEMANAME,B.HALLNAME,F.SEATROW,F.SEATNUM "
               +        " from BOOKING A      "
               +      " INNER JOIN HALL B    "
               +      "     ON A.HALLCODE = B.HALLCODE    "
               +      " INNER JOIN CINEMA C "
               +      "     ON C.CINEMACODE = b.CINEMACODE    "
               +      " INNER JOIN SEATSET G    "
               +      "     ON A.BOOKCODE = G.BOOKCODE    "   
               +      " INNER JOIN SEATS F "
               +      "     ON G.SEATCODE = F.SEATCODE   "     
               +      " where A.BOOKCODE= ?";
      
      
      return jdbc.selectOne(sql,param);
   }
////   public Map<String, Object> tk_chek(List<Object> list){
//   public Map<String, Object> tk_chek(List<Object> param) {
//      
//      String sql  = "  SELECT HALLCODE,TIMECODE,TOTALPRICE "
//                + " FROM  BOOKING A  "
//               + " where A.BOOKCODE= ?";
//      
//      
//      return jdbc.selectOne(sql,list);
//   }
//   
   
   
}