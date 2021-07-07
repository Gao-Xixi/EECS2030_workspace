import java.util.ArrayList;
import java.util.Objects;

//final class means cannot be extended.
public final class Mix extends Dog{
    private ArrayList<String> breeds;
//    same attribute name as superclass, causing attribute hiding
//    static protected int numCreated = 0;
    private static int numMixCreated = 0;
    public Mix() {
        super();
        this.breeds = new ArrayList<>();
        numMixCreated ++;
    }

    public Mix(int age, int energy) {
        super(age, energy);
        this.breeds = new ArrayList<>();
        numMixCreated ++;
    }

    /**
     * If a subclass declares a static method with the same name as a superclass static method,
     * we say that the subclass static method hides the superclass static method.
     *
     * You cannot override a static method, you can only hide it◦
     * Hiding static methods is considered bad form because it makes code hard to read and understand
     * @return
     */
    public static int getNumMixCreated() {
        return numMixCreated;
    }

    @Override
    String getBreed() {
        if(  this.breeds.isEmpty()) {
             return "mix of unknown breeds";    }
        StringBuffer b = new StringBuffer();
        b.append("mix of");
        for(String breed : this.breeds)
        {b.append(" " + breed);     }
        return b.toString();
    }

    public Mix(int age, int energy, ArrayList<String> breeds) {
        super(age, energy);
        this.breeds = new ArrayList<>(breeds);
    }

    @Override
    public boolean equals(Object o) {
        if(super.equals(o)){
            Mix mix = (Mix) o;
            return this.breeds.size() ==  mix.breeds.size()
                    && this.breeds.containsAll(mix.breeds);
        }
        return false;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + this.breeds.hashCode();
        return result;
    }

    /**
     * StringBuffer is a peer class of String
     * @return
     */
    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();
        b.append(super.toString());
        for(String s : this.breeds){
            b.append(" " + s);
        }
        b.append(" mix");
        return b.toString();
    }
}
