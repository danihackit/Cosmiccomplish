//import java.awt.Rectangle;
//import java.lang.*;
import javax.swing.ImageIcon;

public class Letter {
	private char affiliatedCharacter;
	private ImageIcon affiliatedImage;
	private char dimension;

	public Letter() {

	}

	public Letter(char affiliatedCharacterInput) {
		affiliatedCharacter = affiliatedCharacterInput;
		generateAffiliatedImage(Character.toUpperCase(affiliatedCharacterInput));
		generateAffiliatedDimension(Character.toUpperCase(affiliatedCharacterInput));
	}



	public char getAffiliatedCharacter() {
		return affiliatedCharacter;
	}

	public void setAffiliatedCharacter(char affiliatedCharacter) {
		this.affiliatedCharacter = affiliatedCharacter;
	}

	public ImageIcon getAffiliatedImage() {
		return generateAffiliatedImage(Character.toUpperCase(affiliatedCharacter));
	}

	public void setAffiliatedImage(ImageIcon affiliatedImage) {
		this.affiliatedImage = affiliatedImage;
	}

	public char getDimension() {
		return generateAffiliatedDimension(affiliatedCharacter);
	}

	public void setDimension(char dimension) {
		this.dimension = dimension;
	}

	public ImageIcon generateAffiliatedImage(char ACI) {
		ImageIcon returnValue = new ImageIcon("null");

		if(ACI=='A') {
			returnValue = new ImageIcon("A.png");
		} else if(ACI == 'B') {
			returnValue = new ImageIcon("B.png");
		} else if(ACI == 'C') {
			returnValue = new ImageIcon("C.png");
		} else if(ACI == 'D') {
			returnValue = new ImageIcon("D.png");
		} else if(ACI == 'E') {
			returnValue = new ImageIcon("E.png");
		} else if(ACI == 'F') {
			returnValue = new ImageIcon("F.png");
		} else if(ACI == 'G') {
			returnValue = new ImageIcon("G.png");
		} else if(ACI == 'H') {
			returnValue = new ImageIcon("H.png");
		} else if(ACI == 'I') {
			returnValue = new ImageIcon("I.png");
		} else if(ACI == 'J') {
			returnValue = new ImageIcon("J.png");
		} else if(ACI == 'K') {
			returnValue = new ImageIcon("K.png");
		} else if(ACI == 'L') {
			returnValue = new ImageIcon("L.png");
		} else if(ACI == 'M') {
			returnValue = new ImageIcon("M.png");
		} else if(ACI == 'N') {
			returnValue = new ImageIcon("N.png");
		} else if(ACI == 'O') {
			returnValue = new ImageIcon("O.png");
		} else if(ACI == 'P') {
			returnValue = new ImageIcon("P.png");
		} else if(ACI == 'Q') {
			returnValue = new ImageIcon("Q.png");
		} else if(ACI == 'R') {
			returnValue = new ImageIcon("R.png");
		} else if(ACI == 'S') {
			returnValue = new ImageIcon("S.png");
		} else if(ACI == 'T') {
			returnValue = new ImageIcon("T.png");
		} else if(ACI == 'U') {
			returnValue = new ImageIcon("U.png");
		} else if(ACI == 'V') {
			returnValue = new ImageIcon("V.png");
		} else if(ACI == 'W') {
			returnValue = new ImageIcon("W.png");
		} else if(ACI == 'X') {
			returnValue = new ImageIcon("X.png");
		} else if(ACI == 'Y') {
			returnValue = new ImageIcon("Y.png");
		} else if(ACI == 'Z') {
			returnValue = new ImageIcon("Z.png");
		}  else if(ACI == '/') {
			returnValue = new ImageIcon("slash.png");
		} else if(ACI == ' ') {
			returnValue = new ImageIcon("null.png");
		} else if(ACI == '.') {
			returnValue = new ImageIcon("..png");
		} else if(ACI == ',') {
			returnValue = new ImageIcon(",.png");
		} else if(ACI == '?') {
			returnValue = new ImageIcon("question mark.png");
		} else if(ACI == '!') {
			returnValue = new ImageIcon("!.png");
		} else if(ACI == '-') {
			returnValue = new ImageIcon("-.png");
		} else if(ACI == '+') {
			returnValue = new ImageIcon("+.png");
		} else if(ACI == '(') {
			returnValue = new ImageIcon("(.png");
		} else if(ACI == ')') {
			returnValue = new ImageIcon(").png");
		} else if(ACI == '1') {
			returnValue = new ImageIcon("1.png");
		} else if(ACI == '2') {
			returnValue = new ImageIcon("2.png");
		} else if(ACI == '3') {
			returnValue = new ImageIcon("3.png");
		} else if(ACI == '4') {
			returnValue = new ImageIcon("4.png");
		} else if(ACI == '5') {
			returnValue = new ImageIcon("5.png");
		} else if(ACI == '6') {
			returnValue = new ImageIcon("6.png");
		} else if(ACI == '7') {
			returnValue = new ImageIcon("7.png");
		} else if(ACI == '8') {
			returnValue = new ImageIcon("8.png");
		} else if(ACI == '9') {
			returnValue = new ImageIcon("9.png");
		} else if(ACI == '0') {
			returnValue = new ImageIcon("0.png");
		} else if(ACI == '|') {
			returnValue = new ImageIcon("line.png");
		} else if(ACI == '@') {
			returnValue = new ImageIcon("@.png");
		} else if(ACI == '[') {
			returnValue = new ImageIcon("[.png");
		} else if(ACI == ']') {
			returnValue = new ImageIcon("].png");
		} else if(ACI == '{') {
			returnValue = new ImageIcon("{.png");
		} else if(ACI == '}') {
			returnValue = new ImageIcon("}.png");
		} else if(ACI == '<') {
			returnValue = new ImageIcon("less than.png");
		} else if(ACI == '>') {
			returnValue = new ImageIcon("greater than.png");
		} else if(ACI == '%') {
			returnValue = new ImageIcon("%.png");
		} else if(ACI == '^') {
			returnValue = new ImageIcon("^.png");
		} else if(ACI == '"') {
			returnValue = new ImageIcon("quotes.png");
		} else if(Character.toString(ACI).equals("'")) {
			returnValue = new ImageIcon("'.png");
		} else if(ACI == '\n'){
            returnValue = new ImageIcon("null.png");
        } else if(ACI == '_'){
            returnValue = new ImageIcon("_.png");
        } else if(ACI == '$'){
            returnValue = new ImageIcon("$.png");
        } else if(ACI == '#'){
            returnValue = new ImageIcon("#.png");
        } else if(ACI == '*'){
            returnValue = new ImageIcon("asterisk.png");
        } else if(ACI == ';'){
            returnValue = new ImageIcon("semicolon.png");
        } else if(ACI == ':'){
            returnValue = new ImageIcon("colon.png");
        }



		else {
			returnValue = new ImageIcon("slash.png");
		}

		return returnValue;
	}

	public char generateAffiliatedDimension(char AD) {
		AD = Character.toUpperCase(affiliatedCharacter);
		char returnValue = ' ';

		if(AD == 'I' || AD == '1' || AD == '.' || AD == ',' || AD == ';' || AD == ':' || AD == '!' || AD == ' ' || AD == '<' || AD == '>') {
			returnValue = 'S';
		} else if(AD == 'M' || AD == 'W' || AD == 'T' || AD == 'V' || AD == 'Y' || AD == '@' || AD == '_' || AD == '$' || AD == '#'){
			returnValue = 'L';
		} else {
			returnValue = 'M';
		}

		return returnValue;
	}
}