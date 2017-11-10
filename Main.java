import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	
	String fileToLoad;
	String [] dataFromFile = new String[3];
		
	public static void main(String[] args) {
		
		new Main();

	}
	
	public Main() {
		
		greeting();
		
	}
	
	public void greeting() {
		System.out.println("Welcome to the File Manager");
		displayMenu();
		
	}
	
	public void displayMenu() {
		System.out.println("1) To open a file");
		System.out.println("2) To modify a file");
		
		String optionSelected = readingFromUser();
		
		if (optionSelected.equals("1")) {
			loadFile();
			printingOnScreen();
		}
		else if (optionSelected.equals("2")) {
			loadFile();
			System.out.println("What line do you want to change?");
			int lineToChange = Integer.parseInt(readingFromUser());
			System.out.println("What do you want in that line?");
			dataFromFile[lineToChange] = readingFromUser();
			writeInFile();
			printingOnScreen();
			
		}
		else {
			displayMenu();
		}
		
	}
	
	public String readingFromUser() {
		
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String answer = "";
		try {
			answer = br.readLine();
			
		} catch (Exception e) {
			
		}
		return answer;
		
	}
	
	public void loadFile() {
		
		System.out.println("What file do  you want to load?");
		
		fileToLoad = readingFromUser();
		
		try {
			BufferedReader br = new BufferedReader (new FileReader("C:\\users\\apont\\Desktop\\" + fileToLoad + ".txt"));
			
			for (int i = 0; i < dataFromFile.length ; i++) {
				
				dataFromFile[i] = br.readLine();
				
			}

			br.close();
			
		} catch (Exception e) {
			System.out.println("I can't find that file");
		}
		
	}
	
	public void printingOnScreen() {
		
		for (int i = 0; i < dataFromFile.length ; i++) {
			
			System.out.println(dataFromFile[i]);
			
		}
		
	}
	
	public void writeInFile() {
		
		try {
			PrintWriter writer = new PrintWriter("C:\\Users\\apont\\Desktop\\" + fileToLoad + ".txt");
			
			for (int i = 0; i < dataFromFile.length ; i++) {
				
				writer.println(dataFromFile[i]);
				
			}
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
