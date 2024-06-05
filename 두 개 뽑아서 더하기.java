import java.util.*;

class Solution {
    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        return set.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }
}
