import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combined {
    public static void generateStrings(String characters, int minLength, int maxLength, String current, List<String> result) {
        if (minLength <= 0) {
            result.add(current);
        }
        if (minLength <= maxLength) {
            for (char c : characters.toCharArray()) {
                generateStrings(characters, minLength - 1, maxLength, current + c, result);
            }
        }
    }

    public static boolean acceptsEqualZerosOnes(String input) {
        int state = 0;  // Initial state

        for (char c : input.toCharArray()) {
            switch (state) {
                case 0:
                    if (c == '0') state = 1;
                    else if (c == '1') state = 2;
                    break;
                case 1:
                    if (c == '0') state = 0;
                    else if (c == '1') state = 3;
                    break;
                case 2:
                    if (c == '0') state = 3;
                    else if (c == '1') state = 0;
                    break;
                case 3:
                    if (c == '0') state = 2;
                    else if (c == '1') state = 1;
                    break;
            }
        }

        return state == 0;  // Accepted if final state is 0
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum length for generated strings: ");
        int minLength = scanner.nextInt();

        System.out.print("Enter maximum length for generated strings: ");
        int maxLength = scanner.nextInt();

        List<String> generatedStrings = new ArrayList<>();
        generateStrings("01", minLength, maxLength, "", generatedStrings);

        System.out.println("Generated strings:");
        for (String s : generatedStrings) {
            if (acceptsEqualZerosOnes(s)) {
                System.out.println(s + " (Accepted)");
            } else {
                System.out.println(s + " (Rejected)");
            }
        }

        scanner.close();
    }
}