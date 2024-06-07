package andy.dev.labs.affirmation;

import java.util.List;

public class AffirmationChecker {
    public static String et(List<Affirmation> affirmations) {
        for (Affirmation affirmation : affirmations) {
            if (affirmation instanceof Lie) {
                return "false";
            }
        }
        return "true";
    }

    public static String ou(List<Affirmation> affirmations) {
        for (Affirmation affirmation : affirmations) {
            if (affirmation instanceof Truth) {
                return "true";
            }
        }
        return "false";
    }

    public static String donc(List<Affirmation> affirmations) {
        boolean firstIsTruth = !affirmations.isEmpty() && affirmations.getFirst() instanceof Truth;
        boolean containsLieAfterFirstTruth = affirmations.stream()
                .skip(1) // Skip the first affirmation
                .anyMatch(affirmation -> affirmation instanceof Lie);
        return firstIsTruth && !containsLieAfterFirstTruth ? "true" : "false";
    }
}
