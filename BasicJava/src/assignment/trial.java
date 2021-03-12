package assignment;

import java.util.Arrays;
import java.util.Scanner;

public class trial {

	public static void main(String[] args) {

////12pg 2-1		
//		int result2_1 = 3+5;
//		System.out.println("3 + 5 = " + result2_1);
//		
////20pg 2-4
//		int year = 2020;
//		int month = 2;
//		int day = 14;
//		System.out.println(year +"년 "+month+"월 " + day + "일");
//		
////22pg 2-4
//		int a = 8;
//		int b = 3;
//		int div_int = a/b;
//		System.out.println(div_int);
//		double div_db = (double)a/b;
//		System.out.println(div_db);
//		
////23pg 2-5
//		byte byte01 = 33;
//		long long01 = 888L;
//		char char01 = 'A';
//		float float01 = 3.141592f;
//		int integer01 = (int)long01;
//		System.out.println(integer01);
//		short short01 = (short)char01;
//		System.out.println(short01);
//		integer01 = (int)float01;
//		System.out.println(integer01);
//		int integer02 = byte01;
//		System.out.println(integer02);
//		int integer03 = (int)char01;
//		System.out.println(integer03);
//		
//		System.out.println(4+24.3715f);
//		System.out.println("1"+"2");
//		
////38pg 2-10
//		float fl01 = 0.1f;
//		double do01 = 0.1;
//		
//		boolean d = fl01 == (float)do01;
//		System.out.println(d);
//		
//		String str1 = "화이팅";
//		
//		d = str1.equals("화이팅");
//		System.out.println(d);
//		
//		40pg~
		
		

		
		
		
		
//		
//		
//		byte b = 12;
//		b++;
//		System.out.println(b);
//		b++;
//		System.out.println(b);
//		
//		int x = 10;
//		int y = 30;
//		
//		boolean n = x >= 10 && x < 5 || y > 20;
//		System.out.println(n);
//				
//		String a = "gks";
//		boolean n = a=="jeojeojoejojeojo";
//		System.out.println(n);
//		if (a=="gk" || a=="gks"){
//			System.out.println("gs");
//		}
		 Scanner s = new Scanner(System.in);
//		 int score = 5;
//		System.out.println("과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다");
//		String answer9 = s.nextLine();
//		if(answer9 == "O")
//			{System.out.println(score);}
//		
//		String a = "dog";
//		String b = "dog" ;
//		int c = 45;
//		int d = 45;
//		boolean x = a == b; //true
//		boolean y = c == d; //true
//		if(a == b){System.out.println("a=b");}//true
//		if(c == d){System.out.println("c=d");}//true
//		if(a == "dog"){System.out.println("a=dog");}//true
//		if(c == 45){System.out.println("c=45");}//true
//		
//		/**********************/
//		System.out.print("0를 입력하라");
//		String ans_s = s.nextLine();
//		System.out.println(ans_s);
//		if(ans_s == "0"){System.out.println("string");}//false
//		/**********************/
//		/*숫자는 기본형이고 문자열은 참조형이기 때문에 주소 저장 위치가 다르다.*/
//		System.out.println("0를 입력하라");
//		int ans_n = Integer.parseInt(s.nextLine());
//		if(ans_n == 0){System.out.println("number");}//true
//		
//		int e = 5;
//		int f = 10;
//	
//		if(e==f){System.out.println("e==f");}//false
//		
//		 int[] arr  = new int[100];
//	      for(int i = 0; i <arr.length; i++){
//	         arr[i] = (int)(Math.random()*100) + 1;
//	      }
//
//	      int div = (int)(Math.random()*4)+ 2;   
//	      int temp1 [] = new int[100];
//	      int index = 0;
//	      for(int i=0; i<arr.length; i++) {
//	         boolean flag = false;
//	         for(int j=0; j<temp1.length; j++) {
//	            if(arr[i] == temp1[j]) {
//	               flag = true;
//	            }
//	         }
//	         if(!flag) {
//	            temp1[index++] = arr[i];
//	         }
//	      }
//
//	      int[] result = new int[index];
//	      for(int i=0; i<result.length; i++){
//	         result[i] = temp1[i];
//	      }
//	      Arrays.sort(result);
//	      System.out.println(Arrays.toString(result));
//	      
//	      int index2 = 0;
//	      
//	      for(int i=0; i<result.length; i++) {
//	         if(result[i]%div == 0) {
//	            index2++;
//	         }
//	      }
//	      
//	      int[] result2 = new int[index2];
//	      int index3 = 0;
//	      for(int i=0; i<result.length; i++) {
//	         if(result[i]%div == 0) {
//	            result2[index3++] = result[i];
//	         }
//	      }
//	      System.out.println(Arrays.toString(result2));

		
		 
		 
		 
		 
		 
		 for(int i = 0; i<10; i++){
			 System.out.println(i+":"+ (int)(Math.random()*10) );

				try {
					Thread.sleep(10000); //1초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("sleep 실행 후");
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
		
		
		
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("현물 자산  : ");
//		int _asset = Integer.parseInt(sc.nextLine());
//		System.out.println("A회사에 투자할 자산 : ");
//		int _invest_a = Integer.parseInt(sc.nextLine());
//		System.out.println("G회사에 투자할 자산 : ");
//		int _invest_g = Integer.parseInt(sc.nextLing());
//		
//		int _asset
//		
//		
//		
//		System.out.println("========자산 현황========")
//		
		
		
		

	}

}




