package leetcode;

public class AdjacentDuplicateCharacters {
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; j++, i++) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }

    public static void main(String[] args) {
        AdjacentDuplicateCharacters adjacentDuplicateCharacters = new AdjacentDuplicateCharacters();
        System.out.println(adjacentDuplicateCharacters.removeDuplicates("abbaca"));
    }
}
