package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		// 숫자야구를 만드세요.

		Scanner s = new Scanner(System.in);

		int n1 = (int) (Math.random() * 9) + 1;
		int n2 = (int) (Math.random() * 9) + 1;
		int n3 = (int) (Math.random() * 9) + 1;
		while (n1 == n2 || n2 == n3 || n1 == n3) {
			n1 = (int) (Math.random() * 9) + 1;
			n2 = (int) (Math.random() * 9) + 1;
			n3 = (int) (Math.random() * 9) + 1;
		}

		int strike = 0;
		int ball = 0;
		int out = 3;
		System.out.println("=======숫자 야구=======");
		do {

			System.out.println("숫자 세자리를 입력하세요.");
			int ans1 = Integer.parseInt(s.nextLine());
			int q1 = ans1 / 100;
			int q2 = ans1 / 10 - 10 * q1;
			int q3 = ans1 - 100 * q1 - 10 * q2;

			strike = 0;
			ball = 0;
			out = 3;

			if (q1 == n1) {
				strike++;
			}
			if (q2 == n2) {
				strike++;
			}
			if (q3 == n3) {
				strike++;
			}

			System.out.print(strike + "S ");

			if (q1 == n2 || q1 == n3) {
				ball++;
			}
			if (q2 == n1 || q2 == n3) {
				ball++;
			}
			if (q3 == n1 || q3 == n2) {
				ball++;
			}
			System.out.print(ball + "B ");
			System.out.println(out - strike - ball + "O ");
		} while (strike < 3);
		System.out.print("====HOME RUN!=====");

		/***********************************************/

		int a1 = (int) (Math.random() * 9) + 1;
		int a2;
		int a3;

		do {
			a2 = (int) (Math.random() * 9) + 1;
		} while (a1 == a2);

		do {
			a3 = (int) (Math.random() * 9) + 1;
		} while (a1 == a3 || a2 == a3);

		int count = 0;
		while (true) {
			System.out.print("3자리 숫자>");
			int input = Integer.parseInt(s.nextLine());
			int i3 = input % 10;
			input /= 10;
			int i2 = input % 10;
			input /= 10;
			int i1 = input % 10;

			strike = 0;
			ball = 0;

			if (a1 == i1)
				strike++;
			if (a2 == i2)
				strike++;
			if (a3 == i3)
				strike++;

			if (a1 == i2 || a1 == i3)
				strike++;
			if (a2 == i1 || a2 == i3)
				strike++;
			if (a3 == i1 || a3 == i2)
				strike++;

			out = 3 - strike - ball;

			System.out.println(++count + "차 시도(" + i1 + i2 + i3 + ") :"
					+ strike + "S" + ball + "B" + out + "O");

			System.out.println("-----------------------");
			if (strike == 3) {
				System.out.println("정답입니다.");
				break;
			}

		}

	}

}
