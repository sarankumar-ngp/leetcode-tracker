// Last updated: 28/07/2026, 15:43:45
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapSToT = new HashMap<>();
        HashMap<Character, Character> mapTToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check s -> t mapping
            if (mapSToT.containsKey(charS)) {
                if (mapSToT.get(charS) != charT) {
                    return false;
                }
            } else {
                mapSToT.put(charS, charT);
            }

            // Check t -> s mapping
            if (mapTToS.containsKey(charT)) {
                if (mapTToS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTToS.put(charT, charS);
            }
        }

        return true;
    }
}