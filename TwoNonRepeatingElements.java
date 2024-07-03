package dsa.Bitwise;

public class TwoNonRepeatingElements {

    public static void findTwoNonRepeating(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int setBit = xor & -xor;
        int firstNonRepeating = 0;
        int secondNonRepeating = 0;
        
        for (int num : nums) {
            if ((num & setBit) != 0) {
                firstNonRepeating ^= num;
            } else {
                secondNonRepeating ^= num;
            }
        }
        System.out.println("Two non-repeating elements are: " + firstNonRepeating + " and " + secondNonRepeating);
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 9, 2, 4};
        findTwoNonRepeating(nums);
    }
}
