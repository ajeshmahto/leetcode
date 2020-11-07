package leetcode;

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {

            int i = 0;
        System.out.println(i--);

    }
}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word: wordDict){
            s = s.replaceAll(word, "");
        }

        if(s.length() == 0){
            return true;
        }
        return false;
    }
}