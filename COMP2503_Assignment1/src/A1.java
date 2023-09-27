import java.util.ArrayList;
import java.util.Scanner;

public class A1 {
	
	public String[][] avengerRoster = {
			{ "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan"} };
			
	Scanner input = new Scanner(System.in);
	private int topN = 4;
	private int totalwordcount = 0;
	private ArrayList<Avenger> avengersArrayList = new ArrayList<>();


	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.run();
	}
	
	
	public void run() {
		readInput();
		printResults();
	}
		
		
	private void readInput() {
		String textInput = input.next();
		textInput = textInput.trim().toLowerCase().replaceAll("'"," ").replaceAll("[^a-zA-Z\\d]","");
		
	}

	private void printResults() {
		System.out.println("Total number of words:" + totalwordcount);
		System.out.println("Number of Avengers Mentioned:" + avengersArrayList.size());
		System.out.println();
		
		
	}




		{
			
			
			
		
	

}
}
