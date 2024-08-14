/*You are given an m x n binary grid grid where 1 represents land and 0 represents water. An island is a maximal 4-directionally (horizontal or vertical) connected group of 1's.
The grid is said to be connected if we have exactly one island, otherwise is said disconnected.
In one day, we are allowed to change any single land cell (1) into a water cell (0).
Return the minimum number of days to disconnect the grid.*/

class Solution {
    int time; //  //time: This is used to keep track of the discovery time of each cell in the grid during DFS traversal.
    int[][] vis; //vis: This 2D array stores the discovery time of each cell.
    int[][] low; //low: This 2D array stores the lowest discovery time reachable from a cell.
    int[] d=new int[]{0,1,0,-1,0}; //d: This array helps in navigating the four possible directions (right, down, left, up) in the grid.
    boolean arti; //arti: A boolean flag to check if an articulation point is found.
    public int minDays(int[][] grid) {
      //n and m are the dimensions of the grid.
        int n=grid.length;
        int m=grid[0].length;
        arti=false; //arti is set to false initially. It will be set to true if an articulation point is found.
      //vis and low arrays are initialized to store the discovery and lowest reachable times.
        vis=new int[n][m];
        low=new int[n][m];
        time=1; //time is initialized to 1 and is used as a timestamp during DFS.
        boolean hasArt=false;
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                  //When a cell with value 1 is found, if it’s not the first one (found is true), 
                  //the function returns 0 indicating that removing a single cell cannot disconnect the grid. Otherwise, call art method to start DFS from that cell.
                    if(found) 
                        return 0;
                    found=true;
                    art(i,j,grid,-100,-100);
                }
            }
        }

        if(time==1) 
            return 0; //0: If no cells are found (time remains 1).

        if(time==2)
            return 1; //1: If removing a single cell can disconnect the grid or if the time is 2.
        if(arti)
            return 1;
        else
            return 2; //2: If no articulation points are found and the grid is connected in such a way that more than one cell removal is required.
    }

    public void art(int row,int col,int[][] grid , int parRow,int parCol){
        grid[row][col]=0;
        vis[row][col]=time;
        low[row][col]=time;
        time++;
        int child=0;
        for(int i=0;i<4;i++){
            int x=d[i]+row;
            int y=d[i+1]+col;
//If an adjacent cell is not visited, it’s a child node, increment child and recursively call art on it.
//Update the low value based on the subtree rooted at this child.
//Check if the current cell is an articulation point: If the lowest reachable time of the adjacent cell is greater than or equal to the discovery time of the current cell.
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || (x==parRow && y==parCol) || (vis[x][y]==0 && grid[x][y]==0))
                continue;
            if(vis[x][y]==0){
                child++;
                art(x,y,grid,row,col);
                low[row][col]=Math.min(low[row][col],low[x][y]);
                if(low[x][y]>=vis[row][col] && (parRow!=-100 && parCol!=-100))
                    arti=true;
            }else{
                low[row][col]=Math.min(low[row][col],vis[x][y]);
            }
        }
//Special Case: If the current cell is the root and has more than one child, it’s an articulation point.
        if(parRow==-100 && parCol==-100 && child>1)
            arti=true;
    }
}
