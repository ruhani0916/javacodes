import java.util.*;

class longestconsecutivesubsequence {

    // Method defined outside main
    public static int longestconsecutivesubsequence(int n, int[] arr) {
        if (n == 0) return 0;

        Arrays.sort(arr);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] == arr[i - 1] + 1) {
                    currentStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = longestconsecutivesubsequence(n, arr);
        System.out.println(result);
    }
}