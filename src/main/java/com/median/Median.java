package com.median;

/**
 * by anyanwen
 * 2017/6/7.
 */
public class Median {
	public static void main(String[] args) {
		int[] a = {1, 2};
		int[] b = {3};
		new Median().findMedianSortedArrays(a, b);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int L1, R1, L2, R2, C1, C2, lo = 0, hi = m * 2;
		while (lo <= hi) {
			C1 = (lo + hi) / 2;
			C2 = m + n - C1;
			L1 = C1 == 0 ? Integer.MIN_VALUE : nums1[(C1 - 1) / 2];
			R1 = C1 == 2 * m ? Integer.MAX_VALUE : nums1[C1 / 2];
			L2 = C2 == 0 ? Integer.MIN_VALUE : nums2[(C2 - 1) / 2];
			R2 = C2 == 2 * n ? Integer.MAX_VALUE : nums2[C2 / 2];

			if (L1 > R2) {
				hi = C1 - 1;
			} else if (L2 > R1) {
				lo = C1 + 1;
			} else {
				return (double) (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
			}
		}
		return -1;
	}
}
