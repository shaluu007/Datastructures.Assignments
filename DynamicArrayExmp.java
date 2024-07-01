package dsaArrays;

import java.util.ArrayList;

public class DynamicArrayExmp {
    private ArrayList<Integer> dynamicArray;

    public DynamicArrayExmp() {
        dynamicArray = new ArrayList<>();
    }

    public void insert(int element) {
        dynamicArray.add(element);
    }
    public void delete(int index) {
        if (index >= 0 && index < dynamicArray.size()) {
            dynamicArray.remove(index);
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    public void update(int index, int newValue) {
        if (index >= 0 && index < dynamicArray.size()) {
            dynamicArray.set(index, newValue);
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    public int get(int index) {
        if (index >= 0 && index < dynamicArray.size()) {
            return dynamicArray.get(index);
        } else {
            System.out.println("Index out of bounds.");
            return -1;
        }
    }

    public int size() {
        return dynamicArray.size();
    }

    public void print() {
        System.out.print("Dynamic Array: ");
        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.print(dynamicArray.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArrayExmp array = new DynamicArrayExmp();
        array.insert(10);
        array.insert(25);
        array.insert(70);
        array.print(); 
        array.update(1, 65);
        array.print(); 
        array.delete(2);
        array.print();
        int element = array.get(1);
        System.out.println("Element at index 1: " + element); 
        array.get(5); 
        System.out.println("Size of the array: " + array.size()); 
    }
}
