public class SubarraysumequalsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i<nums.length;i++){
            int sum = 0;
            for(int j = i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum == k){
                    count++;
                }
        
            }
        }
        return count;
    }
public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4};

        System.out.println("Number of subarrays with sum equal to k = " + subarraySum(nums, 1));
    }
}
