package com.smarterama.tyshenko.anagramma;

public class Anagramma {
	public static String doAnagramByWords(String expression) {
		String[] wordsArray = expression.split(" ");
		String result = "";
		for (int i = 0; i < wordsArray.length; i++) {
			result += doAnagram(wordsArray[i]);
			if (i != wordsArray.length-1) 
				result += " ";
		}
		return result;
	}
	
	private static String doAnagram(String string) {		
		char[] chars = string.toCharArray();
		for(int left = 0, right = chars.length-1; left < right; ) {
			if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			} else {
				if (!Character.isLetter(chars[left])) 
					left++;
				if (!Character.isLetter(chars[right])) 
					right--;
			}
		}
		return new String(chars);
	}
	
}