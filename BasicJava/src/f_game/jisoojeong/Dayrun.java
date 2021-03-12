package f_game.jisoojeong;

public class Dayrun extends Thread {
	Hairshop hairshop;

	Dayrun(Hairshop h) {
		hairshop = h;
	}

	public void run() {
		Open op = new Open(hairshop);
		Thread opthread = new Thread(op);
		opthread.start();
		try {
			Thread.sleep(60000 + 1000 * hairshop.level);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}

		finally {
			System.out.println("\t\t   - 60초 경과 -");
			opthread.interrupt(); // 정상작동
		}
		System.out.println("시간초과로 데이런파이널 종료");

	}
}