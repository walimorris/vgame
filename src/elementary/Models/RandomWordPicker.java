package elementary.Models;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RandomWordPicker {
    private Map<Character, List<String>> words = new HashMap<>();
    private final Random random = new Random();

    public RandomWordPicker() {
        words.put('A', new ArrayList<>(List.of("Apple", "Art", "Ant", "About")));
        words.put('B', new ArrayList<>(List.of("Bug", "Beaver", "Bag", "")));
        words.put('C', new ArrayList<>(List.of("Cat", "Cake", "Cup")));
        words.put('D', new ArrayList<>(List.of("Dad", "Deer", "Dig")));
        words.put('E', new ArrayList<>(List.of("Eat", "Earth", "Ear")));
        words.put('F', new ArrayList<>(List.of("Friend", "Farm", "French")));
        words.put('G', new ArrayList<>(List.of("Gold", "Golf", "Gift")));
        words.put('H', new ArrayList<>(List.of("Home", "Horse", "Heavy")));
        words.put('I', new ArrayList<>(List.of("Igloo", "Ice", "Idea")));
        words.put('J', new ArrayList<>(List.of("Jump", "Jar", "Jam")));
        words.put('K', new ArrayList<>(List.of("Karate", "Kick", "King")));
        words.put('L', new ArrayList<>(List.of("Laptop", "Lady", "Listen")));
        words.put('M', new ArrayList<>(List.of("Mom", "Monday", "Magnetic")));
        words.put('N', new ArrayList<>(List.of("Nature", "Nurse", "Noble")));
        words.put('O', new ArrayList<>(List.of("Officer", "Oak", "Observe")));
        words.put('P', new ArrayList<>(List.of("Person", "Pie", "Paper")));
        words.put('Q', new ArrayList<>(List.of("Queen", "Quote", "Quart")));
        words.put('R', new ArrayList<>(List.of("Racecar", "Rabbit", "Ribbon")));
        words.put('S', new ArrayList<>(List.of("Sun", "Soup", "Save")));
        words.put('T', new ArrayList<>(List.of("Thankyou", "Tab", "Treasure")));
        words.put('U', new ArrayList<>(List.of("Umbrella", "Universe", "Useful")));
        words.put('V', new ArrayList<>(List.of("Valid", "Valor", "Value")));
        words.put('W', new ArrayList<>(List.of("Wind", "Water", "Winner")));
        words.put('X', new ArrayList<>(List.of("X-ray", "Xenas", "Xylographic")));
        words.put('Y', new ArrayList<>(List.of("Yellow", "Yesterday", "Yourself")));
        words.put('Z', new ArrayList<>(List.of("Zebra", "Zealous", "Zig-Zag")));
    }

    /**
     * Returns a random word from words Map based on the size of ArrayList value.
     * @param c : The character search in words map.
     * @return : {@link String} word
     */
    public String getRandomWord(char c) {
        for ( char letter : words.keySet() ) {
            if (letter == c) {
                int size = words.get(letter).size();
                int index = random.nextInt(size);
                return words.get(letter).get(index);
            }
        }
        return null;
    }

}
