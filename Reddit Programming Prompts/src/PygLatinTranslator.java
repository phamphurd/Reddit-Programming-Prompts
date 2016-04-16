/*
 * Problem Description:
 * For those of you who dont know, pyglatin is a fictional language, 
 * where the first letter of a word is moved to the end, and the suffix "ay" is added on...
 * For example, "program" would be "Rogrampay" "Human" would be "Umanhay" "Television" would be "Elevisiontay"
 * Im sure you get it :)
 * 
 * Link: https://www.reddit.com/r/ProgrammingPrompts/comments/31gl36/easy_create_a_pyglatin_translator/
 */

import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PygLatinTranslator {

	public static List<String> VOWELS = Arrays.asList("a","e","i","o","u");
	
	public static void main(String[] args) throws IOException{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		//do the given code while the code follows the regex or the user enters quit
		do{
			System.out.println("Convert to Pyg Latin or Translate Pyg Latin");
			System.out.println("Type numbers, quit or itquay to quit ");
			System.out.println("What do you want to translate to Pyg Latin (no commas)? ");
			input = read.readLine();
			translatePygLatin(input);
		}while (input.matches("^([a-z]||[A-Z])+$") && !input.equalsIgnoreCase("quit") && !input.equalsIgnoreCase("itquay"));
	}
	
	
	public static void translatePygLatin(String englishString) throws IOException{
		String input = englishString;
		String[] words;
		char[] word;
		String output = "";
		
		//Convert input to list
		words = input.split(" ");
		
		//Iterate through words
		for(int x = 0; x<words.length; x++){
			word = words[x].toCharArray();
			//Iterate through word
			for(int y = 0; y<word.length; y++){
				//Add way to the end
				if(VOWELS.contains(Character.toString(word[y])) && y == 0){
					//Check for vowel starting
					output = output + words[x] + "way ";
					break;
				}else if(Character.toString(word[y]).equalsIgnoreCase("y") && y == 0){
					//Check for "y" starting
					output = output + words[x].substring(y+1, word.length) + "yay ";
					break;
				}else if(Character.toString(word[y]).equalsIgnoreCase("u") && Character.toString(word[y-1]).equalsIgnoreCase("q")){
					//Check for "qu" scenario
					output = output + words[x].substring(y+1, word.length) + "quay ";
					break;
				}else if(VOWELS.contains(Character.toString(word[y])) && y != 0){
					//Check for other scenarios
					output = output + words[x].substring(y, word.length) + words[x].substring(0, y) + "ay ";
					break;
				}else if(Character.toString(word[y]).equalsIgnoreCase("y") && y != 0){
					//Check for y later in the word scenarios
					output = output + words[x].substring(y, word.length) + words[x].substring(0, y) + "ay ";
				}
			}
		}
		//Output the final string
		System.out.println(output);
		
	}	
}


