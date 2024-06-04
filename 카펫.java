class Solution {
    public int[] solution(int brown, int yellow) {
        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
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
