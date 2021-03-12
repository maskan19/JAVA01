package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.InquiryBoardDao;

public class InquiryBoardService {
   
   private static InquiryBoardService instance;
   private InquiryBoardService () {}
   public static InquiryBoardService getInstance() {
         if(instance == null){
            instance = new InquiryBoardService();
            
         }
         return instance;
   
   }

   private InquiryBoardDao boardDao = InquiryBoardDao.getInstance();//객체 성성
   private int currentBoardNo;
   
   
   //첫번째 IF 문에서 비로그인 로그인 안내 
   //두번째 IF 문에서 관리자가 답변한 글 리스트 조회
   //세 번째 IF 문에서 로그인 했으면 글등록 할수있도록 안내
   public int boardList(){
      if(Controller.LoginUser==null){
      System.out.println("\n\n\t\t\t\t [1:1 문의를 사용하기 위해서는 로그인해주세요]");
      return View.MAIN;
   }
      
   else if(Controller.LoginUser.get("MEM_ID").equals("ADMIN")){
      List<Map<String, Object>> boardList = boardDao.selectInquiry_A();
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("번호 \t 제목 \t 작성자\t작성일");
      System.out.println("------------------------------------------------------------------------------");
      for(int i=0; i< boardList.size();i++){
         Map<String, Object> board =boardList.get(i);
         System.out.println(     board.get("INNUM")       + "\t"
                        + board.get("QMEM_ID")   + "\t"
                        + board.get("QTITLE")     + "\t"
                        + board.get("QTIME"));      
      }
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t[1].답변하기\n\n\t\t\t\t[2].답변한글 목록\n\n\t\t\t\t[0].메인 메뉴");
      System.out.print("\n\n\t\t\t\t입력>");
      int input = ScanUtil.nextInt();
   
      switch(input){
      
      case 1:  
         System.out.println("\n\n\t\t\t\t 답변할 글 번호 입력>");
         System.out.print("\n\n\t\t\t\t입력>");
         currentBoardNo = ScanUtil.nextInt();//게시글 번호를 입력하고 조회된것을 이용해야해서 다른 메소드를 호출해야해서 공유하지않음. 
                                       //전역변수를 통해서 사용함 
         return View.INQUIRY_SELECT;
      case 2:
         return View.INQUIRY_ANSWERLIST;
      case 0:  
         //로그아웃은 여기에 널을 저장하면 비어짐으로 로그인으로 넘어가지 않는다.
         return View.ADMINPAGE;
      
      }      
      }else{
         System.out.println("\n\n\t\t\t\t[1].1:1문의 글쓰기\n\n\t\t\t\t[0].메인 메뉴");
         System.out.print("\n\n\t\t\t\t입력>");

         int input = ScanUtil.nextInt();
         switch (input) {                  
         case 1:
            return View.INQUIRY_INSERT_FORM;
         case 0:
            return View.MAIN;
         }
         
         
      }
      return View.MAIN;
   }
      
