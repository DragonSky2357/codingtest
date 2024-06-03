class Solution {
   public String solution(String newId){
       newId = newId.toLowerCase();
       // 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 문자들, 특정 문자 제외[^a]패턴 사용
       // escape sequence로 인해 백슬래시2번 사용
       newId = newId.replaceAll("[^a-z0-9\\-_.]","");
       // 연속된 마침표를 하나로 치환(+는 1회 이상)
       newId = newId.replaceAll("\\.+",".");
       // 처음이나 끝에 등장하는 마침표 제거,^는 처음, $는 끝
       newId = newId.replaceAll("^\\.+|\\.+$","");
       if(newId.isEmpty()) newId = "a";
       if(newId.length()>=16){
           newId = newId.substring(0,15);
           newId = newId.replaceAll("\\.+$","");
       }
       while(newId.length() < 3){
           newId += newId.charAt(newId.length() - 1);
       }

       return newId;
   }
}
