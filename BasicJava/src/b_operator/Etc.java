package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {

	/*
	 비트 연산자
	- |(OR), &(AND), ^, ~, <<, >>
	- 비트 단위로 연산한다. 

	기타 연산자
	- .(참조연산자) : 특정 범위 내에 속해 있는 멤버를 지칭할 때 사용한다.
	- (type) : 형변환
	- ?:(삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장 : 조건식이 거짓일 경우 수행할 문장
*/

		//1byte : 01010101 = 8bit
		System.out.println(10 | 15); //|(OR) : 둘 다 0인 경우 0 그 외 1
		//10: 00001010
		//15: 00001111
		//    00001111
		
		int x = 10;
		int y = 20;
		int result = x < y ? x : y; 
		//조건식 true> 1번 문장 실행. int result = x;와 동일
		System.out.println(result);
		
		//주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자
		int regNo = 3;
		String gender = regNo == 1 ? "남자" : "여자";
		System.out.println("당신의 성별은 " + gender + "입니다.");
		//regNo 
		
		gender = regNo == 1? "남자" : (regNo == 2 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 " + gender + "입니다.");
	
		//2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력해주세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1번째 숫자를 입력해주세요>");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("2번째 숫자를 입력해주세요>");
		int num2 = Integer.parseInt(sc.nextLine());
		int b_num = num1 < num2 ? num2 : num1;
		System.out.println(b_num + " is bigger.");
		
		//숫자를 입력받고, 그 숫자가 1이나 3이면 남자를, 2나 4면 여자를 출력해주세요.
		//그 외의 숫자를 입력하면 확인 불가를 출력해주세요.
		
		System.out.println("주민번호 7번째 자리 숫자를 입력하세요>");
		int regNo2 =Integer.parseInt(sc.nextLine());
		String gender1 = regNo2 == 1 || regNo2 == 3 ? "남자" : 
			(regNo2 == 2 || regNo2 == 4 ? "여자" : "확인불가");
		System.out.println("성별  : "+ gender1);
		
	}

}
