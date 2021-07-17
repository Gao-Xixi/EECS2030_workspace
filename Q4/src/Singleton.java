import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class Singleton{

    //only one constructor ... private default constructor ... why?: avoid public instantiation
    private Singleton() { }

    public final static int MAX_CACHE_SIZE = 20;

    //static instance of the class
    private static volatile Singleton instance = null;

    //underlying list object to store shapes
    private static ArrayList<Shape> list;

    /**
     * getInstance to get a reference to the singleton class
     * @return the Singleton that allows caching the Shape s
     */
    public static Singleton getInstance()
    {
        //if instance is created, no need to creat a new one
        if (null == instance)
        {
            //double clutching to assure no issues with other threads
            synchronized (Singleton.class)
            {
                if (null == instance)
                {
                    instance = new Singleton();
                    list = new ArrayList<>();
                }
            }
        }
        return instance;
    }

    /**
     * Using ArrayList to store shape
     * if id of shape already stored, return
     * else add shape in list(if size() < MAX_CACHE_SIZE
     * @param shape object
     */
    public void add(Shape shape)
    {
        boolean inList = false;
        for(Shape s : list){
            if(shape.id == s.id){
                inList = true;
            }
        }
        if (inList) return;
        if(list.size() < MAX_CACHE_SIZE){
            list.add(shape);
        }
    }



}
