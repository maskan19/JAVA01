package a_variable;//클래스의 위치

import java.util.Scanner;

public class Variable { //클래스 : 변수와 메서드로 구성

	public static void main(String[] args) { //메서드 - ()가 붙은 것
//		메서드 : 명령문의 집합
//		main메서드 : 프로그램의 시작과 끝
//		주석 : 프로그램 코드로 인식하지 않는 문장 (주로 코드를 설명하는 데 사용한다.)
//		한줄 주석(줄 전체 주석): Ctrl + Shift + c 또는 Ctrl + /
//		범위 주석(부분주석) : Ctrl +Shift + /(해제 : Ctrl + Shift + \)
//		
//		데이터의 형태(데이터 타입)과 이름을 작성하면 변수를 만들 수 있다. 
//		데이터 타입을 선택할 때는 표현하고자 하는 데이터에 맞는 타입을 선택하면 된다.
//		변수 이름을 정할 때는 표현하고자 하는 데이터의 의미와 부합하는 이름을 지어주면 된다.
		
//		기본형 타입
//		- 정수 : byte(1), short(2), *int(4), long(8)
//		- 실수 :  float(4), *double(8)
//		- 문자  : char(2)
//		- 논리 : boolean(1)
		
		int x; //정수를 저장할 수 있는 x라는 이름의 변수 선언
		//변수를 만드는 것을 변수 선언이라고한다.
		//double x; 블럭{}안에서 이름이 중복될 수 없다.
		double y;
		
		//=(대입연산자) : 오른쪽 값을 왼쪽 변수에 저장
		x = 10; //초기화 : 변수에 처음으로 값을 저장하는 것
		y = 3.14; //변수의 타입에 맞는 값을 저장해야 한다.
		
		int abc = 30; //일반적으로 선언과 초기화를 한번에 한다.
		long l = 40L; //접미사 L을 붙여야 long타입이 된다.
		float f = 5.5f; //접미사 f를 붙여야 float타입이 된다.
		char c = '일'; //따옴표 안에 반드시 한 글자를 넣어야 한다.
		boolean b = true; //true, false	
		
		//8가지 기본형 타입을 사용해서 8개의 변수를 선언 및 초기화 해주세요.
		
		byte _byte = 5;
		short _short = 4;
		int _int = 98;
		long _long = 7L;
		float _float = 7.451f;
		double _double = 8000000;
		char _char = '폼'; 
		boolean _boolean = false;
		
		//변수의 값을 변경하기 위해서는 대입 연산자를 사용해 변수에 새로운 값을 대입해주면 된다.
		x = 20; //기존에 저장되어있는 10이라는 값은 사라지고 20이라는 값이 저장된다.
//		int x = 20; 변수를 만들 때만 타입을 붙인다. 변수를 사용하기 위해서는 이름만 있으면 된다.
		y = 5.5;
		
		//위에서 만든 8개의 변수에 새로운 값을 저장해주세요.
		
		_byte = 100;
		_short = 500;
		_int = 1000;
		_long = 100000;
		_float = 3.141592f;
		_double = 180.078;
		_char = '숲';
		_boolean = true;
		
		
		//콘솔창에 출력
		System.out.println(b); //괄호가 붙으면 메서드. 메서드를 출력하는 문장
		//실행 단축키 : Ctrl + F11
		
		//위에서 만든 8개의 변수의 값을 출력해주세요.
		System.out.println(_byte);
		System.out.println(_short);
		System.out.println(_int);
		System.out.println(_long);
		System.out.println(_float);
		System.out.println(_double);
		System.out.println(_char);
		System.out.println(_boolean);

		//문자열
		String str = "문자 여러개"; //클래스는 참조형 타입 데이터이다.
		System.out.println(str);
		//문자열과 다른 타입의 데이터가 결합되면 문자열의 결과를 얻는다.
		System.out.println(str+50);
		System.out.println(10+20+str); //30 str
		System.out.println(str+10+20); //str 1020
		//문자열은 이후 다른 타입을 문자화한다.
		
		//형변환
		//다른 타입의 값을 저장하기 위해서는 값의 타입을 변경해주어야하는데 이를 형변환이라고 한다.
		int small = 10;
		long big = 10L;
		
//		small = big; //형태가 달라 컴파일 에러가 발생
//		앞= 뒤 뒤의 것을 앞의 형태로 표현
		
		small = (int)big;
		big = small; //표현범위가 작은 쪽에서 큰 쪽으로의 형변환은 생략 가능하다.
//		자동으로 long 타입으로 바뀌었다.
		
//		명명규칙(이름을 짓는 규칙)
//		- 영문자 대소문자, 한글, 숫자, 특수문자('_','$')를 사용할 수 있다.
//		- 숫자로 시작할 수 없다.
//		- 예약어(java 자체에서 이미 사용하고 있는 단어)는 사용할 수 없다.
//		- [주로 낙타식 표기법을 사용한다.(mySampleVariable)]
//		- [클래스 명의 첫 글자는 대문자로 한다.(MySampleClass)]
//		- 변수(variable)는 소문자, 클래스(class)는 대문자
		
//		상수
//		- 값을 변경할 수 없는 변수
//		- 리터럴에 의미를 부여하기 위해 사용한다.
		
		final int MAX_NUMBER = 10;
//		final int 로 선언한 변수는 상수이며 변경할 수 없음. 시도할 경우 컴파일 에러 발생
		
		//출력
		System.out.print("줄바꿈을 하지 않는다.");
//		\ : 이스케이프 문자
		System.out.print("줄바꿈을 하지 않는다.\n");
//		\n,%n : 줄바꿈 \t : 탭 \" : 문장 내 따옴표 사용시
		System.out.println("줄바꿈을\t한다.");
//		%c : 문자 출력     %s: 문자열 출력      %d: 정수 출력     %b : boolean형식으로 출력
		System.out.printf("문자열: %s, 숫자 : %d", "Hello", 10); //출력 포멧을 지정
		System.out.println();
		
//		입력
		Scanner sc = new Scanner(System.in); //입력 받기 위한 클래스
//		Scanner는 현재 패키지에 없으므로 다른 패키지에서 참조해야함
//		import단축키 : Ctrl + Shift + o
		System.out.println("입력>");
		String str2 = sc.nextLine();
//		sc.nextLine() : 사용자의 입력을 기다림
		String str2 = sc.nextLine();
		System.out.println(str2);
		
		System.out.println("int 입력>");
		int nextInt = sc.nextInt();//버그 있으므로 비추천
		System.out.println(nextInt);
		System.out.print("문자열입력>");
		String nextLine = sc.nextLine();
		System.out.println(nextLine);
		System.out.println("입력 끝");
		// int 의 버그

		System.out.print("int 입력>");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println(number);

		// 자신의 이름을 저장할 변수를 선언해주세요.

		/*
		 * System.out.print("이름 : "); String str_name = sc.nextLine();
		 * System.out.println("사용자의 이름은" str_name)
		 */

		String name;

		// 위에서 선언한 변수를 초기화하기 위해 이름을 입력받아주세요.

		System.out.println("이름을 입력하세요>");
		name = sc.nextLine();

		// 자신의 나이를 저장할 변수를 선언해주세요.

		int age;

		// 위에서 선언한 변수를 초기화 하기 위해 나이를 입력받아주세요.

		System.out.println("나이를 입력하세요>");
		age = Integer.parseInt(sc.nextLine());

		System.out.println("이름 : " + name + " / 나이 : " + age);

	}

}
