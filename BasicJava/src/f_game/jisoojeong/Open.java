package f_game.jisoojeong;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Open extends Thread {
	Style[] style;
	Hairshop hairshop;

	Open() {
	}

	Open(Hairshop h) {
		hairshop = h;
		style = new Style[6];
		style[0] = new Style("1", "컷", 20000, 20, 5);
		style[1] = new Style("2", "영양", 30000, 30, 5);
		style[2] = new Style("3", "염색", 40000, 40, 10);
		style[3] = new Style("4", "탈색", 50000, 40, 10);
		style[4] = new Style("5", "펌", 60000, 100, 30);
		style[5] = new Style("6", "매직", 90000, 120, 30);
	}

	// Dayrun dr = new Dayrun();
	// Thread drthread = new Thread(dr);
	// Tycoon ty = new Tycoon();
	public void run() {
		// drthread.start();
		try {
			System.out.println("\t\t   - Day " + hairshop.day + " 시작 -");
			Scanner s = new Scanner(System.in);

			DecimalFormat df = new DecimalFormat("#,##0");
			Customer cus[] = new Customer[100];
			Tycoon.income = 0;
			Tycoon.count = 0;
			for (int i = 0; i < 5 + hairshop.level * 3; i++) {
				cus[i] = new Customer("손님" + (i + 1), new Style[] { style[0],
						style[1], style[2], style[3], style[4], style[5] });
				int num = (int) (Math.random() * style.length);
				System.out.println("\t\t  " + cus[i].name + "이 입장하셨습니다.");
				String input = "";
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					;
					System.out.println("\t\t" + cus[i].name + " : \""
							+ cus[i].dfstyle(num).name + "이 하고 싶어요.\"\n");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					;
					System.out.println("\t\t  제공할 스타일을 고르세요.");
					System.out
							.println("1. 컷\t2. 영양\t3. 염색\t4. 탈색\t5. 펌\t6. 매직");
					input = s.nextLine();
					if (input.equals(cus[i].dfstyle(num).index)) {

						System.out.print("스타일링 중입니다. ");
						try {
							for (int a = 0; a <= 25; a++) {
								Thread.sleep(cus[i].dfstyle(num).time);
								System.out.print("▮");
							}
						} catch (InterruptedException e) {

						}
						System.out.println();
						System.out.println("\t    " + cus[i].name
								+ " : \"내가 원했던 스타일이에요!\"");
						System.out.println("\t\t      손님이 기뻐합니다.\n");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
						}
						;
						hairshop.getExp(cus[i].dfstyle(num).exp);
						hairshop.getMoney(cus[i].dfstyle(num).price);
						Tycoon.exp += cus[i].dfstyle(num).exp;
						Tycoon.income += cus[i].dfstyle(num).price;
						Tycoon.count++;

						break;
					} else {
						try {
							System.out.print("스타일링 중입니다. ");
							for (int a = 0; a < 25; a++) {
								Thread.sleep(500);
								System.out.print("▮");
							}
							System.out.println();
							System.out.println("\t      " + cus[i].name
									+ " : \"" + cus[i].dfstyle(num).name
									+ "이 하고 싶다고 했잖아요!\"");
							Thread.sleep(500);
							System.out.println("\t\t손님이 컴플레인을 걸었습니다.");
							Thread.sleep(500);
							System.out.println("\t\t   전액 환불하여 배상합니다.");
							Thread.sleep(100);
							System.out.println("\t\t      +0 exp");
							Thread.sleep(100);
							System.out.println("\t\t       +0 원");
						} catch (InterruptedException e) {
						}
						break;
					}
				}
			}

			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// drthread.interrupt(); // /이게 안 먹히고 있음
			System.out.println("\t\t모든 손님이 다녀갔습니다.");
		}
		System.out.println("\t\t    장사를 종료합니다.");

	}
}
