package HashTable;
import java.util.LinkedList;
import java.util.Scanner;

class HashTable {
    static class Pair {
        private int key; // key=roll
        private String value; // value=name

        public Pair() {
            key = 0;
            value = "";
        }

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "pair [key = " + key + "  value = " + value + "]";

        }
    }

    private static final int SLOTS = 10;
    public LinkedList<Pair> table[]; // creating array of linkedList inside it store refrance of linkedList
    // initially by empty LinkedList Object

    // hash function
    public int hash(int key) {
        return key % SLOTS;
    }

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[SLOTS];
        for (int i = 0; i < SLOTS; i++) {
            table[i] = new LinkedList<>();
        }

    }

    public void put(int key, String value) {
        // first check ther is key present or not if present then only replace that
        // value
        // find slot for given key using hash function
        int slot = hash(key);
        // access the bucket (linked list) in that slot
        LinkedList<Pair> bucket = table[slot];
        // find the element (key value) in that bucket -- linear search
        for (Pair pair : bucket) {
            // if key is duplicated replace value
            if (key == pair.key) {
                pair.value = value;
                return;
            }

        }
        // if key not fount , create new pair
        Pair pair = new Pair(key, value);
        bucket.add(pair);
        System.out.println("Added:"+pair);
        return;

    }

    public String get(int key) {
        // find slot for given key using hash function
        int slot = hash(key);
        // access the bucket (linked list) in that slot
        LinkedList<Pair> bucket = table[slot];
        // find the element (key value) in that bucket -- linear search
        for (Pair pair : bucket) {
            if (key == pair.key)
                return pair.value;
        }
        // if key not fount
        return null;

    }

}

public class HashTableMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable ht = new HashTable();
        ht.put(1, "Nilesh");
        ht.put(4, "Mahesh");
        ht.put(8, "Ganesh");
        ht.put(5, "Suyash");
        ht.put(21, "Nitesh");
        ht.put(24, "Aavesh");
        ht.put(34, "swarup");
        ht.put(1, "Mangesh");

        System.out.println("enter roll no to find:");
        int roll = sc.nextInt();

        String name = ht.get(roll);
        System.out.println(name);

        sc.close();
    }

}
