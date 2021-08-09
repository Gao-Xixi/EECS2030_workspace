import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    public void test_add(){
        DoublyLinkedList<String> list1 = new DoublyLinkedList();
        list1.addFirst("ccc");
        System.out.println(list1.get(0));
        list1.add(0,"aaa");
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        list1.add(1,"bbb");
        list1.addFirst("ccc");
        System.out.println(list1.toString());
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));

    }

    @Test
    public void test_remove(){
        DoublyLinkedList<String> list1 = new DoublyLinkedList();
        list1.addFirst("ccc");
        list1.add(0,"aaa");
        list1.add(1,"bbb");
        list1.addFirst("ccc");
        System.out.println(list1.toString());
        list1.remove(1);
        System.out.println(list1.toString());
        list1.remove(0);
        list1.remove(3);
        System.out.println(list1.toString());
    }
    @Test
    public void test_stack(){
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList();
        list1.push(1);
        list1.push(2);
        list1.push(3);
        list1.push(4);
        System.out.println(list1.toString());
        System.out.println(list1.pop());
        System.out.println(list1.pop());
        System.out.println(list1.toString());

    }
    @Test
    public void test_addAll_middle(){
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList();
        list1.push(1);
        list1.push(2);
        list1.push(3);
        list1.push(4);
        Collection<Integer> c = new ArrayList<>();
        c.add(5);c.add(6);c.add(7);c.add(8);
        list1.addAll(1,c);
        System.out.println(list1);
        System.out.println(list1.size());
    }
    @Test
    public void test_addAll_front(){
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList();
        list1.push(1);
        list1.push(2);
        list1.push(3);
        list1.push(4);
        Collection<Integer> c = new ArrayList<>();
        c.add(5);c.add(6);c.add(7);c.add(8);
        list1.addAll(0,c);
        System.out.println(list1);
        System.out.println(list1.size());
    }
}