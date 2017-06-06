package com.fraction;

/**
 * by anyanwen
 * 2017/6/6.
 */
public class Fraction {
	private int numerator;//分子
	private int denominator;//分母
	private int flag = 1;//正负标识

	public Fraction() {
	}

	public Fraction(int numerator, int denominator) {
		this.numerator = Math.abs(numerator);
		this.denominator = Math.abs(denominator);
		if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
			this.flag = -1;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (flag == -1) {
			sb.append("-");
		}
		sb.append(numerator).append('/').append(denominator);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fraction) {
			Fraction f = ((Fraction) obj).reduction();
			Fraction cur = this.reduction();
			return f.getNumerator() == cur.getNumerator()
					&& f.getDenominator() == cur.getDenominator()
					&& f.getFlag() == cur.getFlag();
		}
		return false;
	}

	/**
	 * 约分
	 *
	 * @return
	 */
	public Fraction reduction() {
		int commonMulti = MathUtil.getCommonMulti(numerator, denominator);
		Fraction f = new Fraction(numerator / commonMulti, denominator / commonMulti);
		f.setFlag(flag);
		return f;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
