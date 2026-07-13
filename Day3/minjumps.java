public class minjumps {

    public static int minJumps(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return 0;
        }

        if (nums[0] == 0) {
            return -1;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {

                if (farthest == currentEnd) {
                    return -1;
                }

                jumps++;
                currentEnd = farthest;

                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        int result = minJumps(nums);

        System.out.println("Minimum jumps: " + result);
    }
}