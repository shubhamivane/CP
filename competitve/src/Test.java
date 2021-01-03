import java.util.Arrays;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
        TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> {
            return a[0] < b[0] ? -1 : 1;
        });

        treeSet.add(new int[]{1, 2});
        treeSet.add(new int[]{2, 2});
        treeSet.add(new int[]{3, 2});
        treeSet.add(new int[]{4, 2});
        treeSet.add(new int[]{5, 2});
        for(int[] arr: treeSet) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("After Deletion");
        for(int[] arr: treeSet) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
