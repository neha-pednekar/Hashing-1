// Time Complexity : O(n * k log k) where n is the number of words in the input array and k is the length of each word.
// Space Complexity : O(n * k) as we need to store all words in the input inside the map as sorted key with values.

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Group Anagrams
 */

/*
 * Approach: Using Sorted Strings
 * In this approach, we iterate through all input strings, sort them and add them as a sorted key into the hashmap and the
 * corresponding string as the value in the value list. If a string is an anagram of a previous stored value, we will
 * sort the key again to check if it exists in the hashmap and use the same key to retrieve the list in which we will be 
 * adding this newly encountered anagram. 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_usingSortedStrings {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);

            String sortedKey = String.valueOf(charArr);
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }

            map.get(sortedKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    // Driver code
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams_usingSortedStrings groupAnagrams_usingSortedStrings = new GroupAnagrams_usingSortedStrings();
        System.out.println(groupAnagrams_usingSortedStrings.groupAnagrams(strs));
    }
}
