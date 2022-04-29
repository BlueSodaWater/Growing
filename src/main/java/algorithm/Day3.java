package algorithm;

/**
 * @author zhuwenxuan
 * @date 2022/4/28 23:12
 */
public class Day3 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 != 1) {
                left++;
            }
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
            right--;
        }

        return nums;
    }
}
