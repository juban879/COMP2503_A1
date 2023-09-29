import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
		printResults(avengersArrayList);
	}
	
	/**
	 * read the input stream and keep track  
	 * how many times avengers are mentioned by alias or last name or performer's last name.
	 */
	private void readInput() {
		// this boolean flag turns true if an avenger alias name, hero name or performer name is found in the avengersArrayList 
		boolean avengerFound = false;
		// ignore these unused variables for now
		boolean aliasFound = false;
		boolean heroNameFound = false;
		boolean performerNameFound = false;
		/**
		 * the following while loop checks the input stream for words that match the alias name, hero name and performer name of an avenger
		 * if the word is found, a for loop will check the avengersArrayList to determine if an avenger with that alias name, hero name or performer name has already been added to the list
		 * if an avenger with those properties has not been added, a new avenger object will be created and added to the list.  
		 */
		System.out.println("Enter input");
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase().replaceAll("[^a-zA-Z]", "");
			
			if (!word.isBlank()) {
				totalwordcount++;
				for(String[] avengerData : avengerRoster ){
					if ( word.equals(avengerData[0]) || word.equals(avengerData[1]) || word.equals(avengerData[2]) ) {
						avengerFound = searchAvengerList(word)[0] || searchAvengerList(word)[1] || searchAvengerList(word)[2];
						
							
						if(!avengerFound) {
							Avenger newAdvenger = new Avenger(avengerData[0], avengerData[1], avengerData[2]);
							if (word.equals(avengerData[0])) {
								newAdvenger.setAliasFreq();
								
							}else if (word.equals(avengerData[1])) {
								newAdvenger.setNameFreq();
								
							}else if (word.equals(avengerData[2])) {
								newAdvenger.setPerformerFreq();
								
							}
							avengersArrayList.add(newAdvenger);
							
						}
					}
				}
			}	
		}
		input.close();
	}
	
	/*
	 * Create helper functions as needed
	 */
	private boolean[] searchAvengerList(String word) {
		boolean[] avengerFlag = {false, false, false};
		for (Avenger avenger : avengersArrayList ) {
			if (avenger.getHeroAlias().equals(word)) {
				avengerFlag[0] = true;
				avenger.setAliasFreq();
				
			}else if (avenger.getHeroName().equals(word)) {
				avengerFlag[1] = true;
				avenger.setNameFreq();
				
			}else if (avenger.getPerformer().equals(word)) {
				avengerFlag[2] = true;
				avenger.setPerformerFreq();
				
			}
		}
		return avengerFlag;
	}
	private void printAvengersList() {
		for (Avenger avg : avengersArrayList) {
			System.out.println(avg.toString());
		}
	}
	/**
	 * print the results
	 */
	private void printResults(ArrayList<Avenger> avengerArrayLists) {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + avengersArrayList.size());
		System.out.println();
		System.out.println("All avengers in the order they appeared in the input steam:");
		printAvengersList();
		System.out.println("Top " + topN + "most popular avengers:");
		Collections.sort(avengerArrayLists);
		System.out.println(avengerArrayLists.get(0).toString());
		System.out.println(avengerArrayLists.get(1).toString());
		System.out.println(avengerArrayLists.get(2).toString());
		System.out.println(avengerArrayLists.get(3).toString());
//		System.out.println(avengerArrayLists);
		System.out.println("Top " + topN + "most popular performers:");
		Collections.sort(avengerArrayLists, new Performer());
//		System.out.println(avengerArrayLists);
		System.out.println(avengerArrayLists.get(0).toString());
		System.out.println(avengerArrayLists.get(1).toString());
		System.out.println(avengerArrayLists.get(2).toString());
		System.out.println(avengerArrayLists.get(3).toString());
		System.out.println("All mentioned avengers in alphabetical order:");
		
		System.out.println();
		
		
		
	}
	

	
	
	
} //closing bracket



			
			
			
		
	



