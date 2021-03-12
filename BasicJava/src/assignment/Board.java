package assignment;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import e_oop.ScanUtil;
///////////////희수 board ////////////////////////
public class Board {
   ArrayList<HashMap<String, Object>> table;
   Board() {
      table = new ArrayList<>();
   }
   public static void main(String[] args) {
      /*
       * ArrayList와 Hashmap을 사용해 게시판 테이블을 만들고,
       * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
       * 
       * 번호(PK), 제목, 내용, 작성자, 작성일
       * 
       *  
       * -----------------------------------
       * 번호   제목         작성자   작성일
       * -----------------------------------
       *  4   안녕하세요      홍길동   12/15
       *  3   안녕하세요      홍길동   12/15
       *  2   안녕하세요      홍길동   12/15
       *  1   안녕하세요      홍길동   12/15 
       * -----------------------------------
       * 1.조회      2.등록   3.종료
       */
      
      Scanner s = new Scanner(System.in);      
      Board board = new Board();
      
      while(true) {
         board.show();      
         
         System.out.print("1.조회\t2.등록\t3.종료>");
         int num = Integer.parseInt(s.nextLine());
         
         
         switch(num) {
         case 1:
            board.select();
            break;
         case 2:
            board.insert();
            break;
         case 3:
            System.out.println("프로그램 종료");
            System.exit(0);
            break;
         }
      }
   }
   
   void show() {
//      ArrayList<HashMap<String, Object>> table = new ArrayList<>();
      System.out.println("번호\t제목\t작성자\t작성일");
      System.out.println("-----------------------------------");
      
      for(int i=table.size()-1; 0 <= i; i--) {
         HashMap<String, Object> hashMap = table.get(i);
         System.out.print(hashMap.get("번호") + "\t");
         System.out.print(hashMap.get("제목") + "\t");
         System.out.print(hashMap.get("작성자") + "\t");
         System.out.print(hashMap.get("작성일") + "\t");
         System.out.println();
      }      
      System.out.println("-----------------------------------");
   }
   //조회
   void select() {
      if(table.size() == 0) {
         System.out.println("자료가 없습니다.");
      } else {
         System.out.print("조회할 번호>");
         int num = ScanUtil.nextInt();
         if(table.size() < num) {
            System.out.println("자료가 없습니다.");
         } else {
            for(int i=0; i<table.size(); i++) {
               HashMap<String, Object> hashMap = table.get(i);
               if(hashMap.get("번호") == (Object)num) {
                  System.out.println();
                  System.out.print("번호 : " + hashMap.get("번호") + "\t");
                  System.out.print("제목 : " + hashMap.get("제목") + "\t");
                  System.out.println("작성자 : " + hashMap.get("작성자"));
                  System.out.println("=================================");
                  System.out.println("내용 : " + hashMap.get("내용"));
                  System.out.println();
                  System.out.println("=================================");
                  System.out.println("작성일 : " + hashMap.get("작성일"));
                  System.out.println("=================================");
                  System.out.print("1.수정 ㄱ? 2.삭제 ㄱ?");
                  int answer = ScanUtil.nextInt();
                  switch(answer) {
                  case 1:
                     update(hashMap.get("번호"),hashMap.get("작성자"));
                     break;
                  case 2:
                     delete(hashMap.get("번호"));
                     break;
                  }
               }
            }
         }
      }      
   }
   //등록
   void insert() {   
      Date date = new Date();
      SimpleDateFormat format = new SimpleDateFormat ("MM/dd");
      String time = format.format(date);
      HashMap<String, Object> board = new HashMap<>();
      int num = 1;
      for(int i=0; i<table.size(); i++) {
         num++;
      }
      
      System.out.print("제목>");
      String title = ScanUtil.nextLine();
      System.out.print("내용>");
      String content = ScanUtil.nextLine();
      System.out.print("작성자>");
      String writer = ScanUtil.nextLine();
      
      board.put("번호", num);
      board.put("제목", title);
      board.put("내용", content);
      board.put("작성자", writer);
      board.put("작성일", time);
      
      table.add(board);
   }
   
   //수정
   void update(Object num, Object writer) {
      int n = (Integer) num;
      Date date = new Date();
      SimpleDateFormat format = new SimpleDateFormat ("MM/dd");
      String time = format.format(date);
      
      System.out.print("제목>");
      String title = ScanUtil.nextLine();
      System.out.print("내용>");
      String content = ScanUtil.nextLine();
      
      HashMap<String, Object> board = new HashMap<>();
      for(int i=0; i<table.size(); i++) {
         HashMap<String, Object> hashMap = table.get(i);
         if(hashMap.get("번호") == (Object)num) {
            board.put("번호", num);
            board.put("제목", title);
            board.put("내용", content);
            board.put("작성자", writer);
            board.put("작성일", time);
         }
      }
      if((n-1) < 0) {
         n = 0;
      } else {
         n -= 1;            
      }
      table.set(n, board);
   }
   //삭제
   void delete(Object num) {
      int n = (Integer)num;
      System.out.println("정말 삭제할거냐?(y/n)");
      String answer = ScanUtil.nextLine();
      
      if(answer.equals("y")) {
         if((n-1) < 0) {
            n = 0;
         } else {
            n -= 1;            
         }
         table.remove(n);
      } else if(answer.equals("n")) {
         return;
      }
   }

}