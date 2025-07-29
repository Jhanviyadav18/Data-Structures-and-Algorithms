package Arrays;
import java.util.Arrays;

public class RotateArray {
    public static int[] rotate(int[] nums, int k){
        int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums,o,k-1);
        reverse(nums,k,n-1);
        return nums;
    }

    public static void reverse(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start]
    }
    public static void main(String[] args) {

    }
}
