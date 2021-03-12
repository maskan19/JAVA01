package f_game;

public class Monster {

	String name;
	int maxHp;
	int maxMp;
	int hp;
	int mp;
	int att;
	int def;
	Item[] items;

	Monster() {
	}

	Monster(String name, int hp, int mp, int att, int def, Item[] items) {
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxHp;
		this.att = att;
		this.def = def;
		this.items = items;
	}

	void attack(Character m) {
		int damage = att - m.def;
		damage = damage <= 0 ? 1 : damage;
		m.hp = m.hp < damage ? m.hp - m.hp : m.hp - damage;
		System.out.println(name + "가 공격으로 " + m.name + "에게" + damage
				+ "만큼 데미지를 주었습니다.");
		System.out.println(m.name + "의 남은 HP : " + m.hp);
	}

	Item itemDrop() {
		return items[(int) (Math.random() * items.length)];
	}
}
