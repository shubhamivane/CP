import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class MultiplyStrings {

	/*
	 * https://leetcode.com/problems/multiply-strings/
	 */

	public static void main(String[] args) {
		testCase(false);
	}

	public static void testCases() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
			testCase(false);
		}
	}

	public static void testCase(boolean flag) {
		if (flag) {
			FastScanner fs = new FastScanner();
		} else {
			String num1 = "123", num2 = "456";
			print(multiply(num1, num2));
		}
	}

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		if (num1.equals("1"))
			return num2;
		if (num2.equals("1"))
			return num1;
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		String result = "";
		for (int i = 0; i < num1.length(); i++) {
			int carry = 0, mul = 0, cnt = 0;
			String ans = "";
			while (cnt < i) {
				ans += "0";
				cnt++;
			}
			for (int j = 0; j < num2.length(); j++) {
				mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
				carry = mul / 10;
				ans += String.valueOf(mul % 10);
			}
			if(carry > 0) ans += String.valueOf(carry);
			result = addStrings(result, ans);
		}
		return new StringBuilder(result).reverse().toString();
	}

	public static String addStrings(String num1, String num2) {
		List<String> result = new ArrayList<>();
		int i = 0, temp = 0;
		for (; i < num1.length() && i < num2.length(); i++) {
			temp = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + temp;
			result.add(String.valueOf(temp % 10));
			temp /= 10;
		}
		int j = i;
		while (j < num1.length()) {
			temp = (num1.charAt(j) - '0') + temp;
			result.add(String.valueOf(temp % 10));
			temp /= 10;
			j++;
		}
		while (j < num2.length()) {
			temp = (num2.charAt(j) - '0') + temp;
			result.add(String.valueOf(temp % 10));
			temp /= 10;
			j++;
		}
		if (temp > 0) {
			result.add(String.valueOf(temp));
		}
		return result.stream().collect(Collectors.joining(""));
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
