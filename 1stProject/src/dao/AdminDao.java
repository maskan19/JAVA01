package dao;

import java.util.List;
import java.util.Map;

import service.AdminService;
import util.JDBCUtil;


public class AdminDao {
   private static AdminDao instance;

   private AdminDao() {}

   public static AdminDao getInstance() {
      if (instance == null) {
         instance = new AdminDao();
      }
      return instance;
      // 싱글톤 패턴
   }
   
   
   private JDBCUtil jdbc = JDBCUtil.getInstance();
   
   
   
   public List<Map<String, Object>> selectBoardList() {
      String sql = "select mem_id,mem_name,mem_pn,MEM_BIRTH,MEM_MIL,"
            + " CASE WHEN MEM_ACC = 1 THEN '정회원' ELSE '비회원' END AS MEM_ACC"
            + " from member"
            + " where not mem_id = 'ADMIN'";
      return jdbc.selectList(sql);
   }
   
   
   public List<Map<String, Object>> select_Member() {
      //회원 조회
      String sql = "SELECT * FROM MEMBER";
      return jdbc.selectList(sql);
   }
   

   
   
   public int mem_update(List<Object> list) {
   
      String sql = "UPDATE member SET mem_id = ?,"
                           + "  mem_pw = ?,"
                           + " mem_name= ?,"
                           + " mem_pn  = ? "
                           + " WHERE mem_id = ?";

      return jdbc.update(sql, list);
   }

   
   public int mem_delete(List<Object> list) {

      String sql = "DELETE Member where mem_id = ?";
      
      return jdbc.update(sql, list);
   }
   
 
    public int cm_Insert(List<Object> list) {
       
      String sql ="INSERT INTO CINEMA  select tnum, ?, ?"
               +   " from (SELECT NVL(MAX(CINEMACODE),0)+1 as tnum from CINEMA)";


      return jdbc.update(sql, list);   
   }

   public List<Map<String, Object>> select_Cinema() {
      //영화 정보 조회
      String sql = "SELECT * FROM CINEMA";
      
      return jdbc.selectList(sql);
   }
   
   public int cm_delete(List<Object> list) {

      String sql = "DELETE Cinema where  CINEMACODE= ?";
      
      return jdbc.update(sql, list);
   }
   
   
   public int cm_update(List<Object> list) {
      
      String sql = "UPDATE member SET  CINEMANAME = ?,"
                           + "  CINEMAINFORM= ?"
                           + "  WHERE CINEMACODE = ?";

      return jdbc.update(sql, list);
   }
   public int Mv_update(List<Object> list) {
      //영화 수정
      String sql = "UPDATE member SET  CINEMANAME = ?,"
                           + "  CINEMAINFORM= ?"
                           + "  WHERE CINEMACODE = ?";

      return jdbc.update(sql, list);
   }
   

   
   public List<Map<String, Object>> Mv_select() {
      //영화 정보 조회
      
      String sql ="SELECT * FROM FILM";
      
      return jdbc.selectList(sql);
   }
   
   public int Mv_insert(List<Object> list) {
       
      String sql ="Insert into FILM select tnum,?,?,?,?,?,?,?,?,?,? "
            + " from (SELECT NVL(MAX(FILMCODE),0)+1 as tnum from FILM)";

      //      to_date('2020/12/28 00:00:00','YYYY/MM/DD HH24:MI:SS')
     
      return jdbc.update(sql, list);   
   }
   public Map<String, Object> Mv_lookup (List<Object> list){
      //상영관 이름
      String sql =  "select * from film"
                +  " where FILMCODE = ?";
        
      return jdbc.selectOne(sql, list);
   }
      
   
      public int mv_delete(List<Object> list) {

           String sql = "DELETE FIlm where  FILMCODE= ?";
            
           return jdbc.update(sql, list);
       }
 
       public int mv_updaet(List<Object> list){
          
          
          String sql = "UPDATE FILM SET FILMNAME = ?, "
                           +  " FILMRATING = ?, "
                            + " RUNTIME= ?, "
                           +  " RELEASEDATE  = ?, "
                         +    " GENRE  = ?,"
                       +      " COUNTRY  = ?, "
                       +      " DIRECTOR  = ?, "
                      +       " ACTOR  = ?, "
                      +       " SUMMARY = ?, "
                      +       " URL  = ?"
                     +        " WHERE FILMCODE = ?";
          
          return jdbc.update(sql,list);
          
       }
      
       public List<Map<String, Object>> COM_SELECT() {
             //영화 정보 조회
             
             String sql ="SELECT * FROM COMMENTS"; //오다바이
             
             return jdbc.selectList(sql);
          }
     
      
       public int COM_delete(List<Object> list) {

           String sql = "DELETE COMMENTS where  COMCODE= ?";
            
           return jdbc.update(sql, list);
       }
   
       public List<Map<String, Object>> HaSeat_select() {
             //영화 정보 조회
             
             String sql ="select  C.CINEMANAME, A.hallcode,b.seatrow,b.seatnum"
                     +   " from hall A, seats B, CINEMA C"
                     +   " where a.HALLCODE =b.HALLCODE"
                     +   " and   a.CINEMACODE = c.CINEMACODE"
                     +   " order by C.CINEMANAME";
             
             return jdbc.selectList(sql);
        }
          
       public int HALL_insert(List<Object> list) {
           
             String sql ="insert into HALL VALUES(?,?,?)";
            
             return jdbc.update(sql, list);   
          }
       
       public int HALL_delete(List<Object> list) {

           String sql = "DELETE hall where  hallCODE= ?";
            
           return jdbc.update(sql, list);
       }
       
       public List<Map<String, Object>> HALL_SELECT() {
             //영화 정보 조회
             
             String sql ="SELECT * FROM HALL"; //오다바이
             
             return jdbc.selectList(sql);
          }
       public List<Map<String, Object>> SEAT_SELECT() {
          //영화 정보 조회
          
              String sql ="SELECT * FROM seats order by 1"; //오다바이
          
             return jdbc.selectList(sql);
       }
     
       public int SEAT_insert(List<Object> list) {
           
         String sql ="INSERT INTO SEATS(SEATCODE,HALLCODE,SEATROW,SEATNUM)  select tnum,?,?,?"      
                      +" from (SELECT NVL(MAX(SEATCODE),0)+1 as tnum from SEATS)";
     
    
          return jdbc.update(sql, list);   
       }
       public int SEAT_delete(List<Object> list) {

           String sql = "DELETE SEATS where  SEATCODE= ?";
            
           return jdbc.update(sql, list);
       }
       
       
       
       
       
       
       
}