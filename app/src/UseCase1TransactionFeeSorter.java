import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp; // simple string for demo

    public Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + " (fee=" + fee + ", ts=" + timestamp + ")";
    }
}

public class UseCase1TransactionFeeSorter {

    // 🔹 Bubble Sort (by fee ascending)
    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        int swaps = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    // swap
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early termination
        }

        System.out.println("Bubble Sort Result: " + list);
        System.out.println("Total swaps: " + swaps);
    }

    // 🔹 Insertion Sort (by fee + timestamp)
    public static void insertionSort(List<Transaction> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            // Compare fee first, then timestamp (stable)
            while (j >= 0 && compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Result: " + list);
    }

    // 🔹 Comparator logic (fee + timestamp)
    private static int compare(Transaction t1, Transaction t2) {
        if (t1.fee != t2.fee) {
            return Double.compare(t1.fee, t2.fee);
        }
        return t1.timestamp.compareTo(t2.timestamp);
    }

    // 🔹 High-fee outliers (>50)
    public static void findOutliers(List<Transaction> list) {
        System.out.println("High-fee outliers (>50):");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        // 🔹 Bubble Sort (small batch)
        List<Transaction> bubbleList = new ArrayList<>(transactions);
        bubbleSort(bubbleList);

        // 🔹 Insertion Sort (medium batch)
        List<Transaction> insertionList = new ArrayList<>(transactions);
        insertionSort(insertionList);

        // 🔹 Outliers
        findOutliers(transactions);
    }
}