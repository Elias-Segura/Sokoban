/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Elias Segura
 */

  
public class ShortestPath
{ 
static int ROW = 16; 
static int COL = 22; 
static int rowNum[] = {-1, 0, 0, 1}; 
static int colNum[] = {0, -1, 1, 0}; 
    public ShortestPath() {
        
    }

public boolean isValid(int row, int col) 
{ 

    return (row >= 0) && (row < ROW) && 
           (col >= 0) && (col < COL); 
} 



  public int ShortPath(int mat[][], Point src, 
                            Point dest) 
  { 

    if (mat[src.x][src.y] != 1 ||  
        mat[dest.x][dest.y] != 1) 
        return -1; 
  
    boolean [][]visited = new boolean[ROW][COL]; 
 
    visited[src.x][src.y] = true; 

    Queue<queueNode> findPath = new LinkedList<>(); 

    queueNode startPath = new queueNode(src, 0); 
    findPath.add(startPath); 
    
    while (!findPath.isEmpty()) 
    { 
        queueNode Path = findPath.peek(); 
        Point pt = Path.pt; 
        if (pt.x == dest.x && pt.y == dest.y) 
            return Path.dist; 

        findPath.remove(); 
  
        for (int i = 0; i < 4; i++) 
        { 
            int row = pt.x + rowNum[i]; 
            int col = pt.y + colNum[i]; 

            if (isValid(row, col) && mat[row][col] == 1 && !visited[row][col]) 
            { 
                visited[row][col] = true; 
                queueNode AdjPath = new queueNode(new Point(row, col),Path.dist + 1 ); 
                findPath.add(AdjPath); 
            } 
        } 
    } 

    return -1; 
}
}
