package andy.dev.labs.affirmation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Affirmation {
    protected final String affirmationInput;

    public abstract String isTrue();
}
