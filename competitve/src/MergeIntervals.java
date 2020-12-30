import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MergeIntervals {

	/*
	 * https://leetcode.com/problems/merge-intervals/
	 */

	public static void main(String[] args) {
		testCase(false);
	}

	public static void testCases() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
			testCase(true);
		}
	}

	public static void testCase(boolean flag) {
		if (flag) {
			FastScanner fs = new FastScanner();
		} else {
//			int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
			int[][] intervals = {{1,3},{2,6},{5,10},{10,18}};
			print(merge(intervals));
		}
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals.length == 1){
			return intervals;
		}
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(intervals, Comparator.comparingDouble(ele -> ele[0]));
		List<Integer> temp = null;
		int start = 0, end = 0;
		List<Integer> prevInterval = new ArrayList<>();
		prevInterval.add(intervals[0][0]);
		prevInterval.add(intervals[0][1]);
		for(int i = 1 ; i < intervals.length; i++) {
			if(prevInterval.get(1) < intervals[i][0]) {
				result.add(prevInterval);
				prevInterval = new ArrayList<>();
				prevInterval.add(intervals[i][0]);
				prevInterval.add(intervals[i][1]);
				continue;
			}
			start = Math.min(intervals[i][0], prevInterval.get(0));
			end = Math.max(intervals[i][1], prevInterval.get(1));
			prevInterval.set(0, start);
			prevInterval.set(1, end);
		}
		result.add(prevInterval);
		int[][] mergedIntervals = new int[result.size()][2];
		int i=0;
		for(List<Integer> itr : result) {
			mergedIntervals[i][0] = itr.get(0);
			mergedIntervals[i][1] = itr.get(1);
			i++;
		}
		return mergedIntervals;
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

	static void print(boolean bool) {
		System.out.print(String.valueOf(bool));
	}

	static void print(int[][] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			print(arr[i]);
		}
	}

}
