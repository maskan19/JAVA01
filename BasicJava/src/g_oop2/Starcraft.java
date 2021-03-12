package g_oop2;

public class Starcraft {

	// super 는 부모 클래스의 변수와 자식 클래스가 같을 때 쓰는거구
	// super() 는 부모 클래스의 생성자를 호출할때 쓰는거래여

	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();

		scv.repair(tank);
		scv.repair(dropship);
		// scv.repair(marine); : 마린은 Repairable이 아니라서 컴파일 에러
	}
}

class Unit {
	int hp; // 현재체력
	final int MAX_HP; // 최대 체력

	Unit(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class Marine extends Unit {
	Marine() {
		super(40);
	}
}

class Tank extends Unit implements Repairable {
	Tank() {
		super(150);
	}
}

class Dropship extends Unit implements Repairable {
	Dropship() {
		super(125);
	}
}

class SCV extends Unit {
	SCV() {
		super(60);
	}

	void repair(Repairable r) {
		if (r instanceof Unit) { // Unit으로 형변환이 가능한지 확인
			Unit u = (Unit) r;
			while (u.hp < u.MAX_HP) {
				u.hp++;
			}
		}
	}
}

interface Repairable {

}
