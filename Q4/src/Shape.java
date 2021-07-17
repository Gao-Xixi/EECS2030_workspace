import java.util.UUID;

/**
 * superclass of Triangle and Rectangle
 * having a abstract method
 */
public abstract class Shape implements Comparable {
    UUID id;

    /**
     * Get the ID of the property
     *
     * @return the UUID of the property
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set the ID of the property
     *
     * @param id the UUID of the property
     */
    public void setId(UUID id) {
        this.id = id;
    }

    public abstract double perimeter();

    /**
     * Array sorted by uuid
     * @param o other object
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        return this.id.compareTo(((Shape) o).id);
    }
}
