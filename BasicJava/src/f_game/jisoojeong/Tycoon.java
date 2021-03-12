package f_game.jisoojeong;

import java.util.Scanner;

///////////////전부 스캐너를 사용했다. 수정 필요

public class Tycoon {
	Hairshop hairshop;
	Style[] style;
	Effect[] effect;
	static int income = 0;
	static int count = 0;
	static int exp = 0;
	static String name;

	Tycoon() {
	}

	Tycoon(String name) {
		hairshop = new Hairshop(name);
		style = new Style[6];
		style[0] = new Style("1", "컷", 20000, 20, 5);
		style[1] = new Style("2", "영양", 30000, 30, 5);
		style[2] = new Style("3", "염색", 40000, 40, 10);
		style[3] = new Style("4", "탈색", 50000, 40, 10);
		style[4] = new Style("5", "펌", 60000, 100, 30);
		style[5] = new Style("6", "매직", 90000, 120, 30);
		effect = new Effect[4];
		effect[0] = new Effect("1", "곱고 짧게 큰 상가 건물주 아들", 30000, -0.1, 0, -0.3,
				8500 * 6);
		effect[1] = new Effect("2", "엄마 친구의 언니의 사돈의 옆집 딸", 36000, +0.1, 5, 0,
				9500 * 6);
		effect[2] = new Effect("3", "아들 머리로 10년 내공 쌓은 아줌마", 27000, +0.05, 10,
				-0.1, 10000 * 6);
		effect[3] = new Effect("4", "츄르 내놓으라고 우는 때 탄 고양이", 60000, +0.2, 0,
				+0.1, 15000 * 6);
	}

	public static void main(String[] args) {
		System.out.println("\n\t\t            🅦ⒺⓁⒸⓄⓂⒺ  🅣Ⓞ\n");
		System.out
				.println("   ┏┓ ┏┳━━━┳━━┳━━━┓┏━━━┳━━━┳┓  ┏━━━┳━┓ ┏┓\n   ┃┃ ┃┃┏━┓┣┫┣┫┏━┓┃┃┏━┓┃┏━┓┃┃  ┃┏━┓┃┃┗┓┃┃\n   ┃┗━┛┃┃ ┃┃┃┃┃┗━┛┃┃┗━━┫┃ ┃┃┃  ┃┃ ┃┃┏┓┗┛┃\n   ┃┏━┓┃┗━┛┃┃┃┃┏┓┏┛┗━━┓┃┗━┛┃┃ ┏┫┃ ┃┃┃┗┓┃┃\n   ┃┃ ┃┃┏━┓┣┫┣┫┃┃┗┓┃┗━┛┃┏━┓┃┗━┛┃┗━┛┃┃ ┃┃┃\n   ┗┛ ┗┻┛ ┗┻━━┻┛┗━┛┗━━━┻┛ ┗┻━━━┻━━━┻┛ ┗━┛");
		System.out.println();
		new Tycoon().menu();
	}

	void menu() {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out
					.println("\t\t    MAIN MENU\n\t\t    1. PLAY\n\t\t    2. HOW TO \n\t\t    3. EXIT");
			System.out.println();
			String input = s.nextLine();

			switch (input) {
			case "1":
				System.out.println("\t\t  미용실 이름을 입력하세요.");
				String name = s.nextLine();
				new Tycoon(name).start();
				break;
			case "2":
				System.out
						.println("how to~\n 손님이 원하는 머리를 해주고 경험치와 돈을 받고 가게를 성장시키세요.\n 알바는 최대 4명까지 고용할 수 있으며 각각 고유 버프가 다릅니다.\n자산이 0원이 되면 파산합니다.");
				// System.out.println("➀➁➂➃➄➅➆➇➈➉ ❶❷❸❹❺➏➐➑➒➓");
				break;
			case "3":
				System.out.println("- HAIR SALON이 종료됩니다. -");
				System.exit(0);
				break;
			}
		}
	}

	void start() {
		Scanner s1 = new Scanner(System.in);

		String input = "";
		play: while (true) {
			System.out
					.println("1.내 정보      2.알바 고용     3.장사 시작      4.메인메뉴로 돌아가기");
			input = s1.nextLine();
			switch (input) {
			case "1":
				hairshop.Info();
				break;
			case "2":
				System.out.println("\t      고용할 알바생을 골라주세요.");
				for (int i = 0; i < effect.length; i++) {
					System.out.println("\t" + effect[i].index + ". "
							+ effect[i].name);
				}
				int num = Integer.parseInt(s1.nextLine());
				hairshop.geteffect(effect[num - 1]);
				break;
			case "3":
				// Open op = new Open();
				Dayrun dr = new Dayrun(hairshop);
				Thread drthread = new Thread(dr);
				drthread.start();

				try {
					drthread.join();
					adjustment();
					while (hairshop.maxexp <= hairshop.exp) {
						hairshop.levelUp();
						hairshop.exp -= hairshop.maxexp;
					}
					hairshop.day++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "4":
				System.out.println();
				break play;
			}
		}
	}

	void adjustment() {
		// hairshop.asset = (int)
		hairshop.buff();
		hairshop.exp += exp;
		hairshop.asset += income;

		System.out.println("\t\t   - Day " + hairshop.day + " 종료 -");
		System.out.println("\t\t  일일 정산 결과");
		System.out.println("\t\t손님 만족도 : "
				+ (int) (count * 100 / (5 + hairshop.level * 3)) + "%");
		System.out.format("\t\t총 매출 : %+,d 원%n", income);
		System.out.format("\t\t총 지출 : %+,d 원%n", hairshop.maintenance);
		// int x = ;
		hairshop.asset += hairshop.maintenance;

		System.out
				.format("\t\t일일 소득 : %+,d 원%n", income + hairshop.maintenance);
		System.out.println();
		hairshop.bankrupt();
	}
}