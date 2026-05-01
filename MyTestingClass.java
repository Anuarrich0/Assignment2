import java.util.Random;

public class MyTestingClass {

    private String name;
    private int id;

    public MyTestingClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        int prime = 31;
        for (int i = 0; i < name.length(); i++) {
            hash = hash * prime + name.charAt(i);
        }
        hash = hash * prime + id;
        return Math.abs(hash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return this.id == other.id && this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}

class Student {
    private String firstName;
    private int grade;

    public Student(String firstName, int grade) {
        this.firstName = firstName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return firstName + " grade=" + grade;
    }
}

class TestMain {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        Random random = new Random();
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve",
                          "Frank", "Grace", "Henry", "Ivy", "Jack"};

        for (int i = 0; i < 10000; i++) {
            String name = names[random.nextInt(names.length)];
            int id = random.nextInt(100000);
            MyTestingClass key = new MyTestingClass(name, id);
            Student value = new Student(name, random.nextInt(100));
            table.put(key, value);
        }

        System.out.println("Total elements: " + table.getSize());
        System.out.println("\nElements per bucket:");
        table.printBucketSizes();
    }
}
