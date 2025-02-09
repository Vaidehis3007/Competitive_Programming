import java.util.Arrays;

public class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums[i] - i; // Transform the array
        }
        Arrays.sort(diff); // Sort the diff array

        long good = 0;
        int left = 0;
        while (left < n) {
            int right = left;
            while (right < n && diff[right] == diff[left]) {
                right++; // Move right pointer to find the end of the group
            }
            int count = right - left; // Number of identical elements
            good += (long) count * (count - 1) / 2; // Calculate good pairs
            left = right; // Move left pointer to the next group
        }

        long total = (long) n * (n - 1) / 2; // Total pairs
        return total - good; // Bad pairs
    }
}