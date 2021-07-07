public abstract class Dog {
    private int size;
    private int energy;
    static protected int numCreated = 0;

    public Dog(){
        this(5,5);
        numCreated++;
    }
    public Dog(int size, int energy) {
        this.size = size;
        this.energy = energy;
        numCreated++;
    }

    public int getSize() {
        return size;
    }


    /**
     * final keyword means this method cannot be overrided.
     * final class means cannot be extended.
     * @param size
     */
    public final void setSize(int size) {
        this.size = size;
    }

    public int getEnergy() {
        return energy;
    }

    public static int getNumCreated() {
        return numCreated;
    }

    public static void setNumCreated(int numCreated) {
        Dog.numCreated = numCreated;
    }

    public final void setEnergy(int energy) {
        this.energy = energy;
    }
    abstract String getBreed();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return size == dog.size && energy == dog.energy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getEnergy();
        result = prime * result + this.getSize();
        return result;
    }

    @Override
    public String toString() {
        String s =
                "age=" + size +
                ", energy=" + energy;
        return s;
    }

}
