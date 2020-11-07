public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray remove = new RemoveDuplicateFromSortedArray();

        System.out.println(remove.removeDuplicates(new int[]{1,1,2}));
    }

    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[pos] != nums[i]) {
                nums[++pos] = nums[i];
                //pos++;
            }
        }

        return pos + 1;
    }
}
