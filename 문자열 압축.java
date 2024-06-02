import java.util.*;

class Solution {
    // 설정된 길이만큼 문자열 토큰 생성
    private List<String> split(String source, int length){
        List<String> tokens = new ArrayList<>();
        
        // abababac, 2 -> "ab","ab","ab","ac"
        for(int startIndex = 0; startIndex < source.length(); startIndex+= length){
            int endIndex = startIndex + length;
            // 문자열 범위 밖
            if(endIndex >  source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex,endIndex));
        }

        return tokens;
    }

    private int compress(String source, int length){
        StringBuilder builder = new StringBuilder();

        String last = "";
        int count = 0;
        for(String token : split(source,length)){
            if(token.equals(last)){
                count++;
            }else{
                // 토큰 문자열 2개 이상일때 문자열 포함
                if(count > 1) builder.append(count);
                builder.append(last);
                // 직전에 등장한 문자열
                last = token;
                count = 1;
            }
        }
        if(count > 1) builder.append(count);
        builder.append(last);

        return builder.length();
    }

    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int length = 1; length <= s.length(); length++){
            int compressed = compress(s,length);
            if(compressed < min){
                min=compressed;
            }
        }
        return min;
    }
}
