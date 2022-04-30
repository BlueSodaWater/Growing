package algorithm;

/**
 * @author zhuwenxuan
 * @ClassName Day5
 * @date 2022/4/30 13:25
 */
public class Day5 {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }

        return (max - min - 2 * k) >= 0 ? max - min - 2 * k : 0;
    }
}
