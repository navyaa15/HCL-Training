//package Array;
//
//import java.util.ArrayDeque;
//
//public class ArrayDqueue {
//
//    public static void main(String[] args) {
//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//
//
//        deque.add(10);
//        deque.addLast(20);
//        deque.addFirst(5);
//        deque.offer(30);
//        deque.offerFirst(1);
//        deque.offerLast(40);
//
//        System.out.println("After insertion: " + deque);
//
//
//        System.out.println("First element: " + deque.getFirst());
//        System.out.println("Last element: " + deque.getLast());
//        System.out.println("Peek first: " + deque.peekFirst());
//        System.out.println("Peek last: " + deque.peekLast());
//        System.out.println("Queue peek: " + deque.peek());
//
//
//        deque.removeFirst();
//        System.out.println("After removeFirst: " + deque);
//        deque.removeLast();
//        System.out.println("After removeLast: " + deque);
//        deque.remove(20);
//        System.out.println("After remove(20): " + deque);
//        deque.pollFirst();
//        deque.pollLast();
//        deque.poll();
//
//        System.out.println("After polling: " + deque);
//
//
//        deque.addAll(Arrays.asList(10, 20, 30, 20));
//
//        System.out.println("Contains 20: " + deque.contains(20));
//        System.out.println("Contains 99: " + deque.contains(99));
//
//
//        deque.removeFirstOccurrence(20);
//        System.out.println("After removing first 20: " + deque);
//
//        deque.removeLastOccurrence(20);
//        System.out.println("After removing last 20: " + deque);
//
//        // 6. SIZE AND EMPTY CHECK
//        System.out.println("Size: " + deque.size());
//        System.out.println("Is empty: " + deque.isEmpty());
//
//
//        System.out.println("Forward iteration:");
//        for (int element : deque) {
//            System.out.print(element + " ");
//        }
//        System.out.println();
//
//        // 8. ITERATION FROM BACK TO FRONT
//        System.out.println("Reverse iteration:");
//        Iterator<Integer> reverse = deque.descendingIterator();
//
//        while (reverse.hasNext()) {
//            System.out.print(reverse.next() + " ");
//        }
//        System.out.println();
//
//
//        deque.clear();
//        deque.push(100);
//        deque.push(200);
//        deque.push(300);
//
//        System.out.println("Stack: " + deque);
//        System.out.println("Stack top: " + deque.peek());
//        System.out.println("Stack pop: " + deque.pop());
//        System.out.println("Stack after pop: " + deque);
//
//        // 10. QUEUE OPERATIONS (FIFO)
//        deque.clear();
//        deque.offer(10);
//        deque.offer(20);
//        deque.offer(30);
//
//        System.out.println("Queue: " + deque);
//        System.out.println("Queue front: " + deque.peek());
//        System.out.println("Queue remove: " + deque.poll());
//        System.out.println("Queue after poll: " + deque);
//
//        deque.addAll(Arrays.asList(40, 50, 60));
//        System.out.println("After addAll: " + deque);
//
//
//        Object[] arr = deque.toArray();
//        System.out.println("Array: " + Arrays.toString(arr));
//
//
//        deque.clear();
//        System.out.println("After clear: " + deque);
//        System.out.println("Is empty: " + deque.isEmpty());
//    }
//}