class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    count++;
                    dfs(grid,visited,i,j,n,m);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,boolean[][] visited, int r,int c,int n,int m){
        if(r < 0 || r >= n || c<0 || c >=m || grid[r][c] != 'L' || visited[r][c]){
            return;
        }
        visited[r][c] = true;
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        for(int k=0;k<8;k++){
            dfs(grid,visited,r+dr[k],c+dc[k],n,m);
        }
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         int n = grid.length, m = grid[0].length;
//         boolean[][] visited = new boolean[n][m];
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 'L' && !visited[i][j]) {
//                     // found a new island
//                     count++;
//                     dfs(grid, visited, i, j, n, m);
//                 }
//             }
//         }
//         return count;
//     }

//     private void dfs(char[][] grid, boolean[][] visited, int r, int c, int n, int m) {
//         // boundary + visited + water check
//         if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != 'L' || visited[r][c]) {
//             return;
//         }

//         visited[r][c] = true;

//         // explore all 8 directions
//         int[] dr = {-1,-1,-1,0,0,1,1,1};
//         int[] dc = {-1,0,1,-1,1,-1,0,1};

//         for (int k = 0; k < 8; k++) {
//             dfs(grid, visited, r + dr[k], c + dc[k], n, m);
//         }
//     }
// }