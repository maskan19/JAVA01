package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는 것이 아니라 객체 간의 상호작용으로 보는 것
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 */

		SampleClass sc = new SampleClass();
		// SampleClass의 클래스를 참조
		System.out.println(sc.field);

		sc.method1();
		String returnValue = sc.method2(45); // 파라미터와 리턴값이 있음
		System.out.println(returnValue);

		sc.flowTest1();

		// 다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		// 1. 123456+654321

		Calculator cal = new Calculator();
		long value = cal.plus(123456, 654321);

		// 2. 1번의 결과값*123456

		value = cal.multiple(value, 123456);

		// 3. 2번의 결과값/123456

		value = cal.divide(value, 123456);

		// 4. 3번의 결과값-654321

		value = cal.minus(value, 654321);

		// 5. 4번의 결과값 %123456

		value = cal.remainder(value, 123456);
		System.out.println(value);

	}
}
