package affirmation;

import andy.dev.labs.affirmation.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AffirmationTest {

    @Test
    void lou_est_pauvre_et_genereux(){
        List<Affirmation> aff = List.of(
                new Truth("Lou est pauvre"),
                new Lie("Lou est genereux"));
        String result = AffirmationChecker.et(aff);
        assertEquals("false", result);
    }

    @Test
    void lou_est_beau_donc_lou_est_pauvre(){
        List<Affirmation> aff = List.of(
                new Truth("Lou est beau"),
                new Truth("Lou est riche"));
        assertEquals("true", AffirmationChecker.donc(aff));
    }

    @Test
    void lou_est_pauvre_ou_lou_est_genereux(){
        List<Affirmation> aff = List.of(
                new Lie("Lou est pauvre"),
                new Truth("Lou est beau"));
        assertEquals("true", AffirmationChecker.ou(aff));
    }

}