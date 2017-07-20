package com.oth.fraction;

/**
 * by anyanwen
 * 2017/6/6.
 */
public class FractionUtil {
	public static Fraction fAdd(Fraction a, Fraction b) {
		int demoniator = MathUtil.getCommonMulti(a.getDenominator(), b.getDenominator());
		int numerator = (a.getNumerator() * demoniator / a.getDenominator() )* a.getFlag()
				+ (b.getNumerator() * demoniator / b.getDenominator()) * b.getFlag();
		return new Fraction(numerator, demoniator);
	}


	public static Fraction fMinus(Fraction a, Fraction b) {
		int demoniator = MathUtil.getCommonMulti(a.getDenominator(), b.getDenominator());
		int numerator = a.getNumerator() * demoniator / a.getDenominator() * a.getFlag()
				- b.getNumerator() * demoniator / b.getDenominator() * b.getFlag();
		return new Fraction(numerator, demoniator);
	}


	public static Fraction fMultipile(Fraction a, Fraction b) {
		return new Fraction(a.getNumerator() * b.getNumerator() * a.getFlag() * b.getFlag(),
							a.getDenominator() * b.getDenominator());
	}

	public static Fraction fDiv(Fraction a, Fraction b) {
		return new Fraction(a.getNumerator() * b.getDenominator() * a.getFlag() * b.getFlag(),
							a.getDenominator() * b.getNumerator());
	}
}
