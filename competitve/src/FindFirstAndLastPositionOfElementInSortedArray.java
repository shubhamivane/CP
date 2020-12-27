import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FindFirstAndLastPositionOfElementInSortedArray {

	/*
	 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-
	 * sorted-array/
	 */
	public static void main(String[] args) {
//		testCase();
		HashSet<String> s = new HashSet<>();
		s.add("a");
		s.add("a");
	}

	public static void testCases() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
			testCase();
		}
	}

	public static void testCase() {
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int target = fs.nextInt();
		int[] arr = fs.readArray(n);
		int[] ans = new int[2];
		ans[0] = binarySearchFindFirstOccurence(arr, target);
		ans[1] = binarySearchFindLastOccurence(arr, target);
		print(ans);
	}

	public static int binarySearchFindFirstOccurence(int[] arr, int target) {
		int mid, right = arr.length - 1, left = 0;
		int startIdx = Integer.MAX_VALUE;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if(arr[mid] >= target) {
				if(arr[mid] == target) startIdx = Math.min(startIdx, mid);
				right = mid - 1;
//				print(startIdx);
			}
			if(arr[mid] < target) {
				left = mid + 1;
			}
		}
		return startIdx == Integer.MAX_VALUE ? -1 : startIdx;
	}
	
	public static int binarySearchFindLastOccurence(int[] arr, int target) {
		int mid, right = arr.length - 1, left = 0;
		int endIdx = -1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if(arr[mid] > target) {
				right = mid - 1;
			}
			if(arr[mid] <= target) {
				if(arr[mid] == target) endIdx = Math.max(endIdx, mid);
				left = mid + 1;
			}
		}
		return endIdx;
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		char nextChar() {
			return next().charAt(0);
		}

		char[] readArray() {
			return next().toCharArray();
		}

		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
	}
	
	static void print(int n) {
		System.out.println(n);
	}

	static void print(long n) {
		System.out.println(n);
	}

	static void print(double n) {
		System.out.println(n);
	}

	static void print(float n) {
		System.out.println(n);
	}

	static void print(String n) {
		System.out.println(n);
	}

	static void print(Collection<?> c) {
		System.out.println(c.toString());
	}

	static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void print(float[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void print(long[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void print(double[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
