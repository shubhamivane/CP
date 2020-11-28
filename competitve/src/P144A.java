import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P144A {

	public static void main(String[] args) {
		testCase();
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
		int[] arr = fs.readArray(n);
		int maxIdx = 0, minIdx = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[maxIdx]) {
				maxIdx = i;
			}
			if (arr[i] <= arr[minIdx]) {
				minIdx = i;
			}
		}
		if (minIdx == maxIdx) {
			System.out.print(0);
		} else {
			System.out.print((n - minIdx - 1) + (maxIdx) - (minIdx < maxIdx ? 1 : 0));
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

}
