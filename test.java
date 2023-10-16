public class test {
    public static void main(String[] args) {
        Package p = new Package("bubs", 0.5, 5, false, "bubba", "bobby");
        StackInterface<Package> si = new StackRA<>();
        Bag<Package> b = new Bag<>(si);
        b.addItem(p);
        System.out.println(b);
    }
}
