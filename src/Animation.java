import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Animation {
	private int lengthMillis;
	private ImageIcon affiliate;
	
	public Animation() {
		lengthMillis = 0;
		affiliate = new ImageIcon("");
	}
	
	//Player Ship Constructor
	public Animation (int length, ImageIcon gif) {
		lengthMillis = length;
        affiliate = gif;
	}
	
	
	//Getters and Setters
	
	//Getters
	public int getLength() {
		return lengthMillis;
    }

	public ImageIcon getGif() {
		return affiliate;
	}

	//Setters
	public void setLength(int length) {
		lengthMillis = length;
	}
	public void setGif(ImageIcon gif) {
		affiliate = gif;
	}
	
	
}
