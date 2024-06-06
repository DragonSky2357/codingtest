import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    // 양수가 반환되면 s1이 s2보다 크다는 의미 s1이 더 뒤로 정렬
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }
}
