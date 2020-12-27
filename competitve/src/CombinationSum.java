import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class CombinationSum {

	/*
	 * https://leetcode.com/problems/combination-sum/
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
			int n = fs.nextInt();
			int[] arr = fs.readArray(n);
			int target = fs.nextInt();
			print(combinationSum(arr, target));
		} else {
			int[] arr = { 2, 3, 6, 7 };
			int target = 7;
			print(combinationSum(arr, target));
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0 || target == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates, target, 0, new ArrayList<>(), result);
		return result;
	}

	private static void combinationSum(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> results) {
		if (target < 0) {
			return;
		}
		if(target == 0) {
			results.add(new ArrayList<>(combination));
			return;
		}
		for(int i = start ; i < candidates.length ; i++) {
			combination.add(candidates[i]);
//			print(combination);
//			print(target-candidates[i]);
			combinationSum(candidates, target - candidates[i], i, combination, results);
			combination.remove(combination.size()-1);
		}
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

}
