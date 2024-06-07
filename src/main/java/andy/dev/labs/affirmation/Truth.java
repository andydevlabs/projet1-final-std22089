package andy.dev.labs.affirmation;

public class Truth extends Affirmation {

    public Truth(String affirmationInput) {
        super(affirmationInput);
    }

    @Override
    public String isTrue() {
        return "true";
    }
}
