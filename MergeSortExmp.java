package DataStructures.Sorting;

public class MergeSortExmp {

	    public static void mergeSort(int[] arr) {
	        if (arr == null || arr.length <= 1) {
	            return;
	        }
	        int n = arr.length;
	        int[] tempArray = new int[n];
	        mergeSortHelper(arr, tempArray, 0, n - 1);
	    }

	    private static void mergeSortHelper(int[] arr, int[] tempArray, int left, int right) {
	        if (left < right) {
	            int mid = left + (right - left) / 2;
	            mergeSortHelper(arr, tempArray, left, mid);
	            mergeSortHelper(arr, tempArray, mid + 1, right);
	            merge(arr, tempArray, left, mid, right);
	        }
	    }

	    private static void merge(int[] arr, int[] tempArray, int left, int mid, int right) {
	        for (int i = left; i <= right; i++) {
	            tempArray[i] = arr[i];
	        }

	        int i = left;    
	        int j = mid + 1;
	        int k = left;    
	        while (i <= mid && j <= right) {
	            if (tempArray[i] <= tempArray[j]) {
	                arr[k] = tempArray[i];
	                i++;
	            } else {
	                arr[k] = tempArray[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= mid) {
	            arr[k] = tempArray[i];
	            i++;
	            k++;
	        }
	        while (j <= right) {
	            arr[k] = tempArray[j];
	            j++;
	            k++;
	        }
	    }

	    public static void main(String[] args) {
	        int[] array = { 5, 1, 4, 2, 8 };

	        System.out.println("Array before sorting:");
	        printArray(array);

	        mergeSort(array);

	        System.out.println("Array after sorting:");
	        printArray(array);
	    }
	    public static void printArray(int[] arr) {
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }
}
