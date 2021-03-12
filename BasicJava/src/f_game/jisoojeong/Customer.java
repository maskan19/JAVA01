package f_game.jisoojeong;

public class Customer {

	String name;
	int money;
	Style[] style;

	Customer(String name, Style[] style) {
		this.name = name;
		this.style = style;

	}

	Style dfstyle(int num) {
		return this.style[num];
	}

}