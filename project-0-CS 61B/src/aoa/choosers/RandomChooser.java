package aoa.choosers;

import aoa.utils.FileUtils;
import edu.princeton.cs.algs4.StdRandom;

import java.util.List;

public class RandomChooser implements Chooser {
    private final String chosenWord;
    private String pattern;

    public RandomChooser(int wordLength, String dictionaryFile) {
        if (wordLength < 1)
            throw new IllegalArgumentException();
        List<String> words = FileUtils.readWordsOfLength(dictionaryFile, wordLength);
        int totalWords = words.size();
        if (totalWords == 0)
            throw new IllegalStateException();
        pattern = "";
        for (int i = 0; i < wordLength; i++) {
            pattern = pattern + "-";
        }
        int randomlyChosenWordNumber = StdRandom.uniform(totalWords);

        chosenWord = words.get(randomlyChosenWordNumber);


    }

    @Override
    public int makeGuess(char letter) {
        int occurrences = 0;
        int index = 0;

        for (char ch : chosenWord.toCharArray()) {
            if (letter == ch) {
                occurrences = occurrences + 1;
                pattern = pattern.substring(0, index) + ch + pattern.substring(index + 1, pattern.length());
            }
            index++;
        }
        return occurrences;
    }

    @Override
    public String getPattern() {

        return pattern;
    }

    @Override
    public String getWord() {
        return chosenWord;
    }
}
