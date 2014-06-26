
public class PreLab {

	public static void main(String[] args) {
		char test = normalizeToUpperCase('b');
		System.out.println(test);
		System.out.println("Dies ist ein Test \r und hier kommt die nächste Zeile \r\n und noch eine Zeile \n Noch ein Test");
	}
	
	public static char[] createAlphaArray(String type) {
		char[] alphabet = new char[26]; // new array
		int i = 0;
		if(type.equals("lowerCase")) {
			for(char ch = 'a'; ch <= 'z'; ++ch) {
	            alphabet[i]=ch;
	            i++;
	        }
		} else if(type.equals("upperCase")) {
			for(char ch = 'A'; ch <= 'Z'; ++ch) {
	            alphabet[i]=ch;
	            i++;
	        }
		}
		System.out.println(alphabet);
        return alphabet; 
	}
	
	public static char normalizeToUpperCase(char inputChar) {
		char[] lowerCase = createAlphaArray("lowerCase");
		char [] upperCase = createAlphaArray("upperCase");
		char outputChar = inputChar;
		int i = 0;
		for(char value : lowerCase) {
			if(inputChar == value) {
				outputChar = upperCase[i];
			}
			i++;
		}
		return outputChar;
	}
	
	public static char normalizeToLowerCase(char inputChar) {
		char[] lowerCase = createAlphaArray("lowerCase");
		char [] upperCase = createAlphaArray("upperCase");
		char outputChar = inputChar;
		int i = 0;
		for(char value : upperCase) {
			if(inputChar == value) {
				outputChar = lowerCase[i];
			}
			i++;
		}
		return outputChar;
	}
	
}
