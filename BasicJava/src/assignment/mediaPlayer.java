package assignment;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
//url을 브라우저로 실행
public class mediaPlayer {
	public static void main(String[] args) {
		try {
			Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=cba5uDLgED8"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
