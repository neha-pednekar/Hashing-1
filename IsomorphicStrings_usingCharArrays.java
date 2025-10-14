// Time Complexity : O(n) where n is the length of each string.
// Space Complexity : O(1) as the space used by both arrays will be at most 26 chars which is equivalent to a constant space usage

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Isomorphic Strings
 */

/*
 * Approach: Character arrays
 * In this approach, we use characters arrays to store the mappings from s to t and t to s. 
 * If the mappings already exist and the current mapping has a character mismatch we return false. 
 * We need to validate both char arrays for the above condition. If we reach towards the end of the code, it simply means
 * that the mappings are 1:1 and there are no clashes. We can return true in that case.
 */

public class IsomorphicStrings_usingCharArrays {
    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (sl != tl) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for(int i=0; i<sl; i++) {
            char ch1 = sChars[i];
            char ch2 = tChars[i];

            if (mapS[ch1] == 0 && mapT[ch2] == 0) {
                mapS[ch1] = ch2;
                mapT[ch2] = ch1;
            } else if (mapS[ch1] != ch2 || mapT[ch2] != ch1) {
                return false;
            }
        }
        
        return true;
    }
    
    // Driver code
    public static void main(String[] args) {
        IsomorphicStrings_usingCharArrays isomorphicStrings_usingCharArrays = new IsomorphicStrings_usingCharArrays();
        System.out.println(isomorphicStrings_usingCharArrays.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings_usingCharArrays.isIsomorphic("foo", "bar"));
    }
}
