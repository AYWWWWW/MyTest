import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by OneAPM on 2016/11/3.
 */
public class teset {
	public static void main(String[] args) throws InterruptedException {
		int a = '￣';
		int b = 2;
		System.out.println(a);
		System.out.println(calc(a, b));
		double c = 1;
		double d = 2;
		System.out.println(calc(c, d));
	}

	private static double calc(Object a, Object b) {
		if (a instanceof Integer) {
			return ((Integer) a).doubleValue() + ((Integer) b).doubleValue();
		} else {
			return (double)a + (double)b;
		}
	}

	public static int reverse(int x) {
		List<Long> list = new ArrayList<>();
		int flag = 1;
		if (x < 0) {
			flag = -1;
		}
		long absx = Math.abs((long) x);
		long quotient = absx / 10, remainder = absx % 10;
		while (quotient != 0) {
			list.add(remainder);
			remainder = quotient % 10;
			quotient = quotient / 10;
		}
		list.add(remainder);
		long result = 0;
		for (int k = 0, j = list.size() - 1; k < list.size(); k++, j--) {
			result += list.get(k) * Math.pow(10, j);
		}
		return result > Integer.MAX_VALUE ? 0 : (int) (result * flag);
	}

	public int maxArea(int[] height) {
		int max = 0;
		int i = 0;
		while (i < height.length) {
			int left = height[i];
			int j = i + 1;
			int right = height[j];
			if (left <= right) {
				max = Math.max(max, left);
				i++;
				continue;
			}
			while (right < height[j + 1] && left > right) {
				j++;
				right = height[j];
			}
			max = Math.max(max, Math.min(left, right) * (j - i));
			i = j;
		}
		return max;
	}

	public class Solution {
		public boolean isMatch(String s, String p) {
			if (!p.contains("*") && p.length() < s.length()) {
				return false;
			}
			char next;
			int match = 0;
			for (int i = 0, j = 0; i < s.length() && j < p.length(); ) {
				if (p.charAt(j) == '.') {
					j++;
					i++;
					match++;
				} else if (p.charAt(j) == '*') {
					if (j == p.length() - 1) return true;
					else {
						next = p.charAt(j + 1);
						if (next == s.charAt(i)) {
							j++;
							match++;
						}
						i++;
					}
				} else if (p.charAt(j) != s.charAt(i)) {
					i++;
				} else {
					j++;
					i++;
					match++;
				}
			}
			if (match == s.length()) return true;
			else return false;
		}
	}
}
