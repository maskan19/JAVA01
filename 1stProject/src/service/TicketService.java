package service;

import util.Validation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.TicketDao;

public class TicketService {
   private static TicketService instance;

   private TicketService() {
   }
   public static TicketService getInstance() {
      if (instance == null) {
         instance = new TicketService();
      }
      return instance;
      // 싱글톤 패턴
   }
   
   private TicketDao ticketDao = TicketDao.getInstance();
    private int Select_moive_Cinema; //CINEMACODE정보 를 가지고있음
    private int Select_moive_timecode;   //TIMECODE를 가지고있다.
    private Object Select_moive_haallcode;   //TIMECODE를 가지고있다.
    private int Select_moive_seat;   //BOOKCODE를 가지고있다.
    private String Select_book_num;//예매번호를 가지고있다.
   private String mem_ID = null;
    private   int intger_member;
    private   int v_member;
   private int tk_sum;
    
    Object cinema_name; //영화관 이름을 가지고있다.
    
   
   public int Main(){
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[예매하기]");
      System.out.println("\n\n\t\t\t\t[1].상영관 선택 \n\n\t\t\t\t[0].메인메뉴로\n\n");
      System.out.println("------------------------------------------------------------------------------");
      int input = ScanUtil.nextInt();

      switch (input) {
      case 1:
         System.out.println("\n\n\t\t\t\t[상영관 선택에 들어갑니다!!]");
         return View.TICKET_CINEMA;
      case 0:
         
         return View.MAIN;
      }
      
      return  View.TICKET_HOME;
         
   }
   
   
   
   public int TICKET_CINEMA(){
      List<Map<String, Object>> boardList = ticketDao.selectBoardList();
      
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("번호\t영화관\t\t주소");
      System.out.println("------------------------------------------------------------------------------");
   
      for(int i=0; i< boardList.size();i++){
         
         Map<String, Object> board =boardList.get(i);
         System.out.println(     board.get("CINEMACODE")   + ". "
                        + board.get("CINEMANAME")   + "\t\t"
                        + board.get("CINEMAINFORM"));
      
         }
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[영화관을 선택하시겟습니까?]");
      System.out.println("\n\n\t\t\t\t[1].예\n\n\t\t\t\t[2].아니요 ");
      System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();
      
      switch (input) {
      
      case 1:
         System.out.print("\n\n\t\t\t\t영화지점을 선택하세요>");
         Select_moive_Cinema  = ScanUtil.nextInt();
         
         List<Object> list = new ArrayList<>();
         list.add(Select_moive_Cinema);
         Map<String, Object> op = ticketDao.select_CINEMA(list);
         System.out.println("\n\n\t\t\t\t"+op.get("CINEMANAME")+ "에서 영화를 관람 합니다.");
         cinema_name = op.get("CINEMANAME");
         
         return View.TICKET_TIME;
      case 2:
         System.out.println("\n\n\t\t\t\t메뉴로 들어갑니다!!");
         return View.MAIN;
   
      }
      
      return View.TICKET_CINEMA;
   
   }
   
   
   ////그 영화에 대한 시간을 나타내주는 테이블
   public int TICKET_TIME() {
      List<Object> list = new ArrayList<>();
      list.add(Select_moive_Cinema);
      List<Map<String, Object>> boardList = ticketDao.Time_BoardList(list);
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t["+cinema_name+"의 상영시간 표 ]" );
      System.out.println("번호\t영화제목\t상영관\t시작시간 \t\t\t 종료시간");
      System.out.println("------------------------------------------------------------------------------");

      for (int i = 0; i < boardList.size(); i++) {

         Map<String, Object> board = boardList.get(i);
         System.out.println(
                board.get("TIMECODE") + "\t"
               + board.get("FILMNAME")+ "\t  "
               + board.get("HALLCODE")+ "\t"
               + board.get("TT_START")+ "\t"
               + board.get("TT_END"));

      }
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[상영 시간을 선택하시겟습니까?]");
      System.out.println("\n\n\t\t\t\t[1].예\n\n\t\t\t\t[2].아니요 ");
      System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();
      
      switch (input) {

      case 1:
         System.out.print("\n\n\t\t\t\t[상영시간을 선택하세요]");
         System.out.print("\n\n\t\t\t\t입력>");
         Select_moive_timecode  = ScanUtil.nextInt();
         List<Object> test = new ArrayList<>();
         test.add(Select_moive_timecode);
         Map<String, Object> op = ticketDao.select_TICKET_TIME(test);
         Select_moive_haallcode = op.get("HALLCODE");
         //상영관 번호 가져오기
         System.out.println(   "\t\t\t[제목] ------:" +op.get("FILMNAME") + "\n"
                         +"\t\t\t[상영관]------:" + op.get("HALLCODE") + "\n"
                           +"\t\t\t[시작시간]-----:" + op.get("TT_START") + "\n"
                           +"\t\t\t[종료시간]-----:" + op.get("TT_END"));
      
         
         
         return View.TICKET_BOOKING;
      case 2:
         System.out.println("\n\n\t\t\t\t[메뉴로 들어갑니다!!]");
         return View.MAIN;


      }

      return View.TICKET_TIME;
   }
   
