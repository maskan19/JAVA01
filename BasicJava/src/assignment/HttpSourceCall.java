package assignment;
	 
	import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
	public class HttpSourceCall {
	    public static void main( String[] args )
	    {
	    	Image image = null;
	        try {
	        	System.out.println("그림 로딩 3초");
	        	Thread.sleep(3000);
	            URL url = new URL("https://i.pinimg.com/originals/b5/cc/dd/b5ccdd48e507a5d572c606c66f70d5e6.png");
	            image = ImageIO.read(url);
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        JFrame frame = new JFrame();
	        frame.setSize(300, 300);
	        JLabel label = new JLabel(new ImageIcon(image));
	        frame.add(label);
	        frame.setVisible(true);
	    }
	}
