package e_oop;

import /*e_oop안에 있지 않은 다른 클래스의 패키지를 사용할 때*/java.util.*;
//java.utill 패키지 아래의 모든 클래스를 사용하겠다
//Ctrl+Shift+o 단축키로 import 가능

public class SampleClass {
	
	public static void main(String[] args){
	int local = 10; //지역변수 : 메서드 안에서만 사용하는 변수
}
	
	int field; //전역변수 : 클래스 전체 영역에서 사용하는 변수
	//초기화하지 않아도 기본값으로 초기화된다.
	
	/*
	 * - 메서드 : 변수를 가지고 할 일
	 * - 선언 방법 : 리턴타입 메서드명(파라미터){ }
	 * - 파라미터(매개변수) : 실행에 필요한 정보
	 * - 리턴타입(반환타입) : 실행 후 돌려줘야하는 결과물
	 */

	void method1() { // void: 타입이 없다. 돌려줄 값이 없다.
		System.out.println("파라미터도 리턴타입도 없는 메서드");
		return;// void 타입에서는 메서드를 종료시키는 역할
	}

	String method2(int parameter) {
		return parameter + " 를 받아 명령을 수행하고 결과물을 리턴하는 메서드";
		// 리턴값이 필요한 리턴타입
	}

	int method3(int[] parameter) {
		return parameter[5] * 100 + 12;
	}

	// flowTest1()호출시 출력되는 문장에 번호를 붙여주세요.
	void flowTest1() {
		System.out.println("flowTest1 시작 : 1");
		flowTest3();
		System.out.println("flowTest1 종료 : 6");
	}

	void flowTest2() {
		System.out.println("flowTest2 시작 : 3");
		System.out.println("flowTest2 종료 : 4");
	}

	void flowTest3() {
		System.out.println("flowTest3 시작 : 2");
		flowTest2();
		System.out.println("flowTest3 종료 : 5");
	}

}
