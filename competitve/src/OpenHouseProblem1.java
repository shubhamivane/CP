import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OpenHouseProblem1 {

	public static void main(String[] args) {
//		testCase();
		System.out.print("Running tests");
		validAllSameParenthesisTest();
		validCombinationTest();
		invalidAllSameParenthesisTest();
		invalidCombinationTest();
		testCase();

	}

	private static void testCase() {
		FastScanner fs = new FastScanner();
		char[] s = fs.readArray();
		System.out.print(String.valueOf(testCase(s)));
	}

	public static void testCases() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
//			testCase();
		}
	}

	public static boolean testCase(char[] s) {
		FastScanner fs = new FastScanner();
		char[] string = s.length == 0 ? fs.readArray() : s;
		char[] stack = new char[string.length];
		int top = -1;
		boolean flag = true;
		for (int i = 0; i < string.length; i++) {
			char temp = string[i];
			if ((temp == '}' || temp == ']' || temp == ')') && top < 0) {
				flag = false;
			} else if (temp == '}' && stack[top] == '{') {
				top--;
			} else if (temp == ']' && stack[top] == '[') {
				top--;
			} else if (temp == ')' && stack[top] == '(') {
				top--;
			} else {
				stack[++top] = temp;
			}
		}
//		if(flag) {
//			System.out.print("YES");
//		} else {
//			System.out.print("NO");
//		}
		return flag && top == -1;
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

	public static void validAllSameParenthesisTest() {
		if (testCase("{{}}".toCharArray())) {
			System.out.print("Passed");
		} else {
			System.out.print("Failed");
		}
	}

	public static void invalidAllSameParenthesisTest() {
		if (testCase("{{}}}".toCharArray())) {
			System.out.print("Passed");
		} else {
			System.out.print("Failed");
		}
	}

	public static void validCombinationTest() {
		if (testCase("{[{}]}".toCharArray())) {
			System.out.print("Passed");
		} else {
			System.out.print("Failed");
		}
	}

	public static void invalidCombinationTest() {
		if (testCase("{{}]}".toCharArray())) {
			System.out.print("Passed");
		} else {
			System.out.print("Failed");
		}
	}

}
