class Solution {
    public void createGraph(int[][] mat, int[][] edges, int n){
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j) mat[i][j] = (int)1e9;
            }
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            mat[u][v] = w;
            mat[v][u] = w;
        }
    }
    public int findTheCity(int n, int[][] edges, int threshold) {
        int result = -1;
        int[][] mat = new int[n][n];
        createGraph(mat, edges, n);
        for(int via = 0; via < n; via++){
            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    if(row != via && col != via){
                        int newDist = mat[row][via] + mat[via][col];
                        if(newDist < mat[row][col]){
                            mat[row][col] = newDist;
                        }
                    }
                }
            }
        }

        int prevCnt = Integer.MAX_VALUE;
        for(int row = 0; row < n; row++){
            int cnt = 0;
            for(int col = 0; col < n; col++){
                if(row != col && mat[row][col] <= threshold){
                    cnt++;
                }
            }

            if(cnt <= prevCnt){
                prevCnt = cnt;
                result = row;
            }
        }
        return result;
    }
}
