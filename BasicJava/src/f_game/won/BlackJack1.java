package f_game.won;

import java.util.Arrays;
import java.util.Scanner;

public class BlackJack1 {

	Scanner s = new Scanner(System.in);
	User u; // user
	User d; // dealer
	Card[] card;
	int c; // 분배된 카드 수

	BlackJack1() {
		u = new User();
		d = new User();
		card = new Card[13];
		card[0] = new Card(1, "A");
		card[1] = new Card(2, "2");
		card[2] = new Card(3, "3");
		card[3] = new Card(4, "4");
		card[4] = new Card(5, "5");
		card[5] = new Card(6, "6");
		card[6] = new Card(7, "7");
		card[7] = new Card(8, "8");
		card[8] = new Card(9, "9");
		card[9] = new Card(10, "10");
		card[10] = new Card(10, "J");
		card[11] = new Card(10, "Q");
		card[12] = new Card(10, "K");
		c = 0;
	}

	public static void main(String[] args) {
		new BlackJack1().start();
	}

	void explanation() {
		try {
			System.out
					.println("                                      wZZZZZZZZ8      \n                   5BzzzzzzzzzzzzzzzBZZZZW  WZZZZZZZD   \n                9ZZZZZZZZZZZZZZZZZZZZZZ          BZZZZZZEw  \n               ZZZD                 ZZy      ZZ      WZZZZZZZB          \n              ZZZ      ZZZZD       ZZZ     wZ8Z           DZZZZZZZW     \n              ZZ9       8Z        ZZZ    ZZZZwZ               ,9ZZZZZW  \n              ZZ8       EZ        ZZ8    Zj  BZZ                   ZZZZ \n              ZZ8  jZZE 9Z       ZZZ  BZZZ    Z                     yZZj\n              ZZ8   jZ  ZZ      9ZZ         ZZZB                     ZZE\n              ZZ8    ZZZZj      ZZZ           ,Z                     ZZD \n              ZZ8              ZZZ                                  ZZZ  \n              ZZ8        jDDW jZZW              ZZZZ               ZZZ   \n              ZZ8     wZZZZZZZZZZ            yZZZEEZ               ZZE   \n              ZZ8    jZ8BBBDjEZZ          5ZZZZ9888Z8             ZZZ    \n              ZZ8    Z8BBBD5BZZ5       8ZZZZ9888888EZ            BZZ,    \n              ZZ8    Z8BBB5yZZZ      ZZZZ98888888888ZZ           ZZZ     \n              ZZ8    DZzBDy9ZZ      ZZ98888888888888EZ,         ZZZ      \n              ZZ8     DZ85DZZz      Z8888888888888888ZZ        jZZ5      \n              ZZ8       ZBZZZ       ZZ9888888888888888ZZ       ZZZ       \n              ZZ8        ZZZ         ZZZZZZZZZE88888889Z      ZZZ        \n              ZZ8        ZZZ           ,5j  Z ZZ988889ZZ     ,ZZ8        \n              ZZ8       ZZZ                ZZ  ZZZZZZZZ      ZZZ         \n              ZZ8       ZZz              EZZZ    5EEB,      9ZZ          \n              ZZW       ZZZ             ZZZEZ               ZZD          \n         9ZZZZZZZZZZZZZZZZZZZZE    ZZZZZZz BZZZZZZZZZZZZZZZZZZZZZZZZ     \n        zZZEEE98999EZZZZE8EZzZZZ  ZZZEEEZZZZZE,     jZZww  ww     ZZZ    \n        yZZ                  Z9ZZZZZ     ZZZ   W55yW     WW, yWB  ZZ9    \n        yZZ  DZZWyj8ZB ,ZZZ  ZZZZZZ  ZZZ  Z8 ZZjDD5ZZZ   ZZ  ZZ   ZZE    \n        jZZZ  Z9jzD8Z   wZw  ZZZZZ8 8Z ZE    ZZ          ZZEZ  BZZZZj    \n        yZZZ  Zz    9Z  ,Z          ZZ EZW   ZZ     yj   Z9 ZZ  5WZZE    \n        yZZ  ZZZ9ZZEZZ wZZZ9Z9ZZ WEZZD 5ZZE5 ZZZZZZZZE  jZZ, ZZZ  ZZZ    \n        yZZ                                                       ZZZ    \n        5ZZZZZZZZZZZZZ EZZZD ZZ ZZ5 ZZZ 8ZZZZZZZ   ZZZ BZZE ZZZZZZZZZ    \n         WZZZ8ZZZ    w  yZ,    jZ8Z  Z  ZZ    wZ9  8Z  Z5   ZZZ8ZZZj     \n              ZZZ j8z   yZj    ZD ZZ    ZZ ZZ      EZZZB  ZZZZZ          \n              ZZZ  ZZ , EZj   ZZ5DDZ8   ZZ    DZZ  9Z  ZZ   9ZZ          \n              ZZZZ  j9ZED   5Z98, ZzEZ  wZZZZZZ8   ZZZ WZZZ EZZ          \n                ZZZB     WZ                     8           9ZZ          \n                 5ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ          \n\n"
							+ "블랙잭 게임에 오신것을 환영합니다.");

			Thread.sleep(500);

			System.out.println("<게임 룰>");
			Thread.sleep(200);

			System.out.println(" 1. 랜덤카드를 2장 받습니다. ");
			Thread.sleep(200);
			System.out
					.println(" 2. 합이 16이 넘지 않을 경우, 1장을 더 받거나 그대로 진행할 수 있습니다.");
			Thread.sleep(200);
			System.out
					.println(" 3. 딜러는 2장의 카드를 받고 합이 16이 넘지 않을 경우, 1장을 더 받습니다.");
			Thread.sleep(200);
			System.out
					.println(" 4. 각 게임마다 원하는 만큼의 금액을 배팅할 수 있으며 딜러는 유저의 2배를 배팅합니다.");

			Thread.sleep(200);
			System.out.println(" 5. 배팅을 하지 않고 포기 할 경우 참여금은 상대방에게 돌아갑니다.");
			Thread.sleep(200);
			System.out
					.println(" 6. 카드의 총 합이 상대방의 총 합보다 크고 21보다 작거나 같으면 승리입니다.");
			Thread.sleep(200);
			System.out
					.println(" 7. 두 수의 합이 같거나 둘 다 21보다 큰 경우 비기고 배팅금의 반만큼 환급됩니다.");
			Thread.sleep(200);
			System.out.println(" 8. 둘 중 하나가 파산하면 게임이 완전히 종료됩니다.");

			Thread.sleep(200);
			System.out.println("$$$$$지나친 도박은 지갑에 악영향을 줄 수 있습니다$$$$$");
			System.out.println();

		} catch (InterruptedException e) {
		}
	}

