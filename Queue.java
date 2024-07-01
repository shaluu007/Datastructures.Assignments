package Queue;
import java.util.NoSuchElementException;

class Node<T> {
 T data;
 Node<T> next;

 public Node(T data) {
     this.data = data;
     this.next = null;
 }
}
public class Queue<T> {
 private Node<T> front; 
 private Node<T> rear; 
 private int size;  

 public Queue() {
     front = null;
     rear = null;
     size = 0;
 }
 public void enqueue(T element) {
     Node<T> newNode = new Node<>(element);
     if (isEmpty()) {
         front = newNode;
         rear = newNode;
     } else {
         rear.next = newNode;
         rear = newNode;
     }
     size++;
 }
 public T dequeue() {
     if (isEmpty()) {
         throw new NoSuchElementException("Queue is empty");
     }
     T data = front.data;
     front = front.next;
     if (front == null) {
         rear = null;
     }
     size--;
     return data;
 }
 public T peek() {
     if (isEmpty()) {
         throw new NoSuchElementException("Queue is empty");
     }
     return front.data;
 }
 public boolean isEmpty() {
     return size == 0;
 }
 public int size() {
     return size;
 }

 public static void main(String[] args) {
     Queue<Integer> queue = new Queue<>();
     queue.enqueue(10);
     queue.enqueue(28);
     queue.enqueue(82);
     System.out.println("Queue size: " + queue.size());

     System.out.println("Front element: " + queue.peek()); 
     System.out.println("Dequeued element: " + queue.dequeue());

     System.out.println("Queue size after dequeue: " + queue.size()); 
     System.out.println("Front element after dequeue: " + queue.peek());

     while (!queue.isEmpty()) {
         System.out.println("Dequeued element: " + queue.dequeue());
     }
     try {
         System.out.println("Dequeued element: " + queue.dequeue()); 
     } catch (NoSuchElementException e) {
         System.out.println("Cannot dequeue from empty queue.");
     }
 }
}
