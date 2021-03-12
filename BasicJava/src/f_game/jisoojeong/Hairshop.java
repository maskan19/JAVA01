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
		System.out.println("\t\t" + name + "  𝓗𝓐𝓘𝓡 𝓢𝓐𝓛𝓞𝓝");
		System.out.println();
		System.out.println("\t\tDay " + day);
		System.out
				.println("\t\tlv. " + level + " (" + exp + "/" + maxexp + ")");
		System.out.format("\t\t총 자산 : %+,d 원%n", asset);
		System.out.format("\t\t총 유지비 : %+,d 원%n", maintenance);
		for (int i = 0; i < effects.length; i++) {
			if (effects[0] == null) {
				System.out.println("\t고용 중인 아르바이트생이 없습니다.");
				System.out.println();
				break;
			} else if (effects[i] != null) {
				System.out.print("   고용 중인 아르바이트생" + (i + 1) + " : "
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
		System.out.println("\t\t     +" + money + " 원");
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
				.println("🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉🎉\n\t\t🎊🎊 LEVEL UP 🎊🎊");
		System.out.println("\t\t레벨업 보상 : " + 10000 * level + " 원");
		this.asset += 10000 * level;
	}

	int maintenance() {
		maintenance = -200000 - 10000 * day;
		return maintenance;
	}

	void bankrupt() {
		if (asset < 0) {
			System.out.println("파산했습니다.");
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
				System.out.println("\t" + ef.name + "을 고용했습니다.");
				for (int i = inven; i < effects.length; i++) {
					if (effects[i] == null) {
						effects[i] = ef;
						inven++;
						break;
					}
				}
			} else {
				System.out.println("\t\t더이상 고용할 수 없습니다.");
			}
		} else {
			System.out.println("\t\t자산이 부족합니다.");
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