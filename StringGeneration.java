import java.util.Scanner;

public class StringGeneration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first length:");
        int firstLength = sc.nextInt();
        System.out.println("Enter the second length:");
        int secondLength = sc.nextInt();
        String[] arr = {"0", "1"};
        for (int i = firstLength; i <= secondLength; i++) {
            generateStrings(arr, "", arr.length, i);
        }
    }

    public static void generateStrings(String[] arr, String currentString, int n, int length) {
        if (length == 0) {
            System.out.println(currentString);
            return;
        }
        for (int i = 0; i < n; i++) {
            String newString = currentString + arr[i];
            generateStrings(arr, newString, n, length - 1);
        }
    }
}