   //관리자가 답변할 글조회
   public int Look(){
      List<Object> test = new ArrayList<>();
      test.add(currentBoardNo);
      
      Map<String, Object> op = boardDao.selectOneList(test);
            
      if(op.get("QTITLE")!=null){
               System.out.println(    "[번호]-------:"+op.get("INNUM")         + "\n"
                               +"[제목]-------:"      + op.get("QTITLE")   + "\n"
                               +"[내용]-------:"  + op.get("QCONTENTS")      + "\n"
                               +"[작성자]------:"   + op.get("QMEM_ID")     + "\n"
                               +"[작성일]------:"   + op.get("QTIME"));
            
                        System.out.println("\n\n\t\t\t\t[1].답변\n\n\t\t\t\t[2].목록");
                        System.out.print("\n\n\t\t\t\t입력>");
      
                        int input = ScanUtil.nextInt();
                        switch (input) {                  
                        case 1:
                           return View.INQUIRY_ANSWER;               
                        case 2:
                           return View.INQUIRY_LIST;
                        }
                           
         
         }else{
            System.out.println("======잘 못 입력하셨습니다 ");
         }
      return View.ADMINPAGE;   
   
      
   }   
   //로그인한 이용자가 1:1 게시판글 등록하는 인서트 메서드
   public int Insert() {
      int result;
      System.out.println("------------------------------------------------------------------------------");
       System.out.println("\n\n\t\t\t\t[ 등록 중 ]----------- ");                
      System.out.println("\n\n\t\t\t\t[작성자를 입력하세요] ");
      String writer = ScanUtil.nextLine();
      
       System.out.println("\n\n\t\t\t\t[제목을 입력하세요] ");
       System.out.print("\n\n\t\t\t\t입력>");
       String title = ScanUtil.nextLine(); 
      
      System.out.println("\n\n\t\t\t\t[내용을 입력하세요] ");
      System.out.print("\n\n\t\t\t\t입력>");
      String board = ScanUtil.nextLine();                  
      System.out.println("------------------------------------------------------------------------------");
      List<Object> test = new ArrayList<>();
      
      test.add(writer);
      test.add(title);
      test.add(board);
      //test.add(time1);   
      result = boardDao.insertInquiry_Q(test);         
      if(result>0){
         System.out.println("------------------------------------------------------------------------------");
         System.out.println("\n\n\t\t\t\t1:1문의 글쓰기 완료");
         System.out.println("------------------------------------------------------------------------------");
      }else{
         System.out.println("┌----------------------------------┐");
         System.out.println("|-----1:1문의 글쓰기 완료실패.---|");
         System.out.println("└----------------------------------┘");
      }
      
      
      return View.MAIN;
      
   }
   //관리자가 답변하는 업데이트 메서드
   public int answerUpdate() {
      int result;      
      System.out.println("------------------------------------------------------------------------------");
       System.out.println("\n\n\t\t\t\t[ 등록 중 ] ");
       
       
       
       System.out.println("\n\n\t\t\t\t[제목을 입력하세요] ");
      String title = ScanUtil.nextLine(); 
      System.out.println("\n\n\t\t\t\t[내용을 입력하세요] ");
      String board = ScanUtil.nextLine();
      System.out.println("------------------------------------------------------------------------------");
      
      List<Object> test = new ArrayList<>();
      test.add(title);
      test.add(board);
      test.add(currentBoardNo);
      
      result = boardDao.insertInquiry_A(test);             
      if(result>0 ){
         System.out.println("\n\n\t\t\t\t[답변 등록 완료 했습니다]");
      }else{
         System.out.println("\n\n\t※※※※※※※※※!!오류입니다!!※※※※※※※※※");
   
      }
      return View.INQUIRY_LIST;
   }
   //관리자가 답변한글 목록 
   public int answerList(){

            
      List<Map<String, Object>> boardList = boardDao.selectInquiry_Adone();
      System.out.println("------------------------------------------------------------------------------");
      System.out.println("번호\t문의ID\t제목\t내용\t작성일\t답변ID\t답변내용\t답변시간");
      System.out.println("------------------------------------------------------------------------------");
      for(int i=0; i< boardList.size();i++){
         Map<String, Object> board =boardList.get(i);
         System.out.println(     board.get("INNUM")       + "\t"
                        + board.get("QMEM_ID")   + "\t"
                        + board.get("QTITLE")     + "\t"
                        
                        + board.get("QCONTENTS")     + "\t"
                        
                        + board.get("QTIME")     +"\t"
                        + board.get("AMEM_ID")    +"\t"
                        + board.get("ATITLE")    +"\t"
                        + board.get("ACONTENTS") +"\t"
                        + board.get("ADATE"));     
      }
      
      
      System.out.println("\n\n\t\t\t\t[1].수정\n\n\t\t\t\t[2].삭제"
            + "\n\n\t\t\t\t[0].관리자 메인");
      System.out.print("\n\n\t\t\t\t입력>");
      int num = ScanUtil.nextInt();
      switch (num) {                  
      case 1:
         System.out.println("\n\n\t\t\t\t[수정할 번호를 입력하세요]");
         System.out.print("\n\n\t\t\t\t입력>");
         currentBoardNo = ScanUtil.nextInt();
         answerUpdate();
         break;
      case 2:
         System.out.println("\n\n\t\t\t\t[삭제할 번호를 입력하세요]");
         System.out.print("\n\n\t\t\t\t입력>");
         currentBoardNo = ScanUtil.nextInt();
         answerDELETE();
         break;
      case 0:
         return View.ADMINPAGE;
      }
      
      return View.INQUIRY_ANSWERLIST;   
      
   }
   public void answerDELETE() {
         ///유저 삭제 ////////
          
         List<Object> test = new ArrayList<>();
         test.add(currentBoardNo);
         int result = boardDao.Ans_delete(test);
         System.out.println(result);
         if (result > 0) {
            System.out.println("\n\n\t\t\t\t데이터가 삭제되었습니다.");
         } else {
            System.out.println("\n\n\t\t\t\t※※※※※※데이터 취소및 메인페이지로※※※※※※※");
         }

      
   }
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

}