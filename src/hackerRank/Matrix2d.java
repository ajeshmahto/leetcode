package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class Matrix2d {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int rowLength = 6;
        int colLength = 6;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rowLength; i++) {
            int sum = 0;
            for (int j = 0; j < colLength; j++) {
                boolean validRow = i + 1 < rowLength && i - 1 > 0;
                boolean validCol = j + 1 < colLength && j - 1 > 0;

                if (validRow && validCol) {
                    sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i-1][j+1] + arr[i][j] + arr[i + 1][j-1] +
                          arr[i + 1][j] + arr[i+1][j+1];
                }

                if (maxSum < sum) {
                    maxSum = sum;
                }
            }


        }

        return maxSum;

    }

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = {{1,1,1,0,0,0}, {0,1,0,0,0,0}, {1,1,1,0,0,0}, {0,0,2,4,4,0}, {0,0,0,2,0,0}, {0,0,1,2,4,0}};

        /*for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
        System.out.println(hourglassSum(arr));

    }


}
