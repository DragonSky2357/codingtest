class Solution {
    public String solution(String myString){
        Set<Character> set = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        for(char c : myString.toCharArray()){
            if(set.contains(c)) continue;
            set.add(c);
            sb.append(c);
        }

        return sb.toString();
    }
}