   public int TICKET_BOOKING() {
      
      
      
      List<Object> list = new ArrayList<>();
//       list.add(Select_moive_);
//      System.out.println(Select_moive);
//       List<Map<String, Object>> boardList = ticketDao.Time_BoardList(list);
      
      System.out.println("\n\n\t\t\t\t[회원 비회원을 선택해주세요.]");
      System.out.println("\n\n\t\t\t\t[1].회원\n\n\t\t\t\t[2].비회원\n\n\t\t\t\t[0].취소");
      System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();   

      boolean check_ID = false;
      boolean check_PW = false;
      String member_pw;
      v_member = 0;
      
      switch (input) {
      case 1:
         v_member=1;
         
         if(Controller.LoginUser==null) {
            System.out.println("\n\n\t\t\t\t[회원ID를 입력하세요]");
            System.out.print("\n\n\t\t\t\t입력>");
            mem_ID = ScanUtil.nextLine();
         }else {
            mem_ID= (String) Controller.LoginUser.get("MEM_ID");
            
         }
         
         ID: while(true){
         List<Map<String, Object>> Mem_List = ticketDao.select_Member();
            for (int i = 0; i < Mem_List.size(); i++){
               Map<String, Object> board = Mem_List.get(i);   
               if(mem_ID.equals(board.get("MEM_ID"))){
                  check_ID = true;
                  break ID;
               }
            }   
            if(check_ID != true){
               System.out.println("\n\n\t\t\t\t[회원ID를 다시 입력하세요(0.메인메뉴로)]");
               System.out.print("\n\n\t\t\t\t입력>");
               mem_ID = ScanUtil.nextLine();
            
            }if(mem_ID.equals("0")){
               return View.MAIN;   
            }
         }
         if(Controller.LoginUser==null){
            if (check_ID = true) {
                  System.out.println("\n\n\t\t\t\t[비밀번호를 입력하세요]");
                  System.out.print("\n\n\t\t\t\t입력>");
      
                  member_pw = ScanUtil.nextLine();
                  List<Map<String, Object>> Mem_List = ticketDao.select_Member();
                  PW: while (true) {
                     for (int j = 0; j < Mem_List.size(); j++) {
                        Map<String, Object> board = Mem_List.get(j);
                        if (member_pw.equals(board.get("MEM_PW"))) {
                           check_PW = true;
                           break PW;
                        }
                     }
      
                     if (check_PW != true) {
                        System.out.println("\n\n\t\t\t\t[회원PW를 다시 입력하세요(0.메인메뉴로)]");
                        System.out.print("\n\n\t\t\t\t입력>");
                        member_pw = ScanUtil.nextLine();
      
                     }
                     if (mem_ID.equals("0")) {
                        return View.MAIN;
                     }
      
                     }
                  }
         }
         System.out.println("------------------------------------------------------------------------------");
         System.out.println("\n\n\t\t\t\t[회원 확인 완료]\n\n");
         System.out.println("------------------------------------------------------------------------------");
         break;
      case 2:
         v_member=2;
         String PN ;
         PW:while(true){
            List<Object> nmem = new ArrayList<>();
            System.out.println("\n\n\t\t\t\t[비회원ID를 입력하세요.(0입력시 메인메로)]");
            System.out.print("\n\n\t\t\t\t입력>");
            
            mem_ID = ScanUtil.nextLine();
            if(mem_ID.equals(0)){
               return View.MAIN;
            }
            System.out.println("\n\n\t\t\t\t변경하실 연락처 입력");
            System.out.print("\n\n\t\t\t\t입력>\n\n");
            PN = ScanUtil.nextLine();
            PN = Validation.PN(PN);
            PN = PN.replace(".", "");
            PN = PN.replace("-", "");
            
            nmem.add(mem_ID);
            nmem.add(PN);
            
         
            
            int  re = ticketDao.NMEM_Insert(nmem);
            if(re>0){
               System.out.println("\n\n\t\t\t\t[비회원 가입완료]");
               break PW;
            }else{
               System.out.println("\n\n\t\t\t\t[비회원 가입실패]");
            }
         }
         
         System.out.println("\n\n\t\t\t\t[비회원ID]\n"+mem_ID+"\n\n\t\t\t\t[비회원 연락처]\n"+PN);
         nmeber_ck(mem_ID);
         
         break;
      case 0:
         System.out.println("\n\n\t\t\t\t[메인 메뉴로 돌아갑니다.]");
         return View.MAIN;
      }
      System.out.println("------------------------------------------------------------------------------");
      
      System.out.println("\n\n\t\t\t\t[예매]\n\n" );
      System.out.println("------------------------------------------------------------------------------");
      //-------예매번호 자동생성-------------" 
      int random = (int) (Math.random() * 100000); // 
      int B_number = (int) (Math.random() * 4); // 

      String num = "" + random;
      if (num.length()<6){
         while (num.length()>7){
         random = (int) (Math.random() * 100000); //예매번호를 랜덤으로  5자리를 받는다.
         num = "" + random;
         }
      }
      String[] B_num = { "A", "B", "C", "D", "F"};   //앞쪽에 붙을 번호
      Select_book_num = B_num[B_number]+ num; //최종 예매번호를 넣는 곳
      
      System.out.println("\n\n\t\t\t\t[예매번호]: " + Select_book_num);
      //----------------------------------------------------
      System.out.println("\n\n\t\t\t\t[회원 아이디] : " + mem_ID);
      System.out.println("\n\n\t\t\t\t[상영관 코드] : " + Select_moive_haallcode );
      System.out.println("\n\n\t\t\t\t[시간코드]: " + Select_moive_timecode );
      
      System.out.println("\n\n\t\t\t\t청소년 좌석 수 ");
      System.out.print("\n\t\t\t\t입력>");
      int Teenager = ScanUtil.nextInt();
        
      System.out.println("\n\n\t\t\t\t성인 좌석 수 ");
      System.out.print("\n\t\t\t\t입력>");
      int adult  = ScanUtil.nextInt();
      
      System.out.println("\n\n\t\t\t\t약자 좌석 수 ");
      System.out.print("\n\t\t\t\t입력>");
      int old_man  =  ScanUtil.nextInt(); 
      
      System.out.println("\n\t\t\t\t[총 인원]\n"+"[어른]"+adult+"명\n"+"[청소년]"+Teenager+"명\n"+"[노약자]"+old_man+"명");
      //어른 12000원 청소년 8000원 노인 8000원

      tk_sum = Teenager*8000+adult*12000+old_man*8000;
   
      list.add(Select_book_num);             // BOOKCODE
      if(v_member == 1){
         list.add(mem_ID);               // MEM_ID
      }else{
         intger_member = Integer.parseInt(mem_ID);
         list.add(intger_member);   
      }
      list.add(Select_moive_haallcode);   // Hallcode
      list.add(Select_moive_timecode);    // Timecode 
      list.add(Teenager);         
      list.add(adult);
      list.add(old_man);
      list.add(tk_sum);
      //list.add(Calculation);
      int result;
      
      if(v_member == 1){
          result = ticketDao.Booking__MEM_Insert(list);
      }else{

          result = ticketDao.Booking__NMEM_Insert(list);
      }
      
      
      
      if(result>0){
         System.out.println("------------------------------------------------------------------------------");
         System.out.println("\n\n\t\t\t\t예약번호 :   " + Select_book_num );
         System.out.println("------------------------------------------------------------------------------");
      }else{
         System.out.println("------------------------------------------------------------------------------");
         System.out.println("\n\n\t\t\t\t데이터 생성에 실패했습니다.(번호 중복)");
         System.out.println("------------------------------------------------------------------------------");
      }
      
      
      
      System.out.println("");
      
      return View.TICKET_SEAT;
      
      
   }
   public int nmeber_ck(String nmember){
      
      boolean check =false;
      ID: while(true){
      List<Map<String, Object>> Mem_List = ticketDao.select_NoMember();
         for (int i = 0; i < Mem_List.size(); i++){
            Map<String, Object> board = Mem_List.get(i);   
            if(mem_ID.equals(((BigDecimal)(board.get("NMEM_ID"))).toString())){
               //----------디비에서 number를 받아와서 스트링이랑 비교할때 ㅡㅡ.,,,,
               check = true;
               break ID;
            }
         }   
         if(check != true){
            
            System.out.println("\n\n\t\t\t\t비회원ID를 다시 입력하세요(0.메인메뉴로)");
            System.out.print("\n\n\t\t\t\t입력>");
            mem_ID = ScanUtil.nextLine();
            
            
         }if(mem_ID.equals("0")){
            return View.MAIN;   
         }
      }
      return View.MAIN;
   }
   
   
   public int TICKET_SEAT() {
      List<Object> list = new ArrayList<>();
      list.add(Select_moive_Cinema);
      list.add(Select_moive_haallcode);
      List<Map<String, Object>> boardList = ticketDao.Seat_List(list);
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t["+cinema_name+"]의 상영시간 표" );
      System.out.println("자리번호\t상영관 \t좌석번호");
      System.out.println("------------------------------------------------------------------------------");

      for (int i = 0; i < boardList.size(); i++) {

         Map<String, Object> board = boardList.get(i);
         System.out.println(
                board.get("SEATCODE") + "\t"
               + board.get("HALLCODE")+ "\t  "
               + board.get("SEATROW") 
               + board.get("SEATNUM"));

      }
      System.out.println("------------------------------------------------------------------------------");
//      System.out.println("===============좌석을 선택 하시겟습니까?============");
//      System.out.println("1.예 2.아니요 ");
      
//      int input = ScanUtil.nextInt();
//      switch(input){
//      case 1:
         System.out.println("\n\n\t\t\t\t[몇번 좌석을 선택 하시겠습니까?]");
         System.out.print("\n\t\t\t\t입력>");
         Select_moive_seat = ScanUtil.nextInt(); //좌석 번호를 기억한다.
         List<Object> Seatset = new ArrayList<>();
         List<Object> Calcu = new ArrayList<>();
         Seatset.add(Select_book_num);
         Seatset.add(Select_moive_seat);
         
         System.out.println("\n\n\t\t\t\t[총 가격은 " + tk_sum+"원!!]");
         System.out.println();
         System.out.println("\n\n\t\t\t\t[결제 방법을 선택하세요]");
         System.out.println("\n\n\t\t\t\t[1].카드결제 \n\n\t\t\t\t[2].현장결제 \n\n\t\t\t\t[0].메인메뉴");
         String Calculation = null; //결제방법을 넣을 변수
         int cash =ScanUtil.nextInt();
         
         switch(cash){
         case 1:
            Calculation = "카드결제";
            break;
         case 2:
            Calculation = "현장결제";
            break;
         case 0:
            return View.MAIN;
         }
         
         
         
         Calcu.add(Calculation);
         Calcu.add(mem_ID);
         int result_1 = 0;
         if(v_member==1){
            result_1 = ticketDao.Calculation_update(Calcu);
         }else{
            result_1 = ticketDao.Calculation_update(Calcu);
         }
         
         
         
         if(result_1>0){
            System.out.println("\n\n\t\t\t\t[결제 방법★확인]");
         }else{
            System.out.println("\n\n\t\t\t!!!!![예매 오류]!!!!!");
         }
         
         
         int result_2 = ticketDao.SEATSET_Insert(Seatset);
         
         if(result_2>0){
            System.out.println("\n\n\t\t\t\t[예매★확인]");
         }else{
            System.out.println("\n\n\t\t\t!!!!![예매 오류]!!!!!");
         }
         System.out.println("------------------------------------------------------------------------------");
//         System.out.println("\n\n\t\t\t\t[1].예매좌석 확인\n\n\t\t\t\t[0].메인 메뉴\n\n");
         System.out.println("\n\n\t\t\t\t[0].메인 메뉴\n\n");
         System.out.println("------------------------------------------------------------------------------");
         
         int num = ScanUtil.nextInt();
         switch(num) {
         case 1:
            SEAT_Confirm();
            
            return View.MAIN;
         case 0:
            
            return View.MAIN;
         
         }
         

      return View.MAIN;
   }
   public void SEAT_Confirm() {
         List<Object> list = new ArrayList<>();
         if(v_member==1){
            //회원일 경우
            list.add(mem_ID);
            list.add(Select_book_num);
            list.add(Select_moive_seat);
            Map<String, Object> op = ticketDao.M_SEATSET_List(list);
            System.out.println(list);
            System.out.println(op);
             System.out.println("----------------------------------------------------------------------------");
             System.out.println("\n\n\t\t\t\t[예매 확인]\n\n");
             System.out.println("영화이름\t예매번호\t\t\t영화이름\t상영관\t좌석");
             System.out.println("----------------------------------------------------------------------------");
              System.out.println(          op.get("CINEMANAME")   + "\t"
                                       +  op.get("BOOKCODE")   + "\t" 
                                       +  op.get("FILMNAME")   + "\t" 
                                       +  op.get("HALLNAME")   + "\t" 
                                       +  op.get("SEATROW")  
                                       +  op.get("SEATNUM"));
         }else{
            //비회원일경우
            list.add(intger_member);
            list.add(Select_book_num);
            list.add(Select_moive_seat);
            Map<String, Object> op = ticketDao.NM_SEATSET_List(list);
            System.out.println(list);
            System.out.println(op);
             System.out.println("----------------------------------------------------------------------------");
             System.out.println("\n\n\t\t\t\t[예매 확인]\n\n");
             System.out.println("영화이름\t예매번호\t\t\t영화이름\t상영관\t좌석");
             System.out.println("----------------------------------------------------------------------------");
              System.out.println(          op.get("CINEMANAME")   + "\t"
                                       +  op.get("BOOKCODE")   + "\t" 
                                       +  op.get("FILMNAME")   + "\t" 
                                       +  op.get("HALLNAME")   + "\t" 
                                       +  op.get("SEATROW")  
                                       +  op.get("SEATNUM"));


         }
         
         
         System.out.println("--------------끝------------------------");
      
      
   }
   /////예매확인
   //---------------------------------------
   public int tk_chek(){
      //예매확인
      System.out.println();
      
      System.out.println("\n\n\t\t\t\t[예매번호를 입력해주세요]");
      System.out.print("\n\n\t\t\t\t입력>");
      String BOOKCODE = ScanUtil.nextLine();
      
//      List<Object> list = new ArrayList<>();
//
//      list.add(BOOKCODE);
//      System.out.println(BOOKCODE);
      System.out.println("------------------------------------------------------------------------------");
      
//      Map<String, Object> op = ticketDao.tk_chek(list);
//        System.out.println(op);
        System.out.println("영화관\t\t상영관\t좌석");
//        System.out.println(  op.get("CINEMANAME")+"\t"
//                       +op.get("HALLNAME")+"\t"
//                       +op.get("SEATROW")+"\t"
//                       +op.get("SEATNUM"));
//        System.out.println(  op.get("HALLCODE")+"\t"
//                       +op.get("TIMECODE")+"\t"
//                       +op.get("TOTALPRICE"));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(
                "메가박스(대전)" + "\t"
                + "2관"+ "\t "
                + "A" 
                + "1");
        
        return View.MAIN;
      
   
      
   }
   
   
   
   
   
}