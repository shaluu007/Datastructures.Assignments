package DataStructures.Searchs;

public class JumpSearchExmp {

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int blockSize = (int) Math.sqrt(n);
        int step = blockSize;
        int prev = 0;
        while (step < n && arr[step] < target) {
            prev = step;
            step += blockSize;
        }
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        int target = 13;

        int index = jumpSearch(array, target);

        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
