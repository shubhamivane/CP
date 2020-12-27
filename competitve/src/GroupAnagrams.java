import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagrams {

	/*
	 * https://leetcode.com/problems/group-anagrams/
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
		} else {
//			String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
			String[] strs = { "bdddddddddd", "bbbbbbbbbbc" };

			print(groupAnagrams(strs));
		}
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> anagramMap = new HashMap<>();
		for (String string : strs) {
			int[] cntArray = new int[26];
			for (int i = 0; i < 26; i++)
				cntArray[i] = 0;
			for (int i = 0; i < string.length(); i++) {
				cntArray[string.charAt(i) - 'a']++;
			}
			String anagramKey = IntStream.of(cntArray).boxed().map(String::valueOf).collect(Collectors.joining("-"));
			print(anagramKey);
			if (anagramMap.containsKey(anagramKey)) {
				anagramMap.get(anagramKey).add(string);
			} else {
				List<String> anagramList = new ArrayList<>();
				anagramList.add(string);
				anagramMap.put(anagramKey, anagramList);
			}
		}
		return anagramMap.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
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
