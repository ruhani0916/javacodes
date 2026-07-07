import java.util.*;

public class maximumsubarray {

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i <nums.length;i++){
            int currentSum = 0;
            for(int j = i;j < nums.length;j++){
                currentSum = currentSum + nums[j]; //i se j tak ke elements ka sum
                maxSum = Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }
     public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4};

        System.out.println("Maximum Subarray Sum = " + maxSubArray(nums));
    }
}
