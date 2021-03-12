package g_oop2;

import java.util.Scanner;

public class AccessModifier {

	// public : 접근 제어자
	public String publicVar = "public :접근제한이 없음";
	protected String protectedVar = "protected : 같은 패키지 + 상속받은 클래스에서 접근 가능";
	String defaultVar = "default : 같은 패키지에서만 접근 가능";
	// 디폴트는 접근 제어자가 생략되었을 때의 접근 제어자. 생략해야만 디폴트
	private String privateVar = "private : 클래스내에서만 접근 가능";

	public void publicMethod() {
		System.out.println(publicVar);
	}

	void defaultMethod() {
		System.out.println(defaultVar);
	}

	protected void protectedMethod() {
		System.out.println(protectedVar);
	}

	private void privateMethod() {
		System.out.println(privateVar);
	}

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();

		System.out.println(am.publicVar);
		am.publicMethod();
		System.out.println(am.protectedVar);
		am.protectedMethod();
		System.out.println(am.defaultVar);
		am.defaultMethod();
		System.out.println(am.privateVar);
		am.privateMethod();

		Time t = new Time();

		// t.hour = 9;
		// t.minute = 380;
		// t.second = -30;
		Scanner s = new Scanner(System.in);

		System.out.println("시간 입력");
		int num = Integer.parseInt(s.nextLine());
		t.setHour(num);
		System.out.println("분 입력");
		num = Integer.parseInt(s.nextLine());
		t.setMinute(num);
		System.out.println("초 입력");
		num = Integer.parseInt(s.nextLine());
		t.setSecond(num);

		System.out.println(t.getTime());

		t.clock();

	}
}
