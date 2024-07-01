package DataStructures.Sorting;

public class HeapSortExmp {

	   public static void heapSort(int[] arr) {
	        int n = arr.length;
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(arr, n, i);
	        }
	        for (int i = n - 1; i > 0; i--) {
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	            heapify(arr, i, 0);
	        }
	    }
	    private static void heapify(int[] arr, int n, int i) {
	        int largest = i; 
	        int leftChild = 2 * i + 1;
	        int rightChild = 2 * i + 2;
	        if (leftChild < n && arr[leftChild] > arr[largest]) {
	            largest = leftChild;
	        }
	        if (rightChild < n && arr[rightChild] > arr[largest]) {
	            largest = rightChild;
	        }
	        if (largest != i) {
	            int swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;
	            heapify(arr, n, largest);
	        }
	    }

	   public static void main(String[] args) {
	        int[] array = { 12, 49, 13, 5, 62, 7 };

	        System.out.println("Array before sorting:");
	        printArray(array);

	        heapSort(array);

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
