import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
public class test {
    @org.junit.jupiter.api.Test
    public void test_serializable(){
        LinkedList sample = new LinkedList();
        sample.addAll(Arrays.asList("1 apple", "2 banana", "3 cranberry"));
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.ser"));
            oos.writeObject(sample);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("file.ser"));
            LinkedList list = (LinkedList) is.readObject();
            System.out.println(list);
            is.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
