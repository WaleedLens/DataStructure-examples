package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PAGALetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PAGALetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
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
    public boolean isExist(String word,String pattern,List<Character> guesses){

        pattern = pattern.replaceAll("-","");
        boolean tmp = true;
        for(char c : guesses){
            if(pattern.indexOf(c) == -1 && word.indexOf(c) != -1){
                tmp = false;
            }

        }
        return tmp;
    }

    public Map<Character,Integer> getFreqOfExistWords(String pattern,List<Character> guesses){
        Map<Character,Integer> map = new TreeMap<>();

        for(String word : words){

            if(matchesPattern(word,pattern) && isExist(word,pattern,guesses)) {
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


    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN and the GUESSES that have been made. */
    public char getGuess(String pattern, List<Character> guesses) {
        Map<Character,Integer> integerMap = getFreqOfExistWords(pattern,guesses);
        System.out.println(integerMap);
        char mostFreq = '0';
        int maxFreq = -1;
        for(char ch : integerMap.keySet()){

            if((integerMap.get(ch)>maxFreq) && !guesses.contains(ch)){

                mostFreq = ch;
                maxFreq = integerMap.get(ch);
            }
        }


        return mostFreq;
    }



    public static void main(String[] args) {
        PAGALetterFreqGuesser pagalfg = new PAGALetterFreqGuesser("data/example.txt");
        System.out.println(pagalfg.getGuess("-o--", List.of('o')));
    }
}
