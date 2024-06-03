import java.util.*;

class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();

    private void generate(String word,List<String> words){
        words.add(word);

        if(word.length()==5) return;

        for(char c : CHARS){
            generate(word + c, words);
        }
    }

    public int solution(String word){
        List<String> words = new ArrayList<>();
        generate("",words);
        // 리스트에서 몇 번째 인지 체킹
        return words.indexOf(word);
    }
}

