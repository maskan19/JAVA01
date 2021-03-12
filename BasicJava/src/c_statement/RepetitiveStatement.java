package c_statement;

public class RepetitiveStatement {

	public static void main(String[] args) {
		/*
		 * 반복문 - for 문 - while문 - do-while문
		 * 
		 * for문 - for(1.초기화; 2.조건식; 4. 증감식){3.} - 포함하고 있는 문장들을 정해진 횟수만큼 반복하게 해주는
		 * 문장(반복되는 횟수가 정해짐)
		 */

		for (int i = 1; i <= 10; i++) {
			// 초기화 : 조건식과 증감식에 사용할 변수 초기화
			// 조건식 : 연산 결과가 true이면 블럭 안의 내용을 수행
			// 증감식 : 변수를 증가/감소시켜 반복문을 제어
			System.out.println(i);
		}

		int sum = 0; // 1부터 10까지의 합계를 저장

		sum += 1;
		sum += 2;
		sum += 3;
		sum += 4;
		sum += 5;
		sum += 6;
		sum += 7;
		sum += 8;
		sum += 9;
		sum += 10;
		System.out.println(sum);

		sum = 0;
		for (int i = 1/* 1 */; i <= 10/* 2 */; i++/* 4의 순서로 실행 */) {
			sum += i;/* 3 */
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 100; i >= 1; i--) {
			sum += i;
		}
		System.out.println(sum);

		// 1부터 100까지 짝수의 합을 출력해주세요.

		sum = 0;
		for (int i = 1; i <= 50; i++) {
			sum += 2 * i;
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		// 1부터 100까지 홀수의 합을 출력해주세요.

		sum = 0;
		for (int i = 1; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 1; i <= 50; i++) {
			sum += 2 * i - 1;
		}
		System.out.println(sum);

		sum = 0;
		for (int i = 1; i <= 100; i += 2) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println(sum);

		// 구구단 출력
		/*
		 * 2*1=2 2*2=4 . .
		 */
		for (int i = 1; i <= 9; i++) {
			System.out.println(2 + " * " + i + " = " + i * 2);
		}

		// 8단

		for (int i = 1; i <= 9; i++) {
			System.out.println("8 * " + i + " = " + 8 * i);
		}
		// 2~9단
		for (int a = 2; a <= 9; a++) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(a + " * " + i + " = " + a * i);
			}
		}

		// 구구단 전체를 가로로 출력해주세요.
		/*
		 * 2 * 1 = 2 3 * 1 = 3 4 * 1 = 4 ... ... 탭 : \t
		 */

		for (int i = 1; i <= 9; i++) {
			for (int a = 2; a <= 9; a++) {
				System.out.print(a + " * " + i + " = " + a * i + "\t");
			}
			System.out.println();
		}

		/*
		 * while 문 - while(조건식){} - 포함하고 있는 문장들을 조건식이 만족하는 동안 반복하는 문장 - 반복횟수가
		 * 정확하지 않은 경우에 주로 사용한다.
		 */

		int a = 1;
		// a에 2씩 몇번을 곱해야 1000이상이 되는지 알아봅시다.
		int count = 0;
		while (a < 1000) {
			a *= 2;
			count++;
			System.out.println(count + " 회 > " + a);
		}
		// 괄호 안이 false가 되면 종료

		/*
		 * do-while문 - do{}while(조건식); - 최소한 한번의 수행을 보장한다. {}를 실행한 후 ()을 실행>()가
		 * true이면 다시 {}실행, ()가 false가 될 때까지
		 */

		// //숫자 맞추기 게임
		//
		// int answer = (int)(Math.random() *100)+1;
		// int input = 0;
		// Scanner s = new Scanner(System.in);
		// do{
		// System.out.println("1~100사이의 수를 입력해주세요>");
		// input = s.nextInt();
		// if(answer < input){
		// System.out.println(input + "보다 작습니다.");}
		// else if(input <answer){
		// System.out.println(input + "보다 큽니다.");}
		// else{System.out.println("정답입니다!");}
		// }while(input != answer);

		// 이름 붙은 반복문
		outer: for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 5) {
					// break; //가장 가까운 반복문 하나를 빠져나간다.
					// break outer; //outer라는 이름의 반복문을 빠져나간다.
					// continue; //가장 가까운 반복문의 현재 반복 회차를 빠져나간다.
					// continue outer;//outer라는 이름의 현재 반복 회차를 빠져나간다.
				}
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}

		// 별찍기
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		// for문 안에서는 별을 하나만 사용

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
				if (j >= i) {
					break;
				}
			}
			System.out.println();
		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();

		}
	}
}
