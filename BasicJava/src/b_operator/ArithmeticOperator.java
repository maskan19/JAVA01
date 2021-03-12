package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술연산자
		 * - 사칙연산 : +, -, *, /, %(나머지)
		 * - 복합연산자 : +=, -=, *=, /=, %=	직접 연산
		 * - 증감연산자 : ++, --	1 증가 또는 1감소
		 */

		int result = 10 + 20 - 30 * 40 / 50 % 60;
		//곱하기와 나누기가 더하기 빼기보다 우선순위가 높다.
		System.out.println(result);
		
		//나머지 연산
		result = 10/3;
		System.out.println(result); 
		//3.3333...이 연산의 결과여야하지만 타입이 int>정수만 표현 
		result = 10%3;
		System.out.println(result);
		
		//5개의 산술연산자를 사용해 5개의 연산을 수행 후 결과를 출력해주세요.
		
		result = 100/3;
		System.out.println(result);
		result = 107%5;
		System.out.println(result);
		result = 80*4;
		System.out.println(result);
		result = 40+7;
		System.out.println(result);
		
		//복합연산자
		//변수에 저장되어있는 값에 연산을 수행할 때 수행할 연산자와 대입연산자를 결합해 사용할 수 있다.
		result = result + 3;
		System.out.println(result);
		
		result += 3;
		System.out.println(result);
		
		result -= 5;
		System.out.println(result);
		
		result *= 2;
		System.out.println(result);
		
		//아래의 문장을 복합연잔자를 사용한 문장으로 만들어 주세요.
		//result = result +10;
		
		//result = result - 2 * 3;
		
		//result = result %5;
		
		result += 10; 
		System.out.println(result);
		result -= 2 * 3;
		System.out.println(result);
		result %= 5;
		System.out.println(result);
		//실행은 ctrl+F11 디버깅용 F11
		
		
		//증감 연산자
		//증감연산자(++) : 변수의 값을 1 증가시킨다.
		//감소연산자(--) : 변수의 값을 1 감소시킨다.
		int i = 0;
		
		++i; //전위형 : 변수의 값을 읽어오기 전에 1 증가시킨다.
		i++; //후위형 : 변수의 값을 읽어온 후에 1 증가시킨다.
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = " + ++i);
		i = 0;
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double; 
		//표현 범위가 더 큰 타입으로 형변환된다.
		//작은 범위인 _int가 자동으로 double로 변환
		System.out.println(result2);
		
		long _long = 100L;
		_long = _int  + _long;
//		_int = _int + _long; //빨간줄=컴파일에러
		_int = _int + (int)_long;
		
		byte _byte = 5;
		short _short = 10;
		int result3 = _byte + _short; //int보다 작은 타입은 int로 형변환
		System.out.println(result3);
		
		char _char = 'a'; 
		char _char2 = 'b';
		_int = _char + _char2;
		System.out.println(_int);
		//char은 문자함수지만 int로 변환되어 숫자화된다. a=97, b=98
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		
		byte b = 127;
		b++;
		System.out.println(b);
		b--;
		System.out.println(b);
		
		//타입을 선택할 때 연산의 범위를 고려해야한다.
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요 
		//1. 123456 + 654321
		//2. 1번의 결과값 *123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값-654321
		//5. 4번의 결과값 % 123456
		
		long _work = 123456 + 654321;
		System.out.println("1. : " + _work);
		_work *= 123456;
		System.out.println("2. : " + _work);
		_work /= 123456;
		System.out.println("3. : " + _work);
		_work -= 654321;
		System.out.println("4. : " + _work);
		_work %= 123456;
		System.out.println("5. : " + _work);
		
		//3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		
		int a_int = 45;
		int b_int = 89;
		int c_int = 857;
		int sum_int = a_int + b_int + c_int;
		System.out.println("합계 : " + sum_int);
		double avg_int = (double)sum_int / 3; 
		//둘 다 int 로 결과값도 int로 도출, 둘 중 하나는 더블이어야 더블 값이 나옴 
		//sum_int를 더블로 형변환 / 3을 3.0으로 형변환
		System.out.println("평균 : " + avg_int);
		
		//반올림 함수 Math.round(변수)는 소수점 첫째 자리에서 반올림
//		avg_int = Math.round(avg_int);
//		System.out.println(avg_int);
		
		avg_int = Math.round(avg_int * 10);
		//Math.round는 long 타입 함수
		//avg_int = Math.round(avg_int * 10) / 10   >정수
		//avg_int = Math.round(avg_int * 10) / 10.0	>실수
		System.out.println(avg_int / 10);
		
		//랜덤
		int random = (int)(Math.random() * 100) + 1;
		//Math.random()은 0.0~0.99999...까지의 수를 랜덤 생성
		// 0~99를 +1 로 1~100까지의 랜덤한 숫자가 생성
		System.out.println(random);

	}

}
