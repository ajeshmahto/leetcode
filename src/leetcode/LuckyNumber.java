package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumber {
    public static void main(String[] args) {
        LuckyNumber luckyNumber = new LuckyNumber();
        luckyNumber.luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}});
    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] mi = new int[m], mx = new int[n];
        Arrays.fill(mi, Integer.MAX_VALUE);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mi[i] = Math.min(matrix[i][j], mi[i]);
                mx[j] = Math.max(matrix[i][j], mx[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (mi[i] == mx[j])
                    res.add(mi[i]);
        return res;
    }
}
