import java.util.Scanner;

public class EqualAltDfa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        if (acceptsAlternating01(input)) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
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
