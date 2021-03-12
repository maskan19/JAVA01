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
		System.out.println(power ? "          🍎 𝕎𝔼𝕃ℂ𝕆𝕄𝔼 🍎"
				: "       S̶T̶A̶N̶D̶ ̶B̶Y");
	}

	void playing() {
		if (power) {
			playing = !playing;
			System.out.println(playing ? "▶ playing : " + playlist.get(i)
					: "⏸️ pause " + playlist.get(i));
		}
	}

	void status() {
		if (power) {

			if (playlist.size() > 0) {
				System.out.println("𝙉𝙤𝙬 𝙥𝙡𝙖𝙮𝙞𝙣𝙜 ılı.lıllılı.ıllı. "
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
		System.out.print(" 𝙑𝙤𝙡𝙪𝙢𝙚\t");
		for (int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++) {
			if (i <= volume) {
				System.out.print("▮");
			} else {
				System.out.print("▯");
			}
		}
		System.out.println();
	}

	void add_playlist(String a) {
		if (power) {
			playlist.add(playlist.size() - i, a);
			System.out.println("\"" + a + "\" 가 재생목록에 추가되었습니다.");
		}
	}

	void remove_playlist() {
		if (power) {
			if (playlist.size() > 0) {
				System.out.println("\"" + playlist.get(i)
						+ "\" 가 재생목록에서 삭제되었습니다.");
				playlist.remove(i + 1);
			} else {
				System.out.println("재생목록이 존재하지 않습니다.");
			}

		}
	}

	void playlist() {
		if (power) {
			System.out.println("\t𝐖𝐡𝐨𝐥𝐞 𝐏𝐥𝐚𝐲𝐥𝐢𝐬𝐭");
			if (playlist.size() > 0) {
				System.out.println("𝐲𝐨𝐮𝐫 𝐏𝐥𝐚𝐲𝐥𝐢𝐬𝐭 : "
						+ playlist.toString());
			} else {
				System.out.println("플레이리스트가 비어있습니다. 곡을 추가해주세요.");
			}

		}
	}

	void skips_song() {
		if (power) {
			i++;
			if (i > playlist.size() - 1) {
				i = i - playlist.size();
			}
			System.out.println("⏩ skip to : " + playlist.get(i));
		}
	}

	void previous_song() {
		if (power) {
			i--;
			if (i < 0) {
				i = playlist.size() + i;
			}
			System.out.println("⏪ previous : " + playlist.get(i));
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
		System.out.println("     🍎  𝙩𝙝𝙚 𝙍𝙚𝙩𝙧𝙤 𝙞𝙋𝙤𝙙  🍎");
		while (true) {
			System.out.println("7. 📱\t8. 🔊\t9. 📴\t+");
			System.out.println("4. ⏪\t5. ⏯️\t6. ⏩ ");
			System.out.println("1. 🎶\t2. 🔈\t0. exit\t-");

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
				System.out.println("추가할 곡을 입력해주세요.");
				String song = ScanUtil.nextLine();
				ip.add_playlist(song);
				break;
			case "-":
				System.out.println("현재 곡을 삭제합니다.");
				ip.remove_playlist();
				break;
			case "0":
				System.out.println("             🍎 𝕊𝔼𝔼 𝕐𝕆𝕌 🍎");
				System.exit(0);
			}
		}
	}
}
