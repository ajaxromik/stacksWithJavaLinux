public class Bag<T> {

    private int units;
    private double weight;
    private StackInterface<T> packages;

    public Bag() {

    }

    public Bag(StackInterface<T> packages) {
        this.packages = packages;
    }

}