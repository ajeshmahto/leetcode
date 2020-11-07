package hackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ArraySequence {
}



 class Solution {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> result = new ArrayList();
        int lastAnswer = 0;
        Object[] seqList = new Object[n];

        for(List<Integer> query: queries){
            int queryType = query.get(0);
            int seqIndex = 0;
            Object seq;
            if(queryType == 1){
                seqIndex = (query.get(1) ^ lastAnswer) % n;
                seq = seqList[seqIndex];
                if(seq==null){
                    List<Integer> list = new ArrayList();
                    list.add(query.get(2));
                    seqList[seqIndex] = list;
                }
                else {
                    List<Integer> list = (List<Integer>)seq;
                    list.add(query.get(2));
                }
            }

            if(queryType == 2){
                seqIndex = (query.get(1) ^ lastAnswer) % n;
                seq = seqList[seqIndex];
                List<Integer> list = (List<Integer>)seq;
                lastAnswer = list.get(query.get(2) % list.size());
                result.add(lastAnswer);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
