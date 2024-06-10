import java.util.*;

class Solution {
    public static int solution(int[] numbers) {
       Set<Integer> set = new HashSet<>();
        int sum=0;

       for(int number : numbers){
           set.add(number);
       }

       for(int i=1;i<=9;i++){
           if(!set.contains(i)) sum += i;
       }

       return sum;
    }
}
