package andy.dev.labs.affirmation;

public class BasicAffirmation extends Affirmation{

    public BasicAffirmation(String affirmationInput) {
        super(affirmationInput);
    }


    @Override
    public String isTrue() {
        return "idontknow";
    }
}
