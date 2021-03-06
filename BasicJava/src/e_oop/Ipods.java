package e_oop;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Ipods {

	int volume = 0;
	boolean power = false;
	boolean playing = false;
	ArrayList<String> playlist = new ArrayList<>();
	static int i = 0;

	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;

	void power() {
		power = !power;
		System.out.println(power ? "          ๐ ๐๐ผ๐โ๐๐๐ผ ๐"
				: "       SฬถTฬถAฬถNฬถDฬถ ฬถBฬถY");
	}

	void playing() {
		if (power) {
			playing = !playing;
			System.out.println(playing ? "โถ playing : " + playlist.get(i)
					: "โธ๏ธ pause " + playlist.get(i));
		}
	}

	void status() {
		if (power) {

			if (playlist.size() > 0) {
				System.out.println("๐๐ค๐ฌ ๐ฅ๐ก๐๐ฎ๐๐ฃ๐ ฤฑlฤฑ.lฤฑllฤฑlฤฑ.ฤฑllฤฑ. "
						+ playlist.get(i));
			} else if (playlist.size() == 0) {
				System.out.println("Please add songs to your IPods");
			}
		}
	}

	void volumeUp() {
		if (power) {
			if (volume < MAX_VOLUME) {
				volume++;
			}
			Volume();
		}
	}

	void volumeDown() {
		if (power) {
			if (MIN_VOLUME < volume) {
				volume--;
			}
			Volume();
		}
	}

	void Volume() {
		System.out.print(" ๐๐ค๐ก๐ช๐ข๐\t");
		for (int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++) {
			if (i <= volume) {
				System.out.print("โฎ");
			} else {
				System.out.print("โฏ");
			}
		}
		System.out.println();
	}

	void add_playlist(String a) {
		if (power) {
			playlist.add(playlist.size() - i, a);
			System.out.println("\"" + a + "\" ๊ฐ ์ฌ์๋ชฉ๋ก์ ์ถ๊ฐ๋์์ต๋๋ค.");
		}
	}

	void remove_playlist() {
		if (power) {
			if (playlist.size() > 0) {
				System.out.println("\"" + playlist.get(i)
						+ "\" ๊ฐ ์ฌ์๋ชฉ๋ก์์ ์ญ์ ๋์์ต๋๋ค.");
				playlist.remove(i + 1);
			} else {
				System.out.println("์ฌ์๋ชฉ๋ก์ด ์กด์ฌํ์ง ์์ต๋๋ค.");
			}

		}
	}

	void playlist() {
		if (power) {
			System.out.println("\t๐๐ก๐จ๐ฅ๐ ๐๐ฅ๐๐ฒ๐ฅ๐ข๐ฌ๐ญ");
			if (playlist.size() > 0) {
				System.out.println("๐ฒ๐จ๐ฎ๐ซ ๐๐ฅ๐๐ฒ๐ฅ๐ข๐ฌ๐ญ : "
						+ playlist.toString());
			} else {
				System.out.println("ํ๋ ์ด๋ฆฌ์คํธ๊ฐ ๋น์ด์์ต๋๋ค. ๊ณก์ ์ถ๊ฐํด์ฃผ์ธ์.");
			}

		}
	}

	void skips_song() {
		if (power) {
			i++;
			if (i > playlist.size() - 1) {
				i = i - playlist.size();
			}
			System.out.println("โฉ skip to : " + playlist.get(i));
		}
	}

	void previous_song() {
		if (power) {
			i--;
			if (i < 0) {
				i = playlist.size() + i;
			}
			System.out.println("โช previous : " + playlist.get(i));
		}
	}

	static int arrow;

	public class Kevent extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			arrow = e.getKeyCode();
		}
	}

	public static void main(String[] args) {
		Ipods ip = new Ipods();
		System.out.println("     ๐  ๐ฉ๐๐ ๐๐๐ฉ๐ง๐ค ๐๐๐ค๐  ๐");
		while (true) {
			System.out.println("7. ๐ฑ\t8. ๐\t9. ๐ด\t+");
			System.out.println("4. โช\t5. โฏ๏ธ\t6. โฉ ");
			System.out.println("1. ๐ถ\t2. ๐\t0. exit\t-");

			String button = ScanUtil.nextLine();

			switch (button) {

			case "1":
				ip.playlist();
				break;
			case "2":
				ip.volumeDown();
				break;
			case "4":
				ip.previous_song();
				break;
			case "5":
				ip.playing();
				break;
			case "6":
				ip.skips_song();
				break;
			case "7":
				ip.status();
				break;
			case "8":
				ip.volumeUp();
				break;
			case "9":
				ip.power();
				break;
			case "+":
				System.out.println("์ถ๊ฐํ  ๊ณก์ ์๋ ฅํด์ฃผ์ธ์.");
				String song = ScanUtil.nextLine();
				ip.add_playlist(song);
				break;
			case "-":
				System.out.println("ํ์ฌ ๊ณก์ ์ญ์ ํฉ๋๋ค.");
				ip.remove_playlist();
				break;
			case "0":
				System.out.println("             ๐ ๐๐ผ๐ผ ๐๐๐ ๐");
				System.exit(0);
			}
		}
	}
}
