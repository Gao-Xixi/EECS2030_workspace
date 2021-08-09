import java.util.*;

public class Singleton {

    public class SortSchema{
        enum SortField{
            UUID, AREA, PERIMETER
        }

    }
    private static volatile Singleton instance = null;
    private static Map<UUID, SimpleShape> map;
    private static Map<UUID, SimpleShape> cache;
    private static final int MAX_CACHE_SIZE = 200;

    private SortSchema.SortField sortSchemaField = SortSchema.SortField.UUID;
    public SortSchema.SortField getSortSchemaField() {
        return sortSchemaField;
    }
    public synchronized void setSortSchemaField(SortSchema.SortField sortSchemaField) {
        this.sortSchemaField = sortSchemaField;
    }
    private Singleton(){
    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null) {
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
    public List<SimpleShape> shapeStorageSort(){
        return cache.values().stream().sorted().toList();
    }
    public void shapeStoragePut(UUID id, SimpleShape record){
        cache.put(id,record);
    }
    public SimpleShape shapeStorageGet(UUID uuid){
        return cache.getOrDefault(uuid,null);
    }
}
