package g_oop2;

public class Store {

	public static void main(String[] args) {

		Desktop d1 = new Desktop("삼성컴퓨터", 100000);
		Desktop d2 = new Desktop("LG컴퓨터", 100000);

		AirCon ac1 = new AirCon("삼성 에어컨", 200000);
		AirCon ac2 = new AirCon("LG 에어컨", 200000);

		TV tv1 = new TV("삼성TV", 300000);
		TV tv2 = new TV("LGTV", 300000);

		Customer c = new Customer();
		System.out.println(d1.getInfo());
		System.out.println(d2.getInfo());
		System.out.println(ac1.getInfo());
		System.out.println(ac2.getInfo());
		System.out.println(tv1.getInfo());
		System.out.println(tv2.getInfo());
		c.buy(/* (Product) */d1);// 형변환
		c.buy(ac2);
		c.buy(tv2);
		c.showItem();

		Product p = new Desktop("컴퓨터", 1000);
		Desktop d = (Desktop) p;
		d.programming();

	}
}

class Product {
	String name; // 이름
	int price; // 가격

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// 상품의 정보를 반환하는 메서드
	String getInfo() {
		return name + "(" + price + "원 )";
	}

}

class Desktop extends Product { // 생성자 때문에 컴파일 에러 발생
	// 컴파일러는 파라미터가 없는 경우에만 자동으로 생성자를 가져옴
	Desktop(String name, int price) {
		super(name, price);
	}

	void programming() {
		System.out.println("프로그램을 만듭니다.");
	}
}

class AirCon extends Product {
	AirCon(String name, int price) {
		super(name, price);
	}

	void temperature() {
		System.out.println("온도를 설정합니다.");
	}

}

class TV extends Product {

	TV(String name, int price) {
		super(name, price);
	}

	void temperature() {
		System.out.println("채널을 변경합니다.");
	}
}

class Customer {
	int money = 10000000;
	Product[] item = new Product[100];

	void buy(Product p) { // 세가지 물건을 모두 받기 위해 사용
		if (money < p.price) {
			System.out.println("잔돈이 부족합니다.");
			return;
		}
		money -= p.price;
		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) {
				item[i] = p;
				break;
			}
		}
		System.out.println(p.getInfo() + "를 구매했다.");
	}

	void showItem() {
		System.out.println("------장바구니-----");
		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) {
				break;
			} else {
				System.out.println(item[i].getInfo());
			}
		}
		System.out.println("---------------");
	}

}
