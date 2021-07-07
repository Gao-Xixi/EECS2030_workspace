public class Komondor extends PureBreed implements Bark{
    private final String BREED =  "komondor";
    private static int numKomondorCreated = 0;


    public Komondor() {
        super("komondor");
        numKomondorCreated ++;
    }

    public static int getNumKomondorCreated() {
        return numKomondorCreated;
    }

    public Komondor(int size, int energy)   {
        super(size, energy, "komondor");
        numKomondorCreated ++;
    }

    @Override
    public void bark() {
        System.out.println("wo wo!");
    }
}
