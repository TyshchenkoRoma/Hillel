package com.smarterama.tyshenko.anagramma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)  {		
		try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
			System.out.println("Input words through the spase: ");
			String text = bufferedReader.readLine();
			System.out.println(Anagramma.getAnagramm(text));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}