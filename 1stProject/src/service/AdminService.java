package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.Validation;
import util.View;
import dao.AdminDao;

public class AdminService {
   
   private static AdminService instance;

   private AdminService() {
   }

   public static AdminService getInstance() {
      if (instance == null) {
         instance = new AdminService();
      }
      return instance;
      // 싱글톤 패턴
   }
   
   
   
   
   private AdminDao adminDao = AdminDao.getInstance();

   Object member_Id = null;
   
   public int CINEMA_INFO(){
         //지점 페이지 관련 홈
         System.out.println("------------------------------------------------------------------------------");
         System.out.println("\n\n\t\t\t\t[1].영화지점\n\n\t\t\t\t[0].관리자메인\n\n");
         System.out.println("------------------------------------------------------------------------------");
         System.out.print("\n\n\t\t\t\t입력>");
         int input = ScanUtil.nextInt();
         switch (input) {

         case 1:
            CM_Cinema();  //영화관 지점 수정 및 삭제  지점 수정
            break;

         case 0:
            return View.ADMINPAGE;

         }
         return View.ADMINPAGE;
      
  
   }
   
   
   public int movie_info() {
      // 영화 페이지 관련 홈
      System.out
            .println("----------------------------------------------------------------------------");
      System.out
            .println("\n\n\t\t\t\t[1].영화\n\n\t\t\t\t[2].영화평\n\n\t\t\t\t[0].관리자메인\n\n");
      System.out
            .println("----------------------------------------------------------------------------");
      System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();
      switch (input) {

      case 1:
         movie();// /영화 정보 수정및 삭제
         break;
      case 2:
         comment();// 영화평관리

         break;

      case 0:
         return View.ADMINPAGE;

      }
      return 0;

   }
   
   
   public int memList() {
      //회원 테이블 관리하는 페이지
      List<Map<String, Object>> boardList = adminDao.selectBoardList();
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t회원 관리 테이블\n\n");
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("아이디 \t\t 이름 \t 핸드폰번호 \t\t 생년월일\t\t\t 마일리지 \t 회원등급");
      System.out.println("------------------------------------------------------------------------------");
      for(int i=0; i< boardList.size();i++){
         Map<String, Object> board =boardList.get(i);
         System.out.println(     board.get("MEM_ID")   + "\t\t"
                        + board.get("MEM_NAME") + "\t"
                        + board.get("MEM_PN") + "\t"
                        + board.get("MEM_BIRTH") + "\t"
                        + board.get("MEM_MIL") + "\t"
                        + board.get("MEM_ACC"));
      }
      
      System.out.println("----------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[1].수정\n\n\t\t\t\t[2].삭제\n\n\t\t\t\t[0].관리자메인\n\n");
      System.out.println("----------------------------------------------------------------------------");
      System.out.print("\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();
      switch (input) {
      case 1:
         System.out.println("\n\n\t\t\t\t수정할 아이디를 입력하세요\n");
         System.out.print("\n\t\t\t\t입력>");
         member_Id = ScanUtil.nextLine();
         memID_check(member_Id);
         member_update(member_Id);

            break;
      case 2:

         System.out.println("\n\n\t\t\t\t삭제할 아이디를 입력하세요\n");
         System.out.print("\n\t\t\t\t입력>");
         member_Id = ScanUtil.nextLine();
         memID_check(member_Id);
         member_delect(member_Id);

         
         break;
      case 0:
         return View.ADMINPAGE;
      }

      return View.ADMINPAGE;
   }

   public int memID_check(Object memid) {
      int x = 0;
      boolean check = false;
      Map<String, Object> board = null;

      ID: while (true) {
         List<Map<String, Object>> Mem_List = adminDao.select_Member();
         for (int i = 0; i < Mem_List.size(); i++) {
            board = Mem_List.get(i);
            //System.out.println(board.get("MEM_ID"));
            if (memid.equals(board.get("MEM_ID"))) {
               //System.out.println("나와");
               member_Id = memid;
               x = 1;
               check = true;
               break ID;
            }
         }
         if (check != true) {
            System.out.println("\n\n\t\t\t\t회원ID를 다시 입력하세요(0.메인메뉴로)");
            System.out.print("\n\n\t\t\t\t입력>");
            memid = ScanUtil.nextLine();
         }else if (memid.equals("0")) {
            return View.MAIN;
         }

      }

   
      return 0;
   }
   
   
   
   
   
   
   
   
   
   
   void member_delect(Object member){
      ///유저 삭제 ////////
       
      List<Object> test = new ArrayList<>();
      test.add(member);
      int result = adminDao.mem_delete(test);
      System.out.println(result);
      if (result > 0) {
         System.out.println("\n\n\t\t\t\t회원이 삭제되었습니다.");
      } else {
         System.out.println("\n\n\t\t\t\t※※※※※※데이터 취소및 메인페이지로※※※※※※※");
      }

   }
   
   
   
   
   
   
    void member_update(Object mem) {
          int result;
         System.out.println("\n\n\t\t\t\tID : 영어소문자와 숫자로 이루어진 12자 이내");
         System.out.print("\n\t\t\t\t입력>");
         String ID = ScanUtil.nextLine();
         ID = Validation.ALNU(ID);
         
         System.out.println("\n\n\t\t\t\tPW : 영대소문자 특문 12자 이내.");
         System.out.print("\n\t\t\t\t입력>");
         String PW = ScanUtil.nextLine();
         
         System.out.println("\n\n\t\t\t\tNAME : 한글 12자 이내");
         System.out.print("\n\t\t\t\t입력>");
         String NAME = ScanUtil.nextLine();
         
         NAME = Validation.KOR(NAME);
         System.out.println("\n\n\t\t\t\tPHONE : 연락처 ");
         System.out.print("\n\t\t\t\t입력>");
         String PN = ScanUtil.nextLine();
         PN = Validation.PN(PN);
      
         
         List<Object> test = new ArrayList<>();
         test.add(ID);
         test.add(PW);
         test.add(NAME);
         test.add(PN);
         test.add(member_Id);
         result = adminDao.mem_update(test);
         
         if(result>0 ){
            System.out.println("\n\n\t\t\t\t아이디 "+member_Id +"가 데이터가 수정 되었습니다.\n\n");
         }else{
            System.out.println("\n\n\t\t\t\t※※※※※※※※※!!오류입니다!!※※※※※※※※※");
      
         }

    }
   
   
   

   
    


   
   
    public int comment() {
       ///////--------------------------------------영화평---------------------------------
      
       List<Map<String, Object>> boardList = adminDao.COM_SELECT();
       System.out.println("----------------------------------------------------------------------------");
       System.out.println("\n\n\t\t\t\t[영화평 관리]\n\n");
        System.out.println("번호\t아이디\t영화이름\t별점\t한줄평");
        System.out.println("----------------------------------------------------------------------------");
        for(int i=0; i< boardList.size();i++){
           Map<String, Object> board =boardList.get(i);
           System.out.println(      board.get("COMCODE")   + "\t"
                                 +  board.get("MEM_ID")   + "\t" 
                                 +  board.get("FILMCODE")   + "\t" 
                                 +  board.get("COMSTAR")   + "\t" 
                               +  board.get("COMLINE"));
        }   

        System.out.println("\n\n\t\t\t\t[1].삭제\n\n\t\t\t\t[0].관리자 메인");
        System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();   
    
      switch (input) {
      case 1:
         com_delete();
         break;
       case 0:
         return View.ADMINPAGE;

      }
      return 0;
   }

    
    
    
   public void com_delete() {
        //-------------------------코멘트 삭제 -------------------////////
       
         System.out.println("\n\n\t\t\t\t삭제 할 번호를 입력하세요");
         int num = ScanUtil.nextInt();
         List<Object> test = new ArrayList<>();
         test.add(num);
         int result = adminDao.COM_delete(test);
         System.out.println(result);
         if (result > 0) {
            System.out.println("\n\n\t\t\t\t데이터가 삭제되었습니다.");
         } else {
            System.out.println("\n\n\t\t\t\t※※※※※※데이터 취소및 메인페이지로※※※※※※※");
         }

   }

public int CM_Cinema() {
      //영화정보------------------------------------------------------------------
     //상영관 및 좌석--------------------------------------
   
     List<Map<String, Object>> boardList = adminDao.select_Cinema();
      System.out.println("-------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[지점 정보]");
      System.out.println("지점 코드 \t지점 이름\t\t주소");
      System.out.println("-------------------------------------------------------------------------------");
      for(int i=0; i< boardList.size();i++){
         Map<String, Object> board =boardList.get(i);
         System.out.println(     board.get("CINEMACODE")   + "\t"
                        + board.get("CINEMANAME")    +"\t"
                        + board.get("CINEMAINFORM"));
         
      }   
      List<Object> cm_num = new ArrayList<>();
      int mv_num;
      int i;
      System.out.println("------------------------------------------------------------------------------");
            System.out.println("\n\n\t\t\t\t[1].지점 등록\n\n\t\t\t\t[2].지점 수정\n\n\t\t\t\t[3].지점 삭제"
            + "\n\n\t\t\t\t[4].상영관 및 좌석\n\n\t\t\t\t[0].관리자 메인\n\n");
      System.out.println("------------------------------------------------------------------------------");
      System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();
      switch (input) {
      case 1:
         cm_Enrollment();
         return View.ADMINPAGE;
         
         
      case 2:
         System.out.println("\n\n\t\t\t\t수정할 지점 코드를 입력하세요.");
         System.out.print("\n\n\t\t\t\t입력>");
         mv_num = ScanUtil.nextInt();
         cm_update(mv_num);
         return View.ADMINPAGE;
   
      case 3:
         System.out.println("\n\n\t\t\t\t삭제할 지점 코드를 입력하세요.");
         System.out.print("\n\n\t\t\t\t입력>");
         mv_num = ScanUtil.nextInt();
         cm_num.add(mv_num);
         i = adminDao.cm_delete(cm_num);
         if(i >0){
            System.out.println("\n\n\t\t\t\t삭제 완료");
         }else{
            System.out.println("");
         }
         return View.ADMINPAGE;
      case 4:
         CM_HallSeat();
         break;
         
      case 0:
         return View.ADMINPAGE;

      }
      return View.ADMINPAGE;
      
   }

    
   public int CM_HallSeat() {
   //영화 지점이랑 좌석번호 생성및 삭제   ------------------------------------------
     
      List<Map<String, Object>> boardList = adminDao.HaSeat_select();
         System.out.println("------------------------------------------------------------------------------");
         System.out.println("영화관\t\t상영관\t좌석 번호 이름");
         System.out.println("------------------------------------------------------------------------------");
         for(int i=0; i< boardList.size();i++){
            Map<String, Object> board =boardList.get(i);
            System.out.println(      board.get("CINEMANAME") +"\t"
                               +  board.get("HALLCODE") +  "\t"
                               +  board.get("SEATROW") 
                              +  board.get("SEATNUM"));
        }  
         System.out.println("------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("\n\n\t\t\t\t[1].상영관 관리\n\n\t\t\t\t[2]좌석 관리\n\n\t\t\t\t[0].관리자 메인\n\n");
         System.out.println("------------------------------------------------------------------------------");
        System.out.print("입력>");
         int input = ScanUtil.nextInt();
         switch (input) {
         case 1:
          //상영관 관리
             List<Map<String, Object>> hallList = adminDao.HaSeat_select();
             System.out.println("------------------------------------------------------------------------------");
             System.out.println("지점 번호\t상영관 번호\t상영관  이름");
             System.out.println("------------------------------------------------------------------------------");
             for(int i=0; i< hallList.size();i++){
               Map<String, Object> board =hallList.get(i);
               System.out.println(      board.get("CINEMACODE") +  "\t"
                                  +  board.get("CINEMANAME") +  "\t"
                                  +  board.get("CINEMAINFORM"));
            }  
            System.out.println("\n\n\t\t\t\t[1].상영관 등록\n\n\t\t\t\t[2].상영관 삭제\n\n\t\t\t\t[0].관리자 메인");
            System.out.print("\n\t\t\t\t입력>");
            int hallnum = ScanUtil.nextInt();
            switch(hallnum){
               case 1:
                  hall_Enrollment();
                   break;
               case 2:
                  hall_delete();
                  break;
               
                case 0:
                   
                   //관리자 메인페이지
                   return View.ADMINPAGE;
           }
      
              break;
         
         case 2:
             //자리관리
             List<Map<String, Object>> seatList = adminDao.SEAT_SELECT();
             System.out.println("------------------------------------------------------------------------------");
             System.out.println("상영관 번호\t좌석 번호\t좌석  ");
             System.out.println("------------------------------------------------------------------------------");
             for(int i=0; i< seatList.size();i++){
               Map<String, Object> board =seatList.get(i);
               System.out.println(      board.get("HALLCODE") +  "\t"
                                  +  board.get("SEATCODE") +  "\t"
                                  +  board.get("SEATROW") 
                                  +  board.get("SEATNUM"));
            }
            System.out.println("------------------------------------------------------------------------------"); 
            System.out.println("\n\n\t\t\t\t[1].좌석 등록\n\n\t\t\t\t[2].좌석 삭제\n\n\t\t\t\t[0].관리자 메인\n\n");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("\n\t\t\t\t입력>");
            int SeatNum = ScanUtil.nextInt();
            switch(SeatNum){
               case 1:
                  Seat_Enrollment();
                   break;
               case 2:
                  Seatl_delete();
                  break;
               
                case 0:
                   
                   //관리자 메인페이지
                   return View.ADMINPAGE;
           }
                break;
   
         case 0:
            //관리자 메인페이지
            return View.ADMINPAGE;

         }
         
      return View.ADMINPAGE;
        
        
        
   }

   
   
   


   public int Seat_Enrollment() {
      // 상영관 생성함
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\t\t\t\t등록 가능한 상영관의 자리");
      List<Map<String, Object>> boardList = adminDao.HALL_SELECT();
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("상영관 번호\t상영관이름");
      System.out.println("------------------------------------------------------------------------------");
      for (int i = 0; i < boardList.size(); i++) {
         Map<String, Object> board = boardList.get(i);
         System.out.println(  board.get("HALLCODE") + "\t"
                        + board.get("HALLNAME"));
      }
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t※!상영관 코드가 같아야 등록 가능!※\n\n");
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t상영관 코드를 입력하세요.");
      int H_num = ScanUtil.nextInt();

//      System.out.println("등록할 자리번호를 입력하세요.");
//      int Seat_num = ScanUtil.nextInt();

      System.out.println("\n\n\t\t\t\t등록할 좌석행을 입력하세요. ex) A,B,C,D,...");
      System.out.println("\n\n\t\t\t\t※알파벳 대문자만 가능(A~Z)※");
      String S_ROW = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t등록할 좌석열을 입력하세요.");
      int S_NUM = ScanUtil.nextInt();
      
      List<Object> test = new ArrayList<>();
      test.add(H_num);
//      test.add(Seat_num);
      test.add(S_ROW);
      test.add(S_NUM);

      int result = adminDao.SEAT_insert(test);

      if (result > 0) {
         System.out.println("┌-------------------------------------------┐");
         System.out.println("|-------------상영관 데이터 생성에 성공했습니다.----------|");
         System.out.println("└-------------------------------------------┘");
      } else {
         System.out.println("┌----------------------------------┐");
         System.out.println("|-----데이터 생성에 실패했습니다.(번호 중복)---|");
         System.out.println("└----------------------------------┘");
      }

      return View.ADMINPAGE;
   }
   
   
   
   public int Seatl_delete() {
      int result;
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t삭제할 자리 번호를 입력하세요");
      System.out.print("\n\n\t\t\t\t입력>");
      int mv_code = ScanUtil.nextInt();
      System.out.println("------------------------------------------------------------------------------");
      List<Object> test = new ArrayList<>();
      test.add(mv_code);
      result = adminDao.SEAT_delete(test);
      if (result > 0) {
         System.out.println("\n\n\t\t\t\t상영관  " + mv_code + "의 데이터가 삭제되었습니다.");
      } else {
         System.out.println("\n\n\t\t\t\t※※※※※※※※※※데이터 에러※※※※※※※※※※");

      }
      return View.ADMINPAGE;
      
      }
         
   

   public int hall_Enrollment() {
      //상영관 생성함
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\n\n\t\t\t\t등록 가능한 영화관의 상영관---------\n\n");
        List<Map<String, Object>> boardList = adminDao.select_Cinema();
        System.out.println("----------------------------------------------------------------------------");
         System.out.println("영화관 코드\t영화관이름");
         System.out.println("----------------------------------------------------------------------------");
         for(int i=0; i< boardList.size();i++){
            Map<String, Object> board =boardList.get(i);
            System.out.println(      board.get("CINEMACODE") +"\t"
                               +  board.get("CINEMANAME"));
         }  
         System.out.println("----------------------------------------------------------------------------");
         System.out.println("\n\n\t\t\t\t※!영화관 코드가 같아야 등록 가능!※");
        
         System.out.println("\n\n\t\t\t\t영화관 코드를 입력하세요.");
         System.out.print("\n\n\t\t\t\t입력>");
         int num = ScanUtil.nextInt();
         
         System.out.println("\n\n\t\t\t\t등록할 상영관번호를 입력하세요.");
         System.out.print("\n\n\t\t\t\t입력>");
         int h_num = ScanUtil.nextInt();
         
         System.out.println("\n\n\t\t\t등록할 상영관 이름를 입력하세요. ex) 10관 ,20관,...");
         System.out.print("\n\n\t\t\t\t입력>");
         String h_name = ScanUtil.nextLine();
         
        
         List<Object> test = new ArrayList<>();
         test.add(num);
         test.add(h_num);
         test.add(h_name);

        int result = adminDao.HALL_insert(test);   
         
         
        if(result>0){
            System.out.println("┌-------------------------------------------┐");
            System.out.println("\n\n\t\t\t\t상영관 데이터 생성에 성공했습니다.");
            System.out.println("└-------------------------------------------┘");
         }else{
            System.out.println("┌----------------------------------┐");
            System.out.println("|-----데이터 생성에 실패했습니다.(번호 중복)---|");
            System.out.println("└----------------------------------┘");
         }
      
         
        return View.ADMINPAGE;
   }
   


   public int hall_delete() {
   
      int result;
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t삭제할 상영관 번호를 입력하세요");
      System.out.print("\n\t\t\t\t입력>");
      int mv_code = ScanUtil.nextInt();
      System.out.println("------------------------------------------------------------------------------");
      List<Object> test = new ArrayList<>();
      test.add(mv_code);
      result = adminDao.HALL_delete(test);
      if (result > 0) {
         System.out.println("\n\n\t\t\t\t[상영관 " + mv_code + "의 데이터가 삭제되었습니다].");
      } else {
         System.out.println("\n\n\t\t\t\t※※※※※※※※※※데이터 에러※※※※※※※※※※");

      }
      return View.ADMINPAGE;
   
      
   }

     public void cm_Enrollment() {

      int result;
       SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
      Date time = new Date();
      String time1 = format1.format(time);
    
       System.out.println("\n\n\t\t\t\t[지점  등록 중 ]----------- ");
      
      System.out.println("\n\n\t\t\t\t지점 이름을  입력하세요 ");
      System.out.print("\n\t\t\t\t입력>");
      String name = ScanUtil.nextLine(); 
      
      System.out.println("\n\t\t\t\t지점 주소를 입력하세요 ");
      System.out.print("\n\t\t\t\t입력>");
      String addr = ScanUtil.nextLine();

      System.out.println("------------------------------------------");
      List<Object> test = new ArrayList<>();
      test.add(name);
      test.add(addr);

      result = adminDao.cm_Insert(test)   ;   
      
      
      
      if(result>0){
         System.out.println("┌---------------------------------------------┐");
         System.out.println("\n\t\t\t\tBOARD_NO" +name +"데이터 생성에 성공했습니다.");
         System.out.println("└---------------------------------------------┘");
      }else{
         System.out.println("┌--------------------------------------┐");
         System.out.println("\n\t\t\t\t데이터 생성에 실패했습니다.(번호 중복)");
         System.out.println("└--------------------------------------┘");
      }
   
   }

   public void cm_update(int num){
      int result;
      System.out.println("\n\n\t\t\t\t[수정할 내용을 입력하세요]");
      System.out.println("\n\n\t\t\t\t※[지점 이름 변경]※");
      String name = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t※[지점 주소 변경]※");
      System.out.print("\n\t\t\t\t입력>");
      String addr = ScanUtil.nextLine();

      List<Object> test = new ArrayList<>();
      test.add(name);
      test.add(addr);
      test.add(num);
      result = adminDao.cm_update(test);
      
      if(result>0 ){
         System.out.println("\n\n\t\t\t지점번호 "+num +"가 데이터가 수정 되었습니다.");
      }else{
         System.out.println("\n\n\t\t\t※※※※※※※※※!!오류입니다!!※※※※※※※※※");
   
      }
   }

   public int movie() {
      List<Map<String, Object>> boardList = adminDao.Mv_select();
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[영화 정보]");
      System.out.println("영화코드\t영화관 이름");
      System.out.println("------------------------------------------------------------------------------");
      for(int i=0; i< boardList.size();i++){
         Map<String, Object> board =boardList.get(i);
         System.out.println(     board.get("FILMCODE")   + "\t"
                        + board.get("FILMNAME"));
      }   
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[1].등록\n\n\t\t\t\t[2].조회 \n\n\t\t\t\t[0].관리자 메인\n\n");
     
      System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();
      switch (input) {
      case 1:
         //등록
         mv_Enrollment();
        return View.ADMINPAGE;
      
      
      case 2:
         mv_Lookup();
         break;
      
      
      case 0:
         //관리자 메인페이지
         return View.ADMINPAGE;

      }
      
      return 0;
      
   }
     
   
   public int mv_Lookup() {
     System.out.println("------------------------------------------------------------------------------");
     System.out.println("\n\n\t\t\t\t조회할 테이블 번호를 입력하세요\n\n\t\t\t\t");
     System.out.print("\n\n\t\t\t\t입력>");
     int mv_code = ScanUtil.nextInt();
     List<Object> test = new ArrayList<>();
     test.add(mv_code);
     System.out.println("------------------------------------------------------------------------------");
     Map<String, Object> op = adminDao.Mv_lookup(test);   
      System.out.println(         "[영화 코드번호]------>"  +op.get("FILMCODE") + "\n"
                                 +"[영화 제목]-------->"   + op.get("FILMNAME") + "\n"
                                 +"[관람등급]--------->" + op.get("FILMRATING") + "\n"
                                 +"[런타임]---------->" + op.get("RUNTIME") + "\n"
                                 +"[개봉일]---------->" + op.get("RELEASEDATE") + "\n"
                                 +"[장르]----------->" + op.get("GENRE") + "\n"
                                 +"[국가]----------->" + op.get("COUNTRY") + "\n"
                                 +"[감독]----------->" + op.get("DIRECTOR") + "\n"
                                 +"[배우]----------->" + op.get("ACTOR") + "\n"
                                 +"[시놉시스]--------->" + op.get("SUMMARY")+ "\n"
                                 +"[url]----------->" + op.get("URL") );
      
      
      System.out.println("\n\n\t\t\t\t[1].수정\n\n\t\t\t\t[2].삭제\n\n\t\t\t\t[0].관리자 메뉴");
      System.out.print("\n\t\t\t\t입력>");

      int input = ScanUtil.nextInt();
      switch (input) {
      case 1:
         MV_UPDATE(mv_code);
           break;
      case 2:
          MV_DELECT(mv_code);
      case 0:
          break;
      }
      return View.ADMINPAGE;
      
   }

   public int MV_DELECT(int mv_code) {

      int result;

      System.out.println("------------------------------------------------------------------------------");
      List<Object> test = new ArrayList<>();
      test.add(mv_code);
      result = adminDao.mv_delete(test);
      if (result > 0) {
         System.out.println("\n\n\t\t\t\t영화 코드 " + mv_code + "의 데이터가 삭제되었습니다.");
      } else {
         System.out.println("\n\n\t\t\t\t※※※※※※※※※※데이터 에러※※※※※※※※※※");

      }
      return View.ADMINPAGE;
   
   }
   
   
   public void MV_UPDATE(int mv_code) {
   
      int result;
       SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
       Date time = new Date();
       String time1 = format1.format(time);
       System.out.println("------------------------------------------------------------------------------");
       System.out.println("\n\n\t\t\t\t[영화 수정 중] ");
       System.out.println("------------------------------------------------------------------------------");
       System.out.println("\n\n\t\t\t\t[영화 제목를 입력하세요] ");
       System.out.print("\n\n\t\t\t\t입력>");
       String FILMNAME = ScanUtil.nextLine();

      System.out.println("\n\n\t\t\t\t[관람등급 입력 하세요] ");
      System.out.print("\n\n\t\t\t\t입력>");
      String FILMRATING = ScanUtil.nextLine();

      System.out.println("\n\n\t\t\t\t[런타임 입력 하세요] ");
      System.out.print("\n\n\t\t\t\t입력>");
      int RUNTIME = ScanUtil.nextInt();
      //   
      System.out.println("\n\n\t\t\t\t[개봉일]\n\t\t\t\tex)2020/12/28");//date 타입으로 
      System.out.print("\n\n\t\t\t\t입력>");
      String RELEASEDATE = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[장르 입력 하세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String GENRE = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[국가 입력 하세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String COUNTRY = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[감독 입력 하세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String DIRECTOR = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[배우 입력하세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String ACTOR = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[시놉시스(줄거리)를 입력하세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String SUMMARY = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[URL 입력하세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String URL = ScanUtil.nextLine();
      
      
      System.out.println("------------------------------------------------------------------------------");
      List<Object> test = new ArrayList<>();
   
      test.add(FILMNAME);
      test.add(FILMRATING);
      test.add(RUNTIME);
      test.add(RELEASEDATE);
      test.add(GENRE);
      test.add(COUNTRY);
      test.add(DIRECTOR);
      test.add(ACTOR);
      test.add(SUMMARY);
      test.add(URL);
      test.add(mv_code);
      
      
      result = adminDao.mv_updaet(test);   
      
      
      
      if(result>0){
         System.out.println("┌----------------------------------------------┐");
         System.out.println("\n\n\t\t\t\t\t영화 제목" +FILMNAME +"데이터 수정에 성공했습니다.\n\n");
         System.out.println("└----------------------------------------------┘");
      }else{
         System.out.println("┌-------------------------------------┐");
         System.out.println("\n\n\t\t\t\t\t데이터 생성에 실패했습니다.(번호 중복)");
         System.out.println("└--------------------------------------┘");
      }
      
      }

public void mv_Enrollment() {

       int result;
       SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
       Date time = new Date();
       String time1 = format1.format(time);
    
      System.out.println("\n\n\t\t\t\t<영화 등록 중>");

   
      System.out.println("\n\n\t\t\t\t[영화 제목를 입력하세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String FILMNAME = ScanUtil.nextLine();

      System.out.println("\n\n\t\t\t\t[관람등급 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      String FILMRATING = ScanUtil.nextLine();

      System.out.println("\n\n\t\t\t\t[런타임 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      int RUNTIME = ScanUtil.nextInt();
      //   
      System.out.println("\n\n\t\t\t\t[개봉일 수정]  ex)2020/12/28");//date 타입으로 
      System.out.print("\n\n\t\t\t\t입력>");
      String RELEASEDATE = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[장르 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      String GENRE = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[국가 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      String COUNTRY = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[감독 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      String DIRECTOR = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[배우 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      String ACTOR = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[시놉시스(줄거리) 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      String SUMMARY = ScanUtil.nextLine();
      
      System.out.println("\n\n\t\t\t\t[URL 수정]");
      System.out.print("\n\n\t\t\t\t입력>");
      String URL = ScanUtil.nextLine();
      
      
      System.out.println("------------------------------------------------------------------------------");
      List<Object> test = new ArrayList<>();
   
      test.add(FILMNAME);
      test.add(FILMRATING);
      test.add(RUNTIME);
      test.add(RELEASEDATE);
      test.add(GENRE);
      test.add(COUNTRY);
      test.add(DIRECTOR);
      test.add(ACTOR);
      test.add(SUMMARY);
      test.add(URL);

      result = adminDao.Mv_insert(test);   
      
      
      
      if(result>0){
         System.out.println("┌-------------------------------------------┐");
         System.out.println("\n\n\t\t\t영화 제목" +FILMNAME +"데이터 생성에 성공했습니다.");
         System.out.println("└-------------------------------------------┘");
      }else{
         System.out.println("┌----------------------------------┐");
         System.out.println("\n\n\t\t\t데이터 생성에 실패했습니다.(번호 중복)");
         System.out.println("└----------------------------------┘");
      }
   
   }
         


     

   

}