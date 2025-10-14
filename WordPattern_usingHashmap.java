// Time Complexity : O(n + m) where n is the length of the pattern and m is the length of s.
// Space Complexity : O(m) where m is the length of s(number of words in a string). 

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Word Pattern
 */

/*
 * Approach: Using HashMap
 * In this approach, we use a hashmap to check if each character in a pattern is mapped to a word and each word is mapped to the same character in a 
 * pattern. We can achieve this by using single generic hashmap. We can also use two hashmaps if we want to keep things separated out.
 * Inside the map, we put every char in a pattern if it does not exist and its corresponding index and we also add the 
 * word to the map with the same corresponding index. When a new pair comes in, we check if both the keys exist in the hashmap
 * and if they do not map, it means that they were already mapped to some other index and there is a mismatch. We return false
 * if there is a mismatch. If we successfully, reach towards the end of the code, it means words in a sentence match the given pattern.
 */

import java.util.HashMap;

public class WordPattern_usingHashmap {
    public boolean wordPattern(String pattern, String s) {
        HashMap map = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        for (Integer i=0; i<words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }

            if (!map.containsKey(word)) {
                map.put(word, i);
            }

            if (map.get(ch) != map.get(word)) {
                return false;
            }
        }

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        String s2 = "dog cat cat fish";
        String pattern2 = "aaaa";

        WordPattern_usingHashmap wordPattern_usingHashmap = new WordPattern_usingHashmap();

        boolean result1 = wordPattern_usingHashmap.wordPattern(pattern1, s1);
        System.out.println("Result 1: " + result1);

        boolean result2 = wordPattern_usingHashmap.wordPattern(pattern1, s2);
        System.out.println("Result 2: " + result2);

        boolean result3 = wordPattern_usingHashmap.wordPattern(pattern2, s1);
        System.out.println("Result 3: " + result3);
    }   
}
