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
 * @author Alyssa Landeta, Jann Ubana, Starlyn Rivas-Perez
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
	
	
	/**
	 * main method that calls driver class
	 * @param args
	 */
	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.run();
	}
	
	/**
	 * driver method that calls the readInput method and printResults method
	 */
	public void run() {
		readInput();
		printResults(avengersArrayList);
	}
	
	/**
	 * this method reads the input stream, trims and cleans the words, and keeps track  
	 * how many times avengers are mentioned by alias or last name or performer's last name.
	 */
	private void readInput() {
		
		boolean avengerFound = false;// this boolean flag turns true if an avenger alias name, hero name or performer name is found in the avengersArrayList 
		
		//the following while loop checks the input stream for words that match the alias name, hero name and performer name of an avenger
		//if the word is found, a for loop will check the avengersArrayList to determine if an avenger with that alias name, hero name or performer name has already been added to the list
		//if an avenger with those properties has not been added, a new avenger object will be created and added to the list.  
		while (input.hasNext()) {
			String word = input.next();
			word = word.trim().toLowerCase();
			if (word.contains("'")) {
				word = word.substring(0, word.indexOf("'"));
			}
			word = word.replaceAll("[^a-z]", "");
			
			if (!word.isBlank()) {
				totalwordcount++;
				for(String[] avengerData : avengerRoster ){
					
					String alias = avengerData[0];
					String heroName = avengerData[1];
					String performerName = avengerData[2];
					
					if ( word.equals(alias) || word.equals(heroName) || word.equals(performerName) ) {
						
						avengerFound = searchAvengerList(word);
					
						if(!avengerFound) {
							Avenger newAdvenger = new Avenger(alias, heroName, performerName);
							if (word.equals(alias)) {
								newAdvenger.setAliasFreq();
								
							}else if (word.equals(heroName)) {
								newAdvenger.setNameFreq();
								
							}else if (word.equals(performerName)) {
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
	
	/**
	 * this method is called in readInput() method when checking if the input is part of the avengers list
	 * checks the if the input word is an alias, hero name, or performer name and increses the individual frequencies accordingly
	 * @param String word
	 * @return boolean isAvgFound, true if word is found in the avenger list, false if else
	 */
	private boolean searchAvengerList(String word) {

		boolean isAvgFound = false; //boolean[] avengerFlag = {false, false, false};
		for (Avenger avenger : avengersArrayList ) {
			if (avenger.getHeroAlias().equals(word)) {
				isAvgFound = true;
				avenger.setAliasFreq();
				break;
			}else if (avenger.getHeroName().equals(word)) {
				isAvgFound = true;
				avenger.setNameFreq();
				break;
				
			}else if (avenger.getPerformer().equals(word)) {
				isAvgFound = true;
				avenger.setPerformerFreq();
				break;
			}
		}
		return isAvgFound;
	}
	
	/**
	 * this method is called in the printResults() method to print all the avengers in the order they appear in the input stream
	 */
	private void printAvengersList() {
		for (Avenger avg : avengersArrayList) {
			System.out.println(avg.toString());
		}
	}
	
	/**
	 * this method prints the top 4 avengers or performers in the printResults() method 
	 * @param ArrayList<Avenger> avgList list containing mentioned avengers
	 */
	private void printTopFour (ArrayList<Avenger> avgList) {
		
		for (int i = 0; i < avgList.size(); i++) {
			if ( i <= 3) {
				System.out.println(avgList.get(i).toString());
			}else {
				break;
			}
		}
	}
	
	/**
	 * this method prints the resulting output from the input in the format given 
	 * @param avengerArrayLists
	 */
	private void printResults(ArrayList<Avenger> avengerArrayLists) {
		
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + avengersArrayList.size());
		System.out.println();
		System.out.println("All avengers in the order they appeared in the input stream:");
		printAvengersList();
		System.out.println();
		
		
		System.out.println("Top " + topN + " most popular avengers:");
		Collections.sort(avengerArrayLists, new TopAvengers());
		printTopFour(avengerArrayLists);
		System.out.println();
		
		System.out.println("Top " + topN + " most popular performers:");
		Collections.sort(avengerArrayLists, new Performer());
		printTopFour(avengerArrayLists);
		System.out.println();
		
		Collections.sort(avengerArrayLists);
		System.out.println("All mentioned avengers in alphabetical order:");
		printAvengersList();
		System.out.println();	
	}
	
} 