package f_game.jisoojeong;

public class Hairshop {
	String name;
	int asset;
	int day;
	int maxtable;
	int exp;
	int maxexp;
	int level;
	int maintenance;
	Effect[] effects;
	int inven;
	int salary;

	// Tycoon ty = new Tycoon();
	Hairshop(String name) {
		this.name = name;
		this.asset = 0;
		this.day = 1;
		this.maxtable = 10;
		this.exp = 0;
		this.maxexp = 150;
		this.level = 1;
		this.maintenance = -200000;
		this.effects = new Effect[4];
		this.inven = 0;
	}

	void Info() {
		System.out.println("\t\t" + name + "  ππππ‘ π’ππππ");
		System.out.println();
		System.out.println("\t\tDay " + day);
		System.out
				.println("\t\tlv. " + level + " (" + exp + "/" + maxexp + ")");
		System.out.format("\t\tμ΄ μμ° : %+,d μ%n", asset);
		System.out.format("\t\tμ΄ μ μ§λΉ : %+,d μ%n", maintenance);
		for (int i = 0; i < effects.length; i++) {
			if (effects[0] == null) {
				System.out.println("\tκ³ μ© μ€μΈ μλ₯΄λ°μ΄νΈμμ΄ μμ΅λλ€.");
				System.out.println();
				break;
			} else if (effects[i] != null) {
				System.out.print("   κ³ μ© μ€μΈ μλ₯΄λ°μ΄νΈμ" + (i + 1) + " : "
						+ effects[i].effectinfo());
				System.out.println();
			}
		}
	}

	void getExp(int ex) {
		System.out.println("\t\t      +" + ex + " exp");
		// this.exp += ex;
	}

	void getMoney(int money) {
		System.out.println("\t\t     +" + money + " μ");
		System.out.println();
		// this.asset += money;
	}

	void levelUp() {
		this.level++;
		maxexp += 50;
		try {
			Thread.sleep(130);
		} catch (InterruptedException e) {
		}
		;
		System.out
				.println("πππππππππππππππππππππππππ\n\t\tππ LEVEL UP ππ");
		System.out.println("\t\tλ λ²¨μ λ³΄μ : " + 10000 * level + " μ");
		this.asset += 10000 * level;
	}

	int maintenance() {
		maintenance = -200000 - 10000 * day;
		return maintenance;
	}

	void bankrupt() {
		if (asset < 0) {
			System.out.println("νμ°νμ΅λλ€.");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			new Tycoon();
			Tycoon.main(null);
		}
	}

	void geteffect(Effect ef) {
		if (asset >= ef.expense) {
			if (inven < 4) {
				asset -= ef.expense;
				System.out.println("\t" + ef.name + "μ κ³ μ©νμ΅λλ€.");
				for (int i = inven; i < effects.length; i++) {
					if (effects[i] == null) {
						effects[i] = ef;
						inven++;
						break;
					}
				}
			} else {
				System.out.println("\t\tλμ΄μ κ³ μ©ν  μ μμ΅λλ€.");
			}
		} else {
			System.out.println("\t\tμμ°μ΄ λΆμ‘±ν©λλ€.");
		}
	}

	void buff() {
		double expbuff = 0;
		double moneybuff = 0;
		double maintbuff = 0;

		for (int i = 0; i < effects.length; i++) {
			if (effects[i] != null) {
				expbuff += effects[i].buff_getExp;
				moneybuff += effects[i].buff_getMoney;
				maintbuff += effects[i].maintanance;
				salary += effects[i].sal;
			}
		}
		Tycoon.exp += expbuff;
		Tycoon.income *= (1 + moneybuff);
		maintenance *= (1 + maintbuff);
		maintenance -= salary;
	}
	// this.asset = (int)(asset*ef.buff_getMoney);
	// this.exp = (int)(exp*ef.buff_getExp);
	// this.maintenance = (int) (maintenance*ef.maintanance) ;

}