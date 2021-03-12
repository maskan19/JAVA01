package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교연산자
		 * - <, >, <=, >=, ==, !=
		 * - 문자열 비교 : equals()
		 */
		
		int x = 10;
		int y = 20;
		boolean b = x < y; //비교연산자의 연산결과는 boolean이다.
		System.out.println(b);
		
		b = x <= y - 15; // 산술연산후 비교연산을 수행한다.
		System.out.println(b);
		
		String str1 = "abc";
		String str2 = "abc";
		b = str1 == str2; //문자열의 내용이 아닌 주소를 비교한 것.
		System.out.println(b);
		
		//String의 내용을 비교하기 위해서는 equals()메서드를 사용한다.
		b = str1.equals(str2);//글자열이 같으면 true 다르면 false를 출력
		System.out.println(b);
		b = !str1.equals(str2);//equals로 나온 연산값의 반대 값 출력
		System.out.println(b);
		
		//다음 문장들을 코드로 작성해주세요.
		
		//1. x는 y보다 작거나 같다.
		//2. x + 5와 y는 같다. 
		//3. y는 홀수이다.
		//4. "기본형"과 "참조형"은 다르다.  비교대상  : 참조형
		
		boolean _compare = x <= y;
		System.out.println("x는 y보다 작거나 같다. : " + _compare);
		boolean _equal = x + 5 == y;
		System.out.println("x + 5와 y는 같다. : " + _equal);
		boolean _odd = y%2 == 1;
		System.out.println("y는 홀수이다. : " + _odd);
		b= !"기본형".equals("참조형");
		System.out.println("! = " + b);

		String str3 = "abc";
		String str4 = "abc";
		String str5 = "bdc";
		b = str3 == "efc" || str4 == "abc";
		System.out.println("=============\n"+ b);
		
		String str8 = "1234";
		int i = Integer.parseInt(str8);
		System.out.println(i);

	}
}
