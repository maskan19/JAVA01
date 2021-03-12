package e_oop;

public class TV {

	int channel = 1;
	int volume = 5;
	boolean power = false;

	// 상수로 최대값, 최소값을 지정
	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;

	void powerOnOff() {
		power = !power;
		System.out.println(power ? "TV 켜짐" : "TV 꺼짐");
	}

	// 채널 변경
	void changeChannel(int channelVar) {
		if (power) {
			if (MIN_CHANNEL <= channel && channel <= MAX_CHANNEL) {
				this.channel = channelVar;
				// 전역변수와 지역변수의 이름이 같을 때 전역 변수에는 this를 붙여 구분
			}
			System.out.println("채널. " + this.channel);
		}
	}

	// 채널 올리는 메서드
	void channelUp() {
		changeChannel(channel + 1);
	}

	// 채널 내리는 메서드
	void channelDown() {
		changeChannel(channel - 1);
	}

	// 볼륨 변경
	void volumeUp() {
		if (power) {
			if (volume < MAX_VOLUME) {
				volume++;
			}
			showVolume();
		}
	}

	void volumeDown() {
		if (power) {
			if (MIN_VOLUME < volume) {
				volume--;
			}
			showVolume();
		}
	}

	void showVolume() {
		System.out.print("음량. ");
		for (int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++) {
			if (i <= volume) {
				System.out.print("■");
			} else {
				System.out.print("□");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TV tv = new TV();

		while (true) {
			System.out.println("-----------------------------------");
			System.out.println("1.전원 2.채널변경 3.채널업 4.채널다운");
			System.out.println("5.볼륨업 6.볼륨다운 0.종료");
			System.out.println("-----------------------------------");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				tv.powerOnOff();
				break;
			case 2:
				System.out.print("변경할 채널 입력>");
				int ch = ScanUtil.nextInt();
				tv.changeChannel(ch);
				break;
			case 3:
				tv.channelUp();
				break;
			case 4:
				tv.channelDown();
				break;
			case 5:
				tv.volumeUp();
				break;
			case 6:
				tv.volumeDown();
				break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
		}
	}
}