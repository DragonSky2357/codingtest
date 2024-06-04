import java.util.*;

class Solution {
    private boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
    
    // Set을 반환하지 않고 매개변수로 전달해서 불필요한 원소 순회를 방지
    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(acc)) primes.add(acc);

        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) continue;
            // 종이를 계속 이어지면서 자릿수를 올리는 과정
            int nextAcc = acc * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }

    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }
}
