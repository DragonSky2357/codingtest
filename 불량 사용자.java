import java.util.*;

class Solution {
    private void count(int index, Set<String> banned,
                       String[][] bans, Set<Set<String>> banSet){
        // bans   : 불량 사용자 매칭 정보
        // banSet : 찾은 조합을 저장할 매개변수
        // banned : 현재까지 선택한 사용자 아이디
        if(index == bans.length){
            banSet.add(new HashSet<>(banned));
            return;
        }

        // 
        for(String id: bans[index]){
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id){
        String[][] bans = Arrays.stream(banned_id)
                // .은 정규 표현식에서 아무 문자 표현
                .map(banned -> banned.replace('*','.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        // 각각의 ban에 해당하는 문자열
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0,new HashSet<>(),bans,banSet);
        return banSet.size();
    }
}
