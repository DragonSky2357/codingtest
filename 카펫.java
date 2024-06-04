class Solution {
    public int[] solution(int brown, int yellow) {
        // 갈색 격자 갯수가 5000개 이하 및 세로 길이는 3이상
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                // 갈색 격자 갯수(가로 길이에서 세로 2칸식 제거)
                int boundary = (width + height - 2) * 2;
                int cneter = width * height - boundary;

                if (brown == boundary && yellow == cneter) {
                    return new int[]{width, height};
                }
            }
        }
        return null;
    }
}
