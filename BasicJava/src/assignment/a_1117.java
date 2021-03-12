package assignment;

import java.util.Scanner;

public class a_1117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

		
		//다음과 같은 프로그램을 작성해주세요.
		/*
		 * =============회원가입 =============
		 * 아이디>admin
		 * 비밀번호(4자리숫자)>1234
		 * 이름>홍길동
		 * 나이>30
		 * 키 185.5       //Double.parseDouble(sc.nextLine()); 사용
		 * ================================
		 * 아이디 : admin
		 * 비밀번호 : 1234
		 * 이름 : 홍길동
		 * 나이 : 30세
		 * 키 : 185.5cm
		 * ================================
		 */
		
		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("======== 회원가입 ========\n 아이디를 입력하세요>");
//		String _id = sc.nextLine();
//		System.out.print("비밀번호를 입력하세요>");
//		int _pw = Integer.parseInt(sc.nextLine());
//		System.out.print("이름을 입력하세요>");
//		String _name = sc.nextLine();
//		System.out.print("나이를 입력하세요>");
//		int _age = Integer.parseInt(sc.nextLine());
//		System.out.print("키를 입력하세요>");
//		double _height = Double.parseDouble(sc.nextLine());
//		
//		System.out.println("=============== \n아이디 : "+ _id);
//		System.out.println("비밀번호 : " + _pw);
//		System.out.println("이름 : " + _name);
//		System.out.println("나이 : " +_age + "세");
//		System.out.println("키 : " + _height +"cm\n===============");
//		
		

		//홍길동의 이름을 작성받고 일치하는 지 검증, 일치한다면 "환영합니다"를 출력하시오.
		
		System.out.print("=====관계자외 인허 불가=====\n 이름 입력 : ");
		String _auth = sc.nextLine();
		String _acc = "홍길동";
		boolean b = _auth == _acc ;
		System.out.print(b);
		
		
		
		
		

	}

}
