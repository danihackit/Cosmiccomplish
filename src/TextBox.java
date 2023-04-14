import javax.swing.ImageIcon;

public class TextBox {

	private int x,y, w, h;
	private int deletionRestriction;
	private boolean inputStatus, deleteAllowed;
	private String affiliatedText;
	
	public TextBox()
	{
		x=0;
		y=0;
		w=100;
		h=60;
		deletionRestriction = 0;
		inputStatus = false;
	}
	public TextBox(int xval, int yval, int wval, int hval, int deletionRestrictionI, boolean inputStatusI, String defaultInput) {
		x = xval;
		y = yval;
		w = wval;
		h = hval;
		deletionRestriction = deletionRestrictionI;
		inputStatus = inputStatusI;
		affiliatedText = defaultInput;
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

	public boolean getDeleteAllowed(){
		return deleteAllowed;
	}
	
	public int getDeletionRestriction() {
		return deletionRestriction;
	}

	public boolean getInputStatus() {
		return inputStatus;
	}
	
	public String getAffiliatedText() {
		return affiliatedText;
	}
	
	public void setAffiliatedText(String affiliatedTextI) {
		affiliatedText = affiliatedTextI;
	}
	
	public void addToAffiliatedText(String affiliatedTextI) {
		affiliatedText = affiliatedText + affiliatedTextI;
	}
	
	public void setInputStatus(boolean inputStatusI) {
		inputStatus = inputStatusI;
	}

	public void setDeleteAllowed(boolean deleteAllowedI){
		deleteAllowed = deleteAllowedI;
	}
	
	public boolean hover(int mouseX, int mouseY) {
		if((getY() <= mouseY&& mouseY <=  getY() +  getH()) && ( getX() <= mouseX&& mouseX <=  getX() +  getW())){
			return true;
		}
		return false;
	}
	
}


