package f_game.jisoojeong;

public class Effect {

	String index;
	String name;
	double expense;
	double buff_getMoney;
	double buff_getExp;
	double maintanance;
	int sal;

	Effect(String index, String name, double expense, double buff_getMoney,
			double buff_getExp, double maintanance, int sal) {
		this.index = index;
		this.name = name;
		this.expense = expense;
		this.buff_getMoney = buff_getMoney;
		this.buff_getExp = buff_getExp;
		this.maintanance = maintanance;
		this.sal = sal;
	}

	String effectinfo() {
		String info = name + " ";
		return info;
	}
}
