import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P746B {

	public static void main(String[] args) {
		System.out.print("Hellow");
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
		String s = fs.next();
		while (s.length() > 0) {
			int mid = -1;
			if (s.length() % 2 == 0) {
				mid = s.length() / 2 - 1;
				System.out.print(s.indexOf(mid));
			} else {
				mid = s.length() / 2;
				System.out.print(s.indexOf(mid));
			}
			s = removeChar(mid, s);
		}
	}

	static String removeChar(int idx, String str) {
		if (idx < 0) {
			return str;
		}
		return str.substring(0, idx) + str.substring(idx + 1);
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
