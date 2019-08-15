package com.qa.javaAssessment;

import java.util.Arrays;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		String userinput = input.toLowerCase();
		String bertstart;
		String bertend;
		String endremoved;
		String startremoved;
		String reversed = "";
		int index = 0;
		int removeamount;
		
		if(userinput.contains("bert") && userinput.startsWith("bert") == false && userinput.endsWith("bert") == false) {
			
			index = userinput.indexOf("bert");
			bertstart = userinput.substring(index);
			index = bertstart.indexOf("bert", bertstart.indexOf("bert") + 1);
			removeamount = bertstart.length() - (index + 4);
			bertend = bertstart.substring(0, bertstart.length() - removeamount);
			userinput = bertend;
			
		}
		
		if(userinput.startsWith("bert") && userinput.endsWith("bert")) {
			
			endremoved = userinput.substring(0, userinput.length() - 4);
			
			startremoved = endremoved.substring(4);
			
			for(int i = startremoved.length() - 1; i >= 0; i--) {
				reversed += startremoved.substring(i, i + 1);
			}
			
			return reversed;
		}
		else {
			return "";
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int values[] = {a, b, c};
		int temp;
		int medtosmall;
		int largetomed;
	
		
		for(int t = 0; t < 2; t++) {
		  for(int i = 0; i < 2; i++) {
			if(values[i] > values[i+1]) {
				temp = values[i+1];
				values[i+1] = values[i];
				values[i] = temp;
			}
			else
			{
			}
		}
		} 
		
		medtosmall = values[1] - values[0];
		largetomed = values[2] - values[1];
		
		if(medtosmall == largetomed) {
			return true;
		}
		else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int middle = (input.length() - a) / 2; //Finds out the amount to take off each side of the string in order to remove the middle
		
		String newstring;
		
		newstring = input.substring(0 , middle); //Gets the first half of the string without the middle
		
		newstring += input.substring(input.length() - middle, input.length()); //Gets the last half of the string without the middle
		
		return newstring; //Returns the new string without the middle 
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		char currentblock = ' ';
		int counter = 1;
		
		int largestcounter = 1;
		
		
		for(int i = 0; i < input.length() - 1; i++) { //input length is decremented by one in order to stop loop from overflowing out of string causing an error
			
			if(i == 0) { //Initialise first character into variable currentblock
				currentblock = input.charAt(i);
			}
			else if(input.charAt(i + 1) == currentblock) { //Checks to see if char after is same as current char stored in currentblock
				counter++;
			}
			else if(input.charAt(i + 1) != currentblock && counter >= largestcounter) { //if char is different and is larger than current largest stored value make it the largest value and reset counter value to starting 1
				
				largestcounter = counter;
				counter = 1;
				currentblock = input.charAt(i+1);
			}
		}
		
		
		if(input.length() == 0) { //Checks to see if empty string else return collected value
			return 0;
		}
		else {
			return largestcounter;
		}

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		arg1 = arg1.toLowerCase();
		int counter = 0;
		
		while(arg1.length() > 0) {
			int index = -1;
			index = arg1.indexOf("am "); //Finds index of am instance
			
			if(index > 0 && Character.isSpaceChar(arg1.charAt(index -1)) == true || index == 0) { //Ensures that char before is a space
				arg1 = arg1.substring(index + 3); //remove the am and space
				counter++; //Increment counter
			}
			else if(index >= 0 && Character.isSpaceChar(arg1.charAt(index -1)) == false) {//Skips over and removes all false positives (am at the end of Amsterdam)
				arg1 = arg1.substring(index + 3);
			}
			else{
				arg1 = ""; //Removes string to break while loop
			}
		}
		
		return counter;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if(arg1 % 3 == 0 && arg1 % 5 != 0) {
			return "fizz";
		}
		else if(arg1 % 5 == 0 && arg1 % 3 != 0) {
			return "buzz";
		}
		else if(arg1 % 5 == 0 && arg1 % 3 == 0)
		{
			return "fizzbuzz";
		}
		else {
			return null;
		}
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		//could use indexof to find first instance whitespace and then shorten teh string temp into a variable convert assigned i larger than current value then repeat till the lenght of the string is less than or equal to zero
		String temp;
		int index = 0;
		int totakeaway = 0;
		int largestValue = 0;
		int total;
		
		
		arg1 += " "; //Added space character to accomidate searching method
		
		while(arg1.length() > 0) {
			
			
			index = arg1.indexOf(" "); //Find instance of space character
			totakeaway = arg1.length() - index; //Find index of end 
			temp = arg1.substring(0 , arg1.length() - (totakeaway)); //Shorten to required string
			arg1 = arg1.substring(++index); //Store with used substring taken out
			
			total = 0; //Clear value
			
			for(int i = 0; i < temp.length(); i++) {
				total += (int)temp.charAt(i); //Converts char into int ASCII value
				total -= 48; //Take ASCII value away
			}
			//Comparision
			if(total > largestValue) {
				largestValue = total;
			}
		}
		
		//Return largest Value
		return largestValue;
	}
}
