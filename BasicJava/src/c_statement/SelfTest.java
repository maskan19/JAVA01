package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
//		탄수화물 자가중독 테스트

		Scanner s = new Scanner(System.in);

		int score = 0;

		System.out.println("탄수화물 자가중독 테스트\n아침을 배불리 먹은 후 점심시간 전에 배가 고프다");
		String answer1 = s.nextLine();
		switch (answer1) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("밥, 빵, 과자 등 음식을 먹기 시작하면 끝이 없다");
		String answer2 = s.nextLine();
		switch (answer2) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}

		System.out.println("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다");
		String answer3 = s.nextLine();
		switch (answer3) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("정말 배고프지 않더라도 먹을 때가 있다");
		String answer4 = s.nextLine();
		switch (answer4) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다");
		String answer5 = s.nextLine();
		switch (answer5) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("스트레스를 받으면 자꾸 먹고 싶어진다");
		String answer6 = s.nextLine();
		switch (answer6) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다");
		String answer7 = s.nextLine();
		switch (answer7) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다");
		String answer8 = s.nextLine();
		switch (answer8) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다");
		String answer9 = s.nextLine();
		switch (answer9) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}
		System.out.println("다이어트를 위해 식이조절을 하는데 3일도 못 간다");
		String answer10 = s.nextLine();
		switch (answer10) {
		case "o":
		case "O":
		case "0":
		case "ㅇ":
			score++;
			break;
		}

		System.out.println("탄수화물 중독 수치는 " + score + "점입니다.");

		if (score >= 7) {
			System.out.println("중독!\n전문의 상담이 필요함");
		} else if (score >= 4) {
			System.out.println("위험!\n탄수화물 섭취 줄이기 위한 식습관 개선이 필요함");
		} else if (score == 3) {
			System.out.println("주의!\n위험한 수준은 아니지만 관리 필요");
		} else {
			System.out.println("당신은 건강합니다!");
		}

		/**************************/

		String answer = null;
		int sum = 0;

		System.out.println("=========탄수화물 자가진단=========");
		System.out.println("아침을 배불리 먹은 후 점심시간 전에 배가 고프다(Y/N)");
		// 무엇을 입력해야하는지 안내해야함
		answer = s.nextLine();
		if (answer.equals("Y"))
			sum++;
		System.out.println("진단결과");
		if (sum < 3) {
			System.out.println("안전");
		} else if (sum == 3) {
			System.out.println("주의!");
		} else if (sum <= 6) {
			System.out.println("위험");
		}

	}

}
