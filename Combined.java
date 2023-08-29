import java.util.*;

public class Combined{

    public static void main(String[] args) {
        String[] arr = {"0", "1"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the choice:");
        int choice = sc.nextInt();
        if(choice == 1) {
            System.out.println("Enter the length:");
            int length = sc.nextInt();
             for (int i = 0; i <= length; i++) {
            generateStrings(arr, "", arr.length, i);
        }
        } else if(choice == 2) {
            System.out.println("Enter the first length:");
            int firstLength = sc.nextInt();
            System.out.println("Enter the second length:");
            int secondLength = sc.nextInt();
            for (int i = firstLength; i <= secondLength; i++) {
            generateStrings(arr, "", arr.length, i);
        }
        } else {
            System.out.println("Invalid choice");
        }
        sc.close();
    }

    public static void generateStrings(String[] arr, String currentString, int n, int length) {
        if (length == 0) {
            if (acceptsAlternating01(currentString)) {
                System.out.println("Accepted");
            } else {
                System.out.println("Rejected");
            }
            System.out.println(currentString);
            return;
        }
        for (int i = 0; i < n; i++) {
            String newString = currentString + arr[i];
            generateStrings(arr, newString, n, length - 1);
        }
    }
    public static boolean acceptsAlternating01(String input) {
        int state = 0;  // Initial state

        for (char c : input.toCharArray()) {
            switch (state) {
                case 0:
                    if (c == '0') state = 1;
                    else if (c == '1') state = 2;
                    break;
                case 1:
                    if (c == '0') state = -1;
                    else if (c == '1') state = 0;
                    break;
                case 2:
                    if (c == '0') state = 0;
                    else if (c == '1') state = -1;
                    break;
                case -1:
                    return false; 
            }
        }

        return state+1>0; // Accepted if final state is 0
    }

}