	void start() {
		explanation();
		while (true) {
			System.out.println("게임을 시작하시겠습니까?(y/n)");
			String YesOrNo = s.nextLine();

			if (YesOrNo.equals("y") || YesOrNo.equals("Y")) {

				System.out.println("게임을 시작합니다.");

				// ////////////////////////////////////////////////////////////
				System.out.println("배팅 금액을 입력하세요.");
				System.out.println("현재 자산 : " + u.Money + "원");
				int bet = Integer.parseInt(s.nextLine());
				u.Bet += bet;
				d.Bet += bet;
				u.Money -= bet;
				d.Money -= bet;
				usercard();
				dealrcard();
				System.out.println(u.Sum + "유저점수"); // ////////
				System.out.println(d.Sum + "딜러점수"); // ///////////
				userscore();
				dealerscore();
				result();
			} else if (YesOrNo.equals("n") || YesOrNo.equals("N")) {
				System.out.println("게임이 종료됩니다.");
				System.exit(0);
			} else {
				System.out.println("다시 입력해주세요.");
				start();
			}
		}
	}

	void usercard() {
		System.out.println("Hit!");
		System.out.println("두장의 카드를 얻습니다.");
		for (c = 0; c < 2; c++) {
			u.card[c] = card[(int) (Math.random() * 13)];
			d.card[c] = card[(int) (Math.random() * 13)];
			u.Sum += u.card[c].index;
			d.Sum += d.card[c].index;
		}
		System.out.println("획득한 카드 : " + u.card[0].num + ", " + u.card[1].num);
		System.out.println("딜러의 첫 카드 : " + d.card[0].num);

		bet: while (true) {
			System.out.println("카드를 한장 더 받으시겠습니까? (y/n)");
			String YesOrNo1 = s.nextLine();
			if (YesOrNo1.equals("y") || YesOrNo1.equals("Y")) {
				System.out.println("현재 자산 : " + u.Money + "원");
				System.out.println("배팅 금액을 입력하세요.");
				int bet = Integer.parseInt(s.nextLine());
				u.Bet += bet;
				d.Bet += bet;
				u.Money -= bet;
				d.Money -= bet;
				System.out.println("현재 판돈 : " + (u.Bet * 2));

				u.card[c] = card[(int) (Math.random() * 13)];
				System.out.println("추가 획득한 카드 : " + u.card[c].num);
				u.Sum += u.card[c].index;
				c++;
			} else if (YesOrNo1.equals("n") || YesOrNo1.equals("N")) {
				System.out.println("스탠드 하시겠습니까? (y/n)");
				String ans = s.nextLine();
				switch (ans) {
				case "y":
				case "Y":
					System.out.println("Stand!");
					System.out.print("최종 카드 : ");
					for (int i = 0; i < u.card.length; i++) {
						if (u.card[i] != null) {
							System.out.print(u.card[i].num + ", ");
						}
					}
					break bet;
				case "n":
				case "N":
					System.out.println("Surrender!");
					System.out.println("배팅을 포기합니다.");
					System.out.println(u.Bet / 2 + "원을 획득합니다.");
					u.Money += u.Bet / 2;
					d.Money += d.Money + u.Bet / 2;
					break bet;
				}
			}
		}
	}

	void dealrcard() {
		c = 2;
		if (d.Sum <= 16) {
			d.card[c] = this.card[(int) (Math.random() * 13)];
			d.Sum += d.card[c].index;
		}
		System.out.println("딜러가 획득한 카드 : " + d.card[0].num + d.card[1].num
				+ d.card[2].num);
	}

	int userscore() {
		if (u.Sum > 21) {
			u.Sum = 0;
		}
		for (int i = 0; i < c; i++) {
			if (u.card[i].num.equals("A")) {
				System.out.println("A의 점수를 선택하세요. 1/11");
				String a = s.nextLine();
				if (a.equals("11")) {
					u.Sum += 10;
				} else {
					System.out.println("1점고름");
				}
			} else {
				System.out.println("a없음");
			}
		}
		return u.Sum;
	}

	int dealerscore() {
		if (d.Sum > 21) {
			d.Sum = 0;
		}
		if (d.Sum <= 11) {
			for (int i = 0; i < 3; i++) {
				if (u.card[i].num.equals("A")) {
					d.Sum += 10;
				}
			}
		}
		return d.Sum;
	}

	void result() {
		int res = d.Sum - u.Sum;
		if (res > 0) {
			u.Lose(u, d);
		} else if (res == 0) {
			u.Draw(u, d);
		} else {
			u.Win(u, d);
		}
	}

}
