package elementary.Models;

import java.util.Random;

public class RandomCharacters {
    private final char A;
    private final char B;
    private final char C;
    private final char D;
    private final char uppercaseParent;
    private final Random randomChar = new Random();

    private final static char EMPTY = ' ';

    private final static int LOWER_LOW = 97;
    private final static int LOWER_HIGH = 122;

    public RandomCharacters() {
        A = findRandomChildCharacter(EMPTY, EMPTY, EMPTY);
        B = findRandomChildCharacter(A, EMPTY, EMPTY);
        C = findRandomChildCharacter(A, B, EMPTY);
        D = findRandomChildCharacter(A, B, C);
        uppercaseParent = matchParentCharacter();
    }

    /**
     * Finds a unique random character given multiple characters or empty char.
     * @param first : char
     * @param second : char
     * @param third : char
     * @return char
     */
    private char findRandomChildCharacter(char first, char second, char third) {
        char primary;
        do {
            primary = (char) ((char) randomChar.nextInt(LOWER_HIGH -
                    LOWER_LOW) + LOWER_LOW + 1);
        } while ( primary == first || primary == second || primary == third
                || primary == EMPTY);
        return primary;
    }

    /**
     * Picks a random number between 1 - 4 representing A, B, C, D respectively.
     * Based on which letter is selected, the uppercase parent is initialized to
     * the same value as the chosen character.
     */
    private char matchParentCharacter() {
        Random randomChar = new Random();
        int chosen = randomChar.nextInt(5 - 1) + 1;
        char parent = ' ';
        switch ( chosen ) {
            case 1:
                parent = A;
                break;
            case 2:
                parent = B;
                break;
            case 3:
                parent = C;
                break;
            default:
                parent = D;
                break;
        }
        return String.valueOf(parent).toUpperCase().charAt(0);
    }

    /**
     * Get A character.
     * @return char
     */
    public char getA() { return this.A; }

    /**
     * Get B character.
     * @return char
     */
    public char getB() { return this.B; }

    /**
     * Get C character
     * @return char
     */
    public char getC() { return this.C; }

    /**
     * Get D character
     * @return char
     */
    public char getD() { return this.D; }

    /**
     * Get random uppercase Character
     * @return char
     */
    public char getUppercase() { return this.uppercaseParent; }
}

