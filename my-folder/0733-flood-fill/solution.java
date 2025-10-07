class Solution {
    private class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int original = image[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sr, sc));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                image[curr.row][curr.col] = color;
                if(curr.row > 0 && image[curr.row-1][curr.col] == original) 
                    queue.offer(new Pair(curr.row-1, curr.col));
                if(curr.row < image.length-1 && image[curr.row+1][curr.col] == original) 
                    queue.offer(new Pair(curr.row+1, curr.col));
                if(curr.col > 0 && image[curr.row][curr.col-1] == original) 
                    queue.offer(new Pair(curr.row, curr.col-1));
                if(curr.col < image[curr.row].length-1 && image[curr.row][curr.col+1] == original) 
                    queue.offer(new Pair(curr.row, curr.col+1));
            }
        }
        return image;
    }
}
