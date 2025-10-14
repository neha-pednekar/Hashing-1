// Time Complexity : O(n) where n is the length of each string.
// Space Complexity : O(1) as the space used by sMap and tMap will be at most 26 chars which is equivalent to a constant space usage

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Isomorphic Strings
 */

/*
 * Approach: Two Maps
 * In this approach, we use two maps to store the mappings from s to t and t to s. 
 * If the mappings already exist and the current mapping has a character mismatch we return false. 
 * We need to validate both the maps for the above condition. If we reach towards the end of the code, it simply means
 * that the mappings are 1:1 and there are no clashes. We can return true in that case.
 */

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_usingTwoMaps {
    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl != tl) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i=0; i<sl; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // check sMap for mapping s to t
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }   
            } else {
                sMap.put(sChar, tChar);
            }

            // check tMap for mapping t to s
            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar) != sChar) {
                    return false;
                }   
            } else {
                tMap.put(tChar, sChar);
            }
        }

        return true;
    }
    
    // Driver code
    public static void main(String[] args) {
        IsomorphicStrings_usingTwoMaps isomorphicStrings_usingTwoMaps = new IsomorphicStrings_usingTwoMaps();
        System.out.println(isomorphicStrings_usingTwoMaps.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings_usingTwoMaps.isIsomorphic("foo", "bar"));
    }
}
