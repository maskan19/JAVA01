package f_game.jisoojeong;

public class TestRun {

	Runnable r = new Open();
	Thread t = new Thread(r);

	public static void main(String[] args) {
		System.out.println(" - stage start - ");

		TestRun testRun = new TestRun();
		testRun.dayRun();
		System.out.println("test close");
	}

	public void dayRun() {
		System.out.println("dayRunstart");
		final Thread currentThread = Thread.currentThread();

		Thread killerThread = new Thread() {
			public void run() {
				try {
					t.start();
					Thread.sleep(6000);
					System.out.println("dayrun종료 준비");
					t.interrupt();
					System.out.println("dayrun 종료");
					currentThread.interrupt();
					return;
				} catch (Exception e) {
				}
			}
		};
		try {
			killerThread.start();
		} catch (Exception e) {

		} finally {
			try {
			} catch (Exception e) {
			}
		}
	}
}
