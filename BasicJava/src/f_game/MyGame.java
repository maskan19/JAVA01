package f_game;

import e_oop.ScanUtil;

public class MyGame {

	Character c;
	Item[] items;
	int amor = 5;

	MyGame() {
	}

	MyGame(String name) {
		c = new Character(name, 100, 50, 20, 10);
		items = new Item[10];
		items[0] = new Item("무한의 대검", 0, 0, 70, 0);
		items[1] = new Item("가시갑옷", 350, 0, 0, 60);
		items[2] = new Item("징수의 총", 0, 0, 0, 55);
		items[3] = new Item("도미닉경의 인사", 0, 0, 0, 35);
	}

	public static void main(String[] args) {
		System.out.println("이름 지어");
		String input1 = ScanUtil.nextLine();
		new MyGame(input1).start();
		MyGame mg = new MyGame();
		System.out.println(mg.amor);
		// MyGame mg = new MyGame(input1);
		// mg.start();

	}

	void start() {
		int input = 0;
		while (true) {
			System.out.println("1.내 정보\t2.사냥\t3.종료");
			input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				c.showInfo();
				break;
			case 2:
				hunt();
				break;
			case 3:
				System.out.println("종료되었습니다.");
				System.exit(4);
				break;

			}
		}
	}

	// void hunt() {
	// Monster m = new Monster("고블린", 20, 10, 15, 10, new Item[]{items[0],
	// items[1]});
	// System.out.println(m.name + "를 만났습니다. 전투를 시작합니다.");
	//
	// int input = 0;
	//
	// battle : while(true) { //while 변수 지정 (battle)
	// System.out.println("1.공격\t2.도망");
	// input = ScanUtil.nextInt();
	// switch(input) {
	// case 1:
	// c.attack(m); //내가 몬스터를 공격함
	// if(m.hp <= 0) {
	// System.out.println(m.name + "을 처치하였습니다.");
	// c.getExp(150);
	// c.getItem(m.itemDrop());
	// break battle;
	// }
	// m.attack(c); //몬스터가 나를 공격함
	// break;
	// case 2:
	//
	// break battle;
	// }
	// }
	// }

	void hunt() {
		Monster m[] = new Monster[10];
		int sdf = (int) (Math.random() * 9) + 1;
		for (int i = 0; i < 10; i++) {
			m[i] = new Monster("고블린" + (i + 1), 20, 10, 15, 10, new Item[] {
					items[0], items[1], items[3], items[4] });
		}
		// Monster m = new Monster("고블린", 20, 10, 15, 10, new Item[] {
		// items[0],items[1] });
		System.out.println(m[sdf].name + "를 만났습니다. 전투를 시작합니다.");

		int input = 0;

		battle: while (true) { // while 변수 지정 (battle)
			System.out.println("1.공격\t2.도망");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				c.attack(m[sdf]); // 내가 몬스터를 공격함
				if (m[sdf].hp <= 0) {
					System.out.println(m[sdf].name + "을 처치하였습니다.");
					c.getExp(150);
					c.getItem(m[sdf].itemDrop());
					break battle;
				}
				m[sdf].attack(c); // 몬스터가 나를 공격함
				break;
			case 2:

				break battle;
			}
		}
	}

	// hunt(){
	// // Monster mm = new Monster();
	// // Monster m = new Monster("고블린", 20, 10, 15, 10, new
	// Item[]{items[0],items[1],items[3],items[4]});
	// Monster m[] = new Monster[10];
	// int sdf = (int)(Math.random() * 9)+1;
	// for(int i=0; i<10; i++) {
	// m[i] = new Monster("고블린"+(i+1), 20, 10, 15, 10, new
	// Item[]{items[0],items[1],items[3],items[4]});
	// }
	// // for(int i=0; i<m.length; i++) {
	// System.out.println(m[sdf].name + "를 만났습니다. 전투를 시작합니다");
	// // }
	// int input = 0;
	// battle : while(true){
	// System.out.println("1.공격\t2.도망");
	// input = ScanUtil.nextInt();
	// switch (input){
	// case 1:
	// c.attack(m[sdf]);
	// if(m[sdf].hp <=0){
	// System.out.println(m[sdf].name + "을 처치하였습다");
	// c.getExp(150);
	// c.getItem(m[sdf].itemDrop());
	// break;
	// }
	// m[sdf].attack(c);
	// break;
	// case 2:
	// break battle;
	// }
	// }
	//
	// }

}
