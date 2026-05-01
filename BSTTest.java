public class BSTTest {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "five");
        tree.put(3, "three");
        tree.put(7, "seven");
        tree.put(1, "one");
        tree.put(4, "four");
        tree.put(6, "six");
        tree.put(9, "nine");

        System.out.println("Size: " + tree.size());
        System.out.println("get(3): " + tree.get(3));
        System.out.println("get(9): " + tree.get(9));
        System.out.println("get(10): " + tree.get(10));

        System.out.println("\nIn-order traversal:");
        for (var elem : tree.iterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        tree.delete(3);
        System.out.println("\nAfter deleting key=3, size: " + tree.size());

        for (var elem : tree.iterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
