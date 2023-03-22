package aoa.guessers;

import aoa.utils.FileUtils;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PatternAwareLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PatternAwareLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    public Map<Character,Integer> getFreqMapMatchesPattern(String pattern){
        Map<Character,Integer> map = new TreeMap<>();
        for(String word : words){
            if(matchesPattern(word,pattern)) {
                for (char ch : word.toCharArray()) {
                    if (map.get(ch) == null) {
                        map.put(ch, 1);
                    } else {
                        map.put(ch, map.get(ch) + 1);
                    }
                }
            }
        }

        return map;
    }

    public boolean matchesPattern(String word,String pattern){
        if(pattern.length()!=word.length())
            return false;
        for(int i=0;i<word.length();i++){
            if(pattern.charAt(i) != '-') {
                if (word.charAt(i) != pattern.charAt(i))
                    return false;
            }
        }
        return true;
    }


    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN. */
    public char getGuess(String pattern, List<Character> guesses) {
        Map<Character,Integer> integerMap = getFreqMapMatchesPattern(pattern);
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
        PatternAwareLetterFreqGuesser palfg = new PatternAwareLetterFreqGuesser("data/example.txt");
        System.out.println(palfg.getGuess("----", List.of('e')));
    }
}