package com.smarterama.tyshenko.anagramma;

import java.util.Arrays;

public class Anagramma {
	private static final String DELIMITER = " ";

	public static String getAnagramm(String text) {
		if (text == null || text.isEmpty()) {
			return text;
		}
		String[] words = text.split(DELIMITER, text.length());		
		StringBuilder completeText = new StringBuilder();
		 for (String word : words) {
			completeText.append(transposeLetters(word.toCharArray()));			
			completeText.append(DELIMITER);			
		}
		completeText.deleteCharAt(text.length());
		return completeText.toString();				
	}

	private static char[] transposeLetters(char[] letters) {
		int leftPosition = 0;
		int rightPosition = letters.length - 1;
		while (leftPosition < rightPosition) {
			if (!Character.isLetter(letters[leftPosition])) {
				leftPosition++;
			} else if (!Character.isLetter(letters[rightPosition])) {
				rightPosition--;
			} else {
				swap(letters, leftPosition, rightPosition);
				rightPosition--;
				leftPosition++;
			}
		}
		return letters;
	}

	private static void swap(char[] chars, int leftPosition, int rightPosition) {
		char temp = chars[leftPosition];
		chars[leftPosition] = chars[rightPosition];
		chars[rightPosition] = temp;
	}
}