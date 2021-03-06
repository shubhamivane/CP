import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25A {

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
		int oddCnt = 0, evenCnt = 0, oddIdx = 1, evenIdx = 1;
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 == 0) {
				evenCnt++;
				evenIdx = i;
			} else {
				oddCnt++;
				oddIdx = i;
			}
		}
		System.out.print((oddCnt == 1 ? oddIdx : evenIdx) + 1);
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
