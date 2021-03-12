package g_oop2;

public class SampleChild extends SampleParent {

	void childMethod() {
		// 상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var);// 상속받은 변수 0
		System.out.println(method(7, 13)); // 상속받은 메서드 91

	}

	// 오버라이딩 부모클래스에서 상속받은 메서드의 내용을 변경하는 것
	// super, super() 부모클래스의 생성자를 호출
	// 다형성 a 객체, b 타입/ 객체와 타입이 다른 것

	// 오버라이딩 : 상속받은 메서드의 내용을 재정의하는 것
	// 똑같은 메서드를 만듦
	@Override
	// 어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것.
	int method(int a, int b) { // 리턴타입 메서드명 파라미터 모두 같아야한다.
		return a * b;
	}

	// super, super()
	int var;  //0

	void test(double var) {
		System.out.println(var);// 지역변수 :(입력값)
		System.out.println(this.var);// 인스턴스변수   :0
		System.out.println(super.var);// 부모클래스의 인스턴스 변수   :생성자도 물려주지 않는다.
		// super : 부모 클래스의 메버와 자식 클래스의 멤버가 이름이 중복될 때
		// 			둘을 구분하기 위해 사용한다.
		System.out.println(this.method(10,20));   //:200
		System.out.println(super.method(10,20));    //:30
	}


	  SampleChild() {
	     //super()는 맨 첫줄에 있어야함 안그러면 컴파일 에러 생김
	     super();      //부모 클래스의 생성자 호출 -> 부모 클래스에 있는 생성자를 초기화 하겠다는 의미 (=> 상속 받은 변수를 초기화 해주기 위해)   
	     //super()를 통해 클래스의 생성자를 호출하고 부모클래스의 인스턴스 변수도 초기화한다.
	     //super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
	 }
	   
	public static void main(String[] args) {
		SampleChild sc = new SampleChild(); // 객체 타입과 변수 타입이 일치
		SampleParent sp = new SampleChild(); // 객체 타입과 변수 타입 불일치
		// SampleChild2
		// sp = new SampleChild2();
		// SampleChild3
		// sp = new SampleChild3();
		// 부모 타입의 변수로 자식 타입의 객체를 사용하는 것이 다형성이다.
		//서로 상속 관계에 있을 때에 사용 가능
		
		sc.childMethod(); // 0, 91
		System.out.println(sc.method(5, 10)); // 50
		sc.test(8);
		
		//부모와 자식간에는 서로 형변환이 가능하다.
		sc = (SampleChild)sp;
		sp = /*(SampleParent)*/sc;
		//자식타입->부모타입 형변환은 생략할 수 있다.
		
//		SampleChild sc2 = (SampleChild) new SampleParent();
		//SampleParent는 2개의 멤버를 가지고 있다.
		//SampleChild는 5개의 멤버를 가직 있다.
		//SampleChild 타입의 변수는 5개의 멤버를 사용할 수 있어야하는데
		//SampleParent 객체는 2개의 멤버만 가지고 있다.
		//그러므로 부모타입의 객체를 자식 타입으로 형변환 하는 것은 에러를 발생시킨다.
		
		
		//SampleParent 타입의 변수는
		//SampleChild 객체를 가지고도 2개의 멤버만 사용할 수 있다.
		sp = sc;  
		System.out.println(sp.var); //:생성자도 물려주지 않는다.
		System.out.println(sp.method(3, 11)); // :33
	}
}
