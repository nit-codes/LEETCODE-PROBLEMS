public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] vec = new int[2001];

        for (int x : arr) {
            vec[x + 1000]++;
        }

        for (int i = 0; i < 2001; i++) {
            if(vec[i] == 0) continue;

            int idx = Math.abs(vec[i]);
            
            if (vec[idx] < 0) {
                return false;
            }

            vec[idx] = -1;
        }

        return true;
    }
}
