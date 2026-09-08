import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        // pattern -> word
        int[] mapPattern = new int[26];

        // word -> pattern
        int[] mapWord = new int[26];

        Arrays.fill(mapPattern, -1);
        Arrays.fill(mapWord, -1);

        for (int i = 0; i < pattern.length(); i++) {
            int p = pattern.charAt(i) - 'a';
            int w = word.charAt(i) - 'a';

            // Existing mapping must be consistent
            if (mapPattern[p] != -1 && mapPattern[p] != w) {
                return false;
            }

            // Mapping must be one-to-one
            if (mapWord[w] != -1 && mapWord[w] != p) {
                return false;
            }

            mapPattern[p] = w;
            mapWord[w] = p;
        }

        return true;
    }
}
