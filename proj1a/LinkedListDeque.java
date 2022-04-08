import org.w3c.dom.Node;

import java.util.Deque;

/**
 * @author xh
 * @date 2022/4/7
 * @apiNote
 */
public class LinkedListDeque<T> {
    private class Node{
        private T first;
        private Node prev;
        private Node next;

        public Node( Node prev, T first, Node next) {
            this.prev = prev;
            this.first = first;
            this.next = next;
        }
    }

    private Node sentinel;
    private static int size;
    private Node first;


    public LinkedListDeque() {
        sentinel = new Node(null, (T)new Object(), null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    //Add an item of type T to the front of the deque
    public void addFirst(T item){
        Node p = new Node(sentinel, item, sentinel.next);
//        p.prev = sentinel;
//        p.next = sentinel.next;
        sentinel.next = p;
        sentinel.next.prev = p;
        size++;
    }

    //Add an item of type T to the back of the deque
    public void addLast(T item){
        Node p = new Node(sentinel.prev, item, sentinel);
//        p.next = sentinel;
//        p.prev = sentinel.prev;
        sentinel.prev = p;
        sentinel.prev.next = p;
        size++;
    }

    //Returns true if deque is empty, false otherwise
    public boolean isEmpty(){
//        if(sentinel.next == sentinel || sentinel.prev == sentinel)
//            return  true;
//        else return  false;
        return size == 0;
    }

    //Returns the numbers of the items
    public int size(){
        return size;
    }

    //Prints the items in the deque from first to last,separated by a space
    public void printDeque(){
        Node p  = sentinel.next;
        while(p != sentinel){
            System.out.print(sentinel.next.first + " ");
            p = p.next;
        }
        System.out.println();
    }

    //Removes and returns the item at the front of the Deque, if no such item exists. If no such item exits, return null.
    public T removeFirst(){
        if(sentinel.next == sentinel)
            return null;
        Node p;
        p = sentinel.next;
        sentinel.next = p.next;
        //p.next.prev = sentinel;
        sentinel.next.prev = sentinel;
        size--;
        return p.first;

    }

    //Removes and returns the item at the front of the Deque, if no such item exists. If no such item exits, return null.
    public T removeLast(){
        if(sentinel.prev == sentinel)
            return null;
        Node p = sentinel.prev;
        sentinel.prev = p.prev;
        //p.prev.next = sentinel;
        sentinel.prev.next = sentinel;
        size--;
        return  p.first;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque
    public T get(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < LinkedListDeque.size; i++) {
            if(i == index)
                return p.first;
            p = p.next;
        }
        return null;
    }

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque, use the recrusion
    public T getRecrusive(Node node, int index){
        if(size < index) return null;
        if(index == 0)
            return node.first;
        else {
            node = node.next;
            index--;
        }
        return  getRecrusive(node, index);
    }


























}





































