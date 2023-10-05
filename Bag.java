public class Bag<T> {

    private int units;
    private double totalWeight;
    private StackInterface<T> collection;

    public Bag(StackInterface<T> collection) {
        this.units = 0;
        this.totalWeight = 0;
        this.collection = collection;
    }

    public void setUnits(int units) {
        this.units = 0;
    }

    public void setDouble(double totalWeight) {
        this.totalWeight = 0;
    }

    public void setCollection(StackInterface<T> collection) {
        this.collection = collection;
    }

    public int getUnits() {
        return units;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public StackInterface<T> getCollection() {
        return collection;
    }

    public void addItem(T item) {
        collection.push(item);
        totalWeight += ((Sample)item).getWeight();
    }

    public T popItem() {
        T item = collection.pop();
        totalWeight -= ((Sample)item).getWeight();
        return item;
    }

    public String toString() {
        return String.format("Number of units: %d"
                +"Weight: %.2f"
                +"Items: %s",
                units, totalWeight, collection.toString());
    }

}