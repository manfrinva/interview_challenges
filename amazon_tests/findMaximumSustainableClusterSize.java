import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findMaximumSustainableClusterSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY processingPower
     *  2. INTEGER_ARRAY bootingPower
     *  3. LONG_INTEGER powerMax
     */

    public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
    if(processingPower == null || bootingPower == null
        || processingPower.size() ==0 || processingPower.size() !=bootingPower.size()){
            return 0;
    }
    else{
            PriorityQueue<Integer> maximumBootingPower = new PriorityQueue<>((a,b) ->Integer.compare(b, a));
            int maxSustainableClusterSize = 0;
            int specificSize = 1;
            int first = 0;
            int last = 0;
            
            int sumOfProssessingPower = processingPower.size();
            maximumBootingPower.add(bootingPower.get(0));
            
            while(last< processingPower.size()){
                int specificBootingPower = maximumBootingPower.peek();
                int netPowerConsumption = (
                    specificBootingPower + sumOfProssessingPower * specificSize
                );
                
                if(netPowerConsumption <= powerMax){
                    maxSustainableClusterSize = specificSize;
                    last++;
                    specificSize++;                    
                }
                else{
                    sumOfProssessingPower -= processingPower.get(first);
                    maximumBootingPower.remove(bootingPower.get(first));
                    first ++;
                    last ++;
                }
                if(last < processingPower.size()){
                    maximumBootingPower.add(bootingPower.get(last));
                    sumOfProssessingPower +=  processingPower.get(last);
                }
            }
            return maxSustainableClusterSize;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int processingPowerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> processingPower = IntStream.range(0, processingPowerCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int bootingPowerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> bootingPower = IntStream.range(0, bootingPowerCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long powerMax = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.findMaximumSustainableClusterSize(processingPower, bootingPower, powerMax);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
