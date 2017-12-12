import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordCalculatorTest {

    @Test
    public void readFile() {
        String fileName = "resources/input.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            long correct = stream.map((String line) -> {
                String[] lineWords = line.trim().split("\\s\\s*");
                return isValid(lineWords);
            }).filter(b -> b).count();

            System.out.println(correct);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean isValid(String[] lineWords) {
        //System.out.println("*******"+lineWords.length);
        Optional<Boolean> result = Arrays.stream(lineWords)
                //.peek(w-> System.out.println("["+w+"]"))
                .map(s -> {
                    List<String> words = new ArrayList<>();
                    words.addAll(Arrays.asList(lineWords));
                    words.remove(s);


                    return isAnagram(s, words);
                }).filter(b -> b).findFirst();
        return !result.isPresent();
    }

    private boolean isAnagram(String s, List<String> words) {
        return words.stream().anyMatch(word -> isAnagramWith(s, word));

    }

    public static boolean isAnagramWith(String s, String word) {


        char[] c1 = s.trim().toCharArray();
        char[] c2 = word.trim().toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        if (Arrays.equals(c1, c2)) {
            System.out.println("comparing: [" + s + "] <-> [" + word + "] anagram==>" + Arrays.equals(c1, c2) + "  " + Arrays.toString(c1) + "<-->" + Arrays.toString(c2));
        }

        return Arrays.equals(c1, c2);
    }


      /*
    abcde fghij is a valid passphrase.
    abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
    a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
    iiii oiii ooii oooi oooo is valid.
    oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
    */

    @Test
    public void anagramTestWithLists() {

        assertTrue(isValid(new String[]{"abcde", "fghij"}));
        assertFalse(isValid(new String[]{"abcde", "xyz", "ecdab"}));
        assertTrue(isValid(new String[]{"a", "ab", "abc", "abd", "abf", "abj"}));
        assertTrue(isValid(new String[]{"iiii", "oiii", "ooii", "oooi", "oooo"}));
        assertFalse(isValid(new String[]{"oiii", "ioii", "iioi", "iiio"}));
        assertTrue(isValid(new String[]{"aaaab", "bbbba"}));
    }


    @Test
    public void anagramTest() {
        assertFalse(isAnagramWith("abcd", "fghij"));
        assertTrue(isAnagramWith("abcde", "ecdab"));
        assertTrue(isAnagramWith("oiii", "ioii"));
        assertFalse(isAnagramWith("aaaab", "bbbba"));
    }
}