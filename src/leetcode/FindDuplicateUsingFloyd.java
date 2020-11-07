package leetcode;

public class FindDuplicateUsingFloyd {
    public static void main(String[] args) {
        FindDuplicateUsingFloyd findDuplicateUsingFloyd = new FindDuplicateUsingFloyd();
        System.out.println(findDuplicateUsingFloyd.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
