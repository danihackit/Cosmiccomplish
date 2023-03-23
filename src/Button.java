import javax.swing.ImageIcon;

public class Button {

	private ImageIcon img;
	private int x,y, w, h;


	public Button()
	{
		x=200;
		y=300;
		w=20;
		h=70;
		img = new ImageIcon("Play Button.png");
	}
	public Button(int xval, int yval, int wval, int hval, ImageIcon i) {
		x = xval;
		y = yval;
		w = wval;
		h = hval;

		img = i;
		
	}

	
//GETTERS//
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getW()
	{
		return w;
	}
	
	public int getH()
	{
		return h;
	}


	public ImageIcon getImg() {
		return img;
	}
	
	public boolean hover(int mouseX, int mouseY) {
		if(((getY() <= mouseY&& mouseY <=  getY() +  getH()) && ( getX() <= mouseX&& mouseX <=  getX() +  getW()))){
			return true;
		}
		return false;
	}
	

//SETTERS//

	
	public void setImg(ImageIcon i) {
		img = i;
	}


}


