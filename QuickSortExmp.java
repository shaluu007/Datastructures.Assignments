package DataStructures.Sorting;

public class QuickSortExmp {

	    public static void quickSort(int[] arr) {
	        if (arr == null || arr.length == 0) {
	            return;
	        }
	        sort(arr, 0, arr.length - 1);
	    }

	    private static void sort(int[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            sort(arr, low, pi - 1);
	            sort(arr, pi + 1, high);
	        }
	    }

	    private static int partition(int[] arr, int low, int high) {
	        int pivot = arr[high];
	        int i = low - 1; 

	        for (int j = low; j < high; j++) {
	            if (arr[j] <= pivot) {
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[i + 1];
	        arr[i + 1] = arr[high];
	        arr[high] = temp;

	        return i + 1;
	    }

	    public static void main(String[] args) {
	        int[] array = { 9, 13, 42, 2, 7,67 };

	        System.out.println("Array before sorting:");
	        printArray(array);

	        quickSort(array);

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
