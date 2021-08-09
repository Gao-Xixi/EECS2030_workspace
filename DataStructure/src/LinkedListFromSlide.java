import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class LinkedListFromSlide<T> implements Cloneable, Serializable{
    private int size;
    private Node<T> head;



    public int size() {
        return this.size;
    }



    private static class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListFromSlide(){
        this.size = 0;
        this.head = null;
    }

    public void add(T data){
        if(this.size == 0){
            this.head = new Node(data);
        }else{
            this.add(data, this.head);
        }
        this.size++;

    }
   private void add(T data, Node<T> node){
        if(node.next == null){
            node.next = new Node(data);
        }else{
            this.add(data, node.next);
        }
    }
    public T get(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + "Size" + size);
        }else {
            return get(index, this.head);
        }
    }
    private T get(int index, Node<T> node) {
        if (index == 0) {
            return this.head.data;
        } else {
            return get(index - 1, node.next);
        }
    }
    public void set(int index, T data){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + "Size" + size);
        }
        set(index, data, this.head);

    }
    private void set(int index, T data, Node<T> node){
        if (index == 0) {
            node.data = data;
        } else {
            set(index - 1, data, node.next);
        }
    }

    public boolean contains(T data){
        if(this.size == 0){
            return false;
        }
        else{
            return contains(data, this.head);
        }
    }
    private boolean contains(T data, Node<T> node){
        if(data.equals(node.data)){
            return true;
        }
        if(node.next == null){
            return false;
        }
        else{
            return contains(data, node.next);
        }
    }
    public int indexOf(T data){
        if(this.size == 0){
            return -1;
        }
        else{
            return indexOf(data, this.head);
        }
    }
    private int indexOf(T data, Node<T> node){
        int result = -1;
        if(data.equals(node.data)){
            return result + 1;
        }
        if(node.next == null){
            return -1;
        }else{
           return result + 1 + indexOf(data, node.next);
        }
    }

    private void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    /**
     * a little bit hard !!! mention
     * forgeot prev.next
     * @param index
     * @param data
     */
    public void add(int index, T data){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + "Size" + size);
        }
        if(index == 0){
            addFirst(data);    // addFirst already plus the size!!!!
        }else{
            add(index -1 ,data, this.head);
            size++;
        }


    }

    private void add(int index, T data, Node<T> prev){
        if(index == 0){
            Node<T> newNode = new Node<>(data);
            newNode.next = prev.next;
            prev.next = newNode;

        }else{
            add(index -1 , data , prev.next);
        }
    }


    public T removeFirst(){
        if(this.size == 0){
            throw new NoSuchElementException();
        }
        Node<T> curr = this.head;
        this.head = curr.next;
        curr.next = null;
        size--;
        return curr.data;

    }

    public T remove(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Index: " + index + "Size" + size);
        }
        if(index == 0){
            return removeFirst();
        }
        else{
            T result =  remove(index-1,this.head);
            this.size--;
            return result;
        }

    }



    private T remove(int index, Node<T> prev){
        Node<T> curr = prev.next;
        if(index == 0){
            prev.next = curr.next;
            curr.next = null;
            return curr.data;
        }else{
            return remove(index-1,prev.next);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LinkedListFromSlide<T> clone = (LinkedListFromSlide<T>)super.clone();
        clone.head = null;
        clone.size = 0;
        for(Node<T> x = head; x != null;x = x.next){
            clone.add(x.data);
        }
        return clone;
    }

    @Override
    public String toString() {
        String result = "[";
        if(this.size == 0){
            return "[]";
        }else {
            return "[" + toString(this.head);
        }

    }
    public Iterator<T> iterator(){
        LinkedListFromSlideIterator it = new LinkedListFromSlideIterator();
        return it;
    }
    public Iterator<T> iterator(int index) {
        LinkedListFromSlideIterator it = new LinkedListFromSlideIterator();
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        for(int i = -1;i < index; i++){
            it.next();
        }
        return it;
    }

    private String toString(Node<T> node) {
        String result = "";
        if (node.next == null) {
            return node.data + "]";
        } else {
            result += node.data + ",";
            result += toString(node.next);
        }

        return result;
    }
    private class LinkedListFromSlideIterator<T> implements Iterator<T>{
        private Node<T> prev;
        private Node<T> curr;


        public LinkedListFromSlideIterator(){
            prev = null;
            curr = null;

        }

        @Override
        public boolean hasNext() {
            if(curr == null) {
                return head != null;
            }else
                return curr.next != null;
        }

        @Override
        public T next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            prev = curr;
            if(this.curr == null) {
                this.curr = (Node<T>) head;
            }else {
                this.curr = curr.next;
            }
            return curr.data;
        }

        @Override
        public void remove() {
            if(this.prev == this.curr){
                throw new IllegalArgumentException();
            }
            if(this.curr == head){
                curr = curr.next;
            }
            else{
                prev.next = this.curr.next;
            }
            this.curr = this.prev;
            size--;
        }

    }



    public static void main(String[] args) throws CloneNotSupportedException {
        LinkedListFromSlide<Character> list = new LinkedListFromSlide();
        list.add('a');
        list.add('b');
        list.add('c');
        System.out.println(list);
        list.remove(2);
        list.add(1,'2');
        list.addFirst('0');
        list.addFirst('0');
        list.removeFirst();
        System.out.println(list);
        list.get(1);
        list.indexOf('a');
        list.set(0,'1');
        System.out.println(list);
        System.out.println(list.contains('b'));
        System.out.println(list.contains('c'));

        LinkedListFromSlide<Character> list2 = (LinkedListFromSlide<Character>) list.clone();
        System.out.println(list2);

        System.out.println(list2.iterator(0).next());
        }




    }





