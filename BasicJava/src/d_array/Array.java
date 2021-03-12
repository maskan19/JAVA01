package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// sysout + Ctrl + Spacebar : System.out.println()
		// 라인삭제 : Ctrl + D
		// 라인복사 : Ctrl + Alt + 방향키(위/아래)
		// 라인이동 : Alt + 방향키(위/아래)

		/*
		 * 배열 - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다. - 참조형 타입이다. - 인덱스로 값을 구분한다. - 길이를
		 * 변경할 수 없다.
		 */

		int[] array; // 배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5]; // 배열이 생성되고 그 주소가 저장된다.
		// 배열 초기화시 기본 값이 저장된다.
		/*
		 * - 기본 값 정수 : 0 실수 : 0.0 문자 : ' '(0) 공백 논리 : false 참조형 : null
		 */

		array = new int[] { 1, 2, 3, 4, 5 };

		// array = {1, 2, 3, 4, 5};
		// 선언과 초기화를 동시에 해야한다.
		int[] array2 = { 1, 2, 3, 4, 5 };

		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);

		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;

		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("합계 : " + sum);

		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.

		int[] a1 = new int[10];

		for (int i = 0; i < a1.length; i++) {
			a1[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(a1)); // 컴파일 에러가 나면 임포트

		// 배열에 저장된 모든 값의 합계와 평균을 구해주세요.

		sum = 0;
		for (int i = 0; i < a1.length; i++) {
			sum += a1[i];
		}
		double avg = (double) sum / array.length;
		System.out.println("합계 : " + sum + " / 평균 : " + avg);

		// 배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.

		int min = a1[0];
		int max = a1[0];

		for (int i = 0; i < a1.length; i++) {
			if (min > a1[i]) {
				min = a1[i];
			}
			if (max < a1[i]) {
				max = a1[i];
			}
		}
		System.out.println("min : " + min + " / max : " + max);

		int[] shuffle = new int[10];
		for (int i = 0; i < shuffle.length; i++) {
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));

		// 배열의 값을 섞어주세요.

		for (int i = 0; i < 100; i++) {
			int num = (int) (Math.random() * shuffle.length);
			int temp = shuffle[0];
			shuffle[0] = shuffle[num];
			shuffle[num] = temp;
		}
		System.out.println(Arrays.toString(shuffle));

		// 1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.

		int[] ran_a = new int[500];

		for (int i = 0; i < ran_a.length; i++) {
			ran_a[i] = (int) (Math.random() * 10) + 1;
		}

		for (int a = 1; a < 11; a++) {
			int count = 0;
			for (int i = 0; i < ran_a.length; i++) {
				if (ran_a[i] == a) {
					count++;
				}
			}
			System.out.println(a + "의 횟수 : " + count);
		}

		/*************************************************/

		int[] count = new int[10];

		for (int i = 0; i < 500; i++) {
			int random = (int) (Math.random() * 10) + 1;
			count[random - 1]++;
		}
		System.out.println(Arrays.toString(count));

		// 위 문제의 최소값, 최대값, 발생횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.

		Scanner s = new Scanner(System.in);

		int start;
		int end;
		do {
			System.out.println("랜덤 생성 최소값을 설정하세요>");
			start = Integer.parseInt(s.nextLine());
			System.out.println("랜덤 생성 최대값을 설정하세요>");
			end = Integer.parseInt(s.nextLine());
		} while (end < start);
		System.out.println("랜덤 생성할 횟수를 입력하세요>");
		int amount = Integer.parseInt(s.nextLine());

		int[] count1 = new int[end - start + 1];
		int random;
		for (int i = 0; i < amount; i++) {
			random = (int) (Math.random() * (end - start + 1) + start);
			count1[random - start]++;
		}
		// System.out.println(Arrays.toString(count1));
		for (int i = 0; i < end - start + 1; i++) {
			System.out.println(start + i + "생성 횟수 : " + count1[i]);
		}
        /*************일치*************/
	}

}
