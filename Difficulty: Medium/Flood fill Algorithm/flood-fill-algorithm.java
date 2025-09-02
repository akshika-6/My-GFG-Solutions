class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
int oldColor = image[sr][sc];
        if (oldColor == newColor) return image; // avoid infinite loop

        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        // boundary + color check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length 
            || image[r][c] != oldColor) {
            return;
        }

        // fill current pixel
        image[r][c] = newColor;

        // explore 4 directions
        dfs(image, r + 1, c, oldColor, newColor); // down
        dfs(image, r - 1, c, oldColor, newColor); // up
        dfs(image, r, c + 1, oldColor, newColor); // right
        dfs(image, r, c - 1, oldColor, newColor); // left
    }
}