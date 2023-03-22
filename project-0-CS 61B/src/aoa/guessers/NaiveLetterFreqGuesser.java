package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NaiveLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public NaiveLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Makes a guess which ignores the given pattern. */
    public char getGuess(String pattern, List<Character> guesses) {
        return getGuess(guesses);
    }

    /** Returns a map from a given letter to its frequency across all words.
     *  This task is similar to something you did in hw0b! */
    public Map<Character, Integer> getFrequencyMap() {
       Map<Character,Integer> tempMap = new TreeMap<>();
       for(String word : words){
           for(char ch : word.toCharArray()){
               if(tempMap.get(ch) == null){
                   tempMap.put(ch,1);
               }else{
                   tempMap.put(ch,tempMap.get(ch)+1);
               }
           }
       }

        return tempMap;
    }

    /** Returns the most common letter in WORDS that has not yet been guessed
     *  (and therefore isn't present in GUESSES). */
    public char getGuess(List<Character> guesses) {
        Map<Character,Integer> integerMap = getFrequencyMap();
        char mostFreq = '0';
        int maxFreq = -1;
        for(char ch : integerMap.keySet()){

            if(integerMap.get(ch)>maxFreq && !guesses.contains(ch)){
                mostFreq = ch;
                maxFreq = integerMap.get(ch);
            }
        }
        return mostFreq;
    }

    public static void main(String[] args) {
        NaiveLetterFreqGuesser nlfg = new NaiveLetterFreqGuesser("data/example.txt");
        System.out.println("list of words: " + nlfg.words);
        System.out.println("frequency map: " + nlfg.getFrequencyMap());

        List<Character> guesses = List.of('f', 'g','o','a','e');
        System.out.println("guess: " + nlfg.getGuess(guesses));
    }
}
