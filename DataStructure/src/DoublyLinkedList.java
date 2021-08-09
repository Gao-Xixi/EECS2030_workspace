import java.io.Serializable;
import java.util.*;

/**
 *
 * @param <T>
 */
public class DoublyLinkedList<T> extends AbstractSequentialList<T> implements
        List<T>, Cloneable, Serializable {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Double linked node definition
     * @param <T> Generic type of list data
     */
    private static final class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        //add other methods if you like: Setters & Getter??
    }

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        checkPositionIndex(index);
        return new DoublyLinkedListIterator(index);
    }

    @Override
    public int size() {
        return this.size;
    }
    public void checkPositionIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", actual size: " + size);
        }
    }
    public void checkElementIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", actual size: " + size);
        }
    }
    public void add(int index, T o){
        checkPositionIndex(index);
        if(index == 0){
            addFirst(o);

        }
        else if(index == size){
            addLast(o);
        }
        else if(index > 0 || index < size){
            add(index, o, this.head);
            size ++;
        }





    }

    private void add(int index, T o, Node<T> prev) {
        Node<T> newNode = new Node(o);
        if(index == 0){
            newNode.next = prev.next;
            prev.next.prev = newNode;
            prev.next = newNode;
            newNode.prev = prev;
        }else{
            add(index-1, o, prev.next);
        }

    }

    public void addFirst(T o){
        Node<T> newNode = new Node(o);
        size ++;
        newNode.next = head;
        if(this.head == null){
            tail = newNode;
        }else{
            head.prev = newNode;
        }
        head = newNode;
    }
    public void addLast(T o){
        Node<T> newNode = new Node<>(o);
        if(tail == null){
            head = newNode;
        }else{
            newNode.prev = tail;
        }
        tail = newNode;
        size++;

    }
    public T get(int index) {
        checkElementIndex(index);
        if(index == 0){
            return head.data;
        }else{
            return get(index, this.head);
        }
    }

    private T get(int index, Node<T> n) {
        if(index == 0){
            return n.data;
        }else{
            return get(index - 1, n.next);
        }
    }
    public T remove(int index){
        if(index == 0){
            return removeFirst();
        }
        if(index == size -1){
           return removeLast();
        }{
            return remove(index,this.head);
        }
    }

    private T remove(int index, Node<T> node) {
        checkElementIndex(index);

        if(index == 0){
            Node<T> curr = node;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return curr.data;
        }else{
            return remove(index-1,node.next);
        }
    }

    private T removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();

        Node<T> curr = head;
        head = curr.next;
        if(size == 1){
            tail = null;
        }
        else{
            curr.next.prev = null;
        }
        curr.prev = null;
        size--;
        return curr.data;

    }
    private T removeLast(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        Node<T> curr = tail;
        if(size == 1){
            head = null;
            tail = null;
        }else{
            curr.prev.next = null;
            curr.prev = null;
        }
        size--;
        return curr.data;
    }
    public boolean addAll(int index, Collection<? extends T> c){
        boolean modify = false;
        checkPositionIndex(index);
        if(c.size() == 0){
            return modify;
        }
        Object[] o = c.toArray();
        for(Object ob: o){
            T t = (T) ob;
            this.add(index,t);
            index++;
        }
        modify = true;

        return modify;
    }

    public void push(T value){
        addFirst(value);
    }
    public T pop(){
       return removeFirst();
    }

    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }
        else{
            return "[" + toString(this.head);
        }

    }
    private String toString(Node node){
        String result = "";
        if(node.next == null){
            return node.data + "]";
        }else{
            String s = node.data + ", ";
            return s + this.toString(node.next);
        }

    }

    private class DoublyLinkedListIterator implements ListIterator<T>{
        private Node<T> prev;
        private Node<T> curr;
        private Node<T> latestReturn;
        private int nextIndex;

        public DoublyLinkedListIterator(int index){
            prev = null;
            curr = null;
            nextIndex = 0;


        }

        @Override
        public boolean hasNext() {
            if(curr == null){
                return head != null;
            }
            return curr.next != null;
        }

        @Override
        public T next() {
            if(!this.hasNext()){
                throw new NoSuchElementException();
            }
            if (curr == null){
                curr = head;
            }else{
                curr = curr.next;
            }
            latestReturn = curr;
            nextIndex++;
            return latestReturn.data;
        }

        @Override
        public boolean hasPrevious() {
            return curr != null;
        }

        @Override
        public T previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            latestReturn = curr;
            if(curr.prev == null){
                curr = null;
            }else{
                curr = curr.prev;
            }
            return latestReturn.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {


        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }




}

