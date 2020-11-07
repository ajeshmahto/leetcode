package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividing {

    public static void main(String[] args) {
        SelfDividing selfDividing = new SelfDividing();

        System.out.println(selfDividing.selfDividingNumbers(1, 22));
    }
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList();
        for(int i = left; i<=right; i++) {
            if(isSelfDivide(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isSelfDivide(int num) {
        if(num<10) return true;

        int orgNumber = num;

        while(num>0) {
            int reminder = num % 10;
            if(reminder == 0) {
                return false;
            } else if(orgNumber % reminder !=0){
                return false;
            }
            num = num/10;
        }
        return true;
    }
}
