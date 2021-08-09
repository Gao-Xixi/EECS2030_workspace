import java.util.*;

/**
 * Singleton object used to contain immediate cache need (JVM scope)
 * To be complete by students for caching layer
 */
public class Singleton {

    public class SortSchema {
        enum SortField { UUID, AREA, PERIMETER }
    }

    //only one constructor ... private default constructor ... why?: avoid public instantiation
    private Singleton() { }

    public final static int MAX_CACHE_SIZE = 200;

    //static instance of the class
    private static volatile Singleton instance = null;

    //underlying map object
    private static Map<UUID, SimpleShape> map;
    private static Map<UUID, SimpleShape> cache;
    private SortSchema.SortField sortSchemaField = SortSchema.SortField.UUID;

    public SortSchema.SortField getSortSchemaField() {
        return sortSchemaField;
    }

    public synchronized void setSortSchemaField(SortSchema.SortField sortSchemaField) {
        this.sortSchemaField = sortSchemaField;
    }



    /**
     * getInstance to get a reference to the singleton class
     * @return the Singleton that allows caching the MLS records
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
                    map = new LinkedHashMap<>() {
                        @Override
                        protected boolean removeEldestEntry(final Map.Entry old) {
                            return size() > MAX_CACHE_SIZE;
                        }
                    };
                    cache = Collections.synchronizedMap(map);
                }
            }
        }
        return instance;
    }

    /**
     * Put a MLS record in the cache
     * @param id UUID of the MLS record
     * @param record the actual MLS record
     */
    public void shapeStoragePut(UUID id, SimpleShape record)
    {
        cache.put(id, record);
    }


    public List<SimpleShape> shapeStorageSort()
    {
        return cache.values().stream().sorted().toList();
    }


    /**
     * Cache lookup and get operation
     * @param id UUID of the record to be looked up and fetched.
     * @return the actual MLS record and null of not found in cache.
     */
    public SimpleShape shapeStorageGet(UUID id)
    {
        SimpleShape record = cache.getOrDefault(id, null);
        return record;
    }
}
