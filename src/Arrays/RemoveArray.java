package Arrays;

public class RemoveArray {
    public int remove(int[] nums, int val){
        int count = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        RemoveArray obj = new RemoveArray();
        int result = obj.remove(nums,val);
        System.out.println(result);
    }
}
