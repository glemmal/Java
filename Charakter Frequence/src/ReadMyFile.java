import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class ReadMyFile {

	private HashMap<Character, Integer> frequencyTable;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java ReadMyFile <path/to/input.txt>");
			System.exit(1);
		}
		new ReadMyFile(args[0]);
	}


	public ReadMyFile(String inputFile) {
		frequencyTable = new HashMap<Character, Integer>();

		try {
			fileHandling(new FileReader(inputFile));
		} catch (IOException e) {
			System.out.println(e);
		}

		printConsoleResult();
		printToFile("frequency.txt");

	}

	public void fileHandling(FileReader fileInput) throws IOException {
		int data;
		while((data = fileInput.read()) != -1) {
			updateCountArray(data);
		}
	}

	public void updateCountArray(int data) {
		char singleCharacter = normalizeToLowerCase((char)data);
		if(data == 10) {
			singleCharacter = '0';
		} else if (data == 32) {
			singleCharacter = '1';
		}
		if(frequencyTable.get(singleCharacter) != null) {
			frequencyTable.put(singleCharacter, frequencyTable.get(singleCharacter)+1);
		} else {
			frequencyTable.put(singleCharacter, 1);
		}
	}

	public String createHistogram() {
		String output = "";
		for(Entry<Character, Integer> entry : frequencyTable.entrySet()) {
			String stars = "";
			for(int i = 0; i<=entry.getValue(); i++) {
				stars += "*";
			}
			String outputKey = "";
			if(entry.getKey() == '0') {
				outputKey = "Zeilenumbruch";
			} else if(entry.getKey() == '1') {
				outputKey = "Leerzeichen";
			} else {
				outputKey = Character.toString(entry.getKey());
			}
			output += outputKey + " : " + stars + "\n";
		}
		return output;
	}

	public void printConsoleResult() {
		System.out.println(createHistogram());
	}

	public void printToFile(String file) {
		PrintWriter out;
		try {
			out = new PrintWriter(file);
			out.println(createHistogram());
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
        return alphabet;
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
