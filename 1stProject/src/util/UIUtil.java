package util;

import java.util.List;

public class UIUtil {

	public static void selecter(List<String> buttons, int x,String end) {

		for (int i = 0; i < buttons.size(); i++) {
			if (x == i + 1) {
				System.out.println(select_bt(buttons.get(i).toString()));
			} else {
				System.out.println(buttons.get(i));
			}
		}

		System.out.println(end);
	}
	


	public static int chooser(List<String> buttons, int x, String header, String end) {
		while (true) {
			System.out.println(header);
			selecter(buttons, x,end);
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > buttons.size()) {
					x -= buttons.size();
				}

				break;
			case 8:
				x--;
				if (x < 1) {
					x += buttons.size();
				}

				break;
			case 5:
				return x;
			}
		}
	}
	

	public static String select_bt(String a) {
		a = a.replace("┌", "┏");
		a = a.replace("└", "┗");
		a = a.replace("┐", "┓");
		a = a.replace("┘", "┛");
		a = a.replace("│", "┃");
		a = a.replace("─", "━");
		return a;
	}
	
	
	
	
}
