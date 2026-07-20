import java.util.*;

public class SubArraysumdivisiblebyK {

    static int subarraySumDivisibleByK(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int rem = (sum % k + k) % k;
            count += map.getOrDefault(rem, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println(subarraySumDivisibleByK(nums, k));
    }
}