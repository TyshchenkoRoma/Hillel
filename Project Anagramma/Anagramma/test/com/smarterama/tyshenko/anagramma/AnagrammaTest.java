package com.smarterama.tyshenko.anagramma;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagrammaTest {
	private Anagramma anagramma = new Anagramma();

	@Test
	public void testAnagrammEmpty() {
		assertEquals("", anagramma.getAnagramm(""));
	}

	@Test
	public void testAnagrammWithOneSpace() {
		assertEquals(" ", anagramma.getAnagramm(" "));
	}

	@Test
	public void testAnagrammWithTwoSpaces() {
		assertEquals("  ", anagramma.getAnagramm("  "));
	}

	@Test
	public void testAnagrammWithThreeSpaces() {
		assertEquals("   ", anagramma.getAnagramm("   "));
	}

	@Test
	public void testAnagrammWithOneLetter() {
		assertEquals("a", anagramma.getAnagramm("a"));
	}

	@Test
	public void testAnagrammWithTwoLetters() {
		assertEquals("an", anagramma.getAnagramm("na"));
	}

	@Test
	public void testAnagrammWithFourLetters() {
		assertEquals("asdf", anagramma.getAnagramm("fdsa"));
	}

	@Test
	public void testAnagrammWithFourLetterAndBeginningSpace() {
		assertEquals(" asdf", anagramma.getAnagramm(" fdsa"));
	}

	@Test
	public void testAnagrammWithFourLetterAndBeginningTwoSpaces() {
		assertEquals("  asdf", anagramma.getAnagramm("  fdsa"));
	}

	@Test
	public void testAnagrammWithTwoWords() {
		assertEquals("abcd efgh", anagramma.getAnagramm("dcba hgfe"));
	}

	@Test
	public void testAnagrammWithTwoWordsAndNonAlphanumericCharacters() {
		assertEquals("a1bcd efg!h", anagramma.getAnagramm("d1cba hgf!e"));
	}

	@Test
	public void testAnagrammWithThreeWordsSpacesAndNonAlphanumericCharacters() {
		assertEquals("  a1bcd efg!h asdf ",
				anagramma.getAnagramm("  d1cba hgf!e fdsa "));
	}

	@Test
	public void testAnagrammWithLetterAndSeveralNonAlphanumericCharacters() {
		assertEquals("  123a45!@ ", anagramma.getAnagramm("  123a45!@ "));
	}
}
