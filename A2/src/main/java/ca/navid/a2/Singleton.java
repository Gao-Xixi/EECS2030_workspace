package ca.navid.a2;
import java.util.*;

/**
 * To be complete by students for caching layer
 * A Singleton pattern for cache mechanism
 */
public class Singleton {
    // static attribute
    private static Map<UUID, MultipleListingService> cacheMap;
    // static volatile of class
    private static volatile Singleton instance = null;


    /**
     * one constructor
     * initialize cacheMap
     */
    private  Singleton() {
        cacheMap = new HashMap<>();

    }

    /**
     * Lazy initialization
     * getInstance to get a reference to the singleton class
     * @return the Singleton that cacheMap != null
     */
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    /**
     * add new <key, value> to the cache memory
     * synchronized
     * @param uuid
     * @param record
     */
    public static void addCache(UUID uuid, MultipleListingService record) {
        synchronized (Singleton.class){
            cacheMap.put(uuid,record);
        }
    }

    /**
     * remove from the cache memory
     * @param uuid
     */
    public static void removeCacheData(UUID uuid){
        synchronized (Singleton.class) {
            cacheMap.remove(uuid);
        }
    }

    /**
     * To test whether the Singleton Class works, we can check the size of the cache
     * @return the size of the cacheMap
     */
    public static int getSize(){
        synchronized (Singleton.class) {
            return cacheMap.size();
        }
    }

    /**
     * given the key: uuid, return the value:MultipleListingService m
     * @param uuid
     * @return value: MultipleListingService m
     */
    public static MultipleListingService getMls(UUID uuid) {
        synchronized (Singleton.class) {
            MultipleListingService m =  cacheMap.get(uuid);

            if (m == null)
                return null;
            else {
                return m;
            }
        }

    }
}




