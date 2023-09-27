import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * COMP 2503 Fall 2023 Assignment 1
 * 
 * This program reads a input stream and keeps track of the statistics for avengers
 * mentioned by name, alias, or performer's last name.
 *
 * @author Maryam Elahi
 * @date Fall 2023
 */

public class A1 implements Comparator<Avenger >{
	
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
	
	/**
	 * read the input stream and keep track  
	 * how many times avengers are mentioned by alias or last name or performer's last name.
	 */
	private void readInput() {
		String textInput = input.next();
		textInput = textInput.trim().toLowerCase().replaceAll("'"," ").replaceAll("[^a-zA-Z\\d]","");
		
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase().replaceAll("'", "").replaceAll("[^a-zA-Z\\d]", "");
			
			if (word.length() > 0) {
				totalwordcount++;
			} for (int r = 0; r < avengerRoster.length; r++) {
				for (int c = 0; c < avengerRoster[r].length; c++) {
					if (r == 0) {
						
					}
				
				}
			
			}
	
		}
	}
	
	/*
	 * Create helper functions as needed
	 */


	/**
	 * print the results
	 */
	private void printResults() {
		System.out.println("Total number of words:" + totalwordcount);
		System.out.println("Number of Avengers Mentioned:" + avengersArrayList.size());
		System.out.println();
		System.out.println("All avengers in the order they appeared in the input steam:");
		System.out.println();
		System.out.println("Top " + topN + "most popular avengers:");
		System.out.println();
		System.out.println("Top " + topN + "most popular performers:");
		System.out.println();
		System.out.println("All mentioned avengers in alphabetical order:");
		System.out.println();
		
	}

	
	

	@Override
	public int compare(Avenger a1, Avenger a2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
} //closing bracket



			
			
			
		
	



