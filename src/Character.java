import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Character {
	private int x,y,w,h;
	private int xm,ym;
	private ImageIcon characterImage;
	
	public Character() {
		x = 0;
		y = 0;
		w = 0;
		h = 0;
		xm = 0;
		ym = 0;
		characterImage = new ImageIcon("");
	}
	
	//Player Ship Constructor
	public Character (int xv, int yv, int wv, int hv, ImageIcon i) {
		x = xv;
		y = yv;
		characterImage = i;
		xm = 0;
		ym = 0;
		w= wv;
		h = hv;
	}
	
	//Alien Ship Constructor
	public Character (int xv, int yv, int width, int height, ImageIcon i, int xmv, int ymv) {
		x = xv;
		y = yv;
		w= width;
		h = height;
		characterImage = i;
		xm = xmv;
		ym = ymv;
	}
	
	//Getters and Setters
	
	//Getters
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public int getXm() {
		return xm;
	}
	public int getYm() {
		return ym;
	}
	public ImageIcon getImg() {
		return characterImage;
	}
	
	//Setters
	public void setX(int xv) {
		x = xv;
	}
	public void setY(int yv) {
		y = yv;
	}
	public void setW(int wv) {
		w = wv;
	}
	public void setH(int hv) {
		h = hv;
	}
	public void setXm(int xmv) {
		xm = xmv;
	}
	public void increaseXm(int xmv) {
		if(xm<0) {
			xm -= xmv;
		} else {
			xm += xmv;
		}
	}
	public void setYm(int ymv) {
		ym = ymv;
	}
	public void setImg(ImageIcon newimage) {
		characterImage = newimage;
	}
	public void move(int xmv, int ymv) {
		y += ymv;
		x += xmv;
	}
	public boolean collision(Character s) {
		Rectangle sp = new Rectangle(s.getX(), s.getY(), s.getW(), s.getH());
		Rectangle p = new Rectangle(getX(), getY(), getW(), getH());
		
		if(p.intersects(sp)) {
			return true;
		}
		return false;
	}
}
