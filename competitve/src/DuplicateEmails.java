import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DuplicateEmails {

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
//		int n = fs.nextInt();
		String[] arr = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		print(numUniqueEmails(arr));
	}

	public static int numUniqueEmails(String[] emails) {
		Set<String> distinctEmails = new HashSet<>();
		for (String email : emails) {
			String[] localAndDomainArray = email.split("@");
//			System.out.println(localAndDomainArray[0]);
			localAndDomainArray[0] = removeDots(localAndDomainArray[0]);
//			System.out.println(localAndDomainArray[0]);
			int firstIndexOfPlus = localAndDomainArray[0].indexOf("+");
			if (firstIndexOfPlus != -1) {
				localAndDomainArray[0] = localAndDomainArray[0].substring(0, firstIndexOfPlus);
			}
			distinctEmails.add(localAndDomainArray[0] + "@" + localAndDomainArray[1]);
			print(distinctEmails);
		}
		return distinctEmails.size();
	}

	public static String removeDots(String input) {
		return Arrays.asList(input.split("")).stream().filter(ch -> !ch.equals(".")).collect(Collectors.joining(""));
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
