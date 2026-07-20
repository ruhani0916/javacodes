import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;
public class LCSUsingHashset {
    public static int longestConsecutiveSubsequence(int n, int[] arr) {
    HashSet<Integer> set = new HashSet<>();

    for (int num : arr) {
        set.add(num);
    }

    int longestStreak = 0;

    for (int num : set) {
        if (!set.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

            while (set.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }
    }

    return longestStreak;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = longestConsecutiveSubsequence(n, arr);
        System.out.println("Length of the longest consecutive subsequence: " + result);

        sc.close();
    }
    
}
