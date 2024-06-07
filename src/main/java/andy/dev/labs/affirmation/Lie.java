package andy.dev.labs.affirmation;

public class Lie extends Affirmation{

    public Lie(String affirmationInput) {
        super(affirmationInput);
    }

    @Override
    public String isTrue() {
        return "false";
    }
}
