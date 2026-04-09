import java.util.*;

public class UseCase5AccountIdLookup {

    // 🔹 Linear Search (first occurrence)
    public static int linearSearchFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Found at index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not Found (Linear First)");
        return -1;
    }

    // 🔹 Linear Search (last occurrence)
    public static int linearSearchLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last Found at index: " + index);
        System.out.println("Comparisons: " + comparisons);
        return index;
    }

    // 🔹 Binary Search (find one occurrence)
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Found at index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not Found (Binary)");
        return -1;
    }

    // 🔹 Count occurrences using Binary Search
    public static int countOccurrences(String[] arr, String target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1) return 0;
        return last - first + 1;
    }

    private static int findFirst(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static int findLast(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // 🔹 Linear Search
        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        // 🔹 Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // 🔹 Binary Search
        binarySearch(logs, "accB");

        // 🔹 Count occurrences
        int count = countOccurrences(logs, "accB");
        System.out.println("Count of accB: " + count);
    }
}