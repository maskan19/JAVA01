package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 연산자를 입력받아 연산 결과를 알려주는 프로그램을 만들어주세요.(산술연산자 5종)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("=======단순 계산기========\n숫자를 입력하세요.");
		double num1 = Double.parseDouble(sc.nextLine()); 
		System.out.print("연산자를 입력하세요.");
		String opr = sc.nextLine();
		System.out.print("숫자를 입력하세요.");
		double num2 = Double.parseDouble(sc.nextLine());
		
		boolean plus = opr.equals("+");
		boolean minus = opr.equals("-");
		boolean multiple = opr.equals("*");
		boolean divide = opr.equals("/");
		boolean odd = opr.equals("%");
		
		boolean dis;
		dis = plus || minus || multiple || divide || odd;
		
		
		double result = plus == true ? num1+num2 :  
			(minus == true ? num1 - num2 : 
			(multiple == true ? num1* num2 : 
			(divide == true ? num1 / num2 : num1%num2))) ;

		String endup = dis==false ? 
		"========오류========\n올바른 연산자가 아닙니다. 다시 입력해주세요." : 
		"========계산 결과========\n" + num1 + opr + num2 + " =" + result;
		
		System.out.println(endup);

		// --------------------------------------------------

		Scanner s = new Scanner(System.in);

		System.out.print("첫번째 숫자>");
		int x = Integer.parseInt(s.nextLine());
		System.out.print("연산자>");
		String op = s.nextLine();
		System.out.print("두번째 숫자>");
		int y = Integer.parseInt(s.nextLine());
		
		int result1 = op.equals("+") ? x + y  
			: op.equals("-") ? x - y
					: op.equals("*")? x * y
							: op.equals("/")? x / y
									:x % y;

	}

}