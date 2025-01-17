package DataStructures.Sorting;

public class BubbleSortExmp {
    public static void bubbleSort(int[] arr) {
	        int n = arr.length;
	        boolean swapped;
	        
	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                    swapped = true;
	                }
	            }
	            if (!swapped) {
	                break;
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] array = { 5, 4, 16, 2, 8,44 };

	        System.out.println("Array before sorting:");
	        printArray(array);

	        bubbleSort(array);

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
