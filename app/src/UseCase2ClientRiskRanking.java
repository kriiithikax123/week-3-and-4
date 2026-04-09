import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + "(" + riskScore + ")";
    }
}

public class UseCase2ClientRiskRanking {

    // 🔹 Bubble Sort (Ascending by riskScore)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Ascending): " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    // 🔹 Insertion Sort (Descending by riskScore + accountBalance)
    public static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (Descending): " + Arrays.toString(arr));
    }

    // 🔹 Comparator: riskScore DESC, then accountBalance DESC
    private static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return c1.riskScore - c2.riskScore;
        }
        return (int)(c1.accountBalance - c2.accountBalance);
    }

    // 🔹 Top 10 highest risk clients
    public static void printTopClients(Client[] arr, int k) {
        System.out.println("Top " + k + " High Risk Clients:");
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
            new Client("clientC", 80, 2000),
            new Client("clientA", 20, 5000),
            new Client("clientB", 50, 3000)
        };

        // 🔹 Bubble Sort
        Client[] bubbleArr = clients.clone();
        bubbleSort(bubbleArr);

        // 🔹 Insertion Sort
        Client[] insertionArr = clients.clone();
        insertionSort(insertionArr);

        // 🔹 Top clients
        printTopClients(insertionArr, 10);
    }
}
