// Time Complexity : O(n * k) where n is the number of words in the input array and k is the length of each word.
// Space Complexity : O(n * k) as we need to store all words in the input inside the map as sorted key with values.

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Group Anagrams
 */

/*
 * Approach: Using Hashing(optimized approach to remove sorting)
 * In this approach, we iterate through all input strings, instead of sorting we now create a hash of the word
 * using the prime product and add it as a hashed key into the hashmap and the corresponding string as the value in the value list. 
 * If a string is an anagram of a previous stored value, we will use the hashing function again to generate a hash of the 
 * the new work again to check if the key exists in the hashmap and retrieve the list in which we will be 
 * adding this newly encountered anagram. When hashed values are equal it would mean two words are anagram of each other.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_usingHashing {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<BigInteger, List<String>> map = new HashMap<>();
        for (String str : strs) {
            BigInteger primeProduct = primeProduct(str);
            if (!map.containsKey(primeProduct)) {
                map.put(primeProduct, new ArrayList<>());
            }
            map.get(primeProduct).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private BigInteger primeProduct(String s) {
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        BigInteger result = BigInteger.ONE;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            result = result.multiply(BigInteger.valueOf(prime[ch - 'a']));
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams_usingHashing groupAnagrams_usingHashing = new GroupAnagrams_usingHashing();
        System.out.println(groupAnagrams_usingHashing.groupAnagrams(strs));
    }
}
