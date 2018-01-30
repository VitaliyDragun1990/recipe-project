package guru.springframework.domain;

/**
 * Created by jt on 6/13/17.
 */
public enum Difficulty {

    EASY("Easy"), MODERATE("Moderate"), KIND_OF_HARD("Kind of hard"), HARD("Hard");

    private final String textValue;

    Difficulty(String textValue) {
        this.textValue = textValue;
    }


    public static Difficulty[] getValues() {
        return Difficulty.values();
    }

    public String toString() {
        return textValue;
    }
}
