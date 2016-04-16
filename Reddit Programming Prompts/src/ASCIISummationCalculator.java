/*
 * Problem Description:
 * Write a program that takes in a string from the user (or if you want, a file!)
 * and prints all the characters' ascii values summed up to the user. 
 * For Example: The above paragraph's ascii sum is 13,124
 * https://www.reddit.com/r/ProgrammingPrompts/comments/457nkn/easy_make_an_ascii_summation_calculator/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class ASCIISummationCalculator {

	public static void main(String[] args) throws IOException {
		//Variables
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		String inputString = "";
		char[] characters;
		int charint = 0;
		int total = 0;
		
		
		/*
		 * Read
		 */
		//Get string from user
		System.out.println("Enter the string you wish to convert: ");
		inputString = reader.readLine();
		
		/*
		 * Think
		 */
		//Convert string to character array
		characters = inputString.toCharArray();
		
		//Loop through char array and get summation
		for(int i = 0; i < characters.length; i++){
			charint = (int)characters[i];
			total = total + charint;
			System.out.println(characters[i] + ": " + charint);
		}
		
		/*
		 * Do
		 */
		//Display total
		System.out.println("The total summation of the ASCII code for each character in your string is: ");
		System.out.println(total);
	}

}
