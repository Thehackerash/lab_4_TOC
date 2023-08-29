
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringGeneration {
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
    public static void main(String[] args) {
        String characters = "P*";
        int minLength, maxLength;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum length: ");
        minLength = scanner.nextInt();

        System.out.print("Enter maximum length: ");
        maxLength = scanner.nextInt();

        scanner.close();

        List<String> generatedStrings = new ArrayList<>();
        generateStrings(characters, minLength, maxLength, "", generatedStrings);

        System.out.println("Generated strings:");
        for (String s : generatedStrings) {
            System.out.println(s);
        }
    }
}