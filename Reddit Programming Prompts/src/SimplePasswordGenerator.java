/*
 * Problem Description:
 * Make a password generator that generates a random password of desired length specified by user input.
 * For example:
 * Enter desired password length>> 7
 * hY@rSdA
 * https://www.reddit.com/r/ProgrammingPrompts/comments/4cegdt/easy_make_a_simple_password_generator/
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SimplePasswordGenerator {

	//Constants
	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~!@#$%^&*()_-0123456789";
	public static final int ALPHABET_SIZE = ALPHABET.length();
	public static final int MAX = ALPHABET_SIZE;
	public static final int MIN = 0;
	
	public static void main(String[] args) throws IOException {
		//Variables
		Random randomNumber = new Random();
		int passwordSize = 0;
		String stringholder = "";
		String password = "";
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		/*
		 * Read
		 */
		//Get the password size
		while(true){
			System.out.println("What size do you want the password to be? ");
			stringholder = reader.readLine();
			if(stringholder.matches("^-?\\d+$")){
				passwordSize = Integer.parseInt(stringholder);
				break;
			}else{
				System.out.println("Not an integer.");
			}
		}
		
		/*
		 * Think
		 */
		//Generate password using randomly generated numbers
		for(int i = 0; i < passwordSize; i ++){
			password = password + ALPHABET.charAt(randomNumber.nextInt(MAX - MIN) + MIN + 1);
		}
		
		/*
		 * Do
		 */
		//Display password
		System.out.println("Your password is: " + password);
	}

}
