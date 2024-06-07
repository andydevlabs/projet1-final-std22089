package andy.dev.labs.affirmation;

import java.util.ArrayList;
import java.util.List;

public class AffirmationProcessor {
    private static final Affirmation louEstBeau = new Truth("Lou est beau");
    private static final Affirmation louEstPauvre = new Lie("Lou est pauvre");
    private static final Affirmation louEstGeneroux = new BasicAffirmation("Lou est généreux");

    public static void process(String input) {
        // Split the input into individual affirmations
        String[] affirmations = input.split("\\.");

        // List to store the parsed BasicAffirmation objects
        List<Affirmation> affirmationList = new ArrayList<>();

        // Flag to track the keyword in the input
        String keyword = "";

        // Iterate through each affirmation
        for (String affirmation : affirmations) {
            affirmation = affirmation.trim(); // Remove leading and trailing spaces

            if (affirmation.contains(" ou ")) {
                keyword = " ou ";
                String[] parts = affirmation.split(" ou ");
                for (String part : parts) {
                    affirmationList.add(parseAffirmation(part.trim()));
                }
            } else if (affirmation.contains(" donc ") || affirmation.contains(" Donc ")) {
                keyword = " donc ";
                String[] parts = affirmation.split(" donc | Donc ");
                for (String part : parts) {
                    affirmationList.add(parseAffirmation(part.trim()));
                }
            } else if (affirmation.contains(" et ")) {
                keyword = " et ";
                String[] parts = affirmation.split(" et ");
                for (String part : parts) {
                    affirmationList.add(parseAffirmation(part.trim()));
                }
            } else {
                affirmationList.add(parseAffirmation(affirmation));
            }
        }

        // Determine the outcome based on the keyword
        String result;
        switch (keyword) {
            case " ou ":
                result = AffirmationChecker.ou(affirmationList);
                break;
            case " donc ":
                result = AffirmationChecker.donc(affirmationList);
                break;
            case " et ":
                result = AffirmationChecker.et(affirmationList);
                break;
            default:
                // Default to 'et' if no keyword is found
                result = AffirmationChecker.et(affirmationList);
                break;
        }

        System.out.println(result);
    }

    private static Affirmation parseAffirmation(String input) {
        return switch (input.trim()) {
            case "Lou est beau" -> louEstBeau;
            case "Lou est pauvre" -> louEstPauvre;
            case "Lou est généreux" -> louEstGeneroux;
            default -> new BasicAffirmation(input);
        };
    }

    public static void main(String[] args) {
        // Test inputs
        String input1 = "Lou est beau ou Lou est généreux. Donc Lou est pauvre.";
        String input2 = "Lou est beau ou Lou est généreux";
        String input3 = "Lou est pauvre. Donc Lou est généreux.";

        // Process the test inputs
        process(input1); // Expected output: "false"
        process(input2); // Expected output: "true"
        process(input3); // Expected output: "false"
    }
}