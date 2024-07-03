package dsa.Strings;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpSubstringSearch {

    private static final int PRIME = 101;

    public static List<Integer> search(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        
        int textLength = text.length();
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));
        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && text.substring(i, i + patternLength).equals(pattern)) {
                occurrences.add(i);
            }
            
            if (i < textLength - patternLength) {
                textHash = recalculateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }

        return occurrences;
    }

    private static long calculateHash(String str) {
        long hashValue = 0;
        for (int i = 0; i < str.length(); i++) {
            hashValue += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hashValue;
    }

    private static long recalculateHash(long oldHash, char oldChar, char newChar, int patternLength) {
        long newHash = oldHash - oldChar;
        newHash /= PRIME;
        newHash += newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);

        List<Integer> occurrences = search(text, pattern);

        if (occurrences.isEmpty()) {
            System.out.println("Pattern not found in the text.");
        } else {
            System.out.print("Pattern found at indices: ");
            for (int index : occurrences) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }
}
