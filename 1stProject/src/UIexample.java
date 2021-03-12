import java.util.Scanner;

import util.ScanUtil;


public class UIexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		while(true){

		String comments_bt = "┌──────┐\n│ 영화평 │\n└──────┘\n";
		String book_bt = "┌──────┐\n│예매하기│\n└──────┘\n";
		System.out.println(comments_bt);
		System.out.println(book_bt);

		
		
		
		int x = 0;
		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if(x>3){x-=0;}
				if(x<0){x+=3;}
				String a = x == 1 ? select_bt(comments_bt) : comments_bt;
				String b = x == 2 ? select_bt(book_bt) : book_bt;
				System.out.println(a);
				System.out.println(b);
				break;
			case 8:
				x--;
				if(x>3){x-=0;}
				if(x<0){x+=3;}
				a = x == 1 ? select_bt(comments_bt) : comments_bt;
				b = x == 2 ? select_bt(book_bt) : book_bt;
				System.out.println(a);
				System.out.println(b);
				break;
			}
		}
			
//			System.out.println(select_bt(comments_bt));
			
//		System.out.println(""
//				+ "╔══════╗   ┌──────┐   ┏━━━━━━┓\n"
//				+ "║예매하기║   │예매하기│   ┃예매하기┃\n"
//				+ "╚══════╝   └──────┘   ┗━━━━━━┛\n"
//				+ "");
//		System.out.println(""
//				+ "┏━━━━━━┓   ╔══════╗   ┌──────┐\n"
//				+ "┃예매하기┃   ║예매하기║   │예매하기│\n"
//				+ "┗━━━━━━┛   ╚══════╝   └──────┘\n"
//				+ "");
//		int j = s.nextInt();
//
//		System.out.println(""
//				+ "╔══════╗   ┌──────┐   ┏━━━━━━┓\n"
//				+ "║예매하기║   │예매하기│   ┃예매하기┃\n"
//				+ "╚══════╝   └──────┘   ┗━━━━━━┛\n"
//				+ "");
//		}
	}
	static void book_bt(){
		System.out.println("┌──────┐\n"
				+ "│예매하기│\n"
				+ "└──────┘\n");
	}
	
	static void comments_bt(){
		String comments_bt = "┌──────┐\n│ 영화평 │\n└──────┘\n";
	}
	
	static String select_bt(String a){
		a = a.replace("┌","┏");
		a = a.replace("└","┗");
		a = a.replace("┐","┓");
		a = a.replace("┘","┛");
		a = a.replace("│","┃");
		a = a.replace("─","━");
		return a;
	}
	

}
//
//
//
//╔═══════════╗
//║			  ║
//╚═══════════╝
//┌──┐
//│  │
//└──┘
//┏━━┓
//┃  ┃
//┗━━┛
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
