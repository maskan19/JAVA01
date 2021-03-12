package g_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;

	String getTime() {
		return hour + ":" + minute + ":" + second;
	}

	void clock() {
		while (true) {
			System.out.println(getTime());
			stop(1000);
			setSecond(second + 1);
		}
	}

	void stop(int interval) {
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {

		if (hour < 0) {
			this.hour = 0;
		} else if (23 < hour) {
			this.hour = 0;
		} else {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0) {
			this.minute = 0;
		} else if (59 < minute) {
			this.minute = 0;
			setHour(hour + 1);
		} else {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {

		if (second < 0) {
			this.second = 0;
		} else if (59 < second) {
			this.second = 0;
			setMinute(minute + 1);
		} else {
			this.second = second;
		}
	}

}