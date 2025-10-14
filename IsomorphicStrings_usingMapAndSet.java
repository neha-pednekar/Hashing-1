// Time Complexity : O(n) where n is the length of each string.
// Space Complexity : O(1) as the space used by sMap and tSet will be at most 26 chars which is equivalent to a constant space usage

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Isomorphic Strings
 */

/*
 * Approach: One hashmap and one hashset.
 * In this approach, we use one map and one set to store the mappings from s to t and t to s. 
 * If the mappings already exist and the current mapping has a character mismatch we return false. 
 * We need to validate both the map and set for the above condition. If we reach towards the end of the code, it simply means
 * that the mappings are 1:1 and there are no clashes. We can return true in that case.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings_usingMapAndSet {
    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl != tl) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Set<Character> tSet = new HashSet<>();

        for (int i=0; i<sl; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // check sMap for mapping s to t
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (tSet.contains(tChar)) {
                    return false;
                }

                sMap.put(sChar, tChar);
                tSet.add(tChar);
            }
        }

        return true;
    }
    
    // Driver code
    public static void main(String[] args) {
        IsomorphicStrings_usingMapAndSet isoStrings_usingMapAndSet = new IsomorphicStrings_usingMapAndSet();
        System.out.println(isoStrings_usingMapAndSet.isIsomorphic("egg", "add"));
        System.out.println(isoStrings_usingMapAndSet.isIsomorphic("foo", "bar"));
    }
}
