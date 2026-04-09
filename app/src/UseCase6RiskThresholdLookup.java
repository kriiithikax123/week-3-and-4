import java.util.*;

public class UseCase6RiskThresholdLookup {

    // 🔹 Linear Search (unsorted)
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear: Not Found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    // 🔹 Binary Search Floor (largest ≤ target)
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Floor Comparisons: " + comparisons);
                return arr[mid];
            } else if (arr[mid] < target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Floor Comparisons: " + comparisons);
        return result;
    }

    // 🔹 Binary Search Ceiling (smallest ≥ target)
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Ceiling Comparisons: " + comparisons);
                return arr[mid];
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                result = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Ceiling Comparisons: " + comparisons);
        return result;
    }

    // 🔹 Insertion Point (lower_bound)
    public static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};
        int target = 30;

        // 🔹 Linear Search
        linearSearch(risks, target);

        // 🔹 Floor & Ceiling
        int floorVal = floor(risks, target);
        int ceilVal = ceiling(risks, target);

        System.out.println("Floor(" + target + "): " + floorVal);
        System.out.println("Ceiling(" + target + "): " + ceilVal);

        // 🔹 Insertion Point
        int index = insertionPoint(risks, target);
        System.out.println("Insertion Index: " + index);
    }
}
