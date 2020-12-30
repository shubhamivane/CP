import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class FindAllSubSequenceDivisibleByN {

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
			int n = 19;
			int[] arr = { 1, 7, 1};
			Set<Integer> subSequences = new HashSet<>();
			findAllSubSequencesDibisibleByN(arr, 0, 0, n, subSequences);
			print(subSequences);
		}
	}

	private static void findAllSubSequencesDibisibleByN(int[] arr, int idx, int num, int n,
			Set<Integer> subSequences) {
		if(num != 0 && num % n == 0) {
			subSequences.add(num);
		}
		if(idx == arr.length) {
			return;
		}
		findAllSubSequencesDibisibleByN(arr, idx + 1, num, n, subSequences);
		findAllSubSequencesDibisibleByN(arr, idx + 1, num * 10 + arr[idx], n, subSequences);
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
