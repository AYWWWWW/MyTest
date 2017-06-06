package com.fraction;

import org.junit.Test;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

/**
 * by anyanwen
 * 2017/6/6.
 */
public class FractionTest {
	@Test
	public void add() throws Exception {
		Fraction f1 = new Fraction(-5, 9);
		Fraction f2 = new Fraction(-3, -6);
		assert FractionUtil.fAdd(f1, f2).equals(new Fraction(-1,18));
	}


	@Test
	public void minus() throws Exception {
		Fraction f1 = new Fraction(5, 9);
		Fraction f2 = new Fraction(3, -6);
		assert FractionUtil.fMinus(f1, f2).equals(new Fraction(19,18));
	}


	@Test
	public void multi() throws Exception {
		Fraction f1 = new Fraction(5, 9);
		Fraction f2 = new Fraction(3, -6);
		assert FractionUtil.fMultipile(f1, f2).equals(new Fraction(-150,540));
	}

	@Test
	public void div() throws Exception {
		Fraction f1 = new Fraction(5, 9);
		Fraction f2 = new Fraction(3, -6);
		assert FractionUtil.fDiv(f1, f2).equals(new Fraction(-10,9));
	}

}