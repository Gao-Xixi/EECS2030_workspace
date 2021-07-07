public abstract class PureBreed extends Dog{
    private String breed;

    public PureBreed(String breed) {
        super();
        this.breed = breed;
    }

    public PureBreed(int size, int energy, String breed) {
        super(size, energy);
        this.breed = breed;
    }

    @Override
    String getBreed() {
        return breed;
    }
}
